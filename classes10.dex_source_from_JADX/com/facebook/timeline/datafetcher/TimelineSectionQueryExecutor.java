package com.facebook.timeline.datafetcher;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.model.GraphQLTimelineSection;
import com.facebook.graphql.query.GraphQLRefParam.BatchQueryFanOutStyle;
import com.facebook.graphql.query.GraphQLRefParam.FallbackStyle;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParams;
import com.facebook.timeline.protocol.FetchTimelineSectionGraphQL.TimelineUserSectionQueryString;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: greeting_card_opened */
public class TimelineSectionQueryExecutor {
    private final GraphQLQueryExecutor f10585a;
    private final TimelineSectionQueryBuilder f10586b;
    public final QeAccessor f10587c;

    public static TimelineSectionQueryExecutor m10663b(InjectorLike injectorLike) {
        return new TimelineSectionQueryExecutor(GraphQLQueryExecutor.a(injectorLike), TimelineSectionQueryBuilder.m10657a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TimelineSectionQueryExecutor(GraphQLQueryExecutor graphQLQueryExecutor, TimelineSectionQueryBuilder timelineSectionQueryBuilder, QeAccessor qeAccessor) {
        this.f10585a = graphQLQueryExecutor;
        this.f10586b = timelineSectionQueryBuilder;
        this.f10587c = qeAccessor;
    }

    public final RequestObservable<GraphQLTimelineSection> m10666a(TimelineSectionFetchParams timelineSectionFetchParams, CallerContext callerContext) {
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("TimelineSectionQuery");
        GraphQLRequest a = m10660a(this.f10586b.m10659a(timelineSectionFetchParams, this.f10587c.a(ExperimentsForTimelineAbTestModule.bg, 8)), GraphQLCachePolicy.c, 0, callerContext);
        RequestObservable<GraphQLTimelineSection> a2 = GraphQLResultNullChecker.m10532a(graphQLBatchRequest.a(a));
        RequestObservable a3 = m10661a(graphQLBatchRequest, m10662a(timelineSectionFetchParams, a), GraphQLCachePolicy.c, 0, callerContext, m10664c() - 1);
        this.f10585a.a(graphQLBatchRequest);
        return a3 != null ? a2.b(a3) : a2;
    }

    @Nullable
    private RequestObservable<GraphQLTimelineSection> m10661a(GraphQLBatchRequest graphQLBatchRequest, TimelineSectionFetchParams timelineSectionFetchParams, GraphQLCachePolicy graphQLCachePolicy, int i, CallerContext callerContext, int i2) {
        if (i2 == 0) {
            return null;
        }
        TimelineSectionFetchParams timelineSectionFetchParams2 = timelineSectionFetchParams;
        RequestObservable<GraphQLTimelineSection> b = RequestObservable.b();
        int i3 = 0;
        while (i3 < i2) {
            GraphQLRequest a = m10660a(this.f10586b.m10659a(timelineSectionFetchParams2, this.f10587c.a(ExperimentsForTimelineAbTestModule.bf, 0)), graphQLCachePolicy, i, callerContext);
            RequestObservable<GraphQLTimelineSection> b2 = b.b(GraphQLResultNullChecker.m10532a(graphQLBatchRequest.a(a)));
            timelineSectionFetchParams2 = m10662a(timelineSectionFetchParams, a);
            i3++;
            b = b2;
        }
        return b;
    }

    private static GraphQLRequest<GraphQLTimelineSection> m10660a(TimelineUserSectionQueryString timelineUserSectionQueryString, GraphQLCachePolicy graphQLCachePolicy, int i, CallerContext callerContext) {
        GraphQLRequest<GraphQLTimelineSection> a = GraphQLRequest.a(timelineUserSectionQueryString).a(RequestPriority.NON_INTERACTIVE).a(graphQLCachePolicy);
        a.y = i;
        a = a;
        a.f = callerContext;
        return a;
    }

    private static TimelineSectionFetchParams m10662a(TimelineSectionFetchParams timelineSectionFetchParams, GraphQLRequest<GraphQLTimelineSection> graphQLRequest) {
        return timelineSectionFetchParams.m10746a().m10743b(graphQLRequest.a("end_cursor", BatchQueryFanOutStyle.FIRST, FallbackStyle.SKIP)).m10745b();
    }

    private int m10664c() {
        return this.f10587c.a(ExperimentsForTimelineAbTestModule.bh, 1);
    }

    @Nullable
    public final RequestObservable<GraphQLTimelineSection> m10665a(GraphQLBatchRequest graphQLBatchRequest, TimelineSectionFetchParams timelineSectionFetchParams, GraphQLCachePolicy graphQLCachePolicy, int i, CallerContext callerContext) {
        return m10661a(graphQLBatchRequest, timelineSectionFetchParams, graphQLCachePolicy, i, callerContext, this.f10587c.a(ExperimentsForTimelineAbTestModule.bd, 1) - 1);
    }
}
