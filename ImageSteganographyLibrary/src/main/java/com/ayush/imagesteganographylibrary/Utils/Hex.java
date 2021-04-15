package com.ayush.imagesteganographylibrary.Utils;

import android.graphics.Bitmap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Hex {

    public Bitmap image;
    public int hex;

    public int hexImage(Bitmap image, int hex){
        File file = new File("image");
        StringBuilder   builder = new StringBuilder();
        try {
            FileInputStream fin = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while((bytesRead = fin.read(buffer)) > -1)
                    for(int i = 0; i < bytesRead; i++)
                    builder.append(String.format("%02x", buffer[i] & 0xFF)).append(i != bytesRead - 1 ? " " : "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(builder.toString());
        return hex;
        }
    }

