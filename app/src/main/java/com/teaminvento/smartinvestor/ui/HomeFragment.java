package com.teaminvento.smartinvestor.ui;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.teaminvento.smartinvestor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        CardView card_term_insurance_plan = (CardView) view.findViewById(R.id.card_term_insurance_plan);
        card_term_insurance_plan.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_HomeFragment_to_TermPlanFragment, null));

        CardView card_sip = (CardView) view.findViewById(R.id.card_sip);
        card_sip.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_HomeFragment_to_SipFragment, null));

        CardView card_health_insurance_plan = (CardView) view.findViewById(R.id.card_health_insurance);
        card_health_insurance_plan.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_HomeFragment_to_HealthFragment, null));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            StateListAnimator stateListAnimator = AnimatorInflater
                    .loadStateListAnimator(getContext(), R.animator.lift_on_touch);
            card_term_insurance_plan.setStateListAnimator(stateListAnimator);
            card_sip.setStateListAnimator(stateListAnimator);
            card_health_insurance_plan.setStateListAnimator(stateListAnimator);
        }
        return view;
    }
}
