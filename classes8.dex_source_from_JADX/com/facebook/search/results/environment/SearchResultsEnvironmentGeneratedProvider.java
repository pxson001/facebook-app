package com.facebook.search.results.environment;

import android.content.Context;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.feed.environment.impl.CanFollowUserImpl;
import com.facebook.feed.environment.impl.CanFriendPersonImpl;
import com.facebook.feed.environment.impl.CanLikePageImplProvider;
import com.facebook.feed.environment.impl.CanShowVideoInFullScreenImpl;
import com.facebook.feed.environment.impl.HasAnchoredTooltipProviderImpl;
import com.facebook.feed.environment.impl.HasContextImplProvider;
import com.facebook.feed.environment.impl.HasEnvironmentControllerImpl;
import com.facebook.feed.environment.impl.HasFeedListTypeImplProvider;
import com.facebook.feed.environment.impl.HasImageLoadListenerImpl;
import com.facebook.feed.environment.impl.HasInvalidateImplProvider;
import com.facebook.feed.environment.impl.HasMutationControllerManagerImplProvider;
import com.facebook.feed.environment.impl.HasPersistentStateImpl;
import com.facebook.feed.environment.impl.HasPositionInformationImpl;
import com.facebook.feed.environment.impl.HasPrefetcherNoOpImpl;
import com.facebook.feed.environment.impl.HasRowKeyImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImplProvider;
import com.facebook.feed.fragment.generatedenvironments.HasMenuButtonProviderImplProvider;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.analytics.HasIsAsyncImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.search.results.environment.entity.CanApplyEntityInlineActionImplProvider;
import com.facebook.search.results.environment.entity.CanLogEntityNavigationEntitiesImplProvider;
import com.facebook.search.results.environment.videos.HasSearchResultsVideoStoryPersistentStateImplProvider;
import com.facebook.search.results.model.SearchResultsCollection;
import com.facebook.search.results.model.SearchResultsMutableContext;

/* compiled from: Should supply INPUT_ALBUM for editing privacy */
public class SearchResultsEnvironmentGeneratedProvider extends AbstractAssistedProvider<SearchResultsEnvironmentGenerated> {
    public final SearchResultsEnvironmentGenerated m26114a(Context context, FeedListType feedListType, FeedMenuHelperReference feedMenuHelperReference, Runnable runnable, MutationControllerManager mutationControllerManager, Delegate delegate, SearchResultsCollection searchResultsCollection, SearchResultsMutableContext searchResultsMutableContext, SearchResultsCollection searchResultsCollection2) {
        return new SearchResultsEnvironmentGenerated(context, feedListType, feedMenuHelperReference, runnable, mutationControllerManager, delegate, searchResultsCollection, searchResultsMutableContext, searchResultsCollection2, (CanApplyEntityInlineActionImplProvider) getOnDemandAssistedProviderForStaticDi(CanApplyEntityInlineActionImplProvider.class), CanFollowUserImpl.a(this), CanFriendPersonImpl.a(this), (CanLikePageImplProvider) getOnDemandAssistedProviderForStaticDi(CanLikePageImplProvider.class), (CanLogEntityNavigationEntitiesImplProvider) getOnDemandAssistedProviderForStaticDi(CanLogEntityNavigationEntitiesImplProvider.class), CanShowVideoInFullScreenImpl.a(this), HasAnchoredTooltipProviderImpl.a(this), (HasContextImplProvider) getOnDemandAssistedProviderForStaticDi(HasContextImplProvider.class), HasEnvironmentControllerImpl.a(this), (HasFeedListTypeImplProvider) getOnDemandAssistedProviderForStaticDi(HasFeedListTypeImplProvider.class), (HasFeedMenuHelperImplProvider) getOnDemandAssistedProviderForStaticDi(HasFeedMenuHelperImplProvider.class), HasImageLoadListenerImpl.a(this), (HasInvalidateImplProvider) getOnDemandAssistedProviderForStaticDi(HasInvalidateImplProvider.class), HasIsAsyncImpl.a(this), (HasMenuButtonProviderImplProvider) getOnDemandAssistedProviderForStaticDi(HasMenuButtonProviderImplProvider.class), (HasMutationControllerManagerImplProvider) getOnDemandAssistedProviderForStaticDi(HasMutationControllerManagerImplProvider.class), HasPersistentStateImpl.a(this), HasPositionInformationImpl.a(this), HasPrefetcherNoOpImpl.a(this), HasRowKeyImpl.a(this), (HasScrollListenerSupportImplProvider) getOnDemandAssistedProviderForStaticDi(HasScrollListenerSupportImplProvider.class), (HasSearchResultPositionImplProvider) getOnDemandAssistedProviderForStaticDi(HasSearchResultPositionImplProvider.class), (HasSearchResultsContextImplProvider) getOnDemandAssistedProviderForStaticDi(HasSearchResultsContextImplProvider.class), (HasSearchResultsVideoStoryPersistentStateImplProvider) getOnDemandAssistedProviderForStaticDi(HasSearchResultsVideoStoryPersistentStateImplProvider.class), (CanReplaceSearchResultImplProvider) getOnDemandAssistedProviderForStaticDi(CanReplaceSearchResultImplProvider.class));
    }
}
