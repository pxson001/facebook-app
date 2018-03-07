package com.facebook.groups.feed.protocol;

import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.logging.viewport.GroupMallVpvs;
import com.facebook.feed.protocol.FetchFeedMethod;
import com.facebook.feed.protocol.FetchFeedQueryUtil;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.graphql.model.GraphQLFeedHomeStories.Builder;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLGroup;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.feed.protocol.FetchGroupAvailableForSalePostsGraphQL.GroupAvailableForSalePostsString;
import com.facebook.groups.feed.protocol.FetchGroupFeedGraphQL.GroupFeedQueryString;
import com.facebook.groups.feed.protocol.FetchGroupFeedGraphQL.GroupStoriesFeedQueryString;
import com.facebook.groups.feed.protocol.FetchGroupOwnerAuthoredPostGraphQL.GroupAuthoredAvailableForSalePostsString;
import com.facebook.groups.feed.protocol.FetchGroupOwnerAuthoredPostGraphQL.GroupAuthoredExpiredForSalePostsString;
import com.facebook.groups.feed.protocol.FetchGroupOwnerAuthoredPostGraphQL.GroupAuthoredSoldForSalePostsString;
import com.facebook.groups.feed.protocol.FetchGroupPendingPostsGraphQL.GroupPendingPostsQueryString;
import com.facebook.groups.feed.protocol.FetchGroupReportedPosts.GroupReportedPostsQueryString;
import com.facebook.groups.feed.protocol.FetchMarketplaceCrossGroupStoriesGraphQL.MarketplaceCrossGroupStoriesString;
import com.facebook.groups.feed.protocol.GroupsFeedTypeValueParams.C05282;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.topics.protocol.FetchTopicsParamBuilderUtil;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: rating_scale */
public class FetchGroupFeedMethod extends FetchFeedMethod {
    private final FetchFeedQueryUtil f5515e;
    private final GraphQLStoryHelper f5516f;
    private final FetchReactorsParamBuilderUtil f5517g;
    private final Provider<VideoDashConfig> f5518h;
    private final FetchRecentActivityParamBuilderUtil f5519i;
    private final FetchTopicsParamBuilderUtil f5520j;
    private final FetchVideoChannelParamBuilderUtil f5521k;
    private final AutomaticPhotoCaptioningUtils f5522l;
    private final QeAccessor f5523m;
    private final GroupMallVpvs f5524n;

