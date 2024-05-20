package com.meetbutani.graphcoloring;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Level_17_Fragment extends BaseFragment {


    private View edge13;
    private View edge45;
    private View edge68;
    private View edge27;
    private View edge12;
    private View edge46;
    private View edge58;
    private View edge37;
    private View edge35;
    private View edge26;
    private View edge14;
    private View edge78;
    private TextView v1;
    private TextView v2;
    private TextView v3;
    private TextView v4;
    private TextView v5;
    private TextView v6;
    private TextView v7;
    private TextView v8;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_level_17, container, false);
        context = getContext();

        initView();

        v1.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v1);

                edge12.setBackgroundDrawable(setEdgeColor(v1, v2));
                edge13.setBackgroundDrawable(setEdgeColor(v1, v3));
                edge14.setBackgroundDrawable(setHorEdgeColor(v1, v4));
            }
        });

        v2.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v2);

                edge26.setBackgroundDrawable(setHorEdgeColor(v2, v6));
                edge27.setBackgroundDrawable(setEdgeColor(v2, v7));
                edge12.setBackgroundDrawable(setEdgeColor(v1, v2));
            }
        });

        v3.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v3);

                edge37.setBackgroundDrawable(setEdgeColor(v3, v7));
                edge35.setBackgroundDrawable(setHorEdgeColor(v3, v5));
                edge13.setBackgroundDrawable(setEdgeColor(v1, v3));
            }
        });

        v4.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v4);

                edge45.setBackgroundDrawable(setEdgeColor(v4, v5));
                edge46.setBackgroundDrawable(setEdgeColor(v4, v6));
                edge14.setBackgroundDrawable(setHorEdgeColor(v1, v4));
            }
        });
        v5.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v5);

                edge58.setBackgroundDrawable(setEdgeColor(v5, v8));
                edge35.setBackgroundDrawable(setHorEdgeColor(v3, v5));
                edge45.setBackgroundDrawable(setEdgeColor(v4, v5));
            }
        });
        v6.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v6);

                edge68.setBackgroundDrawable(setEdgeColor(v6, v8));
                edge46.setBackgroundDrawable(setEdgeColor(v4, v6));
                edge26.setBackgroundDrawable(setHorEdgeColor(v2, v6));
            }
        });
        v7.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v7);

                edge78.setBackgroundDrawable(setHorEdgeColor(v7, v8));
                edge27.setBackgroundDrawable(setEdgeColor(v2, v7));
                edge37.setBackgroundDrawable(setEdgeColor(v3, v7));
            }
        });
        v8.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v8);

                edge78.setBackgroundDrawable(setHorEdgeColor(v7, v8));
                edge68.setBackgroundDrawable(setEdgeColor(v6, v8));
                edge58.setBackgroundDrawable(setEdgeColor(v5, v8));
            }
        });

        check.setOnClickListener(v -> {
            MediaPlayer.create(context, R.raw.button_click_2).start();
            if (isNonEmpty(vertices) && minColor(4, vertices) && checkHarmoniousColor(v1, v2, v3, v4) && checkHarmoniousColor(v2, v6, v1, v7) && checkHarmoniousColor(v3, v1, v7, v5) && checkHarmoniousColor(v4, v1, v5, v6) && checkHarmoniousColor(v5, v3, v4, v8) && checkHarmoniousColor(v6, v4, v2, v8) && checkHarmoniousColor(v7, v2, v3, v8) && checkHarmoniousColor(v8, v5, v6, v7)) {
                //                status.setImageResource(R.drawable.ic_correct);

                levelComplete(17, new Level_18_Fragment(), "Level 18");

            } else {
//                status.setImageResource(R.drawable.ic_wrong);

                levelFailed(17, new Level_17_Fragment(), "Level 17");
            }
//            status.setVisibility(View.VISIBLE);
        });

        return view;
    }

    private void initView() {
        edge13 = view.findViewById(R.id.edge13);
        edge45 = view.findViewById(R.id.edge45);
        edge68 = view.findViewById(R.id.edge68);
        edge27 = view.findViewById(R.id.edge27);
        edge12 = view.findViewById(R.id.edge12);
        edge46 = view.findViewById(R.id.edge46);
        edge58 = view.findViewById(R.id.edge58);
        edge37 = view.findViewById(R.id.edge37);
        edge35 = view.findViewById(R.id.edge35);
        edge26 = view.findViewById(R.id.edge26);
        edge14 = view.findViewById(R.id.edge14);
        edge78 = view.findViewById(R.id.edge78);
        v1 = view.findViewById(R.id.v1);
        v2 = view.findViewById(R.id.v2);
        v3 = view.findViewById(R.id.v3);
        v4 = view.findViewById(R.id.v4);
        v5 = view.findViewById(R.id.v5);
        v6 = view.findViewById(R.id.v6);
        v7 = view.findViewById(R.id.v7);
        v8 = view.findViewById(R.id.v8);
        initColor_8();
        setDefColor(v1, v2, v3, v4, v5, v6, v7, v8);
        setColorClick(colorSet);
    }

}
