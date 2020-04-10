package org.academiadecodigo.hackaton.Meme;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.academiadecodigo.hackaton.MainActivity;
import org.academiadecodigo.hackaton.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Meme implements Runnable{

    private MemeJson memeJson;
    private String urlString;
    private MainActivity main;

    public Meme(String urlString, MainActivity main){
        this.main = main;
        this.urlString = urlString;
    }

    private void getMeme(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            memeJson = mapper.readValue(new URL(urlString), MemeJson.class);
        }catch (IOException e) {
            Log.d("Create meme", "Create meme: " + e.getLocalizedMessage());
        }
    }

    private void setMeme(){
        try {
            InputStream in = (InputStream) new URL(memeJson.getUrl()).getContent();
            Drawable picture = Drawable.createFromStream(in, memeJson.getTitle());
            ImageView imageView = main.findViewById(R.id.meme);
            imageView.setImageDrawable(picture);
        } catch (Exception e) {
            Log.d("getting meme from url", "getting meme from url: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void run() {
        getMeme();
        setMeme();
    }
}
