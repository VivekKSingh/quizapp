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
import android.widget.EditText;

public class FragmentThree extends Fragment {

    Button submitButton;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment

        final View view = inflater.inflate(
                R.layout.fragment_three, container, false);

        submitButton = (Button) view.findViewById(R.id.button_submit_three);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText answer = view.findViewById(R.id.enter_answer);

                if(answer.getText().toString().equalsIgnoreCase("liver")) {
                    int updatedScore = ((MainActivity) getActivity()).getCurrentScore() + 1;
                    ((MainActivity) getActivity()).updateScore(updatedScore);
                    Log.i("Updating one", "Score" + ((MainActivity) getActivity()).getCurrentScore());
                    switchFragment(new FragmentFour());
                } else {
                    Log.i("Updating one", "Score" + ((MainActivity) getActivity()).getCurrentScore());
                    switchFragment(new FragmentFour());
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