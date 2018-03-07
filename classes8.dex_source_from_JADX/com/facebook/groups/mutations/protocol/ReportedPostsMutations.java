package com.facebook.groups.mutations.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.mutations.protocol.ReportedPostsMutationsModels.GroupIgnoreReportedStoryCoreMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: entity_cards_missing_friending_location */
public final class ReportedPostsMutations {

    /* compiled from: entity_cards_missing_friending_location */
    public class GroupIgnoreReportedStoryCoreMutationString extends TypedGraphQLMutationString<GroupIgnoreReportedStoryCoreMutationModel> {
        public GroupIgnoreReportedStoryCoreMutationString() {
            super(GroupIgnoreReportedStoryCoreMutationModel.class, false, "GroupIgnoreReportedStoryCoreMutation", "0aa1eecb071f9d6c437a6fb8bba55a08", "group_ignore_reported_story", "0", "10154204803781729", RegularImmutableSet.a);
        }

        public final String m17138a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
