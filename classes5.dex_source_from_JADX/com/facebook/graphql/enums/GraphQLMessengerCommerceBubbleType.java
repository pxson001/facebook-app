package com.facebook.graphql.enums;

/* compiled from: mPicSquareUrlsWithSizes */
public enum GraphQLMessengerCommerceBubbleType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    FB_RETAIL_RECEIPT,
    FB_RETAIL_CANCELLATION,
    FB_RETAIL_SHIPMENT,
    FB_RETAIL_SHIPMENT_TRACKING_EVENT_ETA,
    FB_RETAIL_SHIPMENT_TRACKING_EVENT_IN_TRANSIT,
    FB_RETAIL_SHIPMENT_TRACKING_EVENT_OUT_FOR_DELIVERY,
    FB_RETAIL_SHIPMENT_TRACKING_EVENT_DELAYED,
    FB_RETAIL_SHIPMENT_TRACKING_EVENT_DELIVERED,
    FB_RETAIL_SHIPMENT_FOR_UNSUPPORTED_CARRIER,
    FB_RETAIL_SHIPMENT_ETA,
    FB_RETAIL_NOW_IN_STOCK,
    FB_RETAIL_AGENT_ITEM_SUGGESTION,
    FB_RETAIL_AGENT_ITEM_RECEIPT,
    FB_RETAIL_PROMOTIONAL_MSG;

    public static GraphQLMessengerCommerceBubbleType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("FB_RETAIL_RECEIPT")) {
            return FB_RETAIL_RECEIPT;
        }
        if (str.equalsIgnoreCase("FB_RETAIL_CANCELLATION")) {
            return FB_RETAIL_CANCELLATION;
        }
        if (str.equalsIgnoreCase("FB_RETAIL_SHIPMENT")) {
            return FB_RETAIL_SHIPMENT;
        }
        if (str.equalsIgnoreCase("FB_RETAIL_SHIPMENT_TRACKING_EVENT_ETA")) {
            return FB_RETAIL_SHIPMENT_TRACKING_EVENT_ETA;
        }
        if (str.equalsIgnoreCase("FB_RETAIL_SHIPMENT_TRACKING_EVENT_IN_TRANSIT")) {
            return FB_RETAIL_SHIPMENT_TRACKING_EVENT_IN_TRANSIT;
        }
        if (str.equalsIgnoreCase("FB_RETAIL_SHIPMENT_TRACKING_EVENT_OUT_FOR_DELIVERY")) {
            return FB_RETAIL_SHIPMENT_TRACKING_EVENT_OUT_FOR_DELIVERY;
        }
        if (str.equalsIgnoreCase("FB_RETAIL_SHIPMENT_TRACKING_EVENT_DELAYED")) {
            return FB_RETAIL_SHIPMENT_TRACKING_EVENT_DELAYED;
        }
        if (str.equalsIgnoreCase("FB_RETAIL_SHIPMENT_TRACKING_EVENT_DELIVERED")) {
            return FB_RETAIL_SHIPMENT_TRACKING_EVENT_DELIVERED;
        }
        if (str.equalsIgnoreCase("FB_RETAIL_SHIPMENT_FOR_UNSUPPORTED_CARRIER")) {
            return FB_RETAIL_SHIPMENT_FOR_UNSUPPORTED_CARRIER;
        }
        if (str.equalsIgnoreCase("FB_RETAIL_SHIPMENT_ETA")) {
            return FB_RETAIL_SHIPMENT_ETA;
        }
        if (str.equalsIgnoreCase("FB_RETAIL_NOW_IN_STOCK")) {
            return FB_RETAIL_NOW_IN_STOCK;
        }
        if (str.equalsIgnoreCase("FB_RETAIL_AGENT_ITEM_SUGGESTION")) {
            return FB_RETAIL_AGENT_ITEM_SUGGESTION;
        }
        if (str.equalsIgnoreCase("FB_RETAIL_AGENT_ITEM_RECEIPT")) {
            return FB_RETAIL_AGENT_ITEM_RECEIPT;
        }
        if (str.equalsIgnoreCase("FB_RETAIL_PROMOTIONAL_MSG")) {
            return FB_RETAIL_PROMOTIONAL_MSG;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
