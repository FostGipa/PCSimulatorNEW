package com.example.pcsimulator.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pcsimulator.R;
import com.example.pcsimulator.ShopActivity;
import com.example.pcsimulator.models.ShopCategory;

import java.util.List;

public class ShopCategoryAdapter extends RecyclerView.Adapter<ShopCategoryAdapter.ShopCategoryViewHolder> {

    Context context;
    List<ShopCategory> shopCategoryList;

    public ShopCategoryAdapter(Context context, List<ShopCategory> shopCategoryList) {
        this.context = context;
        this.shopCategoryList = shopCategoryList;
    }

    @NonNull
    @Override
    public ShopCategoryAdapter.ShopCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_category_item, parent, false);
        return new ShopCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopCategoryAdapter.ShopCategoryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.category_btn.setText(shopCategoryList.get(position).getName());
        holder.category_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopActivity.showItemByCategory(shopCategoryList.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopCategoryList.size();
    }

    public static final class ShopCategoryViewHolder extends RecyclerView.ViewHolder{

        Button category_btn;
        public ShopCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            category_btn = itemView.findViewById(R.id.category_btn);
        }
    }
}
