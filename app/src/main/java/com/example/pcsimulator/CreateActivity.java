package com.example.pcsimulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.pcsimulator.create_fragments.BPSelectFragment;
import com.example.pcsimulator.create_fragments.CPUSelectFragment;
import com.example.pcsimulator.create_fragments.CaseSelectFragment;
import com.example.pcsimulator.create_fragments.CoolingSelectFragment;
import com.example.pcsimulator.create_fragments.HDDSelectFragment;
import com.example.pcsimulator.create_fragments.MbSelectFragment;
import com.example.pcsimulator.create_fragments.RAMSelectFragment;
import com.example.pcsimulator.create_fragments.SSDSelectFragment;
import com.example.pcsimulator.create_fragments.VDSelectFragment;

public class CreateActivity extends AppCompatActivity{

    SharedPreferences mSettings;
    CardView motherboard_select;
    CardView cpu_select;
    CardView ram_select;
    CardView vd_select;
    CardView bp_select;
    CardView hdd_select;
    CardView ssd_select;
    CardView case_select;
    CardView cooling_select;
    ImageButton create_back_btn;
    ImageView motherboard_img;
    TextView motherboard_name;
    ImageView cpu_img;
    TextView cpu_name;
    ImageView ram_img;
    TextView ram_name;
    ImageView vd_img;
    TextView vd_name;
    ImageView bp_img;
    TextView bp_name;
    ImageView hdd_img;
    TextView hdd_name;
    ImageView ssd_img;
    TextView ssd_name;
    ImageView case_img;
    TextView case_name;
    ImageView cooling_img;
    TextView cooling_name;
    AppCompatButton create_btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
        setContentView(R.layout.activity_create);

        mSettings = getSharedPreferences("mysettings", Context.MODE_PRIVATE);

        motherboard_select = findViewById(R.id.motherboard_select);
        cpu_select = findViewById(R.id.cpu_select);
        ram_select = findViewById(R.id.ram_select);
        vd_select = findViewById(R.id.vd_select);
        bp_select = findViewById(R.id.bp_select);
        hdd_select = findViewById(R.id.hdd_select);
        ssd_select = findViewById(R.id.ssd_select);
        case_select = findViewById(R.id.case_select);
        cooling_select = findViewById(R.id.cooling_select);
        create_back_btn = findViewById(R.id.create_back_btn);
        motherboard_img = findViewById(R.id.motherboard_img);
        motherboard_name = findViewById(R.id.motherboard_name);
        cpu_img = findViewById(R.id.cpu_img);
        cpu_name = findViewById(R.id.cpu_name);
        ram_img = findViewById(R.id.ram_img);
        ram_name = findViewById(R.id.ram_name);
        vd_img = findViewById(R.id.vd_img);
        vd_name = findViewById(R.id.vd_name);
        bp_img = findViewById(R.id.bp_img);
        bp_name = findViewById(R.id.bp_name);
        hdd_img = findViewById(R.id.hdd_img);
        hdd_name = findViewById(R.id.hdd_name);
        ssd_img = findViewById(R.id.ssd_img);
        ssd_name = findViewById(R.id.ssd_name);
        case_img = findViewById(R.id.case_img);
        case_name = findViewById(R.id.case_name);
        cooling_img = findViewById(R.id.cooling_img);
        cooling_name = findViewById(R.id.cooling_name);
        create_btn = findViewById(R.id.create_btn);

