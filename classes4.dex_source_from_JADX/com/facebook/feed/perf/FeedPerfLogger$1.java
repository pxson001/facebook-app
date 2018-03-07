package com.facebook.feed.perf;

import com.facebook.feed.perf.FeedPerfLogger.ColdStartStoryStatus;

/* compiled from: names */
/* synthetic */ class FeedPerfLogger$1 {
    static final /* synthetic */ int[] f7301a = new int[ColdStartStoryStatus.values().length];

    static {
        try {
            f7301a[ColdStartStoryStatus.DEFAULT_FRESH_NETWORK_FETCH.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f7301a[ColdStartStoryStatus.NOT_SET.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f7301a[ColdStartStoryStatus.DEFAULT_CACHED_FRESH_WITHOUT_NETWORK_FETCH.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f7301a[ColdStartStoryStatus.ASYNC_CACHE_UNSEEN_STORY.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f7301a[ColdStartStoryStatus.ASYNC_CACHE_SEEN_STORY.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f7301a[ColdStartStoryStatus.ASYNC_NO_CACHE.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f7301a[ColdStartStoryStatus.ASYNC_FRESH_FAST_NETWORK_FETCH.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f7301a[ColdStartStoryStatus.FRESH_FEED_NETWORK.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f7301a[ColdStartStoryStatus.FRESH_FEED_CACHE.ordinal()] = 9;
        } catch (NoSuchFieldError e9) {
        }
    }
}
