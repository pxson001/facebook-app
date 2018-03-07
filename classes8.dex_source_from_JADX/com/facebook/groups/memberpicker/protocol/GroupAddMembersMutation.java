package com.facebook.groups.memberpicker.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.memberpicker.protocol.GroupAddMembersMutationModels.GroupAddMembersMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: exact_match */
public final class GroupAddMembersMutation {

    /* compiled from: exact_match */
    public class GroupAddMembersMutationString extends TypedGraphQLMutationString<GroupAddMembersMutationModel> {
        public GroupAddMembersMutationString() {
            super(GroupAddMembersMutationModel.class, false, "GroupAddMembersMutation", "ba2d5d29dd536b0fb0cc39d53b818fc4", "group_add_member", "0", "10154273580461729", RegularImmutableSet.a);
        }

        public final String m16522a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
