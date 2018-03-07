package com.facebook.timeline.datafetcher;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.profileprotocol.FetchTimelineHeaderParamsFactory;
import java.util.concurrent.Executor;

/* compiled from: group/{%s} */
public class TimelineHeaderDataFetcherProvider extends AbstractAssistedProvider<TimelineHeaderDataFetcher> {
    public final TimelineHeaderDataFetcher m10621a(Context context, TimelineDataFetcher timelineDataFetcher, TimelineUserContext timelineUserContext, TimelinePerformanceLogger timelinePerformanceLogger, CallerContext callerContext) {
        return new TimelineHeaderDataFetcher(context, timelineDataFetcher, timelineUserContext, timelinePerformanceLogger, callerContext, QuickPerformanceLoggerMethodAutoProvider.a(this), TimelineEarlyFetcher.m10575a((InjectorLike) this), (TimelineGenericDataFetcherProvider) getOnDemandAssistedProviderForStaticDi(TimelineGenericDataFetcherProvider.class), FetchTimelineHeaderParamsFactory.m12093a(this), TimelineHeaderParallelQueryExecutor.m10623a((InjectorLike) this), IdBasedSingletonScopeProvider.a(this, 11174), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this));
    }
}
