package com.meetbutani.graphcoloring.Model;

import androidx.fragment.app.Fragment;

import java.io.Serializable;

public class ModelLevel implements Serializable {

    public String label;
    public Fragment fragment;

    public ModelLevel() {
    }

    public ModelLevel(Fragment fragment, String label) {
        this.fragment = fragment;
        this.label = label;
    }
}
