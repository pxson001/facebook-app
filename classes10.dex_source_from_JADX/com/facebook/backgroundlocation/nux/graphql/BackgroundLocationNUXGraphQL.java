package com.facebook.backgroundlocation.nux.graphql;

import com.facebook.backgroundlocation.nux.graphql.BackgroundLocationNUXGraphQLModels.BackgroundLocationNowNuxQueryModel;
import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLModels.BackgroundLocationUpsellProfileModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: document_swipped_back */
public final class BackgroundLocationNUXGraphQL {

    /* compiled from: document_swipped_back */
    public class BackgroundLocationNowNuxQueryString extends TypedGraphQlQueryString<BackgroundLocationNowNuxQueryModel> {
        public BackgroundLocationNowNuxQueryString() {
            super(BackgroundLocationNowNuxQueryModel.class, false, "BackgroundLocationNowNuxQuery", "76f9bc871e3f38ff9daa51c1c2647b31", "viewer", "10154661257736729", RegularImmutableSet.a);
        }

        public final String m15202a(String str) {
            switch (str.hashCode()) {
                case -1777441434:
                    return "0";
                case -1442803611:
                    return "1";
                case -704493630:
                    return "3";
                case -220209159:
                    return "2";
                case 1973879317:
                    return "4";
                default:
                    return str;
            }
        }
    }

    /* compiled from: document_swipped_back */
    public class BackgroundLocationNuxInviterProfileQueryString extends TypedGraphQlQueryString<BackgroundLocationUpsellProfileModel> {
        public BackgroundLocationNuxInviterProfileQueryString() {
            super(BackgroundLocationUpsellProfileModel.class, false, "BackgroundLocationNuxInviterProfileQuery", "65516dfc8f9dc290b6ac7535e3f72810", "node", "10154646078931729", RegularImmutableSet.a);
        }

        public final String m15203a(String str) {
            switch (str.hashCode()) {
                case -1777441434:
                    return "1";
                case -1442803611:
                    return "2";
                case 3355:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
