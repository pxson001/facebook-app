package com.facebook.messaging.payment.value.input.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: editUsernameParams */
public class OrionMessengerPayViewPager extends ViewPager {
    public OrionMessengerPayViewPager(Context context) {
        super(context);
    }

    public OrionMessengerPayViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Logger.a(2, EntryType.UI_INPUT_END, -336603102, Logger.a(2, EntryType.UI_INPUT_START, 1157534651));
        return false;
    }

    public final void m16051a(int i, boolean z) {
        super.a(i, false);
    }
}
