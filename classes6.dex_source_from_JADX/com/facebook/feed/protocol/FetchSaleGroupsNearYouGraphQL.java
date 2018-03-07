package com.facebook.feed.protocol;

import com.facebook.common.util.TriState;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: mini_thumb_magic */
public final class FetchSaleGroupsNearYouGraphQL {

    /* compiled from: mini_thumb_magic */
    public class SaleGroupsNearYouQueryString extends TypedGraphQlQueryString<GraphQLNode> {
        public SaleGroupsNearYouQueryString() {
            super(GraphQLNode.class, false, "SaleGroupsNearYouQuery", "631f64d66a44b01367fc32535c855c66", "node", "10154478925726729", RegularImmutableSet.a);
        }

        public final TriState m16292g() {
            return TriState.NO;
        }

        public final String m16291a(String str) {
            switch (str.hashCode()) {
                case -738841953:
                    return "2";
                case -709248289:
                    return "3";
                case 566144106:
                    return "1";
                case 865582063:
                    return "5";
                case 1227613005:
                    return "4";
                case 2114448504:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
