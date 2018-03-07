package com.facebook.timeline.cursor;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.ConnectionFetcherState;
import com.facebook.graphql.connection.configuration.BatchConfiguration;
import com.facebook.graphql.connection.configuration.SequentialBatchConfiguration;
import com.facebook.graphql.connection.configuration.TailFetchLocation;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.inject.Assisted;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.timeline.datafetcher.TimelineDataFetcher.C15321;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryBuilder;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.FirstUnitsObservables;
import com.facebook.timeline.datafetcher.TimelineSelfFirstUnitsQueryBuilder;
import com.facebook.timeline.datafetcher.TimelineTaggedMediaSetQueryExecutor;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams;
import com.facebook.ultralight.Inject;
import java.util.concurrent.Executor;

/* compiled from: group_events_page_size */
public class TimelineSelfFirstUnitsBatchConfiguration implements BatchConfiguration {
    private final SequentialBatchConfiguration f10392a;
    private final TimelineSelfFirstUnitsQueryBuilder f10393b;
    private final FetchTimelineFirstUnitsParams f10394c;
    private final CallerContext f10395d;
    private final C15321 f10396e;
    private boolean f10397f = true;

    @Inject
    public TimelineSelfFirstUnitsBatchConfiguration(@Assisted FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, @Assisted CallerContext callerContext, @Assisted C15321 c15321, TimelineFirstUnitsSelfConfigurationProvider timelineFirstUnitsSelfConfigurationProvider, TimelineSectionUnitsConfiguration timelineSectionUnitsConfiguration, TimelineSelfFirstUnitsQueryBuilder timelineSelfFirstUnitsQueryBuilder) {
        this.f10394c = fetchTimelineFirstUnitsParams;
        this.f10395d = callerContext;
        this.f10396e = c15321;
        this.f10392a = new SequentialBatchConfiguration(new TimelineFirstUnitsSelfConfiguration(fetchTimelineFirstUnitsParams, TimelineFirstUnitsQueryBuilder.m10587a((InjectorLike) timelineFirstUnitsSelfConfigurationProvider)), timelineSectionUnitsConfiguration, m10513a());
        this.f10393b = timelineSelfFirstUnitsQueryBuilder;
    }

    public final long m10513a() {
        return 0;
    }

    public final int m10515b() {
        return 2;
    }

    public final GraphQLBatchRequest m10514a(QuickPerformanceLogger quickPerformanceLogger, ConnectionFetcherState connectionFetcherState, Executor executor, TailFetchLocation tailFetchLocation) {
        GraphQLBatchRequest a = this.f10392a.a(quickPerformanceLogger, connectionFetcherState, executor, tailFetchLocation);
        if (tailFetchLocation.b == null) {
            m10512a(a, this.f10397f ? GraphQLCachePolicy.a : GraphQLCachePolicy.d);
        }
        this.f10397f = false;
        return a;
    }

    private void m10512a(GraphQLBatchRequest graphQLBatchRequest, GraphQLCachePolicy graphQLCachePolicy) {
        RequestObservable a = this.f10393b.m10673a(graphQLBatchRequest, this.f10394c, graphQLCachePolicy, 0, this.f10395d);
        RequestObservable a2 = this.f10393b.m10670a(graphQLBatchRequest, graphQLCachePolicy, 0, this.f10395d);
        this.f10396e.m10541a(new FirstUnitsObservables(RequestObservable.b(), RequestObservable.b(), TimelineTaggedMediaSetQueryExecutor.m10732a(graphQLBatchRequest, String.valueOf(this.f10394c.m12092a()), 0, this.f10395d, graphQLCachePolicy), a, a2, this.f10393b.m10675c(graphQLBatchRequest, this.f10394c, graphQLCachePolicy, 0, this.f10395d), this.f10393b.m10674b(graphQLBatchRequest, this.f10394c, graphQLCachePolicy, 0, this.f10395d), null, null));
    }
}
