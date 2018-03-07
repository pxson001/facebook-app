package com.facebook.saved.common.data;

import javax.annotation.Nullable;

/* compiled from: fetch_broadcast_id_failed */
public enum RecentSaveTimeframe {
    PAST_WEEK,
    PAST_MONTH;

    public static RecentSaveTimeframe convertString(@Nullable String str) {
        if (str == null) {
            return PAST_WEEK;
        }
        try {
            return valueOf(str);
        } catch (IllegalArgumentException e) {
            return PAST_WEEK;
        }
    }
}
