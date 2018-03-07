package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: press to start searching */
public final class ProfileUpdateSecondarySubscribeStatusInputData extends GraphQlMutationCallInput {

    /* compiled from: press to start searching */
    public enum Location implements JsonSerializable {
        UNDEFINED("UNDEFINED"),
        PROFILE("PROFILE"),
        LINK("LINK"),
        FOLLOWER_LIST("FOLLOWER_LIST"),
        FOLLOWEE_LIST("FOLLOWEE_LIST"),
        HOVERCARD("HOVERCARD"),
        PYSF_NETEGO("PYSF_NETEGO"),
        PYSF_SEE_ALL("PYSF_SEE_ALL"),
        FEED_X_MENU("FEED_X_MENU"),
        HP_MEGAPHONE("HP_MEGAPHONE"),
        TAB_PROMPT("TAB_PROMPT"),
        RIGHT_COL_UNIT("RIGHT_COL_UNIT"),
        SETTINGS_DIALOG("SETTINGS_DIALOG"),
        HOVER_MENU("HOVER_MENU"),
        STORY_LINK("STORY_LINK"),
        STORY_ATTACHMENT("STORY_ATTACHMENT"),
        UNDO_LINK("UNDO_LINK"),
        STORY_OPTIN("STORY_OPTIN"),
        M_SITE("M_SITE"),
        MARKETING("MARKETING"),
        FEED_X_UNSUBSCRIBE("FEED_X_UNSUBSCRIBE"),
        TICKER_FLYOUT("TICKER_FLYOUT"),
        PROFILE_BROWSER("PROFILE_BROWSER"),
        FEED_X_UNDO("FEED_X_UNDO"),
        BROWSE("BROWSE"),
        FEED_X_INLINE("FEED_X_INLINE"),
        SEARCH_MEGAPHONE("SEARCH_MEGAPHONE"),
        PPS_SEARCH("PPS_SEARCH"),
        LOGGED_OUT_PROFILE("LOGGED_OUT_PROFILE"),
        SOCIAL_WIDGET("SOCIAL_WIDGET"),
        PERMALINK("PERMALINK"),
        SUBSCRIPTION_FEED("SUBSCRIPTION_FEED"),
        FOLLOW_PLUGIN("FOLLOW_PLUGIN"),
        TIMELINE_ESCAPE_HATCH("TIMELINE_ESCAPE_HATCH"),
        FRIEND_MUTATOR_HOOK("FRIEND_MUTATOR_HOOK"),
        UNIT_TEST("UNIT_TEST"),
        TEST_FOLLOW_TOOL("TEST_FOLLOW_TOOL"),
        REPORT_BLOCK_DIALOG("REPORT_BLOCK_DIALOG"),
        FRIEND_LIST_MUTATOR("FRIEND_LIST_MUTATOR"),
        SELF_OVER_REQUEST_LIMIT("SELF_OVER_REQUEST_LIMIT"),
        OTHER_OVER_REQUEST_LIMIT("OTHER_OVER_REQUEST_LIMIT"),
        SELF_OVER_FRIEND_LIMIT("SELF_OVER_FRIEND_LIMIT"),
        OTHER_OVER_FRIEND_LIMIT("OTHER_OVER_FRIEND_LIMIT"),
        LIST_PROFILE_BROWSER("LIST_PROFILE_BROWSER"),
        SUBSCRIBERS_SETTINGS("SUBSCRIBERS_SETTINGS"),
        FRIEND_LIST_FLYOUT("FRIEND_LIST_FLYOUT"),
        FEATURED_ADMIN("FEATURED_ADMIN"),
        INTEREST_LIST_FLYOUT("INTEREST_LIST_FLYOUT"),
        PHOTO("PHOTO"),
        PARENT_OPTED_KID_OUT("PARENT_OPTED_KID_OUT"),
        PAGE_FAN_MUTATOR_HOOK("PAGE_FAN_MUTATOR_HOOK"),
        CONTACT_CARD("CONTACT_CARD"),
        GROUP_JOIN("GROUP_JOIN"),
        MOBILE_SUBSCRIBER_SETTINGS("MOBILE_SUBSCRIBER_SETTINGS"),
        MANY_REQS_OPTIN("MANY_REQS_OPTIN"),
        PAGE_TIMELINE_TIP("PAGE_TIMELINE_TIP"),
        NEWSSTAND_SUBSECTION("NEWSSTAND_SUBSECTION"),
        NEWSSTAND_SETTINGS("NEWSSTAND_SETTINGS"),
        API("API"),
        ADS("ADS"),
        MOBILE_REPORT_AFRO("MOBILE_REPORT_AFRO"),
        APP_TOS_AUTO_FOLLOW("APP_TOS_AUTO_FOLLOW"),
        BLOCK_CONFIRMATION_DIALOG("BLOCK_CONFIRMATION_DIALOG"),
        WEB_SEARCH("WEB_SEARCH"),
        PUBCONTENT_PYSF_NETEGO("PUBCONTENT_PYSF_NETEGO"),
        SUGGESTION_ON_FOLLOWING("SUGGESTION_ON_FOLLOWING"),
        KEYWORD_SEARCH("KEYWORD_SEARCH"),
        SUPPORT_DASHBOARD("SUPPORT_DASHBOARD"),
        EMBED("EMBED"),
        LITESTAND("LITESTAND"),
        AFRO("AFRO"),
        PROFILE_CHAINING("PROFILE_CHAINING"),
        GROUP("GROUP"),
        PAGE_FAN("PAGE_FAN"),
        FRIENDING("FRIENDING"),
        UNCONNECTED_SUBSTORY("UNCONNECTED_SUBSTORY"),
        ORGANIC_PAGEPOST_FOLLOWING_BUTTON("ORGANIC_PAGEPOST_FOLLOWING_BUTTON"),
        TIMELINE_FANNED_PAGES_SECTION("TIMELINE_FANNED_PAGES_SECTION"),
        FEED_CURATION_TOOL("FEED_CURATION_TOOL"),
        CONNECTIONS_CONTACTS("CONNECTIONS_CONTACTS"),
        M_SITE_TIMELINE("M_SITE_TIMELINE"),
        FILTER_ROLLOUT("FILTER_ROLLOUT"),
        GEAR_MENU("GEAR_MENU"),
        M_SITE_FRIENDLIST("M_SITE_FRIENDLIST"),
        PAGE_MIGRATION("PAGE_MIGRATION"),
        M_SITE_GROUP("M_SITE_GROUP"),
        FEED_SETTINGS("FEED_SETTINGS"),
        CONTACTS_PEOPLE("CONTACTS_PEOPLE"),
        TIMELINE_COLLECTION("TIMELINE_COLLECTION"),
        ENTITY_CARDS("ENTITY_CARDS"),
        WORK_ACCOUNT_MIGRATION("WORK_ACCOUNT_MIGRATION"),
        FRIEND_REQUEST("FRIEND_REQUEST"),
        TABLET_PROFILE("TABLET_PROFILE"),
        TABLET_STORY_MENU("TABLET_STORY_MENU"),
        IPAD_SIDEFEED_GROUP_ABOUT("IPAD_SIDEFEED_GROUP_ABOUT"),
        PYSF_NETEGO_FEED("PYSF_NETEGO_FEED"),
        PYSF_NETEGO_M_SITE_FEED("PYSF_NETEGO_M_SITE_FEED"),
        FEED_AWESOMIZER_FOLLOW_CARD("FEED_AWESOMIZER_FOLLOW_CARD"),
        FEED_AWESOMIZER_SEE_FIRST_CARD("FEED_AWESOMIZER_SEE_FIRST_CARD"),
        SEE_FIRST_WWW_MEGAPHONE("SEE_FIRST_WWW_MEGAPHONE"),
        PROFILE_FRIENDS_PAGE("PROFILE_FRIENDS_PAGE"),
        FEED_SHARE_LINK("FEED_SHARE_LINK"),
        UNFRIEND_TOOL("UNFRIEND_TOOL"),
        FOLLOW_MIGRATION_FLOW("FOLLOW_MIGRATION_FLOW"),
        RANKED_COMMENTS_MIGRATION("RANKED_COMMENTS_MIGRATION"),
        PAGE_LAUNCH_POINT("PAGE_LAUNCH_POINT"),
        EVENT_PERMALINK("EVENT_PERMALINK"),
        PAGE_GET_NOTIF_DIALOG("PAGE_GET_NOTIF_DIALOG"),
        BREAKUP_SEE_LESS("BREAKUP_SEE_LESS"),
        FEED_UNCONNECTED_STORY("FEED_UNCONNECTED_STORY"),
        FRIENDS_AT_WORK("FRIENDS_AT_WORK"),
        LIKER_LIST("LIKER_LIST"),
        VIDEO_CHANNEL_FOLLOW("VIDEO_CHANNEL_FOLLOW"),
        VIDEO_HOME("VIDEO_HOME"),
        LIVE_VIDEO_VIEWER("LIVE_VIDEO_VIEWER"),
        LIVE_VIDEO_ENDSCREEN("LIVE_VIDEO_ENDSCREEN"),
        VIDEO_CREATOR_SPACE("VIDEO_CREATOR_SPACE"),
        VOD_FULLSCREEN("VOD_FULLSCREEN"),
        VIDEO_CHANNEL("VIDEO_CHANNEL"),
        VIDEO_CHANNEL_SIDEPANE("VIDEO_CHANNEL_SIDEPANE"),
        CONSTITUENT_TITLE_UPSELL("CONSTITUENT_TITLE_UPSELL"),
        PAGE_BAN("PAGE_BAN"),
        BLOCK_PAGE("BLOCK_PAGE"),
        PRIVACY_CHECKUP("PRIVACY_CHECKUP"),
        PUBLIC_POST_ROLLOUT("PUBLIC_POST_ROLLOUT");
        
        protected final String serverValue;

        private Location(String str) {
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

    /* compiled from: press to start searching */
    public enum NewStatus implements JsonSerializable {
        REGULAR_FOLLOW("REGULAR_FOLLOW"),
        RECAP("RECAP"),
        SEE_FIRST("SEE_FIRST");
        
        protected final String serverValue;

        private NewStatus(String str) {
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
