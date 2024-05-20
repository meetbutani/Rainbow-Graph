package com.meetbutani.graphcoloring;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.Position;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class BaseFragment extends Fragment {

    protected View view;
    protected Context context;
    protected TextView col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14, col15, col16;
    protected int selectedCol = 0;
    protected TextView check;
    protected ImageView status;
    protected ArrayList<TextView> vertices;
    protected ArrayList<String> harmoniousPair;
    protected HashMap<TextView, Integer> colorSet;

    protected SharedPreferences editorSP;
    protected SharedPreferences readSP;
    protected SharedPreferences.Editor editSP;

    protected void initColor_4() {
        check = view.findViewById(R.id.check);
        status = view.findViewById(R.id.status);
        col1 = view.findViewById(R.id.col1);
        col2 = view.findViewById(R.id.col2);
        col3 = view.findViewById(R.id.col3);
        col4 = view.findViewById(R.id.col4);

        colorSet = new HashMap<>();

        colorSet.put(col1, R.color.col1);
        colorSet.put(col2, R.color.col2);
        colorSet.put(col3, R.color.col3);
        colorSet.put(col4, R.color.col4);

//        colorSet.put(col1, R.color.Red);
//        colorSet.put(col2, R.color.Orange);
//        colorSet.put(col3, R.color.Amber);
//        colorSet.put(col4, R.color.Yellow);
    }

    protected void initColor_8() {
        initColor_4();
        col5 = view.findViewById(R.id.col5);
        col6 = view.findViewById(R.id.col6);
        col7 = view.findViewById(R.id.col7);
        col8 = view.findViewById(R.id.col8);

        colorSet.put(col5, R.color.col5);
        colorSet.put(col6, R.color.col6);
        colorSet.put(col7, R.color.col7);
        colorSet.put(col8, R.color.col8);

//        colorSet.put(col5, R.color.Green);
//        colorSet.put(col6, R.color.LightGreen);
//        colorSet.put(col7, R.color.DarkGreen);
//        colorSet.put(col8, R.color.LightYellow);
    }

    protected void initColor_12() {
        initColor_8();
        col9 = view.findViewById(R.id.col9);
        col10 = view.findViewById(R.id.col10);
        col11 = view.findViewById(R.id.col11);
        col12 = view.findViewById(R.id.col12);

        colorSet.put(col9, R.color.col9);
        colorSet.put(col10, R.color.col10);
        colorSet.put(col11, R.color.col11);
        colorSet.put(col12, R.color.col12);

//        colorSet.put(col9, R.color.Blue);
//        colorSet.put(col10, R.color.Mauve);
//        colorSet.put(col11, R.color.Cyan);
//        colorSet.put(col12, R.color.LightBlue);
    }

    protected void initColor_16() {
        initColor_12();
        col13 = view.findViewById(R.id.col13);
        col14 = view.findViewById(R.id.col14);
        col15 = view.findViewById(R.id.col15);
        col16 = view.findViewById(R.id.col16);

        colorSet.put(col13, R.color.col13);
        colorSet.put(col14, R.color.col14);
        colorSet.put(col15, R.color.col15);
        colorSet.put(col16, R.color.col16);

//        colorSet.put(col13, R.color.DarkPurple);
//        colorSet.put(col14, R.color.DarkBlue);
//        colorSet.put(col15, R.color.DarkMint);
//        colorSet.put(col16, R.color.DarkBrown);
    }

    protected void setColorClick(HashMap<TextView, Integer> colorSet) {
        for (TextView col : colorSet.keySet()) {
            col.setBackgroundTintList(ContextCompat.getColorStateList(context, colorSet.get(col)));
            col.setOnClickListener(v -> {
                selectedCol = colorSet.get(col);
                setBackground(col, colorSet.keySet());
            });
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    protected void setDefColor(TextView... vertices) {
        check.setBackground(context.getDrawable(R.drawable.button_background));
        this.vertices = new ArrayList<>();
        for (TextView vertex : vertices) {
            vertex.setHintTextColor(getResources().getColor(R.color.Def));
            this.vertices.add(vertex);
        }
    }

    protected void changeColor(TextView view) {
        view.getBackground().setTint(getResources().getColor(selectedCol));
        view.setHintTextColor(getResources().getColor(selectedCol));
    }

    protected void setBackground(TextView selected, Set<TextView> unselected) {
        selected.setBackgroundResource(R.drawable.round);

        unselected = new HashSet<>(unselected);
        unselected.remove(selected);

        for (TextView item : unselected) {
            item.setBackgroundResource(R.drawable.round_border);
        }
    }

    protected Boolean checkProperColor(TextView main, TextView... vertices) {
        for (TextView vertex : vertices) {
            if (main.getCurrentHintTextColor() == vertex.getCurrentHintTextColor())
                return false;
        }
        return true;
    }

    protected Boolean checkHarmoniousColor(TextView main, TextView... vertices) {

//        harmoniousPair = new ArrayList<>();

        for (TextView vertex : vertices) {
            int colm = main.getCurrentHintTextColor();
            int colver = vertex.getCurrentHintTextColor();
            if (colm == colver || harmoniousPair.contains(colm + "" + colver))
                return false;
            else {
                harmoniousPair.add(colm + "" + colver);
            }
        }

        return true;
    }

    protected boolean minColor(Integer minColor, ArrayList<TextView> vertices) {

        ArrayList<Integer> colors = new ArrayList<>();

        for (TextView vertex : vertices) {
            if (!colors.contains(vertex.getCurrentHintTextColor()))
                colors.add(vertex.getCurrentHintTextColor());
        }

        return minColor >= colors.size();
    }

    protected Boolean isNonEmpty(ArrayList<TextView> vertices) {

        harmoniousPair = new ArrayList<>();

        for (TextView vertex : vertices) {
            if (vertex.getCurrentHintTextColor() == getResources().getColor(R.color.Def))
                return false;
        }
        return true;
    }

    protected GradientDrawable setEdgeColor(TextView Top, TextView Bottom) {

        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{Top.getCurrentHintTextColor(), Bottom.getCurrentHintTextColor()});
        gd.setCornerRadius(0f);

        return gd;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    protected Drawable setCurveEdgeColor(TextView Top, TextView Bottom) {

        final ContextThemeWrapper wrapper = new ContextThemeWrapper(context,
                context.getResources().getIdentifier("S_" + String.valueOf(Top.getCurrentHintTextColor()).replace("-", "") + "_" + String.valueOf(Bottom.getCurrentHintTextColor()).replace("-", ""), "style", context.getPackageName()));
        Log.d("Nothing", "setCurveEdgeColor: " + "S_" + String.valueOf(Top.getCurrentHintTextColor()).replace("-", "") + "_" + String.valueOf(Bottom.getCurrentHintTextColor()).replace("-", ""));
        final Drawable drawable = VectorDrawableCompat.create(getResources(), R.drawable.ic_halfcircle, wrapper.getTheme());

        return drawable;
//        return VectorDrawableCompat.create(getResources(), R.drawable.ic_curve_line_1,
//                new ContextThemeWrapper(context,
//                        context.getResources().getIdentifier("S_"+Top.getCurrentHintTextColor()+Bottom.getCurrentHintTextColor(), "res", context.getPackageName())).getTheme());
    }

    protected GradientDrawable setHorEdgeColor(TextView Top, TextView Bottom) {

        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.LEFT_RIGHT,
                new int[]{Top.getCurrentHintTextColor(), Bottom.getCurrentHintTextColor()});
        gd.setCornerRadius(0f);

        return gd;
    }

    protected void dialog(Context context, String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setMessage(message).create().show();
    }


    @SuppressLint("ResourceType")
    protected void genarateColorCombination() {
        initColor_16();
        ArrayList<String> cole = new ArrayList<>();
        String code = "";
        for (TextView col : colorSet.keySet()) {
            col.setHintTextColor(colorSet.get(col));
            code = "";
            for (TextView col2 : colorSet.keySet()) {
                col2.setHintTextColor(colorSet.get(col2));
                cole.add(col.getCurrentHintTextColor() + "_" + col2.getCurrentHintTextColor());
                code += "    <style name=\"S_" + String.valueOf(getResources().getColor(col.getCurrentHintTextColor())).replace("-", "") + "_" + String.valueOf(getResources().getColor(col2.getCurrentHintTextColor())).replace("-", "") + "\">\n" +
                        "        <item name=\"startColor\">" + String.format("#FF%06X", (0xFFFFFF & getResources().getColor(colorSet.get(col)))) + "</item>\n" +
                        "        <item name=\"endColor\">" + String.format("#FF%06X", (0xFFFFFF & getResources().getColor(colorSet.get(col2)))) + "</item>\n" +
                        "    </style>\n";
            }
            Log.d("Style_Names", "onCreateView: " + code);
        }


//        HashMap<TextView, String> colorSet2 = new HashMap<>();
//        colorSet2.put(col1, "col1");
//        colorSet2.put(col2, "col2");
//        colorSet2.put(col3, "col3");
//        colorSet2.put(col4, "col4");
//        colorSet2.put(col5, "col5");
//        colorSet2.put(col6, "col6");
//        colorSet2.put(col7, "col7");
//        colorSet2.put(col8, "col8");
//        colorSet2.put(col9, "col9");
//        colorSet2.put(col10, "col10");
//        colorSet2.put(col11, "col11");
//        colorSet2.put(col12, "col12");
//        colorSet2.put(col13, "col13");
//        colorSet2.put(col14, "col14");
//        colorSet2.put(col15, "col15");
//        colorSet2.put(col16, "col16");
//        colorSet2.put(v1, "Def");
//        colorSet.put(v1, R.color.Def);
//
//        ArrayList<String> cole = new ArrayList<>();
//        String code = "";
//        for (TextView col : colorSet.keySet()) {
//            col.setHintTextColor(colorSet.get(col));
//            code = "";
//            for (TextView col2 : colorSet.keySet()) {
//                col2.setHintTextColor(colorSet.get(col2));
//                cole.add(col.getCurrentHintTextColor() + "_" + col2.getCurrentHintTextColor());
//                code += "    <style name=\"S_" + String.valueOf(getResources().getColor(col.getCurrentHintTextColor())).replace("-", "") + "_" + String.valueOf(getResources().getColor(col2.getCurrentHintTextColor())).replace("-", "") + "\">\n" +
//                        "        <item name=\"startColor\">@color/" + colorSet2.get(col) + "</item>\n" +
//                        "        <item name=\"endColor\">@color/" + colorSet2.get(col2) + "</item>\n" +
//                        "    </style>\n";
//            }
//            Log.d("Style_Names", "onCreateView: " + code);
//        }
    }

    protected void levelComplete(int level, Fragment nextLevelFragment, String label) {

        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_complete);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView svgComplet = dialog.findViewById(R.id.svgComplet);
        TextView tvNext = dialog.findViewById(R.id.tvNext);

        svgComplet.setText("Level " + level);

        tvNext.setOnClickListener(v -> {
            MediaPlayer.create(context, R.raw.button_click_2).start();
            dialog.dismiss();
            requireActivity().getSupportFragmentManager().popBackStack("Level " + level, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            setFragment(nextLevelFragment, label);
//            Toast.makeText(context, "Next clicked", Toast.LENGTH_SHORT).show();
        });

        MediaPlayer.create(context, R.raw.level_complete).start();
        dialog.show();

        setLevelStatus("Level " + (level + 1));

        Shape.DrawableShape drawableShape = new Shape.DrawableShape(Objects.requireNonNull(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.ic_heart)), true);
        KonfettiView konfettiView = view.findViewById(R.id.konfettiView);
        EmitterConfig emitterConfig = new Emitter(150L, TimeUnit.MILLISECONDS).max(150);
        konfettiView.start(
                new PartyFactory(emitterConfig)
                        .spread(360)
                        .shapes(Arrays.asList(Shape.Square.INSTANCE, Shape.Circle.INSTANCE, drawableShape))
                        .colors(Arrays.asList(0xfce18a, 0xff726d, 0xf4306d, 0xb48def))
                        .setSpeedBetween(0f, 30f)
                        .position(new Position.Relative(0.5, 0.3))
                        .build()
        );
    }


    protected void levelFailed(int level, Fragment currentLevelFragment, String label) {

        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_failed);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView svgComplet = dialog.findViewById(R.id.svgComplet);
        TextView retry = dialog.findViewById(R.id.retry);

        svgComplet.setText("Level " + level);

        retry.setOnClickListener(v -> {
            MediaPlayer.create(context, R.raw.button_click_2).start();
            dialog.dismiss();
            requireActivity().getSupportFragmentManager().popBackStack("Level " + level, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            setFragment(currentLevelFragment, label);
//            Toast.makeText(context, "Next clicked", Toast.LENGTH_SHORT).show();
        });

        MediaPlayer.create(context, R.raw.level_failed).start();
        dialog.show();
    }

    protected void setFragment(Fragment fragment, String label) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFrame, fragment, label)
                .addToBackStack(label)
                .commit();
    }

    private void readSP() {
        readSP = requireContext().getSharedPreferences("levelData", MODE_PRIVATE);
    }

    private void editSP() {
        editorSP = requireContext().getSharedPreferences("levelData", MODE_PRIVATE);
        editSP = editorSP.edit();
    }

    protected String getLevelStatus(String key) {
        readSP();
        return readSP.getString(key, "null");
    }

    protected void setLevelStatus(String key) {
        editSP();
        editSP.putString(key, "complete").commit();
    }


}
