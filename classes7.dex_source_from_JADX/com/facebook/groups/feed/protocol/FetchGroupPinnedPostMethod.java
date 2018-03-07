package com.facebook.groups.feed.protocol;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.protocol.FetchFeedMethod;
import com.facebook.feed.protocol.FetchFeedQueryUtil;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.graphql.model.GraphQLFeedHomeStories.Builder;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.feed.protocol.FetchGroupPinnedPostGraphQL.GroupPinnedPostQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.MoreObjects;
import javax.inject.Inject;

/* compiled from: quick_reply */
public class FetchGroupPinnedPostMethod extends FetchFeedMethod {
    private final FetchFeedQueryUtil f5613e;

    private static FetchGroupPinnedPostMethod m6502b(InjectorLike injectorLike) {
        return new FetchGroupPinnedPostMethod(FetchFeedQueryUtil.a(injectorLike), GraphQLProtocolHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), StartupPerfLogger.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FetchFeedbackMethod.b(injectorLike));
    }

    public final GraphQlQueryString m6510f(Object obj) {
        FetchFeedParams fetchFeedParams = (FetchFeedParams) obj;
        GroupPinnedPostQueryString a = FetchGroupPinnedPostGraphQL.m6501a();
        this.f5613e.a(a);
        this.f5613e.b(a);
        FetchFeedQueryUtil.a(a, fetchFeedParams, "before", "after");
        this.f5613e.c(a);
        FetchFeedQueryUtil.d(a);
        if (fetchFeedParams != null) {
            a.a("group_id", fetchFeedParams.b.a()).a("first", String.valueOf(fetchFeedParams.c));
        }
        return a;
    }

    @Inject
    public FetchGroupPinnedPostMethod(FetchFeedQueryUtil fetchFeedQueryUtil, GraphQLProtocolHelper graphQLProtocolHelper, AbstractFbErrorReporter abstractFbErrorReporter, StartupPerfLogger startupPerfLogger, Clock clock, MonotonicClock monotonicClock, QeAccessor qeAccessor, FetchFeedbackMethod fetchFeedbackMethod) {
        super(graphQLProtocolHelper, abstractFbErrorReporter, startupPerfLogger, clock, monotonicClock, qeAccessor, fetchFeedbackMethod);
        this.f5613e = fetchFeedQueryUtil;
    }

    protected final String m6507c() {
        return "fetch_group_pinned_post";
    }

    protected final String m6508c(FetchFeedParams fetchFeedParams) {
        return "GroupsFeedNetworkTime";
    }

    protected final int m6509d(FetchFeedParams fetchFeedParams) {
        return 655490;
    }

    public final int m6506b(Object obj, ApiResponse apiResponse) {
        return 2;
    }

    protected final GraphQLFeedHomeStories m6504a(FetchFeedParams fetchFeedParams, JsonParser jsonParser) {
        GraphQLFeedHomeStories a = super.a(fetchFeedParams, jsonParser);
        Builder builder = new Builder();
        builder.f = a(a.k());
        builder = builder;
        builder.i = a.n();
        builder = builder;
        builder.e = a.j();
        builder = builder;
        builder.d = a.a();
        return builder.a();
    }

    public final GraphQLFeedHomeStories m6503a(FetchFeedParams fetchFeedParams, GraphQLResult graphQLResult) {
        GraphQLFeedHomeStories a = super.a(fetchFeedParams, graphQLResult);
        a(a);
        return a;
    }

    protected final String m6505a(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        return (String) MoreObjects.firstNonNull(graphQLFeedUnitEdge.c() instanceof GraphQLStory ? ((GraphQLStory) graphQLFeedUnitEdge.c()).c() : null, graphQLFeedUnitEdge.c().g());
    }
}
