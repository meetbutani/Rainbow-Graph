package com.meetbutani.graphcoloring;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

public class last3_Fragment extends BaseFragment {


    private View edge12, edge34, edge14, edge23;
    private TextView v1, v2, v4, v3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint({"ResourceAsColor", "ResourceType"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_level_20, container, false);
        context = getContext();

        initView(view);

        v1.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v1);

                edge12.setBackground(setCurveEdgeColor(v1, v2));
                edge14.setBackground(setEdgeColor(v1, v4));

            }
        });

        v2.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v2);

                edge12.setBackground(setCurveEdgeColor(v1, v2));
                edge23.setBackground(setEdgeColor(v2, v3));

            }
        });

        v3.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v3);

                edge34.setBackground(setCurveEdgeColor(v3, v4));
                edge23.setBackground(setEdgeColor(v2, v3));

            }
        });

        v4.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v4);

                edge34.setBackground(setCurveEdgeColor(v3, v4));
                edge14.setBackground(setEdgeColor(v1, v4));

            }
        });

        check.setOnClickListener(v -> {
            MediaPlayer.create(context, R.raw.button_click_2).start();
            if (isNonEmpty(vertices)
//                    && minColor(3, vertices)
                    && checkHarmoniousColor(v1, v2)
                    && checkHarmoniousColor(v2, v1)
            ) {
                //                status.setImageResource(R.drawable.ic_correct);

                levelComplete(1, new Level_02_Fragment(), "Level 2");

            } else {
//                status.setImageResource(R.drawable.ic_wrong);

                levelFailed(1, new Level_01_Fragment(), "Level 1");
            }
//            status.setVisibility(View.VISIBLE);
        });

        return view;
    }

    private void initView(View view) {
        v1 = view.findViewById(R.id.v1);
        v2 = view.findViewById(R.id.v2);
        v3 = view.findViewById(R.id.v3);
        v4 = view.findViewById(R.id.v4);
        edge12 = view.findViewById(R.id.edge12);
        edge34 = view.findViewById(R.id.edge34);
        edge14 = view.findViewById(R.id.edge14);
        edge23 = view.findViewById(R.id.edge23);
        initColor_12();
        setDefColor(v1, v2, v3, v4);
        setColorClick(colorSet);
    }
}
