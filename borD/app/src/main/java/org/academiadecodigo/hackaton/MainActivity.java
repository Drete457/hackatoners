package org.academiadecodigo.hackaton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.scwang.wave.MultiWaveHeader;

import org.academiadecodigo.hackaton.ReadFile.ReadFile;
import org.academiadecodigo.hackaton.Buttons.MuteButton;
import org.academiadecodigo.hackaton.Sound.Sound;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MultiWaveHeader waveHeader;
    private Sound sound;
    private MuteButton mute;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        minimizeNotificationBar();
        setContentView(R.layout.activity_main);
        waveHeader = findViewById(R.id.wave_header);
        background();
        getSupportActionBar().hide();
        //getList("https://textuploader.com/14pyk");

        sound = new Sound(this);
        mute = new MuteButton(sound);

        Button randomButton = findViewById(R.id.randomButton);
        randomButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //generate random website
                //change activity with generated website
                Toast.makeText(MainActivity.this, "Random funny website would appear now.", Toast.LENGTH_LONG).show();
            }
        });

        ImageButton imageButton = findViewById(R.id.settingsButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Dialog dialog;

                final String[] items = {"Option1", "Option2", "Option3"};
                final ArrayList itemsSelected = new ArrayList();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Select the type of Content you'd like to see:");
                builder.setMultiChoiceItems(items, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                    
                            @Override
                            public void onClick(DialogInterface dialog, int selectedItemId,
                                                boolean isSelected) {
                                if (isSelected) {
                                    itemsSelected.add(selectedItemId);
                                } else if (itemsSelected.contains(selectedItemId)) {
                                    itemsSelected.remove(Integer.valueOf(selectedItemId));
                                }
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                                //Your logic when OK button is clicked
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(MainActivity.this, "Changes not applied.", Toast.LENGTH_SHORT).show();
                            }
                        });

                dialog = builder.create();

                dialog.show();

            }
        });
    }

    private void minimizeNotificationBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
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