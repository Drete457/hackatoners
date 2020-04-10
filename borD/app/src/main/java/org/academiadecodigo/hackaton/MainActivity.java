package org.academiadecodigo.hackaton;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import org.academiadecodigo.hackaton.Meme.Meme;

import org.academiadecodigo.hackaton.ReadFile.CreateList;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    static String websiteToOpen = "";

    static ExecutorService fixedPool;

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
        String urlString2 = "https://meme-api.herokuapp.com/gimme";
        fixedPool = Executors.newCachedThreadPool();
        new BootStrap().getBootStrap(this);
        fixedPool.submit(new CreateList(urlString, this));
        fixedPool.submit(new Meme(urlString2, this));
        //System.out.println("memememeeeeeeeeeeeeeee: " + memeUrl);
    }

}