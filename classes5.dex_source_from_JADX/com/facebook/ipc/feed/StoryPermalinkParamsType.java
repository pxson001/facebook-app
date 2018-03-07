package com.facebook.ipc.feed;

/* compiled from: TICKET */
public enum StoryPermalinkParamsType {
    PLATFORM_KEY,
    FEED_STORY_ID_KEY,
    FEED_STORY_JSON,
    NOTIF_STORY_JSON,
    NOTIF_STORY_ID_KEY,
    FEEDBACK_ID_KEY,
    AD_PREVIEW_PYML_JSON,
    AD_PREVIEW_STORY_JSON,
    STORY_FBID_KEY;

    public final boolean isNotificationType() {
        return this == NOTIF_STORY_JSON || this == NOTIF_STORY_ID_KEY;
    }

    public final boolean isJsonType() {
        return this == FEED_STORY_JSON || this == NOTIF_STORY_JSON || this == AD_PREVIEW_STORY_JSON || this == AD_PREVIEW_PYML_JSON;
    }
}
