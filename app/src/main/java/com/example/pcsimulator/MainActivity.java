package com.example.pcsimulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ImageButton chat_btn;
    Button bed_btn;
    ImageButton settings_btn;
    ImageButton shop_btn;
    ImageButton inventory_btn;
    SharedPreferences mSettings;
    TextView main_money;
    TextView main_energy;
    AppCompatButton computer_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
        setContentView(R.layout.activity_main);

        mSettings = getSharedPreferences("mysettings", Context.MODE_PRIVATE);

        bed_btn = findViewById(R.id.bed_btn);
        shop_btn = findViewById(R.id.shop_btn);
        settings_btn = findViewById(R.id.settings_btn);
        chat_btn = findViewById(R.id.chat_btn);
        inventory_btn = findViewById(R.id.inventory_btn);
        computer_btn = findViewById(R.id.computer_btn);

        chat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        shop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShopActivity.class);
                startActivity(intent);
            }
        });

        inventory_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSettings.getString("first_buy", "yes").equals("yes")) {
                    Toast.makeText(MainActivity.this, "Buy something", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, InventoryActivity.class);
                    startActivity(intent);
                }

            }
        });

        bed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintLayout sleep_screen;
                sleep_screen = findViewById(R.id.sleep_screen);
                sleep_screen.setVisibility(View.VISIBLE);
                bed_btn.setClickable(false);
                chat_btn.setClickable(false);
                settings_btn.setClickable(false);
                shop_btn.setClickable(false);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sleep_screen.setVisibility(View.GONE);
                        bed_btn.setClickable(true);
                        chat_btn.setClickable(true);
                        settings_btn.setClickable(true);
                        shop_btn.setClickable(true);
                    }
                }, 5000);
            }
        });

        computer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(intent);
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString("ssd_name", "");
                editor.putInt("ssd_img", R.drawable.ic_plus);
                editor.putString("bp_name", "");
                editor.putInt("bp_img", R.drawable.ic_plus);
                editor.putString("case_name", "");
                editor.putInt("case_img", R.drawable.ic_plus);
                editor.putString("cooling_name", "");
                editor.putInt("cooling_img", R.drawable.ic_plus);
                editor.putString("cpu_name", "");
                editor.putInt("cpu_img", R.drawable.ic_plus);
                editor.putString("hdd_name", "");
                editor.putInt("hdd_img", R.drawable.ic_plus);
                editor.putString("mb_name", "");
                editor.putInt("mb_img", R.drawable.ic_plus);
                editor.putString("ram_name", "");
                editor.putInt("ram_img", R.drawable.ic_plus);
                editor.putString("vd_name", "");
                editor.putInt("vd_img", R.drawable.ic_plus);
                editor.apply();
            }
        });

        main_money = findViewById(R.id.main_money);
        main_money.setText(String.valueOf(mSettings.getInt("balance", 50000)));
        main_energy = findViewById(R.id.main_energy);
        main_energy.setText(String.valueOf(mSettings.getInt("energy", 100)));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        main_money.setText(String.valueOf(mSettings.getInt("balance", 50000)));
        main_energy.setText(String.valueOf(mSettings.getInt("energy", 100)));
    }
}