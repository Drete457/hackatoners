package org.academiadecodigo.hackaton.View;

import android.view.Window;
import android.view.WindowManager;

import com.scwang.wave.MultiWaveHeader;

import org.academiadecodigo.hackaton.MainActivity;
import org.academiadecodigo.hackaton.R;

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
        main.setContentView(R.layout.activity_main);
        waveHeader = main.findViewById(R.id.wave_header);
        waveHeader.setVelocity(1);
        waveHeader.setProgress(1);
        waveHeader.setWaveHeight(85);
        waveHeader.setStartColor(0xebabab);
        waveHeader.setCloseColor(0xababab);
        waveHeader.isRunning();
    }


}
