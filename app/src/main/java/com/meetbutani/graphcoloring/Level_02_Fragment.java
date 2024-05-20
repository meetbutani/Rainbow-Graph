package com.meetbutani.graphcoloring;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Level_02_Fragment extends BaseFragment {

    private View edge12, edge23, edge34, edge41;
    private TextView v1, v2, v3, v4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_level_02, container, false);
        context = getContext();

        initView();

        v1.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v1);

                edge12.setBackgroundDrawable(setEdgeColor(v1, v2));
                edge41.setBackgroundDrawable(setEdgeColor(v4, v1));
            }
        });

        v2.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v2);

                edge12.setBackgroundDrawable(setEdgeColor(v1, v2));
                edge23.setBackgroundDrawable(setHorEdgeColor(v2, v3));
            }
        });

        v3.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v3);

                edge23.setBackgroundDrawable(setHorEdgeColor(v2, v3));
                edge34.setBackgroundDrawable(setEdgeColor(v3, v4));
            }
        });

        v4.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v4);

                edge34.setBackgroundDrawable(setEdgeColor(v3, v4));
                edge41.setBackgroundDrawable(setEdgeColor(v4, v1));
            }
        });

        check.setOnClickListener(v -> {
            MediaPlayer.create(context, R.raw.button_click_2).start();
            if (isNonEmpty(vertices) && minColor(2, vertices) && checkProperColor(v1, v2, v4) && checkProperColor(v2, v3) && checkProperColor(v3, v4)) {
                //                status.setImageResource(R.drawable.ic_correct);

                levelComplete(2, new Level_03_Fragment(), "Level 3");

            } else {
//                status.setImageResource(R.drawable.ic_wrong);

                levelFailed(2, new Level_02_Fragment(), "Level 2");
            }
//            status.setVisibility(View.VISIBLE);
        });

        return view;
    }

    private void initView() {
        edge12 = view.findViewById(R.id.edge12);
        edge23 = view.findViewById(R.id.edge23);
        edge34 = view.findViewById(R.id.edge34);
        edge41 = view.findViewById(R.id.edge41);
        v1 = view.findViewById(R.id.v1);
        v2 = view.findViewById(R.id.v2);
        v3 = view.findViewById(R.id.v3);
        v4 = view.findViewById(R.id.v4);
        initColor_8();
        setDefColor(v1, v2, v3, v4);
        setColorClick(colorSet);
    }

}