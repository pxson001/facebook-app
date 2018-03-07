package com.facebook.feed.protocol;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.protocol.FetchStoriesAboutPageGraphQL.FetchStoriesAboutPageFeedString;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: miniPreview */
public class FetchStoriesAboutPageFeedMethod extends FetchFeedMethod {
    private final FetchFeedQueryUtil f10327e;

    public static FetchStoriesAboutPageFeedMethod m16293b(InjectorLike injectorLike) {
        return new FetchStoriesAboutPageFeedMethod(GraphQLProtocolHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), StartupPerfLogger.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FetchFeedQueryUtil.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FetchFeedbackMethod.b(injectorLike));
    }

    public final GraphQlQueryString m16298f(Object obj) {
        FetchFeedParams fetchFeedParams = (FetchFeedParams) obj;
        GraphQlQueryString fetchStoriesAboutPageFeedString = new FetchStoriesAboutPageFeedString();
        this.f10327e.a(fetchStoriesAboutPageFeedString);
        FetchFeedQueryUtil.a(fetchStoriesAboutPageFeedString, fetchFeedParams, "before_home_story_param", "after_home_story_param");
        this.f10327e.b(fetchStoriesAboutPageFeedString);
        this.f10327e.c(fetchStoriesAboutPageFeedString);
        FetchFeedQueryUtil.d(fetchStoriesAboutPageFeedString);
        fetchStoriesAboutPageFeedString.a("page_id", fetchFeedParams.b.a()).a("first_home_story_param", String.valueOf(fetchFeedParams.c));
        return fetchStoriesAboutPageFeedString;
    }

    @Inject
    public FetchStoriesAboutPageFeedMethod(GraphQLProtocolHelper graphQLProtocolHelper, AbstractFbErrorReporter abstractFbErrorReporter, StartupPerfLogger startupPerfLogger, Clock clock, FetchFeedQueryUtil fetchFeedQueryUtil, MonotonicClock monotonicClock, QeAccessor qeAccessor, FetchFeedbackMethod fetchFeedbackMethod) {
        super(graphQLProtocolHelper, abstractFbErrorReporter, startupPerfLogger, clock, monotonicClock, qeAccessor, fetchFeedbackMethod);
        this.f10327e = fetchFeedQueryUtil;
    }

    protected final String m16295c() {
        return "fetch_stories_about_page";
    }

    protected final String m16296c(FetchFeedParams fetchFeedParams) {
        return "StoriesAboutPageFeedNetworkTime";
    }

    protected final int m16297d(FetchFeedParams fetchFeedParams) {
        return 655500;
    }

    public final int m16294b(Object obj, ApiResponse apiResponse) {
        return 2;
    }
}
