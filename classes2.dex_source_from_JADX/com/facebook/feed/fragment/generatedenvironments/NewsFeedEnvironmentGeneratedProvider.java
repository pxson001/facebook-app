package com.facebook.feed.fragment.generatedenvironments;

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
import com.facebook.feed.environment.impl.HasRefreshImplProvider;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImplProvider;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.analytics.HasIsAsyncImpl;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: onRebind called with null intent */
public class NewsFeedEnvironmentGeneratedProvider extends AbstractAssistedProvider<NewsFeedEnvironmentGenerated> {
    public final NewsFeedEnvironmentGenerated m16446a(Context context, FeedListType feedListType, Runnable runnable, MutationControllerManager mutationControllerManager, MultiRowImagePrefetcherWrapper multiRowImagePrefetcherWrapper, Delegate delegate, Runnable runnable2) {
        return new NewsFeedEnvironmentGenerated(context, feedListType, runnable, mutationControllerManager, multiRowImagePrefetcherWrapper, delegate, runnable2, CanFollowUserImpl.m18292a((InjectorLike) this), CanFriendPersonImpl.m18306a(this), (CanLikePageImplProvider) getOnDemandAssistedProviderForStaticDi(CanLikePageImplProvider.class), CanShowVideoInFullScreenImpl.m18310a((InjectorLike) this), HasAnchoredTooltipProviderImpl.m18316a((InjectorLike) this), (HasContextImplProvider) getOnDemandAssistedProviderForStaticDi(HasContextImplProvider.class), HasEnvironmentControllerImpl.m18323a(this), (HasFeedListTypeImplProvider) getOnDemandAssistedProviderForStaticDi(HasFeedListTypeImplProvider.class), HasImageLoadListenerImpl.m18333a(this), (HasInvalidateImplProvider) getOnDemandAssistedProviderForStaticDi(HasInvalidateImplProvider.class), HasIsAsyncImpl.m18336a(this), (HasMenuButtonProviderImplProvider) getOnDemandAssistedProviderForStaticDi(HasMenuButtonProviderImplProvider.class), (HasMutationControllerManagerImplProvider) getOnDemandAssistedProviderForStaticDi(HasMutationControllerManagerImplProvider.class), HasPersistentStateImpl.m18340a((InjectorLike) this), HasPositionInformationImpl.m18345a(this), (HasPrefetcherImplProvider) getOnDemandAssistedProviderForStaticDi(HasPrefetcherImplProvider.class), (HasScrollListenerSupportImplProvider) getOnDemandAssistedProviderForStaticDi(HasScrollListenerSupportImplProvider.class), (HasRefreshImplProvider) getOnDemandAssistedProviderForStaticDi(HasRefreshImplProvider.class));
    }
}
