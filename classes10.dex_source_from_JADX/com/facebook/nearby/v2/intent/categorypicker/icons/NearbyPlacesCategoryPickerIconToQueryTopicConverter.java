package com.facebook.nearby.v2.intent.categorypicker.icons;

import android.content.res.Resources;
import com.facebook.nearby.v2.model.NearbyPlacesResultListQueryTopic;
import com.google.common.base.Preconditions;

/* compiled from: people */
public abstract class NearbyPlacesCategoryPickerIconToQueryTopicConverter {
    public static NearbyPlacesResultListQueryTopic m4640a(NearbyPlacesCategoryPickerIconType nearbyPlacesCategoryPickerIconType, Resources resources) {
        String str;
        int i;
        Preconditions.checkNotNull(resources);
        switch (nearbyPlacesCategoryPickerIconType) {
            case ALL:
                str = "";
                i = 2131236641;
                break;
            case RESTAURANTS:
                str = "Restaurants";
                i = 2131236642;
                break;
            case COFFEE:
                str = "Coffee";
                i = 2131236643;
                break;
            case NIGHTLIFE:
                str = "Nightlife";
                i = 2131236644;
                break;
            case OUTDOORS:
                str = "Outdoors";
                i = 2131236645;
                break;
            case ARTS:
                str = "Arts";
                i = 2131236646;
                break;
            case HOTELS:
                str = "Hotels";
                i = 2131236647;
                break;
            case SHOPPING:
                str = "Shopping";
                i = 2131236648;
                break;
            default:
                throw new IllegalArgumentException();
        }
        Preconditions.checkArgument(i != 0);
        return new NearbyPlacesResultListQueryTopic(resources.getString(i), str);
    }
}
