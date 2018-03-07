package com.facebook.video.player.plugins;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.channelfeed.abtest.ChannelFeedConfig;
import com.facebook.video.engine.texview.VideoSurfaceProvider;
import com.facebook.video.engine.texview.VideoSurfaceTarget;
import com.facebook.video.player.AnchorLayout.LayoutParams;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.RichVideoPlayerPauseFrameCache;
import com.facebook.video.player.events.RVPLimitAspectRatioEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RVPSizeChangedEvent;
import com.facebook.video.player.events.RVPVideoSizeUpdatedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: delete */
public class VideoPlugin extends RichVideoPlayerPlugin {
    private double f14080a;
    public double f14081b;
    public boolean f14082c;
    @Inject
    VideoSurfaceProvider f14083d;
    @Inject
    RichVideoPlayerPauseFrameCache f14084l;
    @Inject
    ChannelFeedConfig f14085m;
    protected VideoSurfaceTarget f14086n;
    protected ViewGroup f14087o;
    private boolean f14088p;
    private RectF f14089q;
    private ImageView f14090r;

    /* compiled from: delete */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ VideoPlugin f14100a;
        private boolean f14101b;

        public PlayerStateChangedEventSubscriber(VideoPlugin videoPlugin) {
            this.f14100a = videoPlugin;
            this.f14101b = false;
        }

