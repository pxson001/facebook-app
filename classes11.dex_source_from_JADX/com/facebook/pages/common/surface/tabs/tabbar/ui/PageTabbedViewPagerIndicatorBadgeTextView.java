package com.facebook.pages.common.surface.tabs.tabbar.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.facebook.fbui.pagerindicator.ColoredTabProgressListenerBadgeTextView;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;

/* compiled from: reportPlaceParams */
public class PageTabbedViewPagerIndicatorBadgeTextView extends ColoredTabProgressListenerBadgeTextView {
    public PageTabbedViewPagerIndicatorBadgeTextView(Context context) {
        super(context);
        m3505a();
    }

    public PageTabbedViewPagerIndicatorBadgeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3505a();
    }

    public PageTabbedViewPagerIndicatorBadgeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3505a();
    }

    private void m3505a() {
        CustomFontHelper.a(this, FontFamily.ROBOTO, FontWeight.MEDIUM, getTypeface());
        Resources resources = getResources();
        this.b = resources.getColor(2131361917);
        this.c = resources.getColor(2131362989);
    }
}
