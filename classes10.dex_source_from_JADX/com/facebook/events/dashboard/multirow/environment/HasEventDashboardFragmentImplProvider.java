package com.facebook.events.dashboard.multirow.environment;

import com.facebook.events.dashboard.EventsDiscoveryDashboardFragment;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: com.facebook.platform.extra.IS_USER_MESSAGE_OPTIONAL */
public class HasEventDashboardFragmentImplProvider extends AbstractAssistedProvider<HasEventDashboardFragmentImpl> {
    public static HasEventDashboardFragmentImpl m17479a(EventsDiscoveryDashboardFragment eventsDiscoveryDashboardFragment) {
        return new HasEventDashboardFragmentImpl(eventsDiscoveryDashboardFragment);
    }
}
