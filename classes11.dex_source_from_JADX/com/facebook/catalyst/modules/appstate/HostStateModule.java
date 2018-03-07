package com.facebook.catalyst.modules.appstate;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;

/* compiled from: marketplace_badge_count */
public class HostStateModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private String f5565a = "uninitialized";

    public HostStateModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private void m6881r() {
        ((RCTDeviceEventEmitter) this.a.a(RCTDeviceEventEmitter.class)).emit("hostLifecycleEvent", this.f5565a);
    }

    public final void m6882c() {
        this.a.a(this);
        this.f5565a = "initialized";
    }

    @ReactMethod
    public void getCurrentHostState(Callback callback, Callback callback2) {
        callback.a(new Object[]{this.f5565a});
    }

    public String getName() {
        return "HostStateAndroid";
    }

    public final void hf_() {
        this.f5565a = "resumed";
        m6881r();
    }

    public final void hg_() {
        this.f5565a = "paused";
        m6881r();
    }

    public final void hh_() {
    }

    public final void m6883e() {
    }
}
