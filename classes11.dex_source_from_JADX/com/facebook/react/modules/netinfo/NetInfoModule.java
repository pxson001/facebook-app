package com.facebook.react.modules.netinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: SHARE_MESSENGER */
public class NetInfoModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private final ConnectivityManager f11408a;
    private final ConnectivityBroadcastReceiver f11409b;
    private boolean f11410c = false;
    private String f11411d = "";

    /* compiled from: SHARE_MESSENGER */
    public class ConnectivityBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ NetInfoModule f11406a;
        public boolean f11407b;

        public ConnectivityBroadcastReceiver(NetInfoModule netInfoModule) {
            this.f11406a = netInfoModule;
            this.f11407b = false;
        }

        public final void m11747a(boolean z) {
            this.f11407b = z;
        }

        public final boolean m11748a() {
            return this.f11407b;
        }

        public void onReceive(Context context, Intent intent) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 874500847);
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                NetInfoModule.m11752t(this.f11406a);
            }
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1275009597, a);
        }
    }

    private void m11754v() {
        ((RCTDeviceEventEmitter) this.a.a(RCTDeviceEventEmitter.class)).emit("networkStatusDidChange", m11755w());
    }

    public final void m11756c() {
        this.a.a(this);
    }

    public NetInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.f11408a = (ConnectivityManager) reactApplicationContext.getSystemService("connectivity");
        this.f11409b = new ConnectivityBroadcastReceiver(this);
    }

    public final void hf_() {
        m11750r();
    }

    public final void hg_() {
        m11751s();
    }

    public final void hh_() {
    }

    public String getName() {
        return "NetInfo";
    }

    @ReactMethod
    public void getCurrentConnectivity(Promise promise) {
        if (this.f11410c) {
            promise.b("E_MISSING_PERMISSION", "To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />");
        } else {
            promise.a(m11755w());
        }
    }

    @ReactMethod
    public void isConnectionMetered(Promise promise) {
        if (this.f11410c) {
            promise.b("E_MISSING_PERMISSION", "To use NetInfo on Android, add the following to your AndroidManifest.xml:\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />");
        } else {
            promise.a(Boolean.valueOf(ConnectivityManagerCompat.a(this.f11408a)));
        }
    }

    private void m11750r() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.a.registerReceiver(this.f11409b, intentFilter);
        this.f11409b.f11407b = true;
    }

    private void m11751s() {
        if (this.f11409b.f11407b) {
            this.a.unregisterReceiver(this.f11409b);
            this.f11409b.f11407b = false;
        }
    }

    public static void m11752t(NetInfoModule netInfoModule) {
        String u = netInfoModule.m11753u();
        if (!u.equalsIgnoreCase(netInfoModule.f11411d)) {
            netInfoModule.f11411d = u;
            netInfoModule.m11754v();
        }
    }

    private String m11753u() {
        try {
            NetworkInfo activeNetworkInfo = this.f11408a.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return "NONE";
            }
            if (ConnectivityManager.isNetworkTypeValid(activeNetworkInfo.getType())) {
                return activeNetworkInfo.getTypeName().toUpperCase();
            }
            return "UNKNOWN";
        } catch (SecurityException e) {
            this.f11410c = true;
            return "UNKNOWN";
        }
    }

    private WritableMap m11755w() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("network_info", this.f11411d);
        return writableNativeMap;
    }
}
