package com.facebook.feed.protocol;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.protocol.FetchPageFeedGraphQL.FetchPageFeedString;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import javax.inject.Inject;

/* compiled from: mobile_ */
public class FetchPageFeedMethod extends FetchFeedMethod {
    private final FetchFeedQueryUtil f10319e;
    private final GraphQLImageHelper f10320f;
    private final FetchVideoChannelParamBuilderUtil f10321g;

    public static FetchPageFeedMethod m16266b(InjectorLike injectorLike) {
        return new FetchPageFeedMethod(GraphQLProtocolHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), StartupPerfLogger.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FetchFeedQueryUtil.a(injectorLike), GraphQLImageHelper.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), FetchVideoChannelParamBuilderUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FetchFeedbackMethod.b(injectorLike));
    }

    public final GraphQlQueryString m16271f(Object obj) {
        FetchFeedParams fetchFeedParams = (FetchFeedParams) obj;
        GraphQlQueryString fetchPageFeedString = new FetchPageFeedString();
        this.f10319e.a(fetchPageFeedString);
        FetchFeedQueryUtil.a(fetchPageFeedString, fetchFeedParams, "before_home_story_param", "after_home_story_param");
        this.f10319e.b(fetchPageFeedString);
        this.f10319e.c(fetchPageFeedString);
        FetchFeedQueryUtil.d(fetchPageFeedString);
        fetchPageFeedString.a("first_home_story_param", String.valueOf(fetchFeedParams.c)).a("media_type", this.f10320f.c());
        this.f10321g.a(fetchPageFeedString, EntryPointInputVideoChannelEntryPoint.PAGE);
        return fetchPageFeedString;
    }

    @Inject
    public FetchPageFeedMethod(GraphQLProtocolHelper graphQLProtocolHelper, AbstractFbErrorReporter abstractFbErrorReporter, StartupPerfLogger startupPerfLogger, Clock clock, FetchFeedQueryUtil fetchFeedQueryUtil, GraphQLImageHelper graphQLImageHelper, MonotonicClock monotonicClock, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil, QeAccessor qeAccessor, FetchFeedbackMethod fetchFeedbackMethod) {
        super(graphQLProtocolHelper, abstractFbErrorReporter, startupPerfLogger, clock, monotonicClock, qeAccessor, fetchFeedbackMethod);
        this.f10319e = fetchFeedQueryUtil;
        this.f10320f = graphQLImageHelper;
        this.f10321g = fetchVideoChannelParamBuilderUtil;
    }

    public final int m16267b(Object obj, ApiResponse apiResponse) {
        return 2;
    }

    protected final String m16268c() {
        return "fetch_page_feed";
    }

    protected final String m16269c(FetchFeedParams fetchFeedParams) {
        return "PageFeedNetworkTime";
    }

    protected final int m16270d(FetchFeedParams fetchFeedParams) {
        return 655507;
    }
}
