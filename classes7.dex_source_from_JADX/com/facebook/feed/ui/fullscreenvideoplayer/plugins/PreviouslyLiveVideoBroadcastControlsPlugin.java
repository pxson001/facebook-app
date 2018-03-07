package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.content.event.FbEvent;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPLiveVideoControlChangeHideTimeEvent;
import com.facebook.video.player.events.RVPLiveVideoControlChangeHideTimeEvent.Event;
import com.facebook.video.player.events.RVPLiveVideoControlFadeEvent;
import com.facebook.video.player.events.RVPOrientationChangedEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.VideoControlsBasePlugin;
import com.facebook.video.player.plugins.VideoPlugin.VideoPluginAlignment;
import javax.inject.Inject;

/* compiled from: Threaded Comments Permalink */
public class PreviouslyLiveVideoBroadcastControlsPlugin extends VideoControlsBasePlugin {
    @Inject
    public FacecastUtil f22144m;
    private PreviouslyLiveSeekBarPlugin f22145n;
    public View f22146o;

    /* compiled from: Threaded Comments Permalink */
    /* synthetic */ class C18911 {
        static final /* synthetic */ int[] f22140a = new int[Event.values().length];

        static {
            try {
                f22140a[Event.STOP_HIDE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22140a[Event.REFRESH_HIDE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: Threaded Comments Permalink */
    class LiveVideoControlPluginExtendTimeSEventSubscriber extends RichVideoPlayerEventSubscriber<RVPLiveVideoControlChangeHideTimeEvent> {
        final /* synthetic */ PreviouslyLiveVideoBroadcastControlsPlugin f22141a;

        public LiveVideoControlPluginExtendTimeSEventSubscriber(PreviouslyLiveVideoBroadcastControlsPlugin previouslyLiveVideoBroadcastControlsPlugin) {
            this.f22141a = previouslyLiveVideoBroadcastControlsPlugin;
        }

        public final void m24788b(FbEvent fbEvent) {
            switch (C18911.f22140a[((RVPLiveVideoControlChangeHideTimeEvent) fbEvent).a.ordinal()]) {
                case 1:
                    this.f22141a.f();
                    return;
                case 2:
                    this.f22141a.e();
                    return;
                default:
                    return;
            }
        }

        public final Class<RVPLiveVideoControlChangeHideTimeEvent> m24787a() {
            return RVPLiveVideoControlChangeHideTimeEvent.class;
        }
    }

    /* compiled from: Threaded Comments Permalink */
    class OrientationChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPOrientationChangedEvent> {
        final /* synthetic */ PreviouslyLiveVideoBroadcastControlsPlugin f22142a;

        public OrientationChangedEventSubscriber(PreviouslyLiveVideoBroadcastControlsPlugin previouslyLiveVideoBroadcastControlsPlugin) {
            this.f22142a = previouslyLiveVideoBroadcastControlsPlugin;
        }

        public final void m24790b(FbEvent fbEvent) {
            PreviouslyLiveVideoBroadcastControlsPlugin.m24794e(this.f22142a, ((RVPOrientationChangedEvent) fbEvent).a);
        }

        public final Class<RVPOrientationChangedEvent> m24789a() {
            return RVPOrientationChangedEvent.class;
        }
    }

    /* compiled from: Threaded Comments Permalink */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ PreviouslyLiveVideoBroadcastControlsPlugin f22143a;

        public PlayerStateChangedEventSubscriber(PreviouslyLiveVideoBroadcastControlsPlugin previouslyLiveVideoBroadcastControlsPlugin) {
            this.f22143a = previouslyLiveVideoBroadcastControlsPlugin;
        }

        public final void m24792b(FbEvent fbEvent) {
            if (((RVPPlayerStateChangedEvent) fbEvent).b == State.PLAYBACK_COMPLETE) {
                this.f22143a.m24798d(0);
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m24791a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    public static void m24793a(Object obj, Context context) {
        ((PreviouslyLiveVideoBroadcastControlsPlugin) obj).f22144m = FacecastUtil.m3107b(FbInjector.get(context));
    }

    @DoNotStrip
    public PreviouslyLiveVideoBroadcastControlsPlugin(Context context) {
        this(context, null);
    }

    private PreviouslyLiveVideoBroadcastControlsPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private PreviouslyLiveVideoBroadcastControlsPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = PreviouslyLiveVideoBroadcastControlsPlugin.class;
        m24793a((Object) this, getContext());
        this.f.add(new PlayerStateChangedEventSubscriber(this));
        this.f.add(new LiveVideoControlPluginExtendTimeSEventSubscriber(this));
        this.f.add(new OrientationChangedEventSubscriber(this));
        this.f22146o = findViewById(2131561611);
        this.f22145n = (PreviouslyLiveSeekBarPlugin) findViewById(2131566218);
    }

    protected int getContentView() {
        return 2130906373;
    }

    protected final void m24796a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.a(richVideoPlayerParams, z);
        if (z) {
            m24794e(this, getResources().getConfiguration().orientation);
            Double d = (Double) richVideoPlayerParams.b.get("VideoAspectRatioKey");
            Object obj = (!this.f22144m.m3122w() || d == null || d.doubleValue() >= 0.9d) ? null : 1;
            int i = obj != null ? 0 : 2131560327;
            LayoutParams layoutParams = (LayoutParams) this.f22146o.getLayoutParams();
            layoutParams.addRule(5, i);
            layoutParams.addRule(6, i);
            layoutParams.addRule(7, i);
            layoutParams.addRule(8, i);
            this.f22146o.setLayoutParams(layoutParams);
        }
    }

    public final void m24795a(ViewGroup viewGroup) {
        super.a(viewGroup);
        setInnerResource(2131561611);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1107395136);
        if (motionEvent.getY() > ((float) this.f22146o.getHeight())) {
            Logger.a(2, EntryType.UI_INPUT_END, 687386990, a);
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(-1303262407, a);
        return onTouchEvent;
    }

    protected final void m24797c(int i) {
        super.c(i);
        if (this.g != null) {
            this.g.a(new RVPLiveVideoControlFadeEvent(RVPLiveVideoControlFadeEvent.State.FADE_OUT));
        }
    }

    protected final void m24798d(int i) {
        super.d(i);
        if (this.g != null) {
            this.g.a(new RVPLiveVideoControlFadeEvent(RVPLiveVideoControlFadeEvent.State.FADE_IN));
        }
    }

    protected final boolean m24799j() {
        return true;
    }

    public static void m24794e(PreviouslyLiveVideoBroadcastControlsPlugin previouslyLiveVideoBroadcastControlsPlugin, int i) {
        if (i == 2) {
            previouslyLiveVideoBroadcastControlsPlugin.b.setVideoPluginAlignment(VideoPluginAlignment.CENTER);
        } else {
            previouslyLiveVideoBroadcastControlsPlugin.b.setVideoPluginAlignment(VideoPluginAlignment.TOP);
        }
    }
}
