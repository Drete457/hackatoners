package org.academiadecodigo.hackaton.ReadFile;

import org.academiadecodigo.hackaton.Connection.ConnectionController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadFile {

    private ArrayList<String> list;

    public ReadFile(String urlString) throws IOException {
      list = new ArrayList<String>();
     BufferedReader reader = new BufferedReader(
      new InputStreamReader(
      new ConnectionController(urlString).getInputStream(), "UTF-8"));
      readFile(reader);
    }

    private void readFile(BufferedReader reader){
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
}
