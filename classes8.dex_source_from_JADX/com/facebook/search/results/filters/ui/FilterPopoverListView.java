package com.facebook.search.results.filters.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.facebook.widget.listview.BetterListView;

/* compiled from: SLIDESHOW_PREVIEW_SEEN */
public class FilterPopoverListView extends BetterListView {
    public int f22860a = 300;
    public boolean f22861b = false;

    public FilterPopoverListView(Context context) {
        super(context);
    }

    public FilterPopoverListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FilterPopoverListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setHeight(int i) {
        this.f22860a = i;
    }

    public void setShowFullWidth(boolean z) {
        this.f22861b = z;
    }

    public boolean getShowFullWidth() {
        return this.f22861b;
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = getResources().getDisplayMetrics().widthPixels;
        size2 = Math.min(this.f22860a, size2);
        if (this.f22861b) {
            i = MeasureSpec.makeMeasureSpec(i3, mode);
        }
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(size2, mode2));
        if (!this.f22861b) {
            i3 = size;
        }
        setMeasuredDimension(i3, size2);
    }
}
