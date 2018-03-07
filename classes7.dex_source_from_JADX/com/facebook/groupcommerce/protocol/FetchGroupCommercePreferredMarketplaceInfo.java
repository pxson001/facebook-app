package com.facebook.groupcommerce.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groupcommerce.protocol.FetchGroupCommercePreferredMarketplaceInfoModels.PreferredMarketplaceQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: recording */
public final class FetchGroupCommercePreferredMarketplaceInfo {

    /* compiled from: recording */
    public class PreferredMarketplaceQueryString extends TypedGraphQlQueryString<PreferredMarketplaceQueryModel> {
        public PreferredMarketplaceQueryString() {
            super(PreferredMarketplaceQueryModel.class, false, "PreferredMarketplaceQuery", "2a991f82407028e2018f2fbf66b5b26c", "viewer", "10154044553831729", RegularImmutableSet.a);
        }
    }

    public static final PreferredMarketplaceQueryString m5832a() {
        return new PreferredMarketplaceQueryString();
    }
}
