package com.facebook.groups.fb4a.groupshub.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.groups.fb4a.groupshub.protocol.fetchAdminedGroupsModels.FetchAdminedGroupsCountModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: _bold_italic */
public final class fetchAdminedGroups {

    /* compiled from: _bold_italic */
    public class FetchAdminedGroupsCountString extends TypedGraphQlQueryString<FetchAdminedGroupsCountModel> {
        public FetchAdminedGroupsCountString() {
            super(FetchAdminedGroupsCountModel.class, false, "FetchAdminedGroupsCount", "a16c8fb9db5a290daaae80aba7dfa834", "viewer", "10154644138451729", RegularImmutableSet.a);
        }
    }
}
