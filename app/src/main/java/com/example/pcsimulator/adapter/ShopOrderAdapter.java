package com.example.pcsimulator.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pcsimulator.R;
import com.example.pcsimulator.models.ShopOrder;
import com.example.pcsimulator.models.ShopOrderList;
import java.util.List;

public class ShopOrderAdapter extends RecyclerView.Adapter<ShopOrderAdapter.ShopOrderViewHolder> {
    
    Context context;
    List<ShopOrder> shopOrderList;
    private final ItemDeleteClickListener itemDeleteClickListener;

    public ShopOrderAdapter(Context context, List<ShopOrder> shopOrderList, ItemDeleteClickListener itemDeleteClickListener) {
        this.context = context;
        this.shopOrderList = shopOrderList;
        this.itemDeleteClickListener = itemDeleteClickListener;
    }

    @NonNull
    @Override
    public ShopOrderAdapter.ShopOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_order_item, parent, false);
        return new ShopOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopOrderAdapter.ShopOrderViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.shop_order_name.setText(shopOrderList.get(position).getName());
        holder.shop_order_price.setText(shopOrderList.get(position).getPrice() + " ₽");
        holder.shop_order_delete.setOnClickListener(view -> {
            itemDeleteClickListener.onDeleteClick(position);
            ShopOrderList.items_id.remove(shopOrderList.get(position).getId());
            shopOrderList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, shopOrderList.size());
        });
    }

    @Override
    public int getItemCount() {
        return shopOrderList.size();
    }
    
    public static final class ShopOrderViewHolder extends RecyclerView.ViewHolder{

        TextView shop_order_name;
        ImageButton shop_order_delete;
        TextView shop_order_price;
        public ShopOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            shop_order_price = itemView.findViewById(R.id.shop_order_price);
            shop_order_name = itemView.findViewById(R.id.shop_order_name);
            shop_order_delete = itemView.findViewById(R.id.shop_order_delete);
        }
    }

    public interface ItemDeleteClickListener {
        void onDeleteClick(int i);
    }
}
