package com.meetbutani.graphcoloring;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Level_04_Fragment extends BaseFragment {


    private View edge13;
    private View edge24;
    private TextView v1;
    private TextView v2;
    private TextView v3;
    private TextView v4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_level_04, container, false);
        context = getContext();

        initView();

        v1.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v1);

                edge13.setBackgroundDrawable(setHorEdgeColor(v1, v3));
            }
        });

        v2.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v2);

                edge24.setBackgroundDrawable(setHorEdgeColor(v2, v4));
            }
        });

        v3.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v3);

                edge13.setBackgroundDrawable(setHorEdgeColor(v1, v3));
            }
        });

        v4.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v4);

                edge24.setBackgroundDrawable(setHorEdgeColor(v2, v4));
            }
        });

        check.setOnClickListener(v -> {
            MediaPlayer.create(context, R.raw.button_click_2).start();
            if (isNonEmpty(vertices) && minColor(4, vertices) && checkProperColor(v1, v3) && checkProperColor(v2, v4) && checkProperColor(v3, v1) && checkProperColor(v4, v2)) {
//                status.setImageResource(R.drawable.ic_correct);

                levelComplete(4, new Level_05_Fragment(), "Level 5");

            } else {
//                status.setImageResource(R.drawable.ic_wrong);

                levelFailed(4, new Level_04_Fragment(), "Level 4");
            }
//            status.setVisibility(View.VISIBLE);
        });

        return view;
    }

    private void initView() {
        edge13 = view.findViewById(R.id.edge13);
        edge24 = view.findViewById(R.id.edge24);
        v1 = view.findViewById(R.id.v1);
        v2 = view.findViewById(R.id.v2);
        v3 = view.findViewById(R.id.v3);
        v4 = view.findViewById(R.id.v4);
        initColor_8();
        setDefColor(v1, v2, v3, v4);
        setColorClick(colorSet);
    }

}
