package com.facebook.samples.gestures;

import android.view.MotionEvent;

/* compiled from: setInitialLocationInfo */
public class MultiPointerGestureDetector {
    private boolean f4790a;
    public int f4791b;
    private int f4792c;
    public final int[] f4793d = new int[2];
    public final float[] f4794e = new float[2];
    public final float[] f4795f = new float[2];
    public final float[] f4796g = new float[2];
    public final float[] f4797h = new float[2];
    public TransformGestureDetector f4798i = null;

    public MultiPointerGestureDetector() {
        m7571b();
    }

    public final void m7571b() {
        int i = 0;
        this.f4790a = false;
        this.f4791b = 0;
        while (i < 2) {
            this.f4793d[i] = -1;
            i++;
        }
    }

    private void m7568j() {
        if (!this.f4790a) {
            if (this.f4798i != null) {
                TransformGestureDetector transformGestureDetector = this.f4798i;
                if (transformGestureDetector.f4800b != null) {
                    transformGestureDetector.f4800b.mo347a(transformGestureDetector);
                }
            }
            this.f4790a = true;
        }
    }

    private void m7569k() {
        if (this.f4790a) {
            this.f4790a = false;
        }
    }

    public static int m7567a(MotionEvent motionEvent, int i) {
        int pointerCount = motionEvent.getPointerCount();
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if ((actionMasked == 1 || actionMasked == 6) && i >= actionIndex) {
            actionMasked = i + 1;
        } else {
            actionMasked = i;
        }
        return actionMasked < pointerCount ? actionMasked : -1;
    }

    public final boolean m7570a(MotionEvent motionEvent) {
        int pointerCount;
        int actionMasked;
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 1:
            case 5:
            case 6:
                pointerCount = motionEvent.getPointerCount();
                actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 1 || actionMasked == 6) {
                    pointerCount--;
                }
                this.f4792c = pointerCount;
                m7569k();
                pointerCount = 0;
                this.f4791b = 0;
                while (pointerCount < 2) {
                    actionMasked = m7567a(motionEvent, pointerCount);
                    if (actionMasked == -1) {
                        this.f4793d[pointerCount] = -1;
                    } else {
                        this.f4793d[pointerCount] = motionEvent.getPointerId(actionMasked);
                        float[] fArr = this.f4796g;
                        float[] fArr2 = this.f4794e;
                        float x = motionEvent.getX(actionMasked);
                        fArr2[pointerCount] = x;
                        fArr[pointerCount] = x;
                        fArr = this.f4797h;
                        fArr2 = this.f4795f;
                        float y = motionEvent.getY(actionMasked);
                        fArr2[pointerCount] = y;
                        fArr[pointerCount] = y;
                        this.f4791b++;
                    }
                    pointerCount++;
                }
                if (this.f4791b > 0 && 1 != 0) {
                    m7568j();
                    break;
                }
            case 2:
                for (pointerCount = 0; pointerCount < 2; pointerCount++) {
                    actionMasked = motionEvent.findPointerIndex(this.f4793d[pointerCount]);
                    if (actionMasked != -1) {
                        this.f4796g[pointerCount] = motionEvent.getX(actionMasked);
                        this.f4797h[pointerCount] = motionEvent.getY(actionMasked);
                    }
                }
                if (!(this.f4790a || this.f4791b <= 0 || 1 == 0)) {
                    m7568j();
                }
                if (this.f4790a && this.f4798i != null) {
                    TransformGestureDetector transformGestureDetector = this.f4798i;
                    if (transformGestureDetector.f4800b != null) {
                        transformGestureDetector.f4800b.mo348b(transformGestureDetector);
                    }
                    break;
                }
            case 3:
                this.f4792c = 0;
                m7569k();
                m7571b();
                break;
        }
        return true;
    }

    public final void m7572c() {
        if (this.f4790a) {
            m7569k();
            for (int i = 0; i < 2; i++) {
                this.f4794e[i] = this.f4796g[i];
                this.f4795f[i] = this.f4797h[i];
            }
            m7568j();
        }
    }
}
