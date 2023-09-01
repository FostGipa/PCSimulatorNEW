package com.example.pcsimulator.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pcsimulator.R;
import com.example.pcsimulator.models.ShopItem;
import java.util.List;

public class CreateSelectAdapter extends RecyclerView.Adapter<CreateSelectAdapter.CreateSelectViewHolder> {

    Context context;
    List<ShopItem> shopItemList;
    private final SelectItemClickListener onSelectItemClick;

    public CreateSelectAdapter(Context context, List<ShopItem> shopItemList, SelectItemClickListener onSelectItemClick) {
        this.context = context;
        this.shopItemList = shopItemList;
        this.onSelectItemClick = onSelectItemClick;
    }

    @NonNull
    @Override
    public CreateSelectAdapter.CreateSelectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.create_select_item, parent, false);
        return new CreateSelectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CreateSelectAdapter.CreateSelectViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.img.setImageResource(shopItemList.get(position).getImg());
        holder.name.setText(shopItemList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSelectItemClick.onSelectItemClick(shopItemList.get(position).getName(), shopItemList.get(position).getImg());
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopItemList.size();
    }

    public static final class CreateSelectViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name;
        public CreateSelectViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
        }
    }

    public interface SelectItemClickListener {
        void onSelectItemClick(String name, int img);
    }
}
