package org.academiadecodigo.hackaton.ReadFile;

import android.util.Log;
import org.academiadecodigo.hackaton.MainActivity;
import java.io.IOException;
import java.util.ArrayList;

public class CreateList implements Runnable{

    private ArrayList<String> list;
    private MainActivity main;
    private String urlString;


    public CreateList (String urlString, MainActivity main){
        this.main = main;
        this.urlString = urlString;
    }


    private void setCompleteList(){
        main.setCompleteList(list);
    }

    private void setWebSites() {
        ArrayList webSites = new ArrayList();
        for (String url : list) {
            if (url.contains("http")){
                webSites.add(url);
            }
        }
        main.setWebSites(webSites);
    }

    private void setSettingOptions() {
        ArrayList settingOptions = new ArrayList();
        for ( String option : list) {
            if (!option.contains("http")){
                settingOptions.add(option);
            }
        }
        main.setChooseOptions(settingOptions);
    }

    @Override
    public void run() {
            try {
                list = new ReadFile(urlString).getList();
                setCompleteList();
                setWebSites();
                setSettingOptions();
            } catch (IOException ex) {
                Log.d("BuildList", "Build the list: " + ex.getLocalizedMessage());
            }
    }
}
