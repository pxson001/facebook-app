package com.facebook.events.dashboard.multirow.environment;

import com.facebook.events.dashboard.DashboardFilterType;
import com.facebook.inject.InjectorLike;

/* compiled from: com.facebook.platform.extra.USER_ID */
public class HasEventDashboardFilterTypeImpl implements HasEventDashboardFilterType {
    private DashboardFilterType f17133a;

    public static HasEventDashboardFilterTypeImpl m17475a(InjectorLike injectorLike) {
        return new HasEventDashboardFilterTypeImpl();
    }

    public final void mo792a(DashboardFilterType dashboardFilterType) {
        this.f17133a = dashboardFilterType;
    }

    public final DashboardFilterType mo795t() {
        return this.f17133a;
    }
}
