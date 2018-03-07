package com.facebook.nearby.utils;

import android.app.Activity;
import android.net.Uri;
import android.support.v4.app.Fragment;
import javax.annotation.Nullable;

/* compiled from: topLoadStart */
public class NearbyUriUtil {
    public static boolean m1068a(@Nullable Activity activity, @Nullable Fragment fragment) {
        if (activity != null && activity.getIntent() != null && m1069a(activity.getIntent().getStringExtra("extra_launch_uri"))) {
            return true;
        }
        if (fragment == null || fragment.s == null || !m1069a(fragment.s.getString("extra_launch_uri"))) {
            return false;
        }
        return true;
    }

    private static boolean m1069a(@Nullable String str) {
        if (str == null || !Uri.parse(str).getQueryParameterNames().contains("wifi")) {
            return false;
        }
        return true;
    }
}
