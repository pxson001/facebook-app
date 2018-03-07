package com.facebook.video.player.plugins;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.spherical.GlMediaRenderThread;
import com.facebook.spherical.HasGlToUIBridge;
import com.facebook.spherical.SphericalMediaAnimationHelper;
import com.facebook.spherical.SphericalMediaTextureView;
import com.facebook.spherical.ViewportOrientationTracker;
import com.facebook.spherical.model.SphericalRendererBounds.Builder;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.texview.VideoSurfaceTarget;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVP360PinchZoomEvent;
import com.facebook.video.player.events.RVP360TouchEvent;
import com.facebook.video.player.events.RVPBeforeVideoPlayEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RVPRequestCameraFovEvent;
import com.facebook.video.player.events.RVPRequestCameraLookAtEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: ping_failure_address */
public class Video360Plugin extends VideoPlugin implements HasGlToUIBridge {
    public ViewportOrientationTracker f4715A;
    public boolean f4716B;
    public RichVideoPlayerParams f4717C;
    public ValueAnimator f4718D;
    public SphericalMediaAnimationHelper f4719E;
    public boolean f4720a;
    @Inject
    public VideoLoggingUtils f4721b;
    @Inject
    public Video360PlayerConfig f4722c;
    public float f4723p;
    public float f4724q;
    public float f4725r;
    public AsyncTask f4726s;
    public Handler f4727t;
    public AsyncTask f4728u;
    public boolean f4729v;
    public boolean f4730w;
    public boolean f4731x;
    public final Runnable f4732y;
    public final Runnable f4733z;

    /* compiled from: ping_failure_address */
    class C02081 implements Runnable {
        final /* synthetic */ Video360Plugin f4734a;

        C02081(Video360Plugin video360Plugin) {
            this.f4734a = video360Plugin;
        }

        public void run() {
            this.f4734a.f4726s = new LoggingTask(this.f4734a);
            this.f4734a.f4726s.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }
    }

    /* compiled from: ping_failure_address */
    class C02092 implements Runnable {
        final /* synthetic */ Video360Plugin f4735a;

        C02092(Video360Plugin video360Plugin) {
            this.f4735a = video360Plugin;
        }

        public void run() {
            this.f4735a.f4728u = new UpdateCameraFovTask(this.f4735a);
            this.f4735a.f4728u.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }
    }

    /* compiled from: ping_failure_address */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ Video360Plugin f4736a;

        public PlayerStateChangedEventSubscriber(Video360Plugin video360Plugin) {
            this.f4736a = video360Plugin;
        }

