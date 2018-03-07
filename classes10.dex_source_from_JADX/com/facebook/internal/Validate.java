package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.facebook.FacebookActivity;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import java.util.Collection;

/* compiled from: SEND_FAILED_TIMED_OUT_AFTER_PUBLISH */
public final class Validate {
    private static final String f24057a = Validate.class.getName();

    public static void m25366a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException("Argument '" + str + "' cannot be null");
        }
    }

    private static <T> void m25370b(Collection<T> collection, String str) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Container '" + str + "' cannot be empty");
        }
    }

    private static <T> void m25371c(Collection<T> collection, String str) {
        m25366a((Object) collection, str);
        for (T t : collection) {
            if (t == null) {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            }
        }
    }

    public static <T> void m25368a(Collection<T> collection, String str) {
        m25371c(collection, str);
        m25370b((Collection) collection, str);
    }

    public static void m25367a(String str, String str2) {
        if (Utility.m25345a(str)) {
            throw new IllegalArgumentException("Argument '" + str2 + "' cannot be null or empty");
        }
    }

    public static void m25364a() {
        if (!FacebookSdk.m14046a()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    public static void m25365a(Context context, boolean z) {
        m25366a((Object) context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != -1) {
            return;
        }
        if (z) {
            throw new IllegalStateException("No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
        }
        Log.w(f24057a, "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
    }

    public static void m25369b(Context context, boolean z) {
        m25366a((Object) context, "context");
        PackageManager packageManager = context.getPackageManager();
        ActivityInfo activityInfo = null;
        if (packageManager != null) {
            try {
                activityInfo = packageManager.getActivityInfo(new ComponentName(context, FacebookActivity.class), 1);
            } catch (NameNotFoundException e) {
            }
        }
        if (activityInfo != null) {
            return;
        }
        if (z) {
            throw new IllegalStateException("FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
        }
        Log.w(f24057a, "FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
    }
}
