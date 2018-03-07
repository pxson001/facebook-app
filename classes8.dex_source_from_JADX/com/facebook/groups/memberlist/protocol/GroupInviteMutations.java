package com.facebook.groups.memberlist.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.memberlist.protocol.GroupInviteMutationsModels.GroupRemoveInviteMutationModel;
import com.facebook.groups.memberlist.protocol.GroupInviteMutationsModels.GroupSendReminderMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: extra_events_discovery_single_tab_title */
public final class GroupInviteMutations {

    /* compiled from: extra_events_discovery_single_tab_title */
    public class GroupRemoveInviteMutationString extends TypedGraphQLMutationString<GroupRemoveInviteMutationModel> {
        public GroupRemoveInviteMutationString() {
            super(GroupRemoveInviteMutationModel.class, false, "GroupRemoveInviteMutation", "828592b44e257451ba8c4479020ede9b", "group_unconfirmed_member_remove_invite", "0", "10154516816151729", RegularImmutableSet.a);
        }

        public final String m16333a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: extra_events_discovery_single_tab_title */
    public class GroupSendReminderMutationString extends TypedGraphQLMutationString<GroupSendReminderMutationModel> {
        public GroupSendReminderMutationString() {
            super(GroupSendReminderMutationModel.class, false, "GroupSendReminderMutation", "f49aa4b74af7911e60bbfdfc157d192a", "group_unconfirmed_member_send_reminder", "0", "10154516816141729", RegularImmutableSet.a);
        }

        public final String m16334a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
