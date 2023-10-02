package com.example.myapplication.projectlab.Lab3.Exe01;

public class TraiCay {
    private String Ten;
    private String Mota;
    private int Image;

    public TraiCay(String ten, String mota, int image) {
        Ten = ten;
        Mota = mota;
        Image = image;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
