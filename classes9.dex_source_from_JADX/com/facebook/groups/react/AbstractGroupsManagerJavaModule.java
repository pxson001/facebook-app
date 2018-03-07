package com.facebook.groups.react;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

/* compiled from: payments_db */
public abstract class AbstractGroupsManagerJavaModule extends ReactContextBaseJavaModule {
    public AbstractGroupsManagerJavaModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return "RKTreehouseManager";
    }

    public void doesDeviceHaveSoftKeyboard(Callback callback) {
        boolean z = true;
        Object[] objArr = new Object[1];
        if (this.a.getResources().getConfiguration().keyboard == 2) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        callback.a(objArr);
    }
}
