package com.teaminvento.smartinvestor.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teaminvento.smartinvestor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthInsuranceFragment extends Fragment {

    public HealthInsuranceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_health_insurance, container, false);
    }
}
