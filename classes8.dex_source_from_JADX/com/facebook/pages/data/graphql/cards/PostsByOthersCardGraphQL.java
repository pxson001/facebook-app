package com.facebook.pages.data.graphql.cards;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.data.graphql.cards.PostsByOthersCardGraphQLModels.PostsByOthersCardQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: contact_fundraiser_supporters */
public final class PostsByOthersCardGraphQL {

    /* compiled from: contact_fundraiser_supporters */
    public class PostsByOthersCardQueryString extends TypedGraphQlQueryString<PostsByOthersCardQueryModel> {
        public PostsByOthersCardQueryString() {
            super(PostsByOthersCardQueryModel.class, false, "PostsByOthersCardQuery", "54de9836495f601f17a39ca81f7837a9", "page", "10154405445521729", RegularImmutableSet.a);
        }

        public final String m20688a(String str) {
            switch (str.hashCode()) {
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
