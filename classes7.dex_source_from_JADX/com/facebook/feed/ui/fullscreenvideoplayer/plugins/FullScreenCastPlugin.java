package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.MediaRouteButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.internal.Preconditions;
import com.facebook.content.event.FbEvent;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.fullscreenvideoplayer.castactivity.FullScreenCastActivity;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.abtest.VideoAbTestGatekeepers;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.chromecast.VideoCastManager;
import com.facebook.video.chromecast.VideoCastParams;
import com.facebook.video.chromecast.VideoCastParams.Builder;
import com.facebook.video.chromecast.callbacks.VideoCastConsumerAdapter;
import com.facebook.video.chromecast.dialog.VideoMediaRouteDialogFactory;
import com.facebook.video.chromecast.logging.VideoCastLoggingUtils;
import com.facebook.video.chromecast.notification.NotificationHelper;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPCastStateChangeEvent;
import com.facebook.video.player.events.RVPCastStateChangeEvent.State;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RVPRequestPausingEvent;
import com.facebook.video.player.events.RVPRequestPlayingEvent;
import com.facebook.video.player.events.RVPRequestSeekingEvent;
import com.facebook.video.player.events.RVPSizeChangedEvent;
import com.facebook.video.player.events.RVPStreamCompleteEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController;
import com.facebook.video.player.plugins.RichVideoPlayerPluginUtils;
import com.facebook.video.player.plugins.SeekBarBasePlugin;
import com.facebook.video.util.VideoPlayerUtils;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;

/* compiled from: TimelineFirstUnitsNetworkFetch */
public class FullScreenCastPlugin extends SeekBarBasePlugin {
    public static final Class<?> f22070q = FullScreenCastPlugin.class;
    private static final CallerContext f22071r = CallerContext.a(FullScreenCastPlugin.class, "video_cover");
    public boolean f22072A;
    private FbDraweeView f22073B;
    private Double f22074C;
    private boolean f22075D;
    public int f22076E;
    private FeedFullscreenSeekBarPlugin f22077F;
    private ProgressBar f22078G;
    public VideoCastParams f22079H;
    private VideoPlayerParams f22080I;
    private TextView f22081J;
    @VisibleForTesting
    SeekBar f22082l;
    @Inject
    public VideoLoggingUtils f22083m;
    @Inject
    public VideoCastManager f22084n;
    @Inject
    public GatekeeperStoreImpl f22085o;
    @Inject
    public GlyphColorizer f22086p;
    private FullScreenConsumer f22087s;
    public ImageView f22088t;
    private final AnimatorListener f22089u;
    public UiType f22090v;
    public MediaRouteButton f22091w;
    private MediaRouteButton f22092x;
    public boolean f22093y;
    private View f22094z;

    /* compiled from: TimelineFirstUnitsNetworkFetch */
    class C18811 extends AnimatorListenerAdapter {
        final /* synthetic */ FullScreenCastPlugin f22061a;

        C18811(FullScreenCastPlugin fullScreenCastPlugin) {
            this.f22061a = fullScreenCastPlugin;
        }

        public void onAnimationEnd(Animator animator) {
            this.f22061a.f22088t.setVisibility(8);
            this.f22061a.f22088t.setAlpha(0.0f);
        }
    }

    /* compiled from: TimelineFirstUnitsNetworkFetch */
    class C18822 implements OnClickListener {
        final /* synthetic */ FullScreenCastPlugin f22062a;

