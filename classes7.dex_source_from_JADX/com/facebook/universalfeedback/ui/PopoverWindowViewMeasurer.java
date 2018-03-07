package com.facebook.universalfeedback.ui;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;

/* compiled from: editgallery_filter_viewed */
public class PopoverWindowViewMeasurer {
    private int f15367a;
    private int f15368b;

    public PopoverWindowViewMeasurer(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f15367a = MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels - (((int) TypedValue.applyDimension(1, 12.0f, displayMetrics)) * 2), Integer.MIN_VALUE);
        this.f15368b = MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE);
    }

    public final void m19387a(View view) {
        view.measure(this.f15367a, this.f15368b);
    }
}
