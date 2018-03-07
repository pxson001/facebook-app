package com.facebook.groupcommerce.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groupcommerce.protocol.FetchMarketplaceCrossPostShowSettingsGraphQLModels.FetchMarketplaceCrossPostShowSettingsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: recommendation_like_success */
public final class FetchMarketplaceCrossPostShowSettingsGraphQL {

    /* compiled from: recommendation_like_success */
    public class FetchMarketplaceCrossPostShowSettingsString extends TypedGraphQlQueryString<FetchMarketplaceCrossPostShowSettingsModel> {
        public FetchMarketplaceCrossPostShowSettingsString() {
            super(FetchMarketplaceCrossPostShowSettingsModel.class, false, "FetchMarketplaceCrossPostShowSettings", "86dd297760864eaaa7a1662c0bfbc1ae", "group", "10154413382471729", RegularImmutableSet.a);
        }

        public final String m5895a(String str) {
            switch (str.hashCode()) {
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
