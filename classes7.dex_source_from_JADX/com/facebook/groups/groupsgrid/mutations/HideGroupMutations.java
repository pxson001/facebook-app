package com.facebook.groups.groupsgrid.mutations;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.groupsgrid.mutations.HideGroupMutationsModels.GroupHideMutationModel;
import com.facebook.groups.groupsgrid.mutations.HideGroupMutationsModels.GroupUnhideMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: promotion_subtitle */
public final class HideGroupMutations {

    /* compiled from: promotion_subtitle */
    public class GroupHideMutationString extends TypedGraphQLMutationString<GroupHideMutationModel> {
        public GroupHideMutationString() {
            super(GroupHideMutationModel.class, false, "GroupHideMutation", "f9775cf71de12e2485828ef0d76fa915", "group_hide", "0", "10154204803621729", RegularImmutableSet.a);
        }

        public final String m7067a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: promotion_subtitle */
    public class GroupUnhideMutationString extends TypedGraphQLMutationString<GroupUnhideMutationModel> {
        public GroupUnhideMutationString() {
            super(GroupUnhideMutationModel.class, false, "GroupUnhideMutation", "ed10c22fb494aa16aa00c1294c3014f5", "group_unhide", "0", "10154346623371729", RegularImmutableSet.a);
        }

        public final String m7068a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
