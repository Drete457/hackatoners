package org.academiadecodigo.hackaton.Connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class ConnectionController {
    private InputStream inputStream;

    public ConnectionController(String urlString) throws IOException {
       inputStream = new TextFromWeb(urlString).getUrl().getInputStream();
        if (inputStream == null ){
            inputStream = new FileInputStream(new File("raw/categorias.txt"));
        }
    }

    public InputStream getInputStream(){
        return inputStream;
    }
}
