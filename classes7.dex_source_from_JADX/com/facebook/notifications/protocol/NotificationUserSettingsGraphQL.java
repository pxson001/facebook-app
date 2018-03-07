package com.facebook.notifications.protocol;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLModels.NotificationNodeSettingsQueryModel;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLModels.NotificationUserSettingsFragmentModel;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: mvex */
public final class NotificationUserSettingsGraphQL {

    /* compiled from: mvex */
    public class NotificationNodeSettingsQueryString extends TypedGraphQlQueryString<Map<String, NotificationNodeSettingsQueryModel>> {
        public NotificationNodeSettingsQueryString() {
            super(NotificationNodeSettingsQueryModel.class, true, "NotificationNodeSettingsQuery", "53705528cb9171fda3a755c0bf7dcc51", "nodes", "10154642660341729", RegularImmutableSet.a);
        }

        public final String m10426a(String str) {
            switch (str.hashCode()) {
                case -1773565470:
                    return "1";
                case -154818044:
                    return "3";
                case 104120:
                    return "0";
                case 421050507:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: mvex */
    public class NotificationUserSettingsQueryString extends TypedGraphQlQueryString<NotificationUserSettingsFragmentModel> {
        public NotificationUserSettingsQueryString() {
            super(NotificationUserSettingsFragmentModel.class, false, "NotificationUserSettingsQuery", "17ac0e90bf5a5fb949c2a46bc723cbc8", "notification_user_settings", "10154666308286729", RegularImmutableSet.a);
        }

        public final String m10427a(String str) {
            switch (str.hashCode()) {
                case -1773565470:
                    return "0";
                case -154818044:
                    return "2";
                case 421050507:
                    return "1";
                case 1162067831:
                    return "3";
                default:
                    return str;
            }
        }
    }
}
