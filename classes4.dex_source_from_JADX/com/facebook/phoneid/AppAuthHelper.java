package com.facebook.phoneid;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Base64;
import java.security.MessageDigest;

/* compiled from: total_mem */
public class AppAuthHelper {
    public static boolean m1222a(Context context, Bundle bundle) {
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("auth");
        if (pendingIntent == null) {
            return false;
        }
        String creatorPackage;
        if (VERSION.SDK_INT >= 17) {
            creatorPackage = pendingIntent.getCreatorPackage();
        } else {
            creatorPackage = pendingIntent.getTargetPackage();
        }
        try {
            return m1223a(context.getPackageManager().getPackageInfo(creatorPackage, 64));
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static boolean m1223a(PackageInfo packageInfo) {
        String str;
        if (packageInfo.signatures == null || packageInfo.signatures.length != 1 || VERSION.SDK_INT < 8) {
            str = null;
        } else {
            str = m1221a(packageInfo.signatures[0].toByteArray());
        }
        return FbAppCertificates.f889a.contains(str);
    }

    @TargetApi(8)
    public static String m1221a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bArr, 0, bArr.length);
            return Base64.encodeToString(instance.digest(), 11);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
