package com.facebook.events.permalink.multirow.environment;

import android.content.Context;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.events.feed.ui.EventFeedStoryPinMutatorProvider;
import com.facebook.events.feed.ui.environment.HasEventFeedMenuButtonProviderImplProvider;
import com.facebook.events.permalink.EventPermalinkFragment;
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
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.analytics.HasIsAsyncImpl;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: batch */
public class EventPermalinkEnvironmentGeneratedProvider extends AbstractAssistedProvider<EventPermalinkEnvironmentGenerated> {
    public final EventPermalinkEnvironmentGenerated m19053a(EventPermalinkFragment eventPermalinkFragment, Context context, FeedListType feedListType, Runnable runnable, MutationControllerManager mutationControllerManager, Delegate delegate) {
        return new EventPermalinkEnvironmentGenerated(eventPermalinkFragment, context, feedListType, runnable, mutationControllerManager, delegate, CanFollowUserImpl.a(this), CanFriendPersonImpl.a(this), (CanLikePageImplProvider) getOnDemandAssistedProviderForStaticDi(CanLikePageImplProvider.class), CanPostToEventWallImpl.m19008a(this), CanShowVideoInFullScreenImpl.a(this), (EventFeedStoryPinMutatorProvider) getOnDemandAssistedProviderForStaticDi(EventFeedStoryPinMutatorProvider.class), HasAnchoredTooltipProviderImpl.a(this), (HasContextImplProvider) getOnDemandAssistedProviderForStaticDi(HasContextImplProvider.class), HasEnvironmentControllerImpl.a(this), (HasEventFeedMenuButtonProviderImplProvider) getOnDemandAssistedProviderForStaticDi(HasEventFeedMenuButtonProviderImplProvider.class), (HasFeedListTypeImplProvider) getOnDemandAssistedProviderForStaticDi(HasFeedListTypeImplProvider.class), HasImageLoadListenerImpl.a(this), (HasInvalidateImplProvider) getOnDemandAssistedProviderForStaticDi(HasInvalidateImplProvider.class), HasIsAsyncImpl.a(this), (HasMutationControllerManagerImplProvider) getOnDemandAssistedProviderForStaticDi(HasMutationControllerManagerImplProvider.class), HasPersistentStateImpl.a(this), HasPositionInformationImpl.a(this), HasPrefetcherNoOpImpl.a(this), HasRowKeyImpl.a(this), (HasScrollListenerSupportImplProvider) getOnDemandAssistedProviderForStaticDi(HasScrollListenerSupportImplProvider.class));
    }
}
