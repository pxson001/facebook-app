package com.facebook.widget.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: expires_in */
public class LockableScrollView extends ScrollView {
    private boolean f12998a = false;
    private boolean f12999b = false;
    private boolean f13000c = false;

    public LockableScrollView(Context context) {
        super(context);
    }

    public LockableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LockableScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f12999b) {
            this.f12999b = false;
            return true;
        } else if (this.f13000c) {
            super.onInterceptTouchEvent(motionEvent);
            return true;
        } else if (this.f12998a) {
            return false;
        } else {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -982179168);
        if (motionEvent.getActionMasked() == 0 && this.f12998a) {
            Logger.a(2, EntryType.UI_INPUT_END, -426158608, a);
            return false;
        }
        if (this.f13000c) {
            boolean z;
            if (super.onInterceptTouchEvent(motionEvent)) {
                z = false;
            } else {
                z = true;
            }
            this.f13000c = z;
        }
        if (this.f13000c) {
            LogUtils.a(-808289073, a);
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(136093438, a);
        return onTouchEvent;
    }

    public void setScrollLock(boolean z) {
        if (!z) {
            this.f13000c = false;
            this.f12999b = false;
        }
        this.f12998a = z;
    }

    public boolean getLocked() {
        return this.f12998a;
    }

    public final void m13038a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(0);
        if (super.onInterceptTouchEvent(obtain)) {
            this.f12999b = true;
            super.onTouchEvent(obtain);
        } else {
            this.f13000c = true;
        }
        obtain.recycle();
    }
}
