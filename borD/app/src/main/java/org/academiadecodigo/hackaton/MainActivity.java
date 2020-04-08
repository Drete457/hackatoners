package org.academiadecodigo.hackaton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.scwang.wave.MultiWaveHeader;

import org.academiadecodigo.hackaton.Categories.ReadFile;
import org.academiadecodigo.hackaton.buttons.MuteButton;

import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private MultiWaveHeader waveHeader;
    private Sound sound;
    private MuteButton mute;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        waveHeader = findViewById(R.id.wave_header);
        background();

        //getList("https://github.com/Drete457/hackatoners/blob/file/borD/app/src/main/res/raw/categorias.txt");

        sound = new Sound(this);
        mute = new MuteButton(sound);

    }

    private void getList(String urlString) {
        try {
            list = new ReadFile(urlString).getList();
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