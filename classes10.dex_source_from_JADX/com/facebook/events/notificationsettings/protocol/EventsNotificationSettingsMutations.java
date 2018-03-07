package com.facebook.events.notificationsettings.protocol;

import com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsMutationsModels.EventUpdateNotificationSubscriptionLevelMutationModel;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: card_association */
public final class EventsNotificationSettingsMutations {

    /* compiled from: card_association */
    public class EventUpdateNotificationSubscriptionLevelMutationString extends TypedGraphQLMutationString<EventUpdateNotificationSubscriptionLevelMutationModel> {
        public EventUpdateNotificationSubscriptionLevelMutationString() {
            super(EventUpdateNotificationSubscriptionLevelMutationModel.class, false, "EventUpdateNotificationSubscriptionLevelMutation", "66bcdaeced045d4da02013ff809c2679", "event_update_notification_subscription_level", "0", "10154204802876729", RegularImmutableSet.a);
        }

        public final String m18196a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
