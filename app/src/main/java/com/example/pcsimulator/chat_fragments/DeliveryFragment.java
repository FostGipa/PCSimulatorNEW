package com.example.pcsimulator.chat_fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pcsimulator.R;
import com.example.pcsimulator.TransparentFragment;

public class DeliveryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delivery, container, false);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TransparentFragment transparentFragment = new TransparentFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, transparentFragment).commit();
            }
        }, 5000);
        return view;
    }
}