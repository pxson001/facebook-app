package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

/* compiled from: user_title */
public class ViewDragHelper {
    private static final Interpolator f549v = new C00361();
    public int f550a;
    public int f551b;
    private int f552c = -1;
    public float[] f553d;
    public float[] f554e;
    public float[] f555f;
    public float[] f556g;
    public int[] f557h;
    public int[] f558i;
    public int[] f559j;
    public int f560k;
    private VelocityTracker f561l;
    private float f562m;
    public float f563n;
    public int f564o;
    public int f565p;
    private ScrollerCompat f566q;
    private final Callback f567r;
    public View f568s;
    private boolean f569t;
    public final ViewGroup f570u;
    private final Runnable f571w = new C00372(this);

    /* compiled from: user_title */
    public abstract class Callback {
        public abstract boolean mo181a(View view);

        public void mo177a(int i) {
        }

        public void mo180a(View view, int i) {
        }

        public void mo184b(View view) {
        }

        public void mo179a(View view, float f, float f2) {
        }

        public void mo183b() {
        }

        public boolean mo187c() {
            return false;
        }

        public void mo178a(int i, int i2) {
        }

        public int mo185c(View view) {
            return 0;
        }

        public int mo182b(View view, int i) {
            return 0;
        }

        public int mo186c(View view, int i) {
            return 0;
        }
    }

    /* compiled from: user_title */
    final class C00361 implements Interpolator {
        C00361() {
        }

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* compiled from: user_title */
    class C00372 implements Runnable {
        final /* synthetic */ ViewDragHelper f548a;

        C00372(ViewDragHelper viewDragHelper) {
            this.f548a = viewDragHelper;
        }

        public void run() {
            this.f548a.m1052b(0);
        }
    }

    public static ViewDragHelper m1029a(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    public static ViewDragHelper m1028a(ViewGroup viewGroup, float f, Callback callback) {
        ViewDragHelper a = m1029a(viewGroup, callback);
        a.f551b = (int) (((float) a.f551b) * (1.0f / f));
        return a;
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f570u = viewGroup;
            this.f567r = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f564o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f551b = viewConfiguration.getScaledTouchSlop();
            this.f562m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f563n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f566q = ScrollerCompat.a(context, f549v);
        }
    }

    public final int m1044a() {
        return this.f550a;
    }

    public final void m1045a(int i) {
        this.f565p = i;
    }

    public final void m1046a(View view, int i) {
        if (view.getParent() != this.f570u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f570u + ")");
        }
        this.f568s = view;
        this.f552c = i;
        this.f567r.mo184b(view);
        m1052b(1);
    }

    public final void m1055e() {
        this.f552c = -1;
        if (this.f553d != null) {
            Arrays.fill(this.f553d, 0.0f);
            Arrays.fill(this.f554e, 0.0f);
            Arrays.fill(this.f555f, 0.0f);
            Arrays.fill(this.f556g, 0.0f);
            Arrays.fill(this.f557h, 0);
            Arrays.fill(this.f558i, 0);
            Arrays.fill(this.f559j, 0);
            this.f560k = 0;
        }
        if (this.f561l != null) {
            this.f561l.recycle();
            this.f561l = null;
        }
    }

    public final void m1056f() {
        m1055e();
        if (this.f550a == 2) {
            this.f566q.b();
            this.f566q.c();
            this.f566q.h();
            int b = this.f566q.b();
            this.f566q.c();
            this.f567r.mo180a(this.f568s, b);
        }
        m1052b(0);
    }

    public final boolean m1049a(View view, int i, int i2) {
        this.f568s = view;
        this.f552c = -1;
        boolean a = m1033a(i, i2, 0, 0);
        if (!(a || this.f550a != 0 || this.f568s == null)) {
            this.f568s = null;
        }
        return a;
    }

