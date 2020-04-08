package org.academiadecodigo.hackaton.Connection;

import android.util.Log;
import java.net.URL;
import java.net.URLConnection;

public class TextFromWeb {

    private URLConnection feedUrl;

    TextFromWeb(String urlString){
      try {
          feedUrl = new URL(urlString).openConnection();
          feedUrl.setConnectTimeout(60000);
      } catch (Exception ex){
          Log.d("Connection", "Reading the file: " + ex.getLocalizedMessage());
      }
    }

    public URLConnection getUrl(){
        return feedUrl;
    }
}
