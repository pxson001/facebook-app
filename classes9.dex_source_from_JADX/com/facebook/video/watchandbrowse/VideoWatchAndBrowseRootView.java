package com.facebook.video.watchandbrowse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.browser.lite.BrowserLiteFragment;
import com.facebook.browser.lite.BrowserLiteFragment.BrowserFragmentListener;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.ui.fullscreenvideoplayer.InlineToFullscreenVideoTransitionManager;
import com.facebook.feed.ui.fullscreenvideoplayer.InlineToFullscreenVideoTransitionManager.FullscreenType;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.imageloader.FeedImageLoader.FeedImageType;
import com.facebook.feed.video.FeedFullScreenParams;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.linkutil.LinkExtractorConverter;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.links.AttachmentLinkInspector;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.si.LinkshimExternalIntentHandler;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.browser.lite.BrowserLiteIntentHandler;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.feed.FeedVideoPlayerParamBuilderProvider;
import com.facebook.video.player.FullScreenVideoListener;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.VideoTransitionNode;
import com.facebook.video.watchandshop.WatchAndShopHeaderView;
import com.facebook.video.watchandshop.WatchAndShopProductItemPagerController;
import com.facebook.widget.CustomRelativeLayout;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap.Builder;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: should_show_to_seller */
public class VideoWatchAndBrowseRootView<E extends HasFeedListType & HasPersistentState & HasContext> extends CustomRelativeLayout implements ImmersiveVideoPlayer {
    @Inject
    private VideoLoggingUtils f3397A;
    @Inject
    private BrowserLiteIntentHandler f3398B;
    @Inject
    private RapidFeedbackController f3399C;
    @Inject
    public VideoWatchAndBrowseFullScreenManager f3400D;
    @Inject
    public WatchAndShopProductItemPagerController f3401E;
    public final AudioManager f3402a;
    private final Handler f3403b;
    public FullScreenVideoListener f3404c;
    private boolean f3405d;
    private RichVideoPlayer f3406e;
    public WatchAndBrowseVideoPlayer f3407f;
    private Window f3408g;
    @Nullable
    public ViewGroup f3409h;
    private PlayerOrigin f3410i;
    private EventTriggerType f3411j;
    private RichVideoPlayerParams f3412k;
    private FeedProps<GraphQLStory> f3413l;
    public BrowserLiteFragment f3414m;
    private WatchAndBrowseFullScreenVideoPlayer f3415n;
    private WatchAndMoreType f3416o;
    private C03121 f3417p;
    public LinearLayout f3418q;
    @Inject
    private InlineToFullscreenVideoTransitionManager f3419r;
    @Inject
    private FeedVideoPlayerParamBuilderProvider f3420s;
    @Inject
    private FeedImageLoader f3421t;
    @Inject
    private GraphQLLinkExtractor f3422u;
    @Inject
    private AttachmentLinkInspector f3423v;
    @Inject
    private CommonEventsBuilder f3424w;
    @Inject
    private AnalyticsLogger f3425x;
    @Inject
    private UriIntentMapper f3426y;
    @Inject
    private LinkshimExternalIntentHandler f3427z;

    /* compiled from: should_show_to_seller */
    public class C03121 {
        public final /* synthetic */ VideoWatchAndBrowseRootView f3392a;

        C03121(VideoWatchAndBrowseRootView videoWatchAndBrowseRootView) {
            this.f3392a = videoWatchAndBrowseRootView;
        }
    }

    /* compiled from: should_show_to_seller */
    class C03132 implements BrowserFragmentListener {
        final /* synthetic */ VideoWatchAndBrowseRootView f3393a;

        C03132(VideoWatchAndBrowseRootView videoWatchAndBrowseRootView) {
            this.f3393a = videoWatchAndBrowseRootView;
        }

        public final void m3219a(int i) {
            VideoWatchAndBrowseRootView.m3230h(this.f3393a);
        }
    }

    /* compiled from: should_show_to_seller */
    class C03143 implements Function<RichVideoPlayerParams, Void> {
        final /* synthetic */ VideoWatchAndBrowseRootView f3394a;

        C03143(VideoWatchAndBrowseRootView videoWatchAndBrowseRootView) {
            this.f3394a = videoWatchAndBrowseRootView;
        }

        public Object apply(@Nullable Object obj) {
            this.f3394a.f3400D.m3209c();
            return null;
        }
    }

    /* compiled from: should_show_to_seller */
    class C03154 implements Runnable {
        final /* synthetic */ VideoWatchAndBrowseRootView f3395a;

        C03154(VideoWatchAndBrowseRootView videoWatchAndBrowseRootView) {
            this.f3395a = videoWatchAndBrowseRootView;
        }

