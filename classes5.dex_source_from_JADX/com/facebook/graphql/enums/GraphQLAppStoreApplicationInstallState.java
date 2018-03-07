package com.facebook.graphql.enums;

/* compiled from: medley */
public enum GraphQLAppStoreApplicationInstallState {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PENDING,
    DOWNLOADING,
    INSTALLING,
    FAILED_INSTALL,
    NOT_INSTALLED,
    INSTALLED,
    CANCELED;

    public static GraphQLAppStoreApplicationInstallState fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PENDING")) {
            return PENDING;
        }
        if (str.equalsIgnoreCase("DOWNLOADING")) {
            return DOWNLOADING;
        }
        if (str.equalsIgnoreCase("INSTALLING")) {
            return INSTALLING;
        }
        if (str.equalsIgnoreCase("FAILED_INSTALL")) {
            return FAILED_INSTALL;
        }
        if (str.equalsIgnoreCase("NOT_INSTALLED")) {
            return NOT_INSTALLED;
        }
        if (str.equalsIgnoreCase("INSTALLED")) {
            return INSTALLED;
        }
        if (str.equalsIgnoreCase("CANCELED")) {
            return CANCELED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
