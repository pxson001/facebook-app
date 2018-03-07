package com.facebook.messaging.media.mediapicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: mCity */
public class AutoFitRecyclerView extends RecyclerView {
    private int f11658h = -1;
    private GridLayoutManager f11659i;

    public AutoFitRecyclerView(Context context) {
        super(context);
        m12320a(context, null, 0);
    }

    public AutoFitRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12320a(context, attributeSet, 0);
    }

    public AutoFitRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12320a(context, attributeSet, i);
    }

    private void m12320a(Context context, AttributeSet attributeSet, int i) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843031}, i, 0);
            this.f11658h = obtainStyledAttributes.getDimensionPixelSize(0, -1);
            obtainStyledAttributes.recycle();
        }
        this.f11659i = new GridLayoutManager(getContext(), 1);
        setLayoutManager(this.f11659i);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 689194851);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f11658h != -1) {
            this.f11659i.a(Math.max(1, getMeasuredWidth() / this.f11658h));
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 509706127, a);
    }
}
