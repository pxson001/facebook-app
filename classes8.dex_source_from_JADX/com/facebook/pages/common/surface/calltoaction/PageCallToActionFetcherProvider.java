package com.facebook.pages.common.surface.calltoaction;

import android.content.Context;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: creationDateTime */
public class PageCallToActionFetcherProvider extends AbstractAssistedProvider<PageCallToActionFetcher> {
    public final PageCallToActionFetcher m19688a(String str) {
        return new PageCallToActionFetcher(GraphQLQueryExecutor.a(this), (Context) getInstance(Context.class), str);
    }
}
