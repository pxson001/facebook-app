package com.facebook.reaction.util;

import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;

/* compiled from: pulseContextFooterButtonsConverted */
public class ReactionSurfaceUtil {
    public static boolean m4789u(Surface surface) {
        return m4790v(surface) || m4778d(surface);
    }

    public static boolean m4776b(Surface surface) {
        return surface == Surface.INTERN_STYLE_LIBRARY;
    }

    public static boolean m4777c(Surface surface) {
        return m4789u(surface) || surface == Surface.ANDROID_FEED_CHECKIN_SUGGESTION;
    }

    public static boolean m4778d(Surface surface) {
        return surface == Surface.ANDROID_EXTERNAL_COMPOSER || surface == Surface.ANDROID_PLATFORM_COMPOSER;
    }

    public static boolean m4790v(Surface surface) {
        return surface == Surface.ANDROID_COMPOSER || surface == Surface.ANDROID_AFTER_PARTY_COMPOSER || surface == Surface.ANDROID_EVENTS_DASHBOARD_COMPOSER || surface == Surface.ANDROID_FEED_COMPOSER || surface == Surface.ANDROID_GROUP_COMPOSER || surface == Surface.ANDROID_PAGE_ADMIN_COMPOSER || surface == Surface.ANDROID_PAGE_COMPOSER || surface == Surface.ANDROID_PMA_PAGE_ADMIN_COMPOSER || surface == Surface.ANDROID_TIMELINE_COMPOSER || surface == Surface.ANDROID_VIDEO_COMPOSER;
    }

    public static boolean m4779e(Surface surface) {
        return surface == Surface.ANDROID_APP_INSTALL;
    }

    public static boolean m4780g(Surface surface) {
        if (!(m4781h(surface) || m4782i(surface) || m4784k(surface) || m4785l(surface) || m4787n(surface))) {
            Object obj = (surface == Surface.ANDROID_GAMETIME_MATCHUP_TAB || surface == Surface.ANDROID_GAMETIME_EXPERT_STORIES || surface == Surface.ANDROID_GAMETIME_FRIEND_STORIES || surface == Surface.ANDROID_GAMETIME_MATCH_STATS || surface == Surface.ANDROID_GAMETIME_SCORES) ? 1 : null;
            if (!(obj != null || m4786m(surface) || surface == Surface.A_PLACE_FOR || surface == Surface.ANDROID_CITY_GUIDE || surface == Surface.ANDROID_EVENT_DISCOVER_DASHBOARD || surface == Surface.ANDROID_EVENT_DISCOVER_EVENT_LIST || surface == Surface.ANDROID_EVENT_PERMALINK || surface == Surface.ANDROID_EVENT_PERMALINK_PRIVATE || surface == Surface.ANDROID_PAGE_ADS_AFTER_PARTY_AYMT_ACTIVITIES_TAB_ITEM || surface == Surface.ANDROID_PAGE_ADS_AFTER_PARTY_AYMT_CONTEXT_ITEM || surface == Surface.ANDROID_PAGE_LAUNCH_POINT_HOME || surface == Surface.ANDROID_PLACE_TIPS_EXPLORER || surface == Surface.ANDROID_SEARCH_PLACE_TIPS || surface == Surface.ANDROID_STORY || surface == Surface.ANDROID_TRENDING_PLACE_TIPS || surface == Surface.VIDEO_HOME || m4776b(surface))) {
                return false;
            }
        }
        return true;
    }

    public static boolean m4781h(Surface surface) {
        return surface == Surface.ANDROID_GRAVITY_SUGGESTION || surface == Surface.ANDROID_GPS_LOCATION_SUGGESTION || surface == Surface.ANDROID_FEED_CHECKIN_SUGGESTION || surface == Surface.ANDROID_RAGE_SHAKE_PLACE_TIPS || surface == Surface.ANDROID_PUSH_NOTIFICATION_LANDING;
    }

    public static boolean m4782i(Surface surface) {
        return surface == Surface.ANDROID_PAGE || surface == Surface.ANDROID_PAGE_ADMIN_OVERVIEW || surface == Surface.ANDROID_PAGE_ADMIN_FEED || surface == Surface.ANDROID_PAGE_SINGLE_CARD || surface == Surface.ANDROID_PAGE_LIKES_CONTEXT_ITEM || surface == Surface.ANDROID_POPULAR_AT_PLACE_CONTEXT_ITEM || surface == Surface.ANDROID_PAGE_FRIENDS_CONTENT_CONTEXT_ITEM || surface == Surface.ANDROID_PAGE_SANDBOX || m4783j(surface);
    }

    public static boolean m4783j(Surface surface) {
        return surface == Surface.ANDROID_PAGE_HOME || surface == Surface.ANDROID_PAGE_POSTS || surface == Surface.ANDROID_PAGE_ACTIVITY || surface == Surface.ANDROID_PAGE_PHOTOS_TAB || surface == Surface.ANDROID_PAGE_GROUPS_TAB;
    }

    public static boolean m4784k(Surface surface) {
        return surface == Surface.ANDROID_SEARCH_LOCAL || surface == Surface.ANDROID_SEARCH_LOCAL_ECHO || surface == Surface.ANDROID_SEARCH_LOCAL_FEEDSTORY || surface == Surface.ANDROID_SEARCH_LOCAL_FROMSET || surface == Surface.ANDROID_SEARCH_LOCAL_LOCALSERP || surface == Surface.ANDROID_SEARCH_LOCAL_NEARBY || surface == Surface.ANDROID_SEARCH_LOCAL_NULL || surface == Surface.ANDROID_SEARCH_LOCAL_OTHER || surface == Surface.ANDROID_SEARCH_LOCAL_RECENT || surface == Surface.ANDROID_SEARCH_LOCAL_PLACE_TIPS || surface == Surface.ANDROID_SEARCH_LOCAL_PLACE_TIPS_CHECKIN || surface == Surface.ANDROID_SEARCH_LOCAL_PLACE_TIPS_LOCATION || surface == Surface.ANDROID_SEARCH_LOCAL_PLACES_TAB || surface == Surface.ANDROID_SEARCH_LOCAL_PUSH || surface == Surface.ANDROID_SEARCH_LOCAL_SINGLE || surface == Surface.ANDROID_SEARCH_LOCAL_TODAY || surface == Surface.ANDROID_SEARCH_LOCAL_TYPEAHEAD;
    }

    public static boolean m4785l(Surface surface) {
        return surface == Surface.ANDROID_TODAY;
    }

    public static boolean m4786m(Surface surface) {
        return surface == Surface.ANDROID_FUNDRAISER_PAGE;
    }

    public static boolean m4787n(Surface surface) {
        return surface == Surface.ANDROID_NOTIFICATIONS;
    }

    public static boolean m4788q(Surface surface) {
        return surface == Surface.VIDEO_HOME;
    }
}
