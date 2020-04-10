package org.academiadecodigo.hackaton.Buttons;

import android.view.View;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import org.academiadecodigo.hackaton.MainActivity;
import org.academiadecodigo.hackaton.Sound.Sound;

import static org.academiadecodigo.hackaton.R.id.muteButton;

public class MuteButton {
    private Sound sound;

    public MuteButton(Sound sound, MainActivity main){
        this.sound = sound;
        muteButton(main);
    }

    private void muteButton(final MainActivity main){
        FloatingActionButton myFab = main.findViewById(muteButton);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sound.changeState();
                Toast.makeText(main, sound.checkState(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
