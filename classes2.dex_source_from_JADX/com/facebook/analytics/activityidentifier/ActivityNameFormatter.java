package com.facebook.analytics.activityidentifier;

import android.app.Activity;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.inject.InjectorLike;

/* compiled from: subscribe_source */
public class ActivityNameFormatter {
    public static ActivityNameFormatter m6512a(InjectorLike injectorLike) {
        return new ActivityNameFormatter();
    }

    public static String m6513a(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (!(activity instanceof AnalyticsActivityContentUri)) {
            return localClassName;
        }
        String a = ((AnalyticsActivityContentUri) activity).m13019a();
        if (a == null) {
            return localClassName;
        }
        Uri parse = Uri.parse(a);
        String scheme = parse.getScheme();
        if (!FBLinks.f2152a.equalsIgnoreCase(scheme) && !"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
            return localClassName;
        }
        return localClassName + " | " + new Builder().scheme(scheme).authority(parse.getAuthority()).build().toString();
    }
}