        public final void m5196b(FbEvent fbEvent) {
            if (this.f4736a.f14096h != null) {
                switch (3.a[this.f4736a.f14096h.f5115l.ordinal()]) {
                    case 1:
                    case 2:
                        return;
                    default:
                        this.f4736a.m5193o();
                        return;
                }
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m5195a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: ping_failure_address */
    class BeforePlayEventSubscriber extends RichVideoPlayerEventSubscriber<RVPBeforeVideoPlayEvent> {
        final /* synthetic */ Video360Plugin f4737a;

        public BeforePlayEventSubscriber(Video360Plugin video360Plugin) {
            this.f4737a = video360Plugin;
        }

        public final void m5198b(FbEvent fbEvent) {
            if (this.f4737a.f14096h != null && this.f4737a.f14096h.m5482l()) {
                Video360Plugin video360Plugin = this.f4737a;
                if (video360Plugin.mo416a()) {
                    video360Plugin.get360TextureView().m5839a();
                    if (!video360Plugin.f4722c.d && video360Plugin.mo416a()) {
                        SphericalMediaTextureView sphericalMediaTextureView = video360Plugin.get360TextureView();
                        sphericalMediaTextureView.f5307h = true;
                        SphericalMediaTextureView.m5837b(sphericalMediaTextureView);
                    }
                    video360Plugin.f4729v = true;
                    HandlerDetour.b(video360Plugin.f4727t, video360Plugin.f4732y, 1000, 1529981794);
                    if (video360Plugin.f4722c.l) {
                        HandlerDetour.a(video360Plugin.f4727t, video360Plugin.f4733z, -2117555074);
                        return;
                    }
                    return;
                }
                BLog.a("V360", "Video360Plugin id:%d beginRendering() has no textureview", new Object[]{Integer.valueOf(video360Plugin.hashCode())});
            }
        }

        public final Class<RVPBeforeVideoPlayEvent> m5197a() {
            return RVPBeforeVideoPlayEvent.class;
        }
    }

    /* compiled from: ping_failure_address */
    class PinchZoomEventSubscriber extends RichVideoPlayerEventSubscriber<RVP360PinchZoomEvent> {
        final /* synthetic */ Video360Plugin f4738a;

        public PinchZoomEventSubscriber(Video360Plugin video360Plugin) {
            this.f4738a = video360Plugin;
        }

        public final void m5200b(FbEvent fbEvent) {
            RVP360PinchZoomEvent rVP360PinchZoomEvent = (RVP360PinchZoomEvent) fbEvent;
            if (this.f4738a.mo416a()) {
                switch (rVP360PinchZoomEvent.b) {
                    case 1:
                        this.f4738a.f14086n.m14927g();
                        this.f4738a.f4721b.d(this.f4738a.f4717C.f4962a.f4833b);
                        this.f4738a.f4731x = true;
                        return;
                    case 2:
                        SphericalMediaTextureView g = this.f4738a.f14086n.m14927g();
                        float f = rVP360PinchZoomEvent.a;
                        if (!(g.f5304e == null || g.f5304e.c == null)) {
                            GlMediaRenderThread glMediaRenderThread = g.f5304e.c;
                            if (glMediaRenderThread.F) {
                                glMediaRenderThread.a(Math.max(Math.min(glMediaRenderThread.p * (2.0f - f), 90.0f), 40.0f));
                            }
                        }
                        return;
                    case 3:
                        this.f4738a.f14086n.m14927g();
                        this.f4738a.f4731x = false;
                        return;
                    default:
                        return;
                }
            }
        }

        public final Class<RVP360PinchZoomEvent> m5199a() {
            return RVP360PinchZoomEvent.class;
        }
    }

    /* compiled from: ping_failure_address */
    class TouchEventSubscriber extends RichVideoPlayerEventSubscriber<RVP360TouchEvent> {
        final /* synthetic */ Video360Plugin f4739a;

        public TouchEventSubscriber(Video360Plugin video360Plugin) {
            this.f4739a = video360Plugin;
        }

        public final void m5202b(FbEvent fbEvent) {
            RVP360TouchEvent rVP360TouchEvent = (RVP360TouchEvent) fbEvent;
            this.f4739a.f4719E.m5209a();
            if (this.f4739a.f4718D != null && this.f4739a.f4718D.isRunning()) {
                this.f4739a.f4718D.cancel();
            }
            if (this.f4739a.mo416a()) {
                switch (rVP360TouchEvent.a) {
                    case 0:
                        this.f4739a.f14086n.m14927g().m5845d();
                        this.f4739a.f4721b.c(this.f4739a.f4717C.f4962a.f4833b);
                        this.f4739a.f4730w = true;
                        return;
                    case 1:
                        this.f4739a.f14086n.m14927g().m5842b(rVP360TouchEvent.b, rVP360TouchEvent.c);
                        return;
                    case 2:
                        this.f4739a.f14086n.m14927g().m5844c(rVP360TouchEvent.b, rVP360TouchEvent.c);
                        this.f4739a.f4730w = false;
                        return;
                    default:
                        return;
                }
            }
        }

        public final Class<RVP360TouchEvent> m5201a() {
            return RVP360TouchEvent.class;
        }
    }

    /* compiled from: ping_failure_address */
    class RequestCameraLookAtEventSubscriber extends RichVideoPlayerEventSubscriber<RVPRequestCameraLookAtEvent> {
        final /* synthetic */ Video360Plugin f4740a;

        public RequestCameraLookAtEventSubscriber(Video360Plugin video360Plugin) {
            this.f4740a = video360Plugin;
        }

        public final void m5204b(FbEvent fbEvent) {
            RVPRequestCameraLookAtEvent rVPRequestCameraLookAtEvent = (RVPRequestCameraLookAtEvent) fbEvent;
            if (this.f4740a.mo416a()) {
                this.f4740a.f4719E.m5210a(rVPRequestCameraLookAtEvent.a, rVPRequestCameraLookAtEvent.b, rVPRequestCameraLookAtEvent.c, this.f4740a);
                this.f4740a.f4721b.b(this.f4740a.f4717C.f4962a.f4833b);
            }
        }

        public final Class<RVPRequestCameraLookAtEvent> m5203a() {
            return RVPRequestCameraLookAtEvent.class;
        }
    }

    /* compiled from: ping_failure_address */
    class RequestCameraFovEventSubscriber extends RichVideoPlayerEventSubscriber<RVPRequestCameraFovEvent> {
        final /* synthetic */ Video360Plugin f4741a;

        public RequestCameraFovEventSubscriber(Video360Plugin video360Plugin) {
            this.f4741a = video360Plugin;
        }

        public final void m5206b(FbEvent fbEvent) {
            RVPRequestCameraFovEvent rVPRequestCameraFovEvent = (RVPRequestCameraFovEvent) fbEvent;
            if (this.f4741a.mo416a()) {
                Video360Plugin.m5177a(this.f4741a, rVPRequestCameraFovEvent);
            }
        }

        public final Class<RVPRequestCameraFovEvent> m5205a() {
            return RVPRequestCameraFovEvent.class;
        }
    }

    public static void m5178a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        Video360Plugin video360Plugin = (Video360Plugin) obj;
        VideoLoggingUtils a = VideoLoggingUtils.a(fbInjector);
        Video360PlayerConfig b = Video360PlayerConfig.b(fbInjector);
        video360Plugin.f4721b = a;
        video360Plugin.f4722c = b;
    }

    @DoNotStrip
    public Video360Plugin(Context context) {
        this(context, null);
    }

    private Video360Plugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Video360Plugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4720a = false;
        this.f4732y = new C02081(this);
        this.f4733z = new C02092(this);
        Class cls = Video360Plugin.class;
        m5178a((Object) this, getContext());
        this.f14094f.add(new PlayerStateChangedEventSubscriber(this));
        this.f14094f.add(new BeforePlayEventSubscriber(this));
        this.f14094f.add(new PinchZoomEventSubscriber(this));
        this.f14094f.add(new TouchEventSubscriber(this));
        this.f14094f.add(new RequestCameraLookAtEventSubscriber(this));
        this.f14094f.add(new RequestCameraFovEventSubscriber(this));
        this.f4727t = new Handler();
        this.f4715A = new ViewportOrientationTracker();
        this.f4719E = new SphericalMediaAnimationHelper();
    }

