package com.facebook.feed.protocol;

import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParams.FetchTypeForLogging;
import com.facebook.api.feed.FetchFeedParamsBuilder;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.FetchFeedType;
import com.facebook.api.feed.xconfig.FeedOffScreenAdsFetchXConfig;
import com.facebook.api.feed.xconfig.FeedOffScreenAdsFetchXConfigReader;
import com.facebook.api.feed.xconfig.NewsFeedXConfigReader;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.api.feedtype.newsfeed.NewsFeedTypeValue;
import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.api.ufiservices.common.FetchReactorsParamBuilderUtil;
import com.facebook.api.ufiservices.common.FetchRecentActivityParamBuilderUtil;
import com.facebook.api.ufiservices.qe.ExperimentsForUfiServiceQeModule;
import com.facebook.checkin.socialsearch.parambuilder.SocialSearchParamBuilderUtil;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.hardware.BatteryStateManager;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.udppriming.client.ColdStartPrimingInformation;
import com.facebook.common.udppriming.client.UDPPrimingStatus;
import com.facebook.crudolib.params.ParamsCollection;
import com.facebook.crudolib.params.ParamsFormEncoder;
import com.facebook.crudolib.params.ParamsJsonEncoder;
import com.facebook.debug.feed.DebugFeedConfig;
import com.facebook.debug.pref.DebugLoggingPrefKeys;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ErrorCodeUtil;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.bugreporter.FeedLoadingDebugInfo;
import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.feed.protocol.FetchFeedMethod.FetcherCallback;
import com.facebook.feed.protocol.FetchNewsFeedGraphQL.NewsFeedQueryDepth3DebugString;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.calls.LocationInputStoryRenderLocation;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLFeedHomeStories;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLModelFlatbufferHelper;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.graphql.model.NewsFeedEdge;
import com.facebook.graphql.model.interfaces.FeedUnitCommon;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQLRefParam.BatchQueryFanOutStyle;
import com.facebook.graphql.query.GraphQLRefParam.FallbackStyle;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.BatchMethodNotExecutedException;
import com.facebook.http.protocol.UDPPrimingHelper;
import com.facebook.http.protocol.UDPPrimingHelper.2;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.location.FbLocationCache;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationAgeUtil;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.user.model.User;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelParamBuilderUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: scrollToTop should be called on the UI thread */
public class FetchNewsFeedMethod extends FetchFeedMethod {
    private static final MarkerConfig f5960D = new MarkerConfig(655492, "NNFCold_Network");
    private static final MarkerConfig f5961E = new MarkerConfig(655493, "NNFWarm_Network");
    private static final MarkerConfig f5962F = new MarkerConfig(655494, "NNFNetworktimeHead");
    private static final MarkerConfig f5963G = new MarkerConfig(655495, "NNFNetworkTime");
    private static final MarkerConfig f5964H = new MarkerConfig(655496, "NNFNetworkTimeChunkedRemainder");
    private static final MarkerConfig f5965I = new MarkerConfig(655497, "NNFNetworkTimeTail");
    private static final MarkerConfig f5966J = new MarkerConfig(655498, "NNFNetworktimeUnset");
    public final Provider<Boolean> f5967A;
    private final AutomaticPhotoCaptioningUtils f5968B;
    private final TopicFeedsTestUtil f5969C;
    public String f5970K = "";
    public int[] f5971L = null;
    private final FetchVideoChannelParamBuilderUtil f5972M;
    private final QeAccessor f5973e;
    private final Lazy<GraphQLStoryHelper> f5974f;
    private final GraphQLImageHelper f5975g;
    public final UDPPrimingHelper f5976h;
    public final Lazy<FetchFeedQueryUtil> f5977i;
    private final Provider<User> f5978j;
    public final Lazy<FeedLoadingDebugInfo> f5979k;
    private final PerformanceLogger f5980l;
    private final Lazy<DebugFeedConfig> f5981m;
    public final Lazy<BatteryStateManager> f5982n;
    public final Lazy<FbDataConnectionManager> f5983o;
    private final Lazy<FeedPerfLogger> f5984p;
    private final FeedReliabilityLogger f5985q;
    private final Lazy<UniqueIdForDeviceHolder> f5986r;
    private final Provider<VideoDashConfig> f5987s;
    public final FbSharedPreferences f5988t;
    private final Lazy<FetchReactorsParamBuilderUtil> f5989u;
    private final Lazy<FetchRecentActivityParamBuilderUtil> f5990v;
    private final Lazy<SocialSearchParamBuilderUtil> f5991w;
    private final Lazy<FetchOffScreenAdsHelper> f5992x;
    private final NewsFeedXConfigReader f5993y;
    public final Provider<Boolean> f5994z;

