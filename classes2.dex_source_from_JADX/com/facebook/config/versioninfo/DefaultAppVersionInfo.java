package com.facebook.config.versioninfo;

import android.content.pm.PackageInfo;

/* compiled from: user_values */
public class DefaultAppVersionInfo extends AppVersionInfo {
    private final PackageInfo f1417b;

    public DefaultAppVersionInfo(PackageInfo packageInfo) {
        this.f1417b = packageInfo;
    }

    public final String mo367a() {
        return this.f1417b.versionName;
    }

    public final int mo368b() {
        return this.f1417b.versionCode;
    }

    public final int mo369c() {
        return AppVersionInfo.f1418a;
    }
}
