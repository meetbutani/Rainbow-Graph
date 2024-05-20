package com.meetbutani.graphcoloring;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Level_08_Fragment extends BaseFragment {


    private View edge12;
    private View edge34;
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
        view = inflater.inflate(R.layout.fragment_level_08, container, false);
        context = getContext();

        initView();

        v1.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v1);

                edge12.setBackgroundDrawable(setEdgeColor(v1, v2));
            }
        });

        v2.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v2);

                edge12.setBackgroundDrawable(setEdgeColor(v1, v2));
            }
        });

        v3.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v3);

                edge34.setBackgroundDrawable(setEdgeColor(v3, v4));
            }
        });

        v4.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v4);

                edge34.setBackgroundDrawable(setEdgeColor(v3, v4));
            }
        });

        v5.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v5);

            }
        });

        check.setOnClickListener(v -> {
            MediaPlayer.create(context, R.raw.button_click_2).start();
            if (isNonEmpty(vertices) && minColor(4, vertices) && checkHarmoniousColor(v1, v2) && checkHarmoniousColor(v2, v1) && checkHarmoniousColor(v3, v4) && checkHarmoniousColor(v4, v3)) {
                //                status.setImageResource(R.drawable.ic_correct);

                levelComplete(8, new Level_09_Fragment(), "Level 9");

            } else {
//                status.setImageResource(R.drawable.ic_wrong);

                levelFailed(8, new Level_08_Fragment(), "Level 8");
            }
//            status.setVisibility(View.VISIBLE);
        });

        return view;
    }

    private void initView() {
        edge12 = view.findViewById(R.id.edge12);
        edge34 = view.findViewById(R.id.edge34);
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
