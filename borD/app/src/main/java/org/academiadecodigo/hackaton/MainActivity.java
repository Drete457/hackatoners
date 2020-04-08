package org.academiadecodigo.hackaton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.scwang.wave.MultiWaveHeader;

import org.academiadecodigo.hackaton.ReadFile.ReadFile;
import org.academiadecodigo.hackaton.Buttons.MuteButton;
import org.academiadecodigo.hackaton.Sound.Sound;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MultiWaveHeader waveHeader;
    private Sound sound;
    private MuteButton mute;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        waveHeader = findViewById(R.id.wave_header);
        background();

        getList("https://github.com/Drete457/hackatoners/blob/master/borD/app/src/main/res/raw/categorias.txt");


        sound = new Sound(this);
        mute = new MuteButton(sound, this);
    }

    private void getList(final String urlString) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                   try {
                    list = new ReadFile(urlString).getList();
                   } catch (IOException ex) {
                       Log.d("BuildList", "Build the list: " + ex.getLocalizedMessage());
                   }
                }
            }).start();
    }

    private void background(){
        waveHeader.setVelocity(1);
        waveHeader.setProgress(1);
        waveHeader.setWaveHeight(85);
        waveHeader.setStartColor(0xebebeb);
        waveHeader.setCloseColor(0xababab);
        waveHeader.isRunning();
    }
}