package com.facebook.react.modules.appstate;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;

/* compiled from: SIZE_74 */
public class AppStateModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private String f11383a = "uninitialized";

    public AppStateModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private void m11721s() {
        ((RCTDeviceEventEmitter) this.a.a(RCTDeviceEventEmitter.class)).emit("appStateDidChange", m11720r());
    }

    public final void m11722c() {
        this.a.a(this);
    }

    public String getName() {
        return "AppState";
    }

    @ReactMethod
    public void getCurrentAppState(Callback callback, Callback callback2) {
        callback.a(new Object[]{m11720r()});
    }

    public final void hf_() {
        this.f11383a = "active";
        m11721s();
    }

    public final void hg_() {
        this.f11383a = "background";
        m11721s();
    }

    public final void hh_() {
    }

    private WritableMap m11720r() {
        WritableMap b = Arguments.b();
        b.putString("app_state", this.f11383a);
        return b;
    }
}
