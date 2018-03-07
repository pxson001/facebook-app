package com.facebook.notifications.protocol;

import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.notifications.protocol.NotificationSettingMutationsModels.PushNotificationsMuteMutationModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: name not allowed in array */
public final class NotificationSettingMutations {

    /* compiled from: name not allowed in array */
    public class PushNotificationsMuteMutationString extends TypedGraphQLMutationString<PushNotificationsMuteMutationModel> {
        public PushNotificationsMuteMutationString() {
            super(PushNotificationsMuteMutationModel.class, false, "PushNotificationsMuteMutation", "ffd3d962f3446d6252234dd8d9fcaa7e", "push_token_mute_notifications", "0", "10154204804161729", RegularImmutableSet.a);
        }

        public final String m10386a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
