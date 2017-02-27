package com.example.aartichella.myapp;

/**
 * Created by aartichella on 2/25/17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aartichella.myapp.R;

public class GridtAdapter extends BaseAdapter {
    private Context context;
    private final int[][] myArr;

    public GridtAdapter(Context context, int[][] myArr) {
        this.context = context;
        this.myArr = myArr;
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;

        //gridView = new View(context);
        gridView = inflater.inflate(R.layout.grid, null);

        ImageView imageView = (ImageView) gridView.findViewById(R.id.grid_item_image);
        int row = position / 12;
        int col = position % 12;
        if (myArr[row][col] == 1)
            imageView.setImageResource(R.drawable.red);
        return gridView;
    }
    public int getCount() {
        return 144;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



}

