package com.facebook.nearby.v2.network;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesLocationSearchQueryModel;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesPlacesAndTopicsQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: description_config */
public final class NearbyPlacesTypeaheadGraphQL {

    /* compiled from: description_config */
    public class FBNearbyPlacesLocationSearchQueryString extends TypedGraphQlQueryString<FBNearbyPlacesLocationSearchQueryModel> {
        public FBNearbyPlacesLocationSearchQueryString() {
            super(FBNearbyPlacesLocationSearchQueryModel.class, false, "FBNearbyPlacesLocationSearchQuery", "f955d8fd755a5952258b4360627b4835", "nearby_search", "10154658796761729", RegularImmutableSet.a);
        }

        public final String m18495a(String str) {
            switch (str.hashCode()) {
                case -1439978388:
                    return "1";
                case 137365935:
                    return "2";
                case 461177713:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: description_config */
    public class FBNearbyPlacesPlacesAndTopicsQueryString extends TypedGraphQlQueryString<FBNearbyPlacesPlacesAndTopicsQueryModel> {
        public FBNearbyPlacesPlacesAndTopicsQueryString() {
            super(FBNearbyPlacesPlacesAndTopicsQueryModel.class, false, "FBNearbyPlacesPlacesAndTopicsQuery", "fe2e3d91eff42a9aeae8db5356114b39", "nearby_search", "10154658796751729", RegularImmutableSet.a);
        }

        public final String m18496a(String str) {
            switch (str.hashCode()) {
                case -1439978388:
                    return "1";
                case 109250890:
                    return "3";
                case 137365935:
                    return "2";
                case 461177713:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
