package com.facebook.common.touch;

import android.support.v7.widget.LinearLayoutCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.facebook.notifications.lockscreenservice.LockScreenService.PopupDragGestureListener;

/* compiled from: agree_to_privacy_text */
public class DragDetector {
    private PopupDragGestureListener f11124a;
    private final TouchSlopDetector f11125b;
    public boolean f11126c;
    private float f11127d;
    private float f11128e;
    private int f11129f;
    public final VelocityTracker f11130g = VelocityTracker.obtain();
    public float f11131h;
    public float f11132i;
    private float f11133j;
    private float f11134k;

    public DragDetector(PopupDragGestureListener popupDragGestureListener, TouchSlopDetector touchSlopDetector) {
        this.f11125b = touchSlopDetector;
        this.f11124a = popupDragGestureListener;
    }

    public final void m19118a() {
        this.f11124a = null;
    }

    public final boolean m19119a(MotionEvent motionEvent) {
        int i = 1;
        if (this.f11124a == null) {
            return false;
        }
        Object obj;
        if (this.f11126c) {
            obj = null;
        } else {
            obj = 1;
        }
        if (!(obj == null || motionEvent.getAction() == 0)) {
            motionEvent = MotionEvent.obtain(motionEvent);
            motionEvent.setAction(0);
        }
        float x;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f11125b.a(motionEvent);
                this.f11126c = true;
                x = motionEvent.getX();
                this.f11133j = x;
                this.f11127d = x;
                x = motionEvent.getY();
                this.f11134k = x;
                this.f11128e = x;
                this.f11129f = motionEvent.getPointerId(0);
                this.f11130g.clear();
                m19117b(motionEvent);
                break;
            case 1:
            case 3:
                this.f11126c = false;
                m19117b(motionEvent);
                this.f11130g.computeCurrentVelocity(1000);
                this.f11131h = this.f11130g.getXVelocity();
                this.f11132i = this.f11130g.getYVelocity();
                this.f11129f = -1;
                if (this.f11125b.e) {
                    this.f11124a.c(this.f11131h);
                }
                if (this.f11125b.f) {
                    this.f11124a.d(this.f11132i);
                }
                this.f11125b.a(motionEvent);
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                this.f11125b.a(motionEvent);
                m19117b(motionEvent);
                i = motionEvent.findPointerIndex(this.f11129f);
                if (i >= 0 && i < motionEvent.getPointerCount()) {
                    float x2 = motionEvent.getX(i);
                    x = motionEvent.getY(i);
                    float f = this.f11133j - x2;
                    float f2 = this.f11134k - x;
                    if (this.f11125b.e) {
                        this.f11124a.a(f);
                    }
                    if (this.f11125b.f) {
                        this.f11124a.b(f2);
                    }
                    this.f11133j = x2;
                    this.f11134k = x;
                    break;
                }
            case 6:
                int actionIndex = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(actionIndex) == this.f11129f) {
                    if (actionIndex != 0) {
                        i = 0;
                    }
                    this.f11127d = motionEvent.getX(i);
                    this.f11128e = motionEvent.getY(i);
                    this.f11133j = motionEvent.getX(i);
                    this.f11134k = motionEvent.getY(i);
                    this.f11129f = motionEvent.getPointerId(i);
                    break;
                }
                break;
        }
        return this.f11125b.a();
    }

    private void m19117b(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
        this.f11130g.addMovement(obtain);
    }
}
