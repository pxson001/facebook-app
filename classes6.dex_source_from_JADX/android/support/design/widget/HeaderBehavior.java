package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: pushable_tristate */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private Runnable f6866a;
    public ScrollerCompat f6867b;
    private boolean f6868c;
    private int f6869d = -1;
    private int f6870e;
    private int f6871f = -1;
    private VelocityTracker f6872g;

    /* compiled from: pushable_tristate */
    class FlingRunnable implements Runnable {
        final /* synthetic */ HeaderBehavior f7041a;
        private final CoordinatorLayout f7042b;
        private final V f7043c;

        FlingRunnable(HeaderBehavior headerBehavior, CoordinatorLayout coordinatorLayout, V v) {
            this.f7041a = headerBehavior;
            this.f7042b = coordinatorLayout;
            this.f7043c = v;
        }

        public void run() {
            if (this.f7043c != null && this.f7041a.f6867b != null && this.f7041a.f6867b.g()) {
                this.f7041a.m9987a(this.f7042b, this.f7043c, this.f7041a.f6867b.c());
                ViewCompat.a(this.f7043c, this);
            }
        }
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f6871f < 0) {
            this.f6871f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f6868c) {
            return true;
        }
        int y;
        switch (MotionEventCompat.a(motionEvent)) {
            case 0:
                this.f6868c = false;
                int x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                if (mo855c(v) && coordinatorLayout.m10125a((View) v, x, y)) {
                    this.f6870e = y;
                    this.f6869d = MotionEventCompat.b(motionEvent, 0);
                    m9985b();
                    break;
                }
            case 1:
            case 3:
                this.f6868c = false;
                this.f6869d = -1;
                if (this.f6872g != null) {
                    this.f6872g.recycle();
                    this.f6872g = null;
                    break;
                }
                break;
            case 2:
                y = this.f6869d;
                if (y != -1) {
                    y = MotionEventCompat.a(motionEvent, y);
                    if (y != -1) {
                        y = (int) MotionEventCompat.d(motionEvent, y);
                        if (Math.abs(y - this.f6870e) > this.f6871f) {
                            this.f6868c = true;
                            this.f6870e = y;
                            break;
                        }
                    }
                }
                break;
        }
        if (this.f6872g != null) {
            this.f6872g.addMovement(motionEvent);
        }
        return this.f6868c;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f6871f < 0) {
            this.f6871f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (MotionEventCompat.a(motionEvent)) {
            case 0:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.m10125a((View) v, (int) motionEvent.getX(), y) && mo855c(v)) {
                    this.f6870e = y;
                    this.f6869d = MotionEventCompat.b(motionEvent, 0);
                    m9985b();
                    break;
                }
                return false;
                break;
            case 1:
                if (this.f6872g != null) {
                    this.f6872g.addMovement(motionEvent);
                    this.f6872g.computeCurrentVelocity(1000);
                    m9990a(coordinatorLayout, (View) v, -mo853a(v), 0, VelocityTrackerCompat.b(this.f6872g, this.f6869d));
                    break;
                }
                break;
            case 2:
                int a = MotionEventCompat.a(motionEvent, this.f6869d);
                if (a != -1) {
                    a = (int) MotionEventCompat.d(motionEvent, a);
                    int i = this.f6870e - a;
                    if (!this.f6868c && Math.abs(i) > this.f6871f) {
                        this.f6868c = true;
                        i = i > 0 ? i - this.f6871f : i + this.f6871f;
                    }
                    if (this.f6868c) {
                        this.f6870e = a;
                        m9991b(coordinatorLayout, v, i, mo854b(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case 3:
                break;
        }
        this.f6868c = false;
        this.f6869d = -1;
        if (this.f6872g != null) {
            this.f6872g.recycle();
            this.f6872g = null;
        }
        if (this.f6872g != null) {
            this.f6872g.addMovement(motionEvent);
        }
        return true;
    }

    final int m9987a(CoordinatorLayout coordinatorLayout, V v, int i) {
        return mo852a(coordinatorLayout, (View) v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int mo852a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i2 == 0 || topAndBottomOffset < i2 || topAndBottomOffset > i3) {
            return 0;
        }
        int a = MathUtils.m10148a(i, i2, i3);
        if (topAndBottomOffset == a) {
            return 0;
        }
        setTopAndBottomOffset(a);
        return topAndBottomOffset - a;
    }

    int mo851a() {
        return getTopAndBottomOffset();
    }

    final int m9991b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return mo852a(coordinatorLayout, (View) v, mo851a() - i, i2, i3);
    }

    final boolean m9990a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        if (this.f6866a != null) {
            v.removeCallbacks(this.f6866a);
            this.f6866a = null;
        }
        if (this.f6867b == null) {
            this.f6867b = ScrollerCompat.a(v.getContext());
        }
        this.f6867b.a(0, getTopAndBottomOffset(), 0, Math.round(f), 0, 0, i, i2);
        if (!this.f6867b.g()) {
            return false;
        }
        this.f6866a = new FlingRunnable(this, coordinatorLayout, v);
        ViewCompat.a(v, this.f6866a);
        return true;
    }

    boolean mo855c(V v) {
        return false;
    }

    int mo854b(V v) {
        return -v.getHeight();
    }

    int mo853a(V v) {
        return v.getHeight();
    }

    private void m9985b() {
        if (this.f6872g == null) {
            this.f6872g = VelocityTracker.obtain();
        }
    }
}
