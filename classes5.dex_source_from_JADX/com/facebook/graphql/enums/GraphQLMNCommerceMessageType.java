package com.facebook.graphql.enums;

import android.support.v7.widget.LinearLayoutCompat;

/* compiled from: mProjection= */
public enum GraphQLMNCommerceMessageType {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    TEXT,
    IMAGE,
    VIDEO,
    AUDIO,
    FILE,
    ROBOT_TEXT,
    LOCATION,
    FORCED_FETCH_MESSAGE,
    RETAIL_PRODUCT_SUBSCRIPTION,
    RETAIL_PROMOTION,
    RETAIL_CANCELLATION,
    RETAIL_SHIPMENT,
    SHIPMENT_TRACKING_EVENT,
    AIRLINE_CHECKIN_REMINDER,
    AIRLINE_BOARDING_PASS,
    AIRLINE_UPDATE,
    AIRLINE_ITINERARY,
    CONTENT_SUBSCRIPTION,
    AD_ADMIN_TEXT,
    AD_TEXT,
    AD_BUBBLE,
    NON_AD,
    OTHER,
    GENERIC,
    BUTTON,
    RECEIPT,
    GENERIC_LEGACY,
    RIDE_INTENT,
    RIDE_SIGNUP,
    RIDE_WELCOME,
    RIDE_ORDER_CONFIRMATION,
    RIDE_REQUESTED,
    RIDE_DRIVER_ON_THE_WAY,
    RIDE_NO_DRIVER,
    RIDE_DRIVER_ARRIVING,
    RIDE_DRIVER_CANCELED,
    RIDE_RIDER_CANCELED,
    RIDE_COMPLETE,
    RIDE_ADMIN_MESSAGE,
    RIDE_RECEIPT,
    GET_RIDE,
    GIVE_RIDE,
    LINK,
    UNLINK,
    BLOCK_ALL,
    UNBLOCK_ALL,
    BLOCK_PROMOTION,
    UNBLOCK_PROMOTION,
    INITIAL_PROMOTION,
    WEAK_CONSENT_ADMIN_MESSAGE,
    AIRLINE_CHECKIN,
    AIRLINE_BOARDINGPASS,
    UNKNOWN;

