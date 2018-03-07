package com.facebook.timeline.datafetcher;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.model.GraphQLTimelineSection;
import com.facebook.graphql.model.GraphQLTimelineSectionsConnection;
import com.facebook.graphql.model.GraphQLUnseenStoriesConnection;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.ProtilesResult;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.TimelineFirstUnits;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParamsHelper;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.TimelineProtilesQueryModel;
import com.facebook.timeline.protocol.FetchTimelineSectionGraphQL.TimelineFirstUnitsUserString;
import com.facebook.timeline.protocol.FetchTimelineTaggedMediaSetGraphQLInterfaces.TimelineTaggedMediaSetFields;
import com.facebook.timeline.viewfeaturedcontainers.abtest.FavPhotosVsFeaturedContainersController;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersQueryFactory;
import com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel;
import com.google.common.base.Function;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: greeting_share_cancelled */
public class TimelineNonSelfFirstUnitsQueryBuilder {
    private final QeAccessor f10563a;
    private final TimelineUnseenStoriesQueryBuilder f10564b;
    private final TimelineFirstUnitsQueryBuilder f10565c;
    private final ProtilesQueryFactory f10566d;
    private final TimelineSectionQueryExecutor f10567e;
    private final FeaturedContainersQueryFactory f10568f;
    private final FavPhotosVsFeaturedContainersController f10569g;

    /* compiled from: greeting_share_cancelled */
    class C15381 implements Function<GraphQLResult<GraphQLUser>, GraphQLUnseenStoriesConnection> {
        final /* synthetic */ TimelineNonSelfFirstUnitsQueryBuilder f10560a;

        C15381(TimelineNonSelfFirstUnitsQueryBuilder timelineNonSelfFirstUnitsQueryBuilder) {
            this.f10560a = timelineNonSelfFirstUnitsQueryBuilder;
        }

        public Object apply(Object obj) {
            return ((GraphQLUser) ((GraphQLResult) obj).e).be();
        }
    }

    /* compiled from: greeting_share_cancelled */
    class C15392 implements Function<GraphQLResult<GraphQLUser>, TimelineFirstUnits> {
        final /* synthetic */ TimelineNonSelfFirstUnitsQueryBuilder f10561a;

        C15392(TimelineNonSelfFirstUnitsQueryBuilder timelineNonSelfFirstUnitsQueryBuilder) {
            this.f10561a = timelineNonSelfFirstUnitsQueryBuilder;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            GraphQLTimelineSectionsConnection I = ((GraphQLUser) graphQLResult.e).I();
            FirstSectionChecker.m10525a(I);
            return new TimelineFirstUnits(((GraphQLUser) graphQLResult.e).bc(), I, graphQLResult.freshness);
        }
    }

    /* compiled from: greeting_share_cancelled */
    class C15403 implements Function<GraphQLResult<TimelineProtilesQueryModel>, ProtilesResult> {
        final /* synthetic */ TimelineNonSelfFirstUnitsQueryBuilder f10562a;

        C15403(TimelineNonSelfFirstUnitsQueryBuilder timelineNonSelfFirstUnitsQueryBuilder) {
            this.f10562a = timelineNonSelfFirstUnitsQueryBuilder;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            return new ProtilesResult((TimelineProtilesQueryModel) graphQLResult.e, graphQLResult.freshness);
        }
    }

    public final RequestObservable<TimelineTaggedMediaSetFields> m10649a(GraphQLBatchRequest graphQLBatchRequest, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, boolean z, int i, CallerContext callerContext) {
        return TimelineTaggedMediaSetQueryExecutor.m10732a(graphQLBatchRequest, String.valueOf(fetchTimelineFirstUnitsParams.f12088a), i, callerContext, m10644a(z, false) ? GraphQLCachePolicy.a : GraphQLCachePolicy.c);
    }

    @Nullable
    public final RequestObservable<GraphQLUnseenStoriesConnection> m10646a(GraphQLBatchRequest graphQLBatchRequest, int i, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, CallerContext callerContext) {
        if (!fetchTimelineFirstUnitsParams.f12090c) {
            return null;
        }
        GraphQLRequest a = GraphQLRequest.a(this.f10564b.m10735a(fetchTimelineFirstUnitsParams.f12088a)).a(RequestPriority.NON_INTERACTIVE);
        a.f = callerContext;
        a = a.a(GraphQLCachePolicy.c);
        a.y = i;
        return GraphQLResultNullChecker.m10533b(graphQLBatchRequest.a(a)).a(new C15381(this));
    }