    public final boolean m1047a(int i, int i2) {
        if (this.f569t) {
            return m1033a(i, i2, (int) VelocityTrackerCompat.a(this.f561l, this.f552c), (int) VelocityTrackerCompat.b(this.f561l, this.f552c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean m1033a(int i, int i2, int i3, int i4) {
        int left = this.f568s.getLeft();
        int top = this.f568s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f566q.h();
            m1052b(0);
            return false;
        }
        this.f566q.a(left, top, i5, i6, m1027a(this.f568s, i5, i6, i3, i4));
        m1052b(2);
        return true;
    }

    private int m1027a(View view, int i, int i2, int i3, int i4) {
        int b = m1035b(i3, (int) this.f563n, (int) this.f562m);
        int b2 = m1035b(i4, (int) this.f563n, (int) this.f562m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m1026a(i2, b2, 0))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m1026a(i, b, this.f567r.mo185c(view)))));
    }

    private int m1026a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f570u.getWidth();
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

    private static int m1035b(int i, int i2, int i3) {
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

    private static float m1025a(float f, float f2, float f3) {
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

    public final boolean m1050a(boolean z) {
        if (this.f550a == 2) {
            boolean g = this.f566q.g();
            int b = this.f566q.b();
            int c = this.f566q.c();
            int left = b - this.f568s.getLeft();
            int top = c - this.f568s.getTop();
            if (left != 0) {
                this.f568s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f568s.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.f567r.mo180a(this.f568s, b);
            }
            if (g && b == this.f566q.d() && c == this.f566q.e()) {
                this.f566q.h();
                g = false;
            }
            if (!g) {
                if (z) {
                    this.f570u.post(this.f571w);
                } else {
                    m1052b(0);
                }
            }
        }
        if (this.f550a == 2) {
            return true;
        }
        return false;
    }

    private void m1030a(float f, float f2) {
        this.f569t = true;
        this.f567r.mo179a(this.f568s, f, f2);
        this.f569t = false;
        if (this.f550a == 1) {
            m1052b(0);
        }
    }

    private void m1041d(int i) {
        if (this.f553d != null) {
            this.f553d[i] = 0.0f;
            this.f554e[i] = 0.0f;
            this.f555f[i] = 0.0f;
            this.f556g[i] = 0.0f;
            this.f557h[i] = 0;
            this.f558i[i] = 0;
            this.f559j[i] = 0;
            this.f560k &= (1 << i) ^ -1;
        }
    }

    private void m1042e(int i) {
        if (this.f553d == null || this.f553d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f553d != null) {
                System.arraycopy(this.f553d, 0, obj, 0, this.f553d.length);
                System.arraycopy(this.f554e, 0, obj2, 0, this.f554e.length);
                System.arraycopy(this.f555f, 0, obj3, 0, this.f555f.length);
                System.arraycopy(this.f556g, 0, obj4, 0, this.f556g.length);
                System.arraycopy(this.f557h, 0, obj5, 0, this.f557h.length);
                System.arraycopy(this.f558i, 0, obj6, 0, this.f558i.length);
                System.arraycopy(this.f559j, 0, obj7, 0, this.f559j.length);
            }
            this.f553d = obj;
            this.f554e = obj2;
            this.f555f = obj3;
            this.f556g = obj4;
            this.f557h = obj5;
            this.f558i = obj6;
            this.f559j = obj7;
        }
    }

    private void m1031a(float f, float f2, int i) {
        m1042e(i);
        float[] fArr = this.f553d;
        this.f555f[i] = f;
        fArr[i] = f;
        fArr = this.f554e;
        this.f556g[i] = f2;
        fArr[i] = f2;
        int[] iArr = this.f557h;
        int i2 = (int) f;
        int i3 = (int) f2;
        int i4 = 0;
        if (i2 < this.f570u.getLeft() + this.f564o) {
            i4 = 1;
        }
        if (i3 < this.f570u.getTop() + this.f564o) {
            i4 |= 4;
        }
        if (i2 > this.f570u.getRight() - this.f564o) {
            i4 |= 2;
        }
        if (i3 > this.f570u.getBottom() - this.f564o) {
            i4 |= 8;
        }
        iArr[i] = i4;
        this.f560k |= 1 << i;
    }

    private void m1040c(MotionEvent motionEvent) {
        int c = MotionEventCompat.c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = MotionEventCompat.b(motionEvent, i);
            float c2 = MotionEventCompat.c(motionEvent, i);
            float d = MotionEventCompat.d(motionEvent, i);
            this.f555f[b] = c2;
            this.f556g[b] = d;
        }
    }