    public static GraphQLMNCommerceMessageType fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        switch ((((Character.toUpperCase(str.charAt(0)) * 961) + (Character.toUpperCase(str.charAt(str.length() - 1)) * 31)) + str.length()) & 31) {
            case 1:
                if (str.equalsIgnoreCase("RIDE_RIDER_CANCELED")) {
                    return RIDE_RIDER_CANCELED;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (str.equalsIgnoreCase("AIRLINE_CHECKIN")) {
                    return AIRLINE_CHECKIN;
                }
                if (str.equalsIgnoreCase("AIRLINE_BOARDINGPASS")) {
                    return AIRLINE_BOARDINGPASS;
                }
                if (str.equalsIgnoreCase("OTHER")) {
                    return OTHER;
                }
                if (str.equalsIgnoreCase("RIDE_DRIVER_CANCELED")) {
                    return RIDE_DRIVER_CANCELED;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 3:
                if (str.equalsIgnoreCase("AIRLINE_BOARDING_PASS")) {
                    return AIRLINE_BOARDING_PASS;
                }
                if (str.equalsIgnoreCase("BLOCK_PROMOTION")) {
                    return BLOCK_PROMOTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                if (str.equalsIgnoreCase("TEXT")) {
                    return TEXT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 5:
                if (str.equalsIgnoreCase("FILE")) {
                    return FILE;
                }
                if (str.equalsIgnoreCase("AD_BUBBLE")) {
                    return AD_BUBBLE;
                }
                if (str.equalsIgnoreCase("RECEIPT")) {
                    return RECEIPT;
                }
                if (str.equalsIgnoreCase("LINK")) {
                    return LINK;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 6:
                if (str.equalsIgnoreCase("LOCATION")) {
                    return LOCATION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 7:
                if (str.equalsIgnoreCase("AIRLINE_CHECKIN_REMINDER")) {
                    return AIRLINE_CHECKIN_REMINDER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 8:
                if (str.equalsIgnoreCase("ROBOT_TEXT")) {
                    return ROBOT_TEXT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 9:
                if (str.equalsIgnoreCase("IMAGE")) {
                    return IMAGE;
                }
                if (str.equalsIgnoreCase("CONTENT_SUBSCRIPTION")) {
                    return CONTENT_SUBSCRIPTION;
                }
                if (str.equalsIgnoreCase("RIDE_INTENT")) {
                    return RIDE_INTENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 10:
                if (str.equalsIgnoreCase("AIRLINE_UPDATE")) {
                    return AIRLINE_UPDATE;
                }
                if (str.equalsIgnoreCase("RIDE_RECEIPT")) {
                    return RIDE_RECEIPT;
                }
                if (str.equalsIgnoreCase("GET_RIDE")) {
                    return GET_RIDE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 11:
                if (str.equalsIgnoreCase("GENERIC")) {
                    return GENERIC;
                }
                if (str.equalsIgnoreCase("GIVE_RIDE")) {
                    return GIVE_RIDE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 12:
                if (str.equalsIgnoreCase("VIDEO")) {
                    return VIDEO;
                }
                if (str.equalsIgnoreCase("INITIAL_PROMOTION")) {
                    return INITIAL_PROMOTION;
                }
                if (str.equalsIgnoreCase("WEAK_CONSENT_ADMIN_MESSAGE")) {
                    return WEAK_CONSENT_ADMIN_MESSAGE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 13:
                if (str.equalsIgnoreCase("RETAIL_SHIPMENT")) {
                    return RETAIL_SHIPMENT;
                }
                if (str.equalsIgnoreCase("RIDE_SIGNUP")) {
                    return RIDE_SIGNUP;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 14:
                if (str.equalsIgnoreCase("UNKNOWN")) {
                    return UNKNOWN;
                }
                if (str.equalsIgnoreCase("RIDE_NO_DRIVER")) {
                    return RIDE_NO_DRIVER;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 15:
                if (str.equalsIgnoreCase("RIDE_DRIVER_ON_THE_WAY")) {
                    return RIDE_DRIVER_ON_THE_WAY;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 16:
                if (str.equalsIgnoreCase("NON_AD")) {
                    return NON_AD;
                }
                if (str.equalsIgnoreCase("UNLINK")) {
                    return UNLINK;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 20:
                if (str.equalsIgnoreCase("RETAIL_PROMOTION")) {
                    return RETAIL_PROMOTION;
                }
                if (str.equalsIgnoreCase("AD_TEXT")) {
                    return AD_TEXT;
                }
                if (str.equalsIgnoreCase("UNBLOCK_ALL")) {
                    return UNBLOCK_ALL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 21:
                if (str.equalsIgnoreCase("FORCED_FETCH_MESSAGE")) {
                    return FORCED_FETCH_MESSAGE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 22:
                if (str.equalsIgnoreCase("SHIPMENT_TRACKING_EVENT")) {
                    return SHIPMENT_TRACKING_EVENT;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 23:
                if (str.equalsIgnoreCase("AUDIO")) {
                    return AUDIO;
                }
                if (str.equalsIgnoreCase("RETAIL_CANCELLATION")) {
                    return RETAIL_CANCELLATION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 24:
                if (str.equalsIgnoreCase("UNBLOCK_PROMOTION")) {
                    return UNBLOCK_PROMOTION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 25:
                if (str.equalsIgnoreCase("AIRLINE_ITINERARY")) {
                    return AIRLINE_ITINERARY;
                }
                if (str.equalsIgnoreCase("RIDE_WELCOME")) {
                    return RIDE_WELCOME;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 26:
                if (str.equalsIgnoreCase("AD_ADMIN_TEXT")) {
                    return AD_ADMIN_TEXT;
                }
                if (str.equalsIgnoreCase("BUTTON")) {
                    return BUTTON;
                }
                if (str.equalsIgnoreCase("RIDE_COMPLETE")) {
                    return RIDE_COMPLETE;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 27:
                if (str.equalsIgnoreCase("RIDE_ORDER_CONFIRMATION")) {
                    return RIDE_ORDER_CONFIRMATION;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 28:
                if (str.equalsIgnoreCase("GENERIC_LEGACY")) {
                    return GENERIC_LEGACY;
                }
                if (str.equalsIgnoreCase("RIDE_REQUESTED")) {
                    return RIDE_REQUESTED;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            case 31:
                if (str.equalsIgnoreCase("RETAIL_PRODUCT_SUBSCRIPTION")) {
                    return RETAIL_PRODUCT_SUBSCRIPTION;
                }
                if (str.equalsIgnoreCase("RIDE_DRIVER_ARRIVING")) {
                    return RIDE_DRIVER_ARRIVING;
                }
                if (str.equalsIgnoreCase("RIDE_ADMIN_MESSAGE")) {
                    return RIDE_ADMIN_MESSAGE;
                }
                if (str.equalsIgnoreCase("BLOCK_ALL")) {
                    return BLOCK_ALL;
                }
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            default:
                return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }
}
