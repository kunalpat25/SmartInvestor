package com.teaminvento.smartinvestor.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.core.Repo;
import com.teaminvento.smartinvestor.ExpandableRecyclerAdapter;
import com.teaminvento.smartinvestor.R;

import java.util.List;


public class TermPlanFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Repo> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_term_plan, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.cv);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
//fetch data and on ExpandableRecyclerAdapter
        recyclerView.setAdapter(new ExpandableRecyclerAdapter(data));
        return view;
    }

}
