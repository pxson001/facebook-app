package com.facebook.rtc.views;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.inject.FbInjector;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.fbwebrtc.abtests.RtcRenderThreadExperiment.RtcRenderThreadMode;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.webrtc.videoengine.ViEAndroidGLES20;
import org.webrtc.videoengine.ViEAndroidGLES20OneShotDrawListener;
import org.webrtc.videoengine.ViEAndroidGLES20SurfaceView;

/* compiled from: app_noncanvas_3rdparty */
public class RtcFloatingPeerView extends RtcFloatingView {
    @Inject
    @ForUiThread
    Executor f20113a;
    @BackgroundExecutorService
    @Inject
    ScheduledExecutorService f20114b;
    @Inject
    QeAccessor f20115c;
    @Inject
    FbHandlerThreadFactory f20116d;
    private ViEAndroidGLES20 f20117h;
    private ViEAndroidGLES20SurfaceView f20118i;
    private UserTileView f20119j;
    private UserTileView f20120k;
    private FbTextView f20121l;
    private long f20122m;
    public View f20123n;
    public AwakeTimeSinceBootClock f20124o;
    private ScheduledFuture<?> f20125p;
    private boolean f20126q;
    public boolean f20127r = false;

    /* compiled from: app_noncanvas_3rdparty */
    class C23611 implements Runnable {
        final /* synthetic */ RtcFloatingPeerView f20101a;

        C23611(RtcFloatingPeerView rtcFloatingPeerView) {
            this.f20101a = rtcFloatingPeerView;
        }

        public void run() {
            long lastRedrawTime = this.f20101a.getLastRedrawTime();
            boolean z = lastRedrawTime > 0 && this.f20101a.f20124o.now() - lastRedrawTime > 5000;
            if (z) {
                this.f20101a.m19764a(true, true);
            } else {
                this.f20101a.m19764a(false, true);
            }
        }
    }

    private static <T extends View> void m19761a(Class<T> cls, T t) {
        m19762a((Object) t, t.getContext());
    }

