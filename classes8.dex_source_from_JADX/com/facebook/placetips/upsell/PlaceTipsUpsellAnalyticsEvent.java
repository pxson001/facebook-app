package com.facebook.placetips.upsell;

import com.facebook.analytics.logger.HoneyClientEvent;

/* compiled from: candidate_result_sid */
public enum PlaceTipsUpsellAnalyticsEvent {
    LOCATION_OPT_IN_FEED_UNIT_VPV("location_opt_in_feed_unit_vpv", true),
    LOCATION_OPT_IN_CHECKIN_SAVE_START("location_opt_in_checkin_save_start", true),
    LOCATION_OPT_IN_ON_LOGIN_GMS_LS_DIALOG_START("location_opt_in_on_login_gms_ls_dialog_start", true),
    LOCATION_OPT_IN_FEED_UNIT_CLICK("location_opt_in_feed_unit_click"),
    LOCATION_OPT_IN_INTRO_PAGE_IMPRESSION("location_opt_in_intro_page_impression"),
    LOCATION_OPT_IN_LH_NOTIFICATION_PAGE_IMPRESSION("location_opt_in_lh_notification_page_impression"),
    LOCATION_OPT_IN_ERROR_PAGE_IMPRESSION("location_opt_in_error_page_impression"),
    LOCATION_OPT_IN_CONFIRMATION_PAGE_IMPRESSION("location_opt_in_confirmation_page_impression"),
    LOCATION_OPT_IN_PLACE_SAVE_INTRO("location_opt_in_place_save_intro"),
    LOCATION_OPT_IN_INTRO_LEARN_MORE_TAPPED("location_opt_in_intro_learn_more_tapped"),
    LOCATION_OPT_IN_INTRO_NOT_NOW_TAPPED("location_opt_in_intro_not_now_tapped"),
    LOCATION_OPT_IN_INTRO_GET_STARTED_TAPPED("location_opt_in_intro_get_started_tapped"),
    LOCATION_OPT_IN_LH_NOTIFICATION_LEARN_MORE_TAPPED("location_opt_in_lh_notification_learn_more_tapped"),
    LOCATION_OPT_IN_LH_NOTIFICATION_NOT_NOW_TAPPED("location_opt_in_lh_notification_not_now_tapped"),
    LOCATION_OPT_IN_LH_NOTIFICATION_TURN_ON_TAPPED("location_opt_in_lh_notification_turn_on_tapped"),
    LOCATION_OPT_IN_ERROR_NOT_NOW_TAPPED("location_opt_in_error_not_now_tapped"),
    LOCATION_OPT_IN_ERROR_TRY_AGAIN_TAPPED("location_opt_in_error_try_again_tapped"),
    LOCATION_OPT_IN_CONFIRMATION_X_OUT_TAPPED("location_opt_in_confirmation_not_now_tapped"),
    LOCATION_OPT_IN_CONFIRMATION_PLACE_OR_SERP_TAPPED("location_opt_in_confirmation_place_or_serp_tapped"),
    LOCATION_OPT_IN_PLACE_SAVE_SNACKBAR_TAPPED("location_opt_in_place_save_snackbar_tapped"),
    LOCATION_OPT_IN_PLACE_SAVE_INTRO_LEARN_MORE_TAPPED("location_opt_in_place_save_intro_learn_more_tapped"),
    LOCATION_OPT_IN_PLACE_SAVE_INTRO_NOT_NOW_TAPPED("location_opt_in_place_save_intro_not_now_tapped"),
    LOCATION_OPT_IN_PLACE_SAVE_INTRO_GET_STARTED_TAPPED("location_opt_in_place_save_intro_get_started_tapped"),
    LOCATION_OPT_IN_PLACE_SAVE_BANNER_XOUT_TAPPED("location_opt_in_place_save_banner_xout_tapped"),
    LOCATION_OPT_IN_PLACE_SAVE_BANNER_LEARN_MORE_TAPPED("location_opt_in_place_save_banner_learn_more_tapped"),
    LOCATION_OPT_IN_LOCATION_HISTORY_TURNED_ON("location_opt_in_location_history_turned_on"),
    LOCATION_OPT_IN_LOCATION_HISTORY_FAILED("location_opt_in_location_history_failed"),
    LOCATION_OPT_IN_NOTIFICATIONS_TURNED_ON("location_opt_in_notifications_turned_on"),
    LOCATION_OPT_IN_NOTIFICATIONS_FAILED("location_opt_in_notifications_failed"),
    LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_STATUS_CHECK_DIALOG_IS_POSSIBLE("location_opt_in_google_play_location_status_check_dialog_is_possible"),
    LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_STATUS_CHECK_DIALOG_ALREADY_ATTEMPTED("location_opt_in_google_play_location_status_check_dialog_already_attempted"),
    LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_STATUS_CHECK_FAILED("location_opt_in_google_play_location_status_check_failed"),
    LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_DIALOG_TRIGGERED("location_opt_in_google_play_location_dialog_triggered"),
    LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_SUCCESS("location_opt_in_google_play_location_success"),
    LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_FAILED("location_opt_in_google_play_location_failed"),
    LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_NOT_NEEDED("location_opt_in_google_play_location_not_needed"),
    LOCATION_OPT_IN_GOOGLE_PLAY_LOCATION_NOT_POSSIBLE("location_opt_in_google_play_location_not_possible"),
    LOCATION_OPT_IN_LOCATION_PERMISSION_REQ_DENIED("location_opt_in_location_permission_req_denied"),
    LOCATION_OPT_IN_LOCATION_PERMISSION_REQ_CANCELED("location_opt_in_location_permission_req_canceled"),
    LOCATION_OPT_IN_BACK_BUTTON_PRESSED("location_opt_in_back_button_pressed");
    
    private final String mEventName;
    private final boolean mResetsSession;

    private PlaceTipsUpsellAnalyticsEvent(String str) {
        this(r2, r3, str, false);
    }

    private PlaceTipsUpsellAnalyticsEvent(String str, boolean z) {
        this.mEventName = str;
        this.mResetsSession = z;
    }

    public final HoneyClientEvent createHoneyClientEvent() {
        return new HoneyClientEvent(this.mEventName);
    }

    final boolean doesEventResetSession() {
        return this.mResetsSession;
    }
}
