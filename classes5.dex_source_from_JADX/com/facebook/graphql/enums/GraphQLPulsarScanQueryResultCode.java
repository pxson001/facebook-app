package com.facebook.graphql.enums;

/* compiled from: login_identifier */
public enum GraphQLPulsarScanQueryResultCode {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SUCCESS,
    SUCCESS_BACKGROUND,
    SUCCESS_ADMIN_FORCE_ON,
    SUCCESS_BACKGROUND_FORCE_ON,
    SUCCESS_BACKGROUND_FORCE_OFF,
    USER_DISABLED,
    HOTSPOT_DETECTED,
    HOLDOUT_GROUP,
    ADMIN_FORCE_ON,
    BLE_PT_DISABLED_QE,
    USER_FAILS_PULSAR_GK,
    BACKGROUND_LOCATION_OFF,
    NULL_PAGE,
    SUCCESS_BOUNDRY,
    STATUS_DEACTIVATED,
    OUTSIDE_THRESHOLD,
    USER_SNOOZED_OR_HIDDEN,
    BUCKET_SUPPRESSED;

    public static GraphQLPulsarScanQueryResultCode fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SUCCESS")) {
            return SUCCESS;
        }
        if (str.equalsIgnoreCase("SUCCESS_BACKGROUND")) {
            return SUCCESS_BACKGROUND;
        }
        if (str.equalsIgnoreCase("SUCCESS_ADMIN_FORCE_ON")) {
            return SUCCESS_ADMIN_FORCE_ON;
        }
        if (str.equalsIgnoreCase("SUCCESS_BACKGROUND_FORCE_ON")) {
            return SUCCESS_BACKGROUND_FORCE_ON;
        }
        if (str.equalsIgnoreCase("SUCCESS_BACKGROUND_FORCE_OFF")) {
            return SUCCESS_BACKGROUND_FORCE_OFF;
        }
        if (str.equalsIgnoreCase("USER_DISABLED")) {
            return USER_DISABLED;
        }
        if (str.equalsIgnoreCase("HOTSPOT_DETECTED")) {
            return HOTSPOT_DETECTED;
        }
        if (str.equalsIgnoreCase("HOLDOUT_GROUP")) {
            return HOLDOUT_GROUP;
        }
        if (str.equalsIgnoreCase("ADMIN_FORCE_ON")) {
            return ADMIN_FORCE_ON;
        }
        if (str.equalsIgnoreCase("BLE_PT_DISABLED_QE")) {
            return BLE_PT_DISABLED_QE;
        }
        if (str.equalsIgnoreCase("USER_FAILS_PULSAR_GK")) {
            return USER_FAILS_PULSAR_GK;
        }
        if (str.equalsIgnoreCase("BACKGROUND_LOCATION_OFF")) {
            return BACKGROUND_LOCATION_OFF;
        }
        if (str.equalsIgnoreCase("NULL_PAGE")) {
            return NULL_PAGE;
        }
        if (str.equalsIgnoreCase("SUCCESS_BOUNDRY")) {
            return SUCCESS_BOUNDRY;
        }
        if (str.equalsIgnoreCase("STATUS_DEACTIVATED")) {
            return STATUS_DEACTIVATED;
        }
        if (str.equalsIgnoreCase("OUTSIDE_THRESHOLD")) {
            return OUTSIDE_THRESHOLD;
        }
        if (str.equalsIgnoreCase("USER_SNOOZED_OR_HIDDEN")) {
            return USER_SNOOZED_OR_HIDDEN;
        }
        if (str.equalsIgnoreCase("BUCKET_SUPPRESSED")) {
            return BUCKET_SUPPRESSED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
