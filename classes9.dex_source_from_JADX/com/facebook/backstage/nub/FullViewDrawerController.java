package com.facebook.backstage.nub;

import android.content.Context;
import android.view.MotionEvent;
import com.facebook.backstage.nub.FullWindowView.ViewState;
import com.facebook.backstage.util.BetterGestureDetector;
import com.facebook.backstage.util.BetterGestureListener;

/* compiled from: request-sync */
public class FullViewDrawerController extends BetterGestureListener {
    public final FullWindowView f5433a;
    public final BetterGestureDetector f5434b;
    public boolean f5435c;
    private boolean f5436d;
    private int f5437e;
    public long f5438f;
    private boolean f5439g;

    public FullViewDrawerController(Context context, FullWindowView fullWindowView) {
        this.f5433a = fullWindowView;
        this.f5434b = new BetterGestureDetector(context, this);
        this.f5434b.setIsLongpressEnabled(false);
    }

    public final void m5650d(MotionEvent motionEvent) {
        this.f5434b.onTouchEvent(motionEvent);
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.f5437e = (int) motionEvent.getX();
        this.f5438f = System.currentTimeMillis();
        this.f5435c = true;
        this.f5433a.m5662b();
        this.f5433a.mo202d();
        return super.onDown(motionEvent);
    }

    public final void mo195b(MotionEvent motionEvent) {
        if (this.f5433a.f5446e == ViewState.CAMERA_VIEW) {
            this.f5435c = false;
            this.f5433a.m5668f();
            this.f5433a.invalidate();
        }
        super.mo195b(motionEvent);
    }

    public final void mo185a(MotionEvent motionEvent, float f, float f2) {
        Object obj;
        long currentTimeMillis = System.currentTimeMillis() - this.f5438f;
        if (this.f5433a.f5446e == ViewState.REPOSITIONING || this.f5433a.f5446e == ViewState.DOCKING_NUB || this.f5433a.f5446e == ViewState.HIDDEN || !this.f5435c || currentTimeMillis < 100) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            this.f5436d = f < 0.0f;
            this.f5439g = true;
            if ((this.f5433a.m5660a() && this.f5433a.getCenteredCameraViewOffsetX() + f >= 0.0f && !this.f5436d) || (!this.f5433a.m5660a() && this.f5433a.getCenteredCameraViewOffsetX() + f <= 0.0f && this.f5436d)) {
                f *= 0.1f;
            }
            FullWindowView fullWindowView = this.f5433a;
            int i = (int) f;
            fullWindowView.m5662b();
            fullWindowView.setCameraByX(i);
            fullWindowView.f5445d.setXBy((float) i);
            fullWindowView.f5446e = ViewState.SWIPING_VIEW;
        }
        super.mo185a(motionEvent, f, f2);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        boolean z = true;
        if (this.f5433a.m5660a()) {
            if (f >= 0.0f) {
                z = false;
            }
        } else if (f <= 0.0f) {
            z = false;
        }
        this.f5433a.m5659a(z, (int) motionEvent2.getX(), this.f5436d);
        this.f5439g = false;
        this.f5435c = false;
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    public final void mo184a(MotionEvent motionEvent) {
        boolean z = true;
        float x = motionEvent.getX() - ((float) this.f5437e);
        this.f5435c = false;
        super.mo184a(motionEvent);
        if (this.f5439g || this.f5433a.getCenteredCameraViewOffsetX() != 0.0f) {
            this.f5439g = false;
            if (this.f5433a.m5660a()) {
                if (x >= 0.0f) {
                    z = false;
                }
            } else if (x <= 0.0f) {
                z = false;
            }
            this.f5433a.m5659a(z, (int) motionEvent.getX(), this.f5436d);
            return;
        }
        this.f5435c = false;
    }
}
