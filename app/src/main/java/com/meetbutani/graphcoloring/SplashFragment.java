package com.meetbutani.graphcoloring;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Objects;

public class SplashFragment extends Fragment {

    View view;
    TextView appTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_splash, container, false);

//        appTitle = view.findViewById(R.id.appTitle);
//        appTitle.setText("Rainbow\nGraph");

//        Shader textShader = new LinearGradient(0, 0, 500, 0,
//                new int[]{
//                        Color.parseColor("#9a00ff"),
////                        Color.parseColor("#4300ff"),
//                        Color.parseColor("#019afe"),
//                        Color.parseColor("#00AA01"),
//                        Color.parseColor("#ffff66"),
////                        Color.parseColor("#fea500"),
//                        Color.parseColor("#fe0000"),
//                }, null, Shader.TileMode.CLAMP);
//        appTitle.getPaint().setShader(textShader);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                Activity activity = getActivity();
                if(activity != null && isAdded()) {

                    requireActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.mainFrame, new LevelsFragment(), "LevelsFragment")
                            .addToBackStack("LevelsFragment")
                            .commit();
                }
            }
        }, 2000);

        return view;
    }
}