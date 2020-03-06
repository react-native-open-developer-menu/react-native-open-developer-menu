package com.github.reactnativeopendevelopermenu;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.app.Activity;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;

public class OpenDeveloperMenuModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public OpenDeveloperMenuModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "OpenDeveloperMenu";
    }

    @ReactMethod
    public void open() {
        // based on https://github.com/facebook/react-native/blob/2c136192a352ff04c8f2191397a769df844933b1/ReactAndroid/src/main/java/com/facebook/react/ReactActivityDelegate.java#L126
        final ReactNativeHost rnHost = ((ReactApplication) this.reactContext.getApplicationContext()).getReactNativeHost();
        if (!rnHost.getUseDeveloperSupport()) {
            return;
        }
        Activity activity = getCurrentActivity();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                rnHost.getReactInstanceManager().showDevOptionsDialog();
            }
        });
    }
}
