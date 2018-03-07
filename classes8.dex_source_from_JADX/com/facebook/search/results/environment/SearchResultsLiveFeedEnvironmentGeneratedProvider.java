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
import com.facebook.search.results.model.SearchResultsMutableContext;

/* compiled from: SetCoverPhotoMethod */
public class SearchResultsLiveFeedEnvironmentGeneratedProvider extends AbstractAssistedProvider<SearchResultsLiveFeedEnvironmentGenerated> {
    public final SearchResultsLiveFeedEnvironmentGenerated m26219a(Context context, FeedListType feedListType, Runnable runnable, MutationControllerManager mutationControllerManager, SearchResultsMutableContext searchResultsMutableContext, Delegate delegate) {
        return new SearchResultsLiveFeedEnvironmentGenerated(context, feedListType, runnable, mutationControllerManager, searchResultsMutableContext, delegate, CanFollowUserImpl.a(this), CanFriendPersonImpl.a(this), (CanLikePageImplProvider) getOnDemandAssistedProviderForStaticDi(CanLikePageImplProvider.class), CanShowVideoInFullScreenImpl.a(this), HasAnchoredTooltipProviderImpl.a(this), (HasContextImplProvider) getOnDemandAssistedProviderForStaticDi(HasContextImplProvider.class), HasEnvironmentControllerImpl.a(this), (HasFeedListTypeImplProvider) getOnDemandAssistedProviderForStaticDi(HasFeedListTypeImplProvider.class), HasImageLoadListenerImpl.a(this), (HasInvalidateImplProvider) getOnDemandAssistedProviderForStaticDi(HasInvalidateImplProvider.class), HasIsAsyncImpl.a(this), (HasMenuButtonProviderImplProvider) getOnDemandAssistedProviderForStaticDi(HasMenuButtonProviderImplProvider.class), (HasMutationControllerManagerImplProvider) getOnDemandAssistedProviderForStaticDi(HasMutationControllerManagerImplProvider.class), HasPersistentStateImpl.a(this), HasPositionInformationImpl.a(this), HasPrefetcherNoOpImpl.a(this), HasRowKeyImpl.a(this), (HasSearchResultsContextImplProvider) getOnDemandAssistedProviderForStaticDi(HasSearchResultsContextImplProvider.class), (HasScrollListenerSupportImplProvider) getOnDemandAssistedProviderForStaticDi(HasScrollListenerSupportImplProvider.class));
    }
}
