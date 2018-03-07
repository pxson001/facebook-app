package com.facebook.feed.protocol;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.protocol.FetchGoodFriendsListFeedGraphQL.FetchGoodFriendsListFeedString;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: more_options */
public class FetchGoodFriendsFeedMethod extends FetchFeedMethod {
    private final FetchFeedQueryUtil f10206e;

    public static FetchGoodFriendsFeedMethod m15944b(InjectorLike injectorLike) {
        return new FetchGoodFriendsFeedMethod(GraphQLProtocolHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), StartupPerfLogger.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FetchFeedQueryUtil.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FetchFeedbackMethod.b(injectorLike));
    }

    public final GraphQlQueryString m15949f(Object obj) {
        FetchFeedParams fetchFeedParams = (FetchFeedParams) obj;
        GraphQlQueryString fetchGoodFriendsListFeedString = new FetchGoodFriendsListFeedString();
        this.f10206e.a(fetchGoodFriendsListFeedString);
        FetchFeedQueryUtil.a(fetchGoodFriendsListFeedString, fetchFeedParams, "before_home_story_param", "after_home_story_param");
        this.f10206e.b(fetchGoodFriendsListFeedString);
        this.f10206e.c(fetchGoodFriendsListFeedString);
        FetchFeedQueryUtil.d(fetchGoodFriendsListFeedString);
        fetchGoodFriendsListFeedString.a("first_home_story_param", String.valueOf(fetchFeedParams.c));
        return fetchGoodFriendsListFeedString;
    }

    @Inject
    public FetchGoodFriendsFeedMethod(GraphQLProtocolHelper graphQLProtocolHelper, AbstractFbErrorReporter abstractFbErrorReporter, StartupPerfLogger startupPerfLogger, Clock clock, FetchFeedQueryUtil fetchFeedQueryUtil, MonotonicClock monotonicClock, QeAccessor qeAccessor, FetchFeedbackMethod fetchFeedbackMethod) {
        super(graphQLProtocolHelper, abstractFbErrorReporter, startupPerfLogger, clock, monotonicClock, qeAccessor, fetchFeedbackMethod);
        this.f10206e = fetchFeedQueryUtil;
    }

    public final int m15945b(Object obj, ApiResponse apiResponse) {
        return 5;
    }

    protected final String m15946c() {
        return "fetch_good_friends_feed";
    }

    protected final String m15947c(FetchFeedParams fetchFeedParams) {
        return "GoodFriendsFeedNetworkTime";
    }

    protected final int m15948d(FetchFeedParams fetchFeedParams) {
        return 655518;
    }
}
