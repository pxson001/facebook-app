package com.facebook.wifiscan;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import javax.annotation.Nullable;

/* compiled from: d42892a0f1e0b919561d213608382987 */
public class ConnectedWifis {
    @Nullable
    public static WifiInfo m20242a(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        return (connectionInfo == null || TextUtils.isEmpty(connectionInfo.getBSSID())) ? null : connectionInfo;
    }

    private ConnectedWifis() {
    }
}
