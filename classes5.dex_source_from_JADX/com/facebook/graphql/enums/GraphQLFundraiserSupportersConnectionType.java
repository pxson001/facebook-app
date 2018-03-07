package com.facebook.graphql.enums;

/* compiled from: m_search */
public enum GraphQLFundraiserSupportersConnectionType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    INVITED,
    DONATED,
    SHARED;

    public static GraphQLFundraiserSupportersConnectionType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("INVITED")) {
            return INVITED;
        }
        if (str.equalsIgnoreCase("DONATED")) {
            return DONATED;
        }
        if (str.equalsIgnoreCase("SHARED")) {
            return SHARED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
