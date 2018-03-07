package com.facebook.http.common;

/* compiled from: requests_in_queue_snapshot */
public enum BootstrapRequestName {
    CONFIRM_CONTACTPOINT_PRECONFIRMATION("confirmContactpointPreconfirmation"),
    INITIATE_PRECONFIRMATION("initiatePreconfirmation"),
    REGISTER_ACCOUNT("registerAccount"),
    RESET_PASSWORD_PRECONFIRMATION("resetPasswordPreconfirmation"),
    VALIDATE_REGISTRATION_DATA("validateRegistrationData"),
    CONTACT_POINT_SUGGESTIONS("contactPointSuggestions"),
    SYNC_X_CONFIGS("syncXConfigs"),
    SESSIONLESS_GK("fetchSessionlessGKInfo"),
    GK_INFO("fetchGKInfo"),
    REGISTER_PUSH("registerPush"),
    UNREGISTER_PUSH("unregisterPush"),
    GET_NOTIFICATION_COUNT("getNotificationCount"),
    NOTIFICATION_GET_SEEN_STATES("graphNotificationGetSeenStates"),
    GET_NOTIFICATION_URI("getNotificationURI"),
    LOGOUT("logout"),
    AUTHENTICATE("authenticate"),
    BOOKMARK_SYNC("bookmarkSync"),
    MQTT_CONFIG("getMobileConfig"),
    SMS_INVITE("messenger_invites"),
    GET_LOGGED_IN_USER_QUERY("GetLoggedInUserQuery"),
    FETCH_ZERO_TOKEN_QUERY("FetchZeroTokenQuery"),
    FETCH_ZERO_MESSAGE_QUOTA_QUERY("FetchZeroMessageQuotaQuery"),
    FETCH_ZERO_IP_TEST("FetchZeroIPTest"),
    ZERO_IP_TEST_SUBMIT("ZeroIPTestSubmitMutation"),
    REQUEST_MESSENGER_ONLY_CODE("requestMessengerOnlyConfirmationCode"),
    CONFIRM_MESSENGER_ONLY_CODE("confirmMessengerOnlyConfirmationCode"),
    LOGIN_MESSENGER_CREDS_BYPASS("loginBypassWithMessengerCredentials"),
    CREATE_MESSENGER_ACCOUNT("createMessengerOnlyAccount"),
    BATCH_COMPONENT_FETCH_CONFIGURATION("handleFetchConfiguration");
    
    public final String requestNameString;

    private BootstrapRequestName(String str) {
        this.requestNameString = str;
    }
}
