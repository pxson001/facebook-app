package com.facebook.feed.analytics;

import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: has_root_fragment_inited */
public class AnalyticsHelper {

    /* compiled from: has_root_fragment_inited */
    /* synthetic */ class C09081 {
        static final /* synthetic */ int[] f22388a = new int[FeedListName.values().length];

        static {
            try {
                f22388a[FeedListName.FEED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22388a[FeedListName.MY_TIMELINE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22388a[FeedListName.OTHER_PERSON_TIMELINE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f22388a[FeedListName.PERMALINK.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f22388a[FeedListName.GROUPS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f22388a[FeedListName.GROUPS_PINNED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f22388a[FeedListName.GROUPS_PENDING.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f22388a[FeedListName.GROUPS_REPORTED.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f22388a[FeedListName.SEARCH.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f22388a[FeedListName.SEARCH_DENSE_FEED.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f22388a[FeedListName.SEARCH_DENSE_FEED_WITHOUT_UFI.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f22388a[FeedListName.EVENTS.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f22388a[FeedListName.PAGE_TIMELINE.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f22388a[FeedListName.REACTION.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f22388a[FeedListName.REDSPACE_OTHER.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f22388a[FeedListName.REDSPACE_SELF.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f22388a[FeedListName.VIDEO_CHANNEL.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
        }
    }

    public static AnalyticsHelper m28994a(InjectorLike injectorLike) {
        return new AnalyticsHelper();
    }

    public static String m28995a(FeedListType feedListType) {
        switch (C09081.f22388a[feedListType.mo2419a().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return StoryRenderContext.NEWSFEED.analyticModule;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                return StoryRenderContext.TIMELINE.analyticModule;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return StoryRenderContext.PERMALINK.analyticModule;
            case 5:
            case 6:
            case 7:
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return StoryRenderContext.GROUP.analyticModule;
            case 9:
            case 10:
            case 11:
                return StoryRenderContext.SEARCH.analyticModule;
            case 12:
                return StoryRenderContext.EVENT.analyticModule;
            case 13:
                return StoryRenderContext.PAGE.analyticModule;
            case 14:
                return StoryRenderContext.REACTION.analyticModule;
            case 15:
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                return StoryRenderContext.REDSPACE.analyticModule;
            case 17:
                return StoryRenderContext.VIDEO_CHANNEL.analyticModule;
            default:
                return "unknown";
        }
    }

    public static String m28996b(FeedListType feedListType) {
        switch (C09081.f22388a[feedListType.mo2419a().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "newsfeed_ufi";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                return "timeline_ufi";
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return "permalink_ufi";
            case 5:
            case 6:
            case 7:
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return "groups_ufi";
            case 9:
            case 10:
            case 11:
                return "search_ufi";
            case 12:
                return "events_ufi";
            case 13:
                return "pages_identity_ufi";
            case 14:
                return "reactions_ufi";
            case 15:
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                return "redspace";
            default:
                return "unknown";
        }
    }
}
