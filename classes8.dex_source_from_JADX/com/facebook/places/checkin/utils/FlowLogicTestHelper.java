package com.facebook.places.checkin.utils;

import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;

/* compiled from: central_photo_blur_radius */
public class FlowLogicTestHelper {
    public static boolean m22091a(CheckinPlaceModel checkinPlaceModel, SearchType searchType) {
        if (checkinPlaceModel.g() == null || searchType == null) {
            return false;
        }
        return checkinPlaceModel.g().b().contains(searchType.toString().toLowerCase());
    }
}
