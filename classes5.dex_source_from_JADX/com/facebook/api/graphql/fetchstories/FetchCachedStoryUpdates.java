package com.facebook.api.graphql.fetchstories;

import com.facebook.api.graphql.fetchstories.FetchCachedStoryUpdatesModels.SingleNodeQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: android_suggestifier_voting */
public final class FetchCachedStoryUpdates {

    /* compiled from: android_suggestifier_voting */
    public class SingleNodeQueryString extends TypedGraphQlQueryString<SingleNodeQueryModel> {
        public SingleNodeQueryString() {
            super(SingleNodeQueryModel.class, false, "SingleNodeQuery", "70d8b9834bd0638a1c953f7f01f02293", "node", "10154405017761729", RegularImmutableSet.a);
        }

        public final String m16604a(String str) {
            switch (str.hashCode()) {
                case 191965863:
                    return "2";
                case 1585400958:
                    return "1";
                case 1717754021:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final SingleNodeQueryString m16605a() {
        return new SingleNodeQueryString();
    }
}
