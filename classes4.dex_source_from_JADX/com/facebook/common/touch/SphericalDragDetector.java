package com.facebook.common.touch;

import android.view.MotionEvent;
import android.view.VelocityTracker;

/* compiled from: place_checkin_nearby */
public class SphericalDragDetector {
    private DragListener f4698a;
    private final TouchSlopDetector f4699b;
    private boolean f4700c = false;
    private boolean f4701d = false;
    public boolean f4702e;
    private int f4703f;
    public final VelocityTracker f4704g = VelocityTracker.obtain();
    public float f4705h;
    public float f4706i;
    private float f4707j;
    private float f4708k;

    /* compiled from: place_checkin_nearby */
    public interface DragListener {
        void mo408a();

        void mo409a(float f, float f2);

        void mo411b();

        void mo412b(float f, float f2);
    }

    public SphericalDragDetector(DragListener dragListener, TouchSlopDetector touchSlopDetector) {
        this.f4699b = touchSlopDetector;
        this.f4698a = dragListener;
    }

    public final boolean m5176a(MotionEvent motionEvent) {
        if (this.f4698a == null) {
            return false;
        }
        Object obj;
        int actionIndex;
        if (this.f4702e) {
            obj = null;
        } else {
            obj = 1;
        }
        if (!(obj == null || motionEvent.getAction() == 0)) {
            motionEvent = MotionEvent.obtain(motionEvent);
            motionEvent.setAction(0);
        }
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f4699b.m5173a(motionEvent);
                this.f4702e = true;
                this.f4703f = motionEvent.getPointerId(0);
                this.f4701d = false;
                m5174b();
                m5175b(motionEvent);
                break;
            case 1:
            case 3:
                this.f4702e = false;
                this.f4700c = false;
                m5175b(motionEvent);
                this.f4703f = -1;
                if (this.f4699b.m5172a()) {
                    this.f4704g.computeCurrentVelocity(1000);
                    this.f4705h = this.f4704g.getXVelocity();
                    this.f4706i = this.f4704g.getYVelocity();
                    this.f4698a.mo412b(this.f4705h, this.f4706i);
                } else if (this.f4701d) {
                    this.f4698a.mo412b(0.0f, 0.0f);
                } else {
                    this.f4698a.mo408a();
                }
                this.f4699b.m5173a(motionEvent);
                return false;
            case 2:
                break;
            case 6:
                actionIndex = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(actionIndex) == this.f4703f) {
                    this.f4703f = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                }
                actionIndex = motionEvent.findPointerIndex(this.f4703f);
                this.f4707j = motionEvent.getX(actionIndex);
                this.f4708k = motionEvent.getY(actionIndex);
                m5174b();
                this.f4701d = true;
                return false;
        }
        this.f4699b.m5173a(motionEvent);
        m5175b(motionEvent);
        actionIndex = motionEvent.findPointerIndex(this.f4703f);
        if (actionIndex >= 0 && actionIndex < motionEvent.getPointerCount()) {
            float x = motionEvent.getX(actionIndex);
            float y = motionEvent.getY(actionIndex);
            float f = this.f4707j - x;
            float f2 = this.f4708k - y;
            if (this.f4699b.m5172a()) {
                if (!this.f4700c) {
                    this.f4698a.mo411b();
                    this.f4700c = true;
                }
                this.f4698a.mo409a(f, f2);
            }
            this.f4707j = x;
            this.f4708k = y;
        }
        return true;
    }

    private void m5174b() {
        this.f4704g.clear();
    }

    private void m5175b(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
        this.f4704g.addMovement(obtain);
    }
}
