package com.facebook.graphql.enums;

/* compiled from: load_redundant_fields */
public enum GraphQLRideRequestOutcome {
    UNSET_OR_UNRECOGNIZED_ENUM_VALUE,
    SUCCESS,
    SURGE_ACCEPTANCE_FLOW_NEEDED,
    ERROR_ACTIVE_RIDE,
    ERROR_NOT_AUTHORIZED,
    INTERNAL_SERVER_ERROR,
    ERROR_NON_EXISTENT_REQUEST,
    ERROR_UNEXPECTED_FAILURE_FROM_RIDE_PROVIDER,
    ERROR_INVALID_CONTACT_INFORMATION,
    ERROR_INVALID_PAYMENT_INFORMATION,
    ERROR_TOO_MANY_CANCELLATIONS,
    ERROR_DRIVERS_UNAVAILABLE,
    ERROR_CANCEL_RIDE_NON_ACTIVE_RIDE,
    ERROR_CANCEL_RIDE_USER_NOT_AN_OWNER,
    ERROR_RIDE_TYPE_NOT_ALLOWED,
    ERROR_PAYMENT_OUTSTANDING_BALANCE,
    ERROR_INVALID_PICKUP_DROPOFF,
    CANCEL_ACCEPTANCE_FLOW_NEEDED,
    ERROR_UPDATE_PAYMENT,
    ADDING_PAYMENT_NEEDED,
    ERROR_USER_NOT_ALLOWED,
    ERROR_USER_IN_DRIVER_MODE,
    ERROR_NO_SERVICE_IN_AREA,
    ERROR_UPDATE_PHONE_NUMBER_IN_PROVIDER_APP_NEEDED,
    ERROR_SAME_PICKUP_DROPOFF_LOCATION,
    ERROR_CONFIRM_EMAIL_IN_PROVIDER_APP_NEEDED;

    public static GraphQLRideRequestOutcome fromString(String str) {
        if (str == null || str.isEmpty()) {
            return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        if (str.equalsIgnoreCase("SUCCESS")) {
            return SUCCESS;
        }
        if (str.equalsIgnoreCase("SURGE_ACCEPTANCE_FLOW_NEEDED")) {
            return SURGE_ACCEPTANCE_FLOW_NEEDED;
        }
        if (str.equalsIgnoreCase("ERROR_ACTIVE_RIDE")) {
            return ERROR_ACTIVE_RIDE;
        }
        if (str.equalsIgnoreCase("ERROR_NOT_AUTHORIZED")) {
            return ERROR_NOT_AUTHORIZED;
        }
        if (str.equalsIgnoreCase("INTERNAL_SERVER_ERROR")) {
            return INTERNAL_SERVER_ERROR;
        }
        if (str.equalsIgnoreCase("ERROR_NON_EXISTENT_REQUEST")) {
            return ERROR_NON_EXISTENT_REQUEST;
        }
        if (str.equalsIgnoreCase("ERROR_UNEXPECTED_FAILURE_FROM_RIDE_PROVIDER")) {
            return ERROR_UNEXPECTED_FAILURE_FROM_RIDE_PROVIDER;
        }
        if (str.equalsIgnoreCase("ERROR_INVALID_CONTACT_INFORMATION")) {
            return ERROR_INVALID_CONTACT_INFORMATION;
        }
        if (str.equalsIgnoreCase("ERROR_INVALID_PAYMENT_INFORMATION")) {
            return ERROR_INVALID_PAYMENT_INFORMATION;
        }
        if (str.equalsIgnoreCase("ERROR_TOO_MANY_CANCELLATIONS")) {
            return ERROR_TOO_MANY_CANCELLATIONS;
        }
        if (str.equalsIgnoreCase("ERROR_DRIVERS_UNAVAILABLE")) {
            return ERROR_DRIVERS_UNAVAILABLE;
        }
        if (str.equalsIgnoreCase("ERROR_CANCEL_RIDE_NON_ACTIVE_RIDE")) {
            return ERROR_CANCEL_RIDE_NON_ACTIVE_RIDE;
        }
        if (str.equalsIgnoreCase("ERROR_CANCEL_RIDE_USER_NOT_AN_OWNER")) {
            return ERROR_CANCEL_RIDE_USER_NOT_AN_OWNER;
        }
        if (str.equalsIgnoreCase("ERROR_RIDE_TYPE_NOT_ALLOWED")) {
            return ERROR_RIDE_TYPE_NOT_ALLOWED;
        }
        if (str.equalsIgnoreCase("ERROR_PAYMENT_OUTSTANDING_BALANCE")) {
            return ERROR_PAYMENT_OUTSTANDING_BALANCE;
        }
        if (str.equalsIgnoreCase("ERROR_INVALID_PICKUP_DROPOFF")) {
            return ERROR_INVALID_PICKUP_DROPOFF;
        }
        if (str.equalsIgnoreCase("CANCEL_ACCEPTANCE_FLOW_NEEDED")) {
            return CANCEL_ACCEPTANCE_FLOW_NEEDED;
        }
        if (str.equalsIgnoreCase("ERROR_UPDATE_PAYMENT")) {
            return ERROR_UPDATE_PAYMENT;
        }
        if (str.equalsIgnoreCase("ADDING_PAYMENT_NEEDED")) {
            return ADDING_PAYMENT_NEEDED;
        }
        if (str.equalsIgnoreCase("ERROR_USER_NOT_ALLOWED")) {
            return ERROR_USER_NOT_ALLOWED;
        }
        if (str.equalsIgnoreCase("ERROR_USER_IN_DRIVER_MODE")) {
            return ERROR_USER_IN_DRIVER_MODE;
        }
        if (str.equalsIgnoreCase("ERROR_NO_SERVICE_IN_AREA")) {
            return ERROR_NO_SERVICE_IN_AREA;
        }
        if (str.equalsIgnoreCase("ERROR_UPDATE_PHONE_NUMBER_IN_PROVIDER_APP_NEEDED")) {
            return ERROR_UPDATE_PHONE_NUMBER_IN_PROVIDER_APP_NEEDED;
        }
        if (str.equalsIgnoreCase("ERROR_SAME_PICKUP_DROPOFF_LOCATION")) {
            return ERROR_SAME_PICKUP_DROPOFF_LOCATION;
        }
        if (str.equalsIgnoreCase("ERROR_CONFIRM_EMAIL_IN_PROVIDER_APP_NEEDED")) {
            return ERROR_CONFIRM_EMAIL_IN_PROVIDER_APP_NEEDED;
        }
        return UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }
}
