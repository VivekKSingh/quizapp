package com.example.android.quizapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    int currentScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1.0f;
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Fragment frag = new FragmentOne();
//        frag.getView().setLayoutParams(params);
        fragmentTransaction.replace(R.id.fragment_layout, frag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void displayFinalScore(View view) {
//        TextView txt = (TextView) findViewById(R.id.quiz_final_textView2);
//        txt.setText(getCurrentScore());
        Log.i("Something from fragment", "Score" + getCurrentScore());
    }

    public void updateScore(int newScore) {
        currentScore = newScore;
    }

    public int getCurrentScore() {
        return currentScore;
    }


//    public void selectFrag(View view) {
//        Fragment fr;
//
//        if(view == findViewById(R.id.button5)) {
//            fr = new FragmentFive();
//        } else if(view == findViewById(R.id.buttonFinal)){
//            fr = new FragmentFinal();
//        } else {
//            fr = new FragmentOne();
//        }
//
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_layout, fr);
//        fragmentTransaction.commit();
//    }
}
