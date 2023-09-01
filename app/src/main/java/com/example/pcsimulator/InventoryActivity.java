package com.example.pcsimulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pcsimulator.adapter.InventoryItemAdapter;
import com.example.pcsimulator.models.ShopItem;
import com.example.pcsimulator.models.ShopItemList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InventoryActivity extends AppCompatActivity implements InventoryItemAdapter.ItemClickListener, InventoryItemAdapter.ItemSellClickListener{


    RecyclerView inventoryRecycler;
    InventoryItemAdapter inventoryItemAdapter;
    List<ShopItem> shopItemList = new ArrayList<>();
    SharedPreferences mSettings;
    double sell_balance;
    TextView inventory_money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
        setContentView(R.layout.activity_inventory);

        mSettings = getSharedPreferences("mysettings", Context.MODE_PRIVATE);

        ImageButton inventory_back_btn;
        inventory_back_btn = findViewById(R.id.inventory_back_btn);
        inventory_back_btn.setOnClickListener(view -> onBackPressed());

        inventory_money = findViewById(R.id.inventory_money);
        inventory_money.setText(String.valueOf(mSettings.getInt("balance", 50000)));

        ShopItemList shopItemList1 = new ShopItemList();
        Set<Integer> items_id = new HashSet<>();
        Gson gson = new Gson();
        String json = mSettings.getString("inventoryList", null);
        Type type = new TypeToken<Set<Integer>>() {}.getType();
        items_id = gson.fromJson(json, type);
        Log.e("123", ":" + items_id);
        for (ShopItem shopItem : shopItemList1.getShopItemList()) {
            if (items_id.contains(shopItem.getId())){
                shopItemList.add(new ShopItem(shopItem.getId(), shopItem.getCategory(), shopItem.getName(), shopItem.getPrice(), shopItem.getImg(), shopItem.getName1(), shopItem.getProp1(), shopItem.getName2(), shopItem.getProp2(), shopItem.getName3(), shopItem.getProp3()));
            }
        }
        inventoryRecycler = findViewById(R.id.inventory_recycler);
        inventoryRecycler.setLayoutManager(new GridLayoutManager(getBaseContext(), 3));

    }

    @Override
    public void onItemClick(ShopItem shopItem) {
        Fragment fragment = InventoryInfoFragment.newInstance(shopItem.getName1(), shopItem.getProp1(), shopItem.getName2(), shopItem.getProp2(), shopItem.getName3(), shopItem.getProp3(), shopItem.getId(), shopItem.getPrice());
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.inventory_container, fragment);
        transaction.commit();
    }

    @Override
    public void onSellItemClick(double i, int position) {
        Set<Integer> items_id = new HashSet<>();
        SharedPreferences.Editor editor = mSettings.edit();
        Gson gson = new Gson();
        String json = mSettings.getString("inventoryList", null);
        Type type = new TypeToken<Set<Integer>>() {}.getType();
        items_id = gson.fromJson(json, type);
        items_id.remove(position);
        String json1 = gson.toJson(items_id);
        editor.putString("inventoryList", json1);
        sell_balance = mSettings.getInt("balance", 50000) + i;
        inventory_money.setText(String.valueOf(sell_balance));
        editor.putInt("balance", (int) sell_balance);
        editor.apply();
        Fragment fragment = new TransparentFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.inventory_container, fragment);
        transaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        inventoryItemAdapter = new InventoryItemAdapter(getBaseContext(), shopItemList, this, this);
        inventoryRecycler.setAdapter(inventoryItemAdapter);
    }
}