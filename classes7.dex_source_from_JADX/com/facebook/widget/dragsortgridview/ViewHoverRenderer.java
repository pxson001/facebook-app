package com.facebook.widget.dragsortgridview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import com.facebook.widget.dragsortgridview.DragSortGridView.C12355;
import javax.annotation.Nullable;

/* compiled from: profile_get_notified_event */
public class ViewHoverRenderer<V extends View & HoverableView> implements HoverRenderer {
    public double f16008a;
    public int f16009b;
    public int f16010c;
    @Nullable
    public V f16011d;
    @Nullable
    private Rect f16012e;
    @Nullable
    public Rect f16013f;
    public final C12355 f16014g;
    private Point f16015h = new Point();

    /* compiled from: profile_get_notified_event */
    public interface HoverableView {
        void mo331a(double d);

        void setHovering(boolean z);
    }

    /* compiled from: profile_get_notified_event */
    public class C12401 implements TypeEvaluator<Double> {
        final /* synthetic */ ViewHoverRenderer f16003a;

        public C12401(ViewHoverRenderer viewHoverRenderer) {
            this.f16003a = viewHoverRenderer;
        }

        public Object evaluate(float f, Object obj, Object obj2) {
            Double d = (Double) obj;
            return Double.valueOf(d.doubleValue() + (((double) f) * (((Double) obj2).doubleValue() - d.doubleValue())));
        }
    }

    public ViewHoverRenderer(C12355 c12355) {
        this.f16014g = c12355;
        this.f16008a = 1.0d;
    }

    public final Point mo1217a(double d) {
        this.f16008a = d;
        ((HoverableView) this.f16011d).mo331a(d);
        this.f16015h.x = (this.f16011d.getWidth() - this.f16013f.width()) / 2;
        this.f16015h.y = (this.f16011d.getHeight() - this.f16013f.height()) / 2;
        int i = this.f16013f.left - this.f16015h.x;
        int i2 = this.f16013f.top - this.f16015h.y;
        this.f16013f.set(i, i2, this.f16011d.getWidth() + i, this.f16011d.getHeight() + i2);
        m19980b(this, this.f16013f.left, this.f16013f.top);
        return this.f16015h;
    }

    public final boolean mo1221a() {
        return this.f16011d != null;
    }

    public final void mo1219a(Canvas canvas) {
        if (this.f16011d != null) {
            int save = canvas.save();
            canvas.translate((float) this.f16009b, (float) this.f16010c);
            this.f16011d.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public final void mo1218a(int i, int i2) {
        this.f16013f.offsetTo(this.f16012e.left + i, this.f16012e.top + i2);
        m19980b(this, this.f16013f.left, this.f16013f.top);
    }

    public final void mo1222b() {
        ((HoverableView) this.f16011d).setHovering(false);
        this.f16011d = null;
    }

    public final void mo1220a(View view) {
        if (view instanceof HoverableView) {
            this.f16012e = m19981c(view);
            this.f16013f = m19981c(view);
            View b = this.f16014g.m19896b(view);
            b.measure(view.getWidth(), view.getHeight());
            b.layout(0, 0, view.getWidth(), view.getHeight());
            this.f16011d = b;
            ((HoverableView) this.f16011d).setHovering(true);
            m19980b(this, this.f16012e.left, this.f16012e.top);
            return;
        }
        Log.e("DragSortGridView", "Trying to use ViewHoverRenderer on a non hoverable view");
    }

    public static Rect m19981c(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    public final Rect mo1224c() {
        return this.f16012e;
    }

    public final Rect mo1225d() {
        return this.f16013f;
    }

    public final void mo1223b(final View view) {
        this.f16013f.set(m19981c(view));
        if (VERSION.SDK_INT > 11) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new C12401(this), new Object[]{Double.valueOf(this.f16008a), Double.valueOf(1.0d)});
            ofObject.setDuration(200);
            final Rect c = m19981c(this.f16011d);
            c.offsetTo(this.f16009b, this.f16010c);
            ofObject.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ ViewHoverRenderer f16005b;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    double doubleValue = ((Double) valueAnimator.getAnimatedValue()).doubleValue();
                    Rect a = ViewHoverRenderer.m19979a(this.f16005b, c, this.f16005b.f16013f, 1.0f - ((float) ((doubleValue - 1.0d) / (this.f16005b.f16008a - 1.0d))));
                    ViewHoverRenderer.m19980b(this.f16005b, a.left, a.top);
                    ((HoverableView) this.f16005b.f16011d).mo331a(doubleValue);
                    this.f16005b.f16014g.m19894a();
                }
            });
            ofObject.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ ViewHoverRenderer f16007b;

                public void onAnimationStart(Animator animator) {
                    this.f16007b.f16014g.m19897b();
                }

                public void onAnimationEnd(Animator animator) {
                    this.f16007b.f16014g.m19898c();
                    this.f16007b.f16014g.m19895a(view);
                }
            });
            ofObject.start();
            return;
        }
        ((HoverableView) this.f16011d).mo331a(1.0d);
        this.f16014g.m19894a();
        this.f16014g.m19895a(view);
    }

    public static void m19980b(ViewHoverRenderer viewHoverRenderer, int i, int i2) {
        viewHoverRenderer.f16009b = i;
        viewHoverRenderer.f16010c = i2;
    }

    public static Rect m19979a(ViewHoverRenderer viewHoverRenderer, Rect rect, Rect rect2, float f) {
        return new Rect(m19978a(rect.left, rect2.left, f), m19978a(rect.top, rect2.top, f), m19978a(rect.right, rect2.right, f), m19978a(rect.bottom, rect2.bottom, f));
    }

    private static int m19978a(int i, int i2, float f) {
        return (int) (((float) i) + (((float) (i2 - i)) * f));
    }
}
