package com.facebook.pages.data.graphql.fragments;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.data.graphql.fragments.PostsByOthersFragmentGraphQLModels.PostsByOthersFragmentQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: recently_added */
public final class PostsByOthersFragmentGraphQL {

    /* compiled from: recently_added */
    public class PostsByOthersFragmentQueryString extends TypedGraphQlQueryString<PostsByOthersFragmentQueryModel> {
        public PostsByOthersFragmentQueryString() {
            super(PostsByOthersFragmentQueryModel.class, false, "PostsByOthersFragmentQuery", "27e0dee9146cc153f97377fc4b30e7c5", "page", "10154405445546729", RegularImmutableSet.a);
        }

        public final String m3662a(String str) {
            switch (str.hashCode()) {
                case -1921637429:
                    return "1";
                case -1353090962:
                    return "2";
                case -803548981:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
