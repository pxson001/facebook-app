package com.facebook.events.notificationsettings.protocol;

import com.facebook.events.notificationsettings.protocol.EventsNotificationSettingsGraphQLModels.FetchEventsNotificationSubscriptionLevelsModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: catalog_content_cached */
public final class EventsNotificationSettingsGraphQL {

    /* compiled from: catalog_content_cached */
    public class FetchEventsNotificationSubscriptionLevelsString extends TypedGraphQlQueryString<FetchEventsNotificationSubscriptionLevelsModel> {
        public FetchEventsNotificationSubscriptionLevelsString() {
            super(FetchEventsNotificationSubscriptionLevelsModel.class, false, "FetchEventsNotificationSubscriptionLevels", "34172a5767b8fa0a5d5deb740f2d3d0c", "event", "10154405445266729", RegularImmutableSet.a);
        }

        public final String m18160a(String str) {
            switch (str.hashCode()) {
                case 278118624:
                    return "0";
                default:
                    return str;
            }
        }
    }
}
