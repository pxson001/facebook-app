package com.facebook.search.results.factory.graphsearch;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLInterfaces.KeywordSearchModuleFragment;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchModuleFragmentModel;
import com.facebook.search.results.factory.SearchResultsFeedUnitFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: SUGGEST_EDITS */
public abstract class GraphSearchSingleFeedUnitFactory<F extends FeedUnit> implements SearchResultsFeedUnitFactory<KeywordSearchModuleFragment, F> {
    @Nullable
    protected abstract F mo1261a(KeywordSearchModuleFragment keywordSearchModuleFragment);

    public final /* synthetic */ ImmutableList mo1260a(Object obj) {
        return m26282b((KeywordSearchModuleFragmentModel) obj);
    }

    public final ImmutableList<F> m26282b(KeywordSearchModuleFragment keywordSearchModuleFragment) {
        FeedUnit a = mo1261a((KeywordSearchModuleFragmentModel) keywordSearchModuleFragment);
        return a != null ? ImmutableList.of(a) : RegularImmutableList.a;
    }
}
