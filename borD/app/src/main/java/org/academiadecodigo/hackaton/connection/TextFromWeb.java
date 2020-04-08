package org.academiadecodigo.hackaton.connection;

import java.net.URL;
import java.net.URLConnection;

public class TextFromWeb {

    private URLConnection feedUrl;

    TextFromWeb(String urlString){
      try {
          feedUrl = new URL(urlString).openConnection();
      } catch (Exception ex){
          ex.printStackTrace();
      }
    }

    public URLConnection getUrl(){
        return feedUrl;
    }
}
