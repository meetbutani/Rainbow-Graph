package com.meetbutani.graphcoloring;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Level_10_Fragment extends BaseFragment {


    private View edge12;
    private View edge34;
    private View edge56;
    private View edge23;
    private View edge14;
    private TextView v1;
    private TextView v2;
    private TextView v3;
    private TextView v4;
    private TextView v5;
    private TextView v6;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_level_10, container, false);
        context = getContext();

        initView();

        v1.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v1);

                edge12.setBackgroundDrawable(setEdgeColor(v1, v2));
                edge14.setBackgroundDrawable(setHorEdgeColor(v1, v4));
            }
        });

        v2.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v2);

                edge23.setBackgroundDrawable(setHorEdgeColor(v2, v3));
                edge12.setBackgroundDrawable(setEdgeColor(v1, v2));
            }
        });

        v3.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v3);

                edge34.setBackgroundDrawable(setEdgeColor(v3, v4));
                edge23.setBackgroundDrawable(setHorEdgeColor(v2, v3));
            }
        });

        v4.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v4);

                edge14.setBackgroundDrawable(setHorEdgeColor(v1, v4));
                edge34.setBackgroundDrawable(setEdgeColor(v3, v4));
            }
        });

        v5.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v5);

                edge56.setBackgroundDrawable(setEdgeColor(v5, v6));
            }
        });

        v6.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v6);

                edge56.setBackgroundDrawable(setEdgeColor(v5, v6));
            }
        });

        check.setOnClickListener(v -> {
            MediaPlayer.create(context, R.raw.button_click_2).start();
            if (isNonEmpty(vertices) && minColor(4, vertices) && checkHarmoniousColor(v1, v2, v4) && checkHarmoniousColor(v2, v3, v1) && checkHarmoniousColor(v3, v2, v4) && checkHarmoniousColor(v4, v1, v3) && checkHarmoniousColor(v5, v6) && checkHarmoniousColor(v6, v5)) {
                //                status.setImageResource(R.drawable.ic_correct);

                levelComplete(10, new Level_11_Fragment(), "Level 11");

            } else {
//                status.setImageResource(R.drawable.ic_wrong);

                levelFailed(10, new Level_10_Fragment(), "Level 10");
            }
//            status.setVisibility(View.VISIBLE);
        });

        return view;
    }

    private void initView() {
        edge12 = view.findViewById(R.id.edge12);
        edge34 = view.findViewById(R.id.edge34);
        edge56 = view.findViewById(R.id.edge56);
        edge23 = view.findViewById(R.id.edge23);
        edge14 = view.findViewById(R.id.edge14);
        v1 = view.findViewById(R.id.v1);
        v2 = view.findViewById(R.id.v2);
        v3 = view.findViewById(R.id.v3);
        v4 = view.findViewById(R.id.v4);
        v5 = view.findViewById(R.id.v5);
        v6 = view.findViewById(R.id.v6);
        initColor_8();
        setDefColor(v1, v2, v3, v4, v5, v6);
        setColorClick(colorSet);
    }

}