        public final void m14909b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            boolean z = rVPPlayerStateChangedEvent.f14079b == State.ATTEMPT_TO_PLAY || rVPPlayerStateChangedEvent.f14079b == State.PLAYING;
            if (this.f14100a.f14096h != null && PlayerOrigin.PROFILE_VIDEO.equals(this.f14100a.f14096h.m5485o())) {
                z = false;
            }
            if (z != this.f14101b) {
                this.f14100a.f14087o.setKeepScreenOn(z);
                this.f14101b = z;
            }
            this.f14100a.m14893d();
        }

        public final Class<RVPPlayerStateChangedEvent> m14908a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: delete */
    class SizeChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPSizeChangedEvent> {
        final /* synthetic */ VideoPlugin f14102a;

        public SizeChangedEventSubscriber(VideoPlugin videoPlugin) {
            this.f14102a = videoPlugin;
        }

        public final void m14911b(FbEvent fbEvent) {
            this.f14102a.m14899p();
        }

        public final Class<RVPSizeChangedEvent> m14910a() {
            return RVPSizeChangedEvent.class;
        }
    }

    /* compiled from: delete */
    class VideoSizeUpdatedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPVideoSizeUpdatedEvent> {
        final /* synthetic */ VideoPlugin f14103a;

        public VideoSizeUpdatedEventSubscriber(VideoPlugin videoPlugin) {
            this.f14103a = videoPlugin;
        }

        public final void m14913b(FbEvent fbEvent) {
            RVPVideoSizeUpdatedEvent rVPVideoSizeUpdatedEvent = (RVPVideoSizeUpdatedEvent) fbEvent;
            this.f14103a.mo415a(rVPVideoSizeUpdatedEvent.f14123a, rVPVideoSizeUpdatedEvent.f14124b);
        }

        public final Class<RVPVideoSizeUpdatedEvent> m14912a() {
            return RVPVideoSizeUpdatedEvent.class;
        }
    }

    /* compiled from: delete */
    class LimitAspectRatioEventSubscriber extends RichVideoPlayerEventSubscriber<RVPLimitAspectRatioEvent> {
        final /* synthetic */ VideoPlugin f14104a;

        public LimitAspectRatioEventSubscriber(VideoPlugin videoPlugin) {
            this.f14104a = videoPlugin;
        }

        public final void m14915b(FbEvent fbEvent) {
            RVPLimitAspectRatioEvent rVPLimitAspectRatioEvent = (RVPLimitAspectRatioEvent) fbEvent;
            this.f14104a.f14081b = rVPLimitAspectRatioEvent.f14125a;
            this.f14104a.m14899p();
        }

        public final Class<RVPLimitAspectRatioEvent> m14914a() {
            return RVPLimitAspectRatioEvent.class;
        }
    }

    private static <T extends View> void m14891a(Class<T> cls, T t) {
        m14892a((Object) t, t.getContext());
    }

    private static void m14892a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VideoPlugin) obj).m14888a(VideoSurfaceProvider.b(fbInjector), RichVideoPlayerPauseFrameCache.a(fbInjector), ChannelFeedConfig.a(fbInjector));
    }

    @DoNotStrip
    public VideoPlugin(Context context) {
        this(context, null);
    }

    public VideoPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14080a = 1.7777777777777777d;
        this.f14081b = -1.0d;
        m14891a(VideoPlugin.class, (View) this);
        this.f14094f.add(new PlayerStateChangedEventSubscriber(this));
        this.f14094f.add(new SizeChangedEventSubscriber(this));
        this.f14094f.add(new VideoSizeUpdatedEventSubscriber(this));
        this.f14094f.add(new LimitAspectRatioEventSubscriber(this));
        if (this.f14085m.n) {
            this.f14094f.add(new PauseFrameAvailableEventSubscriber(this));
        }
        setContentView(2130907697);
        this.f14087o = (ViewGroup) m14861a(2131560327);
        this.f14090r = (ImageView) m14861a(2131568379);
        this.f14086n = mo418l();
    }

    private void m14888a(VideoSurfaceProvider videoSurfaceProvider, RichVideoPlayerPauseFrameCache richVideoPlayerPauseFrameCache, ChannelFeedConfig channelFeedConfig) {
        this.f14083d = videoSurfaceProvider;
        this.f14084l = richVideoPlayerPauseFrameCache;
        this.f14085m = channelFeedConfig;
    }

    protected VideoSurfaceTarget mo418l() {
        return this.f14083d.a(false);
    }

    protected void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        Double d = (Double) richVideoPlayerParams.f4963b.get("VideoAspectRatioKey");
        Object obj = (d == null || Math.abs(d.doubleValue() - this.f14080a) <= 0.001d) ? null : 1;
        if (z || obj != null) {
            mo419m();
            if (d != null) {
                this.f14080a = d.doubleValue();
            }
            m14899p();
        }
        if (z || !this.f14088p) {
            if ((this.f14097i != null ? this.f14097i.getCurrentPositionMs() : 0) > 0) {
                setPauseFrame(this, this.f14084l.a(this.f14097i.getVideoId()));
            }
        }
    }

    public static void setPauseFrame(VideoPlugin videoPlugin, Bitmap bitmap) {
        videoPlugin.f14090r.setImageBitmap(bitmap);
        videoPlugin.f14088p = bitmap != null;
        videoPlugin.m14893d();
    }

    private void m14893d() {
        int i;
        int i2 = 1;
        int i3 = 0;
        if (this.f14096h == null || !this.f14096h.m5480i()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.f14088p && r0 == 0) {
            i2 = 0;
        }
        ImageView imageView = this.f14090r;
        if (i2 != 0) {
            i = 8;
        } else {
            i = 0;
        }
        imageView.setVisibility(i);
        ViewGroup viewGroup = this.f14087o;
        if (i2 == 0) {
            i3 = 4;
        }
        viewGroup.setVisibility(i3);
    }

    protected void mo419m() {
        Preconditions.checkNotNull(this.f14096h);
        if (!this.f14086n.m14925b()) {
            this.f14086n.m14924a(this.f14087o);
        }
        PlaybackController playbackController = this.f14096h;
        playbackController.f5123t = this.f14086n;
        playbackController.f5121r.mo481a(playbackController.f5123t);
    }

    protected void mo378c() {
        if (this.f14086n.m14925b()) {
            this.f14086n.m14922a();
        }
    }

    protected void mo415a(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.f14080a = ((double) i) / ((double) i2);
            m14899p();
        }
    }

    protected final void m14899p() {
        View view = this.f14086n.f14118i;
        if (view == null) {
            return;
        }
        if (this.f14089q != null) {
            RichVideoPlayerPluginUtils.m14935a(this.f14093e, view, this.f14089q, this.f14080a);
        } else {
            RichVideoPlayerPluginUtils.m14932a(this.f14093e, view, this.f14080a, this.f14081b, this.f14082c, true);
        }
    }

    public void setCropRect(RectF rectF) {
        this.f14089q = new RectF(rectF);
    }

    public void setShouldCropToFit(boolean z) {
        this.f14082c = z;
    }

    public void setVideoPluginAlignment(VideoPluginAlignment videoPluginAlignment) {
        LayoutParams layoutParams = (LayoutParams) this.f14087o.getLayoutParams();
        layoutParams.addRule(15, 0);
        layoutParams.addRule(10, 0);
        switch (1.a[videoPluginAlignment.ordinal()]) {
            case 1:
                layoutParams.addRule(10);
                break;
            case 2:
                layoutParams.addRule(15);
                break;
        }
        this.f14087o.setLayoutParams(layoutParams);
    }
}
