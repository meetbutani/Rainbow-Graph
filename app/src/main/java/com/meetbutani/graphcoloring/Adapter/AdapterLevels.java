package com.meetbutani.graphcoloring.Adapter;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.meetbutani.graphcoloring.Model.ModelLevel;
import com.meetbutani.graphcoloring.R;

import java.util.ArrayList;

public class AdapterLevels extends RecyclerView.Adapter<AdapterLevels.ViewHolder> {

    private final FragmentActivity context;
    private final ArrayList<ModelLevel> levelList;

    protected SharedPreferences readSP;
    protected SharedPreferences editorSP;
    protected SharedPreferences.Editor editSP;

    public AdapterLevels(FragmentActivity context, ArrayList<ModelLevel> levelList) {
        this.context = context;
        this.levelList = levelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_levels, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.level.setText(levelList.get(position).label);
//        holder.level.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.button_background));
    }

    @Override
    public int getItemCount() {
        return levelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView level;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            level = itemView.findViewById(R.id.level);
            level.setOnClickListener(v -> {

                MediaPlayer.create(context, R.raw.button_click_2).start();
                int position = this.getAdapterPosition();

//                this.setFragment(levelList.get(position));
                if (getLevelStatus("Level " + (position + 1)).equalsIgnoreCase("complete") || position == 0) {
                    this.setFragment(levelList.get(position));
                }else {
                    Toast.makeText(context, "Other level are remaining to complete", Toast.LENGTH_SHORT).show();
                }

//            Toast.makeText(context, position + "", Toast.LENGTH_SHORT).show();
            });

        }

        @Override
        public void onClick(View view) {

        }

        private void setFragment(ModelLevel level) {
            context.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainFrame, level.fragment, level.label)
                    .addToBackStack(level.label)
                    .commit();
        }

        protected void setLevelStatus(String key) {
            editorSP = context.getSharedPreferences("levelData", MODE_PRIVATE);
            editSP = editorSP.edit();
            editSP.putString(key, "complete").commit();
        }

        protected String getLevelStatus(String key) {
            readSP = context.getSharedPreferences("levelData", MODE_PRIVATE);
            return readSP.getString(key, "null");
        }
    }
}
