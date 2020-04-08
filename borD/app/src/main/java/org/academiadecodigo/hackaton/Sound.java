package org.academiadecodigo.hackaton;

import android.media.MediaPlayer;

class Sound {
    private MediaPlayer mediaPlayer;

    public Sound(MainActivity main){
        mediaPlayer = MediaPlayer.create(main.getApplicationContext(), R.raw.startmusicedit2);
        start();
    }

    private void start(){

        mediaPlayer.start();
    }
}
