package com.meetbutani.graphcoloring;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Level_16_Fragment extends BaseFragment {


    private View edge47;
    private View edge26;
    private View edge38;
    private View edge79;
    private View edge37;
    private View edge12;
    private View edge56;
    private View edge23;
    private View edge14;
    private TextView v1;
    private TextView v2;
    private TextView v3;
    private TextView v4;
    private TextView v5;
    private TextView v6;
    private TextView v7;
    private TextView v8;
    private TextView v9;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_level_16, container, false);
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
                edge26.setBackgroundDrawable(setEdgeColor(v2, v6));
                edge12.setBackgroundDrawable(setEdgeColor(v1, v2));
            }
        });

        v3.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v3);

                edge37.setBackgroundDrawable(setHorEdgeColor(v3, v7));
                edge38.setBackgroundDrawable(setEdgeColor(v3, v8));
                edge23.setBackgroundDrawable(setHorEdgeColor(v2, v3));
            }
        });

        v4.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v4);

                edge47.setBackgroundDrawable(setHorEdgeColor(v4, v7));
                edge14.setBackgroundDrawable(setHorEdgeColor(v1, v4));
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

                edge26.setBackgroundDrawable(setEdgeColor(v2, v6));
                edge56.setBackgroundDrawable(setEdgeColor(v5, v6));
            }
        });

        v7.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v7);

                edge79.setBackgroundDrawable(setEdgeColor(v7, v9));
                edge47.setBackgroundDrawable(setHorEdgeColor(v4, v7));
                edge37.setBackgroundDrawable(setHorEdgeColor(v3, v7));
            }
        });

        v8.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v8);

                edge38.setBackgroundDrawable(setEdgeColor(v3, v8));
            }
        });

        v9.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v9);

                edge79.setBackgroundDrawable(setEdgeColor(v7, v9));
            }
        });

        check.setOnClickListener(v -> {
            MediaPlayer.create(context, R.raw.button_click_2).start();
            if (isNonEmpty(vertices) && minColor(4, vertices) && checkHarmoniousColor(v1, v2, v4) && checkHarmoniousColor(v2, v3, v1, v6) && checkHarmoniousColor(v3, v2, v7, v8) && checkHarmoniousColor(v4, v1, v7) && checkHarmoniousColor(v5, v6) && checkHarmoniousColor(v6, v2, v5) && checkHarmoniousColor(v7, v3, v4, v9) && checkHarmoniousColor(v8, v3) && checkHarmoniousColor(v9, v7)) {
                //                status.setImageResource(R.drawable.ic_correct);

                levelComplete(16, new Level_17_Fragment(), "Level 17");

            } else {
//                status.setImageResource(R.drawable.ic_wrong);

                levelFailed(16, new Level_16_Fragment(), "Level 16");
            }
//            status.setVisibility(View.VISIBLE);
        });

        return view;
    }

    private void initView() {
        edge47 = view.findViewById(R.id.edge47);
        edge26 = view.findViewById(R.id.edge26);
        edge38 = view.findViewById(R.id.edge38);
        edge79 = view.findViewById(R.id.edge79);
        edge37 = view.findViewById(R.id.edge37);
        edge12 = view.findViewById(R.id.edge12);
        edge56 = view.findViewById(R.id.edge56);
        edge23 = view.findViewById(R.id.edge23);
        edge14 = view.findViewById(R.id.edge14);
        v1 = view.findViewById(R.id.v1);
        v2 = view.findViewById(R.id.v2);
        v3 = view.findViewById(R.id.v3);
        v4 = view.findViewById(R.id.v4);
        v5 = view.findViewById(R.id.v5);
        v6 = view.findViewById(R.id.v6);
        v7 = view.findViewById(R.id.v7);
        v8 = view.findViewById(R.id.v8);
        v9 = view.findViewById(R.id.v9);
        initColor_8();
        setDefColor(v1, v2, v3, v4, v5, v6, v7, v8, v9);
        setColorClick(colorSet);
    }

}
