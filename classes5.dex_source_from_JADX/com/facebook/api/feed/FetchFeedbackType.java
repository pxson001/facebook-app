package com.facebook.api.feed;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.api.story.FetchSingleStoryParams;
import com.facebook.api.story.FetchSingleStoryParams.FetchType;

/* compiled from: atworknux */
public enum FetchFeedbackType {
    BASE_ONLY,
    COMMENTS_AND_LIKERS;

    /* compiled from: atworknux */
    /* synthetic */ class C09401 {
        static final /* synthetic */ int[] f8693a = null;

        static {
            f8693a = new int[FetchType.values().length];
            try {
                f8693a[FetchType.GRAPHQL_PHOTO_CREATION_STORY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8693a[FetchType.GRAPHQL_DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8693a[FetchType.PLATFORM_DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8693a[FetchType.GRAPHQL_FEEDBACK_DETAILS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f8693a[FetchType.NOTIFICATION_FEEDBACK_DETAILS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f8693a[FetchType.PLATFORM_FEEDBACK_DETAILS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f8693a[FetchType.GRAPHQL_VIDEO_CREATION_STORY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static FetchFeedbackType getQueryType(FetchSingleStoryParams fetchSingleStoryParams) {
        switch (C09401.f8693a[fetchSingleStoryParams.f10258d.ordinal()]) {
            case 1:
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
            case 3:
                return BASE_ONLY;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
            case 5:
            case 6:
            case 7:
                return COMMENTS_AND_LIKERS;
            default:
                return BASE_ONLY;
        }
    }
}
