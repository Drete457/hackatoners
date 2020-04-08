package org.academiadecodigo.hackaton;

import android.media.MediaPlayer;

class Sound {
    private MediaPlayer mediaPlayer;

    public Sound(MainActivity main){
        mediaPlayer = MediaPlayer.create(main.getApplicationContext(), R.raw.startmusiclong);
        start();
    }

    private void start(){

        mediaPlayer.start();
    }
}
