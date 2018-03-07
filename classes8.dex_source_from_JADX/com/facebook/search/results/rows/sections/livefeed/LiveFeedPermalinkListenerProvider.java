package com.facebook.search.results.rows.sections.livefeed;

import android.content.Context;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.model.SearchResultsMutableContext;

/* compiled from: PlacePickerNIEM */
public class LiveFeedPermalinkListenerProvider extends AbstractAssistedProvider<LiveFeedPermalinkListener> {
    public final LiveFeedPermalinkListener m27969a(GraphQLStory graphQLStory, SearchResultsMutableContext searchResultsMutableContext) {
        return new LiveFeedPermalinkListener(graphQLStory, searchResultsMutableContext, (Context) getInstance(Context.class), ViewPermalinkIntentFactory.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), SearchResultsLogger.m25460a((InjectorLike) this));
    }
}
