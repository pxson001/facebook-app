package com.facebook.search.common;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.facebook.fbui.pagerindicator.ColoredTabProgressListenerBadgeTextView;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;

/* compiled from: fetchPaginatedRelatedStoryParamsKey */
public class SearchDarkColoredTabProgressListenerBadgeTextView extends ColoredTabProgressListenerBadgeTextView {
    public SearchDarkColoredTabProgressListenerBadgeTextView(Context context) {
        super(context);
        m18315a();
    }

    public SearchDarkColoredTabProgressListenerBadgeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18315a();
    }

    public SearchDarkColoredTabProgressListenerBadgeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18315a();
    }

    private void m18315a() {
        CustomFontHelper.a(this, FontFamily.ROBOTO, FontWeight.MEDIUM, getTypeface());
        Resources resources = getResources();
        this.f3558b = resources.getColor(2131362084);
        this.f3559c = resources.getColor(2131362129);
    }
}
