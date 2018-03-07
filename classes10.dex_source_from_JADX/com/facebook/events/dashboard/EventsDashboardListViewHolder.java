package com.facebook.events.dashboard;

import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.listview.BetterListView;

/* compiled from: commerce/admin/products/add */
public class EventsDashboardListViewHolder {
    public BetterListView f16682a;
    public FbSwipeRefreshLayout f16683b;
    public boolean f16684c;
    public final DashboardFilterType f16685d;
    public final EventsDashboardFragment f16686e;

    public EventsDashboardListViewHolder(DashboardFilterType dashboardFilterType, EventsDashboardFragment eventsDashboardFragment) {
        this.f16685d = dashboardFilterType;
        this.f16686e = eventsDashboardFragment;
    }
}
