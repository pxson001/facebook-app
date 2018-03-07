package com.facebook.events.dashboard;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.caspian.ui.pagerindicator.CaspianTabbedViewPagerIndicatorBadgeTextView;
import javax.annotation.Nullable;

/* compiled from: commerce_product_details */
public class EventsDashboardFilterTextView extends CaspianTabbedViewPagerIndicatorBadgeTextView {
    public DashboardFilterType f16582a;

    public EventsDashboardFilterTextView(Context context) {
        super(context);
    }

    public EventsDashboardFilterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EventsDashboardFilterTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setDashboardFilterType(DashboardFilterType dashboardFilterType) {
        this.f16582a = dashboardFilterType;
    }

    public DashboardFilterType getDashboardFilterType() {
        return this.f16582a;
    }
}
