package com.facebook.groups.mutations.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.mutations.protocol.GroupMutationsModels.FBGroupPurposeModalSeenCoreMutationModel;
import com.facebook.groups.mutations.protocol.GroupMutationsModels.GroupAcceptInvitationToJoinMutationModel;
import com.facebook.groups.mutations.protocol.GroupMutationsModels.GroupDeclineInvitationToJoinMutationModel;
import com.facebook.groups.mutations.protocol.GroupMutationsModels.GroupLeaveCoreMutationModel;
import com.facebook.groups.mutations.protocol.GroupMutationsModels.GroupRecordNotificationNuxDisplayCoreMutationModel;
import com.facebook.groups.mutations.protocol.GroupMutationsModels.GroupRequestToJoinCoreMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: entity_in_spotlight_section_tap */
public final class GroupMutations {

    /* compiled from: entity_in_spotlight_section_tap */
    public class FBGroupPurposeModalSeenCoreMutationString extends TypedGraphQLMutationString<FBGroupPurposeModalSeenCoreMutationModel> {
        public FBGroupPurposeModalSeenCoreMutationString() {
            super(FBGroupPurposeModalSeenCoreMutationModel.class, false, "FBGroupPurposeModalSeenCoreMutation", "0280a134126274102a8c8e4cac5e3e2e", "viewer_group_purpose_modal_seen", "0", "10154204803746729", RegularImmutableSet.a);
        }

        public final String m16968a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: entity_in_spotlight_section_tap */
    public class GroupAcceptInvitationToJoinMutationString extends TypedGraphQLMutationString<GroupAcceptInvitationToJoinMutationModel> {
        public GroupAcceptInvitationToJoinMutationString() {
            super(GroupAcceptInvitationToJoinMutationModel.class, false, "GroupAcceptInvitationToJoinMutation", "c40276bfaad85ecc1f0b0b65fc2a4aeb", "group_user_invite_accept", "0", "10154346623516729", RegularImmutableSet.a);
        }

        public final String m16969a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: entity_in_spotlight_section_tap */
    public class GroupDeclineInvitationToJoinMutationString extends TypedGraphQLMutationString<GroupDeclineInvitationToJoinMutationModel> {
        public GroupDeclineInvitationToJoinMutationString() {
            super(GroupDeclineInvitationToJoinMutationModel.class, false, "GroupDeclineInvitationToJoinMutation", "b99fc0647613522374343a46277309a2", "group_user_invite_decline", "0", "10154346623526729", RegularImmutableSet.a);
        }

        public final String m16970a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: entity_in_spotlight_section_tap */
    public class GroupLeaveCoreMutationString extends TypedGraphQLMutationString<GroupLeaveCoreMutationModel> {
        public GroupLeaveCoreMutationString() {
            super(GroupLeaveCoreMutationModel.class, false, "GroupLeaveCoreMutation", "f810d73c354f84e1d4f3e7094f216da1", "group_leave", "0", "10154204803711729", RegularImmutableSet.a);
        }

        public final String m16971a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: entity_in_spotlight_section_tap */
    public class GroupRecordNotificationNuxDisplayCoreMutationString extends TypedGraphQLMutationString<GroupRecordNotificationNuxDisplayCoreMutationModel> {
        public GroupRecordNotificationNuxDisplayCoreMutationString() {
            super(GroupRecordNotificationNuxDisplayCoreMutationModel.class, false, "GroupRecordNotificationNuxDisplayCoreMutation", "f2548049aa2fb5c42e73eefe148fdbca", "group_record_notification_nux_display", "0", "10154204803736729", RegularImmutableSet.a);
        }

        public final String m16972a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: entity_in_spotlight_section_tap */
    public class GroupRequestToJoinCoreMutationString extends TypedGraphQLMutationString<GroupRequestToJoinCoreMutationModel> {
        public GroupRequestToJoinCoreMutationString() {
            super(GroupRequestToJoinCoreMutationModel.class, false, "GroupRequestToJoinCoreMutation", "85db8385baa91c75cd66974ef360018f", "group_request_to_join", "0", "10154204803716729", RegularImmutableSet.a);
        }

        public final String m16973a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
