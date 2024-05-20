package com.meetbutani.graphcoloring;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    View layout;
    private long backPressedTime;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setSupportActionBar(findViewById(R.id.tbMainActivity));

        setFragment(new SplashFragment(), "SplashFragment");

    }

    protected void setFragment(Fragment fragment, String FragTitle) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFrame, fragment, FragTitle)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {

        Fragment fragment = getSupportFragmentManager().findFragmentByTag("LevelsFragment");

        if (fragment instanceof LevelsFragment && fragment.isVisible()) {
            if (backPressedTime + 2000 > System.currentTimeMillis()) {
                toast.cancel();
                super.onBackPressed();
                super.onBackPressed();
                super.onBackPressed();
            } else {
                toast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
                toast.show();
            }
            backPressedTime = System.currentTimeMillis();
        } else super.onBackPressed();

    }

}