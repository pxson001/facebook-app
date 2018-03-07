package com.facebook.messaging.connectivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.MultiBinderSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.commerceui.connectivity.CommerceWifiConnectivityListener;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

@SuppressLint({"BadSuperClassBroadcastReceiver.SecureBroadcastReceiver"})
/* compiled from: is_muted */
public class ConnectivityBroadcastReceiver extends BroadcastReceiver {
    private static final String[] f12031d = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    @Inject
    public RuntimePermissionsUtil f12032a;
    @Inject
    public Set<ConnectivityListener> f12033b;
    @Inject
    public GatekeeperStoreImpl f12034c;

    /* compiled from: is_muted */
    public class WifiNetwork {
        public String f12027a;
        public String f12028b;
        public int f12029c;
        public final State f12030d;

        public WifiNetwork(String str, String str2, int i) {
            this(str, str2, i, State.UNKNOWN);
        }

        public WifiNetwork(String str, String str2, int i, State state) {
            this.f12027a = str;
            this.f12028b = str2;
            this.f12029c = i;
            this.f12030d = state;
        }
    }

    public static void m18938a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ConnectivityBroadcastReceiver connectivityBroadcastReceiver = (ConnectivityBroadcastReceiver) obj;
        RuntimePermissionsUtil b = RuntimePermissionsUtil.b(fbInjector);
        Set multiBinderSet = new MultiBinderSet(fbInjector.getScopeAwareInjector(), new C0777x8b83054f(fbInjector));
        GatekeeperStoreImpl a = GatekeeperStoreImplMethodAutoProvider.a(fbInjector);
        connectivityBroadcastReceiver.f12032a = b;
        connectivityBroadcastReceiver.f12033b = multiBinderSet;
        connectivityBroadcastReceiver.f12034c = a;
    }

    public void onReceive(Context context, Intent intent) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 935741562);
        Class cls = ConnectivityBroadcastReceiver.class;
        m18938a(this, context);
        if (!this.f12034c.a(346, false) || this.f12033b == null || this.f12033b.isEmpty()) {
            LogUtils.a(intent, 2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1472231656, a);
            return;
        }
        String action = intent.getAction();
        if (Strings.isNullOrEmpty(action)) {
            LogUtils.a(intent, 396423866, a);
            return;
        }
        WifiInfo wifiInfo;
        if ("android.net.wifi.STATE_CHANGE".equals(action)) {
            wifiInfo = (WifiInfo) intent.getParcelableExtra("wifiInfo");
            if (wifiInfo == null || Strings.isNullOrEmpty(wifiInfo.getSSID()) || Strings.isNullOrEmpty(wifiInfo.getBSSID())) {
                LogUtils.a(intent, -159803035, a);
                return;
            }
            WifiNetwork wifiNetwork = new WifiNetwork(wifiInfo.getSSID(), wifiInfo.getBSSID(), WifiManager.calculateSignalLevel(wifiInfo.getRssi(), 10), ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState());
            for (CommerceWifiConnectivityListener a2 : this.f12033b) {
                a2.a(wifiNetwork);
            }
        } else if ("android.net.wifi.SCAN_RESULTS".equals(action)) {
            if (this.f12032a.a(f12031d)) {
                r0 = (WifiManager) context.getSystemService("wifi");
                if (r0 == null) {
                    LogUtils.a(intent, -365822386, a);
                    return;
                }
                List<ScanResult> scanResults = r0.getScanResults();
                if (scanResults == null || scanResults.isEmpty()) {
                    LogUtils.a(intent, -222326220, a);
                    return;
                }
                Builder builder = new Builder();
                for (ScanResult scanResult : scanResults) {
                    if (!(Strings.isNullOrEmpty(scanResult.SSID) || Strings.isNullOrEmpty(scanResult.BSSID))) {
                        builder.c(new WifiNetwork(scanResult.SSID, scanResult.BSSID, WifiManager.calculateSignalLevel(scanResult.level, 10)));
                    }
                }
                ImmutableList b = builder.b();
                for (CommerceWifiConnectivityListener a22 : this.f12033b) {
                    a22.a(b);
                }
            } else {
                LogUtils.a(intent, -454389900, a);
                return;
            }
        } else if ("android.net.wifi.RSSI_CHANGED".equals(action)) {
            r0 = (WifiManager) context.getSystemService("wifi");
            if (r0 == null) {
                LogUtils.a(intent, -905622643, a);
                return;
            }
            wifiInfo = r0.getConnectionInfo();
            if (wifiInfo == null || Strings.isNullOrEmpty(wifiInfo.getSSID()) || Strings.isNullOrEmpty(wifiInfo.getBSSID())) {
                LogUtils.a(intent, 1388468467, a);
                return;
            }
            WifiNetwork wifiNetwork2 = new WifiNetwork(wifiInfo.getSSID(), wifiInfo.getBSSID(), WifiManager.calculateSignalLevel(wifiInfo.getRssi(), 10));
            Iterator it = this.f12033b.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        LogUtils.a(intent, -725719252, a);
    }
}
