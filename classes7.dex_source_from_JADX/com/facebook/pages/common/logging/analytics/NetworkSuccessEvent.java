package com.facebook.pages.common.logging.analytics;

import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent.PageEventType;

/* compiled from: media_uri */
public enum NetworkSuccessEvent implements PageAnalyticsEvent {
    EVENT_PAGE_VISIT("visit_page"),
    EVENT_PAGE_DETAILS_LOADED("page_load_successful"),
    EVENT_NETWORK_LOADED_BEFORE_CACHE("page_network_before_cache"),
    EVENT_PAGE_INFO_LOADED("info_page_load_successful"),
    EVENT_PAGE_RATING_SUCCESS("page_rating_successful"),
    EVENT_PLACE_REPORT_SUCCESS("place_report_successful"),
    EVENT_PAGE_RECOMMENDATION_SUCCESS("page_recommendation_successful"),
    EVENT_PAGE_EDIT_REVIEW_PRIVACY_SUCCESS("page_edit_review_privacy_success"),
    EVENT_PLACE_EDIT_REVIEW_SUCCESS("place_edit_review_success"),
    EVENT_PLACE_DELETE_REVIEW_SUCCESS("place_delete_review_success"),
    EVENT_SUGGEST_EDIT_SUCCESS("page_suggest_edit_successful"),
    EVENT_UNLIKE_SUCCESS("page_unlike_successful"),
    EVENT_LIKE_SUCCESS("page_like_successful"),
    EVENT_SHARE_PAGE_SUCCESS("page_share_successful"),
    EVENT_CHECKIN_SUCCESS("page_checkin_successful"),
    EVENT_FB_EVENT_STATUS_SUCCESS("page_event_status_update_success"),
    EVENT_RECOMMENDATION_LIKE_SUCCESS("recommendation_like_success"),
    EVENT_RECOMMENDATION_UNLIKE_SUCCESS("recommendation_unlike_success"),
    EVENT_SECTION_LOADED("section_loaded"),
    EVENT_PLACE_SAVE_SUCCESS("place_save_success"),
    EVENT_PLACE_UNSAVE_SUCCESS("place_unsave_success"),
    EVENT_PAGE_SAVE_SUCCESS("page_save_success"),
    EVENT_PAGE_UNSAVE_SUCCESS("page_unsave_success"),
    EVENT_PAGE_FOLLOW_SUCCESS("page_follow_success"),
    EVENT_PAGE_UNFOLLOW_SUCCESS("page_unfollow_success"),
    EVENT_PAGE_FOLLOW_SEE_FIRST_SUCCESS("page_follow_see_first_success"),
    EVENT_PAGE_FOLLOW_REGULAR_SUCCESS("page_follow_regular_success"),
    EVENT_PAGE_ADD_TO_FAVORITES_SUCCESS("page_add_to_favorites_success"),
    EVENT_PAGE_REMOVE_FROM_FAVORITES_SUCCESS("page_remove_from_favorites_success");
    
    private String mEventName;

    private NetworkSuccessEvent(String str) {
        this.mEventName = str;
    }

    public final String getName() {
        return this.mEventName;
    }

    public final PageEventType getType() {
        return PageEventType.NETWORK_SUCCESS;
    }
}
