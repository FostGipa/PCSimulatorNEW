package com.example.pcsimulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.VideoView;
import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {

    VideoView start_video;
    MediaPlayer music;
    ProgressBar progressBar;
    Timer timer;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
        setContentView(R.layout.activity_start);

        music = MediaPlayer.create(
                this, R.raw.splash_music);
        music.start();

        start_video = findViewById(R.id.start_video);
        start_video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.start_video));
        start_video.start();
        start_video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        ImageButton startButton;
        ImageButton settingButton;
        startButton = findViewById(R.id.start_button);
        settingButton = findViewById(R.id.setting_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        progressBar = findViewById(R.id.progress_bar);
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                count++;
                progressBar.setProgress(count);
                if (count==100){
                    timer.cancel();
                    ConstraintLayout constraintLayout;
                    constraintLayout = findViewById(R.id.splash_screen);
                    constraintLayout.setVisibility(View.INVISIBLE);
                    Intent svc = new Intent(StartActivity.this, BackgroundSoundService.class);
                    startService(svc);
                }
            }
        };
        timer.schedule(timerTask, 0, 170);
    }
}