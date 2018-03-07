package com.facebook.widget.touch;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import com.facebook.widget.touch.Resampler.SamplePoint;

@TargetApi(9)
/* compiled from: event_type */
public class MultitouchResampler {
    private Resampler[] f12726a;
    private int[] f12727b;
    private PointerCoords[] f12728c;
    private SamplePoint f12729d;

    public MultitouchResampler() {
        this(false);
    }

    private MultitouchResampler(boolean z) {
        this.f12726a = new Resampler[6];
        this.f12727b = new int[6];
        this.f12728c = new PointerCoords[6];
        for (int i = 0; i <= 5; i++) {
            this.f12726a[i] = new Resampler(z);
            this.f12728c[i] = new PointerCoords();
        }
        this.f12729d = new SamplePoint(0.0f, 0.0f, 0);
    }

    public final void m13546a(MotionEvent motionEvent) {
        int i = 0;
        int pointerCount;
        switch (motionEvent.getAction() & 255) {
            case 0:
            case 5:
                pointerCount = motionEvent.getPointerCount();
                while (i < pointerCount) {
                    float x = motionEvent.getX(i);
                    float y = motionEvent.getY(i);
                    long eventTime = motionEvent.getEventTime();
                    Resampler a = m13544a(motionEvent.getPointerId(i));
                    if ((motionEvent.getActionMasked() == 5 && motionEvent.getActionIndex() == i) || motionEvent.getActionMasked() == 0) {
                        a.a();
                    }
                    a.a(x, y, eventTime);
                    i++;
                }
                return;
            default:
                int pointerCount2 = motionEvent.getPointerCount();
                int historySize = motionEvent.getHistorySize();
                for (int i2 = 0; i2 < pointerCount2; i2++) {
                    Resampler a2 = m13544a(motionEvent.getPointerId(i2));
                    for (pointerCount = 0; pointerCount < historySize; pointerCount++) {
                        a2.a(motionEvent.getHistoricalX(i2, pointerCount), motionEvent.getHistoricalY(i2, pointerCount), motionEvent.getHistoricalEventTime(pointerCount));
                    }
                    a2.a(motionEvent.getX(i2), motionEvent.getY(i2), motionEvent.getEventTime());
                }
                return;
        }
    }

    public final MotionEvent m13545a(MotionEvent motionEvent, int i, long j) {
        if (VERSION.SDK_INT >= 9) {
            int min = Math.min(motionEvent.getPointerCount(), 5);
            for (int i2 = 0; i2 < min; i2++) {
                int pointerId = motionEvent.getPointerId(i2);
                this.f12727b[i2] = pointerId;
                m13544a(pointerId).a(j, this.f12729d);
                this.f12728c[i2].x = this.f12729d.b();
                this.f12728c[i2].y = this.f12729d.c();
            }
            return MotionEvent.obtain(motionEvent.getDownTime(), j, i, min, this.f12727b, this.f12728c, motionEvent.getMetaState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        }
        throw new ArrayIndexOutOfBoundsException("Cannot synthesize motion events on pre-GB devices");
    }

    private final Resampler m13544a(int i) {
        if (i < 5) {
            return this.f12726a[i];
        }
        return this.f12726a[5];
    }
}