    private static void m19762a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RtcFloatingPeerView) obj).m19763a((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), FbHandlerThreadFactory.a(fbInjector));
    }

    private void m19763a(Executor executor, ScheduledExecutorService scheduledExecutorService, QeAccessor qeAccessor, FbHandlerThreadFactory fbHandlerThreadFactory) {
        this.f20113a = executor;
        this.f20114b = scheduledExecutorService;
        this.f20115c = qeAccessor;
        this.f20116d = fbHandlerThreadFactory;
    }

    public void setPeerViewFreeze(boolean z) {
        if (!this.f20126q) {
            this.f20117h.f21063D = z;
        }
    }

    public void setPaused(boolean z) {
        if (!this.f20126q) {
            this.f20117h.setPaused(z);
        }
    }

    public long getLastRedrawTime() {
        if (this.f20126q) {
            return this.f20118i.getLastRedrawTime();
        }
        return this.f20117h.getLastRedrawTime();
    }

    public void setOneShotDrawListener(ViEAndroidGLES20OneShotDrawListener viEAndroidGLES20OneShotDrawListener) {
        if (this.f20126q) {
            this.f20118i.f21112k = viEAndroidGLES20OneShotDrawListener;
        } else {
            this.f20117h.f21079l = viEAndroidGLES20OneShotDrawListener;
        }
    }

    public View getPeerRenderView() {
        if (this.f20126q) {
            return this.f20118i;
        }
        return this.f20117h;
    }

    public RtcFloatingPeerView(Context context) {
        super(context);
    }

    public RtcFloatingPeerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void m19768g() {
        if (this.f20126q) {
            this.f20118i.m21566b();
        }
    }

    private void m19769h() {
        getPeerRenderView().setVisibility(8);
        m19768g();
        this.f20119j.setVisibility(0);
        this.f20120k.setVisibility(8);
        this.f20121l.setVisibility(4);
    }

    public final void mo829a() {
        getPeerRenderView().setVisibility(8);
        m19768g();
        if (this.f20112g) {
            this.f20119j.setVisibility(0);
        } else {
            this.f20119j.setVisibility(8);
            this.f20120k.setVisibility(0);
        }
        this.f20121l.setVisibility(0);
    }

    private void m19770i() {
        if (this.f20125p != null) {
            this.f20125p.cancel(true);
            this.f20125p = null;
        }
        m19764a(false, false);
    }

    private void m19771j() {
        m19770i();
        this.f20125p = this.f20114b.scheduleAtFixedRate(new C23611(this), 0, 500, TimeUnit.MILLISECONDS);
    }

    public final void m19775a(boolean z) {
        if (this.f20126q) {
            this.f20118i.m21564a();
        } else {
            this.f20117h.m21554a();
        }
        if (z) {
            m19769h();
        }
        getPeerRenderView().setVisibility(0);
        m19771j();
    }

    public final void m19776b() {
        getPeerRenderView().setVisibility(4);
        m19770i();
    }

    public final void m19777c() {
        this.f20119j.setVisibility(4);
        this.f20120k.setVisibility(4);
        this.f20121l.setVisibility(8);
        getPeerRenderView().setVisibility(0);
        m19771j();
    }

    ImmutableList<View> getOtherViews() {
        return ImmutableList.of(this.f20119j, this.f20121l);
    }

    View getVideoView() {
        return getPeerRenderView();
    }

    final void mo831d() {
        m19761a(RtcFloatingPeerView.class, (View) this);
        LayoutInflater from = LayoutInflater.from(getContext());
        if (this.f20112g) {
            from.inflate(2130906914, this);
        } else {
            from.inflate(2130906913, this);
        }
        this.f20124o = AwakeTimeSinceBootClock.INSTANCE;
        this.f20117h = (ViEAndroidGLES20) m19755b(2131567149);
        this.f20118i = (ViEAndroidGLES20SurfaceView) m19755b(2131567150);
        this.f20119j = (UserTileView) m19755b(2131567148);
        this.f20120k = (UserTileView) m19755b(2131567152);
        this.f20121l = (FbTextView) m19755b(2131567151);
        this.f20123n = m19755b(2131567153);
        int a = this.f20115c.a(Liveness.Cached, ExperimentsForRtcModule.bT, 0);
        this.f20126q = a == RtcRenderThreadMode.SURFACE_VIEW.ordinal();
        if (!this.f20126q) {
            this.f20117h.m21556a(a, this.f20116d);
        }
    }

    final void mo830a(LayoutParams layoutParams) {
        Point point = this.f20107a;
        layoutParams.width = point.x;
        layoutParams.height = point.y;
        if (this.f20111f != 0.0f) {
            if (this.f20111f < 1.0f) {
                point.x = (int) (((float) point.y) * (1.0f / this.f20111f));
            } else {
                point.y = (int) (((float) point.x) * this.f20111f);
            }
        }
        if (this.f20126q) {
            this.f20118i.m21565a(point.x, point.y);
        } else {
            this.f20117h.m21555a(point.x, point.y);
        }
    }

    final void mo832e() {
    }

    public final void m19774a(String str) {
        if (this.f20121l.getVisibility() == 0) {
            this.f20121l.setText(str);
        }
    }

    public void setPeerId(long j) {
        this.f20122m = j;
        this.f20119j.setParams(UserTileViewParams.a(UserKey.b(Long.toString(this.f20122m))));
        if (!this.f20112g) {
            this.f20120k.setParams(UserTileViewParams.a(UserKey.b(Long.toString(this.f20122m))));
        }
    }

    private void m19764a(final boolean z, final boolean z2) {
        ExecutorDetour.a(this.f20113a, new Runnable(this) {
            final /* synthetic */ RtcFloatingPeerView f20105c;

            /* compiled from: app_noncanvas_3rdparty */
            class C23621 implements AnimationListener {
                final /* synthetic */ C23632 f20102a;

                C23621(C23632 c23632) {
                    this.f20102a = c23632;
                }

                public void onAnimationStart(Animation animation) {
                    if (z) {
                        this.f20102a.f20105c.f20123n.setVisibility(0);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    if (!z) {
                        this.f20102a.f20105c.f20123n.setVisibility(8);
                    }
                }
            }

            public void run() {
                if (this.f20105c.f20123n.getAnimation() != null) {
                    this.f20105c.f20123n.clearAnimation();
                }
                if (!z2) {
                    int i;
                    View view = this.f20105c.f20123n;
                    if (z) {
                        i = 0;
                    } else {
                        i = 8;
                    }
                    view.setVisibility(i);
                } else if (this.f20105c.f20127r != z) {
                    this.f20105c.f20127r = z;
                    Animation alphaAnimation = z ? new AlphaAnimation(0.0f, 1.0f) : new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setDuration(100);
                    alphaAnimation.setAnimationListener(new C23621(this));
                    this.f20105c.f20123n.startAnimation(alphaAnimation);
                }
            }
        }, -509798704);
    }
}
