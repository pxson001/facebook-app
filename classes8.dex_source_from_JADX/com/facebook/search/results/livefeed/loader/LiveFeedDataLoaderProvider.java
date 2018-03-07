package com.facebook.search.results.livefeed.loader;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.ui.futures.TasksManager;

/* compiled from: SEARCH_SUGGESTION */
public class LiveFeedDataLoaderProvider extends AbstractAssistedProvider<LiveFeedDataLoader> {
    public final LiveFeedDataLoader m26909a(SearchResultsMutableContext searchResultsMutableContext, LiveFeedDataHandler liveFeedDataHandler) {
        return new LiveFeedDataLoader(GraphQLQueryExecutor.a(this), TasksManager.b(this), searchResultsMutableContext, liveFeedDataHandler);
    }
}
