package com.facebook.feed.protocol;

import android.content.Context;
import android.content.res.AssetManager;
import com.facebook.accessibility.AutomaticPhotoCaptioningUtils;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParams.FetchTypeForLogging;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.FetchFeedType;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.api.ufiservices.qe.ExperimentsForUfiServiceQeModule;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.hardware.BatteryStateManager;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.feed.DebugFeedConfig;
import com.facebook.debug.pref.DebugLoggingPrefKeys;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ErrorCodeUtil;
import com.facebook.feed.bugreporter.FeedLoadingDebugInfo;
import com.facebook.feed.perf.FeedPerfLogger;
import com.facebook.feed.protocol.FetchNewsFeedGraphQL.NewsFeedQueryDepth3String;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.BatchMethodNotExecutedException;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.StartupPerfLogger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.user.model.User;
import com.facebook.video.abtest.VideoDashConfig;
import com.fasterxml.jackson.core.JsonParser;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mobile_pages_manager_tagger */
public class FetchNewsFeedStreamingMethod extends FetchFeedMethod {
    private final GraphQLStoryHelper f10302e;
    private final GraphQLImageHelper f10303f;
    private final FetchFeedQueryUtil f10304g;
    private final Provider<User> f10305h;
    public final FeedLoadingDebugInfo f10306i;
    private final PerformanceLogger f10307j;
    private final DebugFeedConfig f10308k;
    private final SystemBatteryStateManager f10309l;
    private final FbDataConnectionManager f10310m;
    private final FeedPerfLogger f10311n;
    private final FeedReliabilityLogger f10312o;
    private final UniqueIdForDeviceHolderImpl f10313p;
    private final Provider<VideoDashConfig> f10314q;
    public final FbSharedPreferences f10315r;
    private final AssetManager f10316s;
    private final QeAccessor f10317t;
    private final AutomaticPhotoCaptioningUtils f10318u;

