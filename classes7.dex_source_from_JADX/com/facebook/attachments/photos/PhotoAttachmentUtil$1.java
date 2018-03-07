package com.facebook.attachments.photos;

import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.rows.core.FeedListName;

/* compiled from: used_edge_control */
/* synthetic */ class PhotoAttachmentUtil$1 {
    static final /* synthetic */ int[] f911a = new int[StoryRenderContext.values().length];
    static final /* synthetic */ int[] f912b = new int[FeedListName.values().length];

    static {
        try {
            f912b[FeedListName.FEED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f912b[FeedListName.MY_TIMELINE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f912b[FeedListName.OTHER_PERSON_TIMELINE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f911a[StoryRenderContext.NEWSFEED.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f911a[StoryRenderContext.TIMELINE.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
    }
}
