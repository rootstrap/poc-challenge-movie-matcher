package com.moviematcher;

import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.moviematcher.customView.MovieDetailActivity;

public class IntegrationModule extends ReactContextBaseJavaModule {

    IntegrationModule(ReactApplicationContext context) {
        super(context);
    }

    public String getName() {
        return "IntegrationModule";
    }

    @ReactMethod
    public void openDetailScreen(){
        Log.d("IntegrationModule", "open detail activity");
        ReactApplicationContext context = getReactApplicationContext();
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra("title", "Movie name");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}