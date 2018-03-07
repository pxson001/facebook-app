package com.facebook.graphql.enums;

/* compiled from: map_bounding_box */
public enum GraphQLEventTicketTierStatusEnum {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    PENDING,
    ON_SALE,
    PAUSED,
    SOLD_OUT;

    public static GraphQLEventTicketTierStatusEnum fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("PENDING")) {
            return PENDING;
        }
        if (str.equalsIgnoreCase("ON_SALE")) {
            return ON_SALE;
        }
        if (str.equalsIgnoreCase("PAUSED")) {
            return PAUSED;
        }
        if (str.equalsIgnoreCase("SOLD_OUT")) {
            return SOLD_OUT;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
