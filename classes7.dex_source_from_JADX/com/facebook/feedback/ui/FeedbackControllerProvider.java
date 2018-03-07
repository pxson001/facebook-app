package com.facebook.feedback.ui;

import com.facebook.api.prefetch.GraphQLPrefetchConsumerProvider;
import com.facebook.api.ufiservices.FeedbackPrefetchPolicyProvider;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.controller.mutation.CommentMutationHelper;
import com.facebook.controller.mutation.FeedbackMutationHelper;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedback.prefetcher.FeedbackPrefetcher;
import com.facebook.feedback.prefetcher.FeedbackPrefetchingExperiments;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ufiservices.cache.PendingCommentCache;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.facebook.ui.futures.TasksManager;
import java.util.concurrent.Executor;

/* compiled from: savedPrivacyKey */
public class FeedbackControllerProvider extends AbstractAssistedProvider<FeedbackController> {
    public final FeedbackController m5074a(FeedbackControllerParams feedbackControllerParams) {
        return new FeedbackController(EventsStream.a(this), FeedEventBus.a(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), FeedbackErrorUtil.m5075a((InjectorLike) this), FeedbackLoader.a(this), (FeedbackPrefetchPolicyProvider) getOnDemandAssistedProviderForStaticDi(FeedbackPrefetchPolicyProvider.class), (GraphQLPrefetchConsumerProvider) getOnDemandAssistedProviderForStaticDi(GraphQLPrefetchConsumerProvider.class), IdBasedSingletonScopeProvider.b(this, 10994), PendingCommentCache.a(this), TasksManager.a(this), OfflineCommentCache.m5175a((InjectorLike) this), ViewerContextManagerProvider.a(this), CommentMutationHelper.m2210a(this), FeedbackMutationHelper.m2216a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), FunnelLoggerImpl.a(this), FeedbackPrefetcher.a(this), feedbackControllerParams, FeedbackPrefetchingExperiments.a(this));
    }
}
