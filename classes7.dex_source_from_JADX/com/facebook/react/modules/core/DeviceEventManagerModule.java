package com.facebook.react.modules.core;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.SupportsWebWorkers;
import com.facebook.react.bridge.UiThreadUtil;
import javax.annotation.Nullable;

/* compiled from: frontCamera */
public class DeviceEventManagerModule extends ReactContextBaseJavaModule {
    private final Runnable f11633a;

    @SupportsWebWorkers
    /* compiled from: frontCamera */
    public interface RCTDeviceEventEmitter extends JavaScriptModule {
        void emit(String str, @Nullable Object obj);
    }

    @ReactMethod
    public void invokeDefaultBackPressHandler() {
        this.f1100a.m13522a(this.f11633a);
    }

    public final void m13697r() {
        ((RCTDeviceEventEmitter) this.f1100a.m13515a(RCTDeviceEventEmitter.class)).emit("hardwareBackPress", null);
    }

    public DeviceEventManagerModule(ReactApplicationContext reactApplicationContext, final DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        super(reactApplicationContext);
        this.f11633a = new Runnable(this) {
            final /* synthetic */ DeviceEventManagerModule f11632b;

            public void run() {
                UiThreadUtil.m13554b();
                defaultHardwareBackBtnHandler.mo164a();
            }
        };
    }

    public String getName() {
        return "DeviceEventManager";
    }
}
