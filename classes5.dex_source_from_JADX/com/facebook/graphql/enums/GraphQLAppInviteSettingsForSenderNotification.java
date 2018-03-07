package com.facebook.graphql.enums;

/* compiled from: megaphone_wide */
public enum GraphQLAppInviteSettingsForSenderNotification {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SENDER_NOTIFICATIONS_ENABLED,
    SENDER_NOTIFICATIONS_DISABLED;

    public static GraphQLAppInviteSettingsForSenderNotification fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SENDER_NOTIFICATIONS_ENABLED")) {
            return SENDER_NOTIFICATIONS_ENABLED;
        }
        if (str.equalsIgnoreCase("SENDER_NOTIFICATIONS_DISABLED")) {
            return SENDER_NOTIFICATIONS_DISABLED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
