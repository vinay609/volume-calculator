package com.example.volume_app;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;



public class MyCustomAdaptor extends ArrayAdapter<shape> {

    private ArrayList<shape> shapesArrayList;
    Context context;

    public MyCustomAdaptor(Context context, ArrayList<shape> shapesArrayList) {
        super(context, R.layout.grid_item_layout, shapesArrayList);
        this.shapesArrayList = shapesArrayList;
        this.context = context;
    }

    private static class MyViewHolder {
        TextView shapeName;
        ImageView shapeImg;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        shape shapes = getItem(position);
        MyViewHolder myViewHolder;
        if (convertView == null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.grid_item_layout, parent, false);


            myViewHolder.shapeName = (TextView) convertView.findViewById(R.id.textView);
            myViewHolder.shapeImg = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(myViewHolder);


        }else{
            myViewHolder = (MyViewHolder) convertView.getTag();


        }
        myViewHolder.shapeName.setText(shapes.getshapeName());
        myViewHolder.shapeImg.setImageResource(shapes.getshapeImg());
        return convertView;

    }
}
