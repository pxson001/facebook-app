package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: pymk_feed */
public final class GametimeMatchReactionUnitsInputTriggerData extends GraphQlCallInput {

    /* compiled from: pymk_feed */
    public final class ReactionContext extends GraphQlCallInput {

        /* compiled from: pymk_feed */
        public enum RequestType implements JsonSerializable {
            INTERN("intern"),
            INTERN_ALL_STYLES("intern_all_styles"),
            NORMAL("normal"),
            PRIME("prime"),
            PREFETCH("prefetch"),
            PULL_TO_REFRESH("pull_to_refresh"),
            DIRECT_NODE_LOAD("direct_node_load"),
            COMPONENTS_PAGINATION("components_pagination"),
            COMPONENTS_RELOAD("components_reload"),
            RETRIGGER("retrigger"),
            SINGLE_UNIT("single_unit"),
            LOCATION_DARK_TEST("location_dark_test"),
            PLACE_FEED_SIMULATION("place_feed_simulation");
            
            protected final String serverValue;

            private RequestType(String str) {
                this.serverValue = str;
            }

            public final String toString() {
                return this.serverValue;
            }

            public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.b(this.serverValue);
            }

            public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
                throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
            }
        }

        /* compiled from: pymk_feed */
        public enum Surface implements JsonSerializable {
            ANDROID_EVENT_DISCOVER_DASHBOARD("ANDROID_EVENT_DISCOVER_DASHBOARD"),
            ANDROID_EVENT_DISCOVER_EVENT_LIST("ANDROID_EVENT_DISCOVER_EVENT_LIST"),
            ANDROID_EVENT_PERMALINK("ANDROID_EVENT_PERMALINK"),
            ANDROID_EVENT_PERMALINK_PRIVATE("ANDROID_EVENT_PERMALINK_PRIVATE"),
            ANDROID_FEED_CHECKIN_SUGGESTION("ANDROID_FEED_CHECKIN_SUGGESTION"),
            ANDROID_FUNDRAISER_PAGE("ANDROID_FUNDRAISER_PAGE"),
            ANDROID_GAMETIME_EXPERT_STORIES("ANDROID_GAMETIME_EXPERT_STORIES"),
            ANDROID_GAMETIME_FRIEND_STORIES("ANDROID_GAMETIME_FRIEND_STORIES"),
            ANDROID_GAMETIME_MATCHUP_TAB("ANDROID_GAMETIME_MATCHUP_TAB"),
            ANDROID_GAMETIME_MATCH_STATS("ANDROID_GAMETIME_MATCH_STATS"),
            ANDROID_GAMETIME_SCORES("ANDROID_GAMETIME_SCORES"),
            ANDROID_NEARBY_FRIENDS_DASHBOARD("ANDROID_NEARBY_FRIENDS_DASHBOARD"),
            ANDROID_NOTIFICATIONS("ANDROID_NOTIFICATIONS"),
            ANDROID_NOTIFICATIONS_FRIENDING("ANDROID_NOTIFICATIONS_FRIENDING"),
            ANDROID_PAGE("ANDROID_PAGE"),
            ANDROID_PAGE_ACTIVITY("ANDROID_PAGE_ACTIVITY"),
            ANDROID_PAGE_ADMIN_COMPOSER("ANDROID_PAGE_ADMIN_COMPOSER"),
            ANDROID_PAGE_ADMIN_FEED("ANDROID_PAGE_ADMIN_FEED"),
            ANDROID_PAGE_ADMIN_OVERVIEW("ANDROID_PAGE_ADMIN_OVERVIEW"),
            ANDROID_PAGE_ADS_AFTER_PARTY_AYMT_ACTIVITIES_TAB_ITEM("ANDROID_PAGE_ADS_AFTER_PARTY_AYMT_ACTIVITIES_TAB_ITEM"),
            ANDROID_PAGE_ADS_AFTER_PARTY_AYMT_CONTEXT_ITEM("ANDROID_PAGE_ADS_AFTER_PARTY_AYMT_CONTEXT_ITEM"),
            ANDROID_PAGE_FRIENDS_CONTENT_CONTEXT_ITEM("ANDROID_PAGE_FRIENDS_CONTENT_CONTEXT_ITEM"),
            ANDROID_PAGE_GROUPS_TAB("ANDROID_PAGE_GROUPS_TAB"),
            ANDROID_PAGE_HOME("ANDROID_PAGE_HOME"),
            ANDROID_PAGE_LAUNCH_POINT_HOME("ANDROID_PAGE_LAUNCH_POINT_HOME"),
            ANDROID_PAGE_LIKES_CONTEXT_ITEM("ANDROID_PAGE_LIKES_CONTEXT_ITEM"),
            ANDROID_PAGE_PHOTOS_OTHERS("ANDROID_PAGE_PHOTOS_OTHERS"),
            ANDROID_PAGE_PHOTOS_TAB("ANDROID_PAGE_PHOTOS_TAB"),
            ANDROID_PAGE_POSTS("ANDROID_PAGE_POSTS"),
            ANDROID_PAGE_POSTS_TO_PAGE("ANDROID_PAGE_POSTS_TO_PAGE"),
            ANDROID_PAGE_SANDBOX("ANDROID_PAGE_SANDBOX"),
            ANDROID_PAGE_SINGLE_CARD("ANDROID_PAGE_SINGLE_CARD"),
            ANDROID_PMA_PAGE_ADMIN_COMPOSER("ANDROID_PMA_PAGE_ADMIN_COMPOSER"),
            ANDROID_POPULAR_AT_PLACE_CONTEXT_ITEM("ANDROID_POPULAR_AT_PLACE_CONTEXT_ITEM"),
            ANDROID_SEARCH_KEYWORDS_TOP("ANDROID_SEARCH_KEYWORDS_TOP"),
            ANDROID_SEARCH_LOCAL_ECHO("ANDROID_SEARCH_LOCAL_ECHO"),
            ANDROID_SEARCH_LOCAL_FEEDSTORY("ANDROID_SEARCH_LOCAL_FEEDSTORY"),
            ANDROID_SEARCH_LOCAL_KWSERP_ENTITYMODULE("ANDROID_SEARCH_LOCAL_KWSERP_ENTITYMODULE"),
            ANDROID_SEARCH_LOCAL_LOCALSERP("ANDROID_SEARCH_LOCAL_LOCALSERP"),
            ANDROID_SEARCH_LOCAL_NEARBY("ANDROID_SEARCH_LOCAL_NEARBY"),
            ANDROID_SEARCH_LOCAL_NULL("ANDROID_SEARCH_LOCAL_NULL"),
            ANDROID_SEARCH_LOCAL_OTHER("ANDROID_SEARCH_LOCAL_OTHER"),
            ANDROID_SEARCH_LOCAL_PLACES_TAB("ANDROID_SEARCH_LOCAL_PLACES_TAB"),
            ANDROID_SEARCH_LOCAL_PLACE_TIPS("ANDROID_SEARCH_LOCAL_PLACE_TIPS"),
            ANDROID_SEARCH_LOCAL_PLACE_TIPS_CHECKIN("ANDROID_SEARCH_LOCAL_PLACE_TIPS_CHECKIN"),
            ANDROID_SEARCH_LOCAL_PLACE_TIPS_LOCATION("ANDROID_SEARCH_LOCAL_PLACE_TIPS_LOCATION"),
            ANDROID_SEARCH_LOCAL_PUSH("ANDROID_SEARCH_LOCAL_PUSH"),
            ANDROID_SEARCH_LOCAL_RECENT("ANDROID_SEARCH_LOCAL_RECENT"),
            ANDROID_SEARCH_LOCAL_SINGLE("ANDROID_SEARCH_LOCAL_SINGLE"),
            ANDROID_SEARCH_LOCAL_TODAY("ANDROID_SEARCH_LOCAL_TODAY"),
            ANDROID_SEARCH_LOCAL_TYPEAHEAD("ANDROID_SEARCH_LOCAL_TYPEAHEAD"),
            ANDROID_SEARCH_RESULTS("ANDROID_SEARCH_RESULTS"),
            ANDROID_STORY("ANDROID_STORY"),
            ANDROID_TODAY("ANDROID_TODAY"),
            A_PLACE_FOR("A_PLACE_FOR"),
            INTERN_STYLE_LIBRARY("INTERN_STYLE_LIBRARY"),
            INTERN_TOOL("INTERN_TOOL"),
            IOS_DISCOVERY("IOS_DISCOVERY"),
            IOS_EVENT_COLLECTION("IOS_EVENT_COLLECTION"),
            IOS_EVENT_DISCOVER_DASHBOARD("IOS_EVENT_DISCOVER_DASHBOARD"),
            IOS_EVENT_DISCOVER_EVENT_LIST("IOS_EVENT_DISCOVER_EVENT_LIST"),
            IOS_EVENT_GAMETIME_HIGHLIGHTS("IOS_EVENT_GAMETIME_HIGHLIGHTS"),
            IOS_EVENT_PERMALINK("IOS_EVENT_PERMALINK"),
            IOS_EVENT_PERMALINK_PRIVATE("IOS_EVENT_PERMALINK_PRIVATE"),
            IOS_FUNDRAISER_PAGE("IOS_FUNDRAISER_PAGE"),
            IOS_GAMETIME_EXPERT_STORIES("IOS_GAMETIME_EXPERT_STORIES"),
            IOS_GAMETIME_FRIEND_STORIES("IOS_GAMETIME_FRIEND_STORIES"),
            IOS_GAMETIME_HOME("IOS_GAMETIME_HOME"),
            IOS_GAMETIME_LEAGUE_EXPERT_STORIES("IOS_GAMETIME_LEAGUE_EXPERT_STORIES"),
            IOS_GAMETIME_LEAGUE_FRIEND_STORIES("IOS_GAMETIME_LEAGUE_FRIEND_STORIES"),
            IOS_GAMETIME_LEAGUE_SCHEDULE("IOS_GAMETIME_LEAGUE_SCHEDULE"),
            IOS_GAMETIME_LEAGUE_STANDINGS("IOS_GAMETIME_LEAGUE_STANDINGS"),
            IOS_GAMETIME_MATCHUP_TAB("IOS_GAMETIME_MATCHUP_TAB"),
            IOS_GAMETIME_MATCH_HOME("IOS_GAMETIME_MATCH_HOME"),
            IOS_GAMETIME_MATCH_STATS("IOS_GAMETIME_MATCH_STATS"),
            IOS_GAMETIME_NEW_MATCHUP("IOS_GAMETIME_NEW_MATCHUP"),
            IOS_GAMETIME_SCORES("IOS_GAMETIME_SCORES"),
            IOS_GAMETIME_TEAM_SCHEDULE("IOS_GAMETIME_TEAM_SCHEDULE"),
            IOS_GAMETIME_TEAM_STATS("IOS_GAMETIME_TEAM_STATS"),
            IOS_NEARBY_FRIENDS_DASHBOARD("IOS_NEARBY_FRIENDS_DASHBOARD"),
            IOS_NOTIFICATIONS("IOS_NOTIFICATIONS"),
            IOS_NOTIFICATIONS_FRIENDING("IOS_NOTIFICATIONS_FRIENDING"),
            IOS_PAGE("IOS_PAGE"),
            IOS_PAGE_ACTIVITY("IOS_PAGE_ACTIVITY"),
            IOS_PAGE_ADMIN_COMPOSER("IOS_PAGE_ADMIN_COMPOSER"),
            IOS_PAGE_ADMIN_FEED("IOS_PAGE_ADMIN_FEED"),
            IOS_PAGE_ADMIN_OVERVIEW("IOS_PAGE_ADMIN_OVERVIEW"),
            IOS_PAGE_ADS_AFTER_PARTY_AYMT_ACTIVITIES_TAB_ITEM("IOS_PAGE_ADS_AFTER_PARTY_AYMT_ACTIVITIES_TAB_ITEM"),
            IOS_PAGE_ADS_AFTER_PARTY_AYMT_CONTEXT_ITEM("IOS_PAGE_ADS_AFTER_PARTY_AYMT_CONTEXT_ITEM"),
            IOS_PAGE_FRIENDS_CONTENT_CONTEXT_ITEM("IOS_PAGE_FRIENDS_CONTENT_CONTEXT_ITEM"),
            IOS_PAGE_GROUPS_TAB("IOS_PAGE_GROUPS_TAB"),
            IOS_PAGE_HOME("IOS_PAGE_HOME"),
            IOS_PAGE_LAUNCH_POINT_HOME("IOS_PAGE_LAUNCH_POINT_HOME"),
            IOS_PAGE_LIKES_CONTEXT_ITEM("IOS_PAGE_LIKES_CONTEXT_ITEM"),
            IOS_PAGE_PHOTOS_OTHERS("IOS_PAGE_PHOTOS_OTHERS"),
            IOS_PAGE_PHOTOS_TAB("IOS_PAGE_PHOTOS_TAB"),
            IOS_PAGE_POSTS("IOS_PAGE_POSTS"),
            IOS_PAGE_POSTS_TO_PAGE("IOS_PAGE_POSTS_TO_PAGE"),
            IOS_PAGE_SANDBOX("IOS_PAGE_SANDBOX"),
            IOS_PAGE_SINGLE_CARD("IOS_PAGE_SINGLE_CARD"),
            IOS_PMA_PAGE_ADMIN_COMPOSER("IOS_PMA_PAGE_ADMIN_COMPOSER"),
            IOS_POPULAR_AT_PLACE_CONTEXT_ITEM("IOS_POPULAR_AT_PLACE_CONTEXT_ITEM"),
            IOS_REVIEWS_CARD("IOS_REVIEWS_CARD"),
            IOS_SEARCH_KEYWORDS_TOP("IOS_SEARCH_KEYWORDS_TOP"),
            IOS_SEARCH_LOCAL_ECHO("IOS_SEARCH_LOCAL_ECHO"),
            IOS_SEARCH_LOCAL_FEEDSTORY("IOS_SEARCH_LOCAL_FEEDSTORY"),
            IOS_SEARCH_LOCAL_KWSERP_ENTITYMODULE("IOS_SEARCH_LOCAL_KWSERP_ENTITYMODULE"),
            IOS_SEARCH_LOCAL_LOCALSERP("IOS_SEARCH_LOCAL_LOCALSERP"),
            IOS_SEARCH_LOCAL_NEARBY("IOS_SEARCH_LOCAL_NEARBY"),
            IOS_SEARCH_LOCAL_NULL("IOS_SEARCH_LOCAL_NULL"),
            IOS_SEARCH_LOCAL_OTHER("IOS_SEARCH_LOCAL_OTHER"),
            IOS_SEARCH_LOCAL_PLACES_TAB("IOS_SEARCH_LOCAL_PLACES_TAB"),
            IOS_SEARCH_LOCAL_PLACE_TIPS("IOS_SEARCH_LOCAL_PLACE_TIPS"),
            IOS_SEARCH_LOCAL_PLACE_TIPS_CHECKIN("IOS_SEARCH_LOCAL_PLACE_TIPS_CHECKIN"),
            IOS_SEARCH_LOCAL_PLACE_TIPS_LOCATION("IOS_SEARCH_LOCAL_PLACE_TIPS_LOCATION"),
            IOS_SEARCH_LOCAL_PUSH("IOS_SEARCH_LOCAL_PUSH"),
            IOS_SEARCH_LOCAL_RECENT("IOS_SEARCH_LOCAL_RECENT"),
            IOS_SEARCH_LOCAL_SINGLE("IOS_SEARCH_LOCAL_SINGLE"),
            IOS_SEARCH_LOCAL_TODAY("IOS_SEARCH_LOCAL_TODAY"),
            IOS_SEARCH_LOCAL_TYPEAHEAD("IOS_SEARCH_LOCAL_TYPEAHEAD"),
            IOS_SEARCH_RESULTS("IOS_SEARCH_RESULTS"),
            IOS_SHORTWAVE_DEMO("IOS_SHORTWAVE_DEMO"),
            MOBILE_EVENT_DISCOVER_DASHBOARD("MOBILE_EVENT_DISCOVER_DASHBOARD"),
            MOBILE_EVENT_PERMALINK("MOBILE_EVENT_PERMALINK"),
            MOBILE_PAGES_INSIGHTS_MESSAGES("MOBILE_PAGES_INSIGHTS_MESSAGES"),
            MOBILE_PAGES_INSIGHTS_OVERVIEW("MOBILE_PAGES_INSIGHTS_OVERVIEW"),
            MOBILE_PAGE_ACTIVITY("MOBILE_PAGE_ACTIVITY"),
            MOBILE_PAGE_FRIENDS_CONTENT_CONTEXT_ITEM("MOBILE_PAGE_FRIENDS_CONTENT_CONTEXT_ITEM"),
            MOBILE_PAGE_GROUPS_TAB("MOBILE_PAGE_GROUPS_TAB"),
            MOBILE_PAGE_HOME("MOBILE_PAGE_HOME"),
            MOBILE_PAGE_LIKES_CONTEXT_ITEM("MOBILE_PAGE_LIKES_CONTEXT_ITEM"),
            MOBILE_PAGE_PHOTOS_OTHERS("MOBILE_PAGE_PHOTOS_OTHERS"),
            MOBILE_PAGE_PHOTOS_TAB("MOBILE_PAGE_PHOTOS_TAB"),
            MOBILE_PAGE_POSTS("MOBILE_PAGE_POSTS"),
            MOBILE_PAGE_POSTS_TO_PAGE("MOBILE_PAGE_POSTS_TO_PAGE"),
            MOBILE_PAGE_SANDBOX("MOBILE_PAGE_SANDBOX"),
            MOBILE_PAGE_SINGLE_CARD("MOBILE_PAGE_SINGLE_CARD"),
            MOBILE_POPULAR_AT_PLACE_CONTEXT_ITEM("MOBILE_POPULAR_AT_PLACE_CONTEXT_ITEM"),
            MOBILE_SEARCH_KEYWORDS_TOP("MOBILE_SEARCH_KEYWORDS_TOP"),
            MOBILE_TODAY("MOBILE_TODAY"),
            MSITE_PAGE_ADMIN_COMPOSER("MSITE_PAGE_ADMIN_COMPOSER"),
            MTOUCH_SEARCH_LOCAL_ECHO("MTOUCH_SEARCH_LOCAL_ECHO"),
            MTOUCH_SEARCH_LOCAL_FEEDSTORY("MTOUCH_SEARCH_LOCAL_FEEDSTORY"),
            MTOUCH_SEARCH_LOCAL_KWSERP_ENTITYMODULE("MTOUCH_SEARCH_LOCAL_KWSERP_ENTITYMODULE"),
            MTOUCH_SEARCH_LOCAL_LOCALSERP("MTOUCH_SEARCH_LOCAL_LOCALSERP"),
            MTOUCH_SEARCH_LOCAL_NEARBY("MTOUCH_SEARCH_LOCAL_NEARBY"),
            MTOUCH_SEARCH_LOCAL_OTHER("MTOUCH_SEARCH_LOCAL_OTHER"),
            MTOUCH_SEARCH_LOCAL_PLACES_TAB("MTOUCH_SEARCH_LOCAL_PLACES_TAB"),
            MTOUCH_SEARCH_LOCAL_PUSH("MTOUCH_SEARCH_LOCAL_PUSH"),
            MTOUCH_SEARCH_LOCAL_RECENT("MTOUCH_SEARCH_LOCAL_RECENT"),
            MTOUCH_SEARCH_LOCAL_SINGLE("MTOUCH_SEARCH_LOCAL_SINGLE"),
            MTOUCH_SEARCH_LOCAL_TODAY("MTOUCH_SEARCH_LOCAL_TODAY"),
            MTOUCH_SEARCH_LOCAL_TYPEAHEAD("MTOUCH_SEARCH_LOCAL_TYPEAHEAD"),
            VIDEO_HOME("VIDEO_HOME"),
            WWW_EVENTS_PERMALINK("WWW_EVENTS_PERMALINK"),
            WWW_GAMETIME_LEAGUE_PAGE("WWW_GAMETIME_LEAGUE_PAGE"),
            WWW_PAGES_HOME("WWW_PAGES_HOME"),
            WWW_PAGES_INSIGHTS_MESSAGES("WWW_PAGES_INSIGHTS_MESSAGES"),
            WWW_PAGES_INSIGHTS_OVERVIEW("WWW_PAGES_INSIGHTS_OVERVIEW"),
            WWW_PAGE_REACTION_SANDBOX("WWW_PAGE_REACTION_SANDBOX"),
            WWW_SEARCH_LOCAL_ECHO("WWW_SEARCH_LOCAL_ECHO"),
            WWW_SEARCH_LOCAL_FEEDSTORY("WWW_SEARCH_LOCAL_FEEDSTORY"),
            WWW_SEARCH_LOCAL_KWSERP_ENTITYMODULE("WWW_SEARCH_LOCAL_KWSERP_ENTITYMODULE"),
            WWW_SEARCH_LOCAL_LOCALSERP("WWW_SEARCH_LOCAL_LOCALSERP"),
            WWW_SEARCH_LOCAL_NEARBY("WWW_SEARCH_LOCAL_NEARBY"),
            WWW_SEARCH_LOCAL_OTHER("WWW_SEARCH_LOCAL_OTHER"),
            WWW_SEARCH_LOCAL_PLACES_TAB("WWW_SEARCH_LOCAL_PLACES_TAB"),
            WWW_SEARCH_LOCAL_PUSH("WWW_SEARCH_LOCAL_PUSH"),
            WWW_SEARCH_LOCAL_RECENT("WWW_SEARCH_LOCAL_RECENT"),
            WWW_SEARCH_LOCAL_SINGLE("WWW_SEARCH_LOCAL_SINGLE"),
            WWW_SEARCH_LOCAL_TODAY("WWW_SEARCH_LOCAL_TODAY"),
            WWW_SEARCH_LOCAL_TYPEAHEAD("WWW_SEARCH_LOCAL_TYPEAHEAD"),
            ANDROID_AFTER_PARTY_COMPOSER("ANDROID_AFTER_PARTY_COMPOSER"),
            ANDROID_APP_INSTALL("ANDROID_APP_INSTALL"),
            ANDROID_CITY_GUIDE("ANDROID_CITY_GUIDE"),
            ANDROID_COMPOSER("ANDROID_COMPOSER"),
            ANDROID_EVENTS_DASHBOARD_COMPOSER("ANDROID_EVENTS_DASHBOARD_COMPOSER"),
            ANDROID_EXTERNAL_COMPOSER("ANDROID_EXTERNAL_COMPOSER"),
            ANDROID_FEED_COMPOSER("ANDROID_FEED_COMPOSER"),
            ANDROID_GPS_LOCATION_SUGGESTION("ANDROID_GPS_LOCATION_SUGGESTION"),
            ANDROID_GRAVITY_SUGGESTION("ANDROID_GRAVITY_SUGGESTION"),
            ANDROID_GROUP_COMPOSER("ANDROID_GROUP_COMPOSER"),
            ANDROID_LOCATION_FREE_PLACE_TIPS_SUGGESTION("ANDROID_LOCATION_FREE_PLACE_TIPS_SUGGESTION"),
            ANDROID_NEIGHBORHOOD_FEED("ANDROID_NEIGHBORHOOD_FEED"),
            ANDROID_NEIGHBORHOOD_FEED_INLINE("ANDROID_NEIGHBORHOOD_FEED_INLINE"),
            ANDROID_PAGE_COMPOSER("ANDROID_PAGE_COMPOSER"),
            ANDROID_PLACE_TIPS_EXPLORER("ANDROID_PLACE_TIPS_EXPLORER"),
            ANDROID_PLATFORM_COMPOSER("ANDROID_PLATFORM_COMPOSER"),
            ANDROID_PMA_OVERVIEW("ANDROID_PMA_OVERVIEW"),
            ANDROID_PUSH_NOTIFICATION_LANDING("ANDROID_PUSH_NOTIFICATION_LANDING"),
            ANDROID_RAGE_SHAKE_PLACE_TIPS("ANDROID_RAGE_SHAKE_PLACE_TIPS"),
            ANDROID_SEARCH_LOCAL("ANDROID_SEARCH_LOCAL"),
            ANDROID_SEARCH_LOCAL_FROMSET("ANDROID_SEARCH_LOCAL_FROMSET"),
            ANDROID_SEARCH_PLACE_TIPS("ANDROID_SEARCH_PLACE_TIPS"),
            ANDROID_TIMELINE_COMPOSER("ANDROID_TIMELINE_COMPOSER"),
            ANDROID_TRENDING_PLACE_TIPS("ANDROID_TRENDING_PLACE_TIPS"),
            ANDROID_VIDEO_COMPOSER("ANDROID_VIDEO_COMPOSER"),
            ASYNC_UNIT_PROFILER("ASYNC_UNIT_PROFILER"),
            DIRECT_GRAPHQL_NODE_LOAD("DIRECT_GRAPHQL_NODE_LOAD"),
            IOSRN_SEARCH_LOCAL("IOSRN_SEARCH_LOCAL"),
            IOS_APP_INSTALL("IOS_APP_INSTALL"),
            IOS_CHECKIN_SUGGESTION("IOS_CHECKIN_SUGGESTION"),
            IOS_CITY_GUIDE("IOS_CITY_GUIDE"),
            IOS_COMPOSER("IOS_COMPOSER"),
            IOS_DISCOVERY_SUGGESTION("IOS_DISCOVERY_SUGGESTION"),
            IOS_EVENT_CHECKIN_SUGGESTION("IOS_EVENT_CHECKIN_SUGGESTION"),
            IOS_GAMETIME_PLAYS("IOS_GAMETIME_PLAYS"),
            IOS_GPS_LOCATION_SUGGESTION("IOS_GPS_LOCATION_SUGGESTION"),
            IOS_GRAVITY_SUGGESTION("IOS_GRAVITY_SUGGESTION"),
            IOS_LOCATION_FREE_PLACE_TIPS_SUGGESTION("IOS_LOCATION_FREE_PLACE_TIPS_SUGGESTION"),
            IOS_NEARBY_PLACES_SUGGESTION("IOS_NEARBY_PLACES_SUGGESTION"),
            IOS_NEIGHBORHOOD_FEED("IOS_NEIGHBORHOOD_FEED"),
            IOS_NEIGHBORHOOD_FEED_INLINE("IOS_NEIGHBORHOOD_FEED_INLINE"),
            IOS_NOTIFICATIONS_PARITY("IOS_NOTIFICATIONS_PARITY"),
            IOS_NOW_COMPOSER("IOS_NOW_COMPOSER"),
            IOS_PLACE_FEED_SWITCH_PLACE_TIPS("IOS_PLACE_FEED_SWITCH_PLACE_TIPS"),
            IOS_PLACE_LIST("IOS_PLACE_LIST"),
            IOS_PMA_OVERVIEW("IOS_PMA_OVERVIEW"),
            IOS_PROFILE("IOS_PROFILE"),
            IOS_PUSH_NOTIFICATION_LANDING("IOS_PUSH_NOTIFICATION_LANDING"),
            IOS_RAGE_SHAKE_PLACE_TIPS("IOS_RAGE_SHAKE_PLACE_TIPS"),
            IOS_SEARCH_LOCAL("IOS_SEARCH_LOCAL"),
            IOS_SEARCH_LOCAL_PLACES_SET("IOS_SEARCH_LOCAL_PLACES_SET"),
            IOS_SEARCH_NULL_STATE("IOS_SEARCH_NULL_STATE"),
            IOS_SEARCH_PLACE_TIPS("IOS_SEARCH_PLACE_TIPS"),
            IOS_STORY("IOS_STORY"),
            IOS_STYLE_BROWSER_ACTIONS("IOS_STYLE_BROWSER_ACTIONS"),
            IOS_STYLE_BROWSER_COMPONENTS("IOS_STYLE_BROWSER_COMPONENTS"),
            IOS_STYLE_BROWSER_STORY_ATTACHMENTS("IOS_STYLE_BROWSER_STORY_ATTACHMENTS"),
            IOS_STYLE_BROWSER_STORY_HEADERS("IOS_STYLE_BROWSER_STORY_HEADERS"),
            IOS_TODAY_PLACE_TIPS("IOS_TODAY_PLACE_TIPS"),
            IOS_TRENDING_PLACE_TIPS("IOS_TRENDING_PLACE_TIPS"),
            LOCATION_DARK_TEST("LOCATION_DARK_TEST"),
            MTOUCH_LOCAL_SERP("MTOUCH_LOCAL_SERP"),
            MTOUCH_PAGE_FRIENDS_CONTENT_CONTEXT_ITEM("MTOUCH_PAGE_FRIENDS_CONTENT_CONTEXT_ITEM"),
            MTOUCH_PAGE_HOME("MTOUCH_PAGE_HOME"),
            MTOUCH_PAGE_LIKES_CONTEXT_ITEM("MTOUCH_PAGE_LIKES_CONTEXT_ITEM"),
            MTOUCH_PAGE_SANDBOX("MTOUCH_PAGE_SANDBOX"),
            MTOUCH_PAGE_SINGLE_CARD("MTOUCH_PAGE_SINGLE_CARD"),
            MTOUCH_POPULAR_AT_PLACE_CONTEXT_ITEM("MTOUCH_POPULAR_AT_PLACE_CONTEXT_ITEM"),
            MTOUCH_SEARCH_KEYWORDS_TOP("MTOUCH_SEARCH_KEYWORDS_TOP"),
            MTOUCH_TODAY("MTOUCH_TODAY"),
            WWW_LOCAL_SERP("WWW_LOCAL_SERP"),
            WWW_PAGE_SANDBOX("WWW_PAGE_SANDBOX");
            
            protected final String serverValue;

            private Surface(String str) {
                this.serverValue = str;
            }

            public final String toString() {
                return this.serverValue;
            }

            public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.b(this.serverValue);
            }

            public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
                throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
            }
        }
    }
}
