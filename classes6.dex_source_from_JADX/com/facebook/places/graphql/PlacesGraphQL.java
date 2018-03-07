package com.facebook.places.graphql;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinHistoryMostRecentQueryModel;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinSearchQueryModel;
import com.facebook.places.graphql.PlacesGraphQLModels.FBCheckinNearbyCityQueryModel;
import com.facebook.places.graphql.PlacesGraphQLModels.FBCitySearchQueryModel;
import com.facebook.places.graphql.PlacesGraphQLModels.HomeResidenceQueryModel;
import com.facebook.places.graphql.PlacesGraphQLModels.PlaceDetailsModel;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: subscribed_calendar_profiles */
public final class PlacesGraphQL {

    /* compiled from: subscribed_calendar_profiles */
    public class CheckinHistoryMostRecentQueryString extends TypedGraphQlQueryString<CheckinHistoryMostRecentQueryModel> {
        public CheckinHistoryMostRecentQueryString() {
            super(CheckinHistoryMostRecentQueryModel.class, false, "CheckinHistoryMostRecentQuery", "b73bc63aa0018b284c374721f13fe782", "me", "10154358998781729", ImmutableSet.of("place_id"));
        }

        public final String m5503a(String str) {
            switch (str.hashCode()) {
                case -2058948753:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: subscribed_calendar_profiles */
    public class CheckinSearchQueryString extends TypedGraphQlQueryString<CheckinSearchQueryModel> {
        public CheckinSearchQueryString() {
            super(CheckinSearchQueryModel.class, false, "CheckinSearchQuery", "ce06a3ac6140209c90f73f82ad10e85a", "checkin_search_query", "10154631304466729", ImmutableSet.of("place_id"));
        }

        public final String m5504a(String str) {
            switch (str.hashCode()) {
                case -2058948753:
                    return "6";
                case -1896634307:
                    return "5";
                case 107944136:
                    return "0";
                case 899150587:
                    return "4";
                case 1106582040:
                    return "2";
                case 1400708756:
                    return "1";
                case 1717754021:
                    return "3";
                default:
                    return str;
            }
        }
    }

    /* compiled from: subscribed_calendar_profiles */
    public class FBCheckinNearbyCityQueryString extends TypedGraphQlQueryString<FBCheckinNearbyCityQueryModel> {
        public FBCheckinNearbyCityQueryString() {
            super(FBCheckinNearbyCityQueryModel.class, false, "FBCheckinNearbyCityQuery", "cdcbae1ab20a487842cd8d7bf2fc8c9f", "checkin_search_query", "10153142052011729", RegularImmutableSet.a);
        }

        public final String m5505a(String str) {
            switch (str.hashCode()) {
                case 107944136:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: subscribed_calendar_profiles */
    public class FBCitySearchQueryString extends TypedGraphQlQueryString<FBCitySearchQueryModel> {
        public FBCitySearchQueryString() {
            super(FBCitySearchQueryModel.class, false, "FBCitySearchQuery", "4b19f5dfa9fbd9678ab86d37e60dc0d5", "checkin_search_query", "10154358998796729", ImmutableSet.of("place_id"));
        }

        public final String m5506a(String str) {
            switch (str.hashCode()) {
                case -2058948753:
                    return "4";
                case -814745325:
                    return "3";
                case -168637247:
                    return "0";
                case 1106582040:
                    return "2";
                case 1400708756:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: subscribed_calendar_profiles */
    public class HomeResidenceQueryString extends TypedGraphQlQueryString<HomeResidenceQueryModel> {
        public HomeResidenceQueryString() {
            super(HomeResidenceQueryModel.class, false, "HomeResidenceQuery", "876d7fed3fe2b77ad7159573cd6dd6fe", "node", "10154358998771729", RegularImmutableSet.a);
        }

        public final TriState m5508g() {
            return TriState.NO;
        }

        public final String m5507a(String str) {
            switch (str.hashCode()) {
                case 3386882:
                    return "0";
                case 3530753:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: subscribed_calendar_profiles */
    public class PlaceDetailsQueryString extends TypedGraphQlQueryString<PlaceDetailsModel> {
        public PlaceDetailsQueryString() {
            super(PlaceDetailsModel.class, false, "PlaceDetailsQuery", "4c4940b9e38119d0b75e2adb89c106c2", "node", "10154354466086729", RegularImmutableSet.a);
        }

        public final String m5509a(String str) {
            switch (str.hashCode()) {
                case 3386882:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final CheckinSearchQueryString m5510a() {
        return new CheckinSearchQueryString();
    }

    public static final CheckinHistoryMostRecentQueryString m5511e() {
        return new CheckinHistoryMostRecentQueryString();
    }
}
