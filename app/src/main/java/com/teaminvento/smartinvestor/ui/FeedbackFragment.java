package com.teaminvento.smartinvestor.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.teaminvento.smartinvestor.MainActivity;
import com.teaminvento.smartinvestor.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment {

    private static final String TAG = "FeedbackFragment";

    public FeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        final EditText editSub = (EditText)view.findViewById(R.id.txtSubject);
        final EditText editMess = (EditText)view.findViewById(R.id.txtMessage);

        ((Button) view.findViewById(R.id.btnOK)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String to = "teaminventoapps@gmail.com";
                String sub = editSub.getText().toString();
                String mess = editMess.getText().toString();
                sub = "Feedback - SmartInvestor: " + sub;

                Intent mailSelector = new Intent(Intent.ACTION_SENDTO);
                mailSelector.setData(Uri.parse("mailto:"));

                final Intent mail = new Intent(Intent.ACTION_SEND);
                mail.putExtra(Intent.EXTRA_EMAIL  , new String[]{to});
                mail.putExtra(Intent.EXTRA_SUBJECT, sub);
                mail.putExtra(Intent.EXTRA_TEXT   , mess);

                mail.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                mail.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                mail.setSelector( mailSelector );

                if( mail.resolveActivity(getActivity().getPackageManager()) != null ) {
//                    getActivity().getSupportFragmentManager().popBackStack();
                    startActivity(mail);
                }


            }
        });
        return view;
    }
}
