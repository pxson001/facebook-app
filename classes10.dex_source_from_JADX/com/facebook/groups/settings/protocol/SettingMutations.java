package com.facebook.groups.settings.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.groups.settings.protocol.SettingMutationsModels.GroupUpdatePushSubscriptionMutationModel;
import com.facebook.groups.settings.protocol.SettingMutationsModels.GroupUpdateRequestToJoinSubscriptionMutationModel;
import com.facebook.groups.settings.protocol.SettingMutationsModels.GroupUpdateSubscriptionMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: THREAD_SETTINGS_INVITE_BUTTON */
public final class SettingMutations {

    /* compiled from: THREAD_SETTINGS_INVITE_BUTTON */
    public class GroupUpdatePushSubscriptionMutationString extends TypedGraphQLMutationString<GroupUpdatePushSubscriptionMutationModel> {
        public GroupUpdatePushSubscriptionMutationString() {
            super(GroupUpdatePushSubscriptionMutationModel.class, false, "GroupUpdatePushSubscriptionMutation", "6e31d2836e0ad435a348ef3dc2060029", "group_update_push_subscription_level", "0", "10154346623611729", RegularImmutableSet.a);
        }

        public final String m24459a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: THREAD_SETTINGS_INVITE_BUTTON */
    public class GroupUpdateRequestToJoinSubscriptionMutationString extends TypedGraphQLMutationString<GroupUpdateRequestToJoinSubscriptionMutationModel> {
        public GroupUpdateRequestToJoinSubscriptionMutationString() {
            super(GroupUpdateRequestToJoinSubscriptionMutationModel.class, false, "GroupUpdateRequestToJoinSubscriptionMutation", "e9bc7cde747b5f95494489f53800febb", "group_update_request_to_join_subscription_level", "0", "10154346623601729", RegularImmutableSet.a);
        }

        public final String m24460a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: THREAD_SETTINGS_INVITE_BUTTON */
    public class GroupUpdateSubscriptionMutationString extends TypedGraphQLMutationString<GroupUpdateSubscriptionMutationModel> {
        public GroupUpdateSubscriptionMutationString() {
            super(GroupUpdateSubscriptionMutationModel.class, false, "GroupUpdateSubscriptionMutation", "82bf9ec05680df78aa20e3a9d8740001", "group_update_subscription_level", "0", "10154346623586729", RegularImmutableSet.a);
        }

        public final String m24461a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
