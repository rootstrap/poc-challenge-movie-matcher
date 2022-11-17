package com.moviematcher;

import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.moviematcher.customView.asd.MovieDetailActivity2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IntegrationModule extends ReactContextBaseJavaModule {
    public String OVERVIEW = "overview";
    public String GENRES = "genres";
    public String PATH = "poster_path";

    IntegrationModule(ReactApplicationContext context) {
        super(context);
    }

    public String getName() {
        return "IntegrationModule";
    }

    @ReactMethod
    public void openDetailScreen(ReadableMap readableMap) {
        String overview = readableMap.getString("overview");

        Log.d("IntegrationModule", "open detail activity");
        ReactApplicationContext context = getReactApplicationContext();
        Intent intent = new Intent(context, MovieDetailActivity2.class);
        intent.putExtra(OVERVIEW, readableMap.getString(OVERVIEW));
        intent.putExtra(PATH, readableMap.getString(PATH));

        ReadableArray genres = readableMap.getArray("genres");
        ArrayList<String> genresList = new ArrayList<String>();
        for (int i = 0; i < genres.size(); i++) {
            genresList.add(genres.getString(i));
        }
        ReadableArray personas = readableMap.getArray("recommended_by");
        ArrayList<RecommendedBy2> recommendeds = new ArrayList<RecommendedBy2>();

        for (int i = 0; i < personas.size(); i++) {
            String name = personas.getMap(i).getString("name") ;
            String avatar = personas.getMap(i).getString("avatar") ;
            RecommendedBy2 recommended = new RecommendedBy2(name,avatar,false);
            recommendeds.add(recommended);
        }

        intent.putParcelableArrayListExtra("recommended_by", recommendeds);
        intent.putStringArrayListExtra(GENRES, genresList);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}