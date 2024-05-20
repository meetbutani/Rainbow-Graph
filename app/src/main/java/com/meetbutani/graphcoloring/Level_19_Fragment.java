package com.meetbutani.graphcoloring;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class Level_19_Fragment extends BaseFragment {


    private View edge89, edge12, edge45, edge710, edge68, edge23, edge28, edge47, edge36, edge19, edge510, edge34, edge67, edge910, edge15;
    private TextView v1, v2, v3, v4, v5, v6, v7, v8, v9, v10;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_level_19, container, false);
        context = getContext();

        initView(view);

        v1.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v1);

                edge12.setBackgroundDrawable(setEdgeColor(v1, v2));
                edge15.setBackgroundDrawable(setHorEdgeColor(v1, v5));
                edge19.setBackgroundDrawable(setHorEdgeColor(v1, v9));
            }
        });

        v2.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v2);

                edge12.setBackgroundDrawable(setEdgeColor(v1, v2));
                edge23.setBackgroundDrawable(setHorEdgeColor(v2, v3));
                edge28.setBackgroundDrawable(setHorEdgeColor(v2, v8));
            }
        });

        v3.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v3);

                edge23.setBackgroundDrawable(setHorEdgeColor(v2, v3));
                edge34.setBackgroundDrawable(setHorEdgeColor(v3, v4));
                edge36.setBackgroundDrawable(setHorEdgeColor(v3, v6));
            }
        });

        v4.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v4);

                edge34.setBackgroundDrawable(setHorEdgeColor(v3, v4));
                edge45.setBackgroundDrawable(setEdgeColor(v4, v5));
                edge47.setBackgroundDrawable(setHorEdgeColor(v4, v7));
            }
        });

        v5.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v5);

                edge15.setBackgroundDrawable(setHorEdgeColor(v1, v5));
                edge45.setBackgroundDrawable(setEdgeColor(v4, v5));
                edge510.setBackgroundDrawable(setHorEdgeColor(v5, v10));
            }
        });

        v6.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v6);

                edge36.setBackgroundDrawable(setHorEdgeColor(v3, v6));
                edge67.setBackgroundDrawable(setHorEdgeColor(v6, v7));
                edge68.setBackgroundDrawable(setHorEdgeColor(v6, v8));
            }
        });

        v7.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v7);

                edge47.setBackgroundDrawable(setHorEdgeColor(v4, v7));
                edge67.setBackgroundDrawable(setHorEdgeColor(v6, v7));
                edge710.setBackgroundDrawable(setEdgeColor(v7, v10));
            }
        });

        v8.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v8);

                edge28.setBackgroundDrawable(setHorEdgeColor(v2, v8));
                edge68.setBackgroundDrawable(setHorEdgeColor(v6, v8));
                edge89.setBackgroundDrawable(setEdgeColor(v8, v9));
            }
        });

        v9.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v9);

                edge19.setBackgroundDrawable(setHorEdgeColor(v1, v9));
                edge89.setBackgroundDrawable(setEdgeColor(v8, v9));
                edge910.setBackgroundDrawable(setHorEdgeColor(v9, v10));
            }
        });

        v10.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v10);

                edge510.setBackgroundDrawable(setHorEdgeColor(v5, v10));
                edge710.setBackgroundDrawable(setEdgeColor(v7, v10));
                edge910.setBackgroundDrawable(setHorEdgeColor(v9, v10));
            }
        });

        check.setOnClickListener(v -> {
            MediaPlayer.create(context, R.raw.button_click_2).start();
            if (isNonEmpty(vertices)
                    && minColor(7, vertices)
                    && checkHarmoniousColor(v1, v2, v5, v9)
                    && checkHarmoniousColor(v2, v1, v3, v8)
                    && checkHarmoniousColor(v3, v2, v4, v6)
                    && checkHarmoniousColor(v4, v3, v5, v7)
                    && checkHarmoniousColor(v5, v1, v4, v10)
                    && checkHarmoniousColor(v6, v3, v7, v8)
                    && checkHarmoniousColor(v7, v4, v6, v10)
                    && checkHarmoniousColor(v8, v2, v6, v9)
                    && checkHarmoniousColor(v9, v1, v8, v10)
                    && checkHarmoniousColor(v10, v5, v7, v9)
            ) {
//                status.setImageResource(R.drawable.ic_correct);

                levelComplete(19, new LevelsFragment(), "Levels");

            } else {
//                status.setImageResource(R.drawable.ic_wrong);

                levelFailed(19, new Level_19_Fragment(), "Level 19");
            }
//            status.setVisibility(View.VISIBLE);
        });

        return view;
    }

    private void initView(View view) {
        edge89 = view.findViewById(R.id.edge89);
        edge12 = view.findViewById(R.id.edge12);
        edge45 = view.findViewById(R.id.edge45);
        edge710 = view.findViewById(R.id.edge710);
        edge68 = view.findViewById(R.id.edge68);
        edge23 = view.findViewById(R.id.edge23);
        edge28 = view.findViewById(R.id.edge28);
        edge47 = view.findViewById(R.id.edge47);
        edge36 = view.findViewById(R.id.edge36);
        edge19 = view.findViewById(R.id.edge19);
        edge510 = view.findViewById(R.id.edge510);
        edge34 = view.findViewById(R.id.edge34);
        edge67 = view.findViewById(R.id.edge67);
        edge910 = view.findViewById(R.id.edge910);
        edge15 = view.findViewById(R.id.edge15);
        v1 = view.findViewById(R.id.v1);
        v2 = view.findViewById(R.id.v2);
        v3 = view.findViewById(R.id.v3);
        v4 = view.findViewById(R.id.v4);
        v5 = view.findViewById(R.id.v5);
        v6 = view.findViewById(R.id.v6);
        v7 = view.findViewById(R.id.v7);
        v8 = view.findViewById(R.id.v8);
        v9 = view.findViewById(R.id.v9);
        v10 = view.findViewById(R.id.v10);
        initColor_8();
        setDefColor(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10);
        setColorClick(colorSet);
    }
}
