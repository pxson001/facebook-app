package com.facebook.nearby.v2.resultlist.views.itemview.actionbar;

import android.location.Location;
import com.facebook.common.util.StringUtil;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.OverallStarRatingModel;

/* compiled from: daily_dialogue_lightweight_extra */
public class NearbyPlacesActionBarActionComponents {
    public int f15995a = 0;

    public static NearbyPlacesActionBarActionComponents m18799a(NearbyPlacesPlaceModel nearbyPlacesPlaceModel, Location location, boolean z) {
        NearbyPlacesActionBarActionComponents nearbyPlacesActionBarActionComponents = new NearbyPlacesActionBarActionComponents();
        if (nearbyPlacesPlaceModel != null) {
            OverallStarRatingModel n = nearbyPlacesPlaceModel.m17750n();
            if (n != null && n.m17867c() > 0.0d) {
                nearbyPlacesActionBarActionComponents.f15995a |= 1;
            }
            if (nearbyPlacesPlaceModel.m17751p() && z && location != null) {
                nearbyPlacesActionBarActionComponents.f15995a |= 2;
            }
            if (nearbyPlacesPlaceModel.m17754v() && !StringUtil.a(nearbyPlacesPlaceModel.m17743g())) {
                nearbyPlacesActionBarActionComponents.f15995a |= 8;
            }
            if (nearbyPlacesPlaceModel.m17752q()) {
                nearbyPlacesActionBarActionComponents.f15995a |= 4;
            }
            if (nearbyPlacesPlaceModel.m17746j() > 0) {
                nearbyPlacesActionBarActionComponents.f15995a |= 16;
            }
        }
        return nearbyPlacesActionBarActionComponents;
    }
}
