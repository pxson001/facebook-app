package com.facebook.timeline.inforeview;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.timeline.event.TimelineHeaderEventBus;

/* compiled from: upload result missing fbid */
public class TimelineInfoReviewAdapterProvider extends AbstractAssistedProvider<TimelineInfoReviewAdapter> {
    public final TimelineInfoReviewAdapter m920a(Context context, TimelineInfoReviewData timelineInfoReviewData) {
        return new TimelineInfoReviewAdapter(context, timelineInfoReviewData, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), TimelineHeaderEventBus.a(this), new InfoReviewHandler((IFeedIntentBuilder) DefaultFeedIntentBuilder.a(this), GraphQLQueryExecutor.a(this), DefaultAndroidThreadUtil.b(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this)));
    }
}
