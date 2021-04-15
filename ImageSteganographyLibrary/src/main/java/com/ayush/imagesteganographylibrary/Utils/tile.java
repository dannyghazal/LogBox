package com.ayush.imagesteganographylibrary.Utils;

import java.util.List;
import com.ayush.imagesteganographylibrary.Utils.Hex;

public class tile {
    private int x, y, width, height;
    private Color color;

    public tile(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

  //  public void paint(Color g) {
  //      g.setColor(color);
  //      g.fillRect(x, y, width, height);
  //  }

   List<tile> tiles = Hex;

    void createTiles() {
        for(int x = 0; x < 100; x++) {
            for(int y = 0; y < 100; y++) {
                //Color color = argb;
                int size = 5;
                int tileX = x * size;
                int tileY = y * size;
                tiles.add(new tile(tileX, tileY, size, size, color));
            }
        }
    }

    //the code below is how you call the function to render the squares
   // void paint(Graphics g) {
   //     tiles.forEach(tile -> tile.paint(g));
   // }

}