    public SphericalMediaTextureView get360TextureView() {
        return this.f14086n.m14927g();
    }

    public final void m5188e() {
        this.f4716B = false;
    }

    public final void m5189f() {
        if (mo416a()) {
            SphericalMediaTextureView sphericalMediaTextureView = get360TextureView();
            sphericalMediaTextureView.f5305f = true;
            SphericalMediaTextureView.m5837b(sphericalMediaTextureView);
            if (this.f4722c.m) {
                sphericalMediaTextureView = get360TextureView();
                sphericalMediaTextureView.f5306g = true;
                SphericalMediaTextureView.m5837b(sphericalMediaTextureView);
                return;
            }
            get360TextureView().m5846g();
        }
    }

    public final void m5190k() {
        if (mo416a()) {
            SphericalMediaTextureView sphericalMediaTextureView = get360TextureView();
            sphericalMediaTextureView.f5305f = false;
            SphericalMediaTextureView.m5837b(sphericalMediaTextureView);
            get360TextureView().m5846g();
        }
    }

    private void m5179r() {
        if (mo416a()) {
            SphericalMediaTextureView sphericalMediaTextureView = get360TextureView();
            sphericalMediaTextureView.f5307h = false;
            SphericalMediaTextureView.m5837b(sphericalMediaTextureView);
        }
    }

    private void m5180s() {
        if (mo416a() && m5181t()) {
            float f = (float) this.f4717C.f4962a.f4850s.f;
            if (f > 0.0f) {
                get360TextureView().setPreferredVerticalFOV(Math.max(Math.min(f, 120.0f), 40.0f));
            }
        }
    }

    private boolean m5181t() {
        return (this.f4717C == null || this.f4717C.f4962a == null || this.f4717C.f4962a.f4850s == null) ? false : true;
    }

    private void m5182u() {
        if (this.f4722c.j && mo416a() && m5181t()) {
            float f = (float) this.f4717C.f4962a.f4850s.d;
            get360TextureView().m5840a(Math.max(Math.min((float) this.f4717C.f4962a.f4850s.c, 180.0f), -180.0f), Math.max(Math.min(f, 90.0f), -90.0f));
        }
    }

    protected final void mo378c() {
        super.mo378c();
        HandlerDetour.a(this.f4727t, this.f4732y);
    }

