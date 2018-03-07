package com.facebook.orca.threadview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* compiled from: messenger_video_too_big_dialog */
public class MessageItemContainer extends LinearLayout {
    public boolean f7057a;

    public MessageItemContainer(Context context) {
        super(context);
    }

    public MessageItemContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setInterceptEvent(boolean z) {
        this.f7057a = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f7057a;
    }
}
