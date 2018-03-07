package com.facebook.messaging.groups.graphql;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.messaging.groups.graphql.JoinableGroupsMutationsModels.ChangeGroupApprovalModeSettingModel;
import com.facebook.messaging.groups.graphql.JoinableGroupsMutationsModels.ChangeGroupJoinableThreadSettingsModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: showPickerView */
public final class JoinableGroupsMutations {

    /* compiled from: showPickerView */
    public class ChangeGroupApprovalModeSettingString extends TypedGraphQLMutationString<ChangeGroupApprovalModeSettingModel> {
        public ChangeGroupApprovalModeSettingString() {
            super(ChangeGroupApprovalModeSettingModel.class, false, "ChangeGroupApprovalModeSetting", "f30597c6729d19c01ff130225071a15f", "messenger_group_change_thread_approval_settings", "0", "10154592979691729", RegularImmutableSet.a);
        }

        public final String m2437a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: showPickerView */
    public class ChangeGroupJoinableThreadSettingsString extends TypedGraphQLMutationString<ChangeGroupJoinableThreadSettingsModel> {
        public ChangeGroupJoinableThreadSettingsString() {
            super(ChangeGroupJoinableThreadSettingsModel.class, false, "ChangeGroupJoinableThreadSettings", "bb62c80dff8544b6a03e1d38c4bd3fda", "messenger_group_change_thread_joinable_settings", "0", "10154611766251729", RegularImmutableSet.a);
        }

        public final String m2438a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
