package com.facebook.ui.touch;

import android.view.MotionEvent;
import com.facebook.debug.log.BLog;
import java.util.Arrays;
import java.util.List;

/* compiled from: creative_med_img_size */
public class DragMotionDetector {
    private static final Class<?> f18361c = DragMotionDetector.class;
    boolean f18362a;
    boolean f18363b;
    private float f18364d;
    private float f18365e;
    private float f18366f;
    private float f18367g;
    private float f18368h;
    private float f18369i;
    private float f18370j;
    private float[] f18371k;
    private float[] f18372l;
    private int f18373m;
    private float f18374n;
    private float f18375o;
    public List<Integer> f18376p;
    private float f18377q;
    private float f18378r;
    private float f18379s;
    private float f18380t;
    private ListenState f18381u;
    private int f18382v;

    /* compiled from: creative_med_img_size */
    enum ListenState {
        MONITORING,
        INTERCEPTING,
        DEFERRING
    }

    private boolean m26967a() {
        return this.f18376p.contains(Integer.valueOf(1)) || this.f18376p.contains(Integer.valueOf(-1));
    }

    public final boolean m26970a(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.f18363b) {
            x = motionEvent.getRawX();
            y = motionEvent.getRawY();
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f18367g = x;
                this.f18368h = y;
                this.f18369i = this.f18367g;
                this.f18370j = this.f18368h;
                this.f18381u = ListenState.MONITORING;
                this.f18374n = 0.0f;
                this.f18375o = 0.0f;
                Arrays.fill(this.f18371k, 0.0f);
                Arrays.fill(this.f18372l, 0.0f);
                if (this.f18362a && !m26969a(this.f18367g, this.f18368h)) {
                    this.f18381u = ListenState.DEFERRING;
                    break;
                }
            case 1:
            case 3:
                if (this.f18381u == ListenState.DEFERRING || this.f18382v == 0) {
                    ListenState listenState = ListenState.DEFERRING;
                }
                this.f18381u = ListenState.MONITORING;
                this.f18382v = 0;
                break;
            case 2:
                float f;
                float f2;
                switch (this.f18381u) {
                    case MONITORING:
                        Object obj;
                        f = x - this.f18367g;
                        f2 = y - this.f18368h;
                        float abs = Math.abs(f);
                        float abs2 = Math.abs(f2);
                        if (BLog.b(2)) {
                            new StringBuilder("abs_dx=").append(abs).append(" dx=").append(f);
                            new StringBuilder("abs_dy=").append(abs2);
                        }
                        this.f18381u = ListenState.INTERCEPTING;
                        if (this.f18376p.contains(Integer.valueOf(10)) || this.f18376p.contains(Integer.valueOf(-10))) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj == null || abs2 <= this.f18364d || !m26968a(abs)) {
                            if (m26967a() && abs > this.f18365e && m26968a(abs2)) {
                                if (f > 0.0f) {
                                    this.f18382v = -1;
                                } else {
                                    this.f18382v = 1;
                                }
                                if (BLog.b(2)) {
                                    Integer.valueOf(this.f18382v);
                                    Float.valueOf(abs);
                                }
                            } else {
                                this.f18381u = ListenState.MONITORING;
                                this.f18382v = 0;
                            }
                        } else if (f2 > 0.0f) {
                            this.f18382v = 10;
                        } else {
                            this.f18382v = -10;
                        }
                        if (!this.f18376p.contains(Integer.valueOf(this.f18382v))) {
                            if (this.f18381u == ListenState.INTERCEPTING) {
                                this.f18381u = ListenState.DEFERRING;
                                break;
                            }
                        }
                        this.f18381u = ListenState.INTERCEPTING;
                        break;
                        break;
                    case INTERCEPTING:
                        f = x - this.f18369i;
                        f2 = y - this.f18370j;
                        this.f18374n += f - this.f18371k[this.f18373m];
                        this.f18371k[this.f18373m] = f;
                        this.f18373m = (this.f18373m + 1) % this.f18371k.length;
                        this.f18375o += f2 - this.f18372l[this.f18373m];
                        this.f18372l[this.f18373m] = f2;
                        this.f18373m = (this.f18373m + 1) % this.f18372l.length;
                        break;
                }
                this.f18369i = x;
                this.f18370j = y;
                break;
        }
        if (this.f18381u == ListenState.INTERCEPTING) {
            return true;
        }
        return false;
    }

    private boolean m26968a(float f) {
        if (this.f18366f <= 0.0f || f <= this.f18366f) {
            return true;
        }
        return false;
    }

    private boolean m26969a(float f, float f2) {
        if (this.f18377q < this.f18378r) {
            if (this.f18379s < this.f18380t) {
                if (f > this.f18377q && f < this.f18378r && f2 > this.f18379s && f2 < this.f18380t) {
                    return true;
                }
            } else if (f > this.f18377q && f < this.f18378r && f2 < this.f18379s && f2 > this.f18380t) {
                return true;
            }
        } else if (this.f18379s < this.f18380t) {
            if (f < this.f18377q && f > this.f18378r && f2 > this.f18379s && f2 < this.f18380t) {
                return true;
            }
        } else if (f < this.f18377q && f > this.f18378r && f2 < this.f18379s && f2 > this.f18380t) {
            return true;
        }
        return false;
    }
}
