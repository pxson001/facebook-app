package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.spherical.model.SphericalParams;
import com.facebook.spherical.ui.SphericalHeadingIndicatorPlugin;
import com.facebook.spherical.ui.SphericalHeadingIndicatorPlugin.HeadingListener;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVP360TouchEvent;
import com.facebook.video.player.events.RVPCameraUpdateEvent;
import com.facebook.video.player.events.RVPDismiss360NuxEvent;
import com.facebook.video.player.events.RVPOrientationChangedEvent;
import com.facebook.video.player.events.RVPRequestCameraFovEvent;
import com.facebook.video.player.events.RVPRequestCameraLookAtEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: completion */
public class Video360HeadingPlugin extends RichVideoPlayerPlugin {
    @Inject
    public VideoLoggingUtils f19392a;
    @Inject
    public Video360PlayerConfig f19393b;
    public VideoHeadingIndicatorListener f19394c;
    public RichVideoPlayerParams f19395d;
    public SphericalHeadingIndicatorPlugin f19396l;

    /* compiled from: completion */
    public class HeadingIndicatorEventSubscriber extends RichVideoPlayerEventSubscriber<RVPCameraUpdateEvent> {
        final /* synthetic */ Video360HeadingPlugin f19388a;

        public HeadingIndicatorEventSubscriber(Video360HeadingPlugin video360HeadingPlugin) {
            this.f19388a = video360HeadingPlugin;
        }

        public final void m28163b(FbEvent fbEvent) {
            RVPCameraUpdateEvent rVPCameraUpdateEvent = (RVPCameraUpdateEvent) fbEvent;
            this.f19388a.f19396l.m23864a(rVPCameraUpdateEvent.f19267b, rVPCameraUpdateEvent.f19266a, rVPCameraUpdateEvent.f19268c, Video360HeadingPlugin.getCurrentPlaybackPositionMs(this.f19388a));
        }

        public final Class<RVPCameraUpdateEvent> m28162a() {
            return RVPCameraUpdateEvent.class;
        }
    }

    /* compiled from: completion */
    public class OrientationChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPOrientationChangedEvent> {
        final /* synthetic */ Video360HeadingPlugin f19389a;

        public OrientationChangedEventSubscriber(Video360HeadingPlugin video360HeadingPlugin) {
            this.f19389a = video360HeadingPlugin;
        }

        public final void m28165b(FbEvent fbEvent) {
            this.f19389a.f19396l.m23867c();
        }

        public final Class<RVPOrientationChangedEvent> m28164a() {
            return RVPOrientationChangedEvent.class;
        }
    }

    /* compiled from: completion */
    public class TouchEventSubscriber extends RichVideoPlayerEventSubscriber<RVP360TouchEvent> {
        final /* synthetic */ Video360HeadingPlugin f19390a;

        public TouchEventSubscriber(Video360HeadingPlugin video360HeadingPlugin) {
            this.f19390a = video360HeadingPlugin;
        }

        public final void m28167b(FbEvent fbEvent) {
            this.f19390a.f19396l.m23863a();
        }

        public final Class<RVP360TouchEvent> m28166a() {
            return RVP360TouchEvent.class;
        }
    }

    /* compiled from: completion */
    public class VideoHeadingIndicatorListener implements HeadingListener {
        final /* synthetic */ Video360HeadingPlugin f19391a;

        public VideoHeadingIndicatorListener(Video360HeadingPlugin video360HeadingPlugin) {
            this.f19391a = video360HeadingPlugin;
        }

        public final void mo1251a() {
            if (this.f19391a.g != null) {
                this.f19391a.g.a(new RVPDismiss360NuxEvent());
            }
        }

        public final void mo1252a(float f, float f2, int i) {
            if (this.f19391a.g != null) {
                this.f19391a.g.a(new RVPRequestCameraLookAtEvent(f, f2, i));
            }
        }

        public final void mo1253a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            if (this.f19391a.g != null) {
                this.f19391a.g.a(new RVPRequestCameraLookAtEvent((float) i, (float) i2, i7));
                this.f19391a.g.a(new RVPRequestCameraFovEvent((float) i3, i7));
            }
            this.f19391a.f19392a.a(this.f19391a.f19395d.a.b, i4, i5, i6, i, i2, i3, Video360HeadingPlugin.getCurrentPlaybackPositionMs(this.f19391a) / 1000, "");
        }
    }

    public static void m28171a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        Video360HeadingPlugin video360HeadingPlugin = (Video360HeadingPlugin) obj;
        VideoLoggingUtils a = VideoLoggingUtils.a(fbInjector);
        Video360PlayerConfig b = Video360PlayerConfig.b(fbInjector);
        video360HeadingPlugin.f19392a = a;
        video360HeadingPlugin.f19393b = b;
    }

    @DoNotStrip
    public Video360HeadingPlugin(Context context) {
        this(context, null);
    }

    private Video360HeadingPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Video360HeadingPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = Video360HeadingPlugin.class;
        m28171a((Object) this, getContext());
        setContentView(2130907651);
        this.f19396l = (SphericalHeadingIndicatorPlugin) a(2131565874);
        this.f.add(new TouchEventSubscriber(this));
        this.f.add(new HeadingIndicatorEventSubscriber(this));
        this.f.add(new OrientationChangedEventSubscriber(this));
        this.f19394c = new VideoHeadingIndicatorListener(this);
    }

    public static int getCurrentPlaybackPositionMs(Video360HeadingPlugin video360HeadingPlugin) {
        return video360HeadingPlugin.h != null ? video360HeadingPlugin.h.f() : 0;
    }

    protected final void m28172a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.a(richVideoPlayerParams, z);
        boolean z2 = this.f19393b.n;
        SphericalParams sphericalParams = null;
        if (!(richVideoPlayerParams == null || richVideoPlayerParams.a == null || richVideoPlayerParams.a.s == null)) {
            this.f19395d = richVideoPlayerParams;
            sphericalParams = richVideoPlayerParams.a.s;
        }
        if (this.h != null) {
            this.h.h();
        }
        this.f19396l.m23865a(sphericalParams, z, z2, getCurrentPlaybackPositionMs(this), this.f19394c);
    }

    protected final void m28173c() {
        super.c();
        this.f19396l.m23866b();
    }
}
