package com.facebook.timeline.inforeview;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.timeline.event.TimelineHeaderEventBus;

/* compiled from: upload_cancelled_ratio */
public class PlutoniumProfileQuestionHandlerProvider extends AbstractAssistedProvider<PlutoniumProfileQuestionHandler> {
    public final PlutoniumProfileQuestionHandler m914a(TimelineHeaderEventBus timelineHeaderEventBus, TimelineInfoReviewData timelineInfoReviewData) {
        return new PlutoniumProfileQuestionHandler(timelineHeaderEventBus, timelineInfoReviewData, new PlutoniumProfileQuestionActionController(GraphQLQueryExecutor.a(this), DefaultAndroidThreadUtil.b(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this)));
    }
}
