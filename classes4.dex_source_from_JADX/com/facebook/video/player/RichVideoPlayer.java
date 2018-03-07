package com.facebook.video.player;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.abtest.VideoAbTestGatekeepers;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.engine.VideoResolution;
import com.facebook.video.player.RichVideoPlayerParams.Builder;
import com.facebook.video.player.environment.AnyPlayerEnvironment;
import com.facebook.video.player.events.RVPActivityDialogEvent;
import com.facebook.video.player.events.RVPDialogEvent;
import com.facebook.video.player.events.RVPErrorEvent;
import com.facebook.video.player.events.RVPFirstPlayEvent;
import com.facebook.video.player.events.RVPMeasureEvent;
import com.facebook.video.player.events.RVPOrientationChangedEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RVPRequestPausingEvent;
import com.facebook.video.player.events.RVPRequestPlayingEvent;
import com.facebook.video.player.events.RVPRequestSeekingEvent;
import com.facebook.video.player.events.RVPRequestSubtitlesLanguageChangeEvent;
import com.facebook.video.player.events.RVPRequestSubtitlesVisibilityChangeEvent;
import com.facebook.video.player.events.RVPSizeChangedEvent;
import com.facebook.video.player.events.RVPStreamCompleteEvent;
import com.facebook.video.player.events.RVPVideoSpecUpdateEvent;
import com.facebook.video.player.events.RVPVolumeChangeEvent;
import com.facebook.video.player.events.RichVideoPlayerEventBus;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.BaseCoverImagePlugin;
import com.facebook.video.player.plugins.PlaybackController;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.PlaybackControllerProvider;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPluginWithEnv;
import com.facebook.video.player.plugins.VideoPlugin;
import com.facebook.video.player.plugins.VideoPlugin.VideoPluginAlignment;
import com.facebook.video.subtitles.controller.Subtitles;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: passes_if_not_client_supported */
public class RichVideoPlayer extends AnchorLayout {
    private EventTriggerType f14002A;
    @Nullable
    private RichVideoPlayerParams f14003B;
    @Nullable
    private DraweeController f14004C;
    private int f14005D;
    private VideoResolution f14006E;
    public boolean f14007F;
    @Inject
    DefaultAndroidThreadUtil f14008a;
    @Inject
    RichVideoPlayerEventBus f14009b;
    @Inject
    PlaybackControllerProvider f14010c;
    @Inject
    PlayerActivityManager f14011d;
    @Inject
    Clock f14012e;
    @Inject
    GatekeeperStoreImpl f14013f;
    @VisibleForTesting
    List<RichVideoPlayerPlugin> f14014g;
    @Nullable
    @VisibleForTesting
    VideoPlugin f14015h;
    private final ActivityDialogSubscriber f14016i;
    private final FirstPlayEventSubscriber f14017j;
    private final StreamCompleteEventSubscriber f14018k;
    private final ErrorEventSubscriber f14019l;
    private final DialogEventSubscriber f14020m;
    private final PlayerStateChangedEventSubscriber f14021n;
    public final AudioFadeHandler f14022o;
    private boolean f14023p;
    public boolean f14024q;
    public boolean f14025r;
    public boolean f14026s;
    @Nullable
    public RichVideoPlayerParams f14027t;
    @Nullable
    public PlaybackController f14028u;
    public RichVideoPlayerCallbackListener f14029v;
    @Nullable
    private FbDraweeView f14030w;
    public PlayerOrigin f14031x;
    private PlayerType f14032y;
    private ChannelEligibility f14033z;

    /* compiled from: passes_if_not_client_supported */
    class C02211 implements Runnable {
        final /* synthetic */ RichVideoPlayer f5337a;

        C02211(RichVideoPlayer richVideoPlayer) {
            this.f5337a = richVideoPlayer;
        }

        public void run() {
            this.f5337a.f14009b.m14878a(new RVPSizeChangedEvent());
        }
    }

    /* compiled from: passes_if_not_client_supported */
    class ActivityDialogSubscriber extends RichVideoPlayerEventSubscriber<RVPActivityDialogEvent> {
        final /* synthetic */ RichVideoPlayer f14056a;

