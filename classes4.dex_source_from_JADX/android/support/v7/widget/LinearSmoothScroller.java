package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView$SmoothScroller.Action;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: diode_override_toggle */
public abstract class LinearSmoothScroller extends RecyclerView$SmoothScroller {
    private final float f13827a;
    public final LinearInterpolator f13828b = new LinearInterpolator();
    protected final DecelerateInterpolator f13829c = new DecelerateInterpolator();
    public PointF f13830d;
    public int f13831e = 0;
    public int f13832f = 0;

    public abstract PointF mo994a(int i);

    public LinearSmoothScroller(Context context) {
        this.f13827a = mo992a(context.getResources().getDisplayMetrics());
    }

    protected final void mo998a(View view, Action action) {
        int a;
        int a2 = mo993a(view, mo995b());
        int c = m14614c();
        LayoutManager layoutManager = this.f13835c;
        if (layoutManager.h()) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            a = m14604a(layoutManager.i(view) - layoutParams.topMargin, layoutParams.bottomMargin + layoutManager.k(view), layoutManager.z(), layoutManager.x() - layoutManager.B(), c);
        } else {
            a = 0;
        }
        c = a;
        int d = m14605d((int) Math.sqrt((double) ((a2 * a2) + (c * c))));
        if (d > 0) {
            action.m14636a(-a2, -c, d, this.f13829c);
        }
    }

    protected final void mo997a(int i, int i2, Action action) {
        if (m14631i() == 0) {
            m14627e();
            return;
        }
        this.f13831e = m14603a(this.f13831e, i);
        this.f13832f = m14603a(this.f13832f, i2);
        if (this.f13831e == 0 && this.f13832f == 0) {
            PointF a = mo994a(this.f13833a);
            if (a == null || (a.x == 0.0f && a.y == 0.0f)) {
                Log.e("LinearSmoothScroller", "To support smooth scrolling, you should override \nLayoutManager#computeScrollVectorForPosition.\nFalling back to instant scroll");
                action.f13843d = this.f13833a;
                m14627e();
            } else {
                RecyclerView$SmoothScroller.m14617a(a);
                this.f13830d = a;
                this.f13831e = (int) (a.x * 10000.0f);
                this.f13832f = (int) (a.y * 10000.0f);
                action.m14636a((int) (((float) this.f13831e) * 1.2f), (int) (((float) this.f13832f) * 1.2f), (int) (((float) m14613b(10000)) * 1.2f), this.f13828b);
            }
        }
    }

    protected final void mo996a() {
        this.f13832f = 0;
        this.f13831e = 0;
        this.f13830d = null;
    }

    protected float mo992a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    private int m14605d(int i) {
        return (int) Math.ceil(((double) m14613b(i)) / 0.3356d);
    }

    public int m14613b(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.f13827a));
    }

    protected int mo995b() {
        if (this.f13830d == null || this.f13830d.x == 0.0f) {
            return 0;
        }
        return this.f13830d.x > 0.0f ? 1 : -1;
    }

    protected int m14614c() {
        if (this.f13830d == null || this.f13830d.y == 0.0f) {
            return 0;
        }
        return this.f13830d.y > 0.0f ? 1 : -1;
    }

    private static int m14603a(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    public static int m14604a(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case -1:
                return i3 - i;
            case 0:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                i6 = i4 - i2;
                return i6 >= 0 ? 0 : i6;
            case 1:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int mo993a(View view, int i) {
        LayoutManager layoutManager = this.f13835c;
        if (!layoutManager.g()) {
            return 0;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return m14604a(layoutManager.h(view) - layoutParams.leftMargin, layoutParams.rightMargin + layoutManager.j(view), layoutManager.y(), layoutManager.w() - layoutManager.A(), i);
    }
}
