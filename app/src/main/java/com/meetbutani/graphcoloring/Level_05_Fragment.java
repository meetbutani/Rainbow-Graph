package com.meetbutani.graphcoloring;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Level_05_Fragment extends BaseFragment {


    private View edge12;
    private View edge13;
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
        view = inflater.inflate(R.layout.fragment_level_05, container, false);
        context = getContext();

        initView();

        v1.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v1);

                edge12.setBackgroundDrawable(setEdgeColor(v1, v2));
                edge13.setBackgroundDrawable(setHorEdgeColor(v1, v3));

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

                edge13.setBackgroundDrawable(setHorEdgeColor(v2, v3));
            }
        });

        v4.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v4);
            }
        });

        check.setOnClickListener(v -> {
            MediaPlayer.create(context, R.raw.button_click_2).start();
            if (isNonEmpty(vertices) && minColor(4, vertices) && checkHarmoniousColor(v1, v2, v3) && checkHarmoniousColor(v2, v1) && checkHarmoniousColor(v3, v1)) {
                //                status.setImageResource(R.drawable.ic_correct);

                levelComplete(5, new Level_06_Fragment(), "Level 6");

            } else {
//                status.setImageResource(R.drawable.ic_wrong);

                levelFailed(5, new Level_05_Fragment(), "Level 5");
            }
//            status.setVisibility(View.VISIBLE);
        });

        return view;
    }

    private void initView() {
        edge12 = view.findViewById(R.id.edge12);
        edge13 = view.findViewById(R.id.edge13);
        v1 = view.findViewById(R.id.v1);
        v2 = view.findViewById(R.id.v2);
        v3 = view.findViewById(R.id.v3);
        v4 = view.findViewById(R.id.v4);
        initColor_8();
        setDefColor(v1, v2, v3, v4);
        setColorClick(colorSet);

    }

}
