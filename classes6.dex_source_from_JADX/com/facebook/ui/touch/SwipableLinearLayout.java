package com.facebook.ui.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: creative_low_img_size */
public class SwipableLinearLayout extends LinearLayout {
    private DragMotionDetector f18383a;
    private OnSizeChangedListener f18384b;
    private boolean f18385c;

    /* compiled from: creative_low_img_size */
    public interface OnSizeChangedListener {
    }

    public SwipableLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        this.f18384b = onSizeChangedListener;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f18383a != null) {
            this.f18385c = this.f18383a.m26970a(motionEvent);
        }
        return this.f18385c;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 513971334);
        super.onSizeChanged(i, i2, i3, i4);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1028376326, a);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -638193834);
        if (this.f18385c) {
            this.f18385c = this.f18383a.m26970a(motionEvent);
        }
        boolean z = this.f18385c;
        Logger.a(2, EntryType.UI_INPUT_END, 1342859113, a);
        return z;
    }
}
