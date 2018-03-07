package com.facebook.events.dashboard.multirow.environment;

import com.facebook.events.dashboard.multirow.EventsDashboardItemCollection;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: com.facebook.platform.extra.DID_COMPLETE */
public class ShouldExpandEventsImpl implements ShouldExpandEvents {
    private EventsDashboardItemCollection f17137a;

    @Inject
    public ShouldExpandEventsImpl(@Assisted EventsDashboardItemCollection eventsDashboardItemCollection) {
        this.f17137a = eventsDashboardItemCollection;
    }

    public final void mo793c(boolean z) {
        this.f17137a.m17373a(z);
    }
}
