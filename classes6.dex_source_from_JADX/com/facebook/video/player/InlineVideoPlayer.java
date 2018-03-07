package com.facebook.video.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.katana.app.module.Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.api.AsyncVideo.PlayRequestedEvent;
import com.facebook.video.api.AsyncVideo.PlayRequestedEvent.Handler;
import com.facebook.video.api.AsyncVideo.PlayStartedEvent;
import com.facebook.video.engine.AbstractVideoPlayerListener;
import com.facebook.video.engine.Constants.VideoError;
import com.facebook.video.engine.Constants.VideoMediaState;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayer;
import com.facebook.video.engine.VideoPlayer.PlayerState;
import com.facebook.video.engine.VideoPlayerListener;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.player.VideoSpecText.VideoSpecParam;
import com.facebook.video.subtitles.controller.SubtitleListener;
import com.facebook.video.subtitles.controller.SubtitleText;
import com.facebook.video.subtitles.controller.Subtitles;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(14)
@Deprecated
/* compiled from: composer_opened_target_selector */
public class InlineVideoPlayer extends CustomRelativeLayout implements BaseInlineVideoPlayer {
    private static final CallerContext f19132h = CallerContext.a(InlineVideoPlayer.class, "video_cover");
    public boolean f19133A;
    public boolean f19134B;
    public boolean f19135C;
    public boolean f19136D;
    private boolean f19137E;
    public int f19138F;
    public VideoController f19139G;
    public VideoMediaState f19140H;
    private VideoPlayerParams f19141I;
    private PlayerOrigin f19142J;
    private PlayerType f19143K;
    private VideoCallToActionEndScreenOnInlinePlayer f19144L;
    public VideoPlayerListener f19145M;
    public SubtitleListener f19146N;
    public OnClickListener f19147O;
    public OnLongClickListener f19148P;
    private DialtoneStateChangedListener f19149Q;
    @Inject
    @IsVideoSpecDisplayEnabled
    Boolean f19150a;
    @Inject
    DefaultAndroidThreadUtil f19151b;
    @Inject
    VideoLoggingUtils f19152c;
    @Inject
    Lazy<NavigationLogger> f19153d;
    @Inject
    MonotonicClock f19154e;
    @Inject
    DialtoneController f19155f;
    @Inject
    FbDraweeControllerBuilder f19156g;
    public final InlineVideoView f19157i;
    private final FbDraweeView f19158j;
    public final TextView f19159k;
    public final View f19160l;
    private final DisturbingVideoMessage f19161m;
    private final View f19162n;
    public final VideoSpecText f19163o;
    public final FbTextView f19164p;
    private final TextView f19165q;
    private final ViewStub f19166r;
    private final InlineVideoPlayerListener f19167s;
    private final InlineVideoPlayerSubtitleListener f19168t;
    private final NewSpecsHandler f19169u;
    private final TypedEventBus f19170v;
    private boolean f19171w;
    private boolean f19172x;
    public boolean f19173y;
    public boolean f19174z;

    /* compiled from: composer_opened_target_selector */
    class C14221 implements Runnable {
        final /* synthetic */ InlineVideoPlayer f19109a;

        C14221(InlineVideoPlayer inlineVideoPlayer) {
            this.f19109a = inlineVideoPlayer;
        }

        public void run() {
            if (this.f19109a.f19159k.getVisibility() != 0) {
                this.f19109a.f19159k.setVisibility(0);
                this.f19109a.f19159k.setText(" ");
            }
        }
    }

    /* compiled from: composer_opened_target_selector */
    class C14232 implements Runnable {
        final /* synthetic */ InlineVideoPlayer f19110a;

        C14232(InlineVideoPlayer inlineVideoPlayer) {
            this.f19110a = inlineVideoPlayer;
        }

        public void run() {
            if (this.f19110a.f19159k.getVisibility() != 4) {
                this.f19110a.f19159k.setVisibility(4);
            }
        }
    }

    /* compiled from: composer_opened_target_selector */
    class C14243 implements Runnable {
        final /* synthetic */ InlineVideoPlayer f19111a;

        C14243(InlineVideoPlayer inlineVideoPlayer) {
            this.f19111a = inlineVideoPlayer;
        }

        public void run() {
            this.f19111a.f19138F = this.f19111a.f19138F - 1;
            if (this.f19111a.f19138F <= 0) {
                this.f19111a.f19159k.setText(" ");
            }
        }
    }

    /* compiled from: composer_opened_target_selector */
    class C14254 implements DialtoneStateChangedListener {
        final /* synthetic */ InlineVideoPlayer f19112a;

        C14254(InlineVideoPlayer inlineVideoPlayer) {
            this.f19112a = inlineVideoPlayer;
        }

        public final void iw_() {
        }

        public final void b_(boolean z) {
            if (z) {
                this.f19112a.f19160l.setVisibility(8);
            } else if (this.f19112a.f19133A) {
                this.f19112a.f19160l.setVisibility(0);
            }
        }
    }

    /* compiled from: composer_opened_target_selector */
    class InlineVideoPlayerListener extends AbstractVideoPlayerListener {
        final /* synthetic */ InlineVideoPlayer f19113a;

        public InlineVideoPlayerListener(InlineVideoPlayer inlineVideoPlayer) {
            this.f19113a = inlineVideoPlayer;
        }

        public final void m27842a() {
            this.f19113a.f19136D = true;
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.a();
            }
            if (this.f19113a.f19139G != null && this.f19113a.f19140H == VideoMediaState.PLAYING) {
                this.f19113a.f19139G.m28046e();
            }
            if (this.f19113a.getVideoPlayer() != null) {
                this.f19113a.f19163o.m28056a(VideoSpecParam.API_CONFIG, this.f19113a.getVideoPlayer().r());
            }
        }

        public final void m27843a(int i) {
            this.f19113a.f19157i.setIsVideoCompleted(true);
            this.f19113a.m27890a(VideoMediaState.STOPPED);
            this.f19113a.m27941i();
            this.f19113a.mo1463f();
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.a(i);
            }
        }

        public final void m27846a(EventTriggerType eventTriggerType) {
            this.f19113a.m27890a(VideoMediaState.STOPPED);
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.a(eventTriggerType);
            }
        }

        public final void m27852b(EventTriggerType eventTriggerType) {
            if (eventTriggerType == EventTriggerType.BY_MANAGER || eventTriggerType == EventTriggerType.BY_NEWSFEED_ONPAUSE || eventTriggerType == EventTriggerType.BY_DIALOG) {
                this.f19113a.m27890a(VideoMediaState.PAUSED);
            }
            VideoMediaState videoMediaState = this.f19113a.f19140H;
            VideoMediaState videoMediaState2 = VideoMediaState.PLAYING;
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.b(eventTriggerType);
            }
        }

        public final void m27856c(EventTriggerType eventTriggerType) {
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.c(eventTriggerType);
            }
            this.f19113a.m27890a(VideoMediaState.PLAYING);
            if (this.f19113a.f19136D && this.f19113a.f19139G != null) {
                this.f19113a.f19139G.m28046e();
            }
        }

        public final void m27851b(int i) {
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.b(i);
            }
        }

        public final void m27844a(int i, int i2) {
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.a(i, i2);
            }
        }

        public final void m27850b() {
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.b();
            }
        }

        public final void m27855c() {
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.c();
            }
        }

        public final void m27845a(Bitmap bitmap) {
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.a(bitmap);
            }
        }

        public final void m27858d() {
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.d();
            }
        }

        public final void m27847a(EventTriggerType eventTriggerType, boolean z) {
            if (z) {
                this.f19113a.m27890a(VideoMediaState.PLAYING);
            } else {
                this.f19113a.m27919p();
            }
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.a(eventTriggerType, z);
            }
        }

        public final void m27853b(EventTriggerType eventTriggerType, boolean z) {
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.b(eventTriggerType, z);
            }
        }

        public final void m27857c(EventTriggerType eventTriggerType, boolean z) {
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.c(eventTriggerType, z);
            }
        }

        public final void m27848a(PlayerState playerState) {
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.a(playerState);
            }
            this.f19113a.f19163o.m28056a(VideoSpecParam.CURRENT_STATE, playerState.value);
        }

        public final void m27854b(PlayerState playerState) {
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.b(playerState);
            }
            this.f19113a.f19163o.m28056a(VideoSpecParam.TARGET_STATE, playerState.value);
        }

        public final void m27849a(String str, VideoError videoError) {
            if (this.f19113a.f19145M != null) {
                this.f19113a.f19145M.a(str, videoError);
            }
        }
    }

    /* compiled from: composer_opened_target_selector */
    class InlineVideoPlayerSubtitleListener implements SubtitleListener {
        final /* synthetic */ InlineVideoPlayer f19116a;

        public InlineVideoPlayerSubtitleListener(InlineVideoPlayer inlineVideoPlayer) {
            this.f19116a = inlineVideoPlayer;
        }

        public final void m27859a(final SubtitleText subtitleText) {
            if (subtitleText != null) {
                this.f19116a.f19151b.b(new Runnable(this) {
                    final /* synthetic */ InlineVideoPlayerSubtitleListener f19115b;

                    public void run() {
                        this.f19115b.f19116a.f19138F = this.f19115b.f19116a.f19138F + 1;
                        this.f19115b.f19116a.f19159k.setText(subtitleText.f19660b);
                        this.f19115b.f19116a.m27889a(subtitleText.f19661c);
                    }
                });
            }
            if (this.f19116a.f19146N != null) {
                this.f19116a.f19146N.a(subtitleText);
            }
        }
    }

    /* compiled from: composer_opened_target_selector */
    class NewSpecsHandler implements Handler, PlayStartedEvent.Handler {
        final /* synthetic */ InlineVideoPlayer f19117a;
        private long f19118b;

        public NewSpecsHandler(InlineVideoPlayer inlineVideoPlayer) {
            this.f19117a = inlineVideoPlayer;
        }

        public final void m27860a(PlayRequestedEvent playRequestedEvent) {
            this.f19118b = this.f19117a.f19154e.now();
        }

        public final void m27861a(PlayStartedEvent playStartedEvent) {
            if (this.f19118b > 0) {
                this.f19117a.f19163o.m28054a((float) (this.f19117a.f19154e.now() - this.f19118b));
            }
            this.f19118b = 0;
        }
    }

    /* compiled from: composer_opened_target_selector */
    class OnLongClickPlayerButtonListener implements OnLongClickListener {
        final /* synthetic */ InlineVideoPlayer f19119a;

        public OnLongClickPlayerButtonListener(InlineVideoPlayer inlineVideoPlayer) {
            this.f19119a = inlineVideoPlayer;
        }

        public boolean onLongClick(View view) {
            ((NavigationLogger) this.f19119a.f19153d.get()).a("tap_video");
            if (this.f19119a.f19148P != null) {
                return this.f19119a.f19148P.onLongClick(view);
            }
            return false;
        }
    }

    /* compiled from: composer_opened_target_selector */
    class OnTapPlayerButtonListener implements OnClickListener {
        final /* synthetic */ InlineVideoPlayer f19120a;

        public OnTapPlayerButtonListener(InlineVideoPlayer inlineVideoPlayer) {
            this.f19120a = inlineVideoPlayer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2003418073);
            ((NavigationLogger) this.f19120a.f19153d.get()).a("tap_video");
            if (this.f19120a.f19147O != null) {
                this.f19120a.f19147O.onClick(view);
            } else {
                this.f19120a.performClick();
            }
            LogUtils.a(1830960386, a);
        }
    }

    private static <T extends View> void m27895a(Class<T> cls, T t) {
        m27896a((Object) t, t.getContext());
    }

    private static void m27896a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((InlineVideoPlayer) obj).m27894a(Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider.b(fbInjector), DefaultAndroidThreadUtil.b(fbInjector), VideoLoggingUtils.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 137), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector), (DialtoneController) DialtoneControllerImpl.a(fbInjector), FbDraweeControllerBuilder.b(fbInjector));
    }

    private void m27894a(Boolean bool, AndroidThreadUtil androidThreadUtil, VideoLoggingUtils videoLoggingUtils, Lazy<NavigationLogger> lazy, MonotonicClock monotonicClock, DialtoneController dialtoneController, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f19150a = bool;
        this.f19151b = androidThreadUtil;
        this.f19152c = videoLoggingUtils;
        this.f19153d = lazy;
        this.f19154e = monotonicClock;
        this.f19155f = dialtoneController;
        this.f19156g = fbDraweeControllerBuilder;
    }

    public InlineVideoPlayer(Context context) {
        this(context, null);
    }

    public InlineVideoPlayer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InlineVideoPlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19167s = new InlineVideoPlayerListener(this);
        this.f19168t = new InlineVideoPlayerSubtitleListener(this);
        this.f19173y = true;
        this.f19133A = true;
        this.f19134B = true;
        this.f19140H = VideoMediaState.STOPPED;
        this.f19142J = PlayerOrigin.UNKNOWN;
        this.f19143K = PlayerType.INLINE_PLAYER;
        m27895a(InlineVideoPlayer.class, (View) this);
        setContentView(2130904926);
        this.f19157i = (InlineVideoView) a(2131563188);
        this.f19158j = (FbDraweeView) a(2131563190);
        this.f19166r = (ViewStub) a(2131563191);
        this.f19161m = (DisturbingVideoMessage) a(2131563193);
        this.f19159k = (TextView) a(2131563189);
        this.f19162n = a(2131563195);
        this.f19163o = (VideoSpecText) a(2131563196);
        this.f19164p = (FbTextView) a(2131563197);
        this.f19165q = (TextView) a(2131563192);
        ViewStub viewStub = (ViewStub) a(2131563194);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.InlineVideoPlayer, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, 2130904929);
        obtainStyledAttributes.recycle();
        viewStub.setLayoutResource(resourceId);
        this.f19160l = viewStub.inflate();
        OnClickListener onTapPlayerButtonListener = new OnTapPlayerButtonListener(this);
        this.f19157i.setOnClickListener(onTapPlayerButtonListener);
        this.f19158j.setOnClickListener(onTapPlayerButtonListener);
        OnLongClickListener onLongClickPlayerButtonListener = new OnLongClickPlayerButtonListener(this);
        this.f19157i.setOnLongClickListener(onLongClickPlayerButtonListener);
        this.f19158j.setOnLongClickListener(onLongClickPlayerButtonListener);
        this.f19163o.m28057a(this.f19150a.booleanValue());
        this.f19170v = this.f19157i.f19180d;
        this.f19169u = new NewSpecsHandler(this);
    }

    public void setAlwaysPlayVideoUnmuted(boolean z) {
        this.f19157i.f19189m = z;
    }

    public void setDisturbingVideo(boolean z) {
        this.f19171w = z;
    }

    public void setDisturbingMessageVisibility(int i) {
        if (this.f19171w) {
            this.f19161m.setVisibility(i);
        } else {
            this.f19161m.setVisibility(4);
        }
    }

    public final void mo1452a(int i, String str) {
        Preconditions.checkNotNull(this.f19144L);
        this.f19144L.m28012a(i, str);
    }

    public final void mo1455a(String str, String str2, String str3) {
        Preconditions.checkNotNull(this.f19144L);
        this.f19144L.m28013a(str, str2, str3);
    }

    public void setEndScreenVideoPlayerListener(OnClickListener onClickListener) {
        Preconditions.checkNotNull(this.f19144L);
        this.f19144L.setVideoReplayListener(onClickListener);
    }

    public final void mo1459c() {
        Preconditions.checkNotNull(this.f19144L);
        this.f19144L.m28014b();
    }

    public final boolean mo1457a() {
        return this.f19144L != null;
    }

    @Nullable
    public View getEndScreenCallToActionView() {
        Preconditions.checkNotNull(this.f19144L);
        return this.f19144L.f19215c;
    }

    public final void mo1469h() {
        this.f19152c.a(this.f19141I.e, PlayerType.INLINE_PLAYER.value, this.f19141I.b, this.f19141I.f);
    }

    public void setOnClickPlayerListener(@Nullable OnClickListener onClickListener) {
        this.f19147O = onClickListener;
    }

    public boolean callOnClick() {
        return this.f19157i.callOnClick();
    }

    public void setOnLongClickPlayerListener(OnLongClickListener onLongClickListener) {
        this.f19148P = onLongClickListener;
    }

    private void m27912l() {
        m27917o();
        if (this.f19140H == VideoMediaState.PLAYING) {
            this.f19160l.setVisibility(4);
            setDisturbingMessageVisibility(4);
            setSoundWaveVisibility(true);
            setStatusVisibility(false);
            if (this.f19144L != null) {
                this.f19144L.setVisibility(4);
            }
        } else {
            this.f19160l.setVisibility(getShouldShowPlayButton() ? 0 : 8);
            setDisturbingMessageVisibility(0);
            setSoundWaveVisibility(false);
            setStatusVisibility(true);
        }
        if (getVideoSourceType() != null) {
            this.f19163o.m28056a(VideoSpecParam.SOURCE, getVideoSourceType().value);
        }
        if (getVideoPlayer() != null) {
            this.f19163o.m28055a(getVideoPlayer().p());
            this.f19163o.m28056a(VideoSpecParam.NEW_PLAYER, "old_player");
        }
    }

    private boolean getShouldShowPlayButton() {
        return !this.f19155f.j() && this.f19133A;
    }

    private void setSoundWaveVisibility(boolean z) {
        if (z && this.f19173y) {
            m27914m();
        } else {
            m27941i();
        }
    }

    public void setVideoControllerVisibility(boolean z) {
        if (this.f19139G == null) {
            return;
        }
        if (z) {
            this.f19139G.m28045d();
        } else {
            this.f19139G.m28044c();
        }
    }

    public void setShouldShowFullscreenButton(boolean z) {
        if (z) {
            this.f19139G.m28047f();
        } else {
            this.f19139G.m28048g();
        }
    }

    public void setShouldShowPlayButton(boolean z) {
        this.f19133A = z;
    }

    public void setShouldShowSoundWave(boolean z) {
        this.f19173y = z;
    }

    public void setShouldShowProgressBar(boolean z) {
        this.f19134B = z;
    }

    private void setStatusVisibility(boolean z) {
        if (z && this.f19174z) {
            this.f19164p.setVisibility(0);
        } else {
            this.f19164p.setVisibility(4);
        }
    }

    public void setShouldShowStatus(boolean z) {
        this.f19174z = z;
    }

    public void setShowVideoDuration(boolean z) {
        this.f19137E = z;
    }

    public FbTextView getStatusView() {
        return this.f19164p;
    }

    public FbDraweeView getCoverImage() {
        return this.f19158j;
    }

    public final void mo1464g() {
        TracerDetour.a("InlineVideoPlayer.bindModel", 800295241);
        try {
            this.f19136D = false;
            this.f19157i.setVideoListener(this.f19167s);
            this.f19157i.setSubtitleListener(this.f19168t);
            m27912l();
            mo1463f();
            if (this.f19139G != null) {
                this.f19139G.setVisibility(4);
            }
            TracerDetour.a(132970597);
        } catch (Throwable th) {
            TracerDetour.a(1621430134);
        }
    }

    public final void mo1456a(boolean z, EventTriggerType eventTriggerType) {
        this.f19172x = z;
        m27901b(this.f19172x, eventTriggerType);
        m27912l();
    }

    private void m27901b(boolean z, EventTriggerType eventTriggerType) {
        this.f19157i.m27979a(z, eventTriggerType);
    }

    public final boolean mo1458b() {
        return this.f19157i.m27985c();
    }

    private void setVideoCoverImageFetchParams(ImageRequest imageRequest) {
        this.f19158j.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f19156g.a(f19132h).c(imageRequest)).b(this.f19158j.getController())).s());
    }

    private void setVideoCoverImageLayoutParams(LayoutParams layoutParams) {
        if (layoutParams != null) {
            this.f19158j.setLayoutParams(layoutParams);
        }
    }

    public Uri getVideoUri() {
        return this.f19157i.getVideoUri();
    }

    public int getCurrentPosition() {
        return this.f19157i.getVideoViewCurrentPosition();
    }

    public int getCurrentDuration() {
        return this.f19157i.getVideoViewDurationInMillis();
    }

    public int getLastStartPosition() {
        return this.f19157i.getLastStartPosition();
    }

    public InlineVideoView getInlineVideoView() {
        return this.f19157i;
    }

    public final void mo1451a(int i, int i2) {
        this.f19157i.m27982b(i, i2);
    }

    private void m27890a(VideoMediaState videoMediaState) {
        this.f19140H = videoMediaState;
        if (videoMediaState == VideoMediaState.STOPPED || (videoMediaState == VideoMediaState.PAUSED && !this.f19135C)) {
            this.f19158j.setVisibility(0);
            this.f19157i.setVisibility(4);
        } else {
            this.f19158j.setVisibility(4);
            this.f19157i.setVisibility(0);
        }
        m27912l();
    }

    public final void m27925a(EventTriggerType eventTriggerType) {
        m27927a(eventTriggerType, PlayPosition.a);
    }

    public final void m27927a(EventTriggerType eventTriggerType, PlayPosition playPosition) {
        m27914m();
        this.f19157i.setIsVideoCompleted(false);
        m27901b(this.f19172x, EventTriggerType.BY_PLAYER);
        if (!this.f19157i.m27985c()) {
            m27916n();
        }
        if (this.f19139G == null || eventTriggerType == EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION) {
            if (this.f19139G != null) {
                this.f19139G.m28050i();
            }
            this.f19157i.m27977a(eventTriggerType, playPosition);
            return;
        }
        this.f19139G.m28039a(eventTriggerType, playPosition);
    }

    public final void m27941i() {
        if (this.f19137E && !m27942j()) {
            this.f19165q.setText(Utils.m28005a((long) this.f19141I.c));
            this.f19165q.setVisibility(0);
        }
    }

    private void m27914m() {
        if (this.f19165q.getVisibility() == 0) {
            this.f19165q.setVisibility(4);
        }
    }

    private void m27916n() {
        if (this.f19134B) {
            this.f19162n.setVisibility(0);
        }
        this.f19160l.setVisibility(4);
        setDisturbingMessageVisibility(4);
        setSoundWaveVisibility(false);
        setStatusVisibility(false);
    }

    private void m27917o() {
        if (this.f19162n.getVisibility() == 0) {
            this.f19162n.setVisibility(4);
        }
    }

    public void setPlayerOrigin(PlayerOrigin playerOrigin) {
        this.f19142J = playerOrigin;
        this.f19157i.setPlayerOrigin(this.f19142J);
    }

    public void setPlayerType(PlayerType playerType) {
        this.f19143K = playerType;
        this.f19157i.setPlayerType(this.f19143K);
    }

    public void setChannelEligibility(ChannelEligibility channelEligibility) {
        this.f19157i.setChannelEligibility(channelEligibility);
    }

    @Deprecated
    public void setOriginalPlayReason(EventTriggerType eventTriggerType) {
        this.f19157i.setOriginalPlayReason(eventTriggerType);
    }

    public final void m27933b(EventTriggerType eventTriggerType) {
        this.f19157i.m27984c(eventTriggerType);
        m27890a(VideoMediaState.STOPPED);
    }

    public final void mo1453a(EventTriggerType eventTriggerType, VideoMediaState videoMediaState) {
        if (this.f19139G == null || eventTriggerType == EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION) {
            this.f19157i.m27986d(eventTriggerType);
        } else {
            this.f19139G.m28042b(eventTriggerType);
        }
        m27890a(videoMediaState);
        this.f19157i.setIsVideoCompleted(false);
        VideoMediaState videoMediaState2 = VideoMediaState.PLAYING;
    }

    public final boolean m27942j() {
        return this.f19157i.m27987d();
    }

    public final boolean m27943k() {
        return this.f19157i.m27988e();
    }

    private void m27919p() {
        m27890a(VideoMediaState.PAUSED);
    }

    public void setVideoListener(VideoPlayerListener videoPlayerListener) {
        this.f19145M = videoPlayerListener;
    }

    public boolean getIsVideoCompleted() {
        return this.f19157i.f19187k;
    }

    public void setIsVideoCompleted(boolean z) {
        this.f19157i.setIsVideoCompleted(z);
    }

    public VideoPlayer getVideoPlayer() {
        return this.f19157i.getVideoPlayer();
    }

    public void setVideoData(VideoPlayerParams videoPlayerParams) {
        if (m27898a(videoPlayerParams)) {
            this.f19141I = videoPlayerParams;
            this.f19157i.setVideoData(videoPlayerParams);
        }
    }

    private boolean m27898a(VideoPlayerParams videoPlayerParams) {
        if (this.f19141I == null || Strings.isNullOrEmpty(this.f19141I.b) || !this.f19141I.b.equals(videoPlayerParams.b)) {
            return true;
        }
        return false;
    }

    public final void mo1454a(VideoPlayerParams videoPlayerParams, ImmutableMap<String, ? extends Object> immutableMap) {
        setVideoData(videoPlayerParams);
    }

    private void m27920q() {
        this.f19151b.b(new C14221(this));
    }

    public final void mo1461d() {
        if (this.f19144L == null) {
            this.f19144L = (VideoCallToActionEndScreenOnInlinePlayer) this.f19166r.inflate();
        }
    }

    public final void mo1462e() {
        Preconditions.checkNotNull(this.f19144L);
        this.f19157i.setIsVideoCompleted(true);
        m27890a(VideoMediaState.STOPPED);
        m27941i();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f19144L.getLayoutParams();
        layoutParams.height = (this.f19157i.getHeight() - this.f19157i.getPaddingTop()) - this.f19157i.getPaddingBottom();
        layoutParams.width = (this.f19157i.getWidth() - this.f19157i.getPaddingLeft()) - this.f19157i.getPaddingRight();
        this.f19144L.setLayoutParams(layoutParams);
        this.f19144L.setVisibility(0);
        this.f19144L.setClickable(true);
        this.f19144L.bringToFront();
        this.f19160l.setVisibility(4);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(300);
        this.f19144L.startAnimation(alphaAnimation);
    }

    public final void mo1463f() {
        if (this.f19144L != null && this.f19144L.getVisibility() != 4) {
            this.f19144L.setVisibility(4);
        }
    }

    private void m27921r() {
        this.f19151b.b(new C14232(this));
    }

    public void setPauseMediaPlayerOnVideoPause(boolean z) {
        this.f19157i.setPauseMediaPlayerOnVideoPause(z);
    }

    public StreamSourceType getVideoSourceType() {
        return this.f19157i.getVideoSourceType();
    }

    public final void m27929a(Subtitles subtitles) {
        this.f19157i.setSubtitles(subtitles);
        if (subtitles != null) {
            m27920q();
        } else {
            m27921r();
        }
    }

    private void m27889a(long j) {
        this.f19151b.a(new C14243(this), j);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (m27897a(configuration) && mo1458b()) {
            m27890a(this.f19140H);
        }
    }

    private static boolean m27897a(Configuration configuration) {
        return configuration.orientation == 2 || configuration.orientation == 1 || configuration.orientation == 0;
    }

    public void setFreezeOnPause(boolean z) {
        this.f19135C = z;
    }

    private void m27922s() {
        if (this.f19149Q == null) {
            this.f19149Q = new C14254(this);
        }
        this.f19155f.a(this.f19149Q);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1234533567);
        super.onAttachedToWindow();
        this.f19170v.a(PlayRequestedEvent.class, this.f19169u);
        this.f19170v.a(PlayStartedEvent.class, this.f19169u);
        if (this.f19155f.j()) {
            this.f19160l.setVisibility(8);
            m27922s();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1319669999, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1777470512);
        super.onDetachedFromWindow();
        this.f19170v.b(PlayRequestedEvent.class, this.f19169u);
        this.f19170v.b(PlayStartedEvent.class, this.f19169u);
        if (this.f19149Q != null) {
            this.f19155f.b(this.f19149Q);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1894122621, a);
    }

    public VideoPlayerParams getVideoPlayerParams() {
        return this.f19141I;
    }
}
