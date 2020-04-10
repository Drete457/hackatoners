package org.academiadecodigo.hackaton.Sound;

import android.media.MediaPlayer;
import org.academiadecodigo.hackaton.MainActivity;
import org.academiadecodigo.hackaton.R;

public class Sound {
    private MediaPlayer mediaPlayer;
    private boolean isPlaying;
    private MainActivity main;

    public Sound(MainActivity main){
        this.main = main;
        isPlaying = true;
        start();
    }

    private void start(){
        mediaPlayer = MediaPlayer.create(main, R.raw.startmusiclong);
        mediaPlayer.start();
    }

    private void stop(){
        mediaPlayer.stop();
    }

    public void changeState(){
        if (isPlaying) {
            stop();
            isPlaying = false;
            return;
        }
        start();
        isPlaying = true;

    }

    public String checkState(){
        return isPlaying ? "Sound On" : "Sound Off";
    }
}
