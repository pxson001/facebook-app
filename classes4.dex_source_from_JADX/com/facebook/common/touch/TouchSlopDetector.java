package com.facebook.common.touch;

import android.view.MotionEvent;

/* compiled from: ping_ip */
public class TouchSlopDetector {
    public int f4686a;
    private float f4687b;
    private float f4688c;
    private int f4689d;
    public boolean f4690e;
    public boolean f4691f;
    private float f4692g;
    private float f4693h;
    public boolean f4694i;
    public boolean f4695j;
    public boolean f4696k;
    public float f4697l;

    public TouchSlopDetector() {
        this.f4697l = 90.0f;
        this.f4686a = 8;
    }

    public TouchSlopDetector(int i) {
        this.f4697l = 90.0f;
        this.f4686a = i;
    }

    public final boolean m5172a() {
        return this.f4690e || this.f4691f;
    }

    private void m5171d() {
        this.f4690e = false;
        this.f4691f = false;
    }

    public final boolean m5173a(MotionEvent motionEvent) {
        Object obj;
        if (this.f4696k) {
            obj = null;
        } else {
            obj = 1;
        }
        if (!(obj == null || motionEvent.getAction() == 0)) {
            motionEvent = MotionEvent.obtain(motionEvent);
            motionEvent.setAction(0);
        }
        int findPointerIndex;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f4696k = true;
                this.f4687b = motionEvent.getX();
                this.f4688c = motionEvent.getY();
                this.f4689d = motionEvent.getPointerId(0);
                m5171d();
                break;
            case 1:
            case 3:
                this.f4696k = false;
                this.f4689d = -1;
                m5171d();
                break;
            case 2:
                findPointerIndex = motionEvent.findPointerIndex(this.f4689d);
                if (findPointerIndex >= 0 && findPointerIndex < motionEvent.getPointerCount()) {
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    this.f4692g = this.f4687b - x;
                    this.f4693h = this.f4688c - y;
                    y = this.f4692g;
                    x = this.f4693h;
                    boolean z = false;
                    if (this.f4694i) {
                        this.f4691f = false;
                        this.f4690e = true;
                    } else if (this.f4695j) {
                        this.f4691f = true;
                        this.f4690e = false;
                    } else {
                        if (Math.sqrt((double) ((y * y) + (x * x))) > ((double) this.f4686a)) {
                            z = true;
                        }
                        double toDegrees = Math.toDegrees(Math.atan((double) Math.abs(x / y)));
                        if (z) {
                            if (toDegrees < ((double) (this.f4697l / 2.0f))) {
                                this.f4690e = true;
                            } else {
                                this.f4691f = true;
                            }
                        }
                    }
                    break;
                }
            case 6:
                findPointerIndex = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(findPointerIndex) == this.f4689d) {
                    if (findPointerIndex == 0) {
                        findPointerIndex = 1;
                    } else {
                        findPointerIndex = 0;
                    }
                    this.f4687b = motionEvent.getX(findPointerIndex);
                    this.f4688c = motionEvent.getY(findPointerIndex);
                    this.f4689d = motionEvent.getPointerId(findPointerIndex);
                    break;
                }
                break;
        }
        if (this.f4690e || this.f4691f) {
            return true;
        }
        return false;
    }
}
