package com.facebook.fbui.pagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator.TabProgressListenerView;
import com.facebook.fbui.widget.text.BadgeTextView;

/* compiled from: souvenirs.json */
public class ColoredTabProgressListenerBadgeTextView extends BadgeTextView implements TabProgressListenerView {
    private float f3557a;
    public int f3558b;
    public int f3559c;

    public ColoredTabProgressListenerBadgeTextView(Context context) {
        this(context, null);
    }

    public ColoredTabProgressListenerBadgeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColoredTabProgressListenerBadgeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4273a(context, attributeSet, i);
    }

    private void m4273a(Context context, AttributeSet attributeSet, int i) {
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColoredTabProgressListenerBadgeTextView, i, 0);
        this.f3559c = obtainStyledAttributes.getColor(0, resources.getColor(2131361958));
        this.f3558b = obtainStyledAttributes.getColor(1, resources.getColor(2131361917));
        obtainStyledAttributes.recycle();
    }

    public void setSelectedColor(int i) {
        this.f3558b = i;
    }

    public void setUnselectedColor(int i) {
        this.f3559c = i;
    }

    public final void mo168a(float f) {
        float a = ColorInterpolatorHelper.m4270a(f);
        if (this.f3557a != a) {
            setTextColor(ColorInterpolatorHelper.m4271a(f, this.f3559c, this.f3558b));
            this.f3557a = a;
        }
    }
}
