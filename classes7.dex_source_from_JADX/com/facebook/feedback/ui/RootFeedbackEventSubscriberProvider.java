package com.facebook.feedback.ui;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.offlinemode.comments.OfflineCommentsExecutorHelper;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ufiperf.perf.UfiPerfUtil;
import com.google.common.base.Function;

/* compiled from: rotate_by */
public class RootFeedbackEventSubscriberProvider extends AbstractAssistedProvider<RootFeedbackEventSubscriber> {
    public final RootFeedbackEventSubscriber m5222a(Function<GraphQLFeedback, Void> function, CommentAdapter commentAdapter, CommentListScrollStateController commentListScrollStateController, FeedbackNewCommentsPillController feedbackNewCommentsPillController, FeedbackTypingPillController feedbackTypingPillController) {
        return new RootFeedbackEventSubscriber(function, commentAdapter, commentListScrollStateController, feedbackNewCommentsPillController, feedbackTypingPillController, EventsStream.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), FeedbackMutator.a(this), UfiPerfUtil.a(this), OfflineCommentsExecutorHelper.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), IdBasedSingletonScopeProvider.b(this, 10994), (TypingIndicatorControllerProvider) getOnDemandAssistedProviderForStaticDi(TypingIndicatorControllerProvider.class));
    }
}
