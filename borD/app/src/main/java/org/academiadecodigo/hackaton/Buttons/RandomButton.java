package org.academiadecodigo.hackaton.Buttons;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import org.academiadecodigo.hackaton.MainActivity;
import org.academiadecodigo.hackaton.R;
import org.academiadecodigo.hackaton.WrapperActivity;

public class RandomButton {
    MainActivity main;

    public RandomButton(MainActivity main){
        this.main = main;
        start(main);
    }

    private void start(final MainActivity main){
        Button randomButton = main.findViewById(R.id.randomButton);
        randomButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //generate random website
                //change activity with generated website
                Toast.makeText(main, main.randomChoose(), Toast.LENGTH_LONG).show();
                View view = main.findViewById(R.id.mainActivityView);
                goToAnotherActivity(view);
            }
        });
    }

    public void goToAnotherActivity(View view) {
        WrapperActivity.setMain(main);
        Intent intent = new Intent(view.getContext(), WrapperActivity.class);
        view.getContext().startActivity(intent);
    }
}

