package org.academiadecodigo.hackaton.View;

import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.scwang.wave.MultiWaveHeader;

import org.academiadecodigo.hackaton.MainActivity;
import org.academiadecodigo.hackaton.R;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class BackGround {

    private MultiWaveHeader waveHeader;

    public BackGround(MainActivity main){
        minimizeNotificationBar(main);
        background(main);
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

    private void background(MainActivity main){
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
