package com.facebook.goodwill.composer.photofragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;

/* compiled from: {CAPTCHA_RETRY_TOKEN} */
public class InterceptingRelativeLayout extends FbRelativeLayout {
    public View f125a;

    public InterceptingRelativeLayout(Context context) {
        super(context);
    }

    public InterceptingRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InterceptingRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setDispatchTarget(View view) {
        this.f125a = view;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f125a != null;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1039239511);
        if (this.f125a != null) {
            this.f125a.onTouchEvent(motionEvent);
        }
        Logger.a(2, EntryType.UI_INPUT_END, 2118974337, a);
        return true;
    }
}
