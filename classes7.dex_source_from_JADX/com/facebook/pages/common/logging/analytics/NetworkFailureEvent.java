package com.facebook.pages.common.logging.analytics;

import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent.PageEventType;

/* compiled from: member_count */
public enum NetworkFailureEvent implements PageAnalyticsEvent {
    EVENT_PAGE_DETAILS_LOAD_ERROR("page_load_error"),
    EVENT_PAGE_INFO_LOAD_ERROR("info_page_load_error"),
    EVENT_PAGE_RATING_ERROR("page_rating_error"),
    EVENT_PLACE_REPORT_ERROR("place_report_error"),
    EVENT_PAGE_RECOMMENDATION_ERROR("page_recommendation_error"),
    EVENT_PAGE_EDIT_REVIEW_PRIVACY_ERROR("page_edit_review_privacy_error"),
    EVENT_PLACE_EDIT_REVIEW_ERROR("place_edit_review_error"),
    EVENT_PLACE_DELETE_REVIEW_FAILED("place_delete_review_failed"),
    EVENT_SHARE_PAGE_ERROR("page_share_error"),
    EVENT_CHECKIN_ERROR("page_checkin_error"),
    EVENT_LIKE_ERROR("page_like_error"),
    EVENT_UNLIKE_ERROR("page_unlike_error"),
    EVENT_FB_EVENT_STATUS_FAILURE("page_event_status_update_failure"),
    EVENT_RECOMMENDATION_UNLIKE_FAIL("recommendation_unlike_fail"),
    EVENT_RECOMMENDATION_LIKE_FAIL("recommendation_like_fail"),
    EVENT_SECTION_LOAD_ERROR("section_load_error"),
    EVENT_PLACE_SAVE_ERROR("place_save_error"),
    EVENT_PLACE_UNSAVE_ERROR("place_unsave_error"),
    EVENT_PAGE_SAVE_ERROR("page_save_error"),
    EVENT_PAGE_UNSAVE_ERROR("page_unsave_error"),
    EVENT_PAGE_FOLLOW_ERROR("page_follow_error"),
    EVENT_PAGE_UNFOLLOW_ERROR("page_unfollow_error"),
    EVENT_PAGE_FOLLOW_SEE_FIRST_ERROR("page_follow_see_first_error"),
    EVENT_PAGE_FOLLOW_REGULAR_ERROR("page_follow_regular_error"),
    EVENT_PAGE_ADD_TO_FAVORITES_ERROR("page_add_to_favorites_error"),
    EVENT_PAGE_REMOVE_FROM_FAVORITES_ERROR("page_remove_from_favorites_error");
    
    private String mEventName;

    private NetworkFailureEvent(String str) {
        this.mEventName = str;
    }

    public final String getName() {
        return this.mEventName;
    }

    public final PageEventType getType() {
        return PageEventType.NETWORK_FAILURE;
    }
}
