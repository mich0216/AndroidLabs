package com.example.androidlabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View result =  inflater.inflate(R.layout.fragment_details, container, false);

        //show the message
        TextView message = (TextView)result.findViewById(R.id.message);
        message.setText(dataFromActivity.getString(FragmentExample.ITEM_SELECTED));

        //show the id:
        TextView idView = (TextView)result.findViewById(R.id.idEqual);
        idView.setText("ID=" + id);

        // get the delete button, and add a click listener:
        Button finishButton = (Button)result.findViewById(R.id.checkBox);    }
}