    @Inject
    public TimelineNonSelfFirstUnitsQueryBuilder(QeAccessor qeAccessor, TimelineUnseenStoriesQueryBuilder timelineUnseenStoriesQueryBuilder, TimelineFirstUnitsQueryBuilder timelineFirstUnitsQueryBuilder, ProtilesQueryFactory protilesQueryFactory, TimelineSectionQueryExecutor timelineSectionQueryExecutor, FeaturedContainersQueryFactory featuredContainersQueryFactory, FavPhotosVsFeaturedContainersController favPhotosVsFeaturedContainersController) {
        this.f10563a = qeAccessor;
        this.f10564b = timelineUnseenStoriesQueryBuilder;
        this.f10565c = timelineFirstUnitsQueryBuilder;
        this.f10566d = protilesQueryFactory;
        this.f10567e = timelineSectionQueryExecutor;
        this.f10568f = featuredContainersQueryFactory;
        this.f10569g = favPhotosVsFeaturedContainersController;
    }

    public final GraphQLRequest<GraphQLUser> m10645a(FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, boolean z, int i, CallerContext callerContext) {
        TimelineFirstUnitsUserString a = this.f10565c.m10589a(fetchTimelineFirstUnitsParams);
        GraphQLCachePolicy a2 = m10643a(z);
        long a3 = this.f10563a.a(ExperimentsForTimelineAbTestModule.az, 86400);
        GraphQLRequest a4 = GraphQLRequest.a(a).a(RequestPriority.NON_INTERACTIVE);
        a4.f = callerContext;
        GraphQLRequest<GraphQLUser> a5 = a4.a(a2).a(a3);
        a5.y = i;
        return a5;
    }

    public final RequestObservable<TimelineFirstUnits> m10647a(GraphQLBatchRequest graphQLBatchRequest, GraphQLRequest<GraphQLUser> graphQLRequest) {
        return GraphQLResultNullChecker.m10533b(graphQLBatchRequest.a(graphQLRequest)).a(new C15392(this));
    }

    public final RequestObservable<GraphQLTimelineSection> m10648a(GraphQLBatchRequest graphQLBatchRequest, GraphQLRequest<GraphQLUser> graphQLRequest, boolean z, int i, CallerContext callerContext) {
        return this.f10567e.m10665a(graphQLBatchRequest, TimelineSectionFetchParamsHelper.m10747a(graphQLRequest, z), m10643a(z), i, callerContext);
    }

    public final RequestObservable<ProtilesResult> m10650b(GraphQLBatchRequest graphQLBatchRequest, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, boolean z, int i, CallerContext callerContext) {
        GraphQLCachePolicy graphQLCachePolicy = m10644a(z, this.f10563a.a(ExperimentsForTimelineAbTestModule.aA, false)) ? GraphQLCachePolicy.a : GraphQLCachePolicy.c;
        long a = this.f10563a.a(ExperimentsForTimelineAbTestModule.ay, 86400);
        GraphQLRequest a2 = GraphQLRequest.a(this.f10566d.m10538b(String.valueOf(fetchTimelineFirstUnitsParams.f12088a))).a(RequestPriority.NON_INTERACTIVE);
        a2.y = i;
        a2 = a2;
        a2.f = callerContext;
        GraphQLRequest a3 = a2.a(graphQLCachePolicy).a(a);
        a3.b = true;
        return GraphQLResultNullChecker.m10533b(graphQLBatchRequest.a(a3)).a(new C15403(this));
    }

    @Nullable
    public final RequestObservable<GraphQLResult<FeaturedContainersQueryModel>> m10651c(GraphQLBatchRequest graphQLBatchRequest, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, boolean z, int i, CallerContext callerContext) {
        if (!this.f10569g.m12778c()) {
            return null;
        }
        GraphQLCachePolicy graphQLCachePolicy;
        GraphQLRequest a = GraphQLRequest.a(this.f10568f.m12784a(fetchTimelineFirstUnitsParams.f12088a)).a(RequestPriority.NON_INTERACTIVE);
        a.y = i;
        a = a;
        a.f = callerContext;
        GraphQLRequest graphQLRequest = a;
        if (z) {
            graphQLCachePolicy = GraphQLCachePolicy.d;
        } else {
            graphQLCachePolicy = GraphQLCachePolicy.a;
        }
        return GraphQLResultNullChecker.m10533b(graphQLBatchRequest.a(graphQLRequest.a(graphQLCachePolicy).a(86400)));
    }

    private GraphQLCachePolicy m10643a(boolean z) {
        return m10644a(z, this.f10563a.a(ExperimentsForTimelineAbTestModule.aB, false)) ? GraphQLCachePolicy.a : GraphQLCachePolicy.c;
    }

    private boolean m10644a(boolean z, boolean z2) {
        if (z) {
            return false;
        }
        return z2 || this.f10563a.a(ExperimentsForTimelineAbTestModule.ap, false);
    }
}
