package com.facebook.video.player;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.katana.app.module.Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.video.abtest.DirectPlayConfig;
import com.facebook.video.analytics.FullScreenStartedPlayingInfo;
import com.facebook.video.analytics.StallTimeCalculation;
import com.facebook.video.analytics.SuggestedVideoInfo;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.analytics.VideoAnalyticsRequiredInfo;
import com.facebook.video.analytics.VideoDataSourceInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.analytics.VideoPlayerInfo;
import com.facebook.video.analytics.VideoStallTimeInfo;
import com.facebook.video.analytics.VideoTimeSpentInfo;
import com.facebook.video.api.AsyncVideo.PlayCancelledEvent;
import com.facebook.video.api.AsyncVideo.PlayPausedEvent;
import com.facebook.video.api.AsyncVideo.PlayRequestedEvent;
import com.facebook.video.api.AsyncVideo.PlayStartedEvent;
import com.facebook.video.api.UserReason;
import com.facebook.video.api.VideoEvents.BufferingEndEvent;
import com.facebook.video.api.VideoEvents.StartingEvent;
import com.facebook.video.api.VideoReason;
import com.facebook.video.api.playersession.VideoPlayerSessionBase.SessionState;
import com.facebook.video.api.playersession.VideoPlayerSessionManager;
import com.facebook.video.engine.DelayedCompletionHandler.DelayedCompletionListener;
import com.facebook.video.engine.DirectPlayPreparerProvider;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerManager;
import com.facebook.video.events.VideoFullScreenEventBus;
import com.facebook.video.events.VideoFullScreenEvents.EnterFullScreenEvent;
import com.facebook.video.events.VideoFullScreenEvents.ExitFullScreenEvent;
import com.facebook.video.player.VideoSpecText.VideoSpecParam;
import com.facebook.video.server.BytesViewedLogger;
import com.facebook.video.server.VideoPlayerSessionManagerMethodAutoProvider;
import com.facebook.video.server.VideoResourceMetadata;
import com.facebook.video.server.VideoServer;
import com.facebook.video.settings.VideoPrefs;
import com.facebook.video.subtitles.controller.SubtitleMediaTimeProvider;
import com.facebook.video.subtitles.controller.Subtitles;
import com.facebook.video.subtitles.views.FbSubtitleView;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.SettableFuture;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

@Deprecated
/* compiled from: composer_pause */
public class FullScreenVideoPlayer extends CustomRelativeLayout {
    private static final Class<?> f19060N = FullScreenVideoPlayer.class;
    private static final CallerContext f19061O = CallerContext.a(FullScreenVideoPlayer.class, "video_cover");
    protected boolean f19062A = false;
    protected int f19063B;
    protected int f19064C = 0;
    protected VideoPlayerInfo f19065D = new VideoPlayerInfo(PlayerType.FULL_SCREEN_PLAYER);
    protected Uri f19066E;
    protected StreamSourceType f19067F = StreamSourceType.FROM_STREAM;
    protected ImmutableList<VideoDataSource> f19068G;
    protected int f19069H = 0;
    protected int f19070I;
    protected int f19071J;
    protected LayoutParams f19072K;
    protected int f19073L;
    protected FullScreenParams f19074M;
    private boolean f19075P;
    public ImageView f19076Q;
    private ImageView f19077R;
    public WindowManager f19078S;
    private Executor f19079T;
    private AbstractFbErrorReporter f19080U;
    private FbSharedPreferences f19081V;
    private VideoPlayerManager f19082W;
    protected RelativeLayout f19083a;
    public SettableFuture<Void> aA;
    public View aB;
    private View aC;
    private Optional<AnimatorListener> aD = Absent.INSTANCE;
    public Optional<AnimatorListener> aE = Absent.INSTANCE;
    private boolean aF;
    private Optional<Rect> aG = Absent.INSTANCE;
    private int aH;
    private float aI = 0.0f;
    public OnDownloadPlaceholderAction aJ = OnDownloadPlaceholderAction.NOP;
    public AndroidVideoCompleteWorkaround aK;
    private VideoPlayerSessionManager aL;
    private ImageRequest aM;
    private ImageRequest aN;
    private FbDraweeControllerBuilder aO;
    private DynamicSecureBroadcastReceiver aP;
    private DirectPlayPreparerProvider aQ;
    private boolean aR = false;
    private DirectPlayConfig aS;
    private final AnimatorListener aT = new AnimatorListenerAdapter(this) {
        final /* synthetic */ FullScreenVideoPlayer f19027a;

        {
            this.f19027a = r1;
        }

        public void onAnimationEnd(Animator animator) {
            this.f19027a.f19076Q.setVisibility(4);
            this.f19027a.f19076Q.setAlpha(0.0f);
        }
    };
    private final VideoPlaceholderControllerListener aU = new VideoPlaceholderControllerListener(this);
    public final FutureAnimationListener aV = new FutureAnimationListener(this) {
        final /* synthetic */ FullScreenVideoPlayer f19029a;

        {
            this.f19029a = r1;
        }

        public void onAnimationStart(Animator animator) {
            this.f19029a.m27834l();
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f19029a.m27830h();
        }
    };
    public final AnimatorUpdateListener aW = new AnimatorUpdateListener(this) {
        final /* synthetic */ FullScreenVideoPlayer f19032a;

        {
            this.f19032a = r1;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f19032a.f19072K.width = ((Integer) valueAnimator.getAnimatedValue("width")).intValue();
            this.f19032a.f19072K.height = ((Integer) valueAnimator.getAnimatedValue("height")).intValue();
            this.f19032a.f19072K.leftMargin = ((Integer) valueAnimator.getAnimatedValue("left")).intValue();
            this.f19032a.f19072K.topMargin = ((Integer) valueAnimator.getAnimatedValue("top")).intValue();
            this.f19032a.f19072K.bottomMargin = this.f19032a.getHeight() - (this.f19032a.f19072K.topMargin + this.f19032a.f19072K.height);
            this.f19032a.f19087e.requestLayout();
        }
    };
    private AnimatorListener aX = new AnimatorListenerAdapter(this) {
        final /* synthetic */ FullScreenVideoPlayer f19035a;

        {
            this.f19035a = r1;
        }

        public void onAnimationEnd(Animator animator) {
            CustomViewUtils.b(this.f19035a, new ColorDrawable(this.f19035a.f19070I));
            this.f19035a.f19087e.setAlpha(1.0f);
            this.f19035a.m27835m();
            FullScreenVideoPlayer.m27818z(this.f19035a);
            FullScreenVideoPlayer.m27749D(this.f19035a);
            if (this.f19035a.ai) {
                if (this.f19035a.aj) {
                    this.f19035a.f19078S.removeViewImmediate(this.f19035a);
                    this.f19035a.aj = false;
                }
                this.f19035a.ai = false;
            }
        }
    };
    public final NewApiEventHandler aY = new NewApiEventHandler(this);
    private final AnonymousClass21 aZ = new Object(this) {
        final /* synthetic */ FullScreenVideoPlayer f19039a;

        {
            this.f19039a = r1;
        }

        public final void m27727a(EventTriggerType eventTriggerType) {
            this.f19039a.aw = eventTriggerType;
        }

        public final void m27728b(EventTriggerType eventTriggerType) {
            int videoViewCurrentPosition = this.f19039a.f19084b.getVideoViewCurrentPosition();
            this.f19039a.aK.m27635a();
            if (this.f19039a.f19084b.mo1425a()) {
                this.f19039a.f19100r.m27707c(eventTriggerType, videoViewCurrentPosition);
            }
            if (eventTriggerType == EventTriggerType.BY_USER) {
                this.f19039a.f19106x = false;
            }
            this.f19039a.m27835m();
            if (this.f19039a.ax >= 0) {
                videoViewCurrentPosition = this.f19039a.ax;
            }
            this.f19039a.az.a(new PlayStartedEvent(videoViewCurrentPosition, videoViewCurrentPosition, UserReason.b));
        }

        public final void m27729c(EventTriggerType eventTriggerType) {
            if (!this.f19039a.aY.f19055b) {
                int videoViewCurrentPosition = this.f19039a.f19084b.getVideoViewCurrentPosition();
                this.f19039a.az.a(new PlayPausedEvent(videoViewCurrentPosition, UserReason.b));
                this.f19039a.f19100r.m27701a(eventTriggerType, videoViewCurrentPosition, this.f19039a.f19106x);
            }
            if (eventTriggerType == EventTriggerType.BY_USER) {
                this.f19039a.f19106x = true;
            }
        }

        public final void m27726a(int i) {
            FullScreenLoggingPolicy fullScreenLoggingPolicy = this.f19039a.f19100r;
            int videoViewCurrentPosition = this.f19039a.f19084b.getVideoViewCurrentPosition();
            VideoTimeSpentInfo videoTimeSpentInfo = fullScreenLoggingPolicy.f18997b;
            videoTimeSpentInfo.c = videoViewCurrentPosition;
            videoTimeSpentInfo.d = i;
            fullScreenLoggingPolicy.f18996a.a(fullScreenLoggingPolicy.f18998c.a, fullScreenLoggingPolicy.f19003h.a.value, EventTriggerType.BY_USER.value, i, fullScreenLoggingPolicy.f18997b.c, fullScreenLoggingPolicy.f19002g.a, fullScreenLoggingPolicy.f19003h.b, fullScreenLoggingPolicy.f18998c.d);
            videoTimeSpentInfo = fullScreenLoggingPolicy.f18997b;
            videoTimeSpentInfo.b = videoTimeSpentInfo.c;
            fullScreenLoggingPolicy.f19000e.c = fullScreenLoggingPolicy.f18997b.b;
            this.f19039a.m27841u();
        }

        public final void m27725a() {
            boolean z;
            if (this.f19039a.f19074M.f19013f) {
                z = false;
            } else {
                z = true;
            }
            this.f19039a.f19074M.f19013f = z;
            this.f19039a.m27822a(z);
            this.f19039a.f19086d.m28040a(z);
        }
    };
    private AudioManager aa;
    private Subtitles ab;
    private boolean ac;
    private Window ad;
    private WindowManager.LayoutParams ae;
    private AutohideHandler af;
    public Lazy<NetworkMonitor> ag;
    public ErrorDialogs ah;
    public boolean ai = false;
    public boolean aj = false;
    private boolean ak = false;
    private VideoViewControlHandler al = new VideoViewControlHandler(this);
    private StubbedMediaController am;
    private boolean an = true;
    private ViewGroup ao;
    public boolean ap = true;
    private Rect aq;
    private FsSubtitleMediaTimeProvider ar = new FsSubtitleMediaTimeProvider(this);
    private final FullScreenVideoListenerDispatcher as = new FullScreenVideoListenerDispatcher(this);
    public FullScreenVideoListener at;
    public OnCompletionListener au;
    private int av;
    public EventTriggerType aw;
    public int ax = -1;
    private BytesViewedLogger ay;
    public TypedEventBus az;
    protected VideoViewController f19084b;
    protected View f19085c;
    protected VideoController f19086d;
    protected FbDraweeView f19087e;
    protected VideoSpecText f19088f;
    protected DefaultAndroidThreadUtil f19089g;
    protected FbSubtitleView f19090h;
    protected Uri f19091i;
    protected FullScreenChromeInteractionListener f19092j;
    protected VideoTimeSpentInfo f19093k = new VideoTimeSpentInfo();
    protected VideoFeedStoryInfo f19094l = new VideoFeedStoryInfo();
    protected SuggestedVideoInfo f19095m = new SuggestedVideoInfo();
    protected FullScreenStartedPlayingInfo f19096n = new FullScreenStartedPlayingInfo();
    protected VideoDataSourceInfo f19097o = new VideoDataSourceInfo();
    protected VideoAnalyticsRequiredInfo f19098p = new VideoAnalyticsRequiredInfo();
    protected VideoStallTimeInfo f19099q = new VideoStallTimeInfo();
    protected FullScreenLoggingPolicy f19100r;
    protected VideoLoggingUtils f19101s;
    protected MonotonicClock f19102t;
    protected AbstractFbErrorReporter f19103u;
    protected VideoFullScreenEventBus f19104v;
    protected boolean f19105w = false;
    protected boolean f19106x = false;
    protected boolean f19107y;
    public boolean f19108z = false;

    /* compiled from: composer_pause */
    public class FutureAnimationListener extends AnimatorListenerAdapter {
        public SettableFuture<Void> f19028a;

        public final FutureAnimationListener m27724a(SettableFuture<Void> settableFuture) {
            this.f19028a = settableFuture;
            return this;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f19028a.isDone()) {
                FutureDetour.a(this.f19028a, null, -37670381);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f19028a.a(new AnimationCanceledException());
        }
    }

    /* compiled from: composer_pause */
    class C14131 implements OnPreparedListener {
        final /* synthetic */ FullScreenVideoPlayer f19037a;

        C14131(FullScreenVideoPlayer fullScreenVideoPlayer) {
            this.f19037a = fullScreenVideoPlayer;
        }

        public void onPrepared(final MediaPlayer mediaPlayer) {
            if (this.f19037a.f19105w) {
                this.f19037a.f19089g.a(this.f19037a.aA, new FutureCallback<Void>(this) {
                    final /* synthetic */ C14131 f19022b;

                    public void onSuccess(Object obj) {
                        this.f19022b.f19037a.m27827e();
                    }

                    public void onFailure(Throwable th) {
                        this.f19022b.f19037a.m27827e();
                    }
                });
                return;
            }
            this.f19037a.m27827e();
            this.f19037a.f19088f.m28055a(this.f19037a.f19084b.getMetadata());
        }
    }

    /* compiled from: composer_pause */
    class C14142 implements OnClickListener {
        final /* synthetic */ FullScreenVideoPlayer f19041a;

        C14142(FullScreenVideoPlayer fullScreenVideoPlayer) {
            this.f19041a = fullScreenVideoPlayer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2016060802);
            this.f19041a.m27829g();
            Logger.a(2, EntryType.UI_INPUT_END, -1072956134, a);
        }
    }

    /* compiled from: composer_pause */
    class C14153 implements OnCompletionListener {
        final /* synthetic */ FullScreenVideoPlayer f19042a;

        C14153(FullScreenVideoPlayer fullScreenVideoPlayer) {
            this.f19042a = fullScreenVideoPlayer;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            if (this.f19042a.f19062A) {
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
                return;
            }
            this.f19042a.m27828f();
            if (this.f19042a.au != null) {
                this.f19042a.au.onCompletion(mediaPlayer);
            }
            this.f19042a.az.a(new PlayPausedEvent(this.f19042a.f19063B, VideoReason.a));
            if (this.f19042a.ap) {
                this.f19042a.m27824a(EventTriggerType.BY_PLAYER);
            }
        }
    }

    /* compiled from: composer_pause */
    class C14164 implements DelayedCompletionListener {
        final /* synthetic */ FullScreenVideoPlayer f19043a;

        C14164(FullScreenVideoPlayer fullScreenVideoPlayer) {
            this.f19043a = fullScreenVideoPlayer;
        }

        public final void m27730a(int i) {
            this.f19043a.m27824a(EventTriggerType.BY_PLAYER);
            if (this.f19043a.au != null) {
                this.f19043a.au.onCompletion(null);
            }
        }
    }

    /* compiled from: composer_pause */
    class C14175 implements OnErrorListener {
        final /* synthetic */ FullScreenVideoPlayer f19044a;

        C14175(FullScreenVideoPlayer fullScreenVideoPlayer) {
            this.f19044a = fullScreenVideoPlayer;
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            return this.f19044a.m27823a(mediaPlayer, i, i2);
        }
    }

    /* compiled from: composer_pause */
    class C14186 implements FullScreenChromeInteractionListener {
        boolean f19045a = false;
        final /* synthetic */ FullScreenVideoPlayer f19046b;

        C14186(FullScreenVideoPlayer fullScreenVideoPlayer) {
            this.f19046b = fullScreenVideoPlayer;
        }

        public final void mo1449a() {
            this.f19046b.m27825b();
            this.f19045a = true;
        }

        public final void mo1450a(boolean z) {
            if (!this.f19045a || (this.f19045a && z)) {
                this.f19046b.m27819a();
                this.f19045a = false;
            }
        }
    }

    /* compiled from: composer_pause */
    class C14197 implements Runnable {
        final /* synthetic */ FullScreenVideoPlayer f19047a;

        C14197(FullScreenVideoPlayer fullScreenVideoPlayer) {
            this.f19047a = fullScreenVideoPlayer;
        }

        public void run() {
            this.f19047a.f19084b.mo1433c().getLeft();
            this.f19047a.f19084b.mo1433c().getTop();
            this.f19047a.f19084b.mo1433c().getWidth();
            this.f19047a.f19084b.mo1433c().getHeight();
        }
    }

    /* compiled from: composer_pause */
    class C14208 implements Runnable {
        final /* synthetic */ FullScreenVideoPlayer f19048a;

        C14208(FullScreenVideoPlayer fullScreenVideoPlayer) {
            this.f19048a = fullScreenVideoPlayer;
        }

        public void run() {
            this.f19048a.m27836n();
        }
    }

    /* compiled from: composer_pause */
    class C14219 implements Runnable {
        final /* synthetic */ FullScreenVideoPlayer f19049a;

        C14219(FullScreenVideoPlayer fullScreenVideoPlayer) {
            this.f19049a = fullScreenVideoPlayer;
        }

        public void run() {
            this.f19049a.m27836n();
        }
    }

    /* compiled from: composer_pause */
    class AnimationCanceledException extends RuntimeException {
    }

    /* compiled from: composer_pause */
    class AutohideHandler extends Handler {
        private final WeakReference<FullScreenVideoPlayer> f19050a;

        public AutohideHandler(FullScreenVideoPlayer fullScreenVideoPlayer) {
            this.f19050a = new WeakReference(fullScreenVideoPlayer);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    FullScreenVideoPlayer fullScreenVideoPlayer = (FullScreenVideoPlayer) this.f19050a.get();
                    if (fullScreenVideoPlayer != null) {
                        fullScreenVideoPlayer.m27826c();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: composer_pause */
    class FsSubtitleMediaTimeProvider implements SubtitleMediaTimeProvider {
        private final WeakReference<FullScreenVideoPlayer> f19051a;

        public FsSubtitleMediaTimeProvider(FullScreenVideoPlayer fullScreenVideoPlayer) {
            this.f19051a = new WeakReference(fullScreenVideoPlayer);
        }

        public final int m27733a() {
            FullScreenVideoPlayer fullScreenVideoPlayer = (FullScreenVideoPlayer) this.f19051a.get();
            if (fullScreenVideoPlayer != null) {
                return fullScreenVideoPlayer.getCurrentMediaTime();
            }
            return 0;
        }
    }

    /* compiled from: composer_pause */
    final class FullScreenVideoListenerDispatcher {
        final /* synthetic */ FullScreenVideoPlayer f19052a;
        private final Set<FullScreenVideoListener> f19053b;

        public FullScreenVideoListenerDispatcher(FullScreenVideoPlayer fullScreenVideoPlayer) {
            this.f19052a = fullScreenVideoPlayer;
            this.f19053b = new CopyOnWriteArraySet();
        }

        public final void m27734a(EventTriggerType eventTriggerType, int i) {
            for (FullScreenVideoListener a : this.f19053b) {
                a.a(eventTriggerType);
            }
            if (this.f19052a.at != null) {
                this.f19052a.at.a(eventTriggerType);
            }
        }

        public final void m27735a(EventTriggerType eventTriggerType, ExitFullScreenResult exitFullScreenResult) {
            for (FullScreenVideoListener a : this.f19053b) {
                a.a(eventTriggerType, exitFullScreenResult);
            }
            if (this.f19052a.at != null) {
                this.f19052a.at.a(eventTriggerType, exitFullScreenResult);
            }
        }
    }

    /* compiled from: composer_pause */
    public class NewApiEventHandler implements TypedHandler, PlayCancelledEvent.Handler, PlayRequestedEvent.Handler, BufferingEndEvent.Handler, StartingEvent.Handler {
        final /* synthetic */ FullScreenVideoPlayer f19054a;
        public boolean f19055b;
        private int f19056c;

        public NewApiEventHandler(FullScreenVideoPlayer fullScreenVideoPlayer) {
            this.f19054a = fullScreenVideoPlayer;
        }

        public final boolean m27741c() {
            return this.f19055b;
        }

        public final void m27737a(PlayRequestedEvent playRequestedEvent) {
            this.f19055b = true;
            this.f19056c = playRequestedEvent.b;
            this.f19054a.f19100r.m27700a(this.f19054a.aw, playRequestedEvent.b, null);
        }

        public final void m27739a(StartingEvent startingEvent) {
            this.f19055b = false;
            this.f19054a.f19100r.m27705b(this.f19054a.aw, startingEvent.b);
        }

        public final void m27736a() {
            if (this.f19055b) {
                this.f19055b = false;
                this.f19054a.f19100r.m27699a(this.f19054a.aw, this.f19056c);
            }
        }

        public final void m27740b() {
            this.f19054a.m27833k();
        }

        public final void mo1401a(BufferingEndEvent bufferingEndEvent) {
            this.f19054a.m27834l();
        }
    }

    /* compiled from: composer_pause */
    public enum OnDownloadPlaceholderAction {
        ENTER_ANIMATE,
        POSITION,
        NOP
    }

    /* compiled from: composer_pause */
    class VideoPlaceholderControllerListener extends BaseControllerListener {
        boolean f19057a;
        final /* synthetic */ FullScreenVideoPlayer f19058b;

        public VideoPlaceholderControllerListener(FullScreenVideoPlayer fullScreenVideoPlayer) {
            this.f19058b = fullScreenVideoPlayer;
            this.f19057a = false;
        }

        public final /* synthetic */ void m27742a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            m27743b();
        }

        public final void m27743b() {
            this.f19057a = true;
            Drawable topLevelDrawable = this.f19058b.f19087e.getTopLevelDrawable();
            switch (this.f19058b.aJ) {
                case ENTER_ANIMATE:
                    if (!this.f19058b.aA.isDone()) {
                        this.f19058b.m27831i();
                        if (this.f19058b.f19105w && this.f19058b.aB != null) {
                            this.f19058b.m27832j();
                            FullScreenVideoPlayer.m27787d(this.f19058b, topLevelDrawable);
                            break;
                        }
                        this.f19058b.m27820a(topLevelDrawable);
                        break;
                    }
                    break;
                case POSITION:
                    this.f19058b.m27831i();
                    CustomViewUtils.a(this.f19058b.f19072K, FullScreenVideoPlayer.m27778c(this.f19058b, topLevelDrawable));
                    break;
                case NOP:
                    break;
                default:
                    throw new AssertionError("Unknown action");
            }
            this.f19058b.aJ = OnDownloadPlaceholderAction.NOP;
        }

        public final void m27744b(String str, Throwable th) {
            switch (this.f19058b.aJ) {
                case ENTER_ANIMATE:
                    if (!this.f19058b.aA.isDone()) {
                        this.f19058b.aB = null;
                        this.f19058b.m27820a(null);
                        break;
                    }
                    break;
                case POSITION:
                case NOP:
                    break;
                default:
                    throw new AssertionError("Unknown action");
            }
            this.f19058b.aJ = OnDownloadPlaceholderAction.NOP;
        }
    }

    /* compiled from: composer_pause */
    public class VideoViewControlHandler {
        final /* synthetic */ FullScreenVideoPlayer f19059a;

        public VideoViewControlHandler(FullScreenVideoPlayer fullScreenVideoPlayer) {
            this.f19059a = fullScreenVideoPlayer;
        }

        public final boolean m27745a() {
            return this.f19059a.f19086d.m28049h();
        }
    }

    private static <T extends View> void m27769a(Class<T> cls, T t) {
        m27770a((Object) t, t.getContext());
    }

    private static void m27770a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FullScreenVideoPlayer fullScreenVideoPlayer = (FullScreenVideoPlayer) obj;
        WindowManager a = WindowManagerMethodAutoProvider.a(fbInjector);
        DefaultAndroidThreadUtil a2 = DefaultAndroidThreadUtil.a(fbInjector);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        VideoPlayerManager a3 = VideoPlayerManager.a(fbInjector);
        Boolean a4 = Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider.a(fbInjector);
        MonotonicClock monotonicClock = (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector);
        VideoLoggingUtils a5 = VideoLoggingUtils.a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter2 = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        VideoFullScreenEventBus a6 = VideoFullScreenEventBus.m27622a(fbInjector);
        BytesViewedLogger a7 = BytesViewedLogger.a(fbInjector);
        ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector);
        fullScreenVideoPlayer.m27766a(a, a2, executor, abstractFbErrorReporter, fbSharedPreferences, a3, a4, monotonicClock, a5, abstractFbErrorReporter2, a6, a7, AndroidVideoCompleteWorkaround.m27634a(fbInjector), VideoPlayerSessionManagerMethodAutoProvider.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 587), ErrorDialogs.a(fbInjector), FbDraweeControllerBuilder.a(fbInjector), (DirectPlayPreparerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(DirectPlayPreparerProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector));
    }

    public FullScreenVideoPlayer(Context context) {
        super(context);
        m27765a(context);
    }

    public FullScreenVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27765a(context);
    }

    public FullScreenVideoPlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27765a(context);
    }

    @Inject
    private void m27766a(WindowManager windowManager, AndroidThreadUtil androidThreadUtil, Executor executor, FbErrorReporter fbErrorReporter, FbSharedPreferences fbSharedPreferences, VideoPlayerManager videoPlayerManager, Boolean bool, MonotonicClock monotonicClock, VideoLoggingUtils videoLoggingUtils, FbErrorReporter fbErrorReporter2, VideoFullScreenEventBus videoFullScreenEventBus, BytesViewedLogger bytesViewedLogger, AndroidVideoCompleteWorkaround androidVideoCompleteWorkaround, VideoPlayerSessionManager videoPlayerSessionManager, Lazy<NetworkMonitor> lazy, ErrorDialogs errorDialogs, FbDraweeControllerBuilder fbDraweeControllerBuilder, DirectPlayPreparerProvider directPlayPreparerProvider, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore) {
        this.f19078S = windowManager;
        this.f19089g = androidThreadUtil;
        this.f19079T = executor;
        this.f19080U = fbErrorReporter;
        this.f19081V = fbSharedPreferences;
        this.f19082W = videoPlayerManager;
        this.ac = bool != null ? bool.booleanValue() : false;
        this.f19102t = monotonicClock;
        this.f19101s = videoLoggingUtils;
        this.f19103u = fbErrorReporter2;
        this.f19104v = videoFullScreenEventBus;
        this.aK = androidVideoCompleteWorkaround;
        this.aL = videoPlayerSessionManager;
        this.ag = lazy;
        this.ah = errorDialogs;
        this.aO = fbDraweeControllerBuilder;
        this.az = new TypedEventBus();
        this.ay = bytesViewedLogger;
        this.ay.a(this.az);
        this.aQ = directPlayPreparerProvider;
        this.aS = new DirectPlayConfig(qeAccessor, gatekeeperStore);
    }

    protected final void m27822a(boolean z) {
        Uri uri;
        if (z) {
            this.f19101s.a(this.f19098p.a, this.f19074M.m27716i(), this.f19084b.getVideoViewCurrentPosition(), this.f19074M.m27717l());
        } else {
            this.f19101s.b(this.f19098p.a, this.f19074M.m27716i(), this.f19084b.getVideoViewCurrentPosition(), this.f19074M.m27717l());
        }
        this.f19064C = getCurrentMediaTimeResetable();
        this.f19091i = this.f19066E;
        if (z) {
            uri = null;
        } else {
            uri = this.f19074M.f19008a;
        }
        this.f19066E = uri;
        this.av = 0;
        m27836n();
    }

    private void m27765a(Context context) {
        setLayoutParams(new LayoutParams(-1, -1));
        this.f19070I = getResources().getColor(2131361848);
        this.f19071J = getResources().getColor(2131361871);
        CustomViewUtils.b(this, new ColorDrawable(this.f19070I));
        setContentView(2130904546);
        this.f19083a = (RelativeLayout) a(2131562413);
        this.f19076Q = (ImageView) a(2131562420);
        this.f19085c = a(2131562398);
        this.f19086d = (VideoController) a(2131562415);
        this.f19090h = (FbSubtitleView) a(2131562421);
        this.f19087e = (FbDraweeView) a(2131562416);
        this.f19072K = (LayoutParams) this.f19087e.getLayoutParams();
        this.f19077R = (ImageView) a(2131562419);
        this.f19088f = (VideoSpecText) a(2131562422);
        m27769a(FullScreenVideoPlayer.class, (View) this);
        this.aa = (AudioManager) context.getSystemService("audio");
        this.f19088f.m28057a(this.ac);
        this.ad = context instanceof Activity ? ((Activity) context).getWindow() : null;
        this.ae = new WindowManager.LayoutParams(-1, -1, 2, 776, -3);
        this.ae.gravity = 51;
        getVideoView().setVideoViewClickable(false);
        getVideoView().setVideoViewOnPreparedListener(new C14131(this));
        setOnClickListener(new C14142(this));
        getVideoView().setVideoViewOnCompletionListener(new C14153(this));
        getVideoView().setDelayedCompletionListener(new C14164(this));
        getVideoView().setVideoViewOnErrorListener(new C14175(this));
        this.am = new StubbedMediaController(context);
        this.am.f19210a = new WeakReference(this.al);
        getVideoView().setVideoViewMediaController(this.am);
        this.f19092j = new C14186(this);
        this.f19086d.f19254u = this.f19092j;
        m27812v();
        this.f19100r = new FullScreenLoggingPolicy(this.f19101s, this.f19093k, this.f19094l, this.f19095m, this.f19096n, this.f19097o, this.f19098p, this.f19065D);
        this.f19100r.f19005j = this.f19075P;
        this.f19100r.m27697a(new StallTimeCalculation(this.f19102t));
        this.f19086d.f19246m = this.aZ;
        TrackingNodes.a(this, TrackingNode.VIDEO);
        TrackingNodes.a(this.f19084b.mo1433c(), TrackingNode.VIDEO);
        TrackingNodes.a(this.f19086d, TrackingNode.MEDIA_CONTROLS);
        TrackingNodes.a(this.f19090h, TrackingNode.SUBTITLE);
        this.af = new AutohideHandler(this);
    }

    protected final void m27819a() {
        this.af.removeMessages(1);
        this.f19086d.m28045d();
        this.af.sendEmptyMessageDelayed(1, 3000);
    }

    protected final void m27825b() {
        this.af.removeMessages(1);
        this.f19086d.m28045d();
    }

    protected final void m27826c() {
        this.af.removeMessages(1);
        this.f19086d.m28044c();
    }

    private void m27812v() {
        if (this.an && this.f19084b != null) {
            this.ao = (ViewGroup) getVideoView().mo1433c().getParent();
            this.ao.removeView(getVideoView().mo1433c());
            this.an = false;
        }
    }

    public FullScreenVideoListener getFullScreenListener() {
        return this.at;
    }

    protected void setShouldLoopVideo(boolean z) {
        this.f19062A = z;
    }

    protected static void m27785d() {
    }

    protected final void m27827e() {
        this.aF = true;
        m27818z(this);
        invalidate();
        m27834l();
        m27819a();
        if (!this.f19106x) {
            m27816x();
            m27835m();
            this.f19100r.m27698a(this.aw);
        }
        this.f19089g.b(new C14197(this));
    }

    private boolean m27783c(int i) {
        return (i == -1004 || i == -1007 || i == 1) && VideoServer.f(this.f19066E);
    }

    private boolean m27788d(int i) {
        return this.f19068G != null && !this.f19068G.isEmpty() && this.f19069H < this.f19068G.size() - 1 && (i == -1004 || i == -1007 || i == 1);
    }

    protected final boolean m27823a(final MediaPlayer mediaPlayer, int i, int i2) {
        if (this.f19074M != null && this.f19074M.f19013f) {
            this.f19100r.m27696a(this.f19066E, i, i2);
            this.f19074M.f19013f = false;
            this.f19066E = this.f19091i;
            this.f19064C = getCurrentMediaTimeResetable();
            m27836n();
        } else if (!(this.aR && this.aS.i && getVideoView().mo1435e())) {
            if (m27783c(i)) {
                this.aR = true;
                this.f19080U.a(f19060N.getName(), StringFormatUtil.a("FullScreen VideoView network error what=%d/extra=%d; url: %s retrying by bypassing VideoServer", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), this.f19066E}));
                if (this.aS.i && getVideoView().mo1435e()) {
                    this.f19064C = getCurrentMediaTimeResetable();
                    if (this.f19064C == 0) {
                        this.f19064C = getVideoView().getSeekPosition();
                        if (this.f19064C < 0) {
                            this.f19064C = 0;
                        }
                    }
                } else {
                    this.f19066E = VideoServer.e(this.f19066E);
                }
                this.f19089g.b(new C14208(this));
            } else {
                if (m27788d(i)) {
                    this.f19069H++;
                    if (this.f19069H < 0) {
                        this.f19069H = 0;
                    }
                    VideoDataSource videoDataSource = (VideoDataSource) this.f19068G.get(this.f19069H);
                    if (videoDataSource != null) {
                        this.f19066E = videoDataSource.b;
                        this.f19067F = videoDataSource.g;
                        this.f19089g.a(new C14219(this), 100);
                    }
                }
                this.f19100r.m27696a(this.f19066E, i, i2);
                ExecutorDetour.a(this.f19079T, new Runnable(this) {
                    final /* synthetic */ FullScreenVideoPlayer f19026b;

                    /* compiled from: composer_pause */
                    class C14111 implements OnCancelListener {
                        final /* synthetic */ AnonymousClass10 f19023a;

                        C14111(AnonymousClass10 anonymousClass10) {
                            this.f19023a = anonymousClass10;
                        }

                        public void onCancel(DialogInterface dialogInterface) {
                            if (this.f19023a.f19026b.au != null) {
                                this.f19023a.f19026b.au.onCompletion(mediaPlayer);
                            }
                        }
                    }

                    /* compiled from: composer_pause */
                    class C14122 implements DialogInterface.OnClickListener {
                        final /* synthetic */ AnonymousClass10 f19024a;

                        C14122(AnonymousClass10 anonymousClass10) {
                            this.f19024a = anonymousClass10;
                        }

                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (this.f19024a.f19026b.au != null) {
                                this.f19024a.f19026b.au.onCompletion(mediaPlayer);
                            }
                        }
                    }

                    public void run() {
                        int i = ((NetworkMonitor) this.f19026b.ag.get()).a() ? 2131232762 : 2131232763;
                        ErrorDialogs errorDialogs = this.f19026b.ah;
                        ErrorDialogParamsBuilder b = ErrorDialogParams.a(this.f19026b.getResources()).a(2131232761).b(i);
                        b.g = new C14122(this);
                        b = b;
                        b.h = new C14111(this);
                        errorDialogs.a(b.l());
                        this.f19026b.m27824a(EventTriggerType.BY_PLAYER);
                    }
                }, 620236139);
            }
        }
        return true;
    }

    protected final void m27828f() {
        AndroidVideoCompleteWorkaround androidVideoCompleteWorkaround = this.aK;
        String str = this.f19098p.a;
        long j = (long) this.f19063B;
        Object obj = null;
        if (str != null && androidVideoCompleteWorkaround.f18973d != null && androidVideoCompleteWorkaround.f18973d.equals(str) && j == androidVideoCompleteWorkaround.f18975f && androidVideoCompleteWorkaround.f18971b.now() - androidVideoCompleteWorkaround.f18974e < 50) {
            if (androidVideoCompleteWorkaround.f18972c != null) {
                androidVideoCompleteWorkaround.f18972c.a("Video", "Finished event happening too often");
            }
            obj = 1;
        }
        if (obj == null) {
            FullScreenLoggingPolicy fullScreenLoggingPolicy = this.f19100r;
            int i = this.f19063B;
            this.f19084b.getVideoViewDurationInMillis();
            fullScreenLoggingPolicy.m27693a(i);
        }
        androidVideoCompleteWorkaround = this.aK;
        str = this.f19098p.a;
        j = (long) this.f19063B;
        androidVideoCompleteWorkaround.f18974e = androidVideoCompleteWorkaround.f18971b.now();
        androidVideoCompleteWorkaround.f18973d = str;
        androidVideoCompleteWorkaround.f18975f = j;
        this.f19107y = true;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.au = onCompletionListener;
    }

    public void setDismissOnComplete(boolean z) {
        this.ap = z;
    }

    protected boolean getDismissOnComplete() {
        return this.ap;
    }

    protected final void m27829g() {
        if (getVideoView().mo1425a()) {
            this.aY;
            return;
        }
        this.f19076Q.setImageResource(2130840511);
        m27747B();
        m27759N();
    }

    public static void m27814w(FullScreenVideoPlayer fullScreenVideoPlayer) {
        fullScreenVideoPlayer.f19076Q.setImageResource(2130840510);
        fullScreenVideoPlayer.m27747B();
        fullScreenVideoPlayer.f19086d.m28042b(EventTriggerType.BY_USER);
        fullScreenVideoPlayer.f19106x = true;
    }

    private Rect m27760a(Drawable drawable, Rect rect) {
        RectF rectF = new RectF(rect);
        RectF rectF2 = new RectF(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF2, rectF, ScaleToFit.CENTER);
        matrix.mapRect(rectF2);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        return CustomViewUtils.a(rect2, this);
    }

    private Rect m27771b(Drawable drawable) {
        if (this.aG.isPresent()) {
            return m27760a(drawable, (Rect) this.aG.get());
        }
        return m27760a(drawable, CustomViewUtils.a(this.f19083a));
    }

    private Rect getCurrentPlaceholderPosition() {
        if (!this.aU.f19057a) {
            return null;
        }
        Drawable topLevelDrawable = this.f19087e.getTopLevelDrawable();
        if (topLevelDrawable != null) {
            return m27760a(topLevelDrawable, CustomViewUtils.a(this.f19083a));
        }
        return null;
    }

    public static Rect m27778c(FullScreenVideoPlayer fullScreenVideoPlayer, Drawable drawable) {
        Rect b = fullScreenVideoPlayer.m27771b(drawable);
        fullScreenVideoPlayer.aG = Absent.INSTANCE;
        return b;
    }

    protected final void m27830h() {
        if (this.aF) {
            m27748C();
            m27834l();
            m27835m();
            m27818z(this);
            invalidate();
            return;
        }
        m27833k();
        m27751F();
        m27816x();
    }

    private void m27816x() {
        this.f19072K = new LayoutParams(-1, 0);
        this.f19072K.addRule(6, this.f19083a.getId());
        this.f19072K.addRule(8, this.f19083a.getId());
        this.f19087e.setLayoutParams(this.f19072K);
        this.f19087e.requestLayout();
    }

    protected final void m27831i() {
        this.f19072K = new LayoutParams(0, 0);
        this.f19087e.setLayoutParams(this.f19072K);
        this.f19087e.requestLayout();
    }

    protected final void m27820a(final Drawable drawable) {
        m27748C();
        this.f19089g.b(new Runnable(this) {
            final /* synthetic */ FullScreenVideoPlayer f19031b;

            public void run() {
                if (drawable != null) {
                    this.f19031b.f19087e.setVisibility(0);
                    CustomViewUtils.a(this.f19031b.f19072K, FullScreenVideoPlayer.m27778c(this.f19031b, drawable));
                } else {
                    this.f19031b.f19087e.setVisibility(4);
                }
                this.f19031b.setAlpha(0.0f);
                FullScreenVideoPlayer.m27776b(this.f19031b, true);
                FullScreenVideoPlayer.m27817y(this.f19031b);
            }
        });
    }

    public static void m27817y(FullScreenVideoPlayer fullScreenVideoPlayer) {
        fullScreenVideoPlayer.setAlpha(1.0f);
        fullScreenVideoPlayer.m27830h();
    }

    protected final void m27832j() {
        m27748C();
        if (m27746A()) {
            ColorDrawable colorDrawable = (ColorDrawable) new ColorDrawable(this.f19070I).mutate();
            CustomViewUtils.b(this, colorDrawable);
            Animator ofInt = ObjectAnimator.ofInt(colorDrawable, "alpha", new int[]{0, 255});
            ofInt.setDuration(250);
            ofInt.start();
        } else {
            CustomViewUtils.b(this, new ColorDrawable(this.f19070I));
        }
        m27776b(this, true);
    }

    public static void m27787d(FullScreenVideoPlayer fullScreenVideoPlayer, final Drawable drawable) {
        Preconditions.checkNotNull(fullScreenVideoPlayer.aB);
        CustomViewUtils.a(fullScreenVideoPlayer.f19072K, fullScreenVideoPlayer.getAnimationOrigin());
        fullScreenVideoPlayer.f19072K.bottomMargin = fullScreenVideoPlayer.getHeight() - (fullScreenVideoPlayer.f19072K.topMargin + fullScreenVideoPlayer.f19072K.height);
        fullScreenVideoPlayer.f19087e.requestLayout();
        fullScreenVideoPlayer.f19089g.b(new Runnable(fullScreenVideoPlayer) {
            final /* synthetic */ FullScreenVideoPlayer f19034b;

            public void run() {
                Rect c = FullScreenVideoPlayer.m27778c(this.f19034b, drawable);
                r1 = new PropertyValuesHolder[4];
                r1[0] = PropertyValuesHolder.ofInt("left", new int[]{this.f19034b.f19072K.leftMargin, c.left});
                r1[1] = PropertyValuesHolder.ofInt("top", new int[]{this.f19034b.f19072K.topMargin, c.top});
                r1[2] = PropertyValuesHolder.ofInt("width", new int[]{this.f19034b.f19072K.width, c.width()});
                r1[3] = PropertyValuesHolder.ofInt("height", new int[]{this.f19034b.f19072K.height, c.height()});
                ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(r1);
                ofPropertyValuesHolder.setInterpolator(new AccelerateDecelerateInterpolator());
                ofPropertyValuesHolder.addUpdateListener(this.f19034b.aW);
                FutureAnimationListener futureAnimationListener = this.f19034b.aV;
                futureAnimationListener.f19028a = this.f19034b.aA;
                ofPropertyValuesHolder.addListener(futureAnimationListener);
                if (this.f19034b.aE.isPresent()) {
                    ofPropertyValuesHolder.addListener((AnimatorListener) this.f19034b.aE.get());
                }
                ofPropertyValuesHolder.setDuration(250);
                ofPropertyValuesHolder.start();
                this.f19034b.aB = null;
            }
        });
    }

    private void m27774b(EventTriggerType eventTriggerType) {
        m27780c(eventTriggerType);
    }

    private void m27780c(EventTriggerType eventTriggerType) {
        m27750E();
        setAlpha(0.0f);
        CustomViewUtils.b(this, new ColorDrawable(this.f19070I));
        this.f19087e.setAlpha(1.0f);
        m27835m();
        m27818z(this);
        m27749D(this);
        if (this.ai) {
            if (this.aj) {
                this.f19078S.removeViewImmediate(this);
                this.aj = false;
            }
            this.ai = false;
        }
    }

    public static void m27818z(FullScreenVideoPlayer fullScreenVideoPlayer) {
        fullScreenVideoPlayer.f19083a.setAlpha(1.0f);
        CustomViewUtils.b(fullScreenVideoPlayer.getVideoView().mo1433c(), new ColorDrawable(fullScreenVideoPlayer.f19071J));
        if (m27746A()) {
            fullScreenVideoPlayer.getVideoView().mo1433c().setAlpha(1.0f);
        }
    }

    public static void m27776b(FullScreenVideoPlayer fullScreenVideoPlayer, boolean z) {
        fullScreenVideoPlayer.f19083a.setAlpha(0.0f);
        CustomViewUtils.b(fullScreenVideoPlayer.getVideoView().mo1433c(), new ColorDrawable(fullScreenVideoPlayer.f19070I));
        if (m27746A()) {
            fullScreenVideoPlayer.getVideoView().mo1433c().setAlpha(0.0f);
        }
        if (!z) {
            fullScreenVideoPlayer.m27812v();
        }
    }

    private static boolean m27746A() {
        return VERSION.SDK_INT >= 14;
    }

    private Rect getAnimationOrigin() {
        Preconditions.checkNotNull(this.aB);
        return CustomViewUtils.a(CustomViewUtils.a(this.aB), this);
    }

    private Rect getAnimationTarget() {
        Preconditions.checkNotNull(this.aC);
        return CustomViewUtils.a(CustomViewUtils.a(this.aC), this);
    }

    private void m27747B() {
        this.f19076Q.setScaleX(0.5f);
        this.f19076Q.setScaleY(0.5f);
        this.f19076Q.setAlpha(1.0f);
        this.f19076Q.setVisibility(0);
        this.f19076Q.animate().scaleX(1.0f).scaleY(1.0f).alpha(0.5f).setDuration(250).setListener(this.aT);
    }

    private void m27748C() {
        setVisibility(0);
        setAlpha(1.0f);
        Map a = Maps.a(1);
        a.put("android.intent.action.HEADSET_PLUG", new ActionReceiver(this) {
            final /* synthetic */ FullScreenVideoPlayer f19036a;

            {
                this.f19036a = r1;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 887887735);
                if (intent.getIntExtra("state", 1) == 0 && this.f19036a.aj && this.f19036a.getVideoView().mo1425a() && !broadcastReceiverLike.isInitialStickyBroadcast()) {
                    this.f19036a.aY;
                }
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1700315357, a);
            }
        });
        this.aP = new DynamicSecureBroadcastReceiver(a);
        getContext().registerReceiver(this.aP, new IntentFilter("android.intent.action.HEADSET_PLUG"));
    }

    public static void m27749D(FullScreenVideoPlayer fullScreenVideoPlayer) {
        if (fullScreenVideoPlayer.aP != null) {
            fullScreenVideoPlayer.getContext().unregisterReceiver(fullScreenVideoPlayer.aP);
            fullScreenVideoPlayer.aP = null;
        }
        fullScreenVideoPlayer.setVisibility(4);
        fullScreenVideoPlayer.m27812v();
        fullScreenVideoPlayer.f19082W.d();
        fullScreenVideoPlayer.clearAnimation();
    }

    private void m27750E() {
        if (this.ad == null) {
            return;
        }
        if (this.ai) {
            WindowManager.LayoutParams layoutParams = this.ae;
            layoutParams.flags &= -1025;
            if (this.aj) {
                this.f19078S.updateViewLayout(this, this.ae);
                return;
            } else {
                this.ak = true;
                return;
            }
        }
        this.ad.clearFlags(1024);
    }

    private void m27751F() {
        if (this.ad == null) {
            return;
        }
        if (this.ai) {
            WindowManager.LayoutParams layoutParams = this.ae;
            layoutParams.flags |= 1024;
            if (this.aj) {
                this.f19078S.updateViewLayout(this, this.ae);
                return;
            } else {
                this.ak = true;
                return;
            }
        }
        this.ad.addFlags(1024);
    }

    protected final void m27833k() {
        this.f19085c.setVisibility(0);
    }

    protected final void m27834l() {
        if (this.f19085c.getVisibility() == 0) {
            this.f19085c.setVisibility(4);
        }
    }

    protected void setPlaceholder(OnDownloadPlaceholderAction onDownloadPlaceholderAction) {
        if (onDownloadPlaceholderAction == OnDownloadPlaceholderAction.ENTER_ANIMATE) {
            this.aA = SettableFuture.f();
        }
        this.aJ = onDownloadPlaceholderAction;
        ImageRequest imageRequest = this.aM;
        ImageRequest imageRequest2 = this.aN;
        if (imageRequest == null && imageRequest2 == null) {
            m27820a(null);
        } else if (imageRequest2 == null || !(imageRequest == null || imageRequest.c.equals(imageRequest2.c))) {
            this.f19087e.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.aO.a(f19061O).c(imageRequest)).a(this.aU)).b(this.f19087e.getController())).s());
            this.aN = imageRequest;
        } else if (this.aU.f19057a) {
            this.aU.m27743b();
        }
        m27752G();
    }

    private void m27752G() {
        this.f19087e.setVisibility(0);
    }

    protected final void m27835m() {
        if (this.f19087e.getVisibility() != 4) {
            this.f19087e.setVisibility(4);
        }
        if (this.f19077R.getVisibility() != 4) {
            this.f19077R.setVisibility(4);
        }
    }

    private void m27753H() {
        this.f19077R.setVisibility(4);
        m27752G();
    }

    protected int getOrientation() {
        return getResources().getConfiguration().orientation;
    }

    public final void m27821a(FullScreenParams fullScreenParams) {
        this.f19100r.f19000e.d = true;
        this.aH = getOrientation();
        this.f19088f.m28057a(this.ac);
        this.f19108z = true;
        if (getParent() == null && !this.ai) {
            this.f19078S.addView(this, this.ae);
            this.ai = true;
            this.aj = true;
        }
        if (!this.an) {
            this.an = true;
            this.ao.addView(getVideoView().mo1433c());
        }
        if (this.ad != null) {
            this.ad.addFlags(128);
        }
        if (fullScreenParams.f19015h > 0) {
            this.f19086d.m28037a(fullScreenParams.f19014g, fullScreenParams.f19015h);
        }
        m27781c(fullScreenParams);
        setPlaceholder(OnDownloadPlaceholderAction.ENTER_ANIMATE);
        this.f19100r.m27703a(fullScreenParams);
        this.f19104v.a(new EnterFullScreenEvent());
    }

    private void m27775b(FullScreenParams fullScreenParams) {
        StreamSourceType streamSourceType = null;
        this.f19068G = fullScreenParams.f19011d;
        if (this.f19068G == null || this.f19068G.isEmpty()) {
            this.f19066E = fullScreenParams.f19008a;
            this.av = 0;
            this.f19067F = StreamSourceType.FROM_STREAM;
            this.f19069H = 0;
            return;
        }
        this.f19069H = 0;
        VideoDataSource videoDataSource = (VideoDataSource) this.f19068G.get(0);
        this.f19066E = videoDataSource == null ? null : videoDataSource.b;
        this.av = 0;
        if (videoDataSource != null) {
            streamSourceType = videoDataSource.g;
        }
        this.f19067F = streamSourceType;
    }

    private void m27781c(FullScreenParams fullScreenParams) {
        m27775b(fullScreenParams);
        this.f19063B = fullScreenParams.m27712c();
        this.f19064C = fullScreenParams.m27714e();
        this.aI = fullScreenParams.m27715h();
        this.ab = null;
        this.f19093k = fullScreenParams.m27721q();
        this.f19098p = fullScreenParams.m27722r();
        this.f19097o = fullScreenParams.m27720p();
        this.f19065D = fullScreenParams.m27723s();
        this.f19100r = new FullScreenLoggingPolicy(this.f19101s, this.f19093k, this.f19094l, this.f19095m, this.f19096n, this.f19097o, this.f19098p, this.f19065D);
        this.f19100r.f19005j = this.f19075P;
        this.f19100r.m27697a(new StallTimeCalculation(this.f19102t));
        this.aK.m27635a();
        this.ay.a(this.f19066E);
        this.ay.h = this.av;
        boolean a = this.f19101s.a(this.f19098p.a(), fullScreenParams.m27714e());
        VideoResourceMetadata videoResourceMetadata = new VideoResourceMetadata(this.f19066E, fullScreenParams.m27719o());
        videoResourceMetadata.c((long) fullScreenParams.m27712c());
        videoResourceMetadata.b(0);
        videoResourceMetadata.a(0);
        if (this.f19064C == 0 && this.aS.i && ((this.aS.j || !fullScreenParams.m27717l()) && ((this.aS.l || videoResourceMetadata.h()) && videoResourceMetadata.d() <= this.aS.d && a))) {
            getVideoView().mo1431a(this.f19066E, this.aQ.m27507a(videoResourceMetadata, this.f19066E));
        } else {
            getVideoView().setVideoViewPath$48ad1708(this.f19066E);
        }
        getVideoView().i_(this.f19064C);
        this.aL.a(VideoServer.a(this.f19066E), m27754I());
        setVideoRenderRotation(this.aI);
        this.f19086d.setCurrentTimeMs(this.f19064C);
        this.f19107y = false;
        this.f19106x = false;
        m27782c(this.f19106x);
        m27793f(fullScreenParams.m27714e());
        this.aM = fullScreenParams.m27713d();
        this.f19082W.c();
        this.aF = false;
        setSubtitles(null);
        this.f19063B = fullScreenParams.m27712c();
        this.f19100r.m27706b(fullScreenParams);
        this.as.m27734a(FullScreenParams.m27709g(), fullScreenParams.m27718m());
        this.f19100r.m27708c(fullScreenParams);
        this.ax = fullScreenParams.m27714e();
        this.f19086d.m28038a(FullScreenParams.m27709g());
        this.ax = -1;
        if (FullScreenParams.m27710n() != null) {
            this.f19088f.m28056a(VideoSpecParam.SOURCE, FullScreenParams.m27710n().value);
        }
    }

    private void setVideoRenderRotation(float f) {
        if (this.f19084b != null && this.f19084b.mo1434d()) {
            this.f19084b.setVideoViewRotation(f);
        }
    }

    protected final void m27836n() {
        this.ay.a(this.f19066E);
        this.ay.h = this.av;
        getVideoView().setVideoViewPath$48ad1708(this.f19066E);
        this.aL.a(VideoServer.a(this.f19066E), m27754I());
        this.f19086d.setCurrentTimeMs(this.f19064C);
        this.f19086d.m28039a(EventTriggerType.BY_PLAYER, new PlayPosition(this.f19064C, this.f19064C));
        this.f19107y = false;
        this.f19106x = false;
        this.aR = false;
    }

    private VideoViewPlayerSession m27754I() {
        return new VideoViewPlayerSession(getVideoView(), CallerContext.a(getContext()));
    }

    protected final boolean m27824a(EventTriggerType eventTriggerType) {
        int i;
        this.f19084b.mo1425a();
        FullScreenLoggingPolicy fullScreenLoggingPolicy = this.f19100r;
        if (this.f19107y) {
            i = this.f19063B;
        } else {
            i = this.f19084b.getVideoViewCurrentPosition();
        }
        fullScreenLoggingPolicy.f18997b.c(i);
        if (!this.f19108z) {
            return false;
        }
        if (this.ad != null) {
            this.ad.clearFlags(128);
        }
        this.f19108z = false;
        m27786d(eventTriggerType);
        m27780c(eventTriggerType);
        this.f19100r.m27704b();
        this.f19104v.a(new ExitFullScreenEvent());
        return true;
    }

    private void m27786d(EventTriggerType eventTriggerType) {
        boolean z;
        if (!getVideoView().mo1425a() || this.aY.f19055b) {
            z = false;
        } else {
            z = true;
        }
        int videoViewCurrentPosition = this.f19084b.getVideoViewCurrentPosition();
        ExitFullScreenResult J = m27755J();
        getVideoView().mo1426b();
        this.az.a(new PlayPausedEvent(videoViewCurrentPosition, UserReason.b));
        this.f19086d.setPlaying(false);
        this.f19090h.m28403e();
        this.f19090h.m28399b();
        this.aL.a(VideoServer.a(this.f19066E));
        this.as.m27735a(eventTriggerType, J);
        this.f19100r.m27702a(eventTriggerType, this.f19108z, z, videoViewCurrentPosition);
    }

    private ExitFullScreenResult m27755J() {
        boolean z = this.f19107y || !this.f19084b.mo1425a();
        int videoViewCurrentPosition = this.f19107y ? 0 : this.f19084b.getVideoViewCurrentPosition();
        if (videoViewCurrentPosition < 0) {
            this.f19103u.a(f19060N.getName(), StringFormatUtil.formatStrLocaleSafe("Found a negative current position %d", Integer.valueOf(videoViewCurrentPosition)));
            videoViewCurrentPosition = 0;
        }
        int i = this.f19093k.b;
        if (i < 0) {
            this.f19103u.a(f19060N.getName(), StringFormatUtil.formatStrLocaleSafe("Found a negative last start position %d", Integer.valueOf(this.f19093k.b)));
            i = videoViewCurrentPosition;
        }
        if (i > videoViewCurrentPosition) {
            i = videoViewCurrentPosition;
        }
        return new ExitFullScreenResult(z, this.f19107y, videoViewCurrentPosition, i, this.f19095m.a, null, EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f19108z && configuration.orientation != this.aH) {
            m27791e(configuration.orientation);
        }
    }

    private void m27791e(int i) {
        this.aH = i;
        m27816x();
        this.f19089g.b(new Runnable(this) {
            final /* synthetic */ FullScreenVideoPlayer f19038a;

            {
                this.f19038a = r1;
            }

            public void run() {
                this.f19038a.f19084b.mo1433c().getLeft();
                this.f19038a.f19084b.mo1433c().getTop();
                this.f19038a.f19084b.mo1433c().getWidth();
                this.f19038a.f19084b.mo1433c().getHeight();
            }
        });
    }

    public final void m27837o() {
        if (this.ai && !this.aj) {
            this.f19078S.addView(this, this.ae);
            this.aj = true;
            if (this.ak) {
                this.f19078S.updateViewLayout(this, this.ae);
                this.ak = false;
            }
        }
    }

    public final void m27838p() {
        if (this.ai && this.aj) {
            this.f19078S.removeViewImmediate(this);
            this.aj = false;
        }
    }

    public final void m27839q() {
        int orientation = getOrientation();
        Object obj = this.f19073L != orientation ? 1 : null;
        if (obj != null) {
            m27791e(orientation);
        }
        orientation = m27756K();
        this.f19106x = m27757L();
        FullScreenLoggingPolicy fullScreenLoggingPolicy = this.f19100r;
        fullScreenLoggingPolicy.f18996a.b(fullScreenLoggingPolicy.f18998c.a, fullScreenLoggingPolicy.f19002g.a, orientation, fullScreenLoggingPolicy.f19003h.b);
        this.ay.a(this.f19066E);
        this.ay.h = this.av;
        getVideoView().setVideoViewPath$48ad1708(this.f19066E);
        getVideoView().i_(orientation);
        CustomViewUtils.b(getVideoView().mo1433c(), new ColorDrawable(this.f19070I));
        m27833k();
        if (obj == null || this.f19106x) {
            m27753H();
        } else {
            this.f19100r.m27695a(orientation, EventTriggerType.BY_ANDROID);
            this.f19086d.m28038a(EventTriggerType.BY_ANDROID);
            this.f19086d.m28046e();
        }
        this.f19082W.c();
    }

    public final void m27840r() {
        boolean z;
        int videoViewCurrentPosition = this.f19084b.getVideoViewCurrentPosition();
        int currentMediaTimeResetable = getCurrentMediaTimeResetable();
        if (!this.f19084b.mo1425a() || this.aY.f19055b) {
            z = false;
        } else {
            z = true;
        }
        this.f19073L = getResources().getConfiguration().orientation;
        m27793f(getCurrentMediaTimeResetable());
        m27782c(this.f19106x);
        getVideoView().mo1426b();
        this.f19086d.setPlaying(false);
        this.f19082W.d();
        this.az.a(new PlayPausedEvent(videoViewCurrentPosition, UserReason.b));
        this.aq = CustomViewUtils.a(getVideoView().mo1433c());
        this.f19100r.m27694a(videoViewCurrentPosition, currentMediaTimeResetable, z);
    }

    protected int getCurrentMediaTimeResetable() {
        if (this.f19107y) {
            return 0;
        }
        int videoViewCurrentPosition = getVideoView().getVideoViewCurrentPosition();
        if (videoViewCurrentPosition >= 0) {
            return videoViewCurrentPosition;
        }
        this.f19103u.a(f19060N.getName(), "getCurrentMediaTimeResetable got a negative value " + videoViewCurrentPosition);
        return 0;
    }

    private int m27756K() {
        if (this.f19081V == null) {
            return 0;
        }
        return this.f19081V.a(VideoPrefs.b, 0);
    }

    private void m27793f(int i) {
        if (this.f19081V != null) {
            this.f19081V.edit().a(VideoPrefs.b, i).commit();
        }
    }

    private boolean m27757L() {
        if (this.f19081V == null) {
            return false;
        }
        return this.f19081V.a(VideoPrefs.c, false);
    }

    private void m27782c(boolean z) {
        if (this.f19081V != null) {
            this.f19081V.edit().putBoolean(VideoPrefs.c, z).commit();
        }
    }

    private boolean m27758M() {
        return this.f19108z;
    }

    private void m27759N() {
        this.f19107y = false;
        this.f19086d.m28038a(EventTriggerType.BY_USER);
        this.f19086d.m28046e();
        this.f19106x = false;
        m27835m();
    }

    public void setSubtitles(@Nullable Subtitles subtitles) {
        if (subtitles == null || subtitles.m28383b()) {
            this.f19086d.setSubtitleAdapter(null);
            this.f19090h.m28403e();
            this.f19090h.m28399b();
            return;
        }
        this.f19090h.m28397a(this.ar, new Subtitles(subtitles));
        this.f19086d.setSubtitleAdapter(this.f19090h.f19678e);
        this.f19090h.m28401c(getVideoView().getVideoViewCurrentPosition());
        this.f19090h.m28400c();
    }

    public int getCurrentMediaTime() {
        return getVideoView().getVideoViewCurrentPosition();
    }

    protected int getCurrentVolume() {
        return (this.aa.getStreamVolume(3) * 100) / this.aa.getStreamMaxVolume(3);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1372247550);
        super.onDetachedFromWindow();
        this.aj = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1527854107, a);
    }

    protected VideoViewController getVideoView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(2131562414);
        if (this.f19084b == null) {
            VideoViewController androidVideoViewController = new AndroidVideoViewController(getContext());
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(13, -1);
            androidVideoViewController.mo1433c().setLayoutParams(layoutParams);
            viewGroup.addView(androidVideoViewController.mo1433c());
            this.f19084b = androidVideoViewController;
            this.f19086d.setVideoController(this.f19084b);
            this.f19086d.f19253t = this.aS.i;
        }
        return this.f19084b;
    }

    protected Subtitles getSubtitles() {
        return this.ab;
    }

    protected static void m27806s() {
    }

    protected static void m27809t() {
    }

    protected final void m27841u() {
        this.aL.a(VideoServer.a(this.f19066E), SessionState.INSEEK);
    }

    public void setLogEnteringStartEvent(boolean z) {
        this.f19100r.f19000e.e = z;
    }

    public void setLogExitingPauseEvent(boolean z) {
        this.f19100r.f19000e.f = z;
    }
}
