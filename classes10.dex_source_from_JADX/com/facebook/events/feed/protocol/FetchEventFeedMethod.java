package com.facebook.events.feed.protocol;

import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.events.feed.protocol.EventsFeedGraphQL.EventFeedQueryString;
import com.facebook.feed.protocol.FetchFeedMethod;
import com.facebook.feed.protocol.FetchFeedQueryUtil;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.graphql.model.GraphQLFeedHomeStories.Builder;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.topics.protocol.FetchTopicsParamBuilderUtil;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.MoreObjects;
import javax.inject.Inject;

/* compiled from: com.facebook.acra.ErrorReporter.handleException */
public class FetchEventFeedMethod extends FetchFeedMethod {
    private final FetchFeedQueryUtil f17395e;
    private final FetchReactorsParamBuilderUtil f17396f;
    private final FetchRecentActivityParamBuilderUtil f17397g;
    private final FetchTopicsParamBuilderUtil f17398h;
    private final FetchVideoChannelParamBuilderUtil f17399i;
    private final AutomaticPhotoCaptioningUtils f17400j;

    public static FetchEventFeedMethod m17768b(InjectorLike injectorLike) {
        return new FetchEventFeedMethod(GraphQLProtocolHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), StartupPerfLogger.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), FetchFeedQueryUtil.a(injectorLike), FetchReactorsParamBuilderUtil.a(injectorLike), FetchRecentActivityParamBuilderUtil.a(injectorLike), FetchTopicsParamBuilderUtil.a(injectorLike), FetchVideoChannelParamBuilderUtil.a(injectorLike), AutomaticPhotoCaptioningUtils.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FetchFeedbackMethod.b(injectorLike));
    }

    public final GraphQlQueryString m17776f(Object obj) {
        FetchFeedParams fetchFeedParams = (FetchFeedParams) obj;
        GraphQlQueryString eventFeedQueryString = new EventFeedQueryString();
        this.f17395e.a(eventFeedQueryString);
        this.f17395e.b(eventFeedQueryString);
        FetchFeedQueryUtil.a(eventFeedQueryString, fetchFeedParams, "before", "after");
        this.f17395e.c(eventFeedQueryString);
        FetchFeedQueryUtil.d(eventFeedQueryString);
        this.f17397g.a(eventFeedQueryString);
        this.f17398h.a(eventFeedQueryString);
        this.f17399i.a(eventFeedQueryString);
        eventFeedQueryString.a("action_location", NegativeFeedbackExperienceLocation.EVENT.stringValueOf());
        eventFeedQueryString.a("automatic_photo_captioning_enabled", Boolean.toString(this.f17400j.a()));
        if (fetchFeedParams != null) {
            eventFeedQueryString.a("event_id", (String) fetchFeedParams.b.f).a("first", String.valueOf(fetchFeedParams.c));
        }
        return eventFeedQueryString;
    }

    @Inject
    public FetchEventFeedMethod(GraphQLProtocolHelper graphQLProtocolHelper, AbstractFbErrorReporter abstractFbErrorReporter, StartupPerfLogger startupPerfLogger, Clock clock, MonotonicClock monotonicClock, FetchFeedQueryUtil fetchFeedQueryUtil, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil, FetchTopicsParamBuilderUtil fetchTopicsParamBuilderUtil, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils, QeAccessor qeAccessor, FetchFeedbackMethod fetchFeedbackMethod) {
        super(graphQLProtocolHelper, abstractFbErrorReporter, startupPerfLogger, clock, monotonicClock, qeAccessor, fetchFeedbackMethod);
        this.f17395e = fetchFeedQueryUtil;
        this.f17396f = fetchReactorsParamBuilderUtil;
        this.f17397g = fetchRecentActivityParamBuilderUtil;
        this.f17398h = fetchTopicsParamBuilderUtil;
        this.f17399i = fetchVideoChannelParamBuilderUtil;
        this.f17400j = automaticPhotoCaptioningUtils;
    }

    protected final String m17773c() {
        return "event_stories";
    }

    protected final String m17774c(FetchFeedParams fetchFeedParams) {
        return "EventsFeedNetworkTime";
    }

    protected final int m17775d(FetchFeedParams fetchFeedParams) {
        return 655487;
    }

    public final int m17772b(Object obj, ApiResponse apiResponse) {
        return 2;
    }

    protected final GraphQLFeedHomeStories m17770a(FetchFeedParams fetchFeedParams, JsonParser jsonParser) {
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

    public final GraphQLFeedHomeStories m17769a(FetchFeedParams fetchFeedParams, GraphQLResult graphQLResult) {
        GraphQLFeedHomeStories a = super.a(fetchFeedParams, graphQLResult);
        a(a);
        return a;
    }

    protected final String m17771a(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        return (String) MoreObjects.firstNonNull(graphQLFeedUnitEdge.c() instanceof GraphQLStory ? ((GraphQLStory) graphQLFeedUnitEdge.c()).c() : null, graphQLFeedUnitEdge.c().g());
    }
}
