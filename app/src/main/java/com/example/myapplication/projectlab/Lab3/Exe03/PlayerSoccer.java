package com.example.myapplication.projectlab.Lab3.Exe03;

import com.example.myapplication.projectlab.Lab3.Exe01.TraiCay;

public class PlayerSoccer extends TraiCay {
    private int ImageRight;


    public PlayerSoccer(String ten, String mota, int image, int imageRight) {
        super(ten, mota, image);
        ImageRight = imageRight;
    }

    public int getImageRight() {
        return ImageRight;
    }

    public void setImageRight(int imageRight) {
        ImageRight = imageRight;
    }
}