    final void m1052b(int i) {
        this.f570u.removeCallbacks(this.f571w);
        if (this.f550a != i) {
            this.f550a = i;
            this.f567r.mo177a(i);
            if (this.f550a == 0) {
                this.f568s = null;
            }
        }
    }

    private boolean m1038b(View view, int i) {
        if (view == this.f568s && this.f552c == i) {
            return true;
        }
        if (view == null || !this.f567r.mo181a(view)) {
            return false;
        }
        this.f552c = i;
        m1046a(view, i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m1048a(android.view.MotionEvent r15) {
        /*
        r14 = this;
        r0 = android.support.v4.view.MotionEventCompat.a(r15);
        r1 = android.support.v4.view.MotionEventCompat.b(r15);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r14.m1055e();
    L_0x000d:
        r2 = r14.f561l;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r14.f561l = r2;
    L_0x0017:
        r2 = r14.f561l;
        r2.addMovement(r15);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x010d;
            case 2: goto L_0x008c;
            case 3: goto L_0x010d;
            case 4: goto L_0x001f;
            case 5: goto L_0x0057;
            case 6: goto L_0x0104;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r14.f550a;
        r1 = 1;
        if (r0 != r1) goto L_0x0112;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r15.getX();
        r1 = r15.getY();
        r2 = 0;
        r2 = android.support.v4.view.MotionEventCompat.b(r15, r2);
        r14.m1031a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r14.m1051b(r0, r1);
        r1 = r14.f568s;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r14.f550a;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r14.m1038b(r0, r2);
    L_0x0048:
        r0 = r14.f557h;
        r0 = r0[r2];
        r1 = r14.f565p;
        r0 = r0 & r1;
        if (r0 == 0) goto L_0x001f;
    L_0x0051:
        r0 = r14.f567r;
        r0.mo183b();
        goto L_0x001f;
    L_0x0057:
        r0 = android.support.v4.view.MotionEventCompat.b(r15, r1);
        r2 = android.support.v4.view.MotionEventCompat.c(r15, r1);
        r1 = android.support.v4.view.MotionEventCompat.d(r15, r1);
        r14.m1031a(r2, r1, r0);
        r3 = r14.f550a;
        if (r3 != 0) goto L_0x0079;
    L_0x006a:
        r1 = r14.f557h;
        r0 = r1[r0];
        r1 = r14.f565p;
        r0 = r0 & r1;
        if (r0 == 0) goto L_0x001f;
    L_0x0073:
        r0 = r14.f567r;
        r0.mo183b();
        goto L_0x001f;
    L_0x0079:
        r3 = r14.f550a;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x007e:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r14.m1051b(r2, r1);
        r2 = r14.f568s;
        if (r1 != r2) goto L_0x001f;
    L_0x0088:
        r14.m1038b(r1, r0);
        goto L_0x001f;
    L_0x008c:
        r2 = android.support.v4.view.MotionEventCompat.c(r15);
        r0 = 0;
        r1 = r0;
    L_0x0092:
        if (r1 >= r2) goto L_0x00ff;
    L_0x0094:
        r3 = android.support.v4.view.MotionEventCompat.b(r15, r1);
        r0 = android.support.v4.view.MotionEventCompat.c(r15, r1);
        r4 = android.support.v4.view.MotionEventCompat.d(r15, r1);
        r5 = r14.f553d;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r14.f554e;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r14.m1051b(r0, r4);
        if (r4 == 0) goto L_0x00fd;
    L_0x00b4:
        r0 = r14.m1034a(r4, r5, r6);
        if (r0 == 0) goto L_0x00fd;
    L_0x00ba:
        r0 = 1;
    L_0x00bb:
        if (r0 == 0) goto L_0x00e9;
    L_0x00bd:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r14.f567r;
        r8 = r9.mo182b(r4, r8);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r14.f567r;
        r10 = r11.mo186c(r4, r10);
        r11 = r14.f567r;
        r11 = r11.mo185c(r4);
        r13 = 0;
        r12 = r13;
        if (r11 == 0) goto L_0x00e3;
    L_0x00df:
        if (r11 <= 0) goto L_0x00e9;
    L_0x00e1:
        if (r8 != r7) goto L_0x00e9;
    L_0x00e3:
        if (r12 == 0) goto L_0x00ff;
    L_0x00e5:
        if (r12 <= 0) goto L_0x00e9;
    L_0x00e7:
        if (r10 == r9) goto L_0x00ff;
    L_0x00e9:
        r14.m1036b(r5, r6, r3);
        r5 = r14.f550a;
        r6 = 1;
        if (r5 == r6) goto L_0x00ff;
    L_0x00f1:
        if (r0 == 0) goto L_0x00f9;
    L_0x00f3:
        r0 = r14.m1038b(r4, r3);
        if (r0 != 0) goto L_0x00ff;
    L_0x00f9:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0092;
    L_0x00fd:
        r0 = 0;
        goto L_0x00bb;
    L_0x00ff:
        r14.m1040c(r15);
        goto L_0x001f;
    L_0x0104:
        r0 = android.support.v4.view.MotionEventCompat.b(r15, r1);
        r14.m1041d(r0);
        goto L_0x001f;
    L_0x010d:
        r14.m1055e();
        goto L_0x001f;
    L_0x0112:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.ViewDragHelper.a(android.view.MotionEvent):boolean");
    }

    public final void m1053b(MotionEvent motionEvent) {
        int i = 0;
        int a = MotionEventCompat.a(motionEvent);
        int b = MotionEventCompat.b(motionEvent);
        if (a == 0) {
            m1055e();
        }
        if (this.f561l == null) {
            this.f561l = VelocityTracker.obtain();
        }
        this.f561l.addMovement(motionEvent);
        float x;
        float y;
        View b2;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = MotionEventCompat.b(motionEvent, 0);
                b2 = m1051b((int) x, (int) y);
                m1031a(x, y, i);
                m1038b(b2, i);
                if ((this.f557h[i] & this.f565p) != 0) {
                    this.f567r.mo183b();
                    return;
                }
                return;
            case 1:
                if (this.f550a == 1) {
                    m1043h();
                }
                m1055e();
                return;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                int i2;
                if (this.f550a == 1) {
                    i = MotionEventCompat.a(motionEvent, this.f552c);
                    x = MotionEventCompat.c(motionEvent, i);
                    i2 = (int) (x - this.f555f[this.f552c]);
                    i = (int) (MotionEventCompat.d(motionEvent, i) - this.f556g[this.f552c]);
                    m1037b(this.f568s.getLeft() + i2, this.f568s.getTop() + i, i2, i);
                    m1040c(motionEvent);
                    return;
                }
                i2 = MotionEventCompat.c(motionEvent);
                while (i < i2) {
                    a = MotionEventCompat.b(motionEvent, i);
                    float c = MotionEventCompat.c(motionEvent, i);
                    float d = MotionEventCompat.d(motionEvent, i);
                    float f = c - this.f553d[a];
                    float f2 = d - this.f554e[a];
                    m1036b(f, f2, a);
                    if (this.f550a != 1) {
                        b2 = m1051b((int) c, (int) d);
                        if (!m1034a(b2, f, f2) || !m1038b(b2, a)) {
                            i++;
                        }
                    }
                    m1040c(motionEvent);
                    return;
                }
                m1040c(motionEvent);
                return;
            case 3:
                if (this.f550a == 1) {
                    m1030a(0.0f, 0.0f);
                }
                m1055e();
                return;
            case 5:
                i = MotionEventCompat.b(motionEvent, b);
                x = MotionEventCompat.c(motionEvent, b);
                y = MotionEventCompat.d(motionEvent, b);
                m1031a(x, y, i);
                if (this.f550a == 0) {
                    m1038b(m1051b((int) x, (int) y), i);
                    if ((this.f557h[i] & this.f565p) != 0) {
                        this.f567r.mo183b();
                        return;
                    }
                    return;
                }
                if (m1039b(this.f568s, (int) x, (int) y)) {
                    m1038b(this.f568s, i);
                    return;
                }
                return;
            case 6:
                a = MotionEventCompat.b(motionEvent, b);
                if (this.f550a == 1 && a == this.f552c) {
                    b = MotionEventCompat.c(motionEvent);
                    while (i < b) {
                        int b3 = MotionEventCompat.b(motionEvent, i);
                        if (b3 != this.f552c) {
                            if (m1051b((int) MotionEventCompat.c(motionEvent, i), (int) MotionEventCompat.d(motionEvent, i)) == this.f568s && m1038b(this.f568s, b3)) {
                                i = this.f552c;
                                if (i == -1) {
                                    m1043h();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m1043h();
                    }
                }
                m1041d(a);
                return;
            default:
                return;
        }
    }

    private void m1036b(float f, float f2, int i) {
        int i2 = 1;
        if (!m1032a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m1032a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m1032a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m1032a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f558i;
            iArr[i] = iArr[i] | i2;
            this.f567r.mo178a(i2, i);
        }
    }

    private boolean m1032a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f557h[i] & i2) != i2 || (this.f565p & i2) == 0 || (this.f559j[i] & i2) == i2 || (this.f558i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f551b) && abs2 <= ((float) this.f551b)) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.f567r.mo187c()) {
            int[] iArr = this.f559j;
            iArr[i] = iArr[i] | i2;
            return false;
        } else if ((this.f558i[i] & i2) != 0 || abs <= ((float) this.f551b)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean m1034a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.f567r.mo185c(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (null > null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) > ((float) (this.f551b * this.f551b))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.f551b)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.f551b)) {
            return false;
        } else {
            return true;
        }
    }

    public final boolean m1054c(int i) {
        int length = this.f553d.length;
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = null;
            int i3 = 1;
            if ((this.f560k & (1 << i2)) == 0) {
                i3 = 0;
            }
            if (i3 != 0) {
                Object obj2;
                Object obj3 = (i & 1) == 1 ? 1 : null;
                if ((i & 2) == 2) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                float f = this.f555f[i2] - this.f553d[i2];
                float f2 = this.f556g[i2] - this.f554e[i2];
                int i4;
                if (obj3 == null || obj2 == null) {
                    if (obj3 != null) {
                        if (Math.abs(f) > ((float) this.f551b)) {
                            i4 = 1;
                        }
                    } else if (obj2 != null && Math.abs(f2) > ((float) this.f551b)) {
                        i4 = 1;
                    }
                } else if ((f * f) + (f2 * f2) > ((float) (this.f551b * this.f551b))) {
                    i4 = 1;
                }
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    private void m1043h() {
        this.f561l.computeCurrentVelocity(1000, this.f562m);
        m1030a(m1025a(VelocityTrackerCompat.a(this.f561l, this.f552c), this.f563n, this.f562m), m1025a(VelocityTrackerCompat.b(this.f561l, this.f552c), this.f563n, this.f562m));
    }

    private void m1037b(int i, int i2, int i3, int i4) {
        int left = this.f568s.getLeft();
        int top = this.f568s.getTop();
        if (i3 != 0) {
            i = this.f567r.mo182b(this.f568s, i);
            this.f568s.offsetLeftAndRight(i - left);
        }
        if (i4 != 0) {
            this.f568s.offsetTopAndBottom(this.f567r.mo186c(this.f568s, i2) - top);
        }
        if (i3 != 0 || i4 != 0) {
            this.f567r.mo180a(this.f568s, i);
        }
    }

    public static boolean m1039b(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public final View m1051b(int i, int i2) {
        for (int childCount = this.f570u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f570u.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}
