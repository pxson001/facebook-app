package com.facebook.catalyst.modules.persistedqueries;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;

/* compiled from: universal_feedback/? */
public class RelayPersistedQueriesPreloaderModule extends ReactContextBaseJavaModule {
    public RelayPersistedQueriesPreloaderModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return "RelayPersistedQueryPreloader";
    }

    @ReactMethod
    public void getEntry(String str) {
        RelayPersistedQueriesPreloader.m1059a().m1068a((RCTDeviceEventEmitter) this.f1100a.m13515a(RCTDeviceEventEmitter.class), str);
    }
}
