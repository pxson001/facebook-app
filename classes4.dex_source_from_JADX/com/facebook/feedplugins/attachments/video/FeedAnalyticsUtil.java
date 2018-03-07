package com.facebook.feedplugins.attachments.video;

import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;

/* compiled from: photos_eviction_tracking */
public class FeedAnalyticsUtil {

    /* compiled from: photos_eviction_tracking */
    /* synthetic */ class C02101 {
        static final /* synthetic */ int[] f4803a = new int[FeedListName.values().length];

        static {
            try {
                f4803a[FeedListName.FEED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4803a[FeedListName.PERMALINK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4803a[FeedListName.MY_TIMELINE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4803a[FeedListName.OTHER_PERSON_TIMELINE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4803a[FeedListName.PAGE_TIMELINE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4803a[FeedListName.GROUPS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f4803a[FeedListName.GROUPS_PENDING.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f4803a[FeedListName.GROUPS_PINNED.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f4803a[FeedListName.GROUPS_REPORTED.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f4803a[FeedListName.EVENTS.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f4803a[FeedListName.VIDEO_HOME.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f4803a[FeedListName.SEARCH_RESULTS.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    public static PlayerOrigin m5245a(FeedListType feedListType) {
        if (feedListType == null) {
            return PlayerOrigin.UNKNOWN;
        }
        switch (C02101.f4803a[feedListType.a().ordinal()]) {
            case 1:
                return PlayerOrigin.FEED;
            case 2:
                return PlayerOrigin.PERMALINK;
            case 3:
            case 4:
                return PlayerOrigin.USER_TIMELINE;
            case 5:
                return PlayerOrigin.PAGE_TIMELINE;
            case 6:
            case 7:
            case 8:
            case 9:
                return PlayerOrigin.GROUP;
            case 10:
                return PlayerOrigin.EVENT;
            case 11:
                return PlayerOrigin.VIDEO_HOME;
            case 12:
                return PlayerOrigin.SEARCH_RESULTS;
            default:
                return PlayerOrigin.UNKNOWN;
        }
    }
}
