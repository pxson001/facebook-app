package com.facebook.analytics.cache;

import com.facebook.cache.common.CacheEventListener$EvictionReason;

/* compiled from: timeline_map_pagelet_link */
/* synthetic */ class CacheTracker$1 {
    static final /* synthetic */ int[] f1882a = new int[CacheEventListener$EvictionReason.values().length];

    static {
        try {
            f1882a[CacheEventListener$EvictionReason.CACHE_FULL.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1882a[CacheEventListener$EvictionReason.CONTENT_STALE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1882a[CacheEventListener$EvictionReason.USER_FORCED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1882a[CacheEventListener$EvictionReason.CACHE_MANAGER_TRIMMED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
