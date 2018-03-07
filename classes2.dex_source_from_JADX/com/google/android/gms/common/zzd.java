package com.google.android.gms.common;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import java.util.Set;

public class zzd {
    public static final zzd f67a = new zzd();

    private zzd() {
    }

    static zza m170a(PackageInfo packageInfo, zza... com_google_android_gms_common_zzc_zzaArr) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zza com_google_android_gms_common_zzc_zzb = new zzb(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < com_google_android_gms_common_zzc_zzaArr.length; i++) {
            if (com_google_android_gms_common_zzc_zzaArr[i].equals(com_google_android_gms_common_zzc_zzb)) {
                return com_google_android_gms_common_zzc_zzaArr[i];
            }
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(com_google_android_gms_common_zzc_zzb.mo767a(), 0));
        }
        return null;
    }

    public static zzd m171a() {
        return f67a;
    }

    private static boolean m172a(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        Set set;
        zza com_google_android_gms_common_zzc_zzb = new zzb(packageInfo.signatures[0].toByteArray());
        if (z) {
            if (zzc.f147c == null) {
                zzc.f147c = zzc.m291a(zzc.f146b);
            }
            set = zzc.f147c;
        } else {
            if (zzc.f148d == null) {
                zzc.f148d = zzc.m291a(zzc.f145a);
            }
            set = zzc.f148d;
        }
        if (set.contains(com_google_android_gms_common_zzc_zzb)) {
            return true;
        }
        if (Log.isLoggable("GoogleSignatureVerifier", 2)) {
            Log.v("GoogleSignatureVerifier", "Signature not valid.  Found: \n" + Base64.encodeToString(com_google_android_gms_common_zzc_zzb.mo767a(), 0));
        }
        return false;
    }

    private boolean m173a(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        Object obj;
        boolean a;
        if (!GooglePlayServicesUtil.m163b(packageManager)) {
            if (GooglePlayServicesUtil.f58b ? GooglePlayServicesUtil.f59c : "user".equals(Build.TYPE)) {
                obj = null;
                if (obj != null) {
                    return m172a(packageInfo, true);
                }
                a = m172a(packageInfo, false);
                if (a && m172a(packageInfo, true)) {
                    Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                    return a;
                }
            }
        }
        obj = 1;
        if (obj != null) {
            return m172a(packageInfo, true);
        }
        a = m172a(packageInfo, false);
        return a ? a : a;
    }

    public final boolean m174a(PackageManager packageManager, String str) {
        try {
            return m173a(packageManager, packageManager.getPackageInfo(str, 64));
        } catch (NameNotFoundException e) {
            if (Log.isLoggable("GoogleSignatureVerifier", 3)) {
                Log.d("GoogleSignatureVerifier", "Package manager can't find package " + str + ", defaulting to false");
            }
            return false;
        }
    }
}
