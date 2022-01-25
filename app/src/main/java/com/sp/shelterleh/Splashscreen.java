package com.sp.shelterleh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class Splashscreen extends AppCompatActivity {
        Handler h =new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        final MediaPlayer mediaPlayer =
                MediaPlayer.create(getApplicationContext(),R.raw.bruh);
            mediaPlayer.start();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splashscreen.this, Main.class );
                startActivity(i);
                finish();
                mediaPlayer.stop();
            }
        }, 3000);
    }
}