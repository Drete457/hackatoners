package org.academiadecodigo.hackaton.Connection;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class TextFromWeb {

    private URLConnection feedUrl;

    TextFromWeb(String urlString){
      try {
          feedUrl = new URL(urlString).openConnection();
          feedUrl.setConnectTimeout(60000);
      } catch (Exception ex){
          ex.printStackTrace();
      }
    }

    public URLConnection getUrl(){
        return feedUrl;
    }
}
