package com.facebook.pages.data.graphql.cards;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.data.graphql.cards.VertexAttributionCardGraphQLModels.VertexAttributionQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: confirmation_resend_code_success */
public final class VertexAttributionCardGraphQL {

    /* compiled from: confirmation_resend_code_success */
    public class VertexAttributionQueryString extends TypedGraphQlQueryString<VertexAttributionQueryModel> {
        public VertexAttributionQueryString() {
            super(VertexAttributionQueryModel.class, false, "VertexAttributionQuery", "fdfd709523d835600b876c8eba917224", "page", "10154405445531729", RegularImmutableSet.a);
        }

        public final String m20766a(String str) {
            switch (str.hashCode()) {
                case -875951854:
                    return "2";
                case -803548981:
                    return "0";
                case 3530753:
                    return "1";
                default:
                    return str;
            }
        }
    }
}
