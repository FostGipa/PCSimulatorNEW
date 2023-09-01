package com.example.pcsimulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.pcsimulator.chat_fragments.Chat1Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pcsimulator.chat_fragments.Chat1Fragment;
import com.example.pcsimulator.chat_fragments.Chat2Fragment;
import com.example.pcsimulator.chat_fragments.Chat3Fragment;
import com.example.pcsimulator.chat_fragments.Chat4Fragment;

public class ChatActivity extends AppCompatActivity {

    SharedPreferences mSettings;
    String orders_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
        setContentView(R.layout.activity_chat);

        mSettings = getSharedPreferences("mysettings", Context.MODE_PRIVATE);

        ImageButton chat_back_btn;
        chat_back_btn = findViewById(R.id.chat_back_btn);
        chat_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        TextView chat_to_name;
        chat_to_name = findViewById(R.id.chat_to_name);

        TextView chat_1_order_name;
        chat_1_order_name = findViewById(R.id.chat_1_order_name);
        ConstraintLayout chat_1_order;
        chat_1_order = findViewById(R.id.chat_1_order);
        chat_1_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chat_to_name.setText(chat_1_order_name.getText());
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.chat_container, new Chat1Fragment()).commit();
            }
        });

        TextView chat_2_order_name;
        chat_2_order_name = findViewById(R.id.chat_2_order_name);
        ConstraintLayout chat_2_order;
        chat_2_order = findViewById(R.id.chat_2_order);
        chat_2_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chat_to_name.setText(chat_2_order_name.getText());
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.chat_container, new Chat2Fragment()).commit();

            }
        });

        TextView chat_3_order_name;
        chat_3_order_name = findViewById(R.id.chat_3_order_name);
        ConstraintLayout chat_3_order;
        chat_3_order = findViewById(R.id.chat_3_order);
        chat_3_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chat_to_name.setText(chat_3_order_name.getText());
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.chat_container, new Chat3Fragment()).commit();
            }
        });

        TextView chat_4_order_name;
        chat_4_order_name = findViewById(R.id.chat_4_order_name);
        ConstraintLayout chat_4_order;
        chat_4_order = findViewById(R.id.chat_4_order);
        chat_4_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chat_to_name.setText(chat_4_order_name.getText());
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.chat_container, new Chat4Fragment()).commit();
            }
        });

        orders_status = mSettings.getString("orders", "1");
        if (orders_status.equals("2")) {
            chat_2_order.setVisibility(View.VISIBLE);
        } else if (orders_status.equals("3")) {
            chat_3_order.setVisibility(View.VISIBLE);
        } else if (orders_status.equals("4")) {
            chat_4_order.setVisibility(View.VISIBLE);
        }

    }
}