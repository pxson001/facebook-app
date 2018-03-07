package com.facebook.widget.mediareorderview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import javax.inject.Inject;

/* compiled from: location_opt_in_google_play_location_status_check_failed */
public class MovableImageView extends FbDraweeView {
    private static final SpringConfig f9895c = SpringConfig.a(250.0d, 20.0d);
    private Rect f9896d;
    private Rect f9897e;
    private Rect f9898f;
    public SpringSystem f9899g;
    private Spring f9900h;
    public double f9901i;
    private boolean f9902j;
    public EventListener f9903k;

    /* compiled from: location_opt_in_google_play_location_status_check_failed */
    public interface EventListener {
        void mo626a();

        void mo627b();
    }

    /* compiled from: location_opt_in_google_play_location_status_check_failed */
    class InternalSpringListener extends SimpleSpringListener {
        final /* synthetic */ MovableImageView f9894a;

        public InternalSpringListener(MovableImageView movableImageView) {
            this.f9894a = movableImageView;
        }

        public final void m11608a(Spring spring) {
            this.f9894a.m11616b(spring.d(), 0.0d, this.f9894a.f9901i);
            if (this.f9894a.f9903k != null) {
                this.f9894a.f9903k.mo626a();
            }
        }

        public final void m11609b(Spring spring) {
            if (this.f9894a.f9903k != null) {
                this.f9894a.f9903k.mo627b();
            }
        }
    }

    private static <T extends View> void m11613a(Class<T> cls, T t) {
        m11614a((Object) t, t.getContext());
    }

    private static void m11614a(Object obj, Context context) {
        ((MovableImageView) obj).f9899g = SpringSystem.b(FbInjector.get(context));
    }

    public MovableImageView(Context context) {
        super(context);
        m11617e();
    }

    public MovableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11617e();
    }

    public MovableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11617e();
    }

    @Inject
    private void m11611a(SpringSystem springSystem) {
        this.f9899g = springSystem;
    }

    private void m11617e() {
        m11613a(MovableImageView.class, (View) this);
        setPivotX(0.0f);
        setPivotY(0.0f);
        this.f9896d = new Rect();
        this.f9897e = new Rect();
        this.f9898f = new Rect();
        this.f9902j = true;
        Spring a = this.f9899g.a().a(f9895c);
        a.c = true;
        this.f9900h = a.a(0.0d).l().a(new InternalSpringListener(this));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2102067007);
        super.onSizeChanged(i, i2, i3, i4);
        m11619g();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -43599301, a);
    }

    public final void m11623c() {
        this.f9902j = true;
    }

    public final void m11625d() {
        this.f9902j = false;
    }

    public void setCurrentRect(Rect rect) {
        this.f9898f.set(rect);
        if (!this.f9902j || this.f9900h.k()) {
            m11619g();
        } else {
            m11618f();
        }
    }

    public Rect getCurrentRect() {
        return new Rect(this.f9898f);
    }

    public int getCurrentHeight() {
        return this.f9898f.height();
    }

    public int getCurrentWidth() {
        return this.f9898f.width();
    }

    public void setEndRect(Rect rect) {
        this.f9897e.set(rect);
        this.f9896d.set(this.f9898f);
        if (this.f9902j) {
            m11618f();
        }
    }

    public Rect getEndRect() {
        return new Rect(this.f9897e);
    }

    public int getCurrentRectCenterY() {
        return this.f9898f.centerY();
    }

    public int getEndRectCenterY() {
        return this.f9897e.centerY();
    }

    private void m11618f() {
        this.f9901i = Math.sqrt(Math.pow((double) (this.f9896d.exactCenterX() - this.f9897e.exactCenterX()), 2.0d) + Math.pow((double) (this.f9896d.exactCenterY() - this.f9897e.exactCenterY()), 2.0d));
        if (this.f9901i > 0.0d) {
            this.f9900h.a(0.0d).b(this.f9901i);
            return;
        }
        this.f9898f.set(this.f9897e);
        m11619g();
        if (this.f9903k != null) {
            this.f9903k.mo627b();
        }
    }

    public final void m11621a(int i, int i2) {
        this.f9898f.offset(i, i2);
        setCurrentRect(this.f9898f);
    }

    public final void m11622b(int i, int i2) {
        this.f9897e.offset(i, i2);
        setEndRect(this.f9897e);
    }

    public final void m11624c(int i, int i2) {
        this.f9897e.offsetTo(i - (this.f9897e.width() / 2), i2 - (this.f9897e.height() / 2));
        setEndRect(this.f9897e);
    }

    public final void m11620a(double d, double d2, double d3) {
        m11616b(d, d2, d3);
    }

    public void setEventListener(EventListener eventListener) {
        this.f9903k = eventListener;
    }

    public void setSpringConfig(SpringConfig springConfig) {
        this.f9900h.a(springConfig);
    }

    private void m11619g() {
        if (getWidth() != 0 && getHeight() != 0) {
            setTranslationX((float) this.f9898f.left);
            setTranslationY((float) this.f9898f.top);
            setScaleX(((float) this.f9898f.width()) / ((float) getWidth()));
            setScaleY(((float) this.f9898f.height()) / ((float) getHeight()));
        }
    }

    private void m11616b(double d, double d2, double d3) {
        this.f9898f.left = (int) SpringUtil.a(d, d2, d3, (double) this.f9896d.left, (double) this.f9897e.left);
        this.f9898f.top = (int) SpringUtil.a(d, d2, d3, (double) this.f9896d.top, (double) this.f9897e.top);
        this.f9898f.right = (int) SpringUtil.a(d, d2, d3, (double) this.f9896d.right, (double) this.f9897e.right);
        this.f9898f.bottom = (int) SpringUtil.a(d, d2, d3, (double) this.f9896d.bottom, (double) this.f9897e.bottom);
        m11619g();
    }
}
