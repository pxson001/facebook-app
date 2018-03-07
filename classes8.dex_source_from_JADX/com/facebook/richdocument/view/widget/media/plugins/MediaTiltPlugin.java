package com.facebook.richdocument.view.widget.media.plugins;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.hardware.SensorManager;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.inject.FbInjector;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEvents.MediaTiltEventListenerRequest;
import com.facebook.richdocument.event.RichDocumentEvents.MediaTiltEventListenerRequest.RequestType;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.richdocument.view.transition.MapState;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.MediaTransitionState.PresentationMode;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.transition.ViewRect;
import com.facebook.richdocument.view.transition.motion.MediaTiltEventListener;
import com.facebook.richdocument.view.widget.SlideshowView;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.OnMediaTouchListener;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import javax.inject.Inject;

/* compiled from: num_assets */
public class MediaTiltPlugin extends BaseMediaFramePlugin<Float> implements MediaTiltEventListener {
    private static final SpringConfig f7682d = SpringConfig.a(RichDocumentUIConfig.f6551d, RichDocumentUIConfig.f6552e);
    @Inject
    public RichDocumentEventBus f7683a;
    @Inject
    public SpringSystem f7684b;
    @Inject
    public QeAccessor f7685c;
    private final Spring f7686e;
    public final Spring f7687f;
    public final Paint f7688g;
    private final boolean f7689h;
    private TouchPanningHandler f7690i;
    public PluginState f7691j = PluginState.INACTIVE;
    public float f7692k;
    private float f7693l;
    private MapState f7694m;

    /* compiled from: num_assets */
    enum PanningTouchState {
        WAITING_FOR_DOWN,
        WAITING_FOR_MOVES,
        ACCEPTING_MOVE_EVENTS
    }

    /* compiled from: num_assets */
    public enum PluginState {
        INACTIVE,
        SENSOR,
        TOUCH;

        public final boolean isActive() {
            return this == SENSOR || this == TOUCH;
        }
    }

    /* compiled from: num_assets */
    class TouchPanningHandler implements OnMediaTouchListener {
        final /* synthetic */ MediaTiltPlugin f7677a;
        private final int f7678b;
        private float f7679c;
        private float f7680d;
        private PanningTouchState f7681e = PanningTouchState.WAITING_FOR_DOWN;

        public TouchPanningHandler(MediaTiltPlugin mediaTiltPlugin, Context context) {
            this.f7677a = mediaTiltPlugin;
            this.f7678b = context.getResources().getDimensionPixelSize(2131431837);
        }

        public final boolean mo512a(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && this.f7681e == PanningTouchState.WAITING_FOR_DOWN) {
                this.f7681e = PanningTouchState.WAITING_FOR_MOVES;
                this.f7679c = motionEvent.getX();
                this.f7680d = this.f7677a.f7692k;
                return false;
            } else if (motionEvent.getAction() == 2 && this.f7681e == PanningTouchState.WAITING_FOR_MOVES) {
                if (Math.abs(motionEvent.getX() - this.f7679c) < ((float) this.f7678b)) {
                    return false;
                }
                this.f7681e = PanningTouchState.ACCEPTING_MOVE_EVENTS;
                m7956a(motionEvent.getX());
                return true;
            } else if (motionEvent.getAction() == 2 && this.f7681e == PanningTouchState.ACCEPTING_MOVE_EVENTS) {
                return true;
            } else {
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                this.f7681e = PanningTouchState.WAITING_FOR_DOWN;
                return false;
            }
        }