    public static FetchGroupFeedMethod m6257b(InjectorLike injectorLike) {
        return new FetchGroupFeedMethod(FetchFeedQueryUtil.a(injectorLike), FetchReactorsParamBuilderUtil.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 3635), FetchRecentActivityParamBuilderUtil.a(injectorLike), FetchTopicsParamBuilderUtil.m18828a(injectorLike), GraphQLProtocolHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), StartupPerfLogger.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), GraphQLStoryHelper.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FetchVideoChannelParamBuilderUtil.a(injectorLike), AutomaticPhotoCaptioningUtils.a(injectorLike), FetchFeedbackMethod.a(injectorLike), GroupMallVpvs.a(injectorLike));
    }

    public final /* synthetic */ void m6266c(Object obj) {
        b((FetchFeedParams) obj);
    }

    public final /* synthetic */ GraphQlQueryString m6269f(Object obj) {
        return m6268e((FetchFeedParams) obj);
    }

    @Inject
    public FetchGroupFeedMethod(FetchFeedQueryUtil fetchFeedQueryUtil, FetchReactorsParamBuilderUtil fetchReactorsParamBuilderUtil, Provider<VideoDashConfig> provider, FetchRecentActivityParamBuilderUtil fetchRecentActivityParamBuilderUtil, FetchTopicsParamBuilderUtil fetchTopicsParamBuilderUtil, GraphQLProtocolHelper graphQLProtocolHelper, FbErrorReporter fbErrorReporter, StartupPerfLogger startupPerfLogger, Clock clock, MonotonicClock monotonicClock, GraphQLStoryHelper graphQLStoryHelper, QeAccessor qeAccessor, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils, FetchFeedbackMethod fetchFeedbackMethod, GroupMallVpvs groupMallVpvs) {
        super(graphQLProtocolHelper, fbErrorReporter, startupPerfLogger, clock, monotonicClock, qeAccessor, fetchFeedbackMethod);
        this.f5515e = fetchFeedQueryUtil;
        this.f5517g = fetchReactorsParamBuilderUtil;
        this.f5518h = provider;
        this.f5519i = fetchRecentActivityParamBuilderUtil;
        this.f5520j = fetchTopicsParamBuilderUtil;
        this.f5516f = graphQLStoryHelper;
        this.f5521k = fetchVideoChannelParamBuilderUtil;
        this.f5522l = automaticPhotoCaptioningUtils;
        this.f5523m = qeAccessor;
        this.f5524n = groupMallVpvs;
    }

    protected final String m6264c() {
        return "fetch_group_feed";
    }

    protected final String m6265c(FetchFeedParams fetchFeedParams) {
        return "GroupsFeedNetworkTime";
    }

    protected final int m6267d(FetchFeedParams fetchFeedParams) {
        return 655490;
    }

    public final TypedGraphQlQueryString<GraphQLGroup> m6268e(FetchFeedParams fetchFeedParams) {
        TypedGraphQlQueryString b;
        ImmutableList b2;
        switch (C05282.f5694a[m6258f(fetchFeedParams).f5696b.ordinal()]) {
            case 1:
                b = FetchGroupPinnedPostGraphQL.m6501a().b(true);
                break;
            case 2:
                b = new GroupPendingPostsQueryString().b(true);
                break;
            case 3:
                b = new GroupReportedPostsQueryString().b(true);
                break;
            case 4:
                b = new GroupAuthoredAvailableForSalePostsString().b(true);
                break;
            case 5:
                b = new GroupAuthoredSoldForSalePostsString().b(true);
                break;
            case 6:
                b = new GroupAuthoredExpiredForSalePostsString().b(true);
                break;
            case 7:
                b = new GroupStoriesFeedQueryString().b(true);
                break;
            case 8:
                b = new GroupAvailableForSalePostsString().b(true);
                break;
            case 9:
                b = new MarketplaceCrossGroupStoriesString().b(true);
                break;
            default:
                b = new GroupFeedQueryString().b(true);
                break;
        }
        GraphQlQueryString graphQlQueryString = b;
        this.f5515e.a(graphQlQueryString);
        this.f5515e.b(graphQlQueryString);
        this.f5515e.c(graphQlQueryString);
        FetchFeedQueryUtil.d(graphQlQueryString);
        this.f5517g.a(graphQlQueryString);
        this.f5519i.a(graphQlQueryString);
        this.f5520j.m18830a(graphQlQueryString);
        graphQlQueryString.a("action_location", NegativeFeedbackExperienceLocation.GROUP.stringValueOf()).a("gysc_member_profile_size", GraphQLStoryHelper.p()).a("gysj_facepile_count_param", "4").a("gysj_facepile_size_param", GraphQLStoryHelper.o()).a("gysj_cover_photo_width_param", Integer.valueOf(GraphQLStoryHelper.o().intValue() * 3)).a("automatic_photo_captioning_enabled", Boolean.toString(this.f5522l.a())).a("enable_download", Boolean.toString(this.f5523m.a(ExperimentsForVideoAbTestModule.cW, false)));
        if (fetchFeedParams != null) {
            graphQlQueryString.a("group_id", m6258f(fetchFeedParams).f5695a).a("first", String.valueOf(fetchFeedParams.c));
            b2 = m6258f(fetchFeedParams).m6949b();
            if (b2 != null) {
                graphQlQueryString.a("story_ids", b2);
            }
        }
        if (fetchFeedParams == null || fetchFeedParams.f != FetchFeedCause.INITIALIZATION || m6258f(fetchFeedParams).m6949b() == null) {
            FetchFeedQueryUtil.a(graphQlQueryString, fetchFeedParams, "before", "after");
        } else if (fetchFeedParams.e != null) {
            graphQlQueryString.a("after", fetchFeedParams.e);
        }
        if (this.f5518h != null && ((VideoDashConfig) this.f5518h.get()).a()) {
            graphQlQueryString.a("scrubbing", "MPEG_DASH");
        }
        b2 = fetchFeedParams.i;
        if (!(b2 == null || b2.isEmpty())) {
            graphQlQueryString.a("recent_vpvs", b2);
        }
        this.f5521k.a(graphQlQueryString, EntryPointInputVideoChannelEntryPoint.GROUP);
        return graphQlQueryString;
    }

    private static GroupsFeedTypeValueParams m6258f(FetchFeedParams fetchFeedParams) {
        return (GroupsFeedTypeValueParams) fetchFeedParams.b.f;
    }

    public final /* synthetic */ int m6262b(Object obj, ApiResponse apiResponse) {
        return 2;
    }

    protected final GraphQLFeedHomeStories m6260a(FetchFeedParams fetchFeedParams, JsonParser jsonParser) {
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

    public final GraphQLFeedHomeStories m6259a(FetchFeedParams fetchFeedParams, GraphQLResult graphQLResult) {
        GraphQLFeedHomeStories a = super.a(fetchFeedParams, graphQLResult);
        a(a);
        return a;
    }

    protected final String m6261a(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        return (String) MoreObjects.firstNonNull(graphQLFeedUnitEdge.c() instanceof GraphQLStory ? ((GraphQLStory) graphQLFeedUnitEdge.c()).c() : null, graphQLFeedUnitEdge.c().g());
    }

    public final void m6263b(FetchFeedParams fetchFeedParams) {
        super.b(fetchFeedParams);
        ImmutableList immutableList = fetchFeedParams.i;
        if (immutableList != null && !immutableList.isEmpty()) {
            GroupMallVpvs groupMallVpvs = this.f5524n;
            if (immutableList != null) {
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    groupMallVpvs.a.b((String) immutableList.get(i));
                }
            }
        }
    }
}
