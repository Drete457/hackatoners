package org.academiadecodigo.hackaton.buttons;

import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import org.academiadecodigo.hackaton.Sound;

import static org.academiadecodigo.hackaton.R.id.muteButton;

public class MuteButton {
    private Sound sound;

    public MuteButton(Sound sound){
        this.sound = sound;
        muteButton();
    }

    private void muteButton(){
        FloatingActionButton myFab = sound.getMain().findViewById(muteButton);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sound.changeState();
                Toast.makeText(sound.getMain(), sound.checkState(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
