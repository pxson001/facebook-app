package com.facebook.nearby.v2.network;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.nearby.v2.network.NearbyPlacesHereCardSuggestionGraphQLModels.FBNearbyPlacesHereCardHugeResultCellQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: destination_link */
public final class NearbyPlacesHereCardSuggestionGraphQL {

    /* compiled from: destination_link */
    public class FBNearbyPlacesHereCardHugeResultCellQueryString extends TypedGraphQlQueryString<FBNearbyPlacesHereCardHugeResultCellQueryModel> {
        public FBNearbyPlacesHereCardHugeResultCellQueryString() {
            super(FBNearbyPlacesHereCardHugeResultCellQueryModel.class, false, "FBNearbyPlacesHereCardHugeResultCellQuery", "23b62a11db501a6e823f652b92f57900", "checkin_search_query", "10154677990771729", RegularImmutableSet.a);
        }

        public final TriState m18416g() {
            return TriState.NO;
        }

        public final String m18414a(String str) {
            switch (str.hashCode()) {
                case -1482998339:
                    return "3";
                case -1424931565:
                    return "4";
                case -693999586:
                    return "2";
                case -168637247:
                    return "0";
                case 109250890:
                    return "6";
                case 334980221:
                    return "8";
                case 855339215:
                    return "5";
                case 1018939763:
                    return "9";
                case 1246913140:
                    return "1";
                case 1939875509:
                    return "7";
                default:
                    return str;
            }
        }

        protected final boolean m18415a(String str, Object obj) {
            Object obj2 = -1;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        obj2 = null;
                        break;
                    }
                    break;
            }
            switch (obj2) {
                case null:
                    if (obj instanceof String) {
                        return "true".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
