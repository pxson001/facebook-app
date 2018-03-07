package com.facebook.groupcommerce.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groupcommerce.protocol.FetchUserGroupCommercePostToMarketplaceStateGraphQLModels.UserGroupCommercePostToMarketplaceStateQueryModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: recent_unread_count */
public final class FetchUserGroupCommercePostToMarketplaceStateGraphQL {

    /* compiled from: recent_unread_count */
    public class UserGroupCommercePostToMarketplaceStateQueryString extends TypedGraphQlQueryString<UserGroupCommercePostToMarketplaceStateQueryModel> {
        public UserGroupCommercePostToMarketplaceStateQueryString() {
            super(UserGroupCommercePostToMarketplaceStateQueryModel.class, false, "UserGroupCommercePostToMarketplaceStateQuery", "93157327524118822af4f4117c582307", "group_address", "10154403593416729", RegularImmutableSet.a);
        }

        public final String m5933a(String str) {
            switch (str.hashCode()) {
                case 506361563:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
