package com.example.pcsimulator.chat_fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.pcsimulator.ChatActivity;
import com.example.pcsimulator.R;

public class Chat1Fragment extends Fragment {

    SharedPreferences mSettings;
    String status;
    int total;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat1, container, false);

        mSettings = getActivity().getSharedPreferences("mysettings", Context.MODE_PRIVATE);

        RelativeLayout client_message1;
        client_message1 = view.findViewById(R.id.client_message1);
        RelativeLayout me_message1;
        me_message1 = view.findViewById(R.id.me_message1);
        ConstraintLayout client_message2;
        client_message2 = view.findViewById(R.id.client_message2);
        NestedScrollView nestedScrollView;
        nestedScrollView = view.findViewById(R.id.nestedScrollView);
        RelativeLayout buttons;
        buttons = view.findViewById(R.id.buttons);
        AppCompatButton chat_1_order_accept_btn;
        chat_1_order_accept_btn = view.findViewById(R.id.chat_1_order_accept_btn);
        AppCompatButton chat_1_order_deny_btn;
        chat_1_order_deny_btn = view.findViewById(R.id.chat_1_order_deny_btn);
        AppCompatButton chat_1_order_deliver_btn;
        chat_1_order_deliver_btn = view.findViewById(R.id.chat_1_order_deliver_btn);
        ConstraintLayout order2;
        order2 = getActivity().findViewById(R.id.chat_2_order);
        RelativeLayout chat_1_order_notify;
        chat_1_order_notify = getActivity().findViewById(R.id.chat_1_order_notify);

        chat_1_order_accept_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chat_1_order_accept_btn.setVisibility(View.GONE);
                chat_1_order_deliver_btn.setVisibility(View.VISIBLE);
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString("status1", "Accept");
                editor.apply();
            }
        });

        chat_1_order_deny_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DenyFragment denyFragment = new DenyFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.chat_container, denyFragment).commit();
            }
        });

        status = mSettings.getString("status1", "New");
        if (status.equals("New")) {
            Handler handler1 = new Handler();
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    client_message1.setVisibility(View.VISIBLE);
                }
            }, 2000);
            Handler handler2 = new Handler();
            handler2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    me_message1.setVisibility(View.VISIBLE);
                }
            }, 4000);
            Handler handler3 = new Handler();
            handler3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    client_message2.setVisibility(View.VISIBLE);
                    nestedScrollView.fullScroll(ScrollView.FOCUS_DOWN);
                }
            }, 6000);
            Handler handler5 = new Handler();
            handler5.postDelayed(new Runnable() {
                @Override
                public void run() {
                    buttons.setVisibility(View.VISIBLE);
                    nestedScrollView.fullScroll(ScrollView.FOCUS_DOWN);
                }
            }, 7000);
        } else if (status.equals("Accept")){
            client_message1.setVisibility(View.VISIBLE);
            me_message1.setVisibility(View.VISIBLE);
            client_message2.setVisibility(View.VISIBLE);
            buttons.setVisibility(View.VISIBLE);
            nestedScrollView.fullScroll(ScrollView.FOCUS_DOWN);
            chat_1_order_accept_btn.setVisibility(View.GONE);
            chat_1_order_deliver_btn.setVisibility(View.VISIBLE);
        } else {
            chat_1_order_notify.setVisibility(View.INVISIBLE);
            OrderCompletedFragment orderCompletedFragment = new OrderCompletedFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.chat_container, orderCompletedFragment).commit();
        }

        chat_1_order_deliver_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSettings.getString("selected_mb_name", "").equals("ASRock H310CM-DVS") &
                        mSettings.getString("selected_vd_name", "").equals("MSI GeForce GT 730") &
                        mSettings.getString("selected_case_name", "").equals("DEXP DC-201M") &
                        mSettings.getString("selected_ssd_name", "").equals("WD Blue SA510") &
                        mSettings.getString("selected_hdd_name", "").equals("WD Purple") &
                        mSettings.getString("selected_ram_name", "").equals("G.Skill RIPJAWS V") &
                        mSettings.getString("selected_bp_name", "").equals("Xilence Red Wings XN054 700W") &
                        mSettings.getString("selected_cooling_name", "").equals("DEEPCOOL AK400 WH") &
                        mSettings.getString("selected_cpu_name", "").equals("AMD A6-9500 OEM"))
                {
                    chat_1_order_notify.setVisibility(View.INVISIBLE);
                    DeliveryFragment deliveryFragment = new DeliveryFragment();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, deliveryFragment).commit();
                    Handler handler6 = new Handler();
                    handler6.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            OrderCompletedFragment orderCompletedFragment = new OrderCompletedFragment();
                            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.chat_container, orderCompletedFragment).commit();
                            order2.setVisibility(View.VISIBLE);
                            SharedPreferences.Editor editor = mSettings.edit();
                            editor.putString("orders", "2");
                            editor.putString("status1", "Complete");
                            total = mSettings.getInt("balance", 50000);
                            editor.putInt("balance", total + 39500);
                            editor.apply();
                        }
                    }, 5000);
                } else {
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }
}
