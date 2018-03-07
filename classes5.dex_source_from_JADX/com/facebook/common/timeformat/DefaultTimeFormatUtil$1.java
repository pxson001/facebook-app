package com.facebook.common.timeformat;

import com.facebook.common.timeformat.DefaultTimeFormatUtil.RelativeTimePeriod;

/* compiled from: should_show_recent_checkins_entry_point */
/* synthetic */ class DefaultTimeFormatUtil$1 {
    static final /* synthetic */ int[] f2737a = new int[RelativeTimePeriod.values().length];

    static {
        try {
            f2737a[RelativeTimePeriod.LESS_THAN_MIN.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2737a[RelativeTimePeriod.LESS_THAN_5_MINS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f2737a[RelativeTimePeriod.LESS_THAN_HOUR.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f2737a[RelativeTimePeriod.SAME_DAY.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f2737a[RelativeTimePeriod.LESS_THAN_ONE_DAY.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f2737a[RelativeTimePeriod.LESS_THAN_4_DAYS.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f2737a[RelativeTimePeriod.SAME_YEAR.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
    }
}
