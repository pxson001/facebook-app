package com.facebook.events.dashboard.multirow.environment;

import com.facebook.events.dashboard.multirow.EventsDashboardItemCollection;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: com.facebook.platform.extra.COMPLETION_GESTURE */
public class ShouldExpandEventsImplProvider extends AbstractAssistedProvider<ShouldExpandEventsImpl> {
    public static ShouldExpandEventsImpl m17483a(EventsDashboardItemCollection eventsDashboardItemCollection) {
        return new ShouldExpandEventsImpl(eventsDashboardItemCollection);
    }
}
