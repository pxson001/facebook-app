package com.facebook.messaging.analytics.perf;

import com.facebook.fbservice.results.DataFetchDisposition.DataSource;

/* compiled from: p2p_history_get_success */
/* synthetic */ class MessagingPerformanceLogger$2 {
    static final /* synthetic */ int[] f7647a = new int[DataSource.values().length];

    static {
        try {
            f7647a[DataSource.IN_MEMORY_CACHE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f7647a[DataSource.LOCAL_DISK_CACHE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f7647a[DataSource.LOCAL_UNSPECIFIED_CACHE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f7647a[DataSource.SERVER.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
