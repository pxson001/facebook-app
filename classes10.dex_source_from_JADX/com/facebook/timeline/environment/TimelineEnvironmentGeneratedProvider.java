package com.facebook.timeline.environment;

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
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImplProvider;
import com.facebook.feed.fragment.generatedenvironments.HasPrefetcherImplProvider;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.analytics.HasIsAsyncImpl;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.profile.TimelineContext;

/* compiled from: from_viewer */
public class TimelineEnvironmentGeneratedProvider extends AbstractAssistedProvider<TimelineEnvironmentGenerated> {
    public final TimelineEnvironmentGenerated m11146a(Context context, FeedListType feedListType, Runnable runnable, MutationControllerManager mutationControllerManager, Delegate delegate, MultiRowImagePrefetcherWrapper multiRowImagePrefetcherWrapper, TimelineContext timelineContext, String str) {
        return new TimelineEnvironmentGenerated(context, feedListType, runnable, mutationControllerManager, delegate, multiRowImagePrefetcherWrapper, timelineContext, str, CanFollowUserImpl.a(this), CanFriendPersonImpl.a(this), (CanLikePageImplProvider) getOnDemandAssistedProviderForStaticDi(CanLikePageImplProvider.class), CanShowVideoInFullScreenImpl.a(this), HasAnchoredTooltipProviderImpl.a(this), (HasContextImplProvider) getOnDemandAssistedProviderForStaticDi(HasContextImplProvider.class), HasEnvironmentControllerImpl.a(this), (HasFeedListTypeImplProvider) getOnDemandAssistedProviderForStaticDi(HasFeedListTypeImplProvider.class), (HasInvalidateImplProvider) getOnDemandAssistedProviderForStaticDi(HasInvalidateImplProvider.class), HasIsAsyncImpl.a(this), (HasMenuButtonProviderImplProvider) getOnDemandAssistedProviderForStaticDi(HasMenuButtonProviderImplProvider.class), (HasMutationControllerManagerImplProvider) getOnDemandAssistedProviderForStaticDi(HasMutationControllerManagerImplProvider.class), HasPersistentStateImpl.a(this), HasPositionInformationImpl.a(this), (HasScrollListenerSupportImplProvider) getOnDemandAssistedProviderForStaticDi(HasScrollListenerSupportImplProvider.class), (HasPrefetcherImplProvider) getOnDemandAssistedProviderForStaticDi(HasPrefetcherImplProvider.class), HasImageLoadListenerImpl.a(this), (HasTimelineContextImplProvider) getOnDemandAssistedProviderForStaticDi(HasTimelineContextImplProvider.class), (HasProfileNameImplProvider) getOnDemandAssistedProviderForStaticDi(HasProfileNameImplProvider.class));
    }
}
