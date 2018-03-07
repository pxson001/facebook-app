package com.facebook.android.maps.internal;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.View;
import android.widget.OverScroller;

/* compiled from: aymt_post_footer_channel */
public class AutoAnimationsHelper implements Runnable {
    private final View f8288a;
    private final Listener f8289b;
    private final OverScroller f8290c;
    private boolean f8291d;
    public boolean f8292e;
    private boolean f8293f;
    private boolean f8294g;
    private float f8295h;
    private float f8296i;
    public boolean f8297j;
    public boolean f8298k;
    private float[] f8299l = new float[2];
    public Matrix f8300m;
    public float f8301n;
    public long f8302o;
    public float f8303p;
    public long f8304q;

    /* compiled from: aymt_post_footer_channel */
    public interface Listener {
        boolean mo1050a(float f);

        boolean mo1053b(float f);

        boolean mo1061g(float f, float f2);

        void mo1062h();
    }

    public AutoAnimationsHelper(View view, Listener listener) {
        this.f8288a = view;
        this.f8289b = listener;
        this.f8290c = new OverScroller(view.getContext());
        if (VERSION.SDK_INT >= 11) {
            this.f8290c.setFriction(0.035f);
        }
    }

    public final void m14423a(int i, int i2, int i3, int i4) {
        this.f8290c.fling(i, i2, i3, i4, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.f8294g = true;
    }

    public final void m14424c() {
        this.f8288a.removeCallbacks(this);
        this.f8293f = false;
        this.f8292e = true;
        m14418a(this);
    }

    public final void m14425d() {
        this.f8288a.removeCallbacks(this);
        this.f8291d = false;
        this.f8292e = false;
        this.f8293f = true;
        m14421i();
        m14420h();
        m14422j();
    }

    public void run() {
        if (this.f8293f) {
            this.f8289b.mo1062h();
            return;
        }
        boolean z;
        Object obj;
        int i;
        if (!this.f8291d) {
            if (this.f8298k) {
                m14421i();
                m14420h();
            } else if (this.f8297j) {
                m14421i();
                m14422j();
            }
            this.f8297j = false;
            this.f8298k = false;
            this.f8291d = true;
        }
        if (this.f8290c.computeScrollOffset()) {
            this.f8299l[0] = (float) this.f8290c.getCurrX();
            this.f8299l[1] = (float) this.f8290c.getCurrY();
            if (this.f8300m != null) {
                this.f8300m.mapPoints(this.f8299l);
            }
            float f = this.f8299l[0];
            float f2 = this.f8299l[1];
            if (this.f8294g) {
                this.f8294g = false;
                this.f8295h = f;
                this.f8296i = f2;
            }
            boolean g = this.f8289b.mo1061g(f - this.f8295h, f2 - this.f8296i);
            this.f8295h = f;
            this.f8296i = f2;
            if (g) {
                z = true;
                obj = 1;
                if (((double) this.f8301n) >= -0.01d || ((double) this.f8301n) > 0.01d) {
                    if (this.f8302o != 0) {
                        this.f8302o = SystemClock.uptimeMillis();
                        i = 1;
                    } else {
                        i = ((int) (SystemClock.uptimeMillis() - this.f8302o)) / 10;
                        this.f8302o += (long) (i * 10);
                    }
                    this.f8301n = (float) (((double) this.f8301n) * Math.pow(0.9150000214576721d, (double) i));
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (this.f8289b.mo1053b(1.0f + this.f8301n)) {
                        m14420h();
                    } else {
                        z = true;
                    }
                }
                if (m14419g()) {
                    if (this.f8289b.mo1050a(this.f8303p)) {
                        m14422j();
                    } else {
                        z = true;
                    }
                }
                if (z) {
                    this.f8291d = false;
                    this.f8292e = false;
                    this.f8289b.mo1062h();
                    return;
                }
                this.f8288a.invalidate();
                m14418a(this);
            }
            m14421i();
        }
        z = false;
        obj = 1;
        if (((double) this.f8301n) >= -0.01d) {
        }
        if (this.f8302o != 0) {
            i = ((int) (SystemClock.uptimeMillis() - this.f8302o)) / 10;
            this.f8302o += (long) (i * 10);
        } else {
            this.f8302o = SystemClock.uptimeMillis();
            i = 1;
        }
        this.f8301n = (float) (((double) this.f8301n) * Math.pow(0.9150000214576721d, (double) i));
        if (obj != null) {
            if (this.f8289b.mo1053b(1.0f + this.f8301n)) {
                m14420h();
            } else {
                z = true;
            }
        }
        if (m14419g()) {
            if (this.f8289b.mo1050a(this.f8303p)) {
                m14422j();
            } else {
                z = true;
            }
        }
        if (z) {
            this.f8291d = false;
            this.f8292e = false;
            this.f8289b.mo1062h();
            return;
        }
        this.f8288a.invalidate();
        m14418a(this);
    }

    @TargetApi(16)
    private void m14418a(Runnable runnable) {
        if (VERSION.SDK_INT >= 16) {
            this.f8288a.postOnAnimation(runnable);
        } else {
            this.f8288a.postDelayed(runnable, 10);
        }
    }

    private boolean m14419g() {
        if (((double) this.f8303p) >= -0.01d && ((double) this.f8303p) <= 0.01d) {
            return false;
        }
        int i;
        if (this.f8304q == 0) {
            this.f8304q = SystemClock.uptimeMillis();
            i = 1;
        } else {
            i = ((int) (SystemClock.uptimeMillis() - this.f8304q)) / 10;
            this.f8304q += (long) (i * 10);
        }
        this.f8303p = (float) (((double) this.f8303p) * Math.pow(0.8500000238418579d, (double) i));
        return true;
    }

    private void m14420h() {
        this.f8301n = 0.0f;
    }

    private void m14421i() {
        this.f8290c.forceFinished(true);
    }

    private void m14422j() {
        this.f8303p = 0.0f;
    }
}
