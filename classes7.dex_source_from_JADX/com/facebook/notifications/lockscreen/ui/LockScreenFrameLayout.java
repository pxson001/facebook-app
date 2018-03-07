package com.facebook.notifications.lockscreen.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;

@TargetApi(16)
/* compiled from: newsfeed_blingbar */
public class LockScreenFrameLayout extends CustomFrameLayout {
    private int f8178a;
    private float f8179b;
    private float f8180c;
    private boolean f8181d;
    private MotionEvent f8182e;
    private OnTouchListener f8183f;
    public OnSizeChangedListener f8184g;
    public SwipeCallback f8185h;
    public OnBackPressedListener f8186i;

    /* compiled from: newsfeed_blingbar */
    public interface OnBackPressedListener {
        boolean mo450a();
    }

    /* compiled from: newsfeed_blingbar */
    public interface OnSizeChangedListener {
        void mo453a();
    }

    /* compiled from: newsfeed_blingbar */
    public interface SwipeCallback {
        boolean mo451a();

        boolean mo452b();
    }

    public LockScreenFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8178a = ViewConfiguration.get(context).getScaledTouchSlop() / 3;
    }

    public final void m9805a(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f8181d = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f8181d) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.f8179b = x;
                this.f8180c = y;
                this.f8182e = MotionEvent.obtain(motionEvent);
                return false;
            case 2:
                x = Math.abs(x - this.f8179b);
                float abs = Math.abs(y - this.f8180c);
                if (Math.max(x, abs) < ((float) this.f8178a)) {
                    return false;
                }
                if (this.f8185h == null) {
                    m9804a();
                    return true;
                } else if (abs > x) {
                    boolean b = y < this.f8180c ? this.f8185h.mo452b() : this.f8185h.mo451a();
                    if (!b) {
                        return b;
                    }
                    m9804a();
                    return b;
                } else {
                    m9804a();
                    return true;
                }
            default:
                return false;
        }
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f8183f = onTouchListener;
        super.setOnTouchListener(onTouchListener);
    }

    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        this.f8186i = onBackPressedListener;
    }

    private void m9804a() {
        if (this.f8183f != null) {
            this.f8183f.onTouch(this, this.f8182e);
        } else {
            onTouchEvent(this.f8182e);
        }
        this.f8182e.recycle();
        this.f8182e = null;
    }

    public void setSwipeCallback(SwipeCallback swipeCallback) {
        this.f8185h = swipeCallback;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1488674460);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f8184g != null) {
            this.f8184g.mo453a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -431489527, a);
    }

    public void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        this.f8184g = onSizeChangedListener;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i != 4 || this.f8186i == null) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            return this.f8186i.mo450a();
        }
        return true;
    }
}
