package org.academiadecodigo.hackaton;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.TextView;

import com.scwang.wave.MultiWaveHeader;

import org.academiadecodigo.hackaton.Categories.ReadFile;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MultiWaveHeader waveHeader;
    private Sound sound;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        waveHeader = findViewById(R.id.wave_header);
        getList();
        background();
        sound = new Sound(this);
    }

    private void getList(String urlString){
        try {
            list =  new ReadFile(urlString).getList();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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