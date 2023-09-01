package com.example.pcsimulator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InventoryInfoFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";
    private String mParam3;
    private String mParam4;
    private static final String ARG_PARAM5 = "param5";
    private static final String ARG_PARAM6= "param6";
    private String mParam5;
    private String mParam6;
    private static final String ARG_PARAM7 = "param7";
    private int mParam7;
    private static final String ARG_PARAM8 = "param8";
    private String mParam8;


    public InventoryInfoFragment() {

    }

    public static InventoryInfoFragment newInstance(String param1, String param2, String param3, String param4, String param5, String param6, int param7, String param8) {
        InventoryInfoFragment fragment = new InventoryInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        args.putString(ARG_PARAM4, param4);
        args.putString(ARG_PARAM5, param5);
        args.putString(ARG_PARAM6, param6);
        args.putInt(ARG_PARAM7, param7);
        args.putString(ARG_PARAM8, param8);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
            mParam5 = getArguments().getString(ARG_PARAM5);
            mParam6 = getArguments().getString(ARG_PARAM6);
            mParam7 = getArguments().getInt(ARG_PARAM7);
            mParam8 = getArguments().getString(ARG_PARAM8);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventory_info, container, false);

        TextView name1_text;
        TextView prop1_text;
        TextView name2_text;
        TextView prop2_text;
        TextView name3_text;
        TextView prop3_text;
        TextView buy_price;
        TextView sell_price;

        name1_text = view.findViewById(R.id.name1);
        prop1_text = view.findViewById(R.id.prop1);
        name2_text = view.findViewById(R.id.name2);
        prop2_text = view.findViewById(R.id.prop2);
        name3_text = view.findViewById(R.id.name3);
        prop3_text = view.findViewById(R.id.prop3);
        buy_price = view.findViewById(R.id.buy_price);
        sell_price = view.findViewById(R.id.sell_price);

        name1_text.setText(mParam1);
        prop1_text.setText(mParam2);
        name2_text.setText(mParam3);
        prop2_text.setText(mParam4);
        name3_text.setText(mParam5);
        prop3_text.setText(mParam6);
        buy_price.setText(mParam8);
        double sell_price_db;
        sell_price_db = Double.parseDouble(mParam8) * 0.8;
        sell_price.setText(String.valueOf(sell_price_db));
        return view;
    }
}