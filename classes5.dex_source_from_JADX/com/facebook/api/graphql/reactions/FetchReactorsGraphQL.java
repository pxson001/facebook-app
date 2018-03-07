package com.facebook.api.graphql.reactions;

import com.facebook.api.graphql.reactions.FetchReactorsGraphQLModels.ReactorsOfFeedbackFieldModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: android_popover_place_picker_add_button */
public final class FetchReactorsGraphQL {

    /* compiled from: android_popover_place_picker_add_button */
    public class FeedbackReactorsString extends TypedGraphQlQueryString<ReactorsOfFeedbackFieldModel> {
        public FeedbackReactorsString() {
            super(ReactorsOfFeedbackFieldModel.class, false, "FeedbackReactors", "e3cb1cdddd9a356d7d8b291278ff861d", "node", "10154436642721729", RegularImmutableSet.a);
        }

        public final String m16919a(String str) {
            switch (str.hashCode()) {
                case -1646960752:
                    return "3";
                case -1302586347:
                    return "0";
                case 90721676:
                    return "6";
                case 689802720:
                    return "2";
                case 1631314385:
                    return "4";
                case 1918628884:
                    return "5";
                case 2023086761:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
