package com.facebook.pages.data.graphql.cards;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.data.graphql.cards.CriticReviewsCardGraphQLModels.CriticReviewsCardQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: contextual_filters */
public final class CriticReviewsCardGraphQL {

    /* compiled from: contextual_filters */
    public class CriticReviewsCardQueryString extends TypedGraphQlQueryString<CriticReviewsCardQueryModel> {
        public CriticReviewsCardQueryString() {
            super(CriticReviewsCardQueryModel.class, false, "CriticReviewsCardQuery", "7338ab59c3aab275e63797edec6b9c18", "page", "10154405445516729", RegularImmutableSet.a);
        }

        public final String m20272a(String str) {
            switch (str.hashCode()) {
                case -1663788165:
                    return "2";
                case -803548981:
                    return "0";
                case -588332180:
                    return "4";
                case -470820334:
                    return "3";
                case 1188358123:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
