package com.facebook.placetips.common.graphql;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: scroll_spinner_delay */
public final class LocationTriggerWithReactionUnitsGraphQL {

    /* compiled from: scroll_spinner_delay */
    public class LocationTriggerWithReactionUnitsString extends TypedGraphQlQueryString<LocationTriggerWithReactionUnitsModel> {
        public LocationTriggerWithReactionUnitsString() {
            super(LocationTriggerWithReactionUnitsModel.class, false, "LocationTriggerWithReactionUnits", "c09689463f575d6ae1f9fde908495425", "location_trigger", "10154429039851729", RegularImmutableSet.a);
        }

        public final String m3744a(String str) {
            switch (str.hashCode()) {
                case -168637247:
                    return "0";
                case 759954292:
                    return "2";
                case 1318194685:
                    return "1";
                case 1598177384:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
