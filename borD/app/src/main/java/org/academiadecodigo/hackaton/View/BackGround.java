package org.academiadecodigo.hackaton.View;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.scwang.wave.MultiWaveHeader;

import org.academiadecodigo.hackaton.Json.Meme;
import org.academiadecodigo.hackaton.Json.MemeJson;
import org.academiadecodigo.hackaton.MainActivity;
import org.academiadecodigo.hackaton.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;

public class BackGround {

    private MultiWaveHeader waveHeader;
    private MemeJson memeJson;

    public BackGround(MainActivity main, String urlString){
        minimizeNotificationBar(main);
        background(main, urlString);
        disableBars(main);
    }

    private void minimizeNotificationBar(MainActivity main) {
        main.requestWindowFeature(Window.FEATURE_NO_TITLE);
        main.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void disableBars(MainActivity main){
        main.getSupportActionBar().hide();
    }

    private void background(MainActivity main, String urlString) {
        final ColorPallete color = new ColorPallete();
        main.setContentView(R.layout.activity_main);
        waveHeader = main.findViewById(R.id.wave_header);
        waveHeader.setVelocity(3);
        waveHeader.setProgress(1);
        waveHeader.setWaveHeight(100);
        waveHeader.isRunning();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        waveHeader.setStartColor(color.getRandomColor());
                        waveHeader.setCloseColor(color.getRandomColor());
                        sleep(3000);
                    }
                } catch (InterruptedException e) {
                    Log.d("BackGround", "Wave: " + e.getLocalizedMessage());
                }
            }
        }).start();
    }


    }


