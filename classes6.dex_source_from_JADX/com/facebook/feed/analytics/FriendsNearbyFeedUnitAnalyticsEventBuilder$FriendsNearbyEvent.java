package com.facebook.feed.analytics;

/* compiled from: neko_di_app_details */
public enum FriendsNearbyFeedUnitAnalyticsEventBuilder$FriendsNearbyEvent {
    FRIENDS_LOCATIONS_FEEDSTORY_TAP_PROFILE_PIC("friends_locations_feedstory_tap_profile_pic"),
    FRIENDS_LOCATIONS_FEEDSTORY_TAP_PROFILE("friends_locations_feedstory_tap_profile"),
    FRIENDS_LOCATIONS_FEEDSTORY_V2_TAP_PROFILE("friends_locations_feedstory_v2_tap_profile"),
    FRIENDS_LOCATIONS_FEEDSTORY_V2_TAP_MAP("friends_locations_feedstory_v2_tap_map"),
    FRIENDS_LOCATIONS_FEEDSTORY_SEE_ALL("friends_locations_feedstory_see_all"),
    FRIENDS_LOCATIONS_FEEDSTORY_TAP_MESSAGE("friends_locations_feedstory_tap_message"),
    FRIENDS_LOCATIONS_FEEDSTORY_SCROLL_LEFT("friends_locations_feedstory_scroll_left"),
    FRIENDS_LOCATIONS_FEEDSTORY_SCROLL_RIGHT("friends_locations_feedstory_scroll_right"),
    FRIENDS_LOCATIONS_FEEDSTORY_ITEM_IMPRESSION("friends_locations_feedstory_item_impression"),
    FRIENDS_LOCATIONS_FEEDSTORY_SCROLL_NEAR_END("friends_locations_feedstory_scroll_near_end");
    
    public final String mName;

    private FriendsNearbyFeedUnitAnalyticsEventBuilder$FriendsNearbyEvent(String str) {
        this.mName = str;
    }
}
