package com.example.myapplication.projectlab.Lab3.Exe03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.projectlab.Lab3.Exe01.TraiCay;
import com.example.myapplication.projectlab.R;

import java.util.List;

public class PlayerSoccerAdapt extends BaseAdapter {
    private Context context;
    private int layout;
    private List<PlayerSoccer> playerSoccers;

    public PlayerSoccerAdapt(Context context, int layout, List<PlayerSoccer> playerSoccers) {
        this.context = context;
        this.layout = layout;
        this.playerSoccers = playerSoccers;
    }
    @Override
    public int getCount() {
        return playerSoccers.size();
    }
    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        TextView txtTen = (TextView) view.findViewById(R.id.textName);
        TextView txtMota =(TextView) view.findViewById(R.id.textDescription);
        ImageView imageView =view.findViewById(R.id.imageView5);
        ImageView imageRight = view.findViewById(R.id.idImageRightLab3);
        PlayerSoccer playerSoccer = playerSoccers.get(i);
        txtTen.setText(playerSoccer.getTen());
        txtMota.setText(playerSoccer.getMota());
        imageRight.setImageResource(playerSoccer.getImageRight());
        imageView.setImageResource(playerSoccer.getImage());
        return view;
    }
}
