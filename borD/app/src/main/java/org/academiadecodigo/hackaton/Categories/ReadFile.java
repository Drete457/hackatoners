package org.academiadecodigo.hackaton.Categories;

import org.academiadecodigo.hackaton.connection.ConnectionController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    private List<String> list;

    public ReadFile(String urlString) throws IOException {
      list = new ArrayList<>();
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
            getList(list);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void addList(String line){
        list.add(line);
    }

    public List<String> getList(List<String> list){
        return list;
    }
}