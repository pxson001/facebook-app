package com.facebook.feed.protocol;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: min_broadcast_duration */
public class FetchTopicFeedMethod extends FetchFeedMethod {
    private final FetchFeedQueryUtil f10328e;

    public static FetchTopicFeedMethod m16302b(InjectorLike injectorLike) {
        return new FetchTopicFeedMethod(GraphQLProtocolHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), StartupPerfLogger.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FetchFeedQueryUtil.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FetchFeedbackMethod.b(injectorLike));
    }

    public final GraphQlQueryString m16308f(Object obj) {
        FetchFeedParams fetchFeedParams = (FetchFeedParams) obj;
        GraphQlQueryString fetchNewsFeedGraphQL$SectionNewsFeedQueryDepth3String = new FetchNewsFeedGraphQL$SectionNewsFeedQueryDepth3String();
        this.f10328e.a(fetchNewsFeedGraphQL$SectionNewsFeedQueryDepth3String);
        FetchFeedQueryUtil.a(fetchNewsFeedGraphQL$SectionNewsFeedQueryDepth3String, fetchFeedParams, "before_home_story_param", "after_home_story_param");
        this.f10328e.b(fetchNewsFeedGraphQL$SectionNewsFeedQueryDepth3String);
        this.f10328e.c(fetchNewsFeedGraphQL$SectionNewsFeedQueryDepth3String);
        FetchFeedQueryUtil.d(fetchNewsFeedGraphQL$SectionNewsFeedQueryDepth3String);
        this.f10328e.g(fetchNewsFeedGraphQL$SectionNewsFeedQueryDepth3String);
        Object obj2 = fetchFeedParams.b.f;
        fetchNewsFeedGraphQL$SectionNewsFeedQueryDepth3String.a("action_location", "explore_feed").a("section_id", obj2 instanceof GraphQLExploreFeed ? ((GraphQLExploreFeed) obj2).n() : (String) obj2).a("first_home_story_param", Integer.valueOf(fetchFeedParams.c));
        return fetchNewsFeedGraphQL$SectionNewsFeedQueryDepth3String;
    }

    @Inject
    public FetchTopicFeedMethod(GraphQLProtocolHelper graphQLProtocolHelper, AbstractFbErrorReporter abstractFbErrorReporter, StartupPerfLogger startupPerfLogger, Clock clock, FetchFeedQueryUtil fetchFeedQueryUtil, MonotonicClock monotonicClock, QeAccessor qeAccessor, FetchFeedbackMethod fetchFeedbackMethod) {
        super(graphQLProtocolHelper, abstractFbErrorReporter, startupPerfLogger, clock, monotonicClock, qeAccessor, fetchFeedbackMethod);
        this.f10328e = fetchFeedQueryUtil;
    }

    public final int m16303b(Object obj, ApiResponse apiResponse) {
        return 2;
    }

    protected final boolean m16304b() {
        return true;
    }

    protected final String m16305c() {
        return "fetch_topic_feed";
    }

    protected final String m16306c(FetchFeedParams fetchFeedParams) {
        return "TopicFeedNetworkTime";
    }

    protected final int m16307d(FetchFeedParams fetchFeedParams) {
        return 655519;
    }
}
