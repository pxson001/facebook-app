package com.facebook.feed.protocol;

import com.facebook.feed.protocol.NewsFeedMutationsModels.PlaceReviewXoutModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: method/user.updateNuxStatus */
public final class NewsFeedMutations {

    /* compiled from: method/user.updateNuxStatus */
    public class PlaceReviewXoutString extends TypedGraphQLMutationString<PlaceReviewXoutModel> {
        public PlaceReviewXoutString() {
            super(PlaceReviewXoutModel.class, false, "PlaceReviewXout", "fed92222a692cfa09cd76182cddf12d9", "place_review_xout", "0", "10154204803001729", RegularImmutableSet.a);
        }

        public final String m16391a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
