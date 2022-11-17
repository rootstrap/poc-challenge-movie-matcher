package com.moviematcher;

import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.moviematcher.customView.asd.MovieDetailActivity2;

public class IntegrationModule extends ReactContextBaseJavaModule {
    public String OVERVIEW="overview";
    public String GENRES = "genres";

    IntegrationModule(ReactApplicationContext context) {
        super(context);
    }

    public String getName() {
        return "IntegrationModule";
    }

    @ReactMethod
    public void openDetailScreen(ReadableMap readableMap){
        String overview = readableMap.getString("overview");

        Log.d("IntegrationModule", "open detail activity");
        ReactApplicationContext context = getReactApplicationContext();
        Intent intent = new Intent(context, MovieDetailActivity2.class);
        intent.putExtra(OVERVIEW, readableMap.getString(OVERVIEW));
        //intent.putStringArrayListExtra(GENRES, readableMap.get("genres"));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}