package org.academiadecodigo.hackaton.Buttons;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.academiadecodigo.hackaton.MainActivity;
import org.academiadecodigo.hackaton.R;

public class RandomButton {

    public RandomButton(MainActivity main){
        start(main);
    }

    private void start(final MainActivity main){
        Button randomButton = main.findViewById(R.id.randomButton);
        randomButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //generate random website
                //change activity with generated website
                Toast.makeText(main, main.randomChoose(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
