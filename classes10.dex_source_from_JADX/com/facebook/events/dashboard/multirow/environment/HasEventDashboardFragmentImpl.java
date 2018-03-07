package com.facebook.events.dashboard.multirow.environment;

import com.facebook.events.dashboard.EventsDiscoveryDashboardFragment;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: com.facebook.platform.extra.POST_ID */
public class HasEventDashboardFragmentImpl implements HasEventDashboardFragment {
    private EventsDiscoveryDashboardFragment f17134a;

    @Inject
    public HasEventDashboardFragmentImpl(@Assisted EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
        this.f17134a = eventsDiscoveryDashboardFragment;
    }

    public final EventsDiscoveryDashboardFragment mo796u() {
        return this.f17134a;
    }
}
