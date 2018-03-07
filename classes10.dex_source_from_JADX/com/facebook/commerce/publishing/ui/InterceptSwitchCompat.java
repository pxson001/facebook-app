package com.facebook.commerce.publishing.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.SwitchCompat;

/* compiled from: current_fb_locale */
public class InterceptSwitchCompat extends SwitchCompat {
    public boolean f15635a = true;

    public InterceptSwitchCompat(Context context) {
        super(context);
    }

    public InterceptSwitchCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InterceptSwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setSwitchingEnabled(boolean z) {
        this.f15635a = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 625228562);
        if (this.f15635a) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            Logger.a(2, EntryType.UI_INPUT_END, 865835151, a);
            return onTouchEvent;
        }
        LogUtils.a(2128679319, a);
        return false;
    }
}
