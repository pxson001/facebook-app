package com.facebook.pages.common.logging.analytics;

import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent.PageEventType;

/* compiled from: media_1 */
public enum TapEvent implements PageAnalyticsEvent {
    EVENT_TAPPED_LIKE("tapped_like_page"),
    EVENT_TAPPED_UNLIKE("tapped_unlike_page"),
    EVENT_TAPPED_MORE_ACTION_BAR("tapped_more_button"),
    EVENT_TAPPED_MESSAGE("tapped_message_button"),
    EVENT_TAPPED_CHECKIN("tapped_check_in"),
    EVENT_TAPPED_SHARE_PAGE("tapped_share_page"),
    EVENT_TAPPED_SHARE_PAGE_AS_POST("tapped_share_page_as_post"),
    EVENT_TAPPED_REPORT_PROBLEM("tapped_report_problem"),
    EVENT_TAPPED_SAVE_PLACE("tapped_save_place"),
    EVENT_TAPPED_UNSAVE_PLACE("tapped_unsave_place"),
    EVENT_TAPPED_GOTO_SAVE_COLLECTION("tapped_goto_save_collection"),
    PAGE_EVENT_TAPPED_SAVE_MEDIA_PAGE("tapped_save_media_page"),
    PAGE_EVENT_TAPPED_UNSAVE_MEDIA_PAGE("tapped_unsave_media_page"),
    EVENT_TAPPED_COPY_LINK("tapped_copy_link"),
    EVENT_TAPPED_CREATE_SHORTCUT("tapped_create_shortcut"),
    EVENT_TAPPED_MANAGE_ADS("tapped_manage_ads"),
    EVENT_TAPPED_FOLLOW("tapped_follow_button"),
    EVENT_TAPPED_UNFOLLOW("tapped_unfollow_button"),
    EVENT_TAPPED_FOLLOW_SWITCHER("tapped_follow_switcher_button"),
    EVENT_TAPPED_FOLLOW_SWITCHER_UNFOLLOW("tapped_follow_switcher_unfollow"),
    EVENT_TAPPED_FOLLOW_SWITCHER_REGULAR("tapped_follow_switcher_regular"),
    EVENT_TAPPED_FOLLOW_SWITCHER_SEE_FIRST("tapped_follow_switcher_see_first"),
    EVENT_TAPPED_SUGGEST_EDIT("tapped_suggest_edit"),
    EVENT_TAPPED_REPORT("tapped_report_button"),
    EVENT_TAPPED_CREATE_PAGE("tapped_create_page_button"),
    EVENT_TAPPED_GET_NOTIFICATION("tapped_notification_setting"),
    EVENT_TAPPED_PLACE_CLAIM("tapped_place_claim"),
    PAGE_EVENT_TAPPED_CONSUME_ACTION("tapped_consume_action"),
    PAGE_EVENT_TAPPED_DEEPLINK_ACTION("tapped_deeplink_action"),
    EVENT_TAPPED_GET_DIRECTION("tapped_directions_button"),
    EVENT_TAPPED_CHILD_LOCATION("tapped_nearby_location"),
    EVENT_TAPPED_ALL_NEARBY_LOCATIONS_LIST("tapped_all_nearby_locations_list"),
    EVENT_TAPPED_ALL_NEARBY_LOCATIONS_MAP("tapped_all_nearby_locations_map"),
    EVENT_TAPPED_PLACES_MAP("tapped_places_map"),
    EVENT_TAPPED_SEE_FULL_MENU("tapped_see_full_menu"),
    EVENT_TAPPED_IMPRESSUM("tapped_impressum"),
    EVENT_PLACE_REPORT_CLAIMED_CLOSED("place_report_claimed_closed"),
    EVENT_PLACE_REPORT_CLAIMED_OPEN("place_report_claimed_open"),
    EVENT_REVIEW_NEEDY_PLACE_CARD_TAPPED("review_needy_place_card_tapped"),
    EVENT_TAPPED_REVIEWS_CONTEXT_ITEM("tapped_reviews_context_item"),
    EVENT_TAPPED_REVIEW_IN_ACTION_BAR("tapped_review_in_action_bar"),
    EVENT_TAPPED_PHOTOS_BY_PAGE("tapped_photos_by_page"),
    EVENT_TAPPED_PHOTOS_OF_PAGE("tapped_photos_at_page"),
    EVENT_TAPPED_PHOTOS_AT_PAGE("tapped_photos_of_page"),
    EVENT_TAPPED_ALL_PHOTOS_AT_PAGE("tapped_all_photos"),
    EVENT_TAPPED_PAGE_PHOTOS("tapped_page_photos"),
    EVENT_TAPPED_PUBLIC_PHOTOS("tapped_public_photos"),
    EVENT_TAPPED_CREATE_ALBUM("tapped_create_album"),
    EVENT_TAPPED_ALBUM("tapped_album"),
    EVENT_TAPPED_ADD_PHOTOS("tapped_add_photos"),
    EVENT_TAPPED_PHOTO("tapped_photo"),
    EVENT_TAPPED_FB_EVENT("tapped_event"),
    EVENT_TAPPED_FB_EVENT_GOING("tapped_event_going"),
    EVENT_TAPPED_FB_EVENT_NOT_GOING("tapped_event_not_going"),
    EVENT_TAPPED_INVITE_FRIENDS("tapped_invite_friends"),
    EVENT_TAPPED_INVITE_MORE_FRIENDS("tapped_invite_more_friends"),
    EVENT_TAPPED_INVITE_FRIEND_FROM_SOCIAL_CONTEXT_UNIT("tapped_invite_friend_from_social_context_unit"),
    EVENT_TAPPED_FRIENDS_HERE_NOW("tapped_friends_here_now"),
    EVENT_TAPPED_FRIENDS_LIKERS_VISITORS("tapped_friend_likers_or_visitors"),
    EVENT_TAPPED_VIDEO_HUB_CARD_HEADER("tapped_videohub_card_header"),
    EVENT_TAPPED_VIDEO_HUB_PLAYLIST_HEADER("tapped_videohub_playlist_header"),
    EVENT_TAPPED_VIDEO_HUB_ALL_VIDEOS("tapped_videohub_all_videos"),
    EVENT_TAPPED_SERVICES_CARD_SEE_ALL("page_service_card_see_all"),
    EVENT_TAPPED_SERVICES_CARD_ITEM("page_service_card_item"),
    EVENT_TAPPED_ABOUT_BLURB("tapped_about_info_blurb"),
    EVENT_TAPPED_COVER_PHOTO("tapped_page_cover_photo"),
    EVENT_TAPPED_SUGGEST_PHOTO("tapped_suggest_photo"),
    EVENT_TAPPED_PROFILE_PHOTO("tapped_page_profile_picture"),
    EVENT_TAPPED_CALL_TO_ACTION("tapped_call_to_action"),
    EVENT_TAPPED_VIEW_TIMELINE("tapped_view_timeline_button"),
    EVENT_TAPPED_SEE_MORE_INFORMATION("tapped_page_about"),
    EVENT_TAPPED_FRIEND_TIMELINE("tapped_friend_timeline"),
    EVENT_TAPPED_WIKIPEDIA_PAGE("tapped_page_wikipedia_page"),
    EVENT_TAPPED_POSTS_BY_OTHERS("tapped_posts_by_others"),
    EVENT_PLACE_DELETE_INLINE_RATING_TAPPED("place_delete_inline_rating_tapped"),
    EVENT_LIKE_RECENT_POST("like_recent_post"),
    EVENT_LIKE_STORY("like_story"),
    EVENT_TAPPED_SCROLL_BACK_TO_TOP("page_event_scroll_back_to_top_tapped"),
    EVENT_TAPPED_TIMELINE_FOOTER_CREATE_PAGE("tapped_timeline_footer_create_page");
    
    private String mEventName;

    private TapEvent(String str) {
        this.mEventName = str;
    }

    public final String getName() {
        return this.mEventName;
    }

    public final PageEventType getType() {
        return PageEventType.TAP;
    }
}
