package com.example.pcsimulator.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pcsimulator.R;
import com.example.pcsimulator.models.ShopItem;

import java.util.List;

public class ShopItemAdapter extends RecyclerView.Adapter<ShopItemAdapter.ShopItemViewHolder> {

    Context context;
    List<ShopItem> shopItemList;
    private final ItemClickListener clickListener;


    public ShopItemAdapter(Context context, List<ShopItem> shopItemList, ItemClickListener clickListener) {
        this.context = context;
        this.shopItemList = shopItemList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ShopItemAdapter.ShopItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_item_item, parent, false);
        return new ShopItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.shop_item_img.setImageResource(shopItemList.get(position).getImg());
        holder.shop_item_name.setText(shopItemList.get(position).getName());
        holder.shop_item_price.setText(shopItemList.get(position).getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopItem shopItem = shopItemList.get(position);
                clickListener.onItemClick(shopItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopItemList.size();
    }

    public static final class ShopItemViewHolder extends RecyclerView.ViewHolder{

        ImageView shop_item_img;
        TextView shop_item_name;
        TextView shop_item_price;
        ConstraintLayout shop_item_add;

        public ShopItemViewHolder(@NonNull View itemView) {
            super(itemView);
            shop_item_img = itemView.findViewById(R.id.shop_item_img);
            shop_item_name = itemView.findViewById(R.id.shop_item_name);
            shop_item_price = itemView.findViewById(R.id.shop_item_price);
            shop_item_add = itemView.findViewById(R.id.shop_item_add);
        }
    }

    public interface ItemClickListener {
        void onItemClick(ShopItem shopItem);
    }
}
