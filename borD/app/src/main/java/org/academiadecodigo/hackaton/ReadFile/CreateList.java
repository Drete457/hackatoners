package org.academiadecodigo.hackaton.ReadFile;

import android.util.Log;
import org.academiadecodigo.hackaton.MainActivity;
import java.io.IOException;
import java.util.ArrayList;

public class CreateList {

    private ArrayList<String> list;

    public CreateList (String urlString, MainActivity main){
        setList(urlString, main);
    }

    private void setList(final String urlString, final MainActivity main) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        list = new ReadFile(urlString).getList();
                        setCompleteList(main);
                        setWebSites(main);
                        setSettingOptions(main);
                        notifyAll();
                    }
                } catch (IOException ex) {
                    Log.d("BuildList", "Build the list: " + ex.getLocalizedMessage());
                }
            }
        }).start();
    }

    private void setCompleteList(MainActivity main){
        main.setCompleteList(list);
    }

    private void setWebSites(MainActivity main) {
        ArrayList webSites = new ArrayList();
        for (String url : list) {
            if (url.contains("http")){
                webSites.add(url);
            }
        }
        main.setWebSites(webSites);
    }

    private void setSettingOptions(MainActivity main) {
        ArrayList settingOptions = new ArrayList();
        for ( String option : list) {
            if (!option.contains("http")){
                settingOptions.add(option);
            }
        }
        main.setChooseOptions(settingOptions);
    }
}
