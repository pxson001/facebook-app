package com.facebook.groupcommerce.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groupcommerce.protocol.GroupMarketplaceCrossPostInterceptSeenMutationModels.GroupMarketplaceCrossPostInterceptSeenMutationFieldsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: reason_type */
public final class GroupMarketplaceCrossPostInterceptSeenMutation {

    /* compiled from: reason_type */
    public class GroupMarketplaceCrossPostInterceptSeenMutationString extends TypedGraphQLMutationString<GroupMarketplaceCrossPostInterceptSeenMutationFieldsModel> {
        public GroupMarketplaceCrossPostInterceptSeenMutationString() {
            super(GroupMarketplaceCrossPostInterceptSeenMutationFieldsModel.class, false, "GroupMarketplaceCrossPostInterceptSeenMutation", "d2473df62b18f819cc0dce7b52d43a3a", "viewer_group_marketplace_cross_post_intercept_seen", "0", "10154412303431729", RegularImmutableSet.a);
        }

        public final String m6038a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
