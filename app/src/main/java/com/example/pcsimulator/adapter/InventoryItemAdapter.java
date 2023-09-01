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

public class InventoryItemAdapter extends RecyclerView.Adapter<InventoryItemAdapter.InventoryViewHolder> {

    Context context;
    List<ShopItem> shopItemList;
    private final ItemClickListener clickListener;
    private final ItemSellClickListener sellclickListener;
    double sell_balance;

    public InventoryItemAdapter(Context context, List<ShopItem> shopItemList, ItemClickListener clickListener, ItemSellClickListener sellclickListener) {
        this.context = context;
        this.shopItemList = shopItemList;
        this.clickListener = clickListener;
        this.sellclickListener = sellclickListener;
    }

    @NonNull
    @Override
    public InventoryItemAdapter.InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.inventory_item, parent, false);
        return new InventoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryItemAdapter.InventoryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(shopItemList.get(position).getName());
        holder.price.setText(shopItemList.get(position).getPrice());
        holder.img.setImageResource(shopItemList.get(position).getImg());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopItem shopItem = shopItemList.get(position);
                clickListener.onItemClick(shopItem);
            }
        });
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopItem shopItem = shopItemList.get(position);
                clickListener.onItemClick(shopItem);
            }
        });
        holder.price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopItem shopItem = shopItemList.get(position);
                clickListener.onItemClick(shopItem);
            }
        });
        holder.sell_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                sell_balance = Double.parseDouble(shopItemList.get(position).getPrice()) * 0.8;
                sellclickListener.onSellItemClick(sell_balance, shopItemList.get(position).getId());
                shopItemList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, shopItemList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopItemList.size();
    }

    public static final class InventoryViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView price;
        ConstraintLayout sell_btn;
        ImageView img;
        public InventoryViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.inventory_item_name);
            price = itemView.findViewById(R.id.inventory_item_price);
            sell_btn = itemView.findViewById(R.id.inventory_item_sell);
            img = itemView.findViewById(R.id.inventory_item_img);
        }
    }

    public interface ItemClickListener {
        void onItemClick(ShopItem shopItem);
    }

    public interface ItemSellClickListener {
        void onSellItemClick(double i, int position);
    }
}
