package com.facebook.graphql.enums;

/* compiled from: live_permalink_time_range_sentence */
public enum GraphQLShipmentTrackingEventType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    UNKNOWN,
    ETA,
    ACCEPTED,
    IN_TRANSIT,
    OUT_FOR_DELIVERY,
    DELIVERED,
    DELAYED;

    public static GraphQLShipmentTrackingEventType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("UNKNOWN")) {
            return UNKNOWN;
        }
        if (str.equalsIgnoreCase("ETA")) {
            return ETA;
        }
        if (str.equalsIgnoreCase("ACCEPTED")) {
            return ACCEPTED;
        }
        if (str.equalsIgnoreCase("IN_TRANSIT")) {
            return IN_TRANSIT;
        }
        if (str.equalsIgnoreCase("OUT_FOR_DELIVERY")) {
            return OUT_FOR_DELIVERY;
        }
        if (str.equalsIgnoreCase("DELIVERED")) {
            return DELIVERED;
        }
        if (str.equalsIgnoreCase("DELAYED")) {
            return DELAYED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
