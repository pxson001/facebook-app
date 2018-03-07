package com.facebook.feed.protocol;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.protocol.FetchHashtagFeedGraphQL.FetchHashtagFeedString;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: model_bundle_page_profile_pic_uri */
public class FetchHashtagFeedMethod extends FetchFeedMethod {
    private final FetchFeedQueryUtil f10226e;
    private final GraphQLImageHelper f10227f;

    public static FetchHashtagFeedMethod m16016b(InjectorLike injectorLike) {
        return new FetchHashtagFeedMethod(GraphQLProtocolHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), StartupPerfLogger.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FetchFeedQueryUtil.a(injectorLike), GraphQLImageHelper.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FetchFeedbackMethod.b(injectorLike));
    }

    public final GraphQlQueryString m16021f(Object obj) {
        FetchFeedParams fetchFeedParams = (FetchFeedParams) obj;
        GraphQlQueryString fetchHashtagFeedString = new FetchHashtagFeedString();
        this.f10226e.a(fetchHashtagFeedString);
        FetchFeedQueryUtil.a(fetchHashtagFeedString, fetchFeedParams, "before_home_story_param", "after_home_story_param");
        this.f10226e.b(fetchHashtagFeedString);
        this.f10226e.c(fetchHashtagFeedString);
        FetchFeedQueryUtil.d(fetchHashtagFeedString);
        fetchHashtagFeedString.a("hashtag", fetchFeedParams.b.a()).a("first_home_story_param", String.valueOf(fetchFeedParams.c)).a("media_type", this.f10227f.c());
        return fetchHashtagFeedString;
    }

    @Inject
    public FetchHashtagFeedMethod(GraphQLProtocolHelper graphQLProtocolHelper, AbstractFbErrorReporter abstractFbErrorReporter, StartupPerfLogger startupPerfLogger, Clock clock, FetchFeedQueryUtil fetchFeedQueryUtil, GraphQLImageHelper graphQLImageHelper, MonotonicClock monotonicClock, QeAccessor qeAccessor, FetchFeedbackMethod fetchFeedbackMethod) {
        super(graphQLProtocolHelper, abstractFbErrorReporter, startupPerfLogger, clock, monotonicClock, qeAccessor, fetchFeedbackMethod);
        this.f10226e = fetchFeedQueryUtil;
        this.f10227f = graphQLImageHelper;
    }

    public final int m16017b(Object obj, ApiResponse apiResponse) {
        return 2;
    }

    protected final String m16018c() {
        return "fetch_hashtag_feed";
    }

    protected final String m16019c(FetchFeedParams fetchFeedParams) {
        return "HashTagFeedNetworkTime";
    }

    protected final int m16020d(FetchFeedParams fetchFeedParams) {
        return 655491;
    }
}
