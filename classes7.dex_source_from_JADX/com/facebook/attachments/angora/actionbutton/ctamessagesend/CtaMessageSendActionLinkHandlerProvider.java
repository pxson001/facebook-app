package com.facebook.attachments.angora.actionbutton.ctamessagesend;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.feed.analytics.LongClickTracker;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.links.AttachmentLinkInspector;
import com.facebook.messaging.linkhandling.LinkHandlingHelper;
import java.util.concurrent.Executor;

/* compiled from: user turned off message notification setting */
public class CtaMessageSendActionLinkHandlerProvider extends AbstractAssistedProvider<CtaMessageSendActionLinkHandler> {
    public final CtaMessageSendActionLinkHandler m886a(FeedProps<GraphQLStoryAttachment> feedProps) {
        return new CtaMessageSendActionLinkHandler(AttachmentLinkInspector.a(this), AnalyticsLoggerMethodAutoProvider.a(this), LongClickTracker.a(this), FeedEventBus.a(this), CommonEventsBuilder.b(this), GraphQLQueryExecutor.a(this), (Context) getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), LinkHandlingHelper.m9456a(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), feedProps);
    }
}
