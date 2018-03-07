package com.facebook.graphql.enums;

/* compiled from: mediumImage */
public enum GraphQLAppStoreDownloadConnectivityPolicy {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    WIFI_FORCE,
    WIFI_ONLY,
    ANY;

    public static GraphQLAppStoreDownloadConnectivityPolicy fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("WIFI_FORCE")) {
            return WIFI_FORCE;
        }
        if (str.equalsIgnoreCase("WIFI_ONLY")) {
            return WIFI_ONLY;
        }
        if (str.equalsIgnoreCase("ANY")) {
            return ANY;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
