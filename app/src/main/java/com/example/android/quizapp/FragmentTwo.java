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
import android.widget.CheckBox;

public class FragmentTwo extends Fragment {

    Button submitButton;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment

        final View view = inflater.inflate(
                R.layout.fragment_two, container, false);

        submitButton = (Button) view.findViewById(R.id.button_submit_two);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox calcium = view.findViewById(R.id.calcium);
                CheckBox carbonDioxide = view.findViewById(R.id.carbon_dioxide);
                CheckBox oxygen = view.findViewById(R.id.oxygen);

                if(calcium.isChecked() && carbonDioxide.isChecked() && oxygen.isChecked()) {
                    int updatedScore = ((MainActivity) getActivity()).getCurrentScore() + 1;
                    ((MainActivity) getActivity()).updateScore(updatedScore);
                    Log.i("Updating one", "Score" + ((MainActivity) getActivity()).getCurrentScore());
                    switchFragment(new FragmentThree());
                } else {
                    Log.i("Updating one", "Score" + ((MainActivity) getActivity()).getCurrentScore());
                    switchFragment(new FragmentThree());
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