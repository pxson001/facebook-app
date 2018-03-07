package com.facebook.photos.warning;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomViewUtils;
import javax.annotation.Nullable;

/* compiled from: seen_unit_ids */
public class ObjectionableContentWarningView extends ViewGroup {
    private final FbTextView f3519a;
    private final FbButton f3520b;
    private final ImageView f3521c;
    private MeasuredLayoutType f3522d;

    /* compiled from: seen_unit_ids */
    enum MeasuredLayoutType {
        FULL,
        MEDIUM,
        MINI,
        SMALL
    }

    public ObjectionableContentWarningView(Context context) {
        this(context, null);
    }

    public ObjectionableContentWarningView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ObjectionableContentWarningView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3522d = MeasuredLayoutType.SMALL;
        LayoutInflater.from(context).inflate(2130905524, this, true);
        this.f3519a = (FbTextView) findViewById(2131564316);
        this.f3520b = (FbButton) findViewById(2131564317);
        this.f3521c = (ImageView) findViewById(2131564315);
        this.f3519a.setMovementMethod(LinkMovementMethod.getInstance());
    }

    protected void onMeasure(int i, int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int a = m3457a(displayMetrics, 48);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        m3458a(size - (m3457a(displayMetrics, 32) * 2));
        this.f3520b.measure(makeMeasureSpec, makeMeasureSpec2);
        a = ((a + this.f3519a.getMeasuredHeight()) + this.f3520b.getMeasuredHeight()) + m3457a(displayMetrics, 96);
        int measuredHeight = (this.f3519a.getMeasuredHeight() + this.f3520b.getMeasuredHeight()) + m3457a(displayMetrics, 80);
        int a2 = m3457a(displayMetrics, 46) + (this.f3519a.getMeasuredHeight() + this.f3520b.getMeasuredHeight());
        m3459a();
        if (a <= size2) {
            this.f3521c.measure(makeMeasureSpec, makeMeasureSpec2);
            setMeasuredDimension(size, a);
            this.f3522d = MeasuredLayoutType.FULL;
        } else if (measuredHeight <= size2) {
            setMeasuredDimension(size, measuredHeight);
            this.f3522d = MeasuredLayoutType.MEDIUM;
        } else if (a2 <= size2) {
            setMeasuredDimension(size, a2);
            this.f3522d = MeasuredLayoutType.MINI;
        } else {
            CustomViewUtils.b(this, new ColorDrawable(ContextCompat.b(getContext(), 2131361953)));
            setMeasuredDimension(size, a2);
            this.f3522d = MeasuredLayoutType.SMALL;
        }
    }

    private void m3458a(int i) {
        this.f3519a.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
    }

    private static int m3457a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int measuredWidth = getMeasuredWidth();
        int a = m3457a(displayMetrics, 32);
        int a2 = m3457a(displayMetrics, 16);
        if (this.f3522d == MeasuredLayoutType.FULL) {
            this.f3521c.setVisibility(0);
            this.f3521c.layout((measuredWidth / 2) - (this.f3521c.getMeasuredWidth() / 2), a, (measuredWidth / 2) + (this.f3521c.getMeasuredWidth() / 2), this.f3521c.getMeasuredHeight() + a);
        } else {
            if (this.f3522d == MeasuredLayoutType.MINI || this.f3522d == MeasuredLayoutType.SMALL) {
                a = m3457a(displayMetrics, 16);
                a2 = m3457a(displayMetrics, 12);
            }
            this.f3521c.setVisibility(8);
        }
        if (this.f3522d == MeasuredLayoutType.FULL) {
            i5 = this.f3521c.getMeasuredHeight() + a2;
        }
        a += i5;
        this.f3519a.layout((measuredWidth / 2) - (this.f3519a.getMeasuredWidth() / 2), a, (measuredWidth / 2) + (this.f3519a.getMeasuredWidth() / 2), this.f3519a.getMeasuredHeight() + a);
        a2 = (a2 + this.f3519a.getMeasuredHeight()) + a;
        this.f3520b.layout((measuredWidth / 2) - (this.f3520b.getMeasuredWidth() / 2), a2, (measuredWidth / 2) + (this.f3520b.getMeasuredWidth() / 2), this.f3520b.getMeasuredHeight() + a2);
    }

    public final void m3459a() {
        CustomViewUtils.b(this, new ColorDrawable(0));
    }
}
