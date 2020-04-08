package org.academiadecodigo.hackaton;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.scwang.wave.MultiWaveHeader;

import static org.academiadecodigo.hackaton.R.id.muteButton;

public class MainActivity extends AppCompatActivity {
    private MultiWaveHeader waveHeader;
    private Sound sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        waveHeader = findViewById(R.id.wave_header);
        background();

        sound = new Sound(this);

        FloatingActionButton myFab = (FloatingActionButton) findViewById(muteButton);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sound.changeState();
                Toast.makeText(MainActivity.this, sound.checkState(), Toast.LENGTH_SHORT).show();
            }
        });
        //Cenas
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