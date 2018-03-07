package com.facebook.widget.bottomsheet;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import java.util.Arrays;

/* compiled from: delivery_type */
public class ViewDragHelper {
    public int f15853a;
    private int f15854b;
    private int f15855c = -1;
    public float[] f15856d;
    public float[] f15857e;
    public float[] f15858f;
    public float[] f15859g;
    public int[] f15860h;
    public int[] f15861i;
    public int[] f15862j;
    public int f15863k;
    private VelocityTracker f15864l;
    private float f15865m;
    private float f15866n;
    public int f15867o;
    private int f15868p;
    public Scroller f15869q;
    public int f15870r;
    private final Callback f15871s;
    public View f15872t;
    private boolean f15873u;
    public final ViewGroup f15874v;
    public final Runnable f15875w = new C12121(this);

    /* compiled from: delivery_type */
    public abstract class Callback {
        public abstract boolean mo1216b();

        public void mo1215a(View view, float f) {
        }

        public int mo1213a() {
            return 0;
        }

        public int mo1214a(int i) {
            return 0;
        }
    }

    /* compiled from: delivery_type */
    class C12121 implements Runnable {
        final /* synthetic */ ViewDragHelper f15896a;

        C12121(ViewDragHelper viewDragHelper) {
            this.f15896a = viewDragHelper;
        }

        public void run() {
            this.f15896a.m19850b(0);
        }
    }

