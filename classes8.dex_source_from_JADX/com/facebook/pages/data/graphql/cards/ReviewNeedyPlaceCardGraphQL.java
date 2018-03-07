package com.facebook.pages.data.graphql.cards;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.data.graphql.cards.ReviewNeedyPlaceCardGraphQLModels.ReviewNeedyPlaceCardQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: connected_state */
public final class ReviewNeedyPlaceCardGraphQL {

    /* compiled from: connected_state */
    public class ReviewNeedyPlaceCardQueryString extends TypedGraphQlQueryString<ReviewNeedyPlaceCardQueryModel> {
        public ReviewNeedyPlaceCardQueryString() {
            super(ReviewNeedyPlaceCardQueryModel.class, false, "ReviewNeedyPlaceCardQuery", "a5d7d2d0c783aa93aabf5e944eafce6c", "page", "10154661258751729", RegularImmutableSet.a);
        }

        public final TriState m20709g() {
            return TriState.NO;
        }

        public final String m20708a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
