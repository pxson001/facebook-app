package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.util.Log;

public enum zze {
    GOOGLE("google.com", 2131233768, "https://accounts.google.com"),
    FACEBOOK("facebook.com", 2131233769, "https://www.facebook.com");
    
    private final String zzUB;
    private final String zzVL;
    private final int zzVM;

    private zze(String str, int i, String str2) {
        this.zzVL = str;
        this.zzVM = i;
        this.zzUB = str2;
    }

    public static zze zzbI(String str) {
        if (str != null) {
            for (zze com_google_android_gms_auth_api_signin_zze : values()) {
                if (com_google_android_gms_auth_api_signin_zze.zzmC().equals(str)) {
                    return com_google_android_gms_auth_api_signin_zze;
                }
            }
            Log.w("IdProvider", "Unrecognized providerId: " + str);
        }
        return null;
    }

    public final String toString() {
        return this.zzVL;
    }

    public final CharSequence zzad(Context context) {
        return context.getResources().getString(this.zzVM);
    }

    public final String zzmC() {
        return this.zzVL;
    }
}