    public ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f15874v = viewGroup;
            this.f15871s = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f15867o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f15854b = viewConfiguration.getScaledTouchSlop();
            this.f15865m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f15866n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f15869q = new Scroller(context);
        }
    }

    private void m19833a(View view, int i) {
        if (view.getParent() != this.f15874v) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f15874v + ")");
        }
        this.f15872t = view;
        this.f15855c = i;
        m19850b(1);
    }

    private void m19840c() {
        this.f15855c = -1;
        if (this.f15856d != null) {
            Arrays.fill(this.f15856d, 0.0f);
            Arrays.fill(this.f15857e, 0.0f);
            Arrays.fill(this.f15858f, 0.0f);
            Arrays.fill(this.f15859g, 0.0f);
            Arrays.fill(this.f15860h, 0);
            Arrays.fill(this.f15861i, 0);
            Arrays.fill(this.f15862j, 0);
            this.f15863k = 0;
        }
        if (this.f15864l != null) {
            this.f15864l.recycle();
            this.f15864l = null;
        }
    }

    public final void m19849b() {
        m19840c();
        if (this.f15853a == 2) {
            this.f15869q.getCurrX();
            this.f15869q.getCurrY();
            this.f15869q.abortAnimation();
            this.f15869q.getCurrX();
            this.f15869q.getCurrY();
        }
        m19850b(0);
    }

    public final boolean m19852b(int i, int i2) {
        if (this.f15873u) {
            return m19838b(i, i2, (int) VelocityTrackerCompat.a(this.f15864l, this.f15855c), (int) VelocityTrackerCompat.b(this.f15864l, this.f15855c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean m19838b(int i, int i2, int i3, int i4) {
        int left = this.f15872t.getLeft();
        int top = this.f15872t.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f15869q.abortAnimation();
            m19850b(0);
            return false;
        }
        this.f15869q.startScroll(left, top, i5, i6, m19830a(this.f15872t, i5, i6, i3, i4));
        this.f15870r = top + i6;
        m19850b(2);
        return true;
    }

    private int m19830a(View view, int i, int i2, int i3, int i4) {
        int b = m19836b(i3, (int) this.f15866n, (int) this.f15865m);
        int b2 = m19836b(i4, (int) this.f15866n, (int) this.f15865m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m19829a(i2, b2, this.f15871s.mo1213a()))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m19829a(i, b, 0))));
    }

    private int m19829a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f15874v.getWidth();
        int i4 = width / 2;
        float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, ((float) Math.abs(i)) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(sin / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private static int m19836b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private static float m19828a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    public final void m19847a(int i, int i2, int i3, int i4) {
        if (this.f15873u) {
            int b = (int) VelocityTrackerCompat.b(this.f15864l, this.f15855c);
            this.f15869q.fling(this.f15872t.getLeft(), this.f15872t.getTop(), (int) VelocityTrackerCompat.a(this.f15864l, this.f15855c), b, i, i3, i2, i4);
            if (b >= 0) {
                i2 = i4;
            }
            this.f15870r = i2;
            m19850b(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    private void m19831a(float f, float f2) {
        this.f15873u = true;
        this.f15871s.mo1215a(this.f15872t, f2);
        this.f15873u = false;
        if (this.f15853a == 1) {
            m19850b(0);
        }
    }

    private void m19841c(int i) {
        if (this.f15856d != null) {
            this.f15856d[i] = 0.0f;
            this.f15857e[i] = 0.0f;
            this.f15858f[i] = 0.0f;
            this.f15859g[i] = 0.0f;
            this.f15860h[i] = 0;
            this.f15861i[i] = 0;
            this.f15862j[i] = 0;
            this.f15863k &= (1 << i) ^ -1;
        }
    }

    private void m19844d(int i) {
        if (this.f15856d == null || this.f15856d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f15856d != null) {
                System.arraycopy(this.f15856d, 0, obj, 0, this.f15856d.length);
                System.arraycopy(this.f15857e, 0, obj2, 0, this.f15857e.length);
                System.arraycopy(this.f15858f, 0, obj3, 0, this.f15858f.length);
                System.arraycopy(this.f15859g, 0, obj4, 0, this.f15859g.length);
                System.arraycopy(this.f15860h, 0, obj5, 0, this.f15860h.length);
                System.arraycopy(this.f15861i, 0, obj6, 0, this.f15861i.length);
                System.arraycopy(this.f15862j, 0, obj7, 0, this.f15862j.length);
            }
            this.f15856d = obj;
            this.f15857e = obj2;
            this.f15858f = obj3;
            this.f15859g = obj4;
            this.f15860h = obj5;
            this.f15861i = obj6;
            this.f15862j = obj7;
        }
    }

    private void m19832a(float f, float f2, int i) {
        m19844d(i);
        float[] fArr = this.f15856d;
        this.f15858f[i] = f;
        fArr[i] = f;
        fArr = this.f15857e;
        this.f15859g[i] = f2;
        fArr[i] = f2;
        int[] iArr = this.f15860h;
        int i2 = (int) f;
        int i3 = (int) f2;
        int i4 = 0;
        if (i2 < this.f15874v.getLeft() + this.f15867o) {
            i4 = 1;
        }
        if (i3 < this.f15874v.getTop() + this.f15867o) {
            i4 |= 4;
        }
        if (i2 > this.f15874v.getRight() - this.f15867o) {
            i4 |= 2;
        }
        if (i3 > this.f15874v.getBottom() - this.f15867o) {
            i4 |= 8;
        }
        iArr[i] = i4;
        this.f15863k |= 1 << i;
    }

    private void m19843c(MotionEvent motionEvent) {
        int c = MotionEventCompat.c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = MotionEventCompat.b(motionEvent, i);
            float c2 = MotionEventCompat.c(motionEvent, i);
            float d = MotionEventCompat.d(motionEvent, i);
            this.f15858f[b] = c2;
            this.f15859g[b] = d;
        }
    }

    public final void m19850b(int i) {
        if (this.f15853a != i) {
            this.f15853a = i;
            if (i == 0) {
                this.f15872t = null;
            }
        }
    }

    private boolean m19839b(View view, int i) {
        if (view == this.f15872t && this.f15855c == i) {
            return true;
        }
        if (view == null || !this.f15871s.mo1216b()) {
            return false;
        }
        this.f15855c = i;
        m19833a(view, i);
        return true;
    }

    public final boolean m19848a(MotionEvent motionEvent) {
        int a = MotionEventCompat.a(motionEvent);
        int b = MotionEventCompat.b(motionEvent);
        if (a == 0) {
            m19840c();
        }
        if (this.f15864l == null) {
            this.f15864l = VelocityTracker.obtain();
        }
        this.f15864l.addMovement(motionEvent);
        float y;
        int b2;
        switch (a) {
            case 0:
                float x = motionEvent.getX();
                y = motionEvent.getY();
                b2 = MotionEventCompat.b(motionEvent, 0);
                m19832a(x, y, b2);
                View a2 = mo1212a((int) x, (int) y);
                if (a2 == this.f15872t && this.f15853a == 2) {
                    m19839b(a2, b2);
                }
                if ((this.f15860h[b2] & this.f15868p) != 0) {
                    break;
                }
                break;
            case 1:
            case 3:
                m19840c();
                break;
            case 2:
                b = MotionEventCompat.c(motionEvent);
                a = 0;
                while (a < b) {
                    b2 = MotionEventCompat.b(motionEvent, a);
                    float c = MotionEventCompat.c(motionEvent, a);
                    float d = MotionEventCompat.d(motionEvent, a);
                    float f = c - this.f15856d[b2];
                    float f2 = d - this.f15857e[b2];
                    m19837b(f, f2, b2);
                    if (this.f15853a != 1) {
                        View a3 = mo1212a((int) c, (int) d);
                        if (a3 == null || !m19835a(a3, f, f2) || !m19839b(a3, b2)) {
                            a++;
                        }
                    }
                    m19843c(motionEvent);
                    break;
                }
                m19843c(motionEvent);
                break;
            case 5:
                a = MotionEventCompat.b(motionEvent, b);
                float c2 = MotionEventCompat.c(motionEvent, b);
                y = MotionEventCompat.d(motionEvent, b);
                m19832a(c2, y, a);
                if (this.f15853a != 0 && this.f15853a == 2) {
                    View a4 = mo1212a((int) c2, (int) y);
                    if (a4 == this.f15872t) {
                        m19839b(a4, a);
                        break;
                    }
                }
                break;
            case 6:
                m19841c(MotionEventCompat.b(motionEvent, b));
                break;
        }
        if (this.f15853a == 1) {
            return true;
        }
        return false;
    }

    public final void m19851b(MotionEvent motionEvent) {
        int i = 0;
        int a = MotionEventCompat.a(motionEvent);
        int b = MotionEventCompat.b(motionEvent);
        if (a == 0) {
            m19840c();
        }
        if (this.f15864l == null) {
            this.f15864l = VelocityTracker.obtain();
        }
        this.f15864l.addMovement(motionEvent);
        float x;
        float y;
        View a2;
        int i2;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = MotionEventCompat.b(motionEvent, 0);
                a2 = mo1212a((int) x, (int) y);
                m19832a(x, y, i);
                m19839b(a2, i);
                if ((this.f15860h[i] & this.f15868p) == 0) {
                    return;
                }
                return;
            case 1:
                if (this.f15853a == 1) {
                    m19845e();
                }
                m19840c();
                return;
            case 2:
                if (this.f15853a == 1) {
                    i = MotionEventCompat.a(motionEvent, this.f15855c);
                    x = MotionEventCompat.c(motionEvent, i);
                    i2 = (int) (x - this.f15858f[this.f15855c]);
                    i = (int) (MotionEventCompat.d(motionEvent, i) - this.f15859g[this.f15855c]);
                    m19842c(this.f15872t.getLeft() + i2, this.f15872t.getTop() + i, i2, i);
                    m19843c(motionEvent);
                    return;
                }
                i2 = MotionEventCompat.c(motionEvent);
                while (i < i2) {
                    a = MotionEventCompat.b(motionEvent, i);
                    float c = MotionEventCompat.c(motionEvent, i);
                    float d = MotionEventCompat.d(motionEvent, i);
                    float f = c - this.f15856d[a];
                    float f2 = d - this.f15857e[a];
                    m19837b(f, f2, a);
                    if (this.f15853a != 1) {
                        a2 = mo1212a((int) c, (int) d);
                        if (!m19835a(a2, f, f2) || !m19839b(a2, a)) {
                            i++;
                        }
                    }
                    m19843c(motionEvent);
                    return;
                }
                m19843c(motionEvent);
                return;
            case 3:
                if (this.f15853a == 1) {
                    m19831a(0.0f, 0.0f);
                }
                m19840c();
                return;
            case 5:
                i = MotionEventCompat.b(motionEvent, b);
                x = MotionEventCompat.c(motionEvent, b);
                y = MotionEventCompat.d(motionEvent, b);
                m19832a(x, y, i);
                if (this.f15853a == 0) {
                    m19839b(mo1212a((int) x, (int) y), i);
                    return;
                }
                i2 = (int) x;
                a = (int) y;
                View view = this.f15872t;
                Object obj = null;
                if (view != null && i2 >= view.getLeft() && i2 < view.getRight() && a >= view.getTop() && a < view.getBottom()) {
                    obj = 1;
                }
                if (obj != null) {
                    m19839b(this.f15872t, i);
                    return;
                }
                return;
            case 6:
                a = MotionEventCompat.b(motionEvent, b);
                if (this.f15853a == 1 && a == this.f15855c) {
                    b = MotionEventCompat.c(motionEvent);
                    while (i < b) {
                        int b2 = MotionEventCompat.b(motionEvent, i);
                        if (b2 != this.f15855c) {
                            if (mo1212a((int) MotionEventCompat.c(motionEvent, i), (int) MotionEventCompat.d(motionEvent, i)) == this.f15872t && m19839b(this.f15872t, b2)) {
                                i = this.f15855c;
                                if (i == -1) {
                                    m19845e();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m19845e();
                    }
                }
                m19841c(a);
                return;
            default:
                return;
        }
    }

    private void m19837b(float f, float f2, int i) {
        int i2 = 1;
        if (!m19834a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m19834a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m19834a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m19834a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f15861i;
            iArr[i] = i2 | iArr[i];
        }
    }

    private boolean m19834a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f15860h[i] & i2) != i2 || (this.f15868p & i2) == 0 || (this.f15862j[i] & i2) == i2 || (this.f15861i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f15854b) && abs2 <= ((float) this.f15854b)) {
            return false;
        }
        if (abs < abs2 * 0.5f && null != null) {
            int[] iArr = this.f15862j;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f15861i[i] & i2) != 0 || abs <= ((float) this.f15854b)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m19835a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (null > null) {
            z = true;
        } else {
            z = false;
        }
        if (this.f15871s.mo1213a() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) > ((float) (this.f15854b * this.f15854b))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.f15854b)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.f15854b)) {
            return false;
        } else {
            return true;
        }
    }

    private void m19845e() {
        this.f15864l.computeCurrentVelocity(1000, this.f15865m);
        m19831a(m19828a(VelocityTrackerCompat.a(this.f15864l, this.f15855c), this.f15866n, this.f15865m), m19828a(VelocityTrackerCompat.b(this.f15864l, this.f15855c), this.f15866n, this.f15865m));
    }

    private void m19842c(int i, int i2, int i3, int i4) {
        int left = this.f15872t.getLeft();
        int top = this.f15872t.getTop();
        if (i3 != 0) {
            this.f15872t.offsetLeftAndRight(0 - left);
        }
        if (i4 != 0) {
            this.f15872t.offsetTopAndBottom(this.f15871s.mo1214a(i2) - top);
        }
    }

    public View mo1212a(int i, int i2) {
        for (int childCount = this.f15874v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f15874v.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}
