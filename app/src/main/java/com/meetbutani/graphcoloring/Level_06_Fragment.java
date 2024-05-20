package com.meetbutani.graphcoloring;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Level_06_Fragment extends BaseFragment {

    private View edge12;
    private View edge15;
    private View edge35;
    private View edge25;
    private View edge45;
    private TextView v1;
    private TextView v2;
    private TextView v3;
    private TextView v4;
    private TextView v5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_level_06, container, false);
        context = getContext();

        initView();

        v1.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v1);

                edge12.setBackgroundDrawable(setEdgeColor(v1, v2));
                edge15.setBackgroundDrawable(setHorEdgeColor(v1, v5));
            }
        });

        v2.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v2);

                edge25.setBackgroundDrawable(setHorEdgeColor(v1, v5));
                edge12.setBackgroundDrawable(setEdgeColor(v1, v2));
            }
        });

        v3.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v3);

                edge35.setBackgroundDrawable(setHorEdgeColor(v3, v5));
            }
        });

        v4.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v4);

                edge45.setBackgroundDrawable(setHorEdgeColor(v4, v5));
            }
        });

        v5.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v5);

                edge45.setBackgroundDrawable(setHorEdgeColor(v4, v5));
                edge35.setBackgroundDrawable(setHorEdgeColor(v3, v5));
                edge25.setBackgroundDrawable(setHorEdgeColor(v2, v5));
                edge15.setBackgroundDrawable(setHorEdgeColor(v1, v5));
            }
        });

        check.setOnClickListener(v -> {
            MediaPlayer.create(context, R.raw.button_click_2).start();
            if (isNonEmpty(vertices) && minColor(4, vertices) && checkProperColor(v1, v2, v5) && checkProperColor(v2, v5, v1) && checkProperColor(v3, v5) && checkProperColor(v4, v5) && checkProperColor(v5, v1, v2, v3, v4)) {
                //                status.setImageResource(R.drawable.ic_correct);

                levelComplete(6, new Level_07_Fragment(), "Level 7");

            } else {
//                status.setImageResource(R.drawable.ic_wrong);

                levelFailed(6, new Level_06_Fragment(), "Level 6");
            }
//            status.setVisibility(View.VISIBLE);
        });

        return view;
    }

    private void initView() {
        edge12 = view.findViewById(R.id.edge12);
        edge15 = view.findViewById(R.id.edge15);
        edge35 = view.findViewById(R.id.edge35);
        edge25 = view.findViewById(R.id.edge25);
        edge45 = view.findViewById(R.id.edge45);
        v1 = view.findViewById(R.id.v1);
        v2 = view.findViewById(R.id.v2);
        v3 = view.findViewById(R.id.v3);
        v4 = view.findViewById(R.id.v4);
        v5 = view.findViewById(R.id.v5);
        initColor_8();
        setDefColor(v1, v2, v3, v4, v5);
        setColorClick(colorSet);
    }

}
