package com.facebook.analytics.cache;

/* compiled from: measurement.upload.max_bundles */
public enum CacheCounterType {
    HITS_COUNT("hits"),
    MISSES_COUNT("misses"),
    BYTES_COUNT("bytes"),
    ENTRIES_COUNT("entries"),
    EVICTIONS_ON_CACHE_FULL_CALL("eviction_on_cache_full_call"),
    EVICTIONS_ON_CACHE_FULL_ITEM("eviction_on_cache_full_item"),
    EVICTIONS_ON_CACHE_FULL_SIZE("eviction_on_cache_full_size"),
    EVICTIONS_ON_CONTENT_STALE_CALL("eviction_on_stale_call"),
    EVICTIONS_ON_CONTENT_STALE_ITEM("eviction_on_stale_item"),
    EVICTIONS_ON_CONTENT_STALE_SIZE("eviction_on_stale_size"),
    EVICTIONS_ON_USER_FORCED_CALL("eviction_on_user_forced_call"),
    EVICTIONS_ON_USER_FORCED_ITEM("eviction_on_user_forced_item"),
    EVICTIONS_ON_USER_FORCED_SIZE("eviction_on_user_forced_size"),
    EVICTIONS_ON_CACHE_MANAGER_TRIMMED_CALL("eviction_on_cache_manager_trimmed_call"),
    EVICTIONS_ON_CACHE_MANAGER_TRIMMED_ITEM("eviction_on_cache_manager_trimmed_item"),
    EVICTIONS_ON_CACHE_MANAGER_TRIMMED_SIZE("eviction_on_cache_manager_trimmed_size"),
    INSERTION_ITEM("insertion_item"),
    INSERTION_SIZE("insertion_size"),
    WRITE_EXCEPTION_COUNT("write_exceptions"),
    READ_EXCEPTION_COUNT("read_exceptions"),
    WRITE_ATTEMPTS("write_attempts"),
    HIT_TIME_MS("hit_time_ms"),
    INSERTION_TIME_MS("insertion_time_ms");
    
    private final String name;

    private CacheCounterType(String str) {
        this.name = str;
    }

    public final String toString() {
        return this.name;
    }
}
