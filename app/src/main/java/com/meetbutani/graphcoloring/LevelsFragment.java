package com.meetbutani.graphcoloring;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.meetbutani.graphcoloring.Adapter.AdapterLevels;
import com.meetbutani.graphcoloring.Model.ModelLevel;

import java.util.ArrayList;


public class LevelsFragment extends Fragment {

    View view;
    Context context;
    private RecyclerView rvLevels;

    private ArrayList<ModelLevel> levelList;
    private AdapterLevels adapterLevels;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_levels, container, false);
        initView();
        context = getContext();

        displayLevels();
        return view;
    }

    @SuppressLint("NotifyDataSetChanged")
    private void displayLevels() {
        try {
            rvLevels.setHasFixedSize(true);

            levelList = new ArrayList<>();
            adapterLevels = new AdapterLevels(getActivity(), levelList);
            rvLevels.setAdapter(adapterLevels);

            levelList.add(new ModelLevel(new Level_01_Fragment(), "Level 1"));
            levelList.add(new ModelLevel(new Level_02_Fragment(), "Level 2"));
            levelList.add(new ModelLevel(new Level_03_Fragment(), "Level 3"));
            levelList.add(new ModelLevel(new Level_04_Fragment(), "Level 4"));
            levelList.add(new ModelLevel(new Level_05_Fragment(), "Level 5"));
            levelList.add(new ModelLevel(new Level_06_Fragment(), "Level 6"));
            levelList.add(new ModelLevel(new Level_07_Fragment(), "Level 7"));
            levelList.add(new ModelLevel(new Level_08_Fragment(), "Level 8"));
            levelList.add(new ModelLevel(new Level_09_Fragment(), "Level 9"));
            levelList.add(new ModelLevel(new Level_10_Fragment(), "Level 10"));
            levelList.add(new ModelLevel(new Level_11_Fragment(), "Level 11"));
            levelList.add(new ModelLevel(new Level_12_Fragment(), "Level 12"));
            levelList.add(new ModelLevel(new Level_13_Fragment(), "Level 13"));
            levelList.add(new ModelLevel(new Level_14_Fragment(), "Level 14"));
            levelList.add(new ModelLevel(new Level_15_Fragment(), "Level 15"));
            levelList.add(new ModelLevel(new Level_16_Fragment(), "Level 16"));
            levelList.add(new ModelLevel(new Level_17_Fragment(), "Level 17"));
            levelList.add(new ModelLevel(new Level_18_Fragment(), "Level 18"));
            levelList.add(new ModelLevel(new Level_19_Fragment(), "Level 19"));
//            levelList.add(new ModelLevel(new last3_Fragment(), "Level 6"));

            adapterLevels.notifyDataSetChanged();

        }catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        rvLevels = view.findViewById(R.id.rvLevels);
    }
}