package com.facebook.events.dashboard.multirow.environment;

import android.content.Context;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.dashboard.EventsDiscoveryDashboardFragment;
import com.facebook.events.dashboard.multirow.EventsDashboardItemCollection;
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
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImplProvider;
import com.facebook.feed.fragment.generatedenvironments.HasMenuButtonProviderImplProvider;
import com.facebook.feed.fragment.generatedenvironments.HasPrefetcherImplProvider;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.analytics.HasIsAsyncImpl;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionInteractionTracker;
import com.facebook.reaction.feed.environment.CanAddReactionComponentsImplProvider;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEventsImpl;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParamsImplProvider;
import com.facebook.reaction.feed.environment.ReactionFeedActionHandlerProvider;

/* compiled from: com.facebook.platform.target.DATA */
public class EventsDashboardEnvironmentGeneratedProvider extends AbstractAssistedProvider<EventsDashboardEnvironmentGenerated> {
    public final EventsDashboardEnvironmentGenerated m17472a(Context context, FeedListType feedListType, Runnable runnable, MutationControllerManager mutationControllerManager, MultiRowImagePrefetcherWrapper multiRowImagePrefetcherWrapper, Delegate delegate, Context context2, ReactionCardContainer reactionCardContainer, ReactionInteractionTracker reactionInteractionTracker, ReactionSession reactionSession, EventAnalyticsParams eventAnalyticsParams, EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment, ReactionAnalyticsParams reactionAnalyticsParams, EventsDashboardItemCollection eventsDashboardItemCollection) {
        return new EventsDashboardEnvironmentGenerated(context, feedListType, runnable, mutationControllerManager, multiRowImagePrefetcherWrapper, delegate, context2, reactionCardContainer, reactionInteractionTracker, reactionSession, eventAnalyticsParams, eventsDiscoveryDashboardFragment, reactionAnalyticsParams, eventsDashboardItemCollection, (CanAddReactionComponentsImplProvider) getOnDemandAssistedProviderForStaticDi(CanAddReactionComponentsImplProvider.class), CanFollowUserImpl.a(this), CanFriendPersonImpl.a(this), CanHandleHScrollPageChangedEventsImpl.a(this), (CanLikePageImplProvider) getOnDemandAssistedProviderForStaticDi(CanLikePageImplProvider.class), CanShowVideoInFullScreenImpl.a(this), HasAnchoredTooltipProviderImpl.a(this), (HasContextImplProvider) getOnDemandAssistedProviderForStaticDi(HasContextImplProvider.class), HasEnvironmentControllerImpl.a(this), (HasFeedListTypeImplProvider) getOnDemandAssistedProviderForStaticDi(HasFeedListTypeImplProvider.class), (HasInvalidateImplProvider) getOnDemandAssistedProviderForStaticDi(HasInvalidateImplProvider.class), HasIsAsyncImpl.a(this), HasImageLoadListenerImpl.a(this), (HasMenuButtonProviderImplProvider) getOnDemandAssistedProviderForStaticDi(HasMenuButtonProviderImplProvider.class), (HasMutationControllerManagerImplProvider) getOnDemandAssistedProviderForStaticDi(HasMutationControllerManagerImplProvider.class), HasPersistentStateImpl.a(this), HasPositionInformationImpl.a(this), (HasPrefetcherImplProvider) getOnDemandAssistedProviderForStaticDi(HasPrefetcherImplProvider.class), (HasScrollListenerSupportImplProvider) getOnDemandAssistedProviderForStaticDi(HasScrollListenerSupportImplProvider.class), (ReactionFeedActionHandlerProvider) getOnDemandAssistedProviderForStaticDi(ReactionFeedActionHandlerProvider.class), (ReactionFeedEnvironmentEventsImplProvider) getOnDemandAssistedProviderForStaticDi(ReactionFeedEnvironmentEventsImplProvider.class), (HasEventAnalyticsParamsImplProvider) getOnDemandAssistedProviderForStaticDi(HasEventAnalyticsParamsImplProvider.class), HasEventDashboardFilterTypeImpl.m17475a((InjectorLike) this), (HasEventDashboardFragmentImplProvider) getOnDemandAssistedProviderForStaticDi(HasEventDashboardFragmentImplProvider.class), (HasReactionAnalyticsParamsImplProvider) getOnDemandAssistedProviderForStaticDi(HasReactionAnalyticsParamsImplProvider.class), (ShouldExpandEventsImplProvider) getOnDemandAssistedProviderForStaticDi(ShouldExpandEventsImplProvider.class));
    }
}