        public ActivityDialogSubscriber(RichVideoPlayer richVideoPlayer) {
            this.f14056a = richVideoPlayer;
        }

        public final void m14865b(FbEvent fbEvent) {
            this.f14056a.f14007F = true;
            if (!this.f14056a.f14025r) {
                this.f14056a.f14025r = true;
                this.f14056a.f14024q = this.f14056a.f14028u.f5115l.isPlayingState();
                if (this.f14056a.f14024q) {
                    this.f14056a.m14832b(EventTriggerType.BY_FLYOUT);
                }
            }
        }

        public final Class<RVPActivityDialogEvent> m14864a() {
            return RVPActivityDialogEvent.class;
        }
    }

    /* compiled from: passes_if_not_client_supported */
    class FirstPlayEventSubscriber extends RichVideoPlayerEventSubscriber<RVPFirstPlayEvent> {
        final /* synthetic */ RichVideoPlayer f14058a;

        public FirstPlayEventSubscriber(RichVideoPlayer richVideoPlayer) {
            this.f14058a = richVideoPlayer;
        }

        public final void m14868b(FbEvent fbEvent) {
            RVPFirstPlayEvent rVPFirstPlayEvent = (RVPFirstPlayEvent) fbEvent;
            if (this.f14058a.f14029v != null) {
                this.f14058a.f14029v.mo424a();
            }
        }

        public final Class<RVPFirstPlayEvent> m14867a() {
            return RVPFirstPlayEvent.class;
        }
    }

    /* compiled from: passes_if_not_client_supported */
    class StreamCompleteEventSubscriber extends RichVideoPlayerEventSubscriber<RVPStreamCompleteEvent> {
        final /* synthetic */ RichVideoPlayer f14059a;

        public StreamCompleteEventSubscriber(RichVideoPlayer richVideoPlayer) {
            this.f14059a = richVideoPlayer;
        }

        public final void m14870b(FbEvent fbEvent) {
            RVPStreamCompleteEvent rVPStreamCompleteEvent = (RVPStreamCompleteEvent) fbEvent;
            if (this.f14059a.f14029v != null) {
                for (RichVideoPlayerPlugin richVideoPlayerPlugin : this.f14059a.f14014g) {
                    if (richVideoPlayerPlugin.f14098j ? false : richVideoPlayerPlugin.mo380j()) {
                        return;
                    }
                }
                this.f14059a.f14029v.mo426a(rVPStreamCompleteEvent);
            }
        }

        public final Class<RVPStreamCompleteEvent> m14869a() {
            return RVPStreamCompleteEvent.class;
        }
    }

    /* compiled from: passes_if_not_client_supported */
    class ErrorEventSubscriber extends RichVideoPlayerEventSubscriber<RVPErrorEvent> {
        final /* synthetic */ RichVideoPlayer f14060a;

        public ErrorEventSubscriber(RichVideoPlayer richVideoPlayer) {
            this.f14060a = richVideoPlayer;
        }

        public final void m14872b(FbEvent fbEvent) {
            RVPErrorEvent rVPErrorEvent = (RVPErrorEvent) fbEvent;
            if (this.f14060a.f14029v != null) {
                this.f14060a.f14029v.mo425a(rVPErrorEvent);
            }
        }

        public final Class<RVPErrorEvent> m14871a() {
            return RVPErrorEvent.class;
        }
    }

    /* compiled from: passes_if_not_client_supported */
    class DialogEventSubscriber extends RichVideoPlayerEventSubscriber<RVPDialogEvent> {
        final /* synthetic */ RichVideoPlayer f14061a;

        public DialogEventSubscriber(RichVideoPlayer richVideoPlayer) {
            this.f14061a = richVideoPlayer;
        }

        public final void m14874b(FbEvent fbEvent) {
            RVPDialogEvent rVPDialogEvent = (RVPDialogEvent) fbEvent;
            if (rVPDialogEvent.f14076a && !this.f14061a.f14025r) {
                this.f14061a.f14025r = true;
                this.f14061a.f14024q = this.f14061a.f14028u.f5115l.isPlayingState();
                if (this.f14061a.f14024q) {
                    this.f14061a.m14832b(EventTriggerType.BY_FLYOUT);
                }
            } else if (!rVPDialogEvent.f14076a && this.f14061a.f14025r && !this.f14061a.f14007F) {
                this.f14061a.f14025r = false;
                if (this.f14061a.m14842h() && this.f14061a.f14024q) {
                    this.f14061a.m14818a(EventTriggerType.BY_FLYOUT);
                }
            }
        }

