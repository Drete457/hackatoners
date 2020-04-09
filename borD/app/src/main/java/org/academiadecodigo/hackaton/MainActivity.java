package org.academiadecodigo.hackaton;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.academiadecodigo.hackaton.ReadFile.CreateList;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> completeList;
    private ArrayList<String> webSites;
    private ArrayList<String> chooseOptions;
    private ArrayList<Integer> selectOptions = new ArrayList<>();

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
        
        if (selectOptions.isEmpty()) {
            randomSite.addAll(webSites);
        } else {
            randomSite = new BootStrap().filterWebSite(selectOptions, chooseOptions, completeList);
        }
        int index = (int) (Math.random() * randomSite.size());
        System.out.println(randomSite.size());
        return randomSite.get(index);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        String urlString = "https://raw.githubusercontent.com/Drete457/hackatoners/master/borD/app/src/main/res/raw/categorias.txt";

        new BootStrap().getBootStrap(this);
        new CreateList(urlString, this);
    }




}