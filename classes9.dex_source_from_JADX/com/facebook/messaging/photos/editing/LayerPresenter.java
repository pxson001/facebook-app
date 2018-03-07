package com.facebook.messaging.photos.editing;

import android.graphics.Matrix;
import android.view.View;
import com.facebook.messaging.photos.editing.Layer.Event;
import com.facebook.messaging.photos.editing.SceneLayersPresenter.C19054;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;

/* compiled from: dispatchActivityDestroy */
public class LayerPresenter {
    private static final SpringConfig f16037a = new SpringConfig(200.0d, 20.0d);
    public final Layer f16038b;
    public final View f16039c;
    private final Matrix f16040d = new Matrix();
    public final Spring f16041e;
    private final Observer f16042f = new C18781(this);
    public boolean f16043g = true;
    public boolean f16044h;
    private float f16045i;
    private boolean f16046j;
    public C19054 f16047k;

    /* compiled from: dispatchActivityDestroy */
    class C18781 implements Observer {
        final /* synthetic */ LayerPresenter f16034a;

        C18781(LayerPresenter layerPresenter) {
            this.f16034a = layerPresenter;
        }

        public final void mo663a(Object obj) {
            this.f16034a.mo674a(obj);
        }
    }

    /* compiled from: dispatchActivityDestroy */
    class FlipSpringListener extends SimpleSpringListener {
        final /* synthetic */ LayerPresenter f16036a;

        public FlipSpringListener(LayerPresenter layerPresenter) {
            this.f16036a = layerPresenter;
        }

        public final void m16184a(Spring spring) {
            this.f16036a.m16199q();
        }
    }

    protected LayerPresenter(Layer layer, View view, SpringSystem springSystem) {
        this.f16038b = layer;
        this.f16039c = view;
        this.f16041e = springSystem.a().a(f16037a).a(new FlipSpringListener(this));
    }

    public void mo675c() {
        Layer layer = this.f16038b;
        layer.f16027a.m16224a(this.f16042f);
    }

    public void mo678d() {
        Layer layer = this.f16038b;
        layer.f16027a.m16226b(this.f16042f);
    }

    public void mo679e() {
    }

    public void mo680f() {
    }

    public void mo681g() {
    }

    public final void m16185a(float f) {
        if (this.f16045i != f) {
            this.f16045i = f;
            m16198p();
        }
    }

    protected void mo674a(Object obj) {
        if (obj instanceof Event) {
            switch ((Event) obj) {
                case TRANSLATE:
                    m16197o();
                    return;
                case ROTATE:
                    m16198p();
                    return;
                case SCALE:
                    m16199q();
                    return;
                case FLIP:
                    double d;
                    Spring spring = this.f16041e;
                    if (this.f16038b.f16032f) {
                        d = 1.0d;
                    } else {
                        d = 0.0d;
                    }
                    spring.b(d);
                    return;
                default:
                    return;
            }
        }
    }

    protected float mo682j() {
        return this.f16038b.f16028b;
    }

    protected float mo683k() {
        return this.f16038b.f16029c;
    }

    protected float mo684l() {
        return this.f16045i + this.f16038b.f16031e;
    }

    protected float mo685m() {
        float f = this.f16038b.f16030d;
        return MathUtil.m16201a(f, -f, (float) this.f16041e.d());
    }

    protected float mo686n() {
        float f = this.f16038b.f16030d;
        float d = (float) this.f16041e.d();
        if (d > 0.5f) {
            d = 1.0f - d;
        }
        return MathUtil.m16201a(f, 1.2f * f, d / 0.5f);
    }

    protected final void m16197o() {
        this.f16046j = true;
        this.f16039c.setTranslationX(mo682j());
        this.f16039c.setTranslationY(mo683k());
    }

    protected final void m16198p() {
        this.f16046j = true;
        this.f16039c.setRotation(mo684l());
    }

    protected final void m16199q() {
        this.f16046j = true;
        this.f16039c.setScaleX(mo685m());
        this.f16039c.setScaleY(mo686n());
    }

    public final Matrix m16200r() {
        if (this.f16046j) {
            this.f16046j = false;
            this.f16040d.reset();
            this.f16040d.postRotate(this.f16039c.getRotation());
            this.f16040d.postScale(this.f16039c.getScaleX(), this.f16039c.getScaleY());
            this.f16040d.postTranslate(this.f16039c.getTranslationX(), this.f16039c.getTranslationY());
            this.f16040d.invert(this.f16040d);
        }
        return this.f16040d;
    }
}
