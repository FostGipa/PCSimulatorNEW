package com.example.pcsimulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.pcsimulator.adapter.ShopCategoryAdapter;
import com.example.pcsimulator.adapter.ShopItemAdapter;
import com.example.pcsimulator.models.ShopCategory;
import com.example.pcsimulator.models.ShopItem;
import com.example.pcsimulator.models.ShopItemList;
import com.example.pcsimulator.models.ShopOrderList;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity implements ShopItemAdapter.ItemClickListener {

    static List<ShopCategory> shopCategoryList = new ArrayList<>();
    RecyclerView shopCategoryRecycler;
    static RecyclerView shopItemRecycler;
    static List<ShopItem> fullCafeItemsList = new ArrayList<>();
    @SuppressLint("StaticFieldLeak")
    static ShopItemAdapter shopItemAdapter;
    static ShopItemList getShopItemList = new ShopItemList();
    static List<ShopItem> shopItemList = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
        setContentView(R.layout.activity_shop);

        ImageButton shop_back_btn;
        shop_back_btn = findViewById(R.id.shop_back_btn);
        shop_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        shopCategoryList.add(new ShopCategory(1, "Motherboard"));
        shopCategoryList.add(new ShopCategory(2, "CPU"));
        shopCategoryList.add(new ShopCategory(3, "RAM"));
        shopCategoryList.add(new ShopCategory(4, "Video-cards"));
        shopCategoryList.add(new ShopCategory(5, "Power Supply"));
        shopCategoryList.add(new ShopCategory(6, "PC Case"));
        shopCategoryList.add(new ShopCategory(7, "HDD"));
        shopCategoryList.add(new ShopCategory(8, "SSD"));
        shopCategoryList.add(new ShopCategory(9, "Cooling"));
        shopCategoryRecycler = findViewById(R.id.shop_category_recycler);
        shopCategoryRecycler.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));
        shopCategoryRecycler.setAdapter(new ShopCategoryAdapter(getBaseContext(), shopCategoryList));

        shopItemList.addAll(getShopItemList.getShopItemList());
        shopItemRecycler = findViewById(R.id.shop_item_recycler);
        shopItemRecycler.setLayoutManager(new GridLayoutManager(getBaseContext(), 3));
        fullCafeItemsList.addAll(shopItemList);
        shopItemAdapter = new ShopItemAdapter(getBaseContext(), shopItemList, this);
        shopItemRecycler.setAdapter(shopItemAdapter);

        Fragment fragment = ShopOrderFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.shop_container, fragment);
        transaction.commit();
    }

    @SuppressLint("NotifyDataSetChanged")
    public static void showItemByCategory(int category){
        shopItemList.clear();
        List<ShopItem> filterItems = new ArrayList<>();
        shopItemList.addAll(fullCafeItemsList);
        for(ShopItem i : shopItemList) {
            if (i.getCategory() == category) {
                filterItems.add(i);
            }
        }
        shopItemList.clear();
        shopItemList.addAll(filterItems);
        shopItemAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(ShopItem shopItem) {
        Fragment fragment = ShopInfoFragment.newInstance(shopItem.getName1(), shopItem.getProp1(), shopItem.getName2(), shopItem.getProp2(), shopItem.getName3(), shopItem.getProp3(), shopItem.getId(), shopItem.getPrice());
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.shop_container, fragment);
        transaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ShopOrderList.items_id.clear();
        shopItemList.clear();
        fullCafeItemsList.clear();
    }
}