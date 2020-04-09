package org.academiadecodigo.hackaton.View;

import android.util.JsonReader;
import android.util.Log;

import org.academiadecodigo.hackaton.Json.MemeJson;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class Meme {

    public MemeJson getMeme(String urlString)  {

        StringBuffer respond;

        try {
            URL obj = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        respond = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            respond.append(inputLine);
        }
        in.close();

        } catch (ProtocolException ex) {
            Log.d("GettingMeme", "Getting Connection to meme: " + ex.getLocalizedMessage())
        } catch (IOException e){
            Log.d("Closing connection", "Clossing conection to get meme: " + e.getLocalizedMessage())
        }

        MemeJson meme = new MemeJson();
        try {
            JSONObject getResponse = new JSONObject((respond.toString()));
            meme.setPostLink(getResponse.getString("postLink"));
            meme.setSubreddit(getResponse.getString("subreddit"));
            meme.setTitle(getResponse.getString("title"));
            meme.setUrl(getResponse.getString("url"));
        } catch (JSONException e) {
            Log.d("GettingJson", "Gettion Json: " + e.getLocalizedMessage())
        }
        return meme;
    }
}
