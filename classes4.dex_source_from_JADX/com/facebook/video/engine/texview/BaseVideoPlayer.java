package com.facebook.video.engine.texview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.Surface;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.MonotonicClock;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.StallTimeCalculation;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.analytics.VideoAnalytics.StreamingFormat;
import com.facebook.video.api.VideoMetadata;
import com.facebook.video.engine.NativePlayerPool;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoEngineUtils;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayer;
import com.facebook.video.engine.VideoPlayer.PlayerState;
import com.facebook.video.engine.VideoPlayerListener;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerViewProvider;
import com.facebook.video.engine.texview.VideoSurfaceTarget.C02403;
import com.facebook.video.engine.texview.VideoSurfaceTarget.SurfaceListener;
import com.facebook.video.server.BytesViewedLogger;
import com.facebook.video.subtitles.controller.SubtitleAdapter;
import com.facebook.video.subtitles.controller.SubtitleListener;
import com.facebook.video.subtitles.controller.Subtitles;
import com.facebook.video.subtitles.controller.compat.CustomSubtitleAdapter;
import com.google.android.exoplayer.chunk.Format;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableEnumSet;
import com.google.common.collect.ImmutableSet;
import java.util.EnumSet;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: pending_media_uploads */
public abstract class BaseVideoPlayer implements VideoPlayer {
    protected static final ImmutableSet<EventTriggerType> f5208a = ImmutableEnumSet.m5775a(EnumSet.of(EventTriggerType.BY_ANDROID, new EventTriggerType[]{EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION}));
    public int f5209A = -1;
    protected int f5210B;
    protected PlayPosition f5211C;
    public PlayerState f5212D = PlayerState.STATE_IDLE;
    protected PlayerState f5213E = PlayerState.STATE_IDLE;
    protected VideoMetadata f5214F;
    public String f5215G;
    protected Bitmap f5216H;
    public Surface f5217I;
    public VideoPlayerParams f5218J;
    public long f5219K = -1;
    public boolean f5220L = false;
    public EventTriggerType f5221M = EventTriggerType.BY_USER;
    protected StallTimeCalculation f5222N;
    protected StallTimeCalculation f5223O;
    protected StreamingFormat f5224P = StreamingFormat.PROGRESSIVE_DOWNLOAD;
    protected int f5225Q = 0;
    public EventTriggerType f5226R;
    protected StreamSourceType f5227S = StreamSourceType.FROM_STREAM;
    public SurfaceState f5228T = SurfaceState.STATE_UNKNOWN;
    protected Format f5229U = null;
    protected final Context f5230b;
    protected final AttributeSet f5231c;
    protected final int f5232d;
    protected final VideoSurfaceProvider f5233e;
    public final VideoPlayerListener f5234f;
    public final VideoLoggingUtils f5235g;
    public final CustomSubtitleAdapter f5236h;
    public final SubtitleListener f5237i;
    protected final Lazy<NativePlayerPool> f5238j;
    protected final ScheduledExecutorService f5239k;
    public final DefaultAndroidThreadUtil f5240l;
    public final MonotonicClock f5241m;
    protected final BytesViewedLogger f5242n;
    protected final VideoEngineUtils f5243o;
    protected final InitializationSequenceLogger f5244p;
    public final TypedEventBus f5245q = new TypedEventBus();
    protected final QeAccessor f5246r;
    public final VideoLivePlaybackConfig f5247s;
    protected final Boolean f5248t;
    protected final boolean f5249u;
    protected final GatekeeperStoreImpl f5250v;
    public PlayerOrigin f5251w = PlayerOrigin.UNKNOWN;
    protected ChannelEligibility f5252x = ChannelEligibility.NO_INFO;
    public PlayerType f5253y = PlayerType.INLINE_PLAYER;
    public EventTriggerType f5254z = EventTriggerType.BY_USER;

    /* compiled from: pending_media_uploads */
    public enum SurfaceState {
        STATE_UNKNOWN("unknown"),
        STATE_CREATED("created"),
        STATE_UPDATED("updated"),
        STATE_DESTROYED("destroyed");
        
        public final String value;

        private SurfaceState(String str) {
            this.value = str;
        }
    }

    /* compiled from: pending_media_uploads */
    public enum ReleaseCaller {
        EXTERNAL("external"),
        FROM_BIND("from_bind"),
        FROM_ONCOMPLETE("from_oncomplete"),
        FROM_ERROR("from_error"),
        FROM_DESTROY_SURFACE("from_surface_destroy"),
        FROM_RESET("from_reset"),
        FROM_PREPARE("from_prepare"),
        FROM_SET_VIDEO_RESOLUTION("from_set_video_resolution");
        
        public final String value;

        private ReleaseCaller(String str) {
            this.value = str;
        }
    }