    protected final void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (richVideoPlayerParams != null) {
            this.f4717C = richVideoPlayerParams;
        }
        if (z) {
            this.f4725r = -1.0f;
            this.f4723p = 0.0f;
            this.f4724q = 0.0f;
        }
        super.mo376a(richVideoPlayerParams, z);
    }

    protected final VideoSurfaceTarget mo418l() {
        return this.f14083d.a(true);
    }

    public final boolean mo416a() {
        return (this.f14086n == null || get360TextureView() == null) ? false : true;
    }

    protected final void mo419m() {
        SphericalMediaTextureView sphericalMediaTextureView;
        super.mo419m();
        m5179r();
        m5180s();
        m5182u();
        if (mo416a()) {
            sphericalMediaTextureView = get360TextureView();
            sphericalMediaTextureView.f5308i = this.f4722c.p;
            if (!(sphericalMediaTextureView.f5304e == null || sphericalMediaTextureView.f5304e.c == null)) {
                sphericalMediaTextureView.f5304e.c.G = sphericalMediaTextureView.f5308i;
            }
        }
        if (mo416a()) {
            get360TextureView().f5303d = this.f4722c.s;
        }
        if (mo416a()) {
            get360TextureView().f5301b = this.f4720a;
        }
        if (mo416a()) {
            sphericalMediaTextureView = get360TextureView();
            Builder b = new Builder().b();
            b.d = 90.0f;
            b = b;
            b.c = -90.0f;
            sphericalMediaTextureView.f5302c = b.c();
        }
    }

    protected final void mo415a(int i, int i2) {
        if (i > 0 && i2 > 0) {
            m14899p();
        }
    }

    public final void m5193o() {
        if (mo416a() && !this.f4716B) {
            BLog.a("V360", "Video360Plugin id:%d pauseRendering()", new Object[]{Integer.valueOf(hashCode())});
            get360TextureView().m5843c();
            m5179r();
            this.f4729v = false;
        }
        this.f4719E.m5209a();
        if (this.f4718D != null && this.f4718D.isRunning()) {
            this.f4718D.cancel();
        }
    }

    public final boolean m5186a(ViewportOrientationTracker viewportOrientationTracker, int i) {
        if (!mo416a() || viewportOrientationTracker == null) {
            return false;
        }
        boolean z;
        SphericalMediaTextureView sphericalMediaTextureView = get360TextureView();
        if (sphericalMediaTextureView.f5304e == null || sphericalMediaTextureView.f5304e.c == null || viewportOrientationTracker == null) {
            z = false;
        } else {
            GlMediaRenderThread glMediaRenderThread = sphericalMediaTextureView.f5304e.c;
            boolean z2 = false;
            if (viewportOrientationTracker != null) {
                glMediaRenderThread.C.f4744a.lock();
                if (i > 0) {
                    Object obj;
                    ViewportOrientationTracker viewportOrientationTracker2 = glMediaRenderThread.C;
                    float f = viewportOrientationTracker2.f4751h - viewportOrientationTracker2.f4747d;
                    float f2 = viewportOrientationTracker2.f4752i - viewportOrientationTracker2.f4748e;
                    if (((float) i) <= ((float) Math.sqrt((double) ((f * f) + (f2 * f2))))) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        z2 = true;
                        viewportOrientationTracker2 = glMediaRenderThread.C;
                        viewportOrientationTracker.f4745b = viewportOrientationTracker2.f4745b;
                        viewportOrientationTracker.f4746c = viewportOrientationTracker2.f4746c;
                        viewportOrientationTracker.f4749f = viewportOrientationTracker2.f4749f;
                        viewportOrientationTracker.f4747d = viewportOrientationTracker2.f4747d;
                        viewportOrientationTracker.f4748e = viewportOrientationTracker2.f4748e;
                        viewportOrientationTracker.f4751h = viewportOrientationTracker2.f4751h;
                        viewportOrientationTracker.f4752i = viewportOrientationTracker2.f4752i;
                        viewportOrientationTracker.f4750g = viewportOrientationTracker2.f4750g;
                        glMediaRenderThread.C.f4751h = glMediaRenderThread.C.f4747d;
                        glMediaRenderThread.C.f4752i = glMediaRenderThread.C.f4748e;
                    }
                }
                glMediaRenderThread.C.f4744a.unlock();
            }
            z = z2;
        }
        return z;
    }

    public static void m5177a(Video360Plugin video360Plugin, RVPRequestCameraFovEvent rVPRequestCameraFovEvent) {
        if (video360Plugin.f4718D != null) {
            video360Plugin.f4718D.cancel();
        }
        if (video360Plugin.mo416a()) {
            video360Plugin.f4718D = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            video360Plugin.f4718D.setInterpolator(new LinearInterpolator());
            video360Plugin.f4718D.setDuration((long) rVPRequestCameraFovEvent.b);
            float f = 70.0f;
            if (!(video360Plugin.f4717C == null || video360Plugin.f4717C.f4962a == null || video360Plugin.f4717C.f4962a.f4850s == null)) {
                f = (float) video360Plugin.f4717C.f4962a.f4850s.f;
            }
            if (f > 0.0f) {
                f = Math.max(Math.min(f, 120.0f), 40.0f);
            }
            video360Plugin.f4718D.addUpdateListener(new CameraFovUpdateListener(video360Plugin, video360Plugin.get360TextureView().getFov(), f));
            video360Plugin.f4718D.start();
        }
    }
}
