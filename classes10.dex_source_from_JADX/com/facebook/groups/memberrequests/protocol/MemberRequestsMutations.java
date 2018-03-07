package com.facebook.groups.memberrequests.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutationsModels.GroupApproveAllPendingMembersMutationModel;
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutationsModels.GroupApprovePendingMemberMutationModel;
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutationsModels.GroupRejectAllPendingMembersMutationModel;
import com.facebook.groups.memberrequests.protocol.MemberRequestsMutationsModels.GroupRejectPendingMemberMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: TRESOURCE; */
public final class MemberRequestsMutations {

    /* compiled from: TRESOURCE; */
    public class GroupApproveAllPendingMembersMutationString extends TypedGraphQLMutationString<GroupApproveAllPendingMembersMutationModel> {
        public GroupApproveAllPendingMembersMutationString() {
            super(GroupApproveAllPendingMembersMutationModel.class, false, "GroupApproveAllPendingMembersMutation", "fbe7645de0e56185bedf3158b649c3df", "group_approve_all_pending_members", "0", "10154204803651729", RegularImmutableSet.a);
        }

        public final String m24179a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: TRESOURCE; */
    public class GroupApprovePendingMemberMutationString extends TypedGraphQLMutationString<GroupApprovePendingMemberMutationModel> {
        public GroupApprovePendingMemberMutationString() {
            super(GroupApprovePendingMemberMutationModel.class, false, "GroupApprovePendingMemberMutation", "65128b73c5df30e2ab5c5826be55d89d", "group_approve_pending_member", "0", "10154204803591729", RegularImmutableSet.a);
        }

        public final String m24180a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: TRESOURCE; */
    public class GroupRejectAllPendingMembersMutationString extends TypedGraphQLMutationString<GroupRejectAllPendingMembersMutationModel> {
        public GroupRejectAllPendingMembersMutationString() {
            super(GroupRejectAllPendingMembersMutationModel.class, false, "GroupRejectAllPendingMembersMutation", "2432c9adfbb64814e1939a9287cb9e1c", "group_reject_all_pending_members", "0", "10154204803631729", RegularImmutableSet.a);
        }

        public final String m24181a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: TRESOURCE; */
    public class GroupRejectPendingMemberMutationString extends TypedGraphQLMutationString<GroupRejectPendingMemberMutationModel> {
        public GroupRejectPendingMemberMutationString() {
            super(GroupRejectPendingMemberMutationModel.class, false, "GroupRejectPendingMemberMutation", "63550ed6660c83c61ee581668dea4247", "group_reject_pending_member", "0", "10154204803636729", RegularImmutableSet.a);
        }

        public final String m24182a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final GroupRejectPendingMemberMutationString m24183b() {
        return new GroupRejectPendingMemberMutationString();
    }
}
