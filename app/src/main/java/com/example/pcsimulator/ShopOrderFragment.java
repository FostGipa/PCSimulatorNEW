package com.example.pcsimulator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.pcsimulator.adapter.ShopOrderAdapter;
import com.example.pcsimulator.models.ShopItem;
import com.example.pcsimulator.models.ShopItemList;
import com.example.pcsimulator.models.ShopOrder;
import com.example.pcsimulator.models.ShopOrderList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShopOrderFragment extends Fragment implements ShopOrderAdapter.ItemDeleteClickListener {

    RecyclerView shop_order_recycler;
    List<ShopOrder> shopItemList = new ArrayList<>();
    int total;
    Button shop_buy_btn;
    ShopOrderAdapter shopOrderAdapter;
    SharedPreferences mSettings;
    public ShopOrderFragment() {

    }

    public static ShopOrderFragment newInstance() {
        return new ShopOrderFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop_order, container, false);

        mSettings = getActivity().getSharedPreferences("mysettings", Context.MODE_PRIVATE);

        ShopItemList shopItemList1 = new ShopItemList();
        for (ShopItem shopItem : shopItemList1.getShopItemList()) {
            if (ShopOrderList.items_id.contains(shopItem.getId())){
                shopItemList.add(new ShopOrder(shopItem.getId(), shopItem.getName(), shopItem.getPrice(), shopItem.getImg()));
            }
        }

        shop_buy_btn = view.findViewById(R.id.shop_buy_btn);
        for (int i = 0; i < shopItemList.size(); i++) {
            total += Integer.parseInt(shopItemList.get(i).getPrice());
            shop_buy_btn.setText(total + " | Buy");
        }

        shop_order_recycler = view.findViewById(R.id.shop_order_recycler);
        shop_order_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        shopOrderAdapter = new ShopOrderAdapter(getContext(), shopItemList, this);
        shop_order_recycler.setAdapter(shopOrderAdapter);

        TextView shop_balance;
        shop_balance = view.findViewById(R.id.shop_balance);
        shop_balance.setText(String.valueOf(mSettings.getInt("balance", 50000)));

        shop_buy_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                if (mSettings.getInt("balance", 50000) >= total) {
                    shop_balance.setText(String.valueOf(mSettings.getInt("balance", 50000)));
                    Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();

                    Set<Integer> items_id1 = new HashSet<>(Set.of(0));
                    SharedPreferences.Editor editor = mSettings.edit();
                    Gson gson = new Gson();
                    String json = mSettings.getString("inventoryList", null);
                    Type type = new TypeToken<Set<Integer>>() {}.getType();
                    items_id1 = gson.fromJson(json, type);
                    Log.e("123", ":" + json);
                    if (json == null){
                        String json1 = gson.toJson(ShopOrderList.items_id);
                        editor.putString("inventoryList", json1);
                        editor.apply();
                    } else {
                        items_id1.addAll(ShopOrderList.items_id);
                        String json1 = gson.toJson(items_id1);
                        editor.putString("inventoryList", json1);
                        editor.apply();
                    }
                    editor.putInt("balance", mSettings.getInt("balance", 50000) - total);
                    editor.putString("first_buy", "no");
                    editor.apply();
                    shopItemList.clear();
                    shopOrderAdapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(getContext(), "Not enough money", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onDeleteClick(int i) {
        total -= Integer.parseInt(shopItemList.get(i).getPrice());
        shop_buy_btn.setText(total + " | Buy");

    }
}