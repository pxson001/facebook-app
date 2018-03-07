package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.touch.SphericalDragDetector.DragListener;
import com.facebook.common.touch.SphericalTouchDetector;
import com.facebook.common.touch.SphericalZoomDetector.ZoomListener;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.FullScreenCastPlugin.UiType;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVP360PinchZoomEvent;
import com.facebook.video.player.events.RVP360TouchEvent;
import com.facebook.video.player.plugins.VideoControlsBasePlugin;
import com.facebook.video.player.plugins.VideoVRCastPlugin;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: This style requires an extra wrapping FrameLayout to work */
public class Video360ControlsPlugin extends VideoControlsBasePlugin {
    @Inject
    public Video360PlayerConfig f22164m;
    private final VideoVRCastPlugin f22165n;
    private SphericalTouchDetector f22166o;
    private Video360TouchListener f22167p;
    private FullScreenCastPlugin f22168q;

    /* compiled from: This style requires an extra wrapping FrameLayout to work */
    public class Video360TouchListener implements DragListener, ZoomListener {
        final /* synthetic */ Video360ControlsPlugin f22163a;

        public Video360TouchListener(Video360ControlsPlugin video360ControlsPlugin) {
            this.f22163a = video360ControlsPlugin;
        }

        public final void m24815a() {
            this.f22163a.d();
            if (this.f22163a.g != null) {
                this.f22163a.g.a(new RVP360TouchEvent(3));
            }
        }

        public final void m24818b() {
            if (this.f22163a.g != null) {
                this.f22163a.g.a(new RVP360TouchEvent(0));
            }
        }

        public final void m24816a(float f, float f2) {
            if (this.f22163a.g != null) {
                this.f22163a.g.a(new RVP360TouchEvent(1, f, f2));
            }
        }

        public final void m24819b(float f, float f2) {
            if (this.f22163a.g != null) {
                this.f22163a.g.a(new RVP360TouchEvent(2, f, f2));
            }
        }

        public final boolean m24820c() {
            if (this.f22163a.g == null) {
                return false;
            }
            this.f22163a.g.a(new RVP360PinchZoomEvent(1));
            return true;
        }

        public final boolean m24817a(float f) {
            if (this.f22163a.g == null) {
                return false;
            }
            this.f22163a.g.a(new RVP360PinchZoomEvent(2, f));
            return true;
        }

        public final void m24821d() {
            if (this.f22163a.g != null) {
                this.f22163a.g.a(new RVP360PinchZoomEvent(3));
            }
        }
    }

    public static void m24822a(Object obj, Context context) {
        ((Video360ControlsPlugin) obj).f22164m = Video360PlayerConfig.b(FbInjector.get(context));
    }

    @DoNotStrip
    public Video360ControlsPlugin(Context context) {
        this(context, null);
    }

    private Video360ControlsPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Video360ControlsPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = Video360ControlsPlugin.class;
        m24822a((Object) this, getContext());
        this.f22165n = new VideoVRCastPlugin(getContext());
        addView(this.f22165n, 0);
        this.f22167p = new Video360TouchListener(this);
        this.f22166o = new SphericalTouchDetector(context, this.f22167p, this.f22167p, this.f22164m.m);
        this.f22168q = (FullScreenCastPlugin) a(2131561910);
        this.f22168q.f22090v = UiType.UI_360;
    }

    protected final void m24823a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.a(richVideoPlayerParams, z);
        VideoPlayerParams videoPlayerParams = richVideoPlayerParams.a;
        VideoDataSource videoDataSource = (VideoDataSource) videoPlayerParams.a.get(0);
        String str = "";
        if (richVideoPlayerParams.b != null && richVideoPlayerParams.b.containsKey("Video360CastTitle")) {
            str = (String) richVideoPlayerParams.b.get("Video360CastTitle");
        }
        this.f22165n.a((videoDataSource.c != null ? videoDataSource.c : videoDataSource.b).toString(), videoDataSource.d != null ? videoDataSource.d.toString() : "", videoDataSource.f, str, videoPlayerParams.b, PlayerType.FULL_SCREEN_PLAYER);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !this.d;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 457748845);
        boolean a2 = this.f22166o.a(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -1586783218, a);
        return a2;
    }

    protected int getContentView() {
        return 2130904300;
    }
}
