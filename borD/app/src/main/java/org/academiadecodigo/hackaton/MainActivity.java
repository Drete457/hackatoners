package org.academiadecodigo.hackaton;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.scwang.wave.MultiWaveHeader;

public class MainActivity extends AppCompatActivity {
    MultiWaveHeader waveHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        waveHeader = findViewById(R.id.wave_header);

        waveHeader.setVelocity(1);
        waveHeader.setProgress(1);
        waveHeader.setWaveHeight(85);
        waveHeader.setStartColor(0xebebeb);
        waveHeader.setCloseColor(0xababab);
        waveHeader.isRunning();
    }
}