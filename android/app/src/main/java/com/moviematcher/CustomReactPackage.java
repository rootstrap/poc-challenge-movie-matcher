package com.moviematcher;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.List;

public class CustomReactPackage implements ReactPackage {

    public CustomReactPackage() {

    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
         modules.add(new IntegrationModule(reactContext));
        return modules;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        List<ViewManager> modules = new ArrayList<>();
        // Add native UI components here
       // modules.add(new DetailScreenModule(reactContext));
        return modules;
    }
}