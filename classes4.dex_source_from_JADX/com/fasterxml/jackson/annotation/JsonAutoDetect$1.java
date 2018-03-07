package com.fasterxml.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

/* compiled from: video_home_badge_count */
/* synthetic */ class JsonAutoDetect$1 {
    static final /* synthetic */ int[] f276a = new int[Visibility.values().length];

    static {
        try {
            f276a[Visibility.ANY.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f276a[Visibility.NONE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f276a[Visibility.NON_PRIVATE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f276a[Visibility.PROTECTED_AND_PUBLIC.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f276a[Visibility.PUBLIC_ONLY.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
