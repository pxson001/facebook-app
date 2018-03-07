package com.facebook.oxygen.preloads.sdk.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: reaction_android_hashtags */
public class PreloadSdkPresence {
    public static final Set<String> f8158a;
    private final PackageManager f8159b;

    static {
        Set hashSet = new HashSet();
        hashSet.add("android.permission.INSTALL_PACKAGES");
        hashSet.add("android.permission.DELETE_PACKAGES");
        hashSet.add("android.permission.CHANGE_COMPONENT_ENABLED_STATE");
        f8158a = Collections.unmodifiableSet(hashSet);
    }

    public PreloadSdkPresence(PackageManager packageManager) {
        this.f8159b = packageManager;
    }

    public final int m12699a() {
        return m12694a(PreloadSdkConstants.f13866a);
    }

    public final boolean m12701b() {
        return m12700a(0);
    }

    public final boolean m12700a(int i) {
        return m12698c() >= i;
    }

    private int m12698c() {
        int i = 0;
        try {
            PackageInfo packageInfo = this.f8159b.getPackageInfo(PreloadSdkConstants.f13866a, 192);
            try {
                PackageInfo packageInfo2 = this.f8159b.getPackageInfo(PreloadSdkConstants.f13868c, 0);
                if (!packageInfo.applicationInfo.enabled) {
                    return -102;
                }
                if (!packageInfo2.applicationInfo.enabled) {
                    return -103;
                }
                if (!m12695a(packageInfo, packageInfo2)) {
                    return -104;
                }
                if (!m12697a(PreloadSdkConstants.f13868c, f8158a)) {
                    return -105;
                }
                if (packageInfo.versionCode >= 20297189) {
                    i = 1;
                }
                return m12693a(packageInfo, i);
            } catch (NameNotFoundException e) {
                return -101;
            }
        } catch (NameNotFoundException e2) {
            return -100;
        }
    }

    private boolean m12695a(PackageInfo packageInfo, PackageInfo packageInfo2) {
        boolean a = m12696a(packageInfo, PreloadSdkConstants.f13877l);
        boolean a2 = m12696a(packageInfo, PreloadSdkConstants.f13873h);
        boolean a3 = m12696a(packageInfo2, PreloadSdkConstants.f13877l);
        boolean a4 = m12696a(packageInfo2, PreloadSdkConstants.f13873h);
        boolean z = (a3 || a4) ? false : true;
        if (a && a3) {
            return true;
        }
        if (a2 && a4) {
            return true;
        }
        if (!z) {
            return false;
        }
        if (a || a2) {
            return true;
        }
        return false;
    }

    private static boolean m12696a(PackageInfo packageInfo, Signature signature) {
        if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
            return false;
        }
        return signature.equals(packageInfo.signatures[0]);
    }

    private boolean m12697a(String str, Set<String> set) {
        for (String checkPermission : set) {
            if (this.f8159b.checkPermission(checkPermission, str) != 0) {
                return false;
            }
        }
        return true;
    }

    private static int m12693a(PackageInfo packageInfo, int i) {
        Bundle bundle = packageInfo.applicationInfo.metaData;
        if (bundle != null) {
            return bundle.getInt("com.facebook.appmanager.api.level", i);
        }
        return i;
    }

    private int m12694a(String str) {
        try {
            PackageInfo packageInfo = this.f8159b.getPackageInfo(str, 0);
            if (packageInfo.applicationInfo.enabled) {
                return packageInfo.versionCode;
            }
            return -packageInfo.versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }
}
