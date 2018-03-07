package com.facebook.search.results.environment;

import android.content.Context;
import com.facebook.feed.environment.impl.HasContextImplProvider;
import com.facebook.feed.environment.impl.HasInvalidateImplProvider;
import com.facebook.feed.environment.impl.HasPersistentStateImpl;
import com.facebook.feed.environment.impl.HasPositionInformationImpl;
import com.facebook.feed.rows.core.analytics.HasIsAsyncImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.search.results.environment.entity.CanProvideRoleForEntityEntitiesImpl;
import com.facebook.search.results.environment.entity.OldCanApplyEntityInlineActionImplProvider;
import com.facebook.search.results.environment.entity.OldCanLogEntityNavigationEntitiesImplProvider;
import com.facebook.search.results.model.SearchResultsEntitiesCollection;
import com.facebook.search.results.model.SearchResultsMutableContext;

/* compiled from: Souvenir NUX */
public class SearchResultsEntitiesEnvironmentGeneratedProvider extends AbstractAssistedProvider<SearchResultsEntitiesEnvironmentGenerated> {
    public final SearchResultsEntitiesEnvironmentGenerated m26063a(Context context, Runnable runnable, SearchResultsEntitiesCollection searchResultsEntitiesCollection, SearchResultsMutableContext searchResultsMutableContext, SearchResultsEntitiesCollection searchResultsEntitiesCollection2) {
        return new SearchResultsEntitiesEnvironmentGenerated(context, runnable, searchResultsEntitiesCollection, searchResultsMutableContext, searchResultsEntitiesCollection2, (HasContextImplProvider) getOnDemandAssistedProviderForStaticDi(HasContextImplProvider.class), (HasInvalidateImplProvider) getOnDemandAssistedProviderForStaticDi(HasInvalidateImplProvider.class), HasIsAsyncImpl.a(this), HasPersistentStateImpl.a(this), HasPositionInformationImpl.a(this), (HasFeedItemPositionEntitiesImplProvider) getOnDemandAssistedProviderForStaticDi(HasFeedItemPositionEntitiesImplProvider.class), (HasSearchResultsContextImplProvider) getOnDemandAssistedProviderForStaticDi(HasSearchResultsContextImplProvider.class), (OldCanApplyEntityInlineActionImplProvider) getOnDemandAssistedProviderForStaticDi(OldCanApplyEntityInlineActionImplProvider.class), (OldCanLogEntityNavigationEntitiesImplProvider) getOnDemandAssistedProviderForStaticDi(OldCanLogEntityNavigationEntitiesImplProvider.class), CanProvideRoleForEntityEntitiesImpl.m26232a(this), (CanReplaceFeedItemEntitiesImplProvider) getOnDemandAssistedProviderForStaticDi(CanReplaceFeedItemEntitiesImplProvider.class));
    }
}
