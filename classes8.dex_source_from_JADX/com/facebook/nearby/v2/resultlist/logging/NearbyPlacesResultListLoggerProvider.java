package com.facebook.nearby.v2.resultlist.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.nearby.v2.model.NearbyPlacesFragmentModel;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataProvider;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListModel;

/* compiled from: db43b5fcb0a1b1c011933e7e23e6fbd0 */
public class NearbyPlacesResultListLoggerProvider extends AbstractAssistedProvider<NearbyPlacesResultListLogger> {
    public final NearbyPlacesResultListLogger m18694a(NearbyPlacesFragmentModel nearbyPlacesFragmentModel, NearbyPlacesSearchDataProvider nearbyPlacesSearchDataProvider, NearbyPlacesResultListModel nearbyPlacesResultListModel) {
        return new NearbyPlacesResultListLogger(nearbyPlacesFragmentModel, nearbyPlacesSearchDataProvider, nearbyPlacesResultListModel, AnalyticsLoggerMethodAutoProvider.a(this));
    }
}
