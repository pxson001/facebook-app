package com.facebook.placetips.logging;

import com.facebook.analytics.logger.HoneyClientEvent;

/* compiled from: scoped_singlestate_candidate_results */
public enum PlaceTipsAnalyticsEvent {
    START_SCAN_SESSION("gravity_start_scan_session", true),
    END_SCAN_SESSION_SUCCESS("gravity_end_scan_session_success"),
    END_SCAN_SESSION_FAIL("gravity_end_scan_session_fail"),
    START_BLE_SCAN("gravity_start_ble_scan"),
    END_BLE_SCAN_SUCCESS("gravity_finish_ble_scan"),
    END_BLE_SCAN_FAIL("gravity_finish_ble_scan_fail"),
    PRESENCE_CHANGED("gravity_location_changed"),
    PRESENCE_STAYED_THE_SAME("gravity_no_location_change"),
    PAGE_NEARBY_INSERTED("gravity_page_nearby_has_shown"),
    PAGE_NEARBY_INSERTED_2("gravity_feed_unit_gen"),
    START_PAGE_LOOKUP("gravity_start_page_lookup"),
    END_PAGE_LOOKUP_SUCCESS("gravity_page_lookup_success"),
    END_PAGE_LOOKUP_FAIL("gravity_page_lookup_fail"),
    GPS_LOCATION_REPORTED("gravity_gps_location_reported", true),
    GPS_LOCATION_CHECK_SKIPPED("gravity_gps_foreground_check_skipped", true),
    GPS_LOCATION_CHECK_FAILED("gravity_gps_foreground_check_failed", true),
    FEED_UNIT_VPV("gravity_feed_unit_vpv"),
    FEED_UNIT_CLICK("gravity_feed_unit_click"),
    EVENT_TIP_VIEW("event_tip_view"),
    EVENT_TIP_CLICK("event_tip_click"),
    SEARCH_NULL_STATE_VPV("gravity_search_null_state_vpv"),
    SEARCH_NULL_STATE_CLICK("gravity_search_null_state_click"),
    POST_COMPOSE_TOOLTIP_SEEN("gravity_post_compose_tooltip_seen");
    
    private final String mEventName;
    private final boolean mResetSession;

    private PlaceTipsAnalyticsEvent(String str) {
        this(r2, r3, str, false);
    }

    private PlaceTipsAnalyticsEvent(String str, boolean z) {
        this.mEventName = str;
        this.mResetSession = z;
    }

    public final HoneyClientEvent createHoneyClientEvent() {
        return new HoneyClientEvent(this.mEventName);
    }

    public final boolean shouldResetSession() {
        return this.mResetSession;
    }
}
