package com.facebook.caspian.ui.pagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.facebook.fbui.pagerindicator.ColoredTabProgressListenerBadgeTextView;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;

/* compiled from: desired_accuracy_meters */
public class CaspianTabbedViewPagerIndicatorBadgeTextView extends ColoredTabProgressListenerBadgeTextView {
    public CaspianTabbedViewPagerIndicatorBadgeTextView(Context context) {
        super(context);
        m15597a();
    }

    public CaspianTabbedViewPagerIndicatorBadgeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15597a();
    }

    public CaspianTabbedViewPagerIndicatorBadgeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15597a();
    }

    private void m15597a() {
        CustomFontHelper.a(this, FontFamily.ROBOTO, FontWeight.MEDIUM, getTypeface());
        Resources resources = getResources();
        this.b = resources.getColor(2131361916);
        this.c = resources.getColor(2131362046);
    }
}
