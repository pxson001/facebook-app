package com.facebook.backstage.nub;

import android.content.Context;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.backstage.StacksConstants;
import com.facebook.backstage.consumption.ScreenUtil;
import com.facebook.backstage.nub.FloatingWindowManager.C05702;
import com.facebook.backstage.nub.NubView.DrawingMode;
import com.facebook.backstage.ui.ViewAnimator;
import com.facebook.backstage.ui.ViewAnimator.OnFinishListener;
import com.facebook.rebound.Spring;
import com.google.common.base.Preconditions;

/* compiled from: request failed */
public abstract class FullWindowView extends FrameLayout {
    public final FullViewDrawerController f5442a;
    public final ScreenUtil f5443b;
    public final C05702 f5444c;
    public NubView f5445d;
    public ViewState f5446e = ViewState.HIDDEN;
    public boolean f5447f = true;
    public final CloseView f5448g;
    public float f5449h;
    public float f5450i = 0.0f;

    /* compiled from: request failed */
    public class C05731 implements OnFinishListener {
        final /* synthetic */ FullWindowView f5440a;

        public C05731(FullWindowView fullWindowView) {
            this.f5440a = fullWindowView;
        }

        public final void mo142a() {
            if (this.f5440a.f5449h > ((float) this.f5440a.f5443b.m4553c()) || this.f5440a.f5450i > ((float) this.f5440a.f5443b.m4554d())) {
                ViewAnimator a = ViewAnimator.m5752a(this.f5440a.f5445d);
                Spring spring = a.f5525b;
                spring.k = (double) 1056964608;
                spring.l = (double) 1056964608;
                a.m5754a(this.f5440a.f5449h).m5755b(this.f5440a.f5450i).m5759d();
            } else {
                this.f5440a.f5445d.setXBy(this.f5440a.f5449h);
                this.f5440a.f5445d.setYBy(this.f5440a.f5450i);
            }
            this.f5440a.f5449h = 0.0f;
            this.f5440a.f5450i = 0.0f;
        }
    }

    /* compiled from: request failed */
    public class C05742 implements OnFinishListener {
        final /* synthetic */ FullWindowView f5441a;

        public C05742(FullWindowView fullWindowView) {
            this.f5441a = fullWindowView;
        }

        public final void mo142a() {
            C05702 c05702 = this.f5441a.f5444c;
            c05702.f5415a.f5430l.edit().putBoolean(StacksConstants.f4256f, false).commit();
            FloatingWindowManager.m5645d(c05702.f5415a);
        }
    }

    /* compiled from: request failed */
    public enum ViewState {
        REPOSITIONING,
        SWIPING_VIEW,
        CAMERA_VIEW,
        SHOWING_CAMERA,
        HIDING_CAMERA,
        DOCKING_NUB,
        HIDDEN
    }

    public abstract void mo196a(int i);

    public abstract void mo197a(int i, int i2, int i3, boolean z);

    protected abstract boolean mo198a(MotionEvent motionEvent);

    public abstract void mo199b(int i, OnFinishListener onFinishListener);

    public abstract void mo200b(OnFinishListener onFinishListener);

    protected abstract void mo201c();

    public abstract void mo202d();

    public abstract void mo203e();

    protected abstract void mo204g();

    public abstract float getCenteredCameraViewOffsetX();

    public abstract float getCenteredCameraViewX();

    public abstract void mo207i();

    protected abstract boolean mo208k();

    public abstract void setCameraByX(int i);

    public FullWindowView(Context context, ScreenUtil screenUtil, C05702 c05702) {
        super(context);
        this.f5443b = screenUtil;
        this.f5444c = c05702;
        this.f5442a = new FullViewDrawerController(context, this);
        this.f5448g = new CloseView(getContext());
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.f5448g.setLayoutParams(layoutParams);
        addView(this.f5448g);
        this.f5448g.setY((float) this.f5443b.m4552b());
        this.f5445d = new NubView(context);
        this.f5445d.f5462f = DrawingMode.CIRCLE;
        addView(this.f5445d);
    }

    public final boolean m5660a() {
        Preconditions.checkArgument(this.f5446e != ViewState.HIDDEN);
        return this.f5447f;
    }

    public final void m5662b() {
        this.f5449h = 0.0f;
        this.f5450i = 0.0f;
        mo201c();
        ViewAnimator.m5752a(this.f5445d).m5761e();
        ViewAnimator.m5752a(this.f5448g).m5761e();
    }

    public final void m5668f() {
        this.f5446e = ViewState.CAMERA_VIEW;
        mo204g();
    }

    public final boolean m5671j() {
        Rect rect = new Rect();
        rect.left = (int) this.f5448g.getX();
        rect.top = (int) this.f5448g.getY();
        rect.right = (int) (this.f5448g.getX() + ((float) this.f5448g.getWidth()));
        rect.bottom = (int) (this.f5448g.getY() + ((float) this.f5448g.getHeight()));
        Rect rect2 = new Rect();
        rect2.left = (int) this.f5445d.getX();
        rect2.top = (int) this.f5445d.getY();
        rect2.right = (int) (this.f5445d.getX() + ((float) this.f5445d.getWidth()));
        rect2.bottom = (int) (this.f5445d.getY() + ((float) this.f5445d.getHeight()));
        return rect2.intersect(rect);
    }

    public final void m5659a(boolean z, int i, boolean z2) {
        if (this.f5444c != null) {
            C05702 c05702 = this.f5444c;
            if (z) {
                c05702.f5415a.f5423e.m5705g();
            } else {
                c05702.f5415a.f5423e.m5704f();
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (mo198a(motionEvent)) {
            this.f5442a.m5650d(motionEvent);
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(this, getKeyDispatcherState(), this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!m5656c(i)) {
            return false;
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (keyEvent.isTracking() && !keyEvent.isCanceled() && m5656c(i)) {
            this.f5444c.m5644a();
        }
        return false;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (!m5656c(i)) {
            return false;
        }
        this.f5444c.m5644a();
        return true;
    }

    private boolean m5656c(int i) {
        return (i != 4 || mo208k() || this.f5444c == null) ? false : true;
    }

    public int getNubY() {
        return (int) this.f5445d.getY();
    }
}
