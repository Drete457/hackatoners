package org.academiadecodigo.hackaton.Buttons;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import org.academiadecodigo.hackaton.MainActivity;
import org.academiadecodigo.hackaton.R;
import java.util.ArrayList;

public class SettingButton {

    private ImageButton imageButton;
    public SettingButton(MainActivity main){
        imageButton = main.findViewById(R.id.settingsButton);
        start(main);
    }

    private void start(final MainActivity main){
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Dialog dialog;

                final String[] items = main.getChooseOptions().toArray(new String[main.getChooseOptions().size()]);
                final ArrayList itemsSelected = new ArrayList();

                AlertDialog.Builder builder = new AlertDialog.Builder(main);
                builder.setTitle("Topics:");
                builder.setMultiChoiceItems(items, null,
                  new DialogInterface.OnMultiChoiceClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int selectedItemId, boolean isSelected) {
                        if (isSelected) {
                            itemsSelected.add(selectedItemId);
                        }
                        else if (itemsSelected.contains(selectedItemId)) {
                             itemsSelected.remove(Integer.valueOf(selectedItemId));
                          }
                        }
                        });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        main.setSelectOptions(itemsSelected);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(main, "Changes not applied.", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog = builder.create();
                dialog.show();
            }
        });
    }
}
