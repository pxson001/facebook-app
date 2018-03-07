package com.facebook.feed.protocol;

import com.facebook.api.feed.FetchFeedParams.FetchTypeForLogging;
import com.facebook.api.feed.FetchFeedType;

/* compiled from: smallPictureSize */
/* synthetic */ class FetchNewsFeedMethod$1 {
    static final /* synthetic */ int[] f2139a = new int[FetchFeedType.values().length];
    static final /* synthetic */ int[] f2140b = new int[FetchTypeForLogging.values().length];

    static {
        try {
            f2140b[FetchTypeForLogging.HEAD.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2140b[FetchTypeForLogging.CHUNKED_INITIAL.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f2140b[FetchTypeForLogging.CHUNKED_REMAINDER.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f2140b[FetchTypeForLogging.TAIL.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f2139a[FetchFeedType.LATEST_N_STORIES.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f2139a[FetchFeedType.LATEST_N_STORIES_BEFORE_A_CURSOR.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f2139a[FetchFeedType.LATEST_N_STORIES_AFTER_A_CURSOR.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f2139a[FetchFeedType.N_STORIES_BETWEEN_CURSORS.ordinal()] = 4;
        } catch (NoSuchFieldError e8) {
        }
    }
}
