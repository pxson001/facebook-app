package com.facebook.reaction.analytics;

/* compiled from: bottom_related_articles */
public class ReactionAnalytics {

    /* compiled from: bottom_related_articles */
    public enum UnitInteractionSource {
        FOOTER("footer");
        
        public final String name;

        private UnitInteractionSource(String str) {
            this.name = str;
        }
    }

    /* compiled from: bottom_related_articles */
    public enum UnitInteractionType {
        ACCEPT_ADMIN_INVITE_TAP("accept_admin_invite_tap"),
        ADD_MORE_CARDS_TAP("add_more_cards_tap"),
        ADD_PHOTOS_AT_PLACE_TAP("add_photos_at_place_tap"),
        ALBUM_TAP("album_tap"),
        BOOST_POST_TAP("boost_post_tap"),
        BROWSE_QUERY_TAP("browse_query_tap"),
        CALL_PHONE_TAP("call_phone_tap"),
        CHECKIN_TAP("checkin_tap"),
        CONTACT_FUNDRAISER_SUPPORTERS("contact_fundraiser_supporters"),
        CREATION_TAB("creation_tab"),
        CRITIC_REVIEW_PAGE_TAP("critic_review_page_tap"),
        DECLINE_ADMIN_INVITE_TAP("decline_admin_invite_tap"),
        DISABLE_UNIT_TAP("disable_unit_tap"),
        DISMISS_UNIT_TAP("dismiss_unit_tap"),
        EDIT_PAGE_INFO_TAP("edit_page_info_tap"),
        EVENT_CARD_GOING_TAP("event_card_going_tap"),
        EVENT_CARD_INTERESTED_TAP("event_card_interested_tap"),
        EVENT_CARD_MAYBE_TAP("event_card_maybe_tap"),
        EVENT_CARD_NOT_GOING_TAP("event_card_not_going_tap"),
        EVENT_CARD_TAP("event_card_tap"),
        EVENT_CARD_UNWATCHED_TAP("event_card_unwatched_tap"),
        EVENT_CARD_WATCHED_TAP("event_card_watched_tap"),
        EVENT_MESSAGE_FRIENDS("event_message_friends"),
        EXTERNAL_PROFILE_LINK_SHARE("external_profile_link_share"),
        FACEWEB_URL_TAP("faceweb_url_tap"),
        GO_LIVE_TAP("go_live_tap"),
        GROUP_JOIN_TAP("group_join_tap"),
        GROUP_LEAVE_TAP("group_leave_tap"),
        HIDE_EVENT_SUGGESTION_TAP("hide_event_suggestion_tap"),
        INLINE_EXPANSION_TAP("inline_expansion_tap"),
        INNER_SCROLL("inner_scroll"),
        INVITE_FRIENDS_TO_EVENT("invite_friends_to_event"),
        JOIN_EVENT_TAP("join_event_tap"),
        LIKE_COMMENT_TAP("like_comment_tap"),
        MESSAGE_TAP("message_tap"),
        NEARBY_FRIENDS_NUX_TAP("nearby_friends_nux_tap"),
        NEARBY_FRIENDS_TAP("nearby_friends_tap"),
        NEARBY_PLACES_TAP("nearby_places_tap"),
        NOTIFICATIONS_INLINE_EXPANSION_TAP("notifications_inline_expansion_tap"),
        NOTIFICATIONS_TAP("notifications_tap"),
        NUX_CONTINUE_TAP("nux_continue_tap"),
        OPEN_ACORN_WEATHER_SETTINGS_TAP("open_acorn_weather_settings_tap"),
        OPEN_ALL_NOTIFICATIONS_TAP("open_all_notifications_tap"),
        OPEN_COMPOSER_TAP("open_composer_tap"),
        OPEN_FRIEND_INVITER("open_friend_inviter"),
        OPEN_LOCAL_SEARCH_TAP("open_local_search_tap"),
        OPEN_MAP_TAP("open_map_tap"),
        OPEN_PAGE_ADD_PRODUCT_TAP("open_page_add_product_tap"),
        OPEN_PAGE_CHILD_LOCATIONS("open_page_child_locations"),
        OPEN_PAGE_COMMERCE_TAP("open_page_commerce_tap"),
        OPEN_PAGE_INFO_TAP("open_page_info_tap"),
        OPEN_PAGE_MAP_TAP("open_page_map_tap"),
        OPEN_PAGE_NAVIGATION_TAP("open_page_navigation_tap"),
        OPEN_PAGE_PROMOTION("open_page_promotion"),
        OPEN_UPCOMING_BIRTHDAYS_TAP("open_upcoming_birthdays_tap"),
        OPEN_VERTICAL_ACTION_SHEET_TAP("open_vertical_action_sheet_tap"),
        OPEN_VIDEO_CHANNEL("open_video_channel"),
        PAGE_ADD_TAB_TAP("page_add_tab_tap"),
        PAGE_MANAGER_TAP("page_manager_tap"),
        PAGE_NEW_ACTIVITY_COUNT_TAP("page_new_activity_count_tap"),
        PHOTO_TAP("photo_tap"),
        PLACE_TIPS_HIDE_TAP("place_tips_hide_tap"),
        PROFILE_TAP("profile_tap"),
        PROMOTE_PAGE("promote_page"),
        QUESTION_ANSWER_TAP("question_answer_tap"),
        QUESTION_SKIP_TAP("question_skip_tap"),
        RATING_TAP("rating_tap"),
        RELOAD_UNIT_TAP("reload_unit_tap"),
        REPLACE_UNIT_TAP("replace_unit_tap"),
        REPLY_COMMMENT_TAP("reply_comment_tap"),
        SAVE_OG_OBJECT("save_og_object"),
        SAVE_PAGE_TAP("save_page_tap"),
        SEE_ALL_COMPONENTS("see_all_components"),
        SEE_ALL_FRIEND_REQUESTS("see_all_friend_requests"),
        SEE_ALL_RATINGS_TAP("see_all_ratings_tap"),
        SEE_ALL_SUGGESTED_EVENTS_TAP("see_all_suggested_events_tap"),
        SEE_MORE_APPS_TAP("see_more_apps_tap"),
        SEE_MORE_EVENTS("see_more_events"),
        SEE_MORE_TAP("see_more_tap"),
        SEE_PAGE_ADS_AND_PROMOTIONS("see_page_ads_and_promotions"),
        SEE_PAGE_LIKES_TAP("see_page_likes_tap"),
        SHARE_EVENT_TAP("share_event_tap"),
        SHARE_PHOTO_TO_PAGE_TAP("share_photo_to_page_tap"),
        STACK_CHILD_INTERACTION("stack_child_interaction"),
        STORY_TAP("story_tap"),
        SUBSCRIBE_PAGE_EVENTS_TAP("subscribe_page_events_tap"),
        TEXT_ENTITY_TAP("text_entity_tap"),
        TOPIC_TAP("topic_tap"),
        UNHIGHLIGHT_RICH_NOTIFICATION_TAP("unhighlight_rich_notification_tap"),
        VIDEO_TAP("video_tap"),
        VIEW_APP_TAP("view_app_tap"),
        VIEW_COMMENT_TAP("view_comment_tap"),
        VIEW_EVENT_GUEST_LIST("view_event_guest_list"),
        VIEW_EVENT_POSTS("view_event_posts"),
        VIEW_EVENTS_DASHBOARD_TAP("view_events_dashboard_tap"),
        VIEW_FUNDRAISER("view_fundraiser"),
        VIEW_FUNDRAISER_SUPPORTERS("view_fundraiser_supporters"),
        VIEW_GROUP_EVENTS_TAP("view_group_events_tap"),
        VIEW_GROUP_PHOTOS_TAP("view_group_photos_tap"),
        VIEW_GROUP_TAP("view_group_tap"),
        VIEW_PAGE_CHECKINS("view_page_checkins"),
        VIEW_PAGE_INSIGHTS("view_page_insights"),
        VIEW_PAGE_LIKERS("view_page_likers"),
        VIEW_PAGE_MENTIONS("view_page_mentions"),
        VIEW_PAGE_PROFILE("view_page_profile"),
        VIEW_PAGE_SERVICE_TAP("view_page_service_tap"),
        VIEW_PAGE_SETTINGS("view_page_settings"),
        VIEW_PAGE_SHARES("view_page_shares"),
        VIEW_PHOTO_MENU_TAP("view_photo_menu_tap"),
        VIEW_POST_INSIGHTS("view_post_insights"),
        VIEW_PROFILE_TAP("view_profile_tap"),
        VIEW_PYML_TAP("view_pyml_tap"),
        VIEW_STORY_INSIGHTS_TAP("view_story_insights_tap"),
        VIEW_STORY_TAP("view_story_tap"),
        VIEW_STRUCTURE_MENU_TAP("view_structured_menu_tap"),
        WHITELIST_UNIT_TAP("whitelist_unit_tap"),
        WRITE_POST_TO_PAGE_TAP("write_post_to_page_tap"),
        WRITE_REVIEW_PUBLISH("write_review_publish"),
        WRITE_REVIEW_TAP("write_review_tap");
        
        public final String name;

        private UnitInteractionType(String str) {
            this.name = str;
        }
    }

    /* compiled from: bottom_related_articles */
    public enum WelcomeHeaderInteractionType {
        HEADER_CHECK_IN("header_check_in"),
        HEADER_CONTEXT_ITEM_TAP("header_context_item_tap"),
        HEADER_LIKE_TAP("header_like_tap"),
        HEADER_SEE_LESS_TAP("header_see_less_tap"),
        HEADER_SEE_MORE_TAP("header_see_more_tap");
        
        public final String name;

        private WelcomeHeaderInteractionType(String str) {
            this.name = str;
        }
    }
}
