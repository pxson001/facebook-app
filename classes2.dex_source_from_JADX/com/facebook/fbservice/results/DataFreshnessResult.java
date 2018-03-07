package com.facebook.fbservice.results;

/* compiled from: saved_bookmark_nux_imp */
public enum DataFreshnessResult {
    FROM_SERVER,
    FROM_CACHE_UP_TO_DATE,
    FROM_CACHE_STALE,
    NO_DATA,
    FROM_CACHE_INCOMPLETE,
    FROM_CACHE_HAD_SERVER_ERROR,
    FROM_DB_NEED_INITIAL_FETCH
}
