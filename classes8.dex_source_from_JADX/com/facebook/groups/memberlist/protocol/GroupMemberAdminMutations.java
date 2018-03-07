package com.facebook.groups.memberlist.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsModels.GroupAddAdminMutationModel;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsModels.GroupBlockMutationModel;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsModels.GroupRemoveAdminMutationModel;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsModels.GroupRemoveMemberMutationModel;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsModels.GroupSuggestAdminMutationModel;
import com.facebook.groups.memberlist.protocol.GroupMemberAdminMutationsModels.GroupUnblockMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: extra_composer_internal_session_id */
public final class GroupMemberAdminMutations {

    /* compiled from: extra_composer_internal_session_id */
    public class GroupAddAdminMutationString extends TypedGraphQLMutationString<GroupAddAdminMutationModel> {
        public GroupAddAdminMutationString() {
            super(GroupAddAdminMutationModel.class, false, "GroupAddAdminMutation", "c08182f28974157a7ee11700d48d14dc", "group_add_admin", "0", "10154346623461729", RegularImmutableSet.a);
        }

        public final String m16347a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: extra_composer_internal_session_id */
    public class GroupBlockMutationString extends TypedGraphQLMutationString<GroupBlockMutationModel> {
        public GroupBlockMutationString() {
            super(GroupBlockMutationModel.class, false, "GroupBlockMutation", "d2b2d1ea64b94840eae865c4b49198d3", "group_block", "0", "10154204803646729", RegularImmutableSet.a);
        }

        public final String m16348a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: extra_composer_internal_session_id */
    public class GroupRemoveAdminMutationString extends TypedGraphQLMutationString<GroupRemoveAdminMutationModel> {
        public GroupRemoveAdminMutationString() {
            super(GroupRemoveAdminMutationModel.class, false, "GroupRemoveAdminMutation", "3ae58059e511bfac8156fb6e3fd8d76e", "group_remove_admin", "0", "10154204803596729", RegularImmutableSet.a);
        }

        public final String m16349a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: extra_composer_internal_session_id */
    public class GroupRemoveMemberMutationString extends TypedGraphQLMutationString<GroupRemoveMemberMutationModel> {
        public GroupRemoveMemberMutationString() {
            super(GroupRemoveMemberMutationModel.class, false, "GroupRemoveMemberMutation", "302b47055c205685ac0b3f593c4de66e", "group_remove_member", "0", "10154204803616729", RegularImmutableSet.a);
        }

        public final String m16350a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: extra_composer_internal_session_id */
    public class GroupSuggestAdminMutationString extends TypedGraphQLMutationString<GroupSuggestAdminMutationModel> {
        public GroupSuggestAdminMutationString() {
            super(GroupSuggestAdminMutationModel.class, false, "GroupSuggestAdminMutation", "764b07023b2fdc5ee09c4f16a0620917", "group_suggest_admin", "0", "10154204803641729", RegularImmutableSet.a);
        }

        public final String m16351a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: extra_composer_internal_session_id */
    public class GroupUnblockMutationString extends TypedGraphQLMutationString<GroupUnblockMutationModel> {
        public GroupUnblockMutationString() {
            super(GroupUnblockMutationModel.class, false, "GroupUnblockMutation", "8cc6dd9dea22cf03d3183ac2cb4963df", "group_unblock_user", "0", "10154346623496729", RegularImmutableSet.a);
        }

        public final String m16352a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    public static final GroupAddAdminMutationString m16353a() {
        return new GroupAddAdminMutationString();
    }

    public static final GroupRemoveAdminMutationString m16354b() {
        return new GroupRemoveAdminMutationString();
    }

    public static final GroupRemoveMemberMutationString m16355c() {
        return new GroupRemoveMemberMutationString();
    }

    public static final GroupBlockMutationString m16356d() {
        return new GroupBlockMutationString();
    }
}
