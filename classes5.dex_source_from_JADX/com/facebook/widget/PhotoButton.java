package com.facebook.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageButton;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: com.google.android.gms.common.internal.ISignInButtonCreator */
public class PhotoButton extends ImageButton {
    private boolean f5684a;
    public boolean f5685b;

    public PhotoButton(Context context) {
        super(context);
        m10470d();
    }

    public PhotoButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10470d();
    }

    public PhotoButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10470d();
    }

    private final void m10470d() {
        setBackgroundResource(2130842604);
        this.f5685b = true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1964432891);
        if (isEnabled() && this.f5685b) {
            if (motionEvent.getAction() == 0) {
                this.f5684a = false;
                mo628a();
            } else if (motionEvent.getAction() == 1 && !this.f5684a) {
                mo629b();
                mo630c();
            } else if (motionEvent.getAction() == 2 && !this.f5684a) {
                float abs = Math.abs(motionEvent.getX() - ((float) (getWidth() / 2)));
                float abs2 = Math.abs(motionEvent.getY() - ((float) (getHeight() / 2)));
                if (abs > 200.0f || abs2 > 200.0f) {
                    mo629b();
                    this.f5684a = true;
                }
            } else if (motionEvent.getAction() == 3) {
                mo629b();
                this.f5684a = true;
            }
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(1613711522, a);
        return onTouchEvent;
    }

    private boolean m10471e() {
        return this.f5685b;
    }

    public void setShowPressState(boolean z) {
        this.f5685b = z;
    }

    protected void mo628a() {
        setColorFilter(-7829368);
    }

    protected void mo629b() {
        clearColorFilter();
    }

    protected void mo630c() {
    }
}