        public final boolean mo513b(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1 && this.f7681e == PanningTouchState.ACCEPTING_MOVE_EVENTS) {
                this.f7681e = PanningTouchState.WAITING_FOR_DOWN;
                return true;
            } else if (motionEvent.getAction() != 2 || this.f7681e != PanningTouchState.ACCEPTING_MOVE_EVENTS) {
                return false;
            } else {
                m7956a(motionEvent.getX());
                return true;
            }
        }

        private void m7956a(float f) {
            float f2 = -1.0f;
            int width = this.f7677a.m7894h().getWidth();
            int width2 = this.f7677a.m7895i().getWidth();
            float f3 = (-((((RichDocumentUIConfig.f6559l * ((float) width2)) / ((float) width)) * (f - this.f7679c)) / ((float) width2))) + this.f7680d;
            if (f3 >= -1.0f) {
                if (f3 > 1.0f) {
                    f2 = 1.0f;
                } else {
                    f2 = f3;
                }
            }
            this.f7677a.m7966a(Float.valueOf(f2));
        }
    }

    public static void m7959a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MediaTiltPlugin mediaTiltPlugin = (MediaTiltPlugin) obj;
        RichDocumentEventBus a = RichDocumentEventBus.m5130a(fbInjector);
        SpringSystem b = SpringSystem.b(fbInjector);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        mediaTiltPlugin.f7683a = a;
        mediaTiltPlugin.f7684b = b;
        mediaTiltPlugin.f7685c = qeAccessor;
    }

    public MediaTiltPlugin(MediaFrame mediaFrame) {
        super(mediaFrame);
        Class cls = MediaTiltPlugin.class;
        m7959a((Object) this, getContext());
        final ViewGroup h = m7894h();
        Resources resources = m7893g().getResources();
        Paint paint = new Paint(1);
        paint.setColor(resources.getColor(2131363467));
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(resources.getDimension(2131431822));
        this.f7688g = paint;
        Spring a = this.f7684b.a().a(f7682d);
        a.c = true;
        this.f7687f = a.l().a(new SimpleSpringListener(this) {
            final /* synthetic */ MediaTiltPlugin f7674b;

            public final void m7954a(Spring spring) {
                super.a(spring);
                this.f7674b.f7688g.setAlpha(Math.round(((float) spring.d()) * 255.0f));
                h.invalidate();
            }
        });
        a = this.f7684b.a().a(f7682d);
        a.c = true;
        this.f7686e = a.l().a(new SimpleSpringListener(this) {
            final /* synthetic */ MediaTiltPlugin f7676b;

            public final void m7955a(Spring spring) {
                super.a(spring);
                this.f7676b.f7692k = (float) spring.d();
                this.f7676b.m7971c(this.f7676b.f7617a.getCurrentLayout());
                h.requestLayout();
            }
        });
        this.f7690i = new TouchPanningHandler(this, getContext());
        this.f7689h = this.f7685c.a(ExperimentsForRichDocumentAbtestModule.a, true);
    }

    public final void mo508c() {
        this.f7692k = 0.0f;
        this.f7694m = MapState.HIDDEN;
    }

    public final void mo509d() {
        m7960l();
    }

    public final void mo510e() {
        m7960l();
    }

    public final void m7966a(Float f) {
        if (this.f7691j.isActive() && f.floatValue() != this.f7692k) {
            this.f7693l = f.floatValue();
            this.f7686e.a((double) this.f7692k);
            this.f7686e.b((double) this.f7693l);
            m7886a((Object) f);
        }
    }

    public final void mo503a(MediaTransitionState mediaTransitionState) {
        m7960l();
    }

    public final void mo506b(ViewLayout viewLayout) {
        m7960l();
        m7971c(viewLayout);
    }

    private void m7960l() {
        PluginState pluginState = this.f7691j;
        if (!m7962n()) {
            this.f7691j = PluginState.INACTIVE;
        } else if (m7961m()) {
            this.f7691j = PluginState.SENSOR;
        } else {
            this.f7691j = PluginState.TOUCH;
        }
        if (this.f7691j != pluginState) {
            if (this.f7691j == PluginState.SENSOR) {
                this.f7683a.a(new MediaTiltEventListenerRequest(this, RequestType.REGISTER));
            } else {
                this.f7683a.a(new MediaTiltEventListenerRequest(this, RequestType.UNREGISTER));
            }
            if (this.f7691j.isActive()) {
                if (this.f7692k != 0.0f) {
                    this.f7686e.b(0.0d);
                }
                MediaTransitionState j = m7896j();
                if (j.f6981e == PresentationMode.EXPANDED && ((double) j.f6983g) >= RichDocumentUIConfig.f6554g) {
                    this.f7687f.a(0.0d);
                    this.f7687f.b(RichDocumentUIConfig.f6553f);
                    return;
                }
                return;
            }
            ViewLayout a = this.f7617a.getTransitionStrategy().m7196a(m7896j(), false);
            if (a != null) {
                if (BaseMediaFramePlugin.m7881a(a, m7895i()).m7328e() < BaseMediaFramePlugin.m7881a(a, m7894h()).m7328e() && this.f7692k != 0.0f) {
                    this.f7686e.a((double) this.f7692k);
                    this.f7686e.b(0.0d);
                }
            }
        }
    }

    private boolean m7961m() {
        return this.f7689h && ((SensorManager) getContext().getSystemService("sensor")).getDefaultSensor(4) != null;
    }

    private boolean m7962n() {
        if (m7895i().getVisibility() == 0 && m7896j().f6981e == PresentationMode.EXPANDED && this.f7694m == MapState.HIDDEN) {
            boolean z = false;
            ViewLayout a = this.f7617a.getTransitionStrategy().m7196a(MediaTransitionState.f6978b, false);
            if (a != null) {
                if (BaseMediaFramePlugin.m7881a(a, m7895i()).m7328e() > BaseMediaFramePlugin.m7881a(a, m7894h()).m7328e()) {
                    z = true;
                }
            }
            if (z && (m7961m() || !(m7893g().getParent() instanceof SlideshowView))) {
                return true;
            }
        }
        return false;
    }

    public final void m7971c(ViewLayout viewLayout) {
        if (viewLayout != null) {
            ViewRect a = BaseMediaFramePlugin.m7881a(viewLayout, m7894h());
            ViewRect a2 = BaseMediaFramePlugin.m7881a(viewLayout, m7895i());
            if (a != null && a2 != null) {
                a2.m7325b(Math.round((((float) (a.m7328e() - a2.m7328e())) * (1.0f + this.f7692k)) / 2.0f));
            }
        }
    }

    public final void mo505a(MediaFramePlugin mediaFramePlugin, Object obj) {
        if (mediaFramePlugin instanceof MapUnderlayPlugin) {
            this.f7694m = (MapState) obj;
            m7960l();
        }
    }

    public final void mo502a(Canvas canvas) {
        if (this.f7691j.isActive()) {
            canvas.save();
            ViewLayout currentLayout = this.f7617a.getCurrentLayout();
            if (currentLayout != null) {
                ViewRect a = BaseMediaFramePlugin.m7881a(currentLayout, m7894h());
                ViewRect a2 = BaseMediaFramePlugin.m7881a(currentLayout, m7895i());
                if (!(a == null || a2 == null)) {
                    int e = a.m7328e();
                    int e2 = a2.m7328e();
                    float f = ((float) e) / ((float) e2);
                    int round = Math.round(((float) e) * f);
                    e2 = Math.round(((float) Math.round((((float) (e - e2)) * (1.0f + this.f7692k)) / 2.0f)) * (-1.0f * f));
                    int round2 = Math.round(((float) (a.m7329f() + a.f7004a.top)) - this.f7688g.getStrokeWidth());
                    canvas.drawLine((float) e2, (float) round2, (float) (e2 + round), (float) round2, this.f7688g);
                }
                canvas.restore();
            }
        }
    }

    public final boolean m7967a(MotionEvent motionEvent) {
        return this.f7691j == PluginState.TOUCH ? this.f7690i.mo512a(motionEvent) : false;
    }

    public final boolean m7969b(MotionEvent motionEvent) {
        return this.f7691j == PluginState.TOUCH ? this.f7690i.mo513b(motionEvent) : false;
    }
}
