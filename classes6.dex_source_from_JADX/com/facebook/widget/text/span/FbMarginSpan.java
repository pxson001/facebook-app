package com.facebook.widget.text.span;

import android.content.res.Resources;
import android.text.style.LeadingMarginSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/* compiled from: com.google.android.gms.location.places.GeoDataApi */
public abstract class FbMarginSpan implements LeadingMarginSpan {
    protected float f19889a;
    protected int f19890b;

    public FbMarginSpan() {
        this(Resources.getSystem().getDisplayMetrics());
    }

    public FbMarginSpan(DisplayMetrics displayMetrics) {
        this.f19890b = -16777216;
        this.f19889a = TypedValue.applyDimension(2, 20.0f, displayMetrics);
    }

    public FbMarginSpan mo1506a(int i) {
        this.f19890b = i;
        return this;
    }

    public int getLeadingMargin(boolean z) {
        return (int) this.f19889a;
    }
}
