package org.academiadecodigo.hackaton;

import org.academiadecodigo.hackaton.Buttons.MuteButton;
import org.academiadecodigo.hackaton.Buttons.RandomButton;
import org.academiadecodigo.hackaton.Buttons.SettingButton;
import org.academiadecodigo.hackaton.Sound.Sound;
import org.academiadecodigo.hackaton.View.BackGround;
import java.util.ArrayList;

public class BootStrap {


    public BootStrap getBootStrap(MainActivity main){
       BackGround backGround = new BackGround(main);
       SettingButton settingButton = new SettingButton(main);
       Sound sound = new Sound(main);
       MuteButton mute = new MuteButton(sound, main);
       RandomButton random = new RandomButton(main);
       main.setCompleteList(new ArrayList<String>());
       main.setChooseOptions(new ArrayList<String>());
       main.setWebSites(new ArrayList<String>());
       main.setSelectOptions(new ArrayList<Integer>());
       MainActivity.fixedPool.submit(backGround);
       return this;
    }

    public ArrayList<String> filterWebSite(ArrayList<Integer> selectOptions,
        ArrayList<String> chooseOptions, ArrayList<String> completeList){

        ArrayList<String> categories = conversionIntToText(selectOptions, chooseOptions);
        ArrayList<String> filterWebSite = new ArrayList<>();

         for (int x = 0; x < categories.size(); x++) {
            for (int y = 0; y < completeList.size(); y++){
               if (categories.get(x).equals(completeList.get(y))){
                    for ( int z = y+1; z < completeList.size(); z++){
                        if ( completeList.get(z).contains("http")) {
                            filterWebSite.add(completeList.get(z));
                        } else {
                            break;
                        }
                    }
                }
            }
        }
       return filterWebSite;
    }

    private ArrayList<String> conversionIntToText(ArrayList<Integer> selectOptions, ArrayList<String> chooseOptions){
        ArrayList<String> list = new ArrayList<>();
        for (int x = 0; x < selectOptions.size(); x++){
            list.add(chooseOptions.get(selectOptions.get(x)));
        }
        return list;
    }
}