        public final Class<RVPDialogEvent> m14873a() {
            return RVPDialogEvent.class;
        }
    }

    /* compiled from: passes_if_not_client_supported */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ RichVideoPlayer f14062a;

        public PlayerStateChangedEventSubscriber(RichVideoPlayer richVideoPlayer) {
            this.f14062a = richVideoPlayer;
        }

        public final void m14876b(FbEvent fbEvent) {
            if (((RVPPlayerStateChangedEvent) fbEvent).f14079b == State.PLAYING) {
                this.f14062a.f14022o.m14884a();
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m14875a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    @VisibleForTesting
    /* compiled from: passes_if_not_client_supported */
    class AudioFadeHandler extends Handler {
        private static final String f14067a = AudioFadeHandler.class.getSimpleName();
        private WeakReference<RichVideoPlayer> f14068b;
        private Clock f14069c;
        private boolean f14070d;
        private int f14071e;
        private long f14072f;

        public AudioFadeHandler(RichVideoPlayer richVideoPlayer, Clock clock) {
            super(Looper.getMainLooper());
            Preconditions.checkNotNull(richVideoPlayer);
            Preconditions.checkNotNull(clock);
            this.f14068b = new WeakReference(richVideoPlayer);
            this.f14069c = clock;
        }

        public final void m14885a(int i) {
            Preconditions.checkState(i > 0);
            Integer.valueOf(i);
            m14881c();
            m14880a(0.0f);
            this.f14070d = true;
            this.f14071e = i;
        }

        @Nullable
        private RichVideoPlayer m14881c() {
            return (RichVideoPlayer) this.f14068b.get();
        }

        private void m14880a(float f) {
            RichVideoPlayer c = m14881c();
            if (c != null) {
                c.setVolume(f);
            }
        }

        public final void m14884a() {
            if (this.f14070d) {
                Integer.valueOf(this.f14071e);
                m14881c();
                this.f14070d = false;
                this.f14072f = this.f14069c.a();
                m14882d();
            }
        }

        private void m14882d() {
            sendMessageDelayed(Message.obtain(this, 0), 100);
        }

        public final void m14886b() {
            m14881c();
            this.f14070d = false;
            removeMessages(0);
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                m14883e();
            }
        }

        private void m14883e() {
            Preconditions.checkState(this.f14071e > 0);
            float pow = (float) Math.pow((double) (((float) (this.f14069c.a() - this.f14072f)) / ((float) this.f14071e)), 1.5d);
            m14880a(pow);
            if (pow < 1.0f) {
                m14882d();
            }
        }
    }

    private static <T extends View> void m14800a(Class<T> cls, T t) {
        m14801a((Object) t, t.getContext());
    }

    private static void m14801a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RichVideoPlayer) obj).m14799a(DefaultAndroidThreadUtil.b(fbInjector), new RichVideoPlayerEventBus(DefaultAndroidThreadUtil.b(fbInjector)), (PlaybackControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PlaybackControllerProvider.class), PlayerActivityManager.a(fbInjector), (Clock) SystemClockMethodAutoProvider.a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector));
    }

    private void m14799a(DefaultAndroidThreadUtil defaultAndroidThreadUtil, RichVideoPlayerEventBus richVideoPlayerEventBus, PlaybackControllerProvider playbackControllerProvider, PlayerActivityManager playerActivityManager, Clock clock, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f14008a = defaultAndroidThreadUtil;
        this.f14009b = richVideoPlayerEventBus;
        this.f14010c = playbackControllerProvider;
        this.f14011d = playerActivityManager;
        this.f14012e = clock;
        this.f14013f = gatekeeperStoreImpl;
    }

    public RichVideoPlayer(Context context) {
        this(context, null);
    }

    public RichVideoPlayer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RichVideoPlayer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14016i = new ActivityDialogSubscriber(this);
        this.f14017j = new FirstPlayEventSubscriber(this);
        this.f14018k = new StreamCompleteEventSubscriber(this);
        this.f14019l = new ErrorEventSubscriber(this);
        this.f14020m = new DialogEventSubscriber(this);
        this.f14021n = new PlayerStateChangedEventSubscriber(this);
        this.f14026s = true;
        this.f14031x = PlayerOrigin.UNKNOWN;
        this.f14032y = PlayerType.INLINE_PLAYER;
        this.f14033z = ChannelEligibility.NO_INFO;
        this.f14002A = EventTriggerType.BY_USER;
        this.f14006E = VideoResolution.STANDARD_DEFINITION;
        this.f14014g = new ArrayList();
        m14800a(RichVideoPlayer.class, (View) this);
        this.f14022o = new AudioFadeHandler(this, this.f14012e);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RichVideoPlayer, i, 0);
        try {
            this.f14026s = obtainStyledAttributes.getBoolean(0, true);
            this.f14009b.a(this.f14018k);
            this.f14009b.a(this.f14017j);
            this.f14009b.a(this.f14019l);
            this.f14009b.a(this.f14020m);
            this.f14009b.a(this.f14016i);
            this.f14009b.a(this.f14021n);
            this.f14011d.a(this);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.f14008a.b(new C02211(this));
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f14009b.m14878a(new RVPMeasureEvent());
    }

    public final void m14837c(int i) {
        this.f14009b.m14878a(new RVPVolumeChangeEvent(i));
    }

    public final void m14829a(boolean z) {
        this.f14009b.m14878a(new RVPRequestSubtitlesVisibilityChangeEvent(z));
    }

    public final void m14826a(@Nullable Subtitles subtitles) {
        this.f14009b.m14878a(new RVPRequestSubtitlesLanguageChangeEvent(subtitles));
    }

    public void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -869127604);
        super.onFinishInflate();
        if (!this.f14023p) {
            List<RichVideoPlayerPlugin> arrayList = new ArrayList();
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof RichVideoPlayerPlugin) {
                    arrayList.add((RichVideoPlayerPlugin) childAt);
                }
            }
            for (RichVideoPlayerPlugin richVideoPlayerPlugin : arrayList) {
                m14825a(richVideoPlayerPlugin);
                removeViewInLayout(richVideoPlayerPlugin);
            }
            this.f14023p = true;
        }
        LogUtils.g(-1737034164, a);
    }

    protected final void mo378c() {
        if (m14802a() && this.f14027t != null) {
            m14814t();
        }
    }

    protected final void iZ_() {
        if (m14802a() && this.f14003B != null) {
            mo394b();
        }
    }

    protected final void m14839e() {
        if (!m14802a() && this.f14027t != null) {
            m14814t();
        }
    }

    protected void m14840f() {
        if (!(m14802a() || this.f14003B == null)) {
            mo394b();
        }
        if (this.f14025r && this.f14007F) {
            this.f14007F = false;
            this.f14025r = false;
            if (this.f14024q) {
                m14818a(EventTriggerType.BY_FLYOUT);
            }
        }
    }

    private boolean m14802a() {
        return this.f14013f.a(491, false);
    }

    private void mo394b() {
        Preconditions.checkNotNull(this.f14003B);
        Builder d = this.f14003B.m5359d();
        if (this.f14005D > 0) {
            d.m5353a("SeekPositionMsKey", Integer.valueOf(this.f14005D));
        }
        if (this.f14006E != VideoResolution.STANDARD_DEFINITION) {
            boolean z;
            VideoPlayerParamsBuilder a = VideoPlayerParams.newBuilder().m5262a(this.f14003B.f4962a);
            if (this.f14006E == VideoResolution.HIGH_DEFINITION) {
                z = true;
            } else {
                z = false;
            }
            a.f4863m = z;
            d.f4958a = a.m5271m();
            this.f14006E = VideoResolution.STANDARD_DEFINITION;
        }
        m14821a(d.m5355b());
        if (!(this.f14004C == null || getCoverImage() == null)) {
            getCoverImage().setController(this.f14004C);
            getCoverImage().setVisibility(0);
            getCoverImage().setAlpha(1.0f);
        }
        if (this.f14005D > 0) {
            this.f14028u.m5461a(this.f14005D, EventTriggerType.BY_ANDROID);
        }
        this.f14003B = null;
        this.f14004C = null;
        this.f14005D = 0;
    }

    private void m14814t() {
        this.f14004C = getCoverImage() != null ? getCoverImage().getController() : null;
        this.f14005D = this.f14028u.m5477f();
        this.f14006E = this.f14028u.m5476e();
        RichVideoPlayerParams richVideoPlayerParams = this.f14027t;
        m14841g();
        this.f14003B = richVideoPlayerParams;
    }

    public synchronized void m14821a(RichVideoPlayerParams richVideoPlayerParams) {
        int i;
        if (this.f14027t == null) {
            this.f14027t = richVideoPlayerParams;
            Object obj = null;
        } else {
            VideoPlayerParams videoPlayerParams = this.f14027t.f4962a;
            this.f14027t = this.f14027t.m5359d().m5354b(richVideoPlayerParams).m5355b();
            VideoPlayerParams videoPlayerParams2 = videoPlayerParams;
        }
        if (this.f14028u == null) {
            boolean z;
            boolean z2;
            if (richVideoPlayerParams == null || richVideoPlayerParams.f4962a == null || richVideoPlayerParams.f4962a.f4850s == null) {
                z = false;
            } else {
                z = true;
            }
            boolean u = m14815u();
            if (this.f14027t == null || this.f14027t.f4962a == null || !this.f14027t.f4962a.f4837f) {
                z2 = false;
            } else {
                z2 = true;
            }
            TracerDetour.a("RichVideoPlayer.PlaybackControllerProvider.get", 1841437379);
            try {
                this.f14028u = this.f14010c.m14879a(Boolean.valueOf(z), Boolean.valueOf(u), Boolean.valueOf(z2), this.f14031x, Boolean.valueOf(this.f14026s));
                this.f14028u.m5474b(this.f14002A);
                this.f14028u.m5466a(this.f14032y);
                this.f14028u.m5462a(this.f14033z);
                TracerDetour.a(-554169368);
                i = 1;
            } catch (Throwable th) {
                TracerDetour.a(-152764997);
            }
        } else {
            i = 0;
        }
        Preconditions.checkNotNull(this.f14028u);
        TracerDetour.a("RichVideoPlayer.RichVideoPlayerPlugins.load", -626880363);
        try {
            int hasNext;
            String str;
            Iterator it = this.f14014g.iterator();
            while (true) {
                hasNext = it.hasNext();
                if (hasNext == 0) {
                    break;
                }
                ((RichVideoPlayerPlugin) it.next()).mo393a(this.f14028u, this, this.f14027t);
            }
            TracerDetour.a(hasNext);
            if (!this.f14027t.f4964c.isEmpty()) {
                this.f14027t = this.f14027t.m5359d().m5350a().m5355b();
            }
            if (!(richVideoPlayerParams.f4962a == null || richVideoPlayerParams.f4962a.equals(r8))) {
                this.f14022o.m14886b();
                TracerDetour.a("RichVideoPlayer.PlaybackController.bindVideoSources", 1538945785);
                try {
                    hasNext = this.f14028u;
                    hasNext.m5467a(richVideoPlayerParams.f4962a);
                    TracerDetour.a(hasNext);
                } finally {
                    i = 866264005;
                    TracerDetour.a(866264005);
                }
            }
            if (i != 0) {
                this.f14028u.m5470a(this.f14009b);
            }
            RichVideoPlayerEventBus richVideoPlayerEventBus = this.f14009b;
            if (richVideoPlayerParams.f4962a != null) {
                str = richVideoPlayerParams.f4962a.f4833b;
            } else {
                str = null;
            }
            richVideoPlayerEventBus.m14878a(new RVPPlayerStateChangedEvent(str, this.f14028u.m5473b()));
        } finally {
            i = -2029992881;
            TracerDetour.a(-2029992881);
        }
    }

    @Nullable
    public RichVideoPlayerParams getRichVideoPlayerParams() {
        return this.f14027t;
    }

    public final void m14841g() {
        TracerDetour.a("RichVideoPlayer.unload", -1572593456);
        try {
            this.f14027t = null;
            this.f14003B = null;
            for (RichVideoPlayerPlugin b : this.f14014g) {
                b.mo394b();
            }
        } finally {
            TracerDetour.a(-370663081);
        }
    }

    public final boolean m14842h() {
        return this.f14027t != null;
    }

    @Nullable
    public String getVideoId() {
        if (this.f14027t == null || this.f14027t.f4962a == null) {
            return null;
        }
        return this.f14027t.f4962a.f4833b;
    }

    public void m14819a(EventTriggerType eventTriggerType, int i) {
        this.f14009b.m14878a(new RVPRequestPlayingEvent(eventTriggerType, i));
    }

    public final void m14818a(EventTriggerType eventTriggerType) {
        m14819a(eventTriggerType, -1);
    }

    public void m14832b(EventTriggerType eventTriggerType) {
        TracerDetour.a("RichVideoPlayer.pause", -406004552);
        try {
            this.f14009b.m14878a(new RVPRequestPausingEvent(eventTriggerType));
        } finally {
            TracerDetour.a(-1908542822);
        }
    }

    public final void m14817a(int i, EventTriggerType eventTriggerType) {
        if (!m14815u() || !this.f14013f.a(VideoAbTestGatekeepers.i, false)) {
            this.f14009b.m14878a(new RVPRequestSeekingEvent(i, eventTriggerType));
        }
    }

    public void m14830a(boolean z, EventTriggerType eventTriggerType) {
        if (this.f14028u != null) {
            this.f14028u.m5471a(z, eventTriggerType);
        }
    }

    public void setVolume(float f) {
        if (this.f14028u != null) {
            this.f14028u.f5121r.mo471a(f);
        }
    }

    public final void m14820a(VideoResolution videoResolution, EventTriggerType eventTriggerType) {
        this.f14028u.m5468a(videoResolution, eventTriggerType);
    }

    protected void setUseOneVideoPolicy(boolean z) {
        this.f14026s = z;
    }

    @Nullable
    public PlaybackController getPlaybackController() {
        return this.f14028u;
    }

    public final void m14823a(RichVideoPlayerScheduledRunnable richVideoPlayerScheduledRunnable) {
        this.f14028u.m5469a(richVideoPlayerScheduledRunnable);
    }

    public final void m14833b(RichVideoPlayerScheduledRunnable richVideoPlayerScheduledRunnable) {
        PlaybackController playbackController = this.f14028u;
        HandlerDetour.a(playbackController.f5127x, richVideoPlayerScheduledRunnable);
        playbackController.f5128y.remove(richVideoPlayerScheduledRunnable);
    }

    public PlayerOrigin getPlayerOrigin() {
        return this.f14031x;
    }

    public void setOriginalPlayReason(EventTriggerType eventTriggerType) {
        this.f14002A = eventTriggerType;
        if (this.f14028u != null) {
            this.f14028u.m5474b(eventTriggerType);
        }
    }

    public void setPlayerType(PlayerType playerType) {
        this.f14032y = playerType;
        if (this.f14028u != null) {
            this.f14028u.m5466a(playerType);
        }
    }

    public void setPlayerOrigin(PlayerOrigin playerOrigin) {
        this.f14031x = playerOrigin;
        if (this.f14028u != null) {
            this.f14028u.m5465a(playerOrigin);
        }
    }

    public void setChannelEligibility(ChannelEligibility channelEligibility) {
        this.f14033z = channelEligibility;
        if (this.f14028u != null) {
            this.f14028u.m5462a(channelEligibility);
        }
    }

    private void m14805b(RichVideoPlayerPlugin richVideoPlayerPlugin) {
        richVideoPlayerPlugin.mo392a(this);
        richVideoPlayerPlugin.setEventBus(this.f14009b);
        if (richVideoPlayerPlugin instanceof VideoPlugin) {
            this.f14014g.add(0, richVideoPlayerPlugin);
        } else {
            this.f14014g.add(richVideoPlayerPlugin);
        }
    }

    private void m14809c(RichVideoPlayerPlugin richVideoPlayerPlugin) {
        Preconditions.checkNotNull(richVideoPlayerPlugin);
        if (richVideoPlayerPlugin instanceof VideoPlugin) {
            m14805b(richVideoPlayerPlugin);
            this.f14015h = (VideoPlugin) richVideoPlayerPlugin;
            setInnerResource(2131560327);
            return;
        }
        m14805b(richVideoPlayerPlugin);
    }

    public final void m14825a(RichVideoPlayerPlugin richVideoPlayerPlugin) {
        m14809c(richVideoPlayerPlugin);
    }

    @Nullable
    public final <T extends RichVideoPlayerPlugin> T m14816a(Class<T> cls) {
        for (RichVideoPlayerPlugin richVideoPlayerPlugin : this.f14014g) {
            if (cls.isInstance(richVideoPlayerPlugin)) {
                return richVideoPlayerPlugin;
            }
        }
        return null;
    }

    public final boolean m14843i() {
        boolean b = m14835b(VideoPlugin.class);
        if (b) {
            this.f14014g.removeAll(Collections.singleton(null));
        }
        return b;
    }

    public final boolean m14835b(Class cls) {
        for (int i = 0; i < this.f14014g.size(); i++) {
            RichVideoPlayerPlugin richVideoPlayerPlugin = (RichVideoPlayerPlugin) this.f14014g.get(i);
            if (cls.isInstance(richVideoPlayerPlugin)) {
                richVideoPlayerPlugin.mo394b();
                this.f14014g.remove(i);
                richVideoPlayerPlugin.em_();
                richVideoPlayerPlugin.mo395b(this);
                if (richVideoPlayerPlugin instanceof VideoPlugin) {
                    this.f14015h = null;
                }
                return true;
            }
        }
        return false;
    }

    public final void m14828a(@Nullable List<RichVideoPlayerPlugin> list) {
        if (list != null && !list.isEmpty()) {
            for (RichVideoPlayerPlugin a : list) {
                m14825a(a);
            }
        }
    }

    public void setPluginEnvironment(AnyPlayerEnvironment anyPlayerEnvironment) {
        for (RichVideoPlayerPlugin richVideoPlayerPlugin : this.f14014g) {
            if (richVideoPlayerPlugin instanceof RichVideoPlayerPluginWithEnv) {
                ((RichVideoPlayerPluginWithEnv) richVideoPlayerPlugin).setEnvironment(anyPlayerEnvironment);
            }
        }
    }

    public final List<RichVideoPlayerPlugin> m14831b(List<Class> list) {
        Collection arrayList = new ArrayList();
        List<RichVideoPlayerPlugin> arrayList2 = new ArrayList();
        for (RichVideoPlayerPlugin richVideoPlayerPlugin : this.f14014g) {
            if (list.contains(richVideoPlayerPlugin.getClass())) {
                arrayList.add(richVideoPlayerPlugin);
            } else {
                if (richVideoPlayerPlugin instanceof VideoPlugin) {
                    this.f14015h = null;
                }
                richVideoPlayerPlugin.mo394b();
                richVideoPlayerPlugin.em_();
                richVideoPlayerPlugin.mo395b(this);
                arrayList2.add(richVideoPlayerPlugin);
            }
        }
        this.f14014g.clear();
        this.f14014g.addAll(arrayList);
        return arrayList2;
    }

    public final List<RichVideoPlayerPlugin> m14844j() {
        return m14831b(Collections.EMPTY_LIST);
    }

    public final List<RichVideoPlayerPlugin> m14845k() {
        this.f14030w = null;
        List<RichVideoPlayerPlugin> arrayList = new ArrayList();
        for (RichVideoPlayerPlugin richVideoPlayerPlugin : this.f14014g) {
            if (!(richVideoPlayerPlugin instanceof VideoPlugin)) {
                richVideoPlayerPlugin.mo394b();
                richVideoPlayerPlugin.em_();
                richVideoPlayerPlugin.mo395b(this);
                arrayList.add(richVideoPlayerPlugin);
            }
        }
        this.f14014g.clear();
        if (this.f14015h != null) {
            this.f14014g.add(this.f14015h);
        }
        return arrayList;
    }

    public int getCurrentPositionMs() {
        return this.f14028u == null ? 0 : this.f14028u.m5477f();
    }

    public int getLastStartPosition() {
        return this.f14028u == null ? 0 : this.f14028u.m5486p();
    }

    public int getVideoDurationMs() {
        return this.f14028u == null ? 0 : this.f14028u.m5479h();
    }

    public final boolean m14846l() {
        if (this.f14028u == null) {
            return false;
        }
        return this.f14028u.f5115l == State.ERROR;
    }

    public final boolean m14847m() {
        return this.f14028u == null ? false : this.f14028u.m5480i();
    }

    public final boolean m14848n() {
        return this.f14028u == null ? false : this.f14028u.m5481k();
    }

    public final boolean m14849o() {
        return this.f14028u == null ? false : this.f14028u.m5482l();
    }

    public final boolean m14850p() {
        return this.f14028u == null ? false : this.f14028u.m5483m();
    }

    @Nullable
    public State getPlayerState() {
        return this.f14028u == null ? null : this.f14028u.f5115l;
    }

    public float getPlaybackPercentage() {
        int videoDurationMs = getVideoDurationMs();
        if (videoDurationMs <= 0) {
            return 0.0f;
        }
        return ((float) getCurrentPositionMs()) / ((float) videoDurationMs);
    }

    public void setShouldCropToFit(boolean z) {
        Preconditions.checkNotNull(this.f14015h);
        this.f14015h.f14082c = z;
    }

    public void setCropRect(RectF rectF) {
        Preconditions.checkNotNull(this.f14015h);
        this.f14015h.setCropRect(rectF);
    }

    public RichVideoPlayerCallbackListener getRichVideoPlayerCallbackListener() {
        return this.f14029v;
    }

    public void setRichVideoPlayerCallbackListener(RichVideoPlayerCallbackListener richVideoPlayerCallbackListener) {
        this.f14029v = richVideoPlayerCallbackListener;
    }

    @Nullable
    public FbDraweeView getCoverImage() {
        if (this.f14030w != null) {
            return this.f14030w;
        }
        for (RichVideoPlayerPlugin richVideoPlayerPlugin : this.f14014g) {
            if (richVideoPlayerPlugin instanceof BaseCoverImagePlugin) {
                this.f14030w = ((BaseCoverImagePlugin) richVideoPlayerPlugin).f14158a;
                break;
            }
        }
        return this.f14030w;
    }

    public void setVideoPluginAlignment(VideoPluginAlignment videoPluginAlignment) {
        this.f14015h.setVideoPluginAlignment(videoPluginAlignment);
    }

    public final void m14822a(RichVideoPlayerParams richVideoPlayerParams, ImmutableList<Class<? extends RichVideoPlayerPlugin>> immutableList, boolean z) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            RichVideoPlayerPlugin a = m14816a((Class) immutableList.get(i));
            if (a != null) {
                if (z) {
                    a.mo394b();
                }
                a.mo393a(this.f14028u, this, richVideoPlayerParams);
            }
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f14009b.m14878a(new RVPOrientationChangedEvent(configuration.orientation));
    }

    public final void m14827a(String str, String str2) {
        this.f14009b.m14878a(new RVPVideoSpecUpdateEvent(str, str2));
    }

    public final void m14851q() {
        this.f14009b.m14878a(new RVPDialogEvent(true));
    }

    public final void m14852r() {
        this.f14009b.m14878a(new RVPDialogEvent(false));
    }

    public final void m14853s() {
        this.f14009b.m14878a(new RVPActivityDialogEvent());
    }

    public final void m14824a(RichVideoPlayerEventSubscriber richVideoPlayerEventSubscriber) {
        this.f14009b.a(richVideoPlayerEventSubscriber);
    }

    public final void m14834b(RichVideoPlayerEventSubscriber richVideoPlayerEventSubscriber) {
        this.f14009b.b(richVideoPlayerEventSubscriber);
    }

    public final void m14838d(int i) {
        Preconditions.checkState(i > 0);
        this.f14022o.m14885a(i);
    }

    @Nullable
    @VisibleForTesting
    public VideoPlugin getVideoPlugin() {
        return this.f14015h;
    }

    private boolean m14815u() {
        return (this.f14027t == null || this.f14027t.f4962a == null || !this.f14027t.f4962a.f4839h) ? false : true;
    }
}