        C18822(FullScreenCastPlugin fullScreenCastPlugin) {
            this.f22062a = fullScreenCastPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 935061139);
            FullScreenCastPlugin.m24705w(this.f22062a);
            Logger.a(2, EntryType.UI_INPUT_END, 880675257, a);
        }
    }

    /* compiled from: TimelineFirstUnitsNetworkFetch */
    class C18833 implements OnClickListener {
        final /* synthetic */ FullScreenCastPlugin f22063a;

        C18833(FullScreenCastPlugin fullScreenCastPlugin) {
            this.f22063a = fullScreenCastPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 301622841);
            FullScreenCastPlugin.m24705w(this.f22063a);
            Logger.a(2, EntryType.UI_INPUT_END, -1444015283, a);
        }
    }

    /* compiled from: TimelineFirstUnitsNetworkFetch */
    class CastStateChangeHandler extends RichVideoPlayerEventSubscriber<RVPCastStateChangeEvent> {
        final /* synthetic */ FullScreenCastPlugin f22064a;

        public CastStateChangeHandler(FullScreenCastPlugin fullScreenCastPlugin) {
            this.f22064a = fullScreenCastPlugin;
        }

        public final void m24659b(FbEvent fbEvent) {
            if (((RVPCastStateChangeEvent) fbEvent).a == State.CAST_TOGGLE_PLAYBACK) {
                this.f22064a.m24717q();
            }
        }

        public final Class<RVPCastStateChangeEvent> m24658a() {
            return RVPCastStateChangeEvent.class;
        }
    }

    /* compiled from: TimelineFirstUnitsNetworkFetch */
    class FullScreenConsumer extends VideoCastConsumerAdapter {
        final /* synthetic */ FullScreenCastPlugin f22065a;

        public FullScreenConsumer(FullScreenCastPlugin fullScreenCastPlugin) {
            this.f22065a = fullScreenCastPlugin;
        }

        public final void mo1536a() {
            Class cls = FullScreenCastPlugin.f22070q;
            VideoCastManager videoCastManager;
            Object obj;
            if (this.f22065a.f22084n.a(this.f22065a.f22079H.a)) {
                if (this.f22065a.f22072A) {
                    this.f22065a.f22082l.setEnabled(true);
                    this.f22065a.m24689b(false);
                } else {
                    this.f22065a.m24710a(true);
                }
                if (this.f22065a.f22084n.K()) {
                    this.f22065a.m24712d();
                    return;
                }
                this.f22065a.o();
                videoCastManager = this.f22065a.f22084n;
                obj = null;
                if (videoCastManager.y != null) {
                    if (videoCastManager.D == null) {
                        videoCastManager.D = videoCastManager.y.b();
                    }
                    if (videoCastManager.D != null && videoCastManager.D.e == 4) {
                        obj = 1;
                    }
                }
                if (obj != null) {
                    this.f22065a.m24689b(true);
                }
            } else if (!this.f22065a.f22072A) {
            } else {
                if (this.f22065a.f22084n.M()) {
                    this.f22065a.m24719s();
                    return;
                }
                videoCastManager = this.f22065a.f22084n;
                obj = null;
                if (videoCastManager.y != null) {
                    if (videoCastManager.D == null) {
                        videoCastManager.D = videoCastManager.y.b();
                    }
                    if (videoCastManager.D != null && videoCastManager.D.e == 1 && (videoCastManager.D.f == 2 || videoCastManager.D.f == 3)) {
                        int i = 1;
                    }
                }
                if (obj != null) {
                    this.f22065a.m24718r();
                }
            }
        }

        public final void mo1544b() {
            if (!this.f22065a.f22084n.a(this.f22065a.f22079H.a)) {
                return;
            }
            if (this.f22065a.f22072A) {
                FullScreenCastPlugin.m24704v(this.f22065a);
                FullScreenCastPlugin.m24675C(this.f22065a);
                this.f22065a.f22079H.n = 0;
                return;
            }
            this.f22065a.m24710a(true);
        }

        public final void mo1545d() {
            this.f22065a.m24718r();
        }

        public final void mo1548h() {
            if (this.f22065a.f22084n.a(this.f22065a.f22079H.a) && !this.f22065a.f22072A) {
                this.f22065a.m24710a(true);
            } else if (this.f22065a.f22072A) {
                this.f22065a.m24718r();
            }
        }

        public final void mo1546e() {
            if (this.f22065a.f22072A) {
                FullScreenCastPlugin.m24704v(this.f22065a);
                FullScreenCastPlugin.m24675C(this.f22065a);
            }
        }

        public final void mo1537c() {
            if (this.f22065a.f22072A) {
                this.f22065a.m24718r();
            }
        }

        public final void mo1543a(boolean z) {
            int i;
            int i2 = 0;
            FullScreenCastPlugin.m24691c(this.f22065a, z);
            this.f22065a.f22093y = z;
            if (this.f22065a.m24720t() && z && this.f22065a.f22090v != UiType.UI_360) {
                i = 1;
            } else {
                i = 0;
            }
            MediaRouteButton mediaRouteButton = this.f22065a.f22091w;
            if (i == 0) {
                i2 = 8;
            }
            mediaRouteButton.setVisibility(i2);
            FullScreenCastPlugin.m24704v(this.f22065a);
        }

        public final void mo1538f() {
            if (this.f22065a.f22072A) {
                this.f22065a.m24718r();
            }
        }

        public final void mo1547g() {
            if (!this.f22065a.f22072A && !this.f22065a.f22084n.r()) {
                this.f22065a.m24710a(true);
            }
        }
    }

    /* compiled from: TimelineFirstUnitsNetworkFetch */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ FullScreenCastPlugin f22066a;

        public PlayerStateChangedEventSubscriber(FullScreenCastPlugin fullScreenCastPlugin) {
            this.f22066a = fullScreenCastPlugin;
        }

        public final void m24670b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            if (this.f22066a.f22072A && rVPPlayerStateChangedEvent.b == PlaybackController.State.PLAYING) {
                this.f22066a.m24716p();
            }
            FullScreenCastPlugin.m24679G(this.f22066a);
        }

        public final Class<RVPPlayerStateChangedEvent> m24669a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: TimelineFirstUnitsNetworkFetch */
    class SeekBarListener implements OnSeekBarChangeListener {
        final /* synthetic */ FullScreenCastPlugin f22067a;
        private boolean f22068b;

        public SeekBarListener(FullScreenCastPlugin fullScreenCastPlugin) {
            this.f22067a = fullScreenCastPlugin;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                int max = (this.f22067a.f22076E * i) / this.f22067a.f22082l.getMax();
                this.f22067a.f22084n.a((long) max);
                this.f22067a.a(max, this.f22067a.f22076E);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            this.f22068b = this.f22067a.f22084n.K();
            if (this.f22068b) {
                this.f22067a.f22084n.D();
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            if (this.f22067a.g != null && this.f22068b) {
                this.f22067a.f22084n.E();
            }
        }
    }

    /* compiled from: TimelineFirstUnitsNetworkFetch */
    class SizeChangedEventHandler extends RichVideoPlayerEventSubscriber<RVPSizeChangedEvent> {
        final /* synthetic */ FullScreenCastPlugin f22069a;

        public SizeChangedEventHandler(FullScreenCastPlugin fullScreenCastPlugin) {
            this.f22069a = fullScreenCastPlugin;
        }

        public final void m24672b(FbEvent fbEvent) {
            if (this.f22069a.f22072A) {
                FullScreenCastPlugin.m24674B(this.f22069a);
            }
        }

        public final Class<RVPSizeChangedEvent> m24671a() {
            return RVPSizeChangedEvent.class;
        }
    }

    /* compiled from: TimelineFirstUnitsNetworkFetch */
    public enum UiType {
        UI_LIVE,
        UI_VOD,
        UI_360
    }

    private static <T extends View> void m24685a(Class<T> cls, T t) {
        m24686a((Object) t, t.getContext());
    }

    private static void m24686a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FullScreenCastPlugin fullScreenCastPlugin = (FullScreenCastPlugin) obj;
        VideoLoggingUtils a = VideoLoggingUtils.a(fbInjector);
        VideoCastManager a2 = VideoCastManager.a(fbInjector);
        GatekeeperStoreImpl a3 = GatekeeperStoreImplMethodAutoProvider.a(fbInjector);
        GlyphColorizer a4 = GlyphColorizer.a(fbInjector);
        fullScreenCastPlugin.f22083m = a;
        fullScreenCastPlugin.f22084n = a2;
        fullScreenCastPlugin.f22085o = a3;
        fullScreenCastPlugin.f22086p = a4;
    }

    public FullScreenCastPlugin(Context context) {
        this(context, null);
    }

    public FullScreenCastPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FullScreenCastPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22089u = new C18811(this);
        m24685a(FullScreenCastPlugin.class, (View) this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Cover_Image_Plugin);
        this.f22075D = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        this.f22091w.setRemoteIndicatorDrawable(this.f22086p.a(2130840125, -1));
        this.f22084n.a(this.f22091w);
        this.f22084n.q = true;
        this.f22087s = new FullScreenConsumer(this);
        this.f22090v = UiType.UI_LIVE;
    }

    protected final void m24713e() {
        super.e();
        this.f22073B = (FbDraweeView) a(2131560814);
        this.f22094z = a(2131562399);
        VideoMediaRouteDialogFactory videoMediaRouteDialogFactory = new VideoMediaRouteDialogFactory();
        this.f22091w = (MediaRouteButton) a(2131561906);
        this.f22091w.setDialogFactory(videoMediaRouteDialogFactory);
        this.f22081J = (TextView) a(2131562397);
        this.f22078G = (ProgressBar) a(2131562398);
        this.f22088t = (ImageView) a(2131560326);
        this.f22082l = (SeekBar) a(2131562401);
    }

    protected final void m24714f() {
        this.f.add(new CastStateChangeHandler(this));
        this.f.add(new SizeChangedEventHandler(this));
        this.f.add(new PlayerStateChangedEventSubscriber(this));
    }

    protected final void m24715k() {
        this.f22091w.setOnClickListener(new C18822(this));
        this.f22082l.setOnSeekBarChangeListener(new SeekBarListener(this));
    }

    public void setUiType(UiType uiType) {
        this.f22090v = uiType;
    }

    public void setOtherControls(FeedFullscreenSeekBarPlugin feedFullscreenSeekBarPlugin) {
        this.f22077F = feedFullscreenSeekBarPlugin;
        if (this.f22077F != null) {
            this.f22092x = this.f22077F.f21994F;
            this.f22092x.setDialogFactory(new VideoMediaRouteDialogFactory());
            this.f22084n.a(this.f22092x);
            this.f22092x.setOnClickListener(new C18833(this));
        }
    }

    public static void m24704v(FullScreenCastPlugin fullScreenCastPlugin) {
        int i = 0;
        int i2 = (!fullScreenCastPlugin.m24720t() || fullScreenCastPlugin.f22090v == UiType.UI_360) ? 0 : 1;
        if (fullScreenCastPlugin.f22077F != null) {
            Object obj;
            if (fullScreenCastPlugin.f22084n.v == 24) {
                obj = 1;
            } else {
                obj = null;
            }
            MediaRouteButton mediaRouteButton;
            if (obj == null) {
                fullScreenCastPlugin.f22077F.m24630d(8);
                fullScreenCastPlugin.f22092x.setVisibility(8);
                mediaRouteButton = fullScreenCastPlugin.f22091w;
                if (!fullScreenCastPlugin.f22093y || i2 == 0) {
                    i = 8;
                }
                mediaRouteButton.setVisibility(i);
                fullScreenCastPlugin.f22084n.a(fullScreenCastPlugin.f22091w);
                return;
            }
            fullScreenCastPlugin.f22077F.m24630d(0);
            mediaRouteButton = fullScreenCastPlugin.f22092x;
            if (!fullScreenCastPlugin.f22093y || i2 == 0) {
                i = 8;
            }
            mediaRouteButton.setVisibility(i);
            fullScreenCastPlugin.f22091w.setVisibility(8);
            fullScreenCastPlugin.f22084n.a(fullScreenCastPlugin.f22092x);
        }
    }

    public static void m24705w(FullScreenCastPlugin fullScreenCastPlugin) {
        fullScreenCastPlugin.m24677E();
        if (!fullScreenCastPlugin.f22072A) {
            Preconditions.a(fullScreenCastPlugin.h);
            fullScreenCastPlugin.m24716p();
            fullScreenCastPlugin.f22079H.n = fullScreenCastPlugin.h.f();
            fullScreenCastPlugin.f22079H.o = fullScreenCastPlugin.h.p();
        }
        VideoCastManager videoCastManager = fullScreenCastPlugin.f22084n;
        VideoCastParams videoCastParams = fullScreenCastPlugin.f22079H;
        if (!videoCastManager.a(videoCastParams.a)) {
            videoCastManager.M = videoCastParams;
        }
    }

    public final void m24716p() {
        if (this.h != null && this.h.i()) {
            this.g.a(new RVPRequestPausingEvent(EventTriggerType.BY_CHROME_CAST));
        }
    }

    protected final void m24709a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        int i = 0;
        if (richVideoPlayerParams.a.b == null || richVideoPlayerParams.a.b.isEmpty()) {
            m24710a(false);
            return;
        }
        if (z) {
            int i2 = (m24720t() && this.f22084n.q() && this.f22090v != UiType.UI_360) ? 1 : 0;
            MediaRouteButton mediaRouteButton = this.f22091w;
            if (i2 == 0) {
                i = 8;
            }
            mediaRouteButton.setVisibility(i);
            m24679G(this);
            this.f22084n.a(this.f22087s);
            this.f22084n.p();
        }
        m24683a(richVideoPlayerParams);
        m24710a(this.f22084n.a(richVideoPlayerParams.a.b));
    }

    private void m24683a(RichVideoPlayerParams richVideoPlayerParams) {
        Object obj;
        ImageRequest imageRequest;
        ImageRequest imageRequest2;
        Object obj2;
        FeedProps feedProps;
        String a;
        GraphQLStoryAttachment o;
        String str;
        GraphQLMedia r;
        String str2;
        String str3;
        int i;
        int i2;
        Builder a2;
        String str4 = null;
        if (richVideoPlayerParams.b.containsKey("CoverImageParamsKey")) {
            obj = richVideoPlayerParams.b.get("CoverImageParamsKey");
            if (obj instanceof ImageRequest) {
                imageRequest = (ImageRequest) obj;
                if (richVideoPlayerParams.b.containsKey("BlurredCoverImageParamsKey")) {
                    obj = richVideoPlayerParams.b.get("BlurredCoverImageParamsKey");
                    if (obj instanceof ImageRequest) {
                        imageRequest2 = (ImageRequest) obj;
                        obj = richVideoPlayerParams.b.get("VideoAspectRatioKey");
                        if (obj instanceof Double) {
                            this.f22074C = Double.valueOf(((Double) obj).doubleValue());
                        }
                        if (richVideoPlayerParams.b.containsKey("GraphQLStoryProps")) {
                            obj2 = richVideoPlayerParams.b.get("GraphQLStoryProps");
                            if ((obj2 instanceof FeedProps) && (((FeedProps) obj2).a instanceof GraphQLStory)) {
                                feedProps = (FeedProps) obj2;
                                a = VideoPlayerUtils.a(StoryAttachmentHelper.o((GraphQLStory) feedProps.a));
                                o = StoryAttachmentHelper.o((GraphQLStory) feedProps.a);
                                str = null;
                                if (o != null) {
                                    r = o.r();
                                    if (!(r == null || r.F() == null || StoryActorHelper.b(r.F()) == null)) {
                                        str = GraphQLActorUtil.a(StoryActorHelper.b(r.F()));
                                    }
                                }
                                str2 = str;
                                if (a != null || a.isEmpty()) {
                                    a = null;
                                    str3 = str2;
                                } else {
                                    str3 = a;
                                    a = str2;
                                }
                                o = StoryAttachmentHelper.o((GraphQLStory) feedProps.a);
                                if (o != null || o.r() == null) {
                                    i = 0;
                                } else {
                                    i = o.r().aJ();
                                }
                                i2 = i;
                                if (i2 > 0) {
                                    str4 = getResources().getQuantityString(2131689515, i2, new Object[]{Integer.valueOf(i2)});
                                }
                                i2 = richVideoPlayerParams.a.c;
                                if (i2 > 0) {
                                    this.f22076E = i2;
                                }
                                Preconditions.a(this.h);
                                this.f22080I = richVideoPlayerParams.a;
                                a2 = Builder.a(this.f22080I).a(str3);
                                if (a != null) {
                                    a2.d = a;
                                }
                                a2 = a2;
                                if (str4 != null) {
                                    a2.e = str4;
                                }
                                a2 = a2;
                                a2.j = imageRequest;
                                a2 = a2;
                                a2.k = imageRequest2;
                                a2 = a2;
                                a2.l = this.h.o();
                                this.f22079H = a2.a();
                            }
                        }
                        a = null;
                        str3 = null;
                        i2 = richVideoPlayerParams.a.c;
                        if (i2 > 0) {
                            this.f22076E = i2;
                        }
                        Preconditions.a(this.h);
                        this.f22080I = richVideoPlayerParams.a;
                        a2 = Builder.a(this.f22080I).a(str3);
                        if (a != null) {
                            a2.d = a;
                        }
                        a2 = a2;
                        if (str4 != null) {
                            a2.e = str4;
                        }
                        a2 = a2;
                        a2.j = imageRequest;
                        a2 = a2;
                        a2.k = imageRequest2;
                        a2 = a2;
                        a2.l = this.h.o();
                        this.f22079H = a2.a();
                    }
                }
                imageRequest2 = null;
                obj = richVideoPlayerParams.b.get("VideoAspectRatioKey");
                if (obj instanceof Double) {
                    this.f22074C = Double.valueOf(((Double) obj).doubleValue());
                }
                if (richVideoPlayerParams.b.containsKey("GraphQLStoryProps")) {
                    obj2 = richVideoPlayerParams.b.get("GraphQLStoryProps");
                    feedProps = (FeedProps) obj2;
                    a = VideoPlayerUtils.a(StoryAttachmentHelper.o((GraphQLStory) feedProps.a));
                    o = StoryAttachmentHelper.o((GraphQLStory) feedProps.a);
                    str = null;
                    if (o != null) {
                        r = o.r();
                        str = GraphQLActorUtil.a(StoryActorHelper.b(r.F()));
                    }
                    str2 = str;
                    if (a != null) {
                    }
                    a = null;
                    str3 = str2;
                    o = StoryAttachmentHelper.o((GraphQLStory) feedProps.a);
                    if (o != null) {
                    }
                    i = 0;
                    i2 = i;
                    if (i2 > 0) {
                        str4 = getResources().getQuantityString(2131689515, i2, new Object[]{Integer.valueOf(i2)});
                    }
                    i2 = richVideoPlayerParams.a.c;
                    if (i2 > 0) {
                        this.f22076E = i2;
                    }
                    Preconditions.a(this.h);
                    this.f22080I = richVideoPlayerParams.a;
                    a2 = Builder.a(this.f22080I).a(str3);
                    if (a != null) {
                        a2.d = a;
                    }
                    a2 = a2;
                    if (str4 != null) {
                        a2.e = str4;
                    }
                    a2 = a2;
                    a2.j = imageRequest;
                    a2 = a2;
                    a2.k = imageRequest2;
                    a2 = a2;
                    a2.l = this.h.o();
                    this.f22079H = a2.a();
                }
                a = null;
                str3 = null;
                i2 = richVideoPlayerParams.a.c;
                if (i2 > 0) {
                    this.f22076E = i2;
                }
                Preconditions.a(this.h);
                this.f22080I = richVideoPlayerParams.a;
                a2 = Builder.a(this.f22080I).a(str3);
                if (a != null) {
                    a2.d = a;
                }
                a2 = a2;
                if (str4 != null) {
                    a2.e = str4;
                }
                a2 = a2;
                a2.j = imageRequest;
                a2 = a2;
                a2.k = imageRequest2;
                a2 = a2;
                a2.l = this.h.o();
                this.f22079H = a2.a();
            }
        }
        imageRequest = null;
        if (richVideoPlayerParams.b.containsKey("BlurredCoverImageParamsKey")) {
            obj = richVideoPlayerParams.b.get("BlurredCoverImageParamsKey");
            if (obj instanceof ImageRequest) {
                imageRequest2 = (ImageRequest) obj;
                obj = richVideoPlayerParams.b.get("VideoAspectRatioKey");
                if (obj instanceof Double) {
                    this.f22074C = Double.valueOf(((Double) obj).doubleValue());
                }
                if (richVideoPlayerParams.b.containsKey("GraphQLStoryProps")) {
                    obj2 = richVideoPlayerParams.b.get("GraphQLStoryProps");
                    feedProps = (FeedProps) obj2;
                    a = VideoPlayerUtils.a(StoryAttachmentHelper.o((GraphQLStory) feedProps.a));
                    o = StoryAttachmentHelper.o((GraphQLStory) feedProps.a);
                    str = null;
                    if (o != null) {
                        r = o.r();
                        str = GraphQLActorUtil.a(StoryActorHelper.b(r.F()));
                    }
                    str2 = str;
                    if (a != null) {
                    }
                    a = null;
                    str3 = str2;
                    o = StoryAttachmentHelper.o((GraphQLStory) feedProps.a);
                    if (o != null) {
                    }
                    i = 0;
                    i2 = i;
                    if (i2 > 0) {
                        str4 = getResources().getQuantityString(2131689515, i2, new Object[]{Integer.valueOf(i2)});
                    }
                    i2 = richVideoPlayerParams.a.c;
                    if (i2 > 0) {
                        this.f22076E = i2;
                    }
                    Preconditions.a(this.h);
                    this.f22080I = richVideoPlayerParams.a;
                    a2 = Builder.a(this.f22080I).a(str3);
                    if (a != null) {
                        a2.d = a;
                    }
                    a2 = a2;
                    if (str4 != null) {
                        a2.e = str4;
                    }
                    a2 = a2;
                    a2.j = imageRequest;
                    a2 = a2;
                    a2.k = imageRequest2;
                    a2 = a2;
                    a2.l = this.h.o();
                    this.f22079H = a2.a();
                }
                a = null;
                str3 = null;
                i2 = richVideoPlayerParams.a.c;
                if (i2 > 0) {
                    this.f22076E = i2;
                }
                Preconditions.a(this.h);
                this.f22080I = richVideoPlayerParams.a;
                a2 = Builder.a(this.f22080I).a(str3);
                if (a != null) {
                    a2.d = a;
                }
                a2 = a2;
                if (str4 != null) {
                    a2.e = str4;
                }
                a2 = a2;
                a2.j = imageRequest;
                a2 = a2;
                a2.k = imageRequest2;
                a2 = a2;
                a2.l = this.h.o();
                this.f22079H = a2.a();
            }
        }
        imageRequest2 = null;
        obj = richVideoPlayerParams.b.get("VideoAspectRatioKey");
        if (obj instanceof Double) {
            this.f22074C = Double.valueOf(((Double) obj).doubleValue());
        }
        if (richVideoPlayerParams.b.containsKey("GraphQLStoryProps")) {
            obj2 = richVideoPlayerParams.b.get("GraphQLStoryProps");
            feedProps = (FeedProps) obj2;
            a = VideoPlayerUtils.a(StoryAttachmentHelper.o((GraphQLStory) feedProps.a));
            o = StoryAttachmentHelper.o((GraphQLStory) feedProps.a);
            str = null;
            if (o != null) {
                r = o.r();
                str = GraphQLActorUtil.a(StoryActorHelper.b(r.F()));
            }
            str2 = str;
            if (a != null) {
            }
            a = null;
            str3 = str2;
            o = StoryAttachmentHelper.o((GraphQLStory) feedProps.a);
            if (o != null) {
            }
            i = 0;
            i2 = i;
            if (i2 > 0) {
                str4 = getResources().getQuantityString(2131689515, i2, new Object[]{Integer.valueOf(i2)});
            }
            i2 = richVideoPlayerParams.a.c;
            if (i2 > 0) {
                this.f22076E = i2;
            }
            Preconditions.a(this.h);
            this.f22080I = richVideoPlayerParams.a;
            a2 = Builder.a(this.f22080I).a(str3);
            if (a != null) {
                a2.d = a;
            }
            a2 = a2;
            if (str4 != null) {
                a2.e = str4;
            }
            a2 = a2;
            a2.j = imageRequest;
            a2 = a2;
            a2.k = imageRequest2;
            a2 = a2;
            a2.l = this.h.o();
            this.f22079H = a2.a();
        }
        a = null;
        str3 = null;
        i2 = richVideoPlayerParams.a.c;
        if (i2 > 0) {
            this.f22076E = i2;
        }
        Preconditions.a(this.h);
        this.f22080I = richVideoPlayerParams.a;
        a2 = Builder.a(this.f22080I).a(str3);
        if (a != null) {
            a2.d = a;
        }
        a2 = a2;
        if (str4 != null) {
            a2.e = str4;
        }
        a2 = a2;
        a2.j = imageRequest;
        a2 = a2;
        a2.k = imageRequest2;
        a2 = a2;
        a2.l = this.h.o();
        this.f22079H = a2.a();
    }

    protected final void m24711c() {
        super.c();
        this.f22076E = 0;
        this.f22084n.b(this.f22087s);
        m24706x();
        m24710a(false);
        this.f22084n.M = null;
    }

    private void m24706x() {
        if (!this.f22084n.O()) {
            return;
        }
        if (!this.f22072A || this.f22079H.k == null) {
            this.f22084n.H();
            return;
        }
        VideoCastManager videoCastManager = this.f22084n;
        PendingIntent a = FullScreenCastActivity.m24573a(getContext(), this.f22080I, this.f22079H.k.c, this.f22074C.doubleValue());
        CharSequence charSequence = "";
        if (videoCastManager.M != null) {
            charSequence = videoCastManager.M.b;
        } else if (videoCastManager.L != null) {
            Object obj = videoCastManager.L.b;
        }
        NotificationHelper notificationHelper = videoCastManager.F;
        NotificationCompat.Builder b = notificationHelper.d.a(2130840818).a(charSequence).b(videoCastManager.s());
        b.d = a;
        b.a(true);
        notificationHelper.e = true;
        notificationHelper.a.notify(1, notificationHelper.d.c());
    }

    protected int getContentView() {
        if (m24708z()) {
            return 2130904541;
        }
        return 2130904540;
    }

    protected int getActiveThumbResource() {
        return 0;
    }

    private boolean m24707y() {
        return this.f22079H == null ? true : this.f22079H.a();
    }

    private boolean m24708z() {
        if (getId() == 2131563521) {
            return false;
        }
        return true;
    }

    protected final void m24710a(boolean z) {
        boolean z2 = false;
        if (this.f22090v == UiType.UI_360) {
            z = false;
        }
        m24704v(this);
        if (z) {
            m24716p();
            m24673A();
            this.f22094z.setVisibility(0);
            m24675C(this);
            m24712d();
            if (m24707y()) {
                this.f22078G.setVisibility(8);
                this.f22082l.setVisibility(8);
                o();
            } else {
                this.f22078G.setVisibility(0);
                this.f22082l.setVisibility(0);
                boolean O = this.f22084n.O();
                this.f22082l.setEnabled(O);
                if (!O) {
                    z2 = true;
                }
                m24689b(z2);
            }
            this.f22084n.G();
            m24684a(State.CAST_INITIATED);
        } else {
            this.f22081J.setVisibility(8);
            this.f22073B.setVisibility(8);
            this.f22094z.setVisibility(8);
            this.f22078G.setVisibility(8);
            o();
            m24684a(State.CAST_STOPPED);
        }
        this.f22072A = z;
    }

    private void m24684a(State state) {
        if (this.g != null) {
            this.g.a(new RVPCastStateChangeEvent(state));
        }
    }

    private void m24673A() {
        if (this.f22074C == null) {
            return;
        }
        if (this.f22079H.k != null || this.f22079H.l != null) {
            m24674B(this);
            this.f22073B.a(this.f22079H.l != null ? this.f22079H.l.c : this.f22079H.k.c, f22071r);
            this.f22073B.setVisibility(0);
        }
    }

    public static void m24674B(FullScreenCastPlugin fullScreenCastPlugin) {
        RichVideoPlayerPluginUtils.a(fullScreenCastPlugin.e, fullScreenCastPlugin.f22073B, fullScreenCastPlugin.f22074C.doubleValue(), fullScreenCastPlugin.f22075D);
    }

    protected final void m24717q() {
        if (this.f22084n.K()) {
            RichVideoPlayerPluginUtils.a(this.f22088t, 250, 2130840510, this.f22089u);
        } else {
            RichVideoPlayerPluginUtils.a(this.f22088t, 250, 2130840511, this.f22089u);
        }
        this.f22084n.B();
    }

    protected final void m24712d() {
        if (!m24707y()) {
            int y;
            if (this.f22079H == null || this.f22079H.n == 0) {
                y = this.f22084n.y();
            } else {
                y = this.f22079H.n;
            }
            Integer.valueOf(this.f22076E);
            Integer.valueOf(y);
            this.f22082l.setProgress(b(this.f22076E, y));
            a(y, this.f22076E);
            if (this.f22084n.K()) {
                n();
            }
        }
    }

    public static void m24675C(FullScreenCastPlugin fullScreenCastPlugin) {
        CharSequence s = fullScreenCastPlugin.f22084n.s();
        if (s != null) {
            fullScreenCastPlugin.f22081J.setText(s);
            fullScreenCastPlugin.f22081J.setVisibility(0);
            return;
        }
        fullScreenCastPlugin.f22081J.setText(8);
    }

    protected final void m24718r() {
        m24710a(false);
        m24676D();
        m24678F();
    }

    protected final void m24719s() {
        m24710a(false);
        this.g.a(new RVPRequestSeekingEvent(0, EventTriggerType.BY_CHROME_CAST));
        this.g.a(new RVPPlayerStateChangedEvent(this.f22080I.b, PlaybackController.State.PLAYBACK_COMPLETE));
        this.g.a(new RVPStreamCompleteEvent(this.f22076E));
    }

    private void m24676D() {
        int progress = (this.f22076E * this.f22082l.getProgress()) / this.f22082l.getMax();
        if (progress >= this.f22076E) {
            progress = 0;
        }
        this.g.a(new RVPRequestSeekingEvent(progress, EventTriggerType.BY_CHROME_CAST));
        if (this.f22084n.K) {
            this.g.a(new RVPRequestPlayingEvent(EventTriggerType.BY_CHROME_CAST));
        }
    }

    private void m24689b(boolean z) {
        this.f22078G.setVisibility(z ? 0 : 8);
    }

    public static void m24691c(FullScreenCastPlugin fullScreenCastPlugin, boolean z) {
        Preconditions.a(fullScreenCastPlugin.h);
        fullScreenCastPlugin.f22083m.a(fullScreenCastPlugin.f22080I.e, fullScreenCastPlugin.h.q.value, fullScreenCastPlugin.h.f(), fullScreenCastPlugin.f22080I.b, fullScreenCastPlugin.h.o(), fullScreenCastPlugin.f22080I.f, z);
    }

    private void m24677E() {
        Preconditions.a(this.h);
        this.f22083m.b(this.f22080I.e, this.h.q.value, this.h.f(), this.f22080I.b, this.h.o(), this.f22080I.f, this.f22084n.h());
    }

    private void m24678F() {
        Preconditions.a(this.h);
        this.f22083m.a(this.f22080I.e, PlayerType.FULL_SCREEN_PLAYER.value, this.h.q.value, this.f22079H.a, this.h.o(), VideoCastLoggingUtils.a, this.f22084n.y(), this.f22079H.o, this.f22079H.f, this.f22079H, null, null);
    }

    public static void m24679G(FullScreenCastPlugin fullScreenCastPlugin) {
        Preconditions.a(fullScreenCastPlugin.h);
        if (fullScreenCastPlugin.h.k()) {
            fullScreenCastPlugin.f22091w.setClickable(false);
            fullScreenCastPlugin.f22091w.setLongClickable(false);
            if (fullScreenCastPlugin.f22092x != null) {
                fullScreenCastPlugin.f22092x.setClickable(false);
                fullScreenCastPlugin.f22092x.setLongClickable(false);
                return;
            }
            return;
        }
        fullScreenCastPlugin.m24707y();
        fullScreenCastPlugin.f22091w.setClickable(true);
        fullScreenCastPlugin.f22091w.setLongClickable(true);
        if (fullScreenCastPlugin.f22092x != null) {
            fullScreenCastPlugin.f22092x.setClickable(true);
            fullScreenCastPlugin.f22092x.setLongClickable(true);
        }
    }

    public final boolean m24720t() {
        return this.f22085o.a(VideoAbTestGatekeepers.d, false);
    }
}
