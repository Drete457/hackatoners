package org.academiadecodigo.hackaton.View;

import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.scwang.wave.MultiWaveHeader;
import org.academiadecodigo.hackaton.MainActivity;
import org.academiadecodigo.hackaton.R;
import static java.lang.Thread.sleep;

public class BackGround implements Runnable{

    private MultiWaveHeader waveHeader;
    private MainActivity main;
    private final ColorPallete color;

    public BackGround(MainActivity main){
        this.main = main;
        color = new ColorPallete();
        minimizeNotificationBar();
        background();
        disableBars();
    }

    private void minimizeNotificationBar() {
        main.requestWindowFeature(Window.FEATURE_NO_TITLE);
        main.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void disableBars(){
        main.getSupportActionBar().hide();
    }

    private void background() {

        main.setContentView(R.layout.activity_main);
        waveHeader = main.findViewById(R.id.wave_header);
        waveHeader.setVelocity(3);
        waveHeader.setProgress(1);
        waveHeader.setWaveHeight(100);
        waveHeader.setStartColor(color.getRandomColor());
        waveHeader.setCloseColor(color.getRandomColor());
        waveHeader.isRunning();
    }


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
}


