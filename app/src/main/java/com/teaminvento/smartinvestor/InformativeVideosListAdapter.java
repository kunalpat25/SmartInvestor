package com.teaminvento.smartinvestor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class InformativeVideosListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    ArrayList<String> videoTitles=new ArrayList<>();
    ArrayList<String> videoThumbnails=new ArrayList<>();

    public InformativeVideosListAdapter(Activity context,ArrayList<String> videoTitles,ArrayList<String> videoThumbnails)
    {
        super(context,R.layout.video_list_item_layout, videoTitles);

        this.context = context;
        this.videoTitles = videoTitles;
        this.videoThumbnails = videoThumbnails;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        @SuppressLint("ViewHolder") View rowView=inflater.inflate(R.layout.video_list_item_layout,null,false);

        ImageView imgView=(ImageView) rowView.findViewById(R.id.imageVideoThumbnail);
        TextView txtView=(TextView) rowView.findViewById(R.id.txtVideoTitle);


        txtView.setText(videoTitles.get(position));
//        Picasso.get().load(videoThumbnails.get(position)).fit().into(imgView);
        Glide.with(context).load(videoThumbnails.get(position)).into(imgView);
        return rowView;
    }
}