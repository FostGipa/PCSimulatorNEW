package com.example.pcsimulator.create_fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.pcsimulator.CreateActivity;
import com.example.pcsimulator.R;
import com.example.pcsimulator.TransparentFragment;
import com.example.pcsimulator.adapter.CreateSelectAdapter;
import com.example.pcsimulator.models.ShopItem;
import com.example.pcsimulator.models.ShopItemList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SSDSelectFragment extends Fragment implements CreateSelectAdapter.SelectItemClickListener{

    private static final String ARG_PARAM1 = "param1";

    private int mParam1;
    SharedPreferences mSettings;
    RecyclerView create_select_recycler;
    List<ShopItem> shopItemList = new ArrayList<>();

    public SSDSelectFragment() {

    }

    public static SSDSelectFragment newInstance(int param1) {
        SSDSelectFragment fragment = new SSDSelectFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_select, container, false);

        mSettings = getActivity().getSharedPreferences("mysettings", Context.MODE_PRIVATE);

        ImageButton create_info_close_btn;
        create_info_close_btn = view.findViewById(R.id.create_info_close_btn);
        create_info_close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new TransparentFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.create_container, fragment);
                transaction.commit();
            }
        });

        ShopItemList shopItemList1 = new ShopItemList();
        Set<Integer> items_id = new HashSet<>();
        Gson gson = new Gson();
        String json = mSettings.getString("inventoryList", null);
        Type type = new TypeToken<Set<Integer>>() {}.getType();
        items_id = gson.fromJson(json, type);
        for (ShopItem shopItem : shopItemList1.getShopItemList()) {
            if (items_id.contains(shopItem.getId())){
                if (shopItem.getCategory() == 8) {
                    shopItemList.add(new ShopItem(shopItem.getId(), shopItem.getCategory(), shopItem.getName(), shopItem.getPrice(), shopItem.getImg(), shopItem.getName1(), shopItem.getProp1(), shopItem.getName2(), shopItem.getProp2(), shopItem.getName3(), shopItem.getProp3()));
                }
            }
        }

        create_select_recycler = view.findViewById(R.id.create_select_recycler);
        create_select_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        create_select_recycler.setAdapter(new CreateSelectAdapter(getContext(), shopItemList, this));
        return view;
    }

    @Override
    public void onSelectItemClick(String name, int img) {
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString("ssd_name", name);
        editor.putInt("ssd_img", img);
        editor.apply();
        getActivity().finish();
        Intent intent = new Intent(getActivity(), CreateActivity.class);
        startActivity(intent);
    }
}