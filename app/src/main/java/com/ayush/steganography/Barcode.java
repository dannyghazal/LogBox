package com.ayush.steganography;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ayush.imagesteganographylibrary.Text.AsyncTaskCallback.TextEncodingCallback;
import com.ayush.imagesteganographylibrary.Text.ImageSteganography;
import com.ayush.imagesteganographylibrary.Text.TextEncoding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Barcode extends AppCompatActivity implements TextBarcodeCallback {
    //barcode class that will be include variables and functions for the barcode page

    private static final String TAG = "Barcode Class";
    private static final int SELECT_PICTURE = 100;
    //Created variables for UI
    private TextView whether_encoded;
    private ImageView imageView;
    private EditText generate_barcode;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barcode);

        //Instantiation of UI components
        //whether_encoded = findViewById(R.id.whether_encoded);

        imageView = findViewById(R.id.imageview);
       // generate_barcode = findViewById(R.id.barcode);

        Button choose_image_button = findViewById(R.id.choose_image_button);

        //Choose Image Button
        choose_image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ImageChooser();
            }
        });

    }
    public static class FileToHex {

        private static final String NEW_LINE = System.lineSeparator();
        private static final String UNKNOWN_CHARACTER = ".";

        @TargetApi(Build.VERSION_CODES.O)
        public static void main(String[] args) throws IOException {

            String file = "/path/to/text.txt";

            String s = convertFileToHex(Paths.get(file));
            System.out.println(s);
        }

        @TargetApi(Build.VERSION_CODES.O)
        public static String convertFileToHex(Path path) throws IOException {

            if (Files.notExists(path)) {
                throw new IllegalArgumentException("File not found! " + path);
            }

            StringBuilder result = new StringBuilder();
            StringBuilder hex = new StringBuilder();
            StringBuilder input = new StringBuilder();

            int count = 0;
            int value;

            // path to inputstream....
            try (InputStream inputStream = Files.newInputStream(path)) {

                while ((value = inputStream.read()) != -1) {

                    hex.append(String.format("%02X ", value));

                    //If the character is unable to convert, just prints a dot "."
                    if (!Character.isISOControl(value)) {
                        input.append((char) value);
                    } else {
                        input.append(UNKNOWN_CHARACTER);
                    }

                    // After 15 bytes, reset everything for formatting purpose
                    if (count == 14) {
                        result.append(String.format("%-60s | %s%n", hex, input));
                        hex.setLength(0);
                        input.setLength(0);
                        count = 0;
                    } else {
                        count++;
                    }

                }

                // if the count>0, meaning there is remaining content
                if (count > 0) {
                    result.append(String.format("%-60s | %s%n", hex, input));
                }

            }

            return result.toString();
        }

    }
}
