package com.facebook.react.modules.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/* compiled from: SHARE_TIMELINE */
public class IntentModule extends ReactContextBaseJavaModule {
    public IntentModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return "IntentAndroid";
    }

    @ReactMethod
    public void getInitialURL(Promise promise) {
        try {
            Activity q = q();
            Object obj = null;
            if (q != null) {
                Intent intent = q.getIntent();
                String action = intent.getAction();
                Uri data = intent.getData();
                if ("android.intent.action.VIEW".equals(action) && data != null) {
                    obj = data.toString();
                }
            }
            promise.a(obj);
        } catch (Exception e) {
            promise.a(new JSApplicationIllegalArgumentException("Could not get the initial URL : " + e.getMessage()));
        }
    }

    @ReactMethod
    public void openURL(String str, Promise promise) {
        if (str == null || str.isEmpty()) {
            promise.a(new JSApplicationIllegalArgumentException("Invalid URL: " + str));
            return;
        }
        try {
            Activity q = q();
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            String packageName = p().getPackageName();
            ComponentName resolveActivity = intent.resolveActivity(p().getPackageManager());
            Object packageName2 = resolveActivity != null ? resolveActivity.getPackageName() : "";
            if (q == null || !packageName.equals(packageName2)) {
                intent.addFlags(268435456);
            }
            if (q != null) {
                q.startActivity(intent);
            } else {
                p().startActivity(intent);
            }
            promise.a(Boolean.valueOf(true));
        } catch (Exception e) {
            promise.a(new JSApplicationIllegalArgumentException("Could not open URL '" + str + "': " + e.getMessage()));
        }
    }

    @ReactMethod
    public void canOpenURL(String str, Promise promise) {
        if (str == null || str.isEmpty()) {
            promise.a(new JSApplicationIllegalArgumentException("Invalid URL: " + str));
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            promise.a(Boolean.valueOf(intent.resolveActivity(p().getPackageManager()) != null));
        } catch (Exception e) {
            promise.a(new JSApplicationIllegalArgumentException("Could not check if URL '" + str + "' can be opened: " + e.getMessage()));
        }
    }
}