    public static FetchNewsFeedMethod m10080b(InjectorLike injectorLike) {
        return new FetchNewsFeedMethod(QeInternalImplMethodAutoProvider.m3744a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3478), GraphQLImageHelper.m10139a(injectorLike), UDPPrimingHelper.m9443a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1467), IdBasedSingletonScopeProvider.m1810b(injectorLike, 547), IdBasedSingletonScopeProvider.m1810b(injectorLike, 584), IdBasedLazy.m1808a(injectorLike, 1077), GraphQLProtocolHelper.m9427a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3595), DelegatingPerformanceLogger.m2803a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 5838), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), StartupPerfLogger.m3406a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1031), IdBasedProvider.m1811a(injectorLike, 3981), FeedReliabilityLogger.m10151a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 1450), IdBasedSingletonScopeProvider.m1809a(injectorLike, 3635), FbSharedPreferencesImpl.m1826a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 260), IdBasedSingletonScopeProvider.m1810b(injectorLike, 261), IdBasedSingletonScopeProvider.m1810b(injectorLike, 448), IdBasedLazy.m1808a(injectorLike, 1470), NewsFeedXConfigReader.m8187a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3980), FetchVideoChannelParamBuilderUtil.m10180a(injectorLike), AutomaticPhotoCaptioningUtils.m10186a(injectorLike), TopicFeedsTestUtil.m8785a(injectorLike), FetchFeedbackMethod.m10189a(injectorLike));
    }

    public final Object mo1423a(@Nullable Object obj, ApiResponse apiResponse) {
        FetchFeedParams fetchFeedParams = (FetchFeedParams) obj;
        try {
            return (FetchFeedResult) super.mo1423a(fetchFeedParams, apiResponse);
        } catch (Exception e) {
            this.f5985q.m10161a(fetchFeedParams, apiResponse.m22209g(), e);
            throw e;
        }
    }

    public final /* synthetic */ void mo1429b(Object obj) {
        mo1425a((FetchFeedParams) obj);
    }

    public final /* synthetic */ GraphQlQueryString mo1433f(Object obj) {
        return m10097e((FetchFeedParams) obj);
    }

    public static MarkerConfig m10075a(PerformanceLogger performanceLogger, FetchFeedParams fetchFeedParams) {
        FetchTypeForLogging fetchTypeForLogging = fetchFeedParams.f5798p;
        if (fetchTypeForLogging == FetchTypeForLogging.HEAD || fetchTypeForLogging == FetchTypeForLogging.CHUNKED_INITIAL || fetchTypeForLogging == FetchTypeForLogging.TAIL) {
            if (performanceLogger.mo400h(655361, "NNFColdStart")) {
                return f5960D;
            }
            if (performanceLogger.mo400h(655380, "NNFFreshContentStart")) {
                return f5961E;
            }
        }
        switch (1.b[fetchTypeForLogging.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return f5962F;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return f5963G;
            case 3:
                return f5964H;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return f5965I;
            default:
                return f5966J;
        }
    }

    @Inject
    public FetchNewsFeedMethod(QeAccessor qeAccessor, Lazy<GraphQLStoryHelper> lazy, GraphQLImageHelper graphQLImageHelper, UDPPrimingHelper uDPPrimingHelper, Lazy<FetchFeedQueryUtil> lazy2, Lazy<BatteryStateManager> lazy3, Lazy<FbDataConnectionManager> lazy4, Lazy<UniqueIdForDeviceHolder> lazy5, GraphQLProtocolHelper graphQLProtocolHelper, FbErrorReporter fbErrorReporter, Clock clock, Provider<User> provider, PerformanceLogger performanceLogger, Lazy<FeedLoadingDebugInfo> lazy6, MonotonicClock monotonicClock, StartupPerfLogger startupPerfLogger, Lazy<DebugFeedConfig> lazy7, Provider<Boolean> provider2, FeedReliabilityLogger feedReliabilityLogger, Lazy<FeedPerfLogger> lazy8, Provider<VideoDashConfig> provider3, FbSharedPreferences fbSharedPreferences, Lazy<FetchReactorsParamBuilderUtil> lazy9, Lazy<FetchRecentActivityParamBuilderUtil> lazy10, Lazy<SocialSearchParamBuilderUtil> lazy11, Lazy<FetchOffScreenAdsHelper> lazy12, NewsFeedXConfigReader newsFeedXConfigReader, Provider<Boolean> provider4, FetchVideoChannelParamBuilderUtil fetchVideoChannelParamBuilderUtil, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils, TopicFeedsTestUtil topicFeedsTestUtil, FetchFeedbackMethod fetchFeedbackMethod) {
        super(graphQLProtocolHelper, fbErrorReporter, startupPerfLogger, clock, monotonicClock, qeAccessor, fetchFeedbackMethod);
        this.f5973e = qeAccessor;
        this.f5974f = lazy;
        this.f5975g = graphQLImageHelper;
        this.f5976h = uDPPrimingHelper;
        this.f5977i = lazy2;
        this.f5982n = lazy3;
        this.f5986r = lazy5;
        this.f5983o = lazy4;
        this.f5978j = provider;
        this.f5979k = lazy6;
        this.f5980l = performanceLogger;
        this.f5981m = lazy7;
        this.f5985q = feedReliabilityLogger;
        this.f5987s = provider3;
        this.f5984p = lazy8;
        this.f5988t = fbSharedPreferences;
        this.f5972M = fetchVideoChannelParamBuilderUtil;
        this.f5989u = lazy9;
        this.f5990v = lazy10;
        this.f5991w = lazy11;
        this.f5992x = lazy12;
        this.f5993y = newsFeedXConfigReader;
        this.f5994z = provider2;
        this.f5967A = provider4;
        this.f5968B = automaticPhotoCaptioningUtils;
        this.f5969C = topicFeedsTestUtil;
    }

    public final FetchFeedResult mo1420a(FetchFeedParams fetchFeedParams, ApiResponse apiResponse, JsonParser jsonParser) {
        FetchFeedResult a = super.mo1420a(fetchFeedParams, apiResponse, jsonParser);
        switch (1.a[FetchFeedType.getQueryType(fetchFeedParams).ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                m10077a(a);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                m10077a(a);
                break;
            case 3:
                break;
        }
        if (a.m22439d().isEmpty()) {
            ((FeedLoadingDebugInfo) this.f5979k.get()).d(a);
        } else {
            ((FeedLoadingDebugInfo) this.f5979k.get()).c(a);
        }
        return a;
    }

    public final void mo1426a(FetchFeedParams fetchFeedParams, Exception exception) {
        super.mo1426a(fetchFeedParams, exception);
        ErrorCode a = ErrorCodeUtil.a(exception);
        if (a == ErrorCode.API_ERROR || a == ErrorCode.HTTP_500_CLASS) {
            if (!(exception instanceof BatchMethodNotExecutedException)) {
                this.f5985q.m10163b(fetchFeedParams, exception);
            } else if (fetchFeedParams.f5798p == FetchTypeForLogging.CHUNKED_REMAINDER) {
                this.f5985q.m10157a(fetchFeedParams);
            }
        } else if (a == ErrorCode.CONNECTION_FAILURE) {
            this.f5985q.m10159a(fetchFeedParams, exception);
        } else {
            this.f5985q.m10165c(fetchFeedParams, exception);
        }
    }

    public final GraphQLFeedHomeStories mo1422a(FetchFeedParams fetchFeedParams, GraphQLResult graphQLResult) {
        Object obj = graphQLResult.f6203e;
        if (obj instanceof GraphQLViewer) {
            return m10074a((GraphQLViewer) obj, ((DebugFeedConfig) this.f5981m.get()).m11300a());
        }
        throw new RuntimeException("Unrecognized GraphQLResult:" + graphQLResult.toString());
    }

    private void m10077a(FetchFeedResult fetchFeedResult) {
        if (fetchFeedResult.m22439d().isEmpty()) {
            ((FeedLoadingDebugInfo) this.f5979k.get()).b(fetchFeedResult);
        } else {
            ((FeedLoadingDebugInfo) this.f5979k.get()).a(fetchFeedResult);
        }
    }

    private void m10078a(GraphQlQueryString graphQlQueryString, FetchFeedParams fetchFeedParams) {
        String str;
        FetchFeedQueryUtil fetchFeedQueryUtil;
        GraphQLStoryHelper graphQLStoryHelper;
        FeedType feedType;
        Object obj;
        String a;
        String str2 = "PRODUCTION";
        User user = (User) this.f5978j.get();
        if (user != null && user.f3612o) {
            boolean z = false;
            if (this.f5988t.mo284a() && this.f5988t.mo286a(DebugLoggingPrefKeys.f2809g, false)) {
                z = true;
            }
            if (!z) {
                str = "DEBUG";
                fetchFeedQueryUtil = (FetchFeedQueryUtil) this.f5977i.get();
                fetchFeedQueryUtil.m11409a(graphQlQueryString);
                FetchFeedQueryUtil.m11406a(graphQlQueryString, (UniqueIdForDeviceHolderImpl) this.f5986r.get());
                fetchFeedQueryUtil.m11411b(graphQlQueryString);
                fetchFeedQueryUtil.m11410a(graphQlQueryString, fetchFeedParams, "cached_stories_range");
                fetchFeedQueryUtil.m11412c(graphQlQueryString);
                FetchFeedQueryUtil.m11408d(graphQlQueryString);
                fetchFeedQueryUtil.m11414g(graphQlQueryString);
                fetchFeedQueryUtil.m11413e(graphQlQueryString);
                graphQLStoryHelper = (GraphQLStoryHelper) this.f5974f.get();
                graphQlQueryString.m11314a("creative_low_img_size", graphQLStoryHelper.m10207A()).m11314a("creative_med_img_size", graphQLStoryHelper.m10208B()).m11314a("creative_high_img_size", graphQLStoryHelper.m10209C()).m11314a("pymk_size_param", graphQLStoryHelper.m10217g()).m11314a("saved_item_pic_width", graphQLStoryHelper.m10218i()).m11314a("saved_item_pic_height", graphQLStoryHelper.m10219j()).m11314a("pyml_size_param", graphQLStoryHelper.m10220k()).m11314a("pysf_size_param", GraphQLImageHelper.m10140a(graphQLStoryHelper.f6089e.getDimensionPixelSize(2131428877))).m11314a("profile_pic_swipe_size_param", graphQLStoryHelper.m10221l()).m11314a("gysc_member_profile_size", GraphQLStoryHelper.m10205p()).m11314a("gysj_size_param", graphQLStoryHelper.m10222m()).m11314a("gysj_facepile_size_param", GraphQLStoryHelper.m10204o()).m11314a("gysj_cover_photo_width_param", Integer.valueOf(GraphQLStoryHelper.m10204o().intValue() * 3)).m11314a("gysj_facepile_count_param", Integer.valueOf(4)).m11314a("sgny_size_param", graphQLStoryHelper.m10222m()).m11314a("sgny_facepile_size_param", GraphQLStoryHelper.m10204o()).m11314a("sgny_cover_photo_width_param", Integer.valueOf(GraphQLStoryHelper.m10204o().intValue() * 3)).m11314a("sgny_facepile_count_param", Integer.valueOf(4)).m11314a("celebrations_profile_pic_size_param", GraphQLStoryHelper.m10206q()).m11314a("multi_share_item_image_size_param", graphQLStoryHelper.m10226u()).m11314a("friends_locations_profile_pic_size_param", graphQLStoryHelper.m10210H()).m11314a("quick_promotion_image_size_param", graphQLStoryHelper.m10211I()).m11314a("quick_promotion_large_image_size_param", graphQLStoryHelper.m10212J()).m11314a("quick_promotion_branding_image_size_param", GraphQLImageHelper.m10140a(graphQLStoryHelper.f6089e.getDimensionPixelSize(2131428916))).m11314a("first_home_story_param", Integer.valueOf(fetchFeedParams.f5785c)).m11314a("discovery_image_size", graphQLStoryHelper.m10222m()).m11315a("debug_mode", str).m11313a("ad_media_type", this.f5975g.m10143a()).m11314a("num_faceboxes_and_tags", graphQLStoryHelper.f6088b).m11315a("include_replies_in_total_count", Boolean.toString(this.f5973e.mo596a(ExperimentsForUfiServiceQeModule.f6627l, false))).m11314a("greeting_card_image_size_large", this.f5975g.m10148f()).m11314a("greeting_card_image_size_medium", this.f5975g.m10149g()).m11314a("num_media_question_options", Integer.valueOf(15)).m11314a("media_question_photo_size", this.f5975g.m10148f()).m11315a("enable_download", Boolean.toString(this.f5973e.mo596a(ExperimentsForVideoAbTestModule.cW, false))).m11315a("enable_hd", Boolean.toString(true)).m11314a("goodwill_full_width_image", Integer.valueOf(this.f5975g.m10147e())).m11314a("goodwill_small_accent_image", this.f5975g.m10150h()).m11314a("friends_birthday_profile_image_size", Integer.valueOf(GraphQlQueryDefaults.m11421c())).m11312a("topic_feeds_enabled", Boolean.valueOf(this.f5969C.m8792b())).m11313a("action_links_location", LocationInputStoryRenderLocation.HOMEPAGE_STREAM).m11314a("place_review_img_width", GraphQLImageHelper.m10140a(graphQLStoryHelper.f6089e.getDimensionPixelSize(2131429111))).m11314a("place_review_img_height", GraphQLImageHelper.m10140a(graphQLStoryHelper.f6089e.getDimensionPixelSize(2131429112))).m11315a("automatic_photo_captioning_enabled", Boolean.toString(this.f5968B.m10188a())).m11315a("inline_comments_for_aggregated_stories", Boolean.toString(this.f5973e.mo593a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMultipleRowsStoriesAbtestModule.f6711a, false))).m11315a("skip_sample_entities_fields", Boolean.toString(this.f5973e.mo596a(ExperimentsForNewsFeedAbTestModule.f5100a, false)));
                feedType = fetchFeedParams.f5784b;
                obj = feedType.f5043f;
                if (feedType.f5044g.equals(Name.f5053h)) {
                    a = FeedType.f5039b.m8961a();
                } else if (obj instanceof NewsFeedTypeValue) {
                    a = feedType.m8961a();
                } else {
                    a = ((NewsFeedTypeValue) obj).f6726b;
                }
                graphQlQueryString.m11315a("orderby_home_story_param", a);
                if (obj instanceof NewsFeedTypeValue) {
                    graphQlQueryString.m11315a("feed_style", ((NewsFeedTypeValue) obj).f6725a);
                }
                if (fetchFeedParams.f5787e == null) {
                    graphQlQueryString.m11315a("refresh_mode_param", fetchFeedParams.f5788f.toString());
                }
                ((FetchRecentActivityParamBuilderUtil) this.f5990v.get()).m10421a(graphQlQueryString);
                this.f5991w.get();
                SocialSearchParamBuilderUtil.m11494a(graphQlQueryString);
                if (((VideoDashConfig) this.f5987s.get()).m11512a()) {
                    graphQlQueryString.m11315a("scrubbing", "MPEG_DASH");
                } else if (((VideoDashConfig) this.f5987s.get()).m11515c()) {
                    graphQlQueryString.m11315a("scrubbing", "WEBM_DASH");
                }
                this.f5972M.m10183a(graphQlQueryString, EntryPointInputVideoChannelEntryPoint.NEWSFEED);
            }
        }
        str = str2;
        fetchFeedQueryUtil = (FetchFeedQueryUtil) this.f5977i.get();
        fetchFeedQueryUtil.m11409a(graphQlQueryString);
        FetchFeedQueryUtil.m11406a(graphQlQueryString, (UniqueIdForDeviceHolderImpl) this.f5986r.get());
        fetchFeedQueryUtil.m11411b(graphQlQueryString);
        fetchFeedQueryUtil.m11410a(graphQlQueryString, fetchFeedParams, "cached_stories_range");
        fetchFeedQueryUtil.m11412c(graphQlQueryString);
        FetchFeedQueryUtil.m11408d(graphQlQueryString);
        fetchFeedQueryUtil.m11414g(graphQlQueryString);
        fetchFeedQueryUtil.m11413e(graphQlQueryString);
        graphQLStoryHelper = (GraphQLStoryHelper) this.f5974f.get();
        graphQlQueryString.m11314a("creative_low_img_size", graphQLStoryHelper.m10207A()).m11314a("creative_med_img_size", graphQLStoryHelper.m10208B()).m11314a("creative_high_img_size", graphQLStoryHelper.m10209C()).m11314a("pymk_size_param", graphQLStoryHelper.m10217g()).m11314a("saved_item_pic_width", graphQLStoryHelper.m10218i()).m11314a("saved_item_pic_height", graphQLStoryHelper.m10219j()).m11314a("pyml_size_param", graphQLStoryHelper.m10220k()).m11314a("pysf_size_param", GraphQLImageHelper.m10140a(graphQLStoryHelper.f6089e.getDimensionPixelSize(2131428877))).m11314a("profile_pic_swipe_size_param", graphQLStoryHelper.m10221l()).m11314a("gysc_member_profile_size", GraphQLStoryHelper.m10205p()).m11314a("gysj_size_param", graphQLStoryHelper.m10222m()).m11314a("gysj_facepile_size_param", GraphQLStoryHelper.m10204o()).m11314a("gysj_cover_photo_width_param", Integer.valueOf(GraphQLStoryHelper.m10204o().intValue() * 3)).m11314a("gysj_facepile_count_param", Integer.valueOf(4)).m11314a("sgny_size_param", graphQLStoryHelper.m10222m()).m11314a("sgny_facepile_size_param", GraphQLStoryHelper.m10204o()).m11314a("sgny_cover_photo_width_param", Integer.valueOf(GraphQLStoryHelper.m10204o().intValue() * 3)).m11314a("sgny_facepile_count_param", Integer.valueOf(4)).m11314a("celebrations_profile_pic_size_param", GraphQLStoryHelper.m10206q()).m11314a("multi_share_item_image_size_param", graphQLStoryHelper.m10226u()).m11314a("friends_locations_profile_pic_size_param", graphQLStoryHelper.m10210H()).m11314a("quick_promotion_image_size_param", graphQLStoryHelper.m10211I()).m11314a("quick_promotion_large_image_size_param", graphQLStoryHelper.m10212J()).m11314a("quick_promotion_branding_image_size_param", GraphQLImageHelper.m10140a(graphQLStoryHelper.f6089e.getDimensionPixelSize(2131428916))).m11314a("first_home_story_param", Integer.valueOf(fetchFeedParams.f5785c)).m11314a("discovery_image_size", graphQLStoryHelper.m10222m()).m11315a("debug_mode", str).m11313a("ad_media_type", this.f5975g.m10143a()).m11314a("num_faceboxes_and_tags", graphQLStoryHelper.f6088b).m11315a("include_replies_in_total_count", Boolean.toString(this.f5973e.mo596a(ExperimentsForUfiServiceQeModule.f6627l, false))).m11314a("greeting_card_image_size_large", this.f5975g.m10148f()).m11314a("greeting_card_image_size_medium", this.f5975g.m10149g()).m11314a("num_media_question_options", Integer.valueOf(15)).m11314a("media_question_photo_size", this.f5975g.m10148f()).m11315a("enable_download", Boolean.toString(this.f5973e.mo596a(ExperimentsForVideoAbTestModule.cW, false))).m11315a("enable_hd", Boolean.toString(true)).m11314a("goodwill_full_width_image", Integer.valueOf(this.f5975g.m10147e())).m11314a("goodwill_small_accent_image", this.f5975g.m10150h()).m11314a("friends_birthday_profile_image_size", Integer.valueOf(GraphQlQueryDefaults.m11421c())).m11312a("topic_feeds_enabled", Boolean.valueOf(this.f5969C.m8792b())).m11313a("action_links_location", LocationInputStoryRenderLocation.HOMEPAGE_STREAM).m11314a("place_review_img_width", GraphQLImageHelper.m10140a(graphQLStoryHelper.f6089e.getDimensionPixelSize(2131429111))).m11314a("place_review_img_height", GraphQLImageHelper.m10140a(graphQLStoryHelper.f6089e.getDimensionPixelSize(2131429112))).m11315a("automatic_photo_captioning_enabled", Boolean.toString(this.f5968B.m10188a())).m11315a("inline_comments_for_aggregated_stories", Boolean.toString(this.f5973e.mo593a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMultipleRowsStoriesAbtestModule.f6711a, false))).m11315a("skip_sample_entities_fields", Boolean.toString(this.f5973e.mo596a(ExperimentsForNewsFeedAbTestModule.f5100a, false)));
        feedType = fetchFeedParams.f5784b;
        obj = feedType.f5043f;
        if (feedType.f5044g.equals(Name.f5053h)) {
            a = FeedType.f5039b.m8961a();
        } else if (obj instanceof NewsFeedTypeValue) {
            a = feedType.m8961a();
        } else {
            a = ((NewsFeedTypeValue) obj).f6726b;
        }
        graphQlQueryString.m11315a("orderby_home_story_param", a);
        if (obj instanceof NewsFeedTypeValue) {
            graphQlQueryString.m11315a("feed_style", ((NewsFeedTypeValue) obj).f6725a);
        }
        if (fetchFeedParams.f5787e == null) {
            graphQlQueryString.m11315a("refresh_mode_param", fetchFeedParams.f5788f.toString());
        }
        ((FetchRecentActivityParamBuilderUtil) this.f5990v.get()).m10421a(graphQlQueryString);
        this.f5991w.get();
        SocialSearchParamBuilderUtil.m11494a(graphQlQueryString);
        if (((VideoDashConfig) this.f5987s.get()).m11512a()) {
            graphQlQueryString.m11315a("scrubbing", "MPEG_DASH");
        } else if (((VideoDashConfig) this.f5987s.get()).m11515c()) {
            graphQlQueryString.m11315a("scrubbing", "WEBM_DASH");
        }
        this.f5972M.m10183a(graphQlQueryString, EntryPointInputVideoChannelEntryPoint.NEWSFEED);
    }

    public final TypedGraphQlQueryString<GraphQLViewer> m10097e(FetchFeedParams fetchFeedParams) {
        GraphQlQueryString newsFeedQueryDepth3DebugString;
        if (((DebugFeedConfig) this.f5981m.get()).m11300a()) {
            newsFeedQueryDepth3DebugString = new NewsFeedQueryDepth3DebugString();
        } else {
            newsFeedQueryDepth3DebugString = FetchNewsFeedGraphQL.m11301a();
        }
        newsFeedQueryDepth3DebugString.m11306b(true);
        m10078a(newsFeedQueryDepth3DebugString, fetchFeedParams);
        FetchFeedQueryUtil fetchFeedQueryUtil = (FetchFeedQueryUtil) this.f5977i.get();
        FetchFeedQueryUtil.m11404a(newsFeedQueryDepth3DebugString, (SystemBatteryStateManager) this.f5982n.get());
        FetchFeedQueryUtil.m11405a(newsFeedQueryDepth3DebugString, (FbDataConnectionManager) this.f5983o.get());
        FetchFeedQueryUtil.m11403a(newsFeedQueryDepth3DebugString, fetchFeedParams, "before_home_story_param", "after_home_story_param");
        if (((Boolean) this.f5967A.get()).booleanValue() && ((AppStateManager) fetchFeedQueryUtil.f6581e.get()).m2264l()) {
            ImmutableLocation a = ((FbLocationCache) fetchFeedQueryUtil.f6582f.get()).m8245a();
            if (a != null) {
                newsFeedQueryDepth3DebugString.m11314a("location_latitude", Double.valueOf(a.m11984a()));
                newsFeedQueryDepth3DebugString.m11314a("location_longitude", Double.valueOf(a.m11985b()));
                newsFeedQueryDepth3DebugString.m11314a("location_accuracy_meters", (Number) a.m11986c().get());
                newsFeedQueryDepth3DebugString.m11314a("location_age_seconds", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(((LocationAgeUtil) fetchFeedQueryUtil.f6583g.get()).m8269a(a))));
            }
        }
        newsFeedQueryDepth3DebugString.m11316a("recent_vpvs", (List) fetchFeedParams.f5791i).m11315a("client_query_id", fetchFeedParams.f5789g);
        return newsFeedQueryDepth3DebugString;
    }

    public final int mo1428b(Object obj, ApiResponse apiResponse) {
        return 2;
    }

    protected final String mo1430c() {
        return "fetch_news_feed";
    }

    public final void mo1425a(FetchFeedParams fetchFeedParams) {
        super.mo1425a(fetchFeedParams);
        ((FeedPerfLogger) this.f5984p.get()).m3348a(fetchFeedParams);
    }

    protected final String mo1431c(FetchFeedParams fetchFeedParams) {
        return m10075a(this.f5980l, fetchFeedParams).f1695d;
    }

    protected final int mo1432d(FetchFeedParams fetchFeedParams) {
        return m10075a(this.f5980l, fetchFeedParams).f1692a;
    }

    public final GraphQLBatchRequest mo1421a(FetchFeedParams fetchFeedParams, String str, FetcherCallback fetcherCallback) {
        FetchFeedParams q;
        String a;
        int[] iArr;
        int[] iArr2;
        GraphQLBatchRequest a2;
        Object obj = 1;
        ColdStartPrimingInformation coldStartPrimingInformation = ColdStartPrimingInformation.a;
        if (m10081f(fetchFeedParams) && coldStartPrimingInformation.e()) {
            Object obj2;
            Object obj3;
            FetchFeedParamsBuilder a3;
            String str2 = coldStartPrimingInformation.d;
            if (((Boolean) this.f5994z.get()).booleanValue()) {
                if (str2 != null && str2.contains("response_format=flatbuffer") && str2.contains("flatbuffer_schema_id=10154690582226729")) {
                    obj2 = 1;
                }
                obj2 = null;
            } else {
                if (!(str2 == null || str2.contains("response_format=flatbuffer"))) {
                    int i = 1;
                }
                obj2 = null;
            }
            if (obj2 != null) {
                if (this.f5976h.f5545b.equals(coldStartPrimingInformation.i)) {
                    obj3 = 1;
                    if (obj3 == null) {
                        a3 = new FetchFeedParamsBuilder().m9926a(fetchFeedParams);
                        a3.f5806h = coldStartPrimingInformation.k;
                        q = a3.m9930q();
                        a = this.f5973e.mo581a(ExperimentsForNewsFeedAbTestModule.f5087N, "");
                        if (this.f5970K.equals(a)) {
                            iArr = this.f5971L;
                        } else {
                            this.f5970K = a;
                            this.f5971L = m10079a(a);
                            iArr = this.f5971L;
                        }
                        iArr2 = iArr;
                        if (q.f5798p != FetchTypeForLogging.HEAD) {
                            obj = null;
                        }
                        if (iArr2 != null || obj == null) {
                            a2 = m10085a(q, str, fetcherCallback, obj != null ? this.f5993y.m8199n() : this.f5993y.m8201p(), obj != null ? this.f5993y.m8200o() - 1 : this.f5993y.m8202q() - 1);
                        } else {
                            a2 = m10073a(q, iArr2, str, fetcherCallback);
                        }
                        m10076a(q, a2);
                        return a2;
                    }
                    coldStartPrimingInformation.o = UDPPrimingStatus.ERROR_MISMATCH;
                }
            }
            obj3 = null;
            if (obj3 == null) {
                coldStartPrimingInformation.o = UDPPrimingStatus.ERROR_MISMATCH;
            } else {
                a3 = new FetchFeedParamsBuilder().m9926a(fetchFeedParams);
                a3.f5806h = coldStartPrimingInformation.k;
                q = a3.m9930q();
                a = this.f5973e.mo581a(ExperimentsForNewsFeedAbTestModule.f5087N, "");
                if (this.f5970K.equals(a)) {
                    this.f5970K = a;
                    this.f5971L = m10079a(a);
                    iArr = this.f5971L;
                } else {
                    iArr = this.f5971L;
                }
                iArr2 = iArr;
                if (q.f5798p != FetchTypeForLogging.HEAD) {
                    obj = null;
                }
                if (iArr2 != null) {
                }
                if (obj != null) {
                }
                if (obj != null) {
                }
                a2 = m10085a(q, str, fetcherCallback, obj != null ? this.f5993y.m8199n() : this.f5993y.m8201p(), obj != null ? this.f5993y.m8200o() - 1 : this.f5993y.m8202q() - 1);
                m10076a(q, a2);
                return a2;
            }
        }
        q = fetchFeedParams;
        a = this.f5973e.mo581a(ExperimentsForNewsFeedAbTestModule.f5087N, "");
        if (this.f5970K.equals(a)) {
            iArr = this.f5971L;
        } else {
            this.f5970K = a;
            this.f5971L = m10079a(a);
            iArr = this.f5971L;
        }
        iArr2 = iArr;
        if (q.f5798p != FetchTypeForLogging.HEAD) {
            obj = null;
        }
        if (iArr2 != null) {
        }
        if (obj != null) {
        }
        if (obj != null) {
        }
        a2 = m10085a(q, str, fetcherCallback, obj != null ? this.f5993y.m8199n() : this.f5993y.m8201p(), obj != null ? this.f5993y.m8200o() - 1 : this.f5993y.m8202q() - 1);
        m10076a(q, a2);
        return a2;
    }

    @Nullable
    public static int[] m10079a(String str) {
        try {
            String[] split = str.split("\\+");
            int length = split.length;
            if (length <= 0) {
                return null;
            }
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                iArr[i] = Integer.parseInt(split[i]);
            }
            return iArr;
        } catch (Exception e) {
            return null;
        }
    }

    public final GraphQLBatchRequest m10085a(FetchFeedParams fetchFeedParams, String str, FetcherCallback<GraphQLViewer> fetcherCallback, int i, int i2) {
        int i3;
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest(str);
        FetchFeedParamsBuilder a = new FetchFeedParamsBuilder().m9926a(fetchFeedParams);
        a.f5801c = i;
        FetchFeedParams q = a.m9930q();
        this.f5985q.m10160a(q, i + "x" + (i2 + 1));
        TypedGraphQlQueryString e = m10097e(q);
        e.m11323b("param", "after_home_story_param");
        e.m11323b("import", "end_cursor");
        e.m11321b("max_runs", Integer.valueOf(i2));
        String str2 = "storyset_first_fetch_size";
        FetchOffScreenAdsHelper fetchOffScreenAdsHelper = (FetchOffScreenAdsHelper) this.f5992x.get();
        FeedOffScreenAdsFetchXConfigReader feedOffScreenAdsFetchXConfigReader = fetchOffScreenAdsHelper.f7013a;
        if (!feedOffScreenAdsFetchXConfigReader.f7016b) {
            feedOffScreenAdsFetchXConfigReader.f7019e = feedOffScreenAdsFetchXConfigReader.f7015a.m2686a(FeedOffScreenAdsFetchXConfig.f7025e, false);
            feedOffScreenAdsFetchXConfigReader.f7016b = true;
        }
        if (feedOffScreenAdsFetchXConfigReader.f7019e) {
            feedOffScreenAdsFetchXConfigReader = fetchOffScreenAdsHelper.f7013a;
            if (feedOffScreenAdsFetchXConfigReader.f7020f == -1) {
                feedOffScreenAdsFetchXConfigReader.f7020f = feedOffScreenAdsFetchXConfigReader.f7015a.m2683a(FeedOffScreenAdsFetchXConfig.f7026f, feedOffScreenAdsFetchXConfigReader.m11577a());
            }
            i3 = feedOffScreenAdsFetchXConfigReader.f7020f;
        } else {
            i3 = fetchOffScreenAdsHelper.f7013a.m11577a();
        }
        e.m11314a(str2, Integer.valueOf(i3));
        e.m11314a("pyml_first_fetch_size", Integer.valueOf(((FetchOffScreenAdsHelper) this.f5992x.get()).m11574b()));
        GraphQLRequest a2 = GraphQLRequest.m11587a(e).m11594a(GraphQLCachePolicy.f7111c);
        a2.f7084b = false;
        GraphQLRequest graphQLRequest = a2;
        graphQLBatchRequest.m11217a(graphQLRequest).m11649a(fetcherCallback.mo1593a("feed_subscriber"));
        graphQLBatchRequest.f6476g = ((Boolean) this.f5994z.get()).booleanValue();
        m10109a(graphQLBatchRequest, graphQLRequest, (FetcherCallback) fetcherCallback);
        return graphQLBatchRequest;
    }

    private GraphQLBatchRequest m10073a(FetchFeedParams fetchFeedParams, int[] iArr, String str, FetcherCallback fetcherCallback) {
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest(str + "_batch");
        int i = iArr[0];
        FetchFeedParamsBuilder a = new FetchFeedParamsBuilder().m9926a(fetchFeedParams);
        a.f5801c = i;
        FetchFeedParams q = a.m9930q();
        this.f5985q.m10160a(q, this.f5970K);
        GraphQLRequest a2 = GraphQLRequest.m11587a(m10097e(q));
        graphQLBatchRequest.m11217a(a2).m11649a(fetcherCallback.mo1593a("feed_subscriber"));
        m10109a(graphQLBatchRequest, a2, fetcherCallback);
        for (i = 1; i < iArr.length; i++) {
            int i2 = iArr[i];
            FetchFeedParamsBuilder a3 = new FetchFeedParamsBuilder().m9926a(fetchFeedParams);
            a3.f5801c = i2;
            GraphQlQueryString e = m10097e(a3.m9930q());
            e.m11311a("after_home_story_param", a2.m11599a("end_cursor", BatchQueryFanOutStyle.FIRST, FallbackStyle.SKIP));
            a2 = GraphQLRequest.m11585a(e, GraphQLViewer.class);
            graphQLBatchRequest.m11217a(a2).m11649a(fetcherCallback.mo1593a("feed_subscriber"));
            m10109a(graphQLBatchRequest, a2, fetcherCallback);
        }
        graphQLBatchRequest.f6476g = ((Boolean) this.f5994z.get()).booleanValue();
        return graphQLBatchRequest;
    }

    private GraphQLFeedHomeStories m10074a(GraphQLViewer graphQLViewer, boolean z) {
        ImmutableList a;
        boolean z2;
        String str;
        GraphQLPageInfo j;
        if (z) {
            if (graphQLViewer.m11359q() == null) {
                return null;
            }
            a = graphQLViewer.m11359q().a();
            z2 = false;
            str = null;
            j = graphQLViewer.m11359q().j();
        } else if (graphQLViewer.m11333A() == null) {
            return null;
        } else {
            ImmutableList j2 = graphQLViewer.m11333A().m22216j();
            boolean k = graphQLViewer.m11333A().m22217k();
            GraphQLPageInfo l = graphQLViewer.m11333A().m22218l();
            if (l == null) {
                l = new GraphQLPageInfo();
            }
            a = j2;
            z2 = k;
            str = graphQLViewer.m11333A().m22214a();
            j = l;
        }
        Builder builder = new Builder();
        long a2 = this.f5996d.mo211a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            FeedUnit feedUnit;
            NewsFeedEdge newsFeedEdge = (NewsFeedEdge) a.get(i);
            FeedUnitCommon o = newsFeedEdge.mo2865o();
            if (o != null) {
                FetchTimeMsHelper.m22314a(o, a2);
                if (o.w_() != null) {
                    MutableFlatBuffer w_ = o.w_();
                    if (w_.m21541b(4) != Boolean.valueOf(true)) {
                        w_.m21535a(w_.m21560g(((MutableFlattenable) newsFeedEdge).u_(), 6));
                    }
                    feedUnit = o;
                } else {
                    feedUnit = (FeedUnit) GraphQLModelFlatbufferHelper.a(newsFeedEdge.mo2865o());
                }
            } else {
                FeedUnitCommon feedUnitCommon = o;
            }
            builder.m1069c(new GraphQLFeedUnitEdge.Builder().m22412a(feedUnit).m22416b(newsFeedEdge.mo2862k()).m22418d(newsFeedEdge.mo2867q()).m22413a(newsFeedEdge.mo2861j()).m22410a(newsFeedEdge.mo2866p()).m22411a(newsFeedEdge.mo2860a()).m22417c(newsFeedEdge.mo2864m()).m22414a(newsFeedEdge.mo2863l()).m22415a());
        }
        return new GraphQLFeedHomeStories.Builder().m22421a(builder.m1068b()).m22420a(j).m22423a(z2).m22422a(str).m22424a();
    }

    private boolean m10081f(FetchFeedParams fetchFeedParams) {
        if (!((DebugFeedConfig) this.f5981m.get()).m11300a() && FeedType.f5039b.equals(fetchFeedParams.f5784b) && FetchTypeForLogging.HEAD == fetchFeedParams.f5798p) {
            return true;
        }
        return false;
    }

    private void m10076a(FetchFeedParams fetchFeedParams, GraphQLBatchRequest graphQLBatchRequest) {
        if (m10081f(fetchFeedParams)) {
            graphQLBatchRequest.f6478i = true;
            if (this.f5976h.m9454c()) {
                User user = (User) this.f5978j.get();
                if (user != null) {
                    String str = user.f3598a;
                    String g = m10082g(fetchFeedParams);
                    UDPPrimingHelper uDPPrimingHelper = this.f5976h;
                    if (!(g == null || str == null)) {
                        ExecutorDetour.a(uDPPrimingHelper.f5546c, new 2(uDPPrimingHelper, g, str), 751622984);
                    }
                }
            }
            ColdStartPrimingInformation coldStartPrimingInformation = ColdStartPrimingInformation.a;
            UDPPrimingStatus uDPPrimingStatus = coldStartPrimingInformation.o;
            if (uDPPrimingStatus != UDPPrimingStatus.NONE) {
                this.f5985q.m10158a(fetchFeedParams, uDPPrimingStatus);
                if (coldStartPrimingInformation.e()) {
                    graphQLBatchRequest.f6477h = true;
                }
                coldStartPrimingInformation.o = UDPPrimingStatus.NONE;
            }
        }
    }

    private String m10082g(FetchFeedParams fetchFeedParams) {
        int o = this.f5993y.m8200o() - 1;
        FetchFeedParams q = new FetchFeedParamsBuilder().m9926a(fetchFeedParams).m9923a(this.f5993y.m8199n()).m9930q();
        GraphQlQueryString a = FetchNewsFeedGraphQL.m11301a();
        m10078a(a, q);
        a.m11315a("before_home_story_param", "CURSOR_BOOKMARK").m11315a("client_query_id", "CLIENT_QUERY_ID_BOOKMARK");
        GraphQlQueryParamSet j = a.m11330j();
        ParamsCollection b = j.m11369a().m5398b();
        b.m5438a(ParamsJsonEncoder.m5454a());
        b.m5421a("param", "after_home_story_param");
        b.m5421a("import", "end_cursor");
        b.m5420a("max_runs", Integer.valueOf(o));
        ParamsCollection b2 = j.m11369a().m5398b();
        b2.m5438a(ParamsJsonEncoder.m5454a());
        b2.m5421a("query_id", a.m11327f());
        b2.m5418a("query_params", j.m11383d());
        b2.m5418a("rerun_param", b);
        b = j.m11369a().m5398b();
        b.m5438a(ParamsJsonEncoder.m5454a());
        b.m5418a(a.m11324c(), b2);
        b2 = j.m11369a().m5398b();
        b2.m5418a("queries", b);
        b2.m5421a("client_query_id", "CLIENT_QUERY_ID_BOOKMARK");
        b2.m5421a("batch_name", "udp");
        if (((Boolean) this.f5994z.get()).booleanValue()) {
            for (BasicNameValuePair basicNameValuePair : GraphQLProtocolHelper.f5533a) {
                b2.m5421a(basicNameValuePair.getName(), basicNameValuePair.getValue());
            }
        }
        try {
            Writer stringWriter = new StringWriter();
            ParamsFormEncoder.m18192a().mo746a(stringWriter, b2);
            return stringWriter.toString();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