    /* compiled from: mobile_pages_manager_tagger */
    /* synthetic */ class C06201 {
        static final /* synthetic */ int[] f10301a = new int[FetchFeedType.values().length];

        static {
            try {
                f10301a[FetchFeedType.LATEST_N_STORIES.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10301a[FetchFeedType.LATEST_N_STORIES_BEFORE_A_CURSOR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10301a[FetchFeedType.LATEST_N_STORIES_AFTER_A_CURSOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10301a[FetchFeedType.N_STORIES_BETWEEN_CURSORS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private static FetchNewsFeedStreamingMethod m16250b(InjectorLike injectorLike) {
        return new FetchNewsFeedStreamingMethod(GraphQLStoryHelper.a(injectorLike), GraphQLImageHelper.a(injectorLike), FetchFeedQueryUtil.a(injectorLike), SystemBatteryStateManager.a(injectorLike), FbDataConnectionManager.a(injectorLike), UniqueIdForDeviceHolderMethodAutoProvider.a(injectorLike), GraphQLProtocolHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3595), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), FeedLoadingDebugInfo.m15821a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), StartupPerfLogger.a(injectorLike), DebugFeedConfig.a(injectorLike), FeedReliabilityLogger.a(injectorLike), FeedPerfLogger.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 3635), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class, ForAppContext.class), AutomaticPhotoCaptioningUtils.a(injectorLike), FetchFeedbackMethod.a(injectorLike));
    }

    public final Object m16252a(@Nullable Object obj, ApiResponse apiResponse) {
        FetchFeedParams fetchFeedParams = (FetchFeedParams) obj;
        try {
            return (FetchFeedResult) super.a(fetchFeedParams, apiResponse);
        } catch (Exception e) {
            this.f10312o.a(fetchFeedParams, apiResponse.g(), e);
            throw e;
        }
    }

    public final /* synthetic */ void m16258b(Object obj) {
        a((FetchFeedParams) obj);
    }

    public final GraphQlQueryString m16262f(Object obj) {
        String str;
        FetchFeedParams fetchFeedParams = (FetchFeedParams) obj;
        NewsFeedQueryDepth3String a = FetchNewsFeedGraphQL.a();
        a.a(true);
        String str2 = "PRODUCTION";
        User user = (User) this.f10305h.get();
        if (user != null && user.o) {
            boolean z = false;
            if (this.f10315r.a() && this.f10315r.a(DebugLoggingPrefKeys.g, false)) {
                z = true;
            }
            if (!z) {
                str = "DEBUG";
                this.f10304g.a(a);
                FetchFeedQueryUtil.a(a, this.f10309l);
                this.f10304g.e(a);
                FetchFeedQueryUtil.a(a, this.f10310m);
                FetchFeedQueryUtil.a(a, this.f10313p);
                this.f10304g.b(a);
                FetchFeedQueryUtil.a(a, fetchFeedParams, "before_home_story_param", "after_home_story_param");
                this.f10304g.a(a, fetchFeedParams, "cached_stories_range");
                this.f10304g.c(a);
                FetchFeedQueryUtil.d(a);
                a.a("creative_low_img_size", this.f10302e.A()).a("creative_med_img_size", this.f10302e.B()).a("creative_high_img_size", this.f10302e.C()).a("pymk_size_param", this.f10302e.g()).a("saved_item_pic_width", this.f10302e.i()).a("saved_item_pic_height", this.f10302e.j()).a("pyml_size_param", this.f10302e.k()).a("profile_pic_swipe_size_param", this.f10302e.l()).a("gysj_size_param", this.f10302e.m()).a("gysj_facepile_size_param", GraphQLImageHelper.a(this.f10302e.e.getDimensionPixelSize(2131428883))).a("gysj_facepile_count_param", Integer.valueOf(4)).a("celebrations_profile_pic_size_param", GraphQLStoryHelper.q()).a("multi_share_item_image_size_param", this.f10302e.u()).a("friends_locations_profile_pic_size_param", this.f10302e.H()).a("quick_promotion_image_size_param", this.f10302e.I()).a("quick_promotion_large_image_size_param", this.f10302e.J()).a("first_home_story_param", Integer.valueOf(fetchFeedParams.c)).a("discovery_image_size", this.f10302e.m()).a("debug_mode", str).a("ad_media_type", this.f10303f.a()).a("num_faceboxes_and_tags", this.f10302e.b).a("include_replies_in_total_count", Boolean.toString(this.f10317t.a(ExperimentsForUfiServiceQeModule.l, false))).a("client_query_id", fetchFeedParams.g).a("greeting_card_image_size_large", this.f10303f.f()).a("greeting_card_image_size_medium", this.f10303f.g()).a("num_media_question_options", Integer.valueOf(15)).a("media_question_photo_size", this.f10303f.f()).a("recent_vpvs", fetchFeedParams.i).a("enable_hd", Boolean.toString(true)).a("automatic_photo_captioning_enabled", Boolean.toString(this.f10318u.a()));
                if (((VideoDashConfig) this.f10314q.get()).a()) {
                    a.a("scrubbing", "MPEG_DASH");
                } else if (((VideoDashConfig) this.f10314q.get()).c()) {
                    a.a("scrubbing", "WEBM_DASH");
                }
                if (fetchFeedParams.b.g.equals(Name.h)) {
                    a.a("orderby_home_story_param", fetchFeedParams.b.a());
                } else {
                    a.a("orderby_home_story_param", FeedType.b.a());
                }
                if (fetchFeedParams.e == null) {
                    a.a("refresh_mode_param", fetchFeedParams.f.toString());
                }
                return a;
            }
        }
        str = str2;
        this.f10304g.a(a);
        FetchFeedQueryUtil.a(a, this.f10309l);
        this.f10304g.e(a);
        FetchFeedQueryUtil.a(a, this.f10310m);
        FetchFeedQueryUtil.a(a, this.f10313p);
        this.f10304g.b(a);
        FetchFeedQueryUtil.a(a, fetchFeedParams, "before_home_story_param", "after_home_story_param");
        this.f10304g.a(a, fetchFeedParams, "cached_stories_range");
        this.f10304g.c(a);
        FetchFeedQueryUtil.d(a);
        a.a("creative_low_img_size", this.f10302e.A()).a("creative_med_img_size", this.f10302e.B()).a("creative_high_img_size", this.f10302e.C()).a("pymk_size_param", this.f10302e.g()).a("saved_item_pic_width", this.f10302e.i()).a("saved_item_pic_height", this.f10302e.j()).a("pyml_size_param", this.f10302e.k()).a("profile_pic_swipe_size_param", this.f10302e.l()).a("gysj_size_param", this.f10302e.m()).a("gysj_facepile_size_param", GraphQLImageHelper.a(this.f10302e.e.getDimensionPixelSize(2131428883))).a("gysj_facepile_count_param", Integer.valueOf(4)).a("celebrations_profile_pic_size_param", GraphQLStoryHelper.q()).a("multi_share_item_image_size_param", this.f10302e.u()).a("friends_locations_profile_pic_size_param", this.f10302e.H()).a("quick_promotion_image_size_param", this.f10302e.I()).a("quick_promotion_large_image_size_param", this.f10302e.J()).a("first_home_story_param", Integer.valueOf(fetchFeedParams.c)).a("discovery_image_size", this.f10302e.m()).a("debug_mode", str).a("ad_media_type", this.f10303f.a()).a("num_faceboxes_and_tags", this.f10302e.b).a("include_replies_in_total_count", Boolean.toString(this.f10317t.a(ExperimentsForUfiServiceQeModule.l, false))).a("client_query_id", fetchFeedParams.g).a("greeting_card_image_size_large", this.f10303f.f()).a("greeting_card_image_size_medium", this.f10303f.g()).a("num_media_question_options", Integer.valueOf(15)).a("media_question_photo_size", this.f10303f.f()).a("recent_vpvs", fetchFeedParams.i).a("enable_hd", Boolean.toString(true)).a("automatic_photo_captioning_enabled", Boolean.toString(this.f10318u.a()));
        if (((VideoDashConfig) this.f10314q.get()).a()) {
            a.a("scrubbing", "MPEG_DASH");
        } else if (((VideoDashConfig) this.f10314q.get()).c()) {
            a.a("scrubbing", "WEBM_DASH");
        }
        if (fetchFeedParams.b.g.equals(Name.h)) {
            a.a("orderby_home_story_param", fetchFeedParams.b.a());
        } else {
            a.a("orderby_home_story_param", FeedType.b.a());
        }
        if (fetchFeedParams.e == null) {
            a.a("refresh_mode_param", fetchFeedParams.f.toString());
        }
        return a;
    }

    @Inject
    public FetchNewsFeedStreamingMethod(GraphQLStoryHelper graphQLStoryHelper, GraphQLImageHelper graphQLImageHelper, FetchFeedQueryUtil fetchFeedQueryUtil, BatteryStateManager batteryStateManager, FbDataConnectionManager fbDataConnectionManager, UniqueIdForDeviceHolder uniqueIdForDeviceHolder, GraphQLProtocolHelper graphQLProtocolHelper, FbErrorReporter fbErrorReporter, Clock clock, Provider<User> provider, PerformanceLogger performanceLogger, FeedLoadingDebugInfo feedLoadingDebugInfo, MonotonicClock monotonicClock, StartupPerfLogger startupPerfLogger, DebugFeedConfig debugFeedConfig, FeedReliabilityLogger feedReliabilityLogger, FeedPerfLogger feedPerfLogger, Provider<VideoDashConfig> provider2, FbSharedPreferences fbSharedPreferences, QeAccessor qeAccessor, @ForAppContext Context context, AutomaticPhotoCaptioningUtils automaticPhotoCaptioningUtils, FetchFeedbackMethod fetchFeedbackMethod) {
        super(graphQLProtocolHelper, fbErrorReporter, startupPerfLogger, clock, monotonicClock, qeAccessor, fetchFeedbackMethod);
        this.f10302e = graphQLStoryHelper;
        this.f10303f = graphQLImageHelper;
        this.f10304g = fetchFeedQueryUtil;
        this.f10309l = batteryStateManager;
        this.f10313p = uniqueIdForDeviceHolder;
        this.f10310m = fbDataConnectionManager;
        this.f10305h = provider;
        this.f10306i = feedLoadingDebugInfo;
        this.f10307j = performanceLogger;
        this.f10308k = debugFeedConfig;
        this.f10312o = feedReliabilityLogger;
        this.f10314q = provider2;
        this.f10311n = feedPerfLogger;
        this.f10315r = fbSharedPreferences;
        this.f10316s = context.getAssets();
        this.f10317t = qeAccessor;
        this.f10318u = automaticPhotoCaptioningUtils;
    }

    public final FetchFeedResult m16251a(FetchFeedParams fetchFeedParams, ApiResponse apiResponse, JsonParser jsonParser) {
        FetchFeedResult a = super.a(fetchFeedParams, apiResponse, jsonParser);
        switch (C06201.f10301a[FetchFeedType.getQueryType(fetchFeedParams).ordinal()]) {
            case 1:
                m16249a(a);
                break;
            case 2:
                m16249a(a);
                break;
            case 3:
                break;
        }
        if (a.d().isEmpty()) {
            this.f10306i.m15827d(a);
        } else {
            this.f10306i.m15826c(a);
        }
        return a;
    }

    public final void m16255a(FetchFeedParams fetchFeedParams, Exception exception) {
        super.a(fetchFeedParams, exception);
        ErrorCode a = ErrorCodeUtil.a(exception);
        if (a == ErrorCode.API_ERROR || a == ErrorCode.HTTP_500_CLASS) {
            if (!(exception instanceof BatchMethodNotExecutedException)) {
                this.f10312o.b(fetchFeedParams, exception);
            } else if (fetchFeedParams.p == FetchTypeForLogging.CHUNKED_REMAINDER) {
                this.f10312o.a(fetchFeedParams);
            }
        } else if (a == ErrorCode.CONNECTION_FAILURE) {
            this.f10312o.a(fetchFeedParams, exception);
        } else {
            this.f10312o.c(fetchFeedParams, exception);
        }
    }

    private void m16249a(FetchFeedResult fetchFeedResult) {
        if (fetchFeedResult.d().isEmpty()) {
            this.f10306i.m15825b(fetchFeedResult);
        } else {
            this.f10306i.m15824a(fetchFeedResult);
        }
    }

    public final int m16257b(Object obj, ApiResponse apiResponse) {
        return 2;
    }

    protected final String m16259c() {
        return "fetch_news_feed_streaming";
    }

    public final void m16254a(FetchFeedParams fetchFeedParams) {
        super.a(fetchFeedParams);
        this.f10311n.a(fetchFeedParams);
    }

    protected final String m16260c(FetchFeedParams fetchFeedParams) {
        return FetchNewsFeedMethod.a(this.f10307j, fetchFeedParams).d;
    }

    protected final int m16261d(FetchFeedParams fetchFeedParams) {
        return FetchNewsFeedMethod.a(this.f10307j, fetchFeedParams).a;
    }
}
