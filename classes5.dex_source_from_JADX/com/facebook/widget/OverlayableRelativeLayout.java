package com.facebook.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: com.google.android.gms.common.ui.SignInButtonCreatorImpl */
public class OverlayableRelativeLayout extends CustomRelativeLayout {
    public Drawable f5683a;

    public OverlayableRelativeLayout(Context context) {
        super(context);
    }

    public OverlayableRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OverlayableRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f5683a != null) {
            this.f5683a.setBounds(0, 0, getWidth(), getHeight());
            this.f5683a.draw(canvas);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 535624365);
        if (this.f5683a != null) {
            Logger.a(2, EntryType.UI_INPUT_END, 2084527811, a);
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(406818342, a);
        return onTouchEvent;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f5683a != null || super.onInterceptTouchEvent(motionEvent);
    }
}
