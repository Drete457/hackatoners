package org.academiadecodigo.hackaton;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.academiadecodigo.hackaton.ReadFile.CreateList;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static String websiteToOpen = "";

    private ArrayList<String> completeList;
    private ArrayList<String> webSites;
    private ArrayList<String> chooseOptions;
    private ArrayList<Integer> selectOptions;

    public void setCompleteList(ArrayList<String> completeList) {
        this.completeList = completeList;
    }

    public void setWebSites(ArrayList<String> webSites){
        this.webSites = webSites;
    }

    public void setChooseOptions(ArrayList<String> chooseOptions) {
        this.chooseOptions = chooseOptions;
    }
    
    public void setSelectOptions(ArrayList<Integer> selectOptions){
        this.selectOptions = selectOptions;
    }

    public ArrayList<String> getChooseOptions(){
        return chooseOptions;
    }

    public String randomChoose(){
        ArrayList<String> randomSite = new ArrayList<>();

        if (webSites.isEmpty()){
            webSites.add("http://noInternetConnection");
        }

        if (selectOptions.isEmpty()) {
            randomSite.addAll(webSites);
        } else {
            randomSite = new BootStrap().filterWebSite(selectOptions, chooseOptions, completeList);
        }

        int index = (int) (Math.random() * randomSite.size());

        websiteToOpen = randomSite.get(index);
        return websiteToOpen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        String urlString = "https://raw.githubusercontent.com/Drete457/hackatoners/master/borD/app/src/main/res/raw/categorias.txt";

        new BootStrap().getBootStrap(this);
        new CreateList(urlString, this);
    }
}