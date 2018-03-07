package com.facebook.platform.common.util;

import android.app.ActivityManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import com.facebook.common.android.ActivityManagerMethodAutoProvider;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.inject.Inject;

/* compiled from: storefront_collection */
public class PlatformPackageUtilities {
    private static final Class<?> f4097a = PlatformPackageUtilities.class;
    public final PackageManager f4098b;
    private final ActivityManager f4099c;

    public static PlatformPackageUtilities m6010b(InjectorLike injectorLike) {
        return new PlatformPackageUtilities(PackageManagerMethodAutoProvider.a(injectorLike), ActivityManagerMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public PlatformPackageUtilities(PackageManager packageManager, ActivityManager activityManager) {
        this.f4098b = packageManager;
        this.f4099c = activityManager;
    }

    public final String m6012a(String str) {
        return m6013a(str, 9);
    }

    public final String m6013a(String str, int i) {
        byte[] c = m6011c(str);
        if (c == null) {
            return null;
        }
        return Base64.encodeToString(c, i);
    }

    public final String m6014b(String str) {
        try {
            return this.f4098b.getApplicationLabel(this.f4098b.getApplicationInfo(str, 0)).toString();
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    private byte[] m6011c(String str) {
        byte[] bArr = null;
        try {
            PackageInfo packageInfo = this.f4098b.getPackageInfo(str, 64);
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(packageInfo.signatures[0].toByteArray());
                return instance.digest();
            } catch (NoSuchAlgorithmException e) {
                BLog.b(f4097a, "Failed to instantiate SHA-1 algorithm. It is evidently missing from this system.");
                return bArr;
            }
        } catch (NameNotFoundException e2) {
            BLog.b(f4097a, "Failed to read calling package's signature.");
            return bArr;
        }
    }
}
