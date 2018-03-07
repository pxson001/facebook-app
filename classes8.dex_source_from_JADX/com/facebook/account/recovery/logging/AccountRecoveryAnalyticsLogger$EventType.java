package com.facebook.account.recovery.logging;

/* compiled from: local_content_menu_id */
public enum AccountRecoveryAnalyticsLogger$EventType {
    CHANGE_SEARCH_TYPE_CLICK("change_search_type_click"),
    SHOW_HIDE_PASSWORD("show_password"),
    SHOW_PASSWORD_CHECKED("show_password_checked"),
    SHOW_PASSWORD_UNCHECKED("show_password_unchecked"),
    FORGOT_PASSWORD_CLICK("forgot_password_click"),
    HELP_CENTER_CLICK("help_center_click"),
    FB4A_ACCOUNT_RECOVERY("fb4a_account_recovery"),
    MSITE_ACCOUNT_RECOVERY("msite_account_recovery"),
    LOGIN_FROM_MSITE("login_from_msite"),
    TEST_BOUNCE_FROM_MSITE("test_bounce_from_msite"),
    UNSET_BOUNCE_FROM_MSITE("unset_bounce_from_msite"),
    BOUNCE_FROM_MSITE("bounce_from_msite"),
    BACKGROUND_FETCH_DEVICE_DATA("background_fetch_device_data"),
    DEVICE_DATA_READY("device_data_ready"),
    CUID_READY("cuid_ready"),
    PARALLEL_SEARCH_READY("parallel_search_ready"),
    AUTO_IDENTIFY_STARTED("auto_identify_started"),
    AUTO_IDENTIFY_PERFORMED("auto_identify_performed"),
    AUTO_IDENTIFY_FAILED("auto_identify_failed"),
    SEARCH_VIEWED("search_viewed"),
    SEARCH_SENT("search_sent"),
    SEARCH_PERFORMED("search_performed"),
    CAPTCHA_REQUIRED("ar_search_captcha_required"),
    LIST_SHOWN("list_shown"),
    FRIEND_SEARCH_VIEWED("friend_search_viewed"),
    FRIEND_SEARCH_SENT("friend_search_sent"),
    FRIEND_SEARCH_PERFORMED("friend_search_performed"),
    INITIATE_VIEWED("initiate_viewed"),
    EMAIL_LISTED_BEFORE_SMS("email_listed_before_sms"),
    SENT_CODE_EMAIL("sent_code_email"),
    SENT_CODE_SMS("sent_code_sms"),
    SMS_CODE_SEARCHED("sms_code_searched"),
    CODE_ENTRY_VIEWED("code_entry_viewed"),
    CODE_SUBMITTED("ar_code_submitted"),
    LOGOUT_OPTION_SELECTED("logout_option_selected"),
    CHANGE_PASSWORD_VIEWED("change_password_viewed"),
    PASSWORD_SHOWN("ar_password_shown"),
    CHANGE_PASSWORD_SUBMITTED("change_password_submitted"),
    RECOVERY_SUCCESS("recovery_success");
    
    private final String mEventName;

    private AccountRecoveryAnalyticsLogger$EventType(String str) {
        this.mEventName = str;
    }

    public final String getEventName() {
        return this.mEventName;
    }
}
