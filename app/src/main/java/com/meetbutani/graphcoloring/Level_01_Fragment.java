package com.meetbutani.graphcoloring;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Angle;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.Position;
import nl.dionsegijn.konfetti.core.Spread;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class Level_01_Fragment extends BaseFragment {

    private View edge21, edge23, edge13;
    private TextView v1, v2, v3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_level_01, container, false);
        context = getContext();

        initView();

        v1.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v1);

                edge21.setBackgroundDrawable(setEdgeColor(v2, v1));
                edge13.setBackgroundDrawable(setEdgeColor(v1, v3));
            }
        });

        v2.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v2);

                edge21.setBackgroundDrawable(setEdgeColor(v2, v1));
                edge23.setBackgroundDrawable(setEdgeColor(v2, v3));
            }
        });

        v3.setOnClickListener(v -> {
            if (selectedCol != 0) {
                changeColor(v3);

                edge23.setBackgroundDrawable(setEdgeColor(v2, v3));
                edge13.setBackgroundDrawable(setEdgeColor(v1, v3));
            }
        });

        check.setOnClickListener(v -> {
            MediaPlayer.create(context, R.raw.button_click_2).start();
            if (isNonEmpty(vertices) && minColor(3, vertices) && checkProperColor(v1, v2, v3) && checkProperColor(v2, v3)) {
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

    private void initView() {
        edge21 = view.findViewById(R.id.edge21);
        edge23 = view.findViewById(R.id.edge23);
        edge13 = view.findViewById(R.id.edge13);
        v1 = view.findViewById(R.id.v1);
        v2 = view.findViewById(R.id.v2);
        v3 = view.findViewById(R.id.v3);
        initColor_8();
        setDefColor(v1, v2, v3);
        setColorClick(colorSet);
    }
}