    /* compiled from: pending_media_uploads */
    public class VideoSurfaceListener implements SurfaceListener {
        final /* synthetic */ BaseVideoPlayer f5625a;

        public VideoSurfaceListener(BaseVideoPlayer baseVideoPlayer) {
            this.f5625a = baseVideoPlayer;
        }

        public final void mo517a(Surface surface) {
            this.f5625a.mo484a("VideoSurfaceTarget::onSurfaceAvailable", new Object[0]);
            this.f5625a.mo488b(surface);
            this.f5625a.f5228T = SurfaceState.STATE_CREATED;
        }

        public final void mo518a(C02403 c02403) {
            this.f5625a.mo484a("VideoSurfaceTarget::onSurfaceUnavailable", new Object[0]);
            if (this.f5625a.mo506i()) {
                this.f5625a.mo490c(EventTriggerType.BY_PLAYER);
            }
            this.f5625a.mo498w();
            this.f5625a.mo480a(ReleaseCaller.FROM_DESTROY_SURFACE);
            this.f5625a.f5217I = null;
            this.f5625a.f5228T = SurfaceState.STATE_DESTROYED;
            c02403.m6168a();
        }

        public final void mo516a() {
            this.f5625a.mo497v();
        }

        public final void mo519b() {
            this.f5625a.f5219K = this.f5625a.f5241m.now();
            if (this.f5625a.f5220L) {
                this.f5625a.f5235g.a(this.f5625a.f5253y.value, this.f5625a.f5218J.f4833b, this.f5625a.f5251w, this.f5625a.f5254z.value, this.f5625a.mo496r());
                this.f5625a.f5220L = false;
                this.f5625a.f5228T = SurfaceState.STATE_UPDATED;
                if (this.f5625a.f5218J.f4839h && this.f5625a.f5247s.x) {
                    this.f5625a.f5210B = this.f5625a.mo487b();
                    this.f5625a.mo484a("ResetLastStartPos: %d", Integer.valueOf(this.f5625a.f5210B));
                }
                this.f5625a.mo532u();
            }
        }
    }

    protected abstract void mo470B();

    protected abstract void mo475a(EventTriggerType eventTriggerType, int i);

    protected abstract void mo480a(ReleaseCaller releaseCaller);

    protected abstract void mo484a(String str, Object... objArr);

    protected abstract void mo488b(Surface surface);

    @VisibleForTesting
    protected abstract void mo494g(EventTriggerType eventTriggerType);

    protected abstract void mo497v();

    protected abstract void mo498w();

    public BaseVideoPlayer(Context context, AttributeSet attributeSet, int i, VideoPlayerViewProvider videoPlayerViewProvider, Lazy<NativePlayerPool> lazy, VideoPlayerListener videoPlayerListener, SubtitleListener subtitleListener, SubtitleAdapter subtitleAdapter, ScheduledExecutorService scheduledExecutorService, AndroidThreadUtil androidThreadUtil, Boolean bool, boolean z, MonotonicClock monotonicClock, InitializationSequenceLogger initializationSequenceLogger, VideoEngineUtils videoEngineUtils, BytesViewedLogger bytesViewedLogger, VideoLoggingUtils videoLoggingUtils, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, VideoLivePlaybackConfig videoLivePlaybackConfig) {
        this.f5230b = context;
        this.f5231c = attributeSet;
        this.f5232d = i;
        this.f5233e = videoPlayerViewProvider;
        this.f5234f = videoPlayerListener;
        this.f5235g = videoLoggingUtils;
        this.f5236h = subtitleAdapter;
        this.f5237i = subtitleListener;
        this.f5239k = scheduledExecutorService;
        this.f5240l = androidThreadUtil;
        this.f5248t = bool;
        this.f5249u = z;
        this.f5241m = monotonicClock;
        this.f5244p = initializationSequenceLogger;
        this.f5243o = videoEngineUtils;
        this.f5242n = bytesViewedLogger;
        this.f5238j = lazy;
        this.f5246r = qeAccessor;
        this.f5250v = gatekeeperStore;
        this.f5247s = videoLivePlaybackConfig;
    }

    public final void mo500a(PlayerOrigin playerOrigin) {
        this.f5251w = playerOrigin;
    }

    public final PlayerOrigin mo504g() {
        return this.f5251w;
    }

    public void mo501a(PlayerType playerType) {
        this.f5253y = playerType;
        this.f5244p.f5159g = ((PlayerType) Preconditions.checkNotNull(playerType)).value;
    }

    public final void mo499a(ChannelEligibility channelEligibility) {
        this.f5252x = channelEligibility;
    }

    public final void mo502d(EventTriggerType eventTriggerType) {
        this.f5254z = eventTriggerType;
    }

    public final boolean mo505h() {
        return this.f5212D == PlayerState.STATE_PREPARING && this.f5213E == PlayerState.STATE_PLAYING;
    }

    public final boolean mo506i() {
        return this.f5213E == PlayerState.STATE_PLAYING;
    }

    public final boolean mo507j() {
        return this.f5213E == PlayerState.STATE_IDLE || this.f5213E == PlayerState.STATE_PAUSED;
    }

    public final int mo508l() {
        return this.f5209A;
    }

    public final int mo509m() {
        int i;
        if (this.f5209A > 0) {
            i = this.f5209A;
        } else {
            i = 0;
        }
        return VideoEngineUtils.a(this.f5210B, 0, i);
    }

    public final TypedEventBus mo513q() {
        return this.f5245q;
    }

    public final VideoMetadata mo512p() {
        return this.f5214F;
    }

    public final Subtitles mo511o() {
        this.f5215G = "getSubtitles";
        return this.f5236h.f5194b;
    }

    public final void mo510n() {
        if (this.f5216H != null) {
            this.f5216H.recycle();
            this.f5216H = null;
        }
    }

    protected void mo532u() {
        if (this.f5234f != null) {
            this.f5234f.mo456c(this.f5221M);
        }
    }

    public void m5708a(final PlayerState playerState) {
        this.f5212D = playerState;
        if (this.f5234f != null) {
            this.f5240l.b(new Runnable(this) {
                final /* synthetic */ BaseVideoPlayer f5272b;

                public void run() {
                    this.f5272b.f5234f.mo450a(playerState);
                }
            });
        }
    }

    public final void m5713b(final PlayerState playerState) {
        if (playerState == PlayerState.STATE_PLAYING) {
            Preconditions.checkNotNull(this.f5211C, "Play position must be set");
        }
        this.f5213E = playerState;
        this.f5240l.b(new Runnable(this) {
            final /* synthetic */ BaseVideoPlayer f5274b;

            public void run() {
                this.f5274b.f5234f.mo455b(playerState);
            }
        });
    }

    protected final String m5734x() {
        String str = "";
        if (this.f5229U != null) {
            str = StringFormatUtil.formatStrLocaleSafe("bitrate: %dkbps, w: %d, h: %d", Integer.valueOf(this.f5229U.c / 1000), Integer.valueOf(this.f5229U.d), Integer.valueOf(this.f5229U.e));
        }
        mo484a("Current dash stream is: %s", str);
        return str;
    }

    protected final boolean m5735y() {
        return m5711a(false);
    }

    protected final boolean m5711a(boolean z) {
        return (this.f5218J.f4839h && this.f5247s.b && !z) ? false : true;
    }

    protected final void m5736z() {
        this.f5235g.a(this.f5218J.f4836e, this.f5253y.value, this.f5224P.value, (this.f5218J.f4839h ? mo487b() : this.f5218J.f4834c) - this.f5225Q, this.f5210B, this.f5218J.f4833b, this.f5251w, this.f5254z.value, mo496r(), this.f5218J.f4837f, this.f5223O, this.f5218J);
        this.f5225Q = 0;
    }

    protected final void m5702A() {
        String str = null;
        if (this.f5228T.equals(SurfaceState.STATE_CREATED) && this.f5220L) {
            str = "never_updated";
        } else if (this.f5219K != -1 && this.f5241m.now() - this.f5219K > 500) {
            str = "playback_stuck";
        }
        if (str != null) {
            this.f5235g.a(str, this.f5253y.value, this.f5218J.f4833b, this.f5251w, this.f5254z.value, mo496r());
        }
    }

    public long mo515t() {
        return -1;
    }

    public void mo490c(EventTriggerType eventTriggerType) {
        this.f5220L = false;
    }

    public int mo514s() {
        return mo487b();
    }

    public final synchronized void mo503e(EventTriggerType eventTriggerType) {
        if (this.f5218J.m5255a()) {
            mo484a("forceLiveVideoToEnd", new Object[0]);
            if (this.f5222N != null) {
                this.f5222N.e();
            }
            if (this.f5212D == PlayerState.STATE_PREPARING) {
                m5708a(PlayerState.STATE_PREPARED);
                mo475a(eventTriggerType, mo487b());
                mo470B();
            }
        }
    }

    protected void mo531f(EventTriggerType eventTriggerType) {
        if (this.f5222N != null) {
            this.f5222N.c();
        }
        this.f5235g.a(this.f5218J.f4836e, this.f5253y.value, this.f5224P.value, eventTriggerType.value, mo487b(), this.f5227S.value, this.f5218J.f4833b, this.f5251w, null, this.f5254z.value, mo496r(), this.f5218J.f4837f, this.f5222N, this.f5218J);
        this.f5226R = eventTriggerType;
        m5713b(PlayerState.STATE_IDLE);
    }
}
