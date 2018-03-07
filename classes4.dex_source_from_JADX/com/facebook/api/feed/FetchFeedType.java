package com.facebook.api.feed;

/* compiled from: smallFaceImage */
public enum FetchFeedType {
    LATEST_N_STORIES,
    LATEST_N_STORIES_BEFORE_A_CURSOR,
    LATEST_N_STORIES_AFTER_A_CURSOR,
    N_STORIES_BETWEEN_CURSORS;

    public static FetchFeedType getQueryType(FetchFeedParams fetchFeedParams) {
        if (fetchFeedParams.e != null && fetchFeedParams.d != null) {
            return N_STORIES_BETWEEN_CURSORS;
        }
        if (fetchFeedParams.e != null) {
            return LATEST_N_STORIES_AFTER_A_CURSOR;
        }
        if (fetchFeedParams.d != null) {
            return LATEST_N_STORIES_BEFORE_A_CURSOR;
        }
        return LATEST_N_STORIES;
    }
}
