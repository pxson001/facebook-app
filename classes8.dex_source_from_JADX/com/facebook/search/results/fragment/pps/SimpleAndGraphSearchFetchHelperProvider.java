package com.facebook.search.results.fragment.pps;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.model.converter.EntitySuggestionGraphQLModelConverter;
import com.facebook.search.model.converter.FilterGraphQLModelConverter;
import com.facebook.search.suggestions.simplesearch.SimpleSearchResultsPageLoader;
import com.facebook.ui.futures.TasksManager;

/* compiled from: SEE_MORE_SEQUENCE */
public class SimpleAndGraphSearchFetchHelperProvider extends AbstractAssistedProvider<SimpleAndGraphSearchFetchHelper> {
    public final SimpleAndGraphSearchFetchHelper m26795a(SeeMoreResultsPagerAdapter seeMoreResultsPagerAdapter) {
        return new SimpleAndGraphSearchFetchHelper(seeMoreResultsPagerAdapter, new SimpleSearchResultsPageLoader(GraphQLQueryExecutor.a(this), ResourcesMethodAutoProvider.a(this), EntitySuggestionGraphQLModelConverter.m25799a((InjectorLike) this), FilterGraphQLModelConverter.m25802a((InjectorLike) this), TasksManager.b(this), GraphSearchErrorReporter.a(this)));
    }
}
