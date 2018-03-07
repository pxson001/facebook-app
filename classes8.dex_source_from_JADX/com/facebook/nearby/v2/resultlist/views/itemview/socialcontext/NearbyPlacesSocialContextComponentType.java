package com.facebook.nearby.v2.resultlist.views.itemview.socialcontext;

import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesFriendsWhoVisitedFragmentModel.FriendsWhoVisitedModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyRecommendationsConnectionFragmentModel;

/* compiled from: custom_title_res_id */
public enum NearbyPlacesSocialContextComponentType {
    NONE,
    FRIENDS_WHO_VISITED,
    FRIENDS_WHO_REVIEWED;

    public static NearbyPlacesSocialContextComponentType getComponentTypeForPlace(NearbyPlacesPlaceModel nearbyPlacesPlaceModel) {
        if (nearbyPlacesPlaceModel == null) {
            return NONE;
        }
        Object obj;
        FriendsWhoVisitedModel e = nearbyPlacesPlaceModel.m17741e();
        if (e == null || e.m17964a() == 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return FRIENDS_WHO_VISITED;
        }
        NearbyRecommendationsConnectionFragmentModel C = nearbyPlacesPlaceModel.f15301a.mo921C();
        if (C == null || C.m18252a() == 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return FRIENDS_WHO_REVIEWED;
        }
        return NONE;
    }
}
