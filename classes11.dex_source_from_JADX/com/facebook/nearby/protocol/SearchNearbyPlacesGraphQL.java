package com.facebook.nearby.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.nearby.protocol.SearchNearbyPlacesGraphQLModels.SearchNearbyPlacesModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: topic_feed_option_select */
public final class SearchNearbyPlacesGraphQL {

    /* compiled from: topic_feed_option_select */
    public class SearchNearbyPlacesString extends TypedGraphQlQueryString<SearchNearbyPlacesModel> {
        public SearchNearbyPlacesString() {
            super(SearchNearbyPlacesModel.class, false, "SearchNearbyPlaces", "8e434e11f2a97a4eaa151f1efb94afdc", "nearby_search", "10154429179156729", RegularImmutableSet.a);
        }

        public final String m898a(String str) {
            switch (str.hashCode()) {
                case -2117681457:
                    return "7";
                case -1974004338:
                    return "12";
                case -1425952190:
                    return "5";
                case -1182369832:
                    return "3";
                case -928361181:
                    return "2";
                case -869265790:
                    return "10";
                case -588332180:
                    return "14";
                case 107944136:
                    return "0";
                case 572178073:
                    return "6";
                case 738889598:
                    return "1";
                case 800076972:
                    return "4";
                case 887305354:
                    return "13";
                case 1856604169:
                    return "8";
                case 1934691027:
                    return "11";
                case 2087101590:
                    return "9";
                default:
                    return str;
            }
        }
    }
}
