package com.facebook.groups.groupsgrid.mutations;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.groupsgrid.mutations.GroupsOrderUpdateMutationModels.GroupCacheUpdateOrderMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: propertiesMapKey */
public final class GroupsOrderUpdateMutation {

    /* compiled from: propertiesMapKey */
    public class GroupCacheUpdateOrderMutationString extends TypedGraphQLMutationString<GroupCacheUpdateOrderMutationModel> {
        public GroupCacheUpdateOrderMutationString() {
            super(GroupCacheUpdateOrderMutationModel.class, false, "GroupCacheUpdateOrderMutation", "6309a6419638f786ea75a5ab7b4aae05", "viewer_update_group_ordering", "0", "10154346623346729", RegularImmutableSet.a);
        }

        public final String m7060a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
