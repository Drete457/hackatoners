package org.academiadecodigo.hackaton.ReadFile;

import org.academiadecodigo.hackaton.Connection.ConnectionController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadFile implements Runnable {

    private ArrayList<String> list;
    private BufferedReader reader;

    public ReadFile(String urlString) throws IOException {
      list = new ArrayList<String>();
      reader = new BufferedReader(
      new InputStreamReader(
      new ConnectionController(urlString).getInputStream(), "UTF-8"));
    }

    private void readFile(){
        try {
            String line = null;

            while ((line = reader.readLine()) != null) {
                addList(line);
            }

            reader.close();
            getList();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void addList(String line){
        list.add(line);
    }

    public ArrayList<String> getList(){
        return list;
    }

    @Override
    public void run() {
        readFile();
    }
}
