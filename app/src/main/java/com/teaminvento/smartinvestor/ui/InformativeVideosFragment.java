package com.teaminvento.smartinvestor.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.teaminvento.smartinvestor.Video;
import com.teaminvento.smartinvestor.InformativeVideosListAdapter;
import com.teaminvento.smartinvestor.R;
import com.teaminvento.smartinvestor.YoutubeVideoActivity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformativeVideosFragment extends Fragment {



    private static final String TAG = "InformativeVideosFragme";
    ListView lv;
    public Context context;
    InformativeVideosListAdapter adapter;

    private DatabaseReference rootDatabase;
    ArrayList<String> videoThumbnails=new ArrayList<>();
    ArrayList<String> videoTitles=new ArrayList<>();
    ArrayList<String> videoIds= new ArrayList<>();
    Video video;

    public InformativeVideosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_informative_videos, container, false);

        lv =(ListView) view.findViewById(R.id.list_informative_videos);

        video = new Video();
        rootDatabase = FirebaseDatabase.getInstance().getReference();
        rootDatabase = rootDatabase.child("Videos");
        Log.d(TAG, "rootdatabase initialized");
        adapter= new InformativeVideosListAdapter(getActivity(),videoTitles,videoThumbnails);

        rootDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                HashMap<String,String> videoSnap = (HashMap<String,String>)dataSnapshot.getValue();
                video = new Video(videoSnap.get("title"),videoSnap.get("id"));

                videoTitles.add(0,video.getTitle());
                videoThumbnails.add(0,video.getThumbnailLink());
                videoIds.add(0,video.getId());
                lv.setAdapter(adapter);
                Log.d(TAG, "onChildAdded: Adapter set");
                Log.d(TAG, "onChildAdded: Datasnapshot Key: "+dataSnapshot.getKey());
                Log.d(TAG, "onChildAdded: Title: "+video.getTitle());
                Log.d(TAG, "onChildAdded: ThumbnailLink: "+video.getThumbnailLink());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                video=dataSnapshot.getValue(Video.class);
                videoTitles.remove(video.getTitle());
                videoThumbnails.remove(video.getThumbnailLink());

                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), YoutubeVideoActivity.class);
                intent.putExtra("ID",videoIds.get(position));
                intent.putExtra("title",videoTitles.get(position));
//                intent.putExtra("navigationKey","");
                startActivity(intent);
            }
        });

        videoThumbnails.clear();
        videoTitles.clear();

        return view;


    }
}
