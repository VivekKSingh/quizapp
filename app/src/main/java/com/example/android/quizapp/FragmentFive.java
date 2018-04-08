package com.example.android.quizapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class FragmentFive extends Fragment {

    Button submitButton;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment

        final View view = inflater.inflate(
                R.layout.fragment_five, container, false);

        submitButton = (Button) view.findViewById(R.id.button_submit_five);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton correctRadioButton = view.findViewById(R.id.quiz5_radioThree);

                if(correctRadioButton.isChecked()) {
                    int updatedScore = ((MainActivity) getActivity()).getCurrentScore() + 1;
                    ((MainActivity) getActivity()).updateScore(updatedScore);
                    Log.i("Updating one", "Score" + ((MainActivity) getActivity()).getCurrentScore());
                    switchFragment(new FragmentFinal());
                } else {
                    Log.i("Updating one", "Score" + ((MainActivity) getActivity()).getCurrentScore());
                    switchFragment(new FragmentFinal());
                }

            }
        });

        return view;
    }

    public void switchFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout, fragment);
        fragmentTransaction.commit();
    }

}