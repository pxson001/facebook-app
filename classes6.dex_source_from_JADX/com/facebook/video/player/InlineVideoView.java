package com.facebook.video.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.util.ExifOrientation;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.AbstractVideoPlayerListener;
import com.facebook.video.engine.Constants.VideoError;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayer;
import com.facebook.video.engine.VideoPlayer.PlayerState;
import com.facebook.video.engine.VideoPlayerListener;
import com.facebook.video.engine.VideoPlayerManager;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.texview.VideoSurfaceProvider;
import com.facebook.video.engine.texview.VideoSurfaceTarget;
import com.facebook.video.subtitles.controller.SubtitleListener;
import com.facebook.video.subtitles.controller.SubtitleText;
import com.facebook.video.subtitles.controller.Subtitles;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@TargetApi(14)
/* compiled from: composer_open_picker_from_exit_confirmation */
public class InlineVideoView extends CustomRelativeLayout implements VideoControllable {
    @Inject
    VideoSurfaceProvider f19177a;
    @Inject
    VideoPlayerManager f19178b;
    @Inject
    VideoLoggingUtils f19179c;
    public final TypedEventBus f19180d;
    private final AttributeSet f19181e;
    private final int f19182f;
    private final InlineVideoPlayerListener f19183g;
    private final InlineVideoPlayerSubtitleListener f19184h;
    private VideoPlayerParams f19185i;
    private boolean f19186j;
    public boolean f19187k;
    private boolean f19188l;
    public boolean f19189m;
    private PlayerOrigin f19190n;
    private PlayerType f19191o;
    private boolean f19192p;
    private boolean f19193q;
    public VideoPlayer f19194r;
    public VideoPlayerListener f19195s;
    public SubtitleListener f19196t;
    private VideoSurfaceTarget f19197u;

    /* compiled from: composer_open_picker_from_exit_confirmation */
    class InlineVideoPlayerListener extends AbstractVideoPlayerListener {
        final /* synthetic */ InlineVideoView f19175a;

        public InlineVideoPlayerListener(InlineVideoView inlineVideoView) {
            this.f19175a = inlineVideoView;
        }

        public final void m27945a() {
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.a();
            }
        }

        public final void m27946a(int i) {
            m27944h();
            this.f19175a.f19187k = true;
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.a(i);
            }
        }

        public final void m27949a(EventTriggerType eventTriggerType) {
            m27944h();
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.a(eventTriggerType);
            }
        }

        public final void m27955b(EventTriggerType eventTriggerType) {
            m27944h();
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.b(eventTriggerType);
            }
        }

        private void m27944h() {
            this.f19175a.setKeepScreenOn(false);
        }

        public final void m27959c(EventTriggerType eventTriggerType) {
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.c(eventTriggerType);
            }
            this.f19175a.setKeepScreenOn(true);
        }

        public final void m27961d() {
            if (this.f19175a.f19194r != null && this.f19175a.f19194r.a()) {
                this.f19175a.f19194r.c(EventTriggerType.BY_MANAGER);
            }
            InlineVideoView.m27974i(this.f19175a);
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.d();
            }
        }

        public final void m27954b(int i) {
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.b(i);
            }
        }

        public final void m27947a(int i, int i2) {
            new StringBuilder("onVideoSizeUpdated: w = ").append(i).append(", h = ").append(i2);
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.a(i, i2);
            }
        }

        public final void m27953b() {
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.b();
            }
        }

        public final void m27958c() {
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.c();
            }
        }

        public final void m27948a(Bitmap bitmap) {
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.a(bitmap);
            }
        }

        public final void m27950a(EventTriggerType eventTriggerType, boolean z) {
            new StringBuilder("onBeforeVideoPlay: success = ").append(z);
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.a(eventTriggerType, z);
            }
        }

        public final void m27956b(EventTriggerType eventTriggerType, boolean z) {
            new StringBuilder("onBeforeVideoPause: success = ").append(z);
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.b(eventTriggerType, z);
            }
        }

        public final void m27960c(EventTriggerType eventTriggerType, boolean z) {
            new StringBuilder("onBeforeVideoStop: success = ").append(z);
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.c(eventTriggerType, z);
            }
        }

        public final void m27951a(PlayerState playerState) {
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.a(playerState);
            }
        }

        public final void m27957b(PlayerState playerState) {
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.b(playerState);
            }
        }

        public final void m27952a(String str, VideoError videoError) {
            if (this.f19175a.f19195s != null) {
                this.f19175a.f19195s.a(str, videoError);
            }
        }
    }

    /* compiled from: composer_open_picker_from_exit_confirmation */
    class InlineVideoPlayerSubtitleListener implements SubtitleListener {
        final /* synthetic */ InlineVideoView f19176a;

        public InlineVideoPlayerSubtitleListener(InlineVideoView inlineVideoView) {
            this.f19176a = inlineVideoView;
        }

        public final void m27962a(SubtitleText subtitleText) {
            if (this.f19176a.f19196t != null) {
                this.f19176a.f19196t.a(subtitleText);
            }
        }
    }

    private static <T extends View> void m27966a(Class<T> cls, T t) {
        m27967a((Object) t, t.getContext());
    }

    private static void m27967a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((InlineVideoView) obj).m27965a(VideoSurfaceProvider.b(fbInjector), VideoPlayerManager.a(fbInjector), VideoLoggingUtils.a(fbInjector));
    }

    private void m27965a(VideoSurfaceProvider videoSurfaceProvider, VideoPlayerManager videoPlayerManager, VideoLoggingUtils videoLoggingUtils) {
        this.f19177a = videoSurfaceProvider;
        this.f19178b = videoPlayerManager;
        this.f19179c = videoLoggingUtils;
    }

    public InlineVideoView(Context context) {
        this(context, null, 0);
    }

    public InlineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InlineVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f19180d = new TypedEventBus();
        this.f19183g = new InlineVideoPlayerListener(this);
        this.f19184h = new InlineVideoPlayerSubtitleListener(this);
        this.f19190n = PlayerOrigin.UNKNOWN;
        this.f19191o = PlayerType.INLINE_PLAYER;
        this.f19192p = false;
        this.f19193q = false;
        setContentView(2130904930);
        m27966a(InlineVideoView.class, (View) this);
        this.f19181e = attributeSet;
        this.f19182f = i;
    }

    public void setAlwaysPlayVideoUnmuted(boolean z) {
        this.f19189m = z;
    }

    public int getLastStartPosition() {
        return this.f19194r != null ? this.f19194r.m() : 0;
    }

    public final void m27979a(boolean z, EventTriggerType eventTriggerType) {
        new StringBuilder("muteAudio: ").append(eventTriggerType);
        m27973h();
        if (this.f19189m) {
            z = false;
        }
        this.f19186j = z;
        this.f19194r.a(z, eventTriggerType);
    }

    public final boolean m27985c() {
        m27973h();
        return this.f19194r.a();
    }

    public final boolean m27987d() {
        if (this.f19194r == null) {
            return false;
        }
        return this.f19194r.i();
    }

    public final boolean m27988e() {
        if (this.f19194r == null) {
            return false;
        }
        return this.f19194r.j();
    }

    public final void m27976a(EventTriggerType eventTriggerType) {
        m27977a(eventTriggerType, PlayPosition.b);
    }

    public final void m27983b(EventTriggerType eventTriggerType) {
        m27977a(eventTriggerType, PlayPosition.a);
    }

    public final void m27977a(EventTriggerType eventTriggerType, PlayPosition playPosition) {
        new StringBuilder("start:").append(eventTriggerType);
        m27973h();
        this.f19194r.a(eventTriggerType, playPosition);
        m27979a(this.f19186j, EventTriggerType.BY_PLAYER);
        this.f19187k = false;
    }

    public final void m27984c(EventTriggerType eventTriggerType) {
        new StringBuilder("stop:").append(eventTriggerType);
        m27973h();
        this.f19194r.b(eventTriggerType);
    }

    public final void m27986d(EventTriggerType eventTriggerType) {
        new StringBuilder("replay:").append(eventTriggerType);
        m27973h();
        this.f19194r.c(eventTriggerType);
    }

    private void m27964a(int i, EventTriggerType eventTriggerType) {
        new StringBuilder("seekTo:").append(eventTriggerType);
        m27973h();
        this.f19194r.a(i, eventTriggerType);
    }

    public void setVideoListener(VideoPlayerListener videoPlayerListener) {
        this.f19195s = videoPlayerListener;
    }

    public void setSubtitleListener(SubtitleListener subtitleListener) {
        this.f19196t = subtitleListener;
    }

    public boolean getIsVideoCompleted() {
        return this.f19187k;
    }

    public void setIsVideoCompleted(boolean z) {
        new StringBuilder("setIsVideoCompleted:").append(z);
        this.f19187k = z;
    }

    public StreamSourceType getVideoSourceType() {
        if (this.f19185i == null || this.f19185i.a.isEmpty()) {
            return null;
        }
        return ((VideoDataSource) this.f19185i.a.get(0)).g;
    }

    public VideoPlayer getVideoPlayer() {
        m27973h();
        return this.f19194r;
    }

    public void setVideoData(VideoPlayerParams videoPlayerParams) {
        TracerDetour.a("InlineVideoView.setVideoData", 1666379313);
        try {
            if (videoPlayerParams.a != null) {
                new StringBuilder("setVideoData:").append(StringUtil.b(", ", new Object[]{videoPlayerParams.a}));
            }
            this.f19185i = videoPlayerParams;
            try {
                m27973h();
                this.f19194r.a(videoPlayerParams);
            } catch (Exception e) {
                this.f19179c.a("Error setting video path. " + e.getMessage(), this.f19191o.value, videoPlayerParams.b, videoPlayerParams.a, null, this.f19194r.g(), this.f19194r.r(), e);
            }
            TracerDetour.a(1944489243);
        } catch (Throwable th) {
            TracerDetour.a(767425708);
        }
    }

    public Uri getVideoUri() {
        if (this.f19185i == null || this.f19185i.a.isEmpty()) {
            return null;
        }
        return ((VideoDataSource) this.f19185i.a.get(0)).b;
    }

    public void setSubtitles(Subtitles subtitles) {
        m27973h();
        this.f19194r.a(subtitles);
    }

    public int getCurrentPosition() {
        m27973h();
        return this.f19194r.b();
    }

    public void setPlayerOrigin(PlayerOrigin playerOrigin) {
        this.f19190n = playerOrigin;
        if (this.f19194r != null) {
            this.f19194r.a(playerOrigin);
        }
    }

    public void setPlayerType(PlayerType playerType) {
        m27973h();
        this.f19191o = playerType;
        if (this.f19194r != null) {
            this.f19194r.a(playerType);
        }
    }

    public void setChannelEligibility(ChannelEligibility channelEligibility) {
        if (this.f19194r != null) {
            this.f19194r.a(channelEligibility);
        }
    }

    @Deprecated
    public void setOriginalPlayReason(EventTriggerType eventTriggerType) {
        if (this.f19194r != null) {
            this.f19194r.d(eventTriggerType);
        }
    }

    public Subtitles getSubtitles() {
        return this.f19194r.o();
    }

    public final void m27982b(int i, int i2) {
        new StringBuilder("setVideoDimensions: w = ").append(i).append(", h = ").append(i2);
        m27973h();
        View k = this.f19194r.k();
        LayoutParams layoutParams = k.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            layoutParams.height = i2;
            k.setLayoutParams(layoutParams);
        }
    }

    public LayoutParams getVideoLayoutParams() {
        if (this.f19194r == null) {
            return null;
        }
        View k = this.f19194r.k();
        if (k != null) {
            return k.getLayoutParams();
        }
        return null;
    }

    public void setPauseMediaPlayerOnVideoPause(boolean z) {
        new StringBuilder("setPauseMediaPlayerOnVideoPause: ").append(z);
        this.f19188l = z;
    }

    public final void i_(int i) {
        m27964a(i, EventTriggerType.BY_USER);
    }

    public final boolean mo1425a() {
        return m27985c();
    }

    public final void mo1426b() {
        m27986d(EventTriggerType.BY_USER);
    }

    public int getVideoViewDurationInMillis() {
        return this.f19194r != null ? this.f19194r.l() : 0;
    }

    public int getVideoViewCurrentPosition() {
        return this.f19194r != null ? this.f19194r.b() : 0;
    }

    public final void mo1432a(PlayPosition playPosition) {
        m27977a(EventTriggerType.BY_USER, playPosition);
    }

    public int getBufferPercentage() {
        return 0;
    }

    public void onAttachedToWindow() {
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2014388944, Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1573428774));
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1970725267);
        if (this.f19194r != null) {
            m27974i(this);
            VideoPlayer videoPlayer = this.f19194r;
            this.f19194r.q().b(this.f19180d);
            this.f19194r = null;
            videoPlayer.f();
        }
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -714732866, a);
    }

    private VideoSurfaceTarget m27972g() {
        return this.f19177a.a(false);
    }

    private void m27973h() {
        boolean z = false;
        FrameLayout frameLayout;
        if (this.f19194r == null) {
            boolean z2;
            boolean z3;
            boolean z4;
            this.f19197u = m27972g();
            VideoPlayerManager videoPlayerManager = this.f19178b;
            Context context = getContext();
            AttributeSet attributeSet = this.f19181e;
            int i = this.f19182f;
            InlineVideoPlayerListener inlineVideoPlayerListener = this.f19183g;
            InlineVideoPlayerSubtitleListener inlineVideoPlayerSubtitleListener = this.f19184h;
            VideoLoggingUtils videoLoggingUtils = this.f19179c;
            boolean z5 = this.f19188l;
            if (this.f19192p) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (this.f19185i == null || !this.f19185i.h) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (this.f19185i == null || !this.f19185i.f) {
                z4 = false;
            } else {
                z4 = true;
            }
            this.f19194r = videoPlayerManager.a(context, attributeSet, i, inlineVideoPlayerListener, inlineVideoPlayerSubtitleListener, videoLoggingUtils, z5, z2, z3, z4, this.f19190n);
            this.f19194r.q().a(this.f19180d);
            if (!this.f19193q) {
                z = true;
            }
            Preconditions.checkState(z);
            frameLayout = (FrameLayout) findViewById(2131563199);
            if (!this.f19197u.b()) {
                this.f19197u.a(frameLayout);
            }
            this.f19194r.a(this.f19197u);
            this.f19193q = true;
            this.f19194r.a(this.f19190n);
            if (this.f19185i != null) {
                setVideoData(this.f19185i);
            }
        } else if (!this.f19193q) {
            frameLayout = (FrameLayout) findViewById(2131563199);
            if (this.f19197u != null) {
                if (!this.f19197u.b()) {
                    this.f19197u.a(frameLayout);
                }
                this.f19194r.a(this.f19197u);
                this.f19193q = true;
                return;
            }
            View k = this.f19194r.k();
            if (k != null) {
                frameLayout.addView(k, new FrameLayout.LayoutParams(-1, -1, 17));
                this.f19193q = true;
                this.f19178b.b(k);
            }
        }
    }

    public static void m27974i(InlineVideoView inlineVideoView) {
        if (inlineVideoView.f19194r != null) {
            if (inlineVideoView.f19197u == null || !inlineVideoView.f19197u.b()) {
                View k = inlineVideoView.f19194r.k();
                if (k != null) {
                    try {
                        ((FrameLayout) inlineVideoView.findViewById(2131563199)).removeView(k);
                        inlineVideoView.f19193q = false;
                        inlineVideoView.f19178b.a(k);
                        return;
                    } catch (RuntimeException e) {
                        throw e;
                    }
                }
                return;
            }
            inlineVideoView.f19197u.a();
            inlineVideoView.f19193q = false;
        }
    }

    public TypedEventBus getTypedEventBus() {
        return this.f19180d;
    }

    public void setCenterCrop(MediaResource mediaResource) {
        int i = mediaResource.f5174k;
        int i2 = mediaResource.f5173j;
        if (mediaResource.f5175l == ExifOrientation.ROTATE_90 || mediaResource.f5175l == ExifOrientation.ROTATE_270) {
            int i3 = i;
            i = i2;
            i2 = i3;
        }
        int height = getHeight();
        LayoutParams a = ScaleViewUtil.m27999a(height, i2, i);
        if (a != null) {
            i = a.width;
            i2 = a.height;
            m27982b(i, i2);
            if (i2 > i) {
                setTranslationX(0.0f);
                setTranslationY((float) ((height - i2) / 2));
            } else {
                setTranslationX((float) ((height - i) / 2));
                setTranslationY(0.0f);
            }
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = i;
                layoutParams.height = i2;
            }
            setLayoutParams(layoutParams);
        }
    }

    public void setFitInside(MediaResource mediaResource) {
        int i = mediaResource.f5174k;
        int i2 = mediaResource.f5173j;
        if (mediaResource.f5175l == ExifOrientation.ROTATE_90 || mediaResource.f5175l == ExifOrientation.ROTATE_270) {
            int i3 = i;
            i = i2;
            i2 = i3;
        }
        LayoutParams a = ScaleViewUtil.m28000a(getWidth(), getHeight(), i2, i);
        if (a != null) {
            m27982b(a.width, a.height);
            LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = a.width;
            layoutParams.height = a.height;
            setLayoutParams(layoutParams);
        }
    }

    public final void m27989f() {
        this.f19194r.d();
    }

    public final void mo1430a(int i, int i2) {
    }

    public int getTrimStartPositionMs() {
        return 0;
    }
}
