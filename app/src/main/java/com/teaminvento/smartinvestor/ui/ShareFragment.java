package com.teaminvento.smartinvestor.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teaminvento.smartinvestor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShareFragment extends Fragment {

    public ShareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_share, container, false);
        share();
        return view;
    }

    private void share(){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plane");
        String shareBody="Smart Investor link Download from here..";
        String shareSub="TeamInvento";
        intent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
        intent.putExtra(Intent.EXTRA_TEXT,shareBody);
//        getActivity().getSupportFragmentManager().popBackStack();
        startActivity(Intent.createChooser(intent,"Share Using"));
    }
}