        public void run() {
            VideoWatchAndBrowseRootView.m3236o(this.f3395a);
        }
    }

    public static void m3227a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((VideoWatchAndBrowseRootView) obj).m3224a(InlineToFullscreenVideoTransitionManager.b(injectorLike), (FeedVideoPlayerParamBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedVideoPlayerParamBuilderProvider.class), FeedImageLoader.a(injectorLike), GraphQLLinkExtractor.a(injectorLike), AttachmentLinkInspector.a(injectorLike), CommonEventsBuilder.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), LinkshimExternalIntentHandler.b(injectorLike), VideoLoggingUtils.a(injectorLike), BrowserLiteIntentHandler.m1616b(injectorLike), RapidFeedbackController.b(injectorLike), VideoWatchAndBrowseFullScreenManager.m3201a(injectorLike), WatchAndShopProductItemPagerController.m3265a(injectorLike));
    }

    private RichVideoPlayerParams m3220a(FeedProps<GraphQLStory> feedProps) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) feedProps.a);
        FeedProps a = feedProps.a(o);
        GraphQLVideo b = GraphQLMediaConversionHelper.b(o.r());
        VideoPlayerParams a2 = this.f3420s.a(a, b).a();
        ImageRequest a3 = this.f3421t.a(o.r(), FeedImageType.Video);
        int bw = b.bw();
        int I = b.I();
        Double valueOf = Double.valueOf(I != 0 ? (1.0d * ((double) bw)) / ((double) I) : 0.0d);
        Builder builder = new Builder();
        builder.b("GraphQLStoryProps", feedProps).b("CoverImageParamsKey", a3).b("VideoAspectRatioKey", valueOf);
        RichVideoPlayerParams.Builder builder2 = new RichVideoPlayerParams.Builder();
        builder2.a = a2;
        return builder2.a(builder.b()).b();
    }

    private void m3223a(LinearLayout linearLayout, FeedProps<GraphQLStory> feedProps, E e) {
        GraphQLStoryActionLink e2 = StoryActionLinkHelper.e((GraphQLStory) feedProps.a);
        if (e2 != null) {
            Object obj;
            if (e2.aS() == null && e2.aR() == null) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                WatchAndShopHeaderView watchAndShopHeaderView = new WatchAndShopHeaderView(((HasContext) e).getContext());
                if (e2.aR() != null) {
                    watchAndShopHeaderView.setBackgroundColor(Color.parseColor("#" + e2.aR()));
                }
                if (e2.aS() != null) {
                    watchAndShopHeaderView.f3445b.a(Uri.parse(e2.aS()), WatchAndShopHeaderView.f3444a);
                }
                this.f3418q.addView(watchAndShopHeaderView, 0);
            }
            ((TextView) linearLayout.findViewById(2131568513)).setText(e2.V());
            this.f3401E.f3453d = linearLayout;
            this.f3401E.m3267a(this.f3413l, e);
        }
    }

    public VideoWatchAndBrowseRootView(Context context) {
        this(context, null);
    }

    private VideoWatchAndBrowseRootView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private VideoWatchAndBrowseRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3405d = false;
        Class cls = VideoWatchAndBrowseRootView.class;
        m3227a((Object) this, getContext());
        View.inflate(context, 2130907707, this);
        this.f3402a = (AudioManager) context.getSystemService("audio");
        this.f3407f = new WatchAndBrowseVideoPlayer(getContext());
        this.f3407f.setLayoutParams(new LayoutParams(-1, -2));
        this.f3408g = getContext() instanceof Activity ? ((Activity) getContext()).getWindow() : null;
        this.f3403b = new Handler(Looper.getMainLooper());
        this.f3415n = (WatchAndBrowseFullScreenVideoPlayer) a(2131560289);
        this.f3418q = (LinearLayout) a(2131568412);
    }

    public final boolean m3243a() {
        return this.f3405d;
    }

    public final boolean m3244b() {
        if (!m3243a()) {
            return false;
        }
        if (!this.f3400D.m3208a()) {
            switch (this.f3416o) {
                case WATCH_AND_BROWSE:
                    m3230h(this);
                    break;
                case WATCH_AND_SHOP:
                    m3231i();
                    break;
            }
        }
        return true;
    }

    public final void u_(int i) {
    }

    public final void m3245c() {
        m3232j();
    }

    public final void m3246d() {
        if (this.f3406e != null && this.f3406e.h() && !this.f3406e.m()) {
            this.f3406e.a(EventTriggerType.BY_FLYOUT, this.f3406e.getLastStartPosition());
        }
    }

    public final void m3247e() {
        if (this.f3406e != null && this.f3406e.h()) {
            this.f3406e.b(EventTriggerType.BY_USER);
        }
    }

    public final void m3248f() {
        m3233k();
    }

    public void setLogExitingPauseEvent(boolean z) {
    }

    public void setLogEnteringStartEvent(boolean z) {
    }

    public FullScreenVideoListener getFullScreenListener() {
        return this.f3404c;
    }

    public final /* synthetic */ Object m3239a(FullScreenVideoListener fullScreenVideoListener) {
        this.f3404c = fullScreenVideoListener;
        return this;
    }

    public final boolean m3249g() {
        return (this.f3402a.getStreamVolume(3) * 100) / this.f3402a.getStreamMaxVolume(3) <= 0;
    }

    public final void m3242a(FeedFullScreenParams feedFullScreenParams) {
    }

    public void setAllowLooping(boolean z) {
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3234l();
        if (configuration.orientation == 1) {
            setupBrowserLiteFragment(m3221a(StoryAttachmentHelper.o((GraphQLStory) this.f3413l.a)));
        }
        this.f3400D.m3207a(configuration.orientation);
    }

    public final void m3240a(FeedProps<GraphQLStory> feedProps, VideoTransitionNode videoTransitionNode, int i, int i2, PlayerOrigin playerOrigin, EventTriggerType eventTriggerType) {
        if (feedProps != null && feedProps.a != null && videoTransitionNode != null) {
            this.f3416o = WatchAndMoreType.WATCH_AND_BROWSE;
            this.f3410i = playerOrigin;
            this.f3411j = eventTriggerType;
            this.f3412k = m3220a((FeedProps) feedProps);
            this.f3413l = feedProps;
            this.f3405d = true;
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.setMargins(0, (int) getResources().getDimension(2131430957), 0, 0);
            this.f3407f.setLayoutParams(layoutParams);
            ((FrameLayout) a(2131568411)).addView(this.f3407f, 1);
            m3232j();
            m3235n();
            this.f3417p = new C03121(this);
            m3226a(videoTransitionNode, i2, playerOrigin, eventTriggerType);
            m3234l();
            String a = m3221a(StoryAttachmentHelper.o((GraphQLStory) this.f3413l.a));
            setupBrowserLiteFragment(a);
            m3228a(a);
            m3222a(i, i2);
            Configuration configuration = getResources().getConfiguration();
            if (configuration.orientation == 2) {
                onConfigurationChanged(configuration);
            }
        }
    }

    public static void m3230h(VideoWatchAndBrowseRootView videoWatchAndBrowseRootView) {
        ExitFullScreenResult q = videoWatchAndBrowseRootView.m3238q();
        videoWatchAndBrowseRootView.m3229b(q);
        videoWatchAndBrowseRootView.m3234l();
        videoWatchAndBrowseRootView.f3417p = null;
        videoWatchAndBrowseRootView.m3225a(q);
        videoWatchAndBrowseRootView.m3237p();
        videoWatchAndBrowseRootView.m3233k();
        ((FrameLayout) videoWatchAndBrowseRootView.a(2131568411)).removeView(videoWatchAndBrowseRootView.f3407f);
        videoWatchAndBrowseRootView.f3405d = false;
        videoWatchAndBrowseRootView.f3399C.a("770855376380968", videoWatchAndBrowseRootView.getContext());
    }

    public final void m3241a(FeedProps<GraphQLStory> feedProps, VideoTransitionNode videoTransitionNode, int i, int i2, PlayerOrigin playerOrigin, EventTriggerType eventTriggerType, E e) {
        if (feedProps != null && feedProps.a != null && videoTransitionNode != null) {
            this.f3416o = WatchAndMoreType.WATCH_AND_SHOP;
            this.f3410i = playerOrigin;
            this.f3411j = eventTriggerType;
            this.f3412k = m3220a((FeedProps) feedProps);
            this.f3413l = feedProps;
            this.f3405d = true;
            this.f3418q.addView(this.f3407f);
            LinearLayout linearLayout = (LinearLayout) ((Activity) getContext()).getLayoutInflater().inflate(2130907766, this.f3418q, true);
            m3232j();
            m3235n();
            m3226a(videoTransitionNode, i2, playerOrigin, eventTriggerType);
            m3223a(linearLayout, feedProps, e);
            m3222a(i, i2);
            Configuration configuration = getResources().getConfiguration();
            if (configuration.orientation == 2) {
                onConfigurationChanged(configuration);
            }
        }
    }

    private void m3231i() {
        ExitFullScreenResult q = m3238q();
        m3229b(q);
        m3225a(q);
        WatchAndShopProductItemPagerController watchAndShopProductItemPagerController = this.f3401E;
        PersistentRecyclerPartDefinition.a(watchAndShopProductItemPagerController.f3454e);
        watchAndShopProductItemPagerController.f3453d = null;
        watchAndShopProductItemPagerController.f3454e = null;
        this.f3418q.removeAllViews();
        m3237p();
        m3233k();
        this.f3418q.removeAllViews();
        this.f3405d = false;
    }

    private void m3232j() {
        if (getParent() == null && this.f3409h != null) {
            m3236o(this);
            this.f3409h.addView(this);
        }
    }

    private void m3233k() {
        if (getParent() == this.f3409h) {
            this.f3403b.removeCallbacksAndMessages(null);
            this.f3409h.removeView(this);
        }
    }

    private void setupBrowserLiteFragment(String str) {
        if (str != null) {
            Context context = getContext();
            Intent a = this.f3426y.a(context, str);
            if (a != null) {
                a.putExtra("watch_and_browse_dummy_video_view_height", this.f3407f.f3442i.b);
                this.f3427z.a(a, context);
                a.putExtra("iab_click_source", "watch_browse");
                this.f3398B.m1624a(a, context);
                Activity activity = (Activity) ContextUtils.a(context, Activity.class);
                if (activity != null) {
                    activity.setIntent(a);
                    this.f3414m = new BrowserLiteFragment();
                    this.f3414m.j = new C03132(this);
                    activity.getFragmentManager().beginTransaction().add(2131568412, this.f3414m).commit();
                }
            }
        }
    }

    private String m3221a(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null) {
            return null;
        }
        GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStoryAttachment, -508788748);
        if (a == null) {
            return null;
        }
        String aE = a.aE();
        if (!Strings.isNullOrEmpty(aE) || graphQLStoryAttachment.z() == null) {
            return aE;
        }
        return this.f3422u.a(LinkExtractorConverter.a(graphQLStoryAttachment.z()));
    }

    private void m3234l() {
        if (this.f3414m != null) {
            Activity activity = (Activity) ContextUtils.a(getContext(), Activity.class);
            if (activity != null) {
                this.f3414m.b(0);
                activity.getFragmentManager().beginTransaction().remove(this.f3414m).commit();
                this.f3414m = null;
            }
        }
    }

    private void m3226a(VideoTransitionNode videoTransitionNode, int i, PlayerOrigin playerOrigin, EventTriggerType eventTriggerType) {
        this.f3406e = this.f3419r.a(videoTransitionNode, this.f3407f, this.f3412k, FullscreenType.WATCH_AND_BROWSE, null);
        this.f3406e.setOriginalPlayReason(eventTriggerType);
        this.f3415n.f3432e = this.f3410i;
        this.f3400D.f3371a = new WeakReference(this.f3407f);
        this.f3400D.f3372b = new WeakReference(this.f3415n);
        this.f3400D.f3373c = new WeakReference(this.f3417p);
        this.f3407f.setupFullscreenButtonClickHandler(new C03143(this));
        if (this.f3404c != null) {
            this.f3404c.a(EventTriggerType.BY_USER);
        }
        this.f3406e.setPlayerOrigin(playerOrigin);
        this.f3407f.m3259a(this.f3412k, StoryAttachmentHelper.o((GraphQLStory) this.f3413l.a));
        this.f3407f.setupDismissPlayerButton(this.f3417p);
        this.f3407f.setVisibility(0);
        this.f3406e.a(false, EventTriggerType.BY_USER);
        this.f3406e.a(EventTriggerType.BY_USER, i);
    }

    private void m3225a(ExitFullScreenResult exitFullScreenResult) {
        this.f3406e.a(true, EventTriggerType.BY_USER);
        this.f3406e.b(EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION);
        this.f3419r.a();
        VideoWatchAndBrowseFullScreenManager videoWatchAndBrowseFullScreenManager = this.f3400D;
        videoWatchAndBrowseFullScreenManager.f3371a = null;
        videoWatchAndBrowseFullScreenManager.f3372b = null;
        videoWatchAndBrowseFullScreenManager.f3374d = 1;
        videoWatchAndBrowseFullScreenManager.f3376f = false;
        videoWatchAndBrowseFullScreenManager.f3375e = false;
        this.f3406e = null;
        if (this.f3404c != null) {
            this.f3404c.a(EventTriggerType.BY_USER, exitFullScreenResult);
        }
    }

    private void m3228a(String str) {
        HoneyClientEvent a = this.f3424w.a(str, ((GraphQLStory) this.f3413l.a).u(), TrackableFeedProps.a(this.f3413l), "video");
        if (a != null) {
            a.a("is_watch_and_browse", true);
            this.f3425x.a(a);
        }
    }

    private void m3222a(int i, int i2) {
        ArrayNode a = TrackableFeedProps.a(this.f3413l);
        this.f3397A.a(a, PlayerType.WATCH_AND_BROWSE.value, PlayerType.INLINE_PLAYER.value, this.f3412k.a.b, this.f3410i, this.f3411j.value, i, i2, ((GraphQLStory) this.f3413l.a()).u(), this.f3412k.a, null, null);
    }

    private void m3229b(ExitFullScreenResult exitFullScreenResult) {
        this.f3397A.a(TrackableFeedProps.a(this.f3413l), PlayerType.INLINE_PLAYER.value, PlayerType.WATCH_AND_BROWSE.value, this.f3412k.a.b, this.f3410i, this.f3411j.value, exitFullScreenResult.c, exitFullScreenResult.d, ((GraphQLStory) this.f3413l.a).u(), this.f3412k.a, null, null);
    }

    private void m3235n() {
        if (this.f3408g == null) {
            return;
        }
        if (VERSION.SDK_INT < 16) {
            this.f3408g.addFlags(1024);
        } else {
            this.f3408g.getDecorView().setSystemUiVisibility(1284);
        }
    }

    public static void m3236o(VideoWatchAndBrowseRootView videoWatchAndBrowseRootView) {
        if (VERSION.SDK_INT < 16) {
            if ((videoWatchAndBrowseRootView.f3408g.getAttributes().flags & 1024) == 0) {
                videoWatchAndBrowseRootView.m3235n();
            }
        } else if ((videoWatchAndBrowseRootView.f3408g.getDecorView().getSystemUiVisibility() & 4) == 0) {
            videoWatchAndBrowseRootView.m3235n();
        }
        HandlerDetour.b(videoWatchAndBrowseRootView.f3403b, new C03154(videoWatchAndBrowseRootView), 2000, 1157595865);
    }

    private void m3224a(InlineToFullscreenVideoTransitionManager inlineToFullscreenVideoTransitionManager, FeedVideoPlayerParamBuilderProvider feedVideoPlayerParamBuilderProvider, FeedImageLoader feedImageLoader, GraphQLLinkExtractor graphQLLinkExtractor, AttachmentLinkInspector attachmentLinkInspector, CommonEventsBuilder commonEventsBuilder, AnalyticsLogger analyticsLogger, UriIntentMapper uriIntentMapper, LinkshimExternalIntentHandler linkshimExternalIntentHandler, VideoLoggingUtils videoLoggingUtils, BrowserLiteIntentHandler browserLiteIntentHandler, RapidFeedbackController rapidFeedbackController, VideoWatchAndBrowseFullScreenManager videoWatchAndBrowseFullScreenManager, WatchAndShopProductItemPagerController watchAndShopProductItemPagerController) {
        this.f3419r = inlineToFullscreenVideoTransitionManager;
        this.f3420s = feedVideoPlayerParamBuilderProvider;
        this.f3421t = feedImageLoader;
        this.f3422u = graphQLLinkExtractor;
        this.f3423v = attachmentLinkInspector;
        this.f3424w = commonEventsBuilder;
        this.f3425x = analyticsLogger;
        this.f3426y = uriIntentMapper;
        this.f3427z = linkshimExternalIntentHandler;
        this.f3397A = videoLoggingUtils;
        this.f3398B = browserLiteIntentHandler;
        this.f3399C = rapidFeedbackController;
        this.f3400D = videoWatchAndBrowseFullScreenManager;
        this.f3401E = watchAndShopProductItemPagerController;
    }

    private void m3237p() {
        if (this.f3408g == null) {
            return;
        }
        if (VERSION.SDK_INT < 16) {
            this.f3408g.clearFlags(1024);
        } else {
            this.f3408g.getDecorView().setSystemUiVisibility(0);
        }
    }

    private ExitFullScreenResult m3238q() {
        int currentPositionMs = this.f3406e.getCurrentPositionMs();
        if (currentPositionMs < 0) {
            currentPositionMs = 0;
        }
        int lastStartPosition = this.f3406e.getLastStartPosition();
        if (lastStartPosition < 0) {
            lastStartPosition = 0;
        }
        if (lastStartPosition > currentPositionMs) {
            lastStartPosition = currentPositionMs;
        }
        return new ExitFullScreenResult(!this.f3406e.m(), this.f3406e.p(), currentPositionMs, lastStartPosition, false, null, EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION);
    }
}