        motherboard_name.setText(mSettings.getString("mb_name", ""));
        motherboard_img.setImageResource(mSettings.getInt("mb_img", R.drawable.ic_plus));
        cpu_name.setText(mSettings.getString("cpu_name", ""));
        cpu_img.setImageResource(mSettings.getInt("cpu_img", R.drawable.ic_plus));
        ram_name.setText(mSettings.getString("ram_name", ""));
        ram_img.setImageResource(mSettings.getInt("ram_img", R.drawable.ic_plus));
        vd_name.setText(mSettings.getString("vd_name", ""));
        vd_img.setImageResource(mSettings.getInt("vd_img", R.drawable.ic_plus));
        bp_name.setText(mSettings.getString("bp_name", ""));
        bp_img.setImageResource(mSettings.getInt("bp_img", R.drawable.ic_plus));
        hdd_name.setText(mSettings.getString("hdd_name", ""));
        hdd_img.setImageResource(mSettings.getInt("hdd_img", R.drawable.ic_plus));
        ssd_name.setText(mSettings.getString("ssd_name", ""));
        ssd_img.setImageResource(mSettings.getInt("ssd_img", R.drawable.ic_plus));
        case_name.setText(mSettings.getString("case_name", ""));
        case_img.setImageResource(mSettings.getInt("case_img", R.drawable.ic_plus));
        cooling_name.setText(mSettings.getString("cooling_name", ""));
        cooling_img.setImageResource(mSettings.getInt("cooling_img", R.drawable.ic_plus));

        create_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                motherboard_name.setText("");
                motherboard_img.setImageResource(R.drawable.ic_plus);
                cpu_name.setText("");
                cpu_img.setImageResource(R.drawable.ic_plus);
                ram_name.setText("");
                ram_img.setImageResource(R.drawable.ic_plus);
                vd_name.setText("");
                vd_img.setImageResource(R.drawable.ic_plus);
                bp_name.setText("");
                bp_img.setImageResource(R.drawable.ic_plus);
                hdd_name.setText("");
                hdd_img.setImageResource(R.drawable.ic_plus);
                ssd_name.setText("");
                ssd_img.setImageResource(R.drawable.ic_plus);
                case_name.setText("");
                case_img.setImageResource(R.drawable.ic_plus);
                cooling_name.setText("");
                cooling_img.setImageResource(R.drawable.ic_plus);
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

        motherboard_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = MbSelectFragment.newInstance(1);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.create_container, fragment);
                transaction.commit();
            }
        });

          cpu_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = CPUSelectFragment.newInstance(1);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.create_container, fragment);
                transaction.commit();
            }
        });

        ram_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = RAMSelectFragment.newInstance(1);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.create_container, fragment);
                transaction.commit();
            }
        });

        bp_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = BPSelectFragment.newInstance(1);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.create_container, fragment);
                transaction.commit();
            }
        });

        vd_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = VDSelectFragment.newInstance(1);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.create_container, fragment);
                transaction.commit();
            }
        });

        hdd_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = HDDSelectFragment.newInstance(1);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.create_container, fragment);
                transaction.commit();
            }
        });

        ssd_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = SSDSelectFragment.newInstance(1);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.create_container, fragment);
                transaction.commit();
            }
        });

        case_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = CaseSelectFragment.newInstance(1);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.create_container, fragment);
                transaction.commit();
            }
        });

        cooling_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = CoolingSelectFragment.newInstance(1);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.create_container, fragment);
                transaction.commit();
            }
        });

        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ssd_name.getText().toString().equals("") | bp_name.getText().toString().equals("") | case_name.getText().toString().equals("") |
                        cooling_name.getText().toString().equals("") | cpu_name.getText().toString().equals("") | hdd_name.getText().toString().equals("") |
                        motherboard_name.getText().toString().equals("") | ram_name.getText().toString().equals("") | vd_name.getText().toString().equals(""))
                {
                    Toast.makeText(CreateActivity.this, "Select all components!!", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences.Editor editor = mSettings.edit();
                    editor.putString("selected_ssd_name", ssd_name.getText().toString());
                    editor.putString("selected_bp_name", bp_name.getText().toString());
                    editor.putString("selected_case_name", case_name.getText().toString());
                    editor.putString("selected_cooling_name", cooling_name.getText().toString());
                    editor.putString("selected_cpu_name", cpu_name.getText().toString());
                    editor.putString("selected_hdd_name", hdd_name.getText().toString());
                    editor.putString("selected_mb_name", motherboard_name.getText().toString());
                    editor.putString("selected_ram_name", ram_name.getText().toString());
                    editor.putString("selected_vd_name", vd_name.getText().toString());
                    editor.apply();
                    Toast.makeText(CreateActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}