package com.facebook.placetips.settings.graphql;

import javax.annotation.Nullable;

/* compiled from: markerInactiveStarted */
public class GravitySettingsUtil {
    public static boolean m21578a(@Nullable C0638x892114ef c0638x892114ef) {
        if (c0638x892114ef == null) {
            return true;
        }
        return c0638x892114ef.m21397a();
    }

    public static boolean m21579b(@Nullable C0638x892114ef c0638x892114ef) {
        if (m21578a(c0638x892114ef)) {
            boolean z;
            if (c0638x892114ef == null) {
                z = false;
            } else {
                z = c0638x892114ef.m21400d();
            }
            if (z && m21580c(c0638x892114ef)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m21580c(@Nullable C0638x892114ef c0638x892114ef) {
        if (c0638x892114ef == null) {
            return false;
        }
        return c0638x892114ef.m21399c();
    }
}
