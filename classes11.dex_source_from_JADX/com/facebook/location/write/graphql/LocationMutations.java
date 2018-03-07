package com.facebook.location.write.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.location.write.graphql.LocationMutationsModels.LocationUpdateMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: Unexpected view type */
public final class LocationMutations {

    /* compiled from: Unexpected view type */
    public class LocationUpdateMutationString extends TypedGraphQLMutationString<LocationUpdateMutationModel> {
        public LocationUpdateMutationString() {
            super(LocationUpdateMutationModel.class, false, "LocationUpdateMutation", "f39bf6c4053e667e3660011633994d29", "location_update", "0", "10154343225151729", RegularImmutableSet.a);
        }

        public final String m10844a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
