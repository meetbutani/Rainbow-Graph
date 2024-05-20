package com.meetbutani.graphcoloring.DisplayProducts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.meetbutani.graphcoloring.R;

import java.util.ArrayList;

public class AdapterDisplayProducts extends RecyclerView.Adapter<AdapterDisplayProducts.ViewHolder> {

    Context context;
    ArrayList<ModelProductDetails> dataListDisplayProducts;

    public AdapterDisplayProducts(Context context, ArrayList<ModelProductDetails> dataListDisplayProducts) {
        this.context = context;
        this.dataListDisplayProducts = dataListDisplayProducts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_levels, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvDisplayProductName.setText(dataListDisplayProducts.get(position).Pro_Name);
        holder.tvDisplayProductPrice.setText(dataListDisplayProducts.get(position).Pro_Price);
    }

    @Override
    public int getItemCount() {
        return dataListDisplayProducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvDisplayProductName, tvDisplayProductPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            tvDisplayProductName = itemView.findViewById(R.id.tvDisplayProductName);
//            tvDisplayProductPrice = itemView.findViewById(R.id.tvDisplayProductPrice);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent intent = new Intent(context, ProductDetailsActivity.class);
//                    intent.putExtra("modelProductDetails", dataListDisplayProducts.get(getAdapterPosition()));
//                    context.startActivity(intent);
                }
            });
        }
    }
}
