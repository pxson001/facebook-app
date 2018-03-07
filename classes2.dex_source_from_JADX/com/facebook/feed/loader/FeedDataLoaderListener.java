package com.facebook.feed.loader;

import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.data.FetchPortion;
import com.facebook.api.feed.data.ViewPortShift;
import com.facebook.feed.model.FetchResultState;

/* compiled from: send_message */
public interface FeedDataLoaderListener extends FeedOnDataChangeListener {
    void mo1368a();

    void mo1369a(int i, LoadIntentHint loadIntentHint);

    void mo1370a(FetchFeedCause fetchFeedCause);

    void mo1371a(boolean z, FetchFeedResult fetchFeedResult, FetchResultState fetchResultState, String str, int i, FetchPortion fetchPortion, ViewPortShift viewPortShift);

    boolean mo1372b();
}
