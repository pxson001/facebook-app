package com.facebook.search.suggestions.nullstate;

import com.facebook.content.event.FbEvent;
import com.facebook.placetips.bootstrap.event.PlaceTipsEvent;
import com.facebook.placetips.bootstrap.event.PlaceTipsEventSubscriber;

/* compiled from: wifi_in_range_time_stamp */
class NearbyNullStateSupplier$LocationTriggerEventSubscriber extends PlaceTipsEventSubscriber<PlaceTipsEvent> {
    final /* synthetic */ NearbyNullStateSupplier f185a;

    public NearbyNullStateSupplier$LocationTriggerEventSubscriber(NearbyNullStateSupplier nearbyNullStateSupplier) {
        this.f185a = nearbyNullStateSupplier;
    }

    public final void m322b(FbEvent fbEvent) {
        NearbyNullStateSupplier.k(this.f185a);
    }

    public final Class<PlaceTipsEvent> m321a() {
        return PlaceTipsEvent.class;
    }
}
