package com.facebook.feed.protocol;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.protocol.FetchFriendListFeedGraphQL.FetchFriendListFeedString;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: mother */
public class FetchFriendListFeedMethod extends FetchFeedMethod {
    private final FetchFeedQueryUtil f10205e;

    public static FetchFriendListFeedMethod m15938b(InjectorLike injectorLike) {
        return new FetchFriendListFeedMethod(GraphQLProtocolHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), StartupPerfLogger.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FetchFeedQueryUtil.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FetchFeedbackMethod.b(injectorLike));
    }

    public final GraphQlQueryString m15943f(Object obj) {
        FetchFeedParams fetchFeedParams = (FetchFeedParams) obj;
        GraphQlQueryString fetchFriendListFeedString = new FetchFriendListFeedString();
        this.f10205e.a(fetchFriendListFeedString);
        FetchFeedQueryUtil.a(fetchFriendListFeedString, fetchFeedParams, "before_home_story_param", "after_home_story_param");
        this.f10205e.b(fetchFriendListFeedString);
        this.f10205e.c(fetchFriendListFeedString);
        FetchFeedQueryUtil.d(fetchFriendListFeedString);
        fetchFriendListFeedString.a("friend_list_id", fetchFeedParams.b.a()).a("first_home_story_param", String.valueOf(fetchFeedParams.c));
        return fetchFriendListFeedString;
    }

    @Inject
    public FetchFriendListFeedMethod(GraphQLProtocolHelper graphQLProtocolHelper, AbstractFbErrorReporter abstractFbErrorReporter, StartupPerfLogger startupPerfLogger, Clock clock, FetchFeedQueryUtil fetchFeedQueryUtil, MonotonicClock monotonicClock, QeAccessor qeAccessor, FetchFeedbackMethod fetchFeedbackMethod) {
        super(graphQLProtocolHelper, abstractFbErrorReporter, startupPerfLogger, clock, monotonicClock, qeAccessor, fetchFeedbackMethod);
        this.f10205e = fetchFeedQueryUtil;
    }

    public final int m15939b(Object obj, ApiResponse apiResponse) {
        return 2;
    }

    protected final String m15940c() {
        return "fetch_friend_list_feed";
    }

    protected final String m15941c(FetchFeedParams fetchFeedParams) {
        return "FriendListFeedNetworkTime";
    }

    protected final int m15942d(FetchFeedParams fetchFeedParams) {
        return 655488;
    }
}
