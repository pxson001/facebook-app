package com.facebook.groups.mutations.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.mutations.protocol.GroupPostMutationsModels.GroupApprovePendingStoryMutationModel;
import com.facebook.groups.mutations.protocol.GroupPostMutationsModels.GroupPinStoryMutationModel;
import com.facebook.groups.mutations.protocol.GroupPostMutationsModels.GroupUnpinStoryMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: entity_cards_visible_id */
public final class GroupPostMutations {

    /* compiled from: entity_cards_visible_id */
    public class GroupApprovePendingStoryMutationString extends TypedGraphQLMutationString<GroupApprovePendingStoryMutationModel> {
        public GroupApprovePendingStoryMutationString() {
            super(GroupApprovePendingStoryMutationModel.class, false, "GroupApprovePendingStoryMutation", "093fa32eca4133fa10fc25cfb723c4de", "group_approve_pending_story", "0", "10154204803751729", RegularImmutableSet.a);
        }

        public final String m17068a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: entity_cards_visible_id */
    public class GroupPinStoryMutationString extends TypedGraphQLMutationString<GroupPinStoryMutationModel> {
        public GroupPinStoryMutationString() {
            super(GroupPinStoryMutationModel.class, false, "GroupPinStoryMutation", "d0b8c78f1a9f5b6e5be2545dd1a11747", "group_pin_story", "0", "10154204803806729", RegularImmutableSet.a);
        }

        public final String m17069a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: entity_cards_visible_id */
    public class GroupUnpinStoryMutationString extends TypedGraphQLMutationString<GroupUnpinStoryMutationModel> {
        public GroupUnpinStoryMutationString() {
            super(GroupUnpinStoryMutationModel.class, false, "GroupUnpinStoryMutation", "04b2e105682937428e9db84c4d3f1fd7", "group_unpin_story", "0", "10154346623591729", RegularImmutableSet.a);
        }

        public final String m17070a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
