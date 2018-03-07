package com.facebook.oxygen.preloads.sdk.common;

import android.content.pm.Signature;
import com.facebook.oxygen.installer.certificates.TrustedCertificates;
import com.facebook.oxygen.preloads.sdk.build.SdkBuildConstants;

/* compiled from: messenger_montage_alpha */
public class PreloadSdkConstants {
    public static final String f13866a;
    public static final String f13867b;
    public static final String f13868c;
    public static final String f13869d;
    public static final String f13870e;
    public static final Signature f13871f = TrustedCertificates.f13881b;
    public static final Signature f13872g = TrustedCertificates.f13880a;
    public static final Signature f13873h;
    public static final String f13874i;
    public static final Signature f13875j = TrustedCertificates.f13883d;
    public static final Signature f13876k = TrustedCertificates.f13882c;
    public static final Signature f13877l;
    public static final String f13878m;

    static {
        String str;
        Signature signature;
        if (SdkBuildConstants.f13879a) {
            str = "com.facebook.appmanager.dev";
        } else {
            str = "com.facebook.appmanager";
        }
        f13866a = str;
        if (SdkBuildConstants.f13879a) {
            str = "com.facebook.appmanager.dev.ACCESS";
        } else {
            str = "com.facebook.appmanager.ACCESS";
        }
        f13867b = str;
        if (SdkBuildConstants.f13879a) {
            str = "com.facebook.system.dev";
        } else {
            str = "com.facebook.system";
        }
        f13868c = str;
        if (SdkBuildConstants.f13879a) {
            str = "com.facebook.system.dev.ACCESS";
        } else {
            str = "com.facebook.system.ACCESS";
        }
        f13869d = str;
        if (SdkBuildConstants.f13879a) {
            str = "com.facebook.permission.debug.FB_APP_COMMUNICATION";
        } else {
            str = "com.facebook.permission.prod.FB_APP_COMMUNICATION";
        }
        f13870e = str;
        if (SdkBuildConstants.f13879a) {
            signature = f13871f;
        } else {
            signature = f13872g;
        }
        f13873h = signature;
        if (SdkBuildConstants.f13879a) {
            str = "7XE60X540nq3JXIiFpcVSgM8diY";
        } else {
            str = "e6fv6XFRr-tXEDJmsSANhagF19Y";
        }
        f13874i = str;
        if (SdkBuildConstants.f13879a) {
            signature = f13875j;
        } else {
            signature = f13876k;
        }
        f13877l = signature;
        if (SdkBuildConstants.f13879a) {
            str = "Xo8WBi6jzSxKDVR4drqm84yr9iU";
        } else {
            str = "ijxLJi1yGs1JpL-X1SExmchvork";
        }
        f13878m = str;
    }
}
