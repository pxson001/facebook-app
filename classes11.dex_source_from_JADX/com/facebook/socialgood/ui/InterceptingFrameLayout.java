package com.facebook.socialgood.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: Null result  */
public class InterceptingFrameLayout extends CustomFrameLayout {
    public View f12855a;

    public InterceptingFrameLayout(Context context) {
        super(context);
    }

    public InterceptingFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InterceptingFrameLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setDispatchTarget(View view) {
        this.f12855a = view;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f12855a != null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 2069522684);
        if (this.f12855a != null) {
            if (!this.f12855a.isEnabled()) {
                this.f12855a.setEnabled(true);
            }
            this.f12855a.dispatchTouchEvent(motionEvent);
        }
        Logger.a(2, EntryType.UI_INPUT_END, 295789080, a);
        return true;
    }
}
