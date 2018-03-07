package com.facebook.confirmation.logging;

/* compiled from: interacted_story_id */
public enum ConfirmationLoggingEventType {
    FLOW_ENTER("confirmation_flow_enter"),
    BACK_PRESS("confirmation_back_press"),
    CANCEL_CLICK("confirmation_cancel_click"),
    LOGOUT_CLICK("confirmation_logout_click"),
    FLOW_EXIT_SINCE_BACKGROUND_CONF("flow_exit_since_background_conf"),
    CONFIRMATION_ATTEMPT("confirmation_attempt"),
    CONFIRMATION_SUCCESS("confirmation_success"),
    CONFIRMATION_FAILURE("confirmation_failure"),
    RESEND_CODE_ATTEMPT("confirmation_resend_code_attempt"),
    RESEND_CODE_SUCCESS("confirmation_resend_code_success"),
    RESEND_CODE_FAILURE("confirmation_resend_code_failure"),
    CHANGE_CONTACTPOINT_ATTEMPT("confirmation_change_contactpoint_attempt"),
    CHANGE_CONTACTPOINT_SUCCESS("confirmation_change_contactpoint_success"),
    CHANGE_CONTACTPOINT_FAILURE("confirmation_change_contactpoint_failure"),
    CHANGE_CONTACTPOINT_FLOW_ENTER("confirmation_change_contactpoint_enter"),
    CHANGE_CONTACTPOINT_COUNTRY_SELECTED("confirmation_change_contactpoint_country_selected"),
    BACKGROUND_SMS_DETECTED("sms_auto_confirm_detected"),
    BACKGROUND_CONFIRMATION_START("sms_auto_confirm_start"),
    BACKGROUND_SMS_CONFIRMATION_ATTEMPT("sms_auto_confirm_attempt"),
    BACKGROUND_SMS_CONFIRMATION_SUCCESS("sms_auto_confirm_success"),
    BACKGROUND_SMS_CONFIRMATION_FAILURE("sms_auto_confirm_failure"),
    BACKGROUND_SMS_CONFIRMATION_NETWORK("sms_auto_confirm_network_failure"),
    BACKGROUND_EMAIL_CONFIRMATION_TASK_START("email_auto_confirm_task_start"),
    BACKGROUND_EMAIL_CONFIRMATION_SUCCESS("email_auto_confirm_success"),
    BACKGROUND_EMAIL_CONFIRMATION_FAILURE("email_auto_confirm_failure");
    
    private final String mAnalyticsName;

    private ConfirmationLoggingEventType(String str) {
        this.mAnalyticsName = str;
    }

    public final String getAnalyticsName() {
        return this.mAnalyticsName;
    }

    public final String toString() {
        return this.mAnalyticsName;
    }
}
