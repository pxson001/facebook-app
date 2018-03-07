package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.List;

/* compiled from: pymk_sticky_megaphone_ef */
public final class FriendRequestSendInputData extends GraphQlMutationCallInput {

    /* compiled from: pymk_sticky_megaphone_ef */
    public enum PeopleYouMayKnowLocation implements JsonSerializable {
        CTX_NETEGO("ctx_netego"),
        FRIEND_BROWSER("friend_browser"),
        FRIEND_BROWSER_LIST("friend_browser_list"),
        NUX("nux"),
        CONTEXTUAL("contextual"),
        CONTEXTUAL_ALL_SOURCES("contextual_all_sources"),
        AJAXREQSPHP("ajax/reqs.php"),
        EVENTS("events"),
        FEED_STORY("feed_story"),
        FINDFRIENDSINDEXPHP("/find-friends/index.php"),
        FRIENDSINDEXPHP("/friends/index.php"),
        HOMEPHP("/home.php"),
        PYMK_JEWEL("pymk_jewel"),
        PYMK_JEWEL_FIRST_PAGE("pymk_jewel_first_page"),
        M_BASIC_HOME("m_basic_home"),
        M_CHAIN_FRIEND_ACCEPT("m_chain_friend_accept"),
        M_CHAIN_FRIEND_ACCEPT_NOTIF("m_chain_friend_accept_notif"),
        M_CHAIN_FRIEND_REQUEST("m_chain_friend_request"),
        M_CHAIN_FRIEND_REQUEST_PENDING("m_chain_friend_request_pending"),
        M_FRIEND_REQUESTS_PAGE("m_friend_requests_page"),
        M_HOME_WELCOME("m_home_welcome"),
        M_SEARCH("m_search"),
        MEGAPHONE("megaphone"),
        MEGAPHONE_WIDE("megaphone_wide"),
        MOBILE_FEED_ZERO_STATE("mobile_feed_zero_state"),
        MOBILE_JEWEL("mobile_jewel"),
        MOBILE_NOTIFICATIONS_TAB("mobile_notifications_tab"),
        NATIVE_APP_URL_SEGUE("native_app_url_segue"),
        MOBILE_SIDEBAR("mobile_sidebar"),
        MOBILE_TOP_OF_FEED("mobile_top_of_feed"),
        NETEGO("netego"),
        NETEGO_PROFILE("netego_profile"),
        NETEGO_CANVAS("netego_canvas"),
        NETEGO_ALBUM("netego_album"),
        NETEGO_REPLACE("netego_replace"),
        NETEGO_TIMELINE("netego_timeline"),
        NETEGO_TIMELINE_COLLECTIONS("netego_timeline_collections"),
        NUX_MEGAPHONE("nux_megaphone"),
        PROFILE_QUESTION("profile_question"),
        SEARCH("search"),
        SEARCH_RANKING("search_ranking"),
        STICKY_MEGAPHONE("sticky_megaphone"),
        WIZARD("wizard"),
        NEW_ACCOUNT_PYMK_GENERATION("new_account_pymk_generation"),
        EMAIL("email"),
        PYMK_TIMELINE_CHAIN("pymk_timeline_chain"),
        QUICK_PROMOTION("quick_promotion"),
        REQUESTS_PAGE_PYMK("requests_page_pymk"),
        MOBILE_BORED_TOP_OF_FEED("mobile_bored_top_of_feed"),
        MOBILE_IN_FEED("mobile_in_feed"),
        INLINE_FEED("inline_feed"),
        FRIENDS_CENTER("friends_center"),
        FRIENDS_CENTER_REQUESTS("friends_center_requests"),
        TOP_OF_FEED("top_of_feed"),
        EMPTY_FEED("empty_feed"),
        JAPAN_CI_FRIENDS_SUGGESTION("japan_ci_friends_suggestion"),
        CONTACT_SUGGEST_FRIEND("contact_suggest_friend"),
        RHC("rhc"),
        NETEGO_GROUP("netego_group"),
        NETEGO_PERMALINK("netego_permalink"),
        NETEGO_MESSENGER("netego_messenger"),
        NETEGO_NOTE("netego_note"),
        IMMERSIVE("immersive"),
        SELF_PROFILE("self_profile"),
        UNKNOWN("unknown");
        
        protected final String serverValue;

        private PeopleYouMayKnowLocation(String str) {
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

    /* compiled from: pymk_sticky_megaphone_ef */
    public enum Refs implements JsonSerializable {
        UNKNOWN("unknown"),
        NONE("none"),
        HC_FRIEND_BROWSER("hc_friend_browser"),
        HC_FRIENDS_TAB("hc_friends_tab"),
        HC_PROFILE_BROWSER("hc_profile_browser"),
        HC_STREAM("hc_stream"),
        HC_TIMELINE("hc_timeline"),
        HC_UFI("hc_ufi"),
        HC_REMINDER_POKE("hc_reminder_poke"),
        HC_REMINDER_BIRTHDAY("hc_reminder_birthday"),
        HC_EVENT_GUEST("hc_event_guest"),
        HC_UNKNOWN("hc_unknown"),
        HC_NUX_PAGE_SUGGESTION("hc_nux_page_suggestion"),
        API("api"),
        BROWSE_SEARCH("browse_search"),
        CI_PYMK("ci_pymk"),
        FRIEND_FINDER("friend_finder"),
        CONTACTS_PEOPLE("contacts_people"),
        ENTITY_CARD("entity_card"),
        FAMILY_SEARCH("family_search"),
        FB_JEWEL("fb_jewel"),
        FB_LEFT_NAV("fb_left_nav"),
        FFA("ffa"),
        FFL("ffl"),
        FRIENDING_CARD("friending_card"),
        FRIENDING_RADAR("friending_radar"),
        HOVERCARD("hovercard"),
        MFL("mfl"),
        NEARBY_FRIENDS("nearby_friends"),
        NF("nf"),
        NF_FR("nf_fr"),
        PB("pb"),
        PROFILE_SHARE("profile_share"),
        PYMK("pymk"),
        PYMK_FEED("pymk_feed"),
        PYMK_JEWEL("pymk_jewel"),
        PYMK_EMAIL("pymk_email"),
        PYMKS_EMAIL("pymks_email"),
        QR_CODE("qr_code"),
        SEARCH("search"),
        TS("ts"),
        BR_TF("br_tf"),
        BR_RS("br_rs"),
        ST("st"),
        QIP_SOCIAL_AD("qip_social_ad"),
        PB_EVENT("pb_event"),
        PB_FRIENDS("pb_friends"),
        PB_FRIENDS_TL("pb_friends_tl"),
        PB_LIKES("pb_likes"),
        PB_REACTIONS("pb_reactions"),
        PB_SSR("pb_ssr"),
        PB_TFA("pb_tfa"),
        PB_OTHER("pb_other"),
        GRP_MMBR_LIST("grp_mmbr_list"),
        PYSF("pysf"),
        TEST("test"),
        TCK("tck"),
        NM("nm"),
        EVENT_GYMK("event_gymk"),
        SHORTCUT("shortcut"),
        FC_PYMK("fc_pymk"),
        FC_SEARCH("fc_search"),
        UFI("ufi"),
        FEED_SETTINGS("feed_settings"),
        PHOTO("photo"),
        TL_FR_BOX("tl_fr_box"),
        PRFL("prfl"),
        MSGS("msgs"),
        NOTIFS("notifs"),
        CI_FRIENDS_SUGGESTION_NOTIF("ci_friends_suggestion_notif"),
        CONTACT_SUGGEST_FRIEND_NOTIF("contact_suggest_friend_notif"),
        MWF("mwf"),
        M_JEWEL("m_jewel"),
        JEWEL("jewel"),
        WELCOME_DASH("welcome_dash"),
        REQSPHP("/reqs.php"),
        M_NORMALIZED_REQUESTS("m_normalized_requests"),
        FR_TAB("fr_tab"),
        FRIEND_CONFIRMED_NOTIF_EMAIL("friend_confirmed_notif_email"),
        DISCOVERY("discovery"),
        NEWSFEED("newsfeed"),
        PEOPLE_TAB("people_tab"),
        FRIENDING("friending"),
        CONTACT_IMPORTER("contact_importer"),
        QRCODE("qrCode"),
        FRIENDS_NEARBY("friends_nearby"),
        SEARCH_RESULTS_TABS("search_results_tabs"),
        TIMELINE_FRIENDS_LIST("timeline_friends_list"),
        TIMELINE_CONTEXT_ITEM_FRIENDS_LIST("timeline_context_item_friends_list"),
        FRIENDS_LIST_BOOKMARK("friends_list_bookmark"),
        FRIEND_REQUESTS("friend_requests"),
        INVITE("invite");
        
        protected final String serverValue;

        private Refs(String str) {
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

    /* compiled from: pymk_sticky_megaphone_ef */
    public enum Source implements JsonSerializable {
        FRIEND_OTHER("friend_other"),
        FRIEND_INVITATION("friend_invitation"),
        FRIEND_FINDER("friend_finder"),
        WIZARD_CLASSMATES_COWORKERS("wizard_classmates_coworkers"),
        FRIEND_SUGGESTION("friend_suggestion"),
        AIM_IMPORTER("aim_importer"),
        SEARCH("search"),
        PEOPLE_YOU_MAY_KNOW("people_you_may_know"),
        PYMK_SIDESHOW("pymk_sideshow"),
        CLASSMATE_SEARCH("classmate_search"),
        COWORKER_SEARCH("coworker_search"),
        NEWSFEED("newsfeed"),
        HOVERCARD("hovercard"),
        HOVERCARD_PYMK("hovercard_pymk"),
        JAPAN_MOBILE_INVITE("japan_mobile_invite"),
        TWITTER_IMPORTER("twitter_importer"),
        JOB_CONNECT_SEARCH("job_connect_search"),
        WIZARD_IMPORTERS("wizard_importers"),
        FRIEND_BROWSER("friend_browser"),
        PROFILE_BUTTON("profile_button"),
        SGM("sgm"),
        EXTERNAL_CONVERT("external_convert"),
        PAIR_SEARCH("pair_search"),
        MERGE("merge"),
        PROFILE_BROWSER("profile_browser"),
        FAMILY_REQUEST("family_request"),
        FAMILY_SUGGEST("family_suggest"),
        API("api"),
        FRIEND_MSITE("friend_msite"),
        PARENT_KID("parent_kid"),
        PHOTO_TAG("photo_tag"),
        FRIENDSHAKE("friendshake"),
        FRIENDS_BOX("friends_box"),
        BROWSE("browse"),
        COMMENT("comment"),
        GROUP_MEMBERS("group_members"),
        CRISIS("crisis"),
        TICKER("ticker"),
        NETEGO_PYMK("netego_pymk"),
        FEED_PYMK("feed_pymk"),
        FEED_FRIENDABLE_HEADER("feed_friendable_header"),
        PYMK_MEGAPHONE("pymk_megaphone"),
        FRIEND_BROWSER_WD("friend_browser_wd"),
        FRIEND_BROWSER_FF("friend_browser_ff"),
        FRIEND_BROWSER_S("friend_browser_s"),
        ESCAPE_HATCH("escape_hatch"),
        EMAIL("email"),
        TIMELINE_UNIT("timeline_unit"),
        PROFILE_FRIENDS("profile_friends"),
        TIMELINE_FRIENDS_PAGELET("timeline_friends_pagelet"),
        TIMELINE_FRIENDS_COLLECTION("timeline_friends_collection"),
        MY_QR_CODE("my_qr_code"),
        ADDFRIEND("addfriend"),
        SMS("sms"),
        TEST("test"),
        WIZARD_SEARCH("wizard_search"),
        WIZARD_SEARCH_PYMK("wizard_search_pymk"),
        FRIEND_BROWSER_NUX("friend_browser_nux"),
        INTERN_PROFILE("intern_profile"),
        CONTACT_CARD("contact_card"),
        MESSAGE("message"),
        TIMELINE_PYMK("timeline_pymk"),
        TIMELINE_COLLECTIONS_PYMK("timeline_collections_pymk"),
        PROFILE_SHARE("profile_share"),
        PYMK_FRIENDS_TAB("pymk_friends_tab"),
        RECENT_FRIENDSHIPS_MEGAPHONE("recent_friendships_megaphone"),
        REMINDERS("reminders"),
        PYMK_MEGAPHONE_SCALABLE_EF("pymk_megaphone_scalable_ef"),
        PYMK_STICKY_MEGAPHONE_EF("pymk_sticky_megaphone_ef"),
        SEARCH_CHAINED_PYMK("search_chained_pymk"),
        CALL_LOG("call_log"),
        VERTEX("vertex"),
        REQUESTS_PAGE_PYMK("requests_page_pymk"),
        PYMK_EXPERIMENT_MEGAPHONE_EF("pymk_experiment_megaphone_ef"),
        API_CONTACTS_UPLOAD("api_contacts_upload"),
        CI_BKG("ci_bkg"),
        CI_CONTINUOUS("ci_continuous"),
        MEDLEY("medley"),
        CI_SOFTMATCH_PYMK("ci_softmatch_pymk"),
        WEB_SEARCH("web_search"),
        KEYWORD_SEARCH("keyword_search"),
        EVENT_GYMK("event_gymk"),
        FRIEND_CENTER_SEARCH("friend_center_search"),
        CONTACTS_PEOPLE("contacts_people"),
        FRIEND_CENTER_OUTGOING_REQ("friend_center_outgoing_req"),
        SHORTCUT("shortcut"),
        FRIEND_CENTER_FRIENDS("friend_center_friends"),
        FRIEND_CENTER_REQUESTS("friend_center_requests"),
        CI_PYMK("ci_pymk"),
        FRIENDING_CARD("friending_card"),
        DATA_CLEANUP("data_cleanup"),
        PROFILE_BROWSER_EVENTS("profile_browser_events"),
        ENTITY_CARDS("entity_cards"),
        CI_FRIENDS_SUGGESTION("ci_friends_suggestion"),
        FRIENDING_RADAR("friending_radar"),
        FRIEND_LIST_PROFILE("friend_list_profile"),
        NEARBY_FRIENDS("nearby_friends"),
        NETEGO_SUGGEST_GROUP_FRIENDS("netego_suggest_group_friends"),
        DISCOVER_FEED("discover_feed"),
        MEMORIAL_CONTACT_TOOLS("memorial_contact_tools"),
        REQUESTS_JEWEL("requests_jewel"),
        GROUP_MEMBER_LIST("group_member_list"),
        GROUP_COMMERCE("group_commerce"),
        CONTACT_SUGGEST_FRIEND("contact_suggest_friend"),
        NETEGO_FRIEND_REQUESTS("netego_friend_requests"),
        WELCOME_FEED_OUTGOING_UNIT("welcome_feed_outgoing_unit"),
        MERGE_VIA_INVITE("merge_via_invite"),
        INVITE_EXISTING_USER("invite_existing_user");
        
        protected final String serverValue;

        private Source(String str) {
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

    public final FriendRequestSendInputData m4421a(List<String> list) {
        a("friend_requestee_ids", list);
        return this;
    }

    public final FriendRequestSendInputData m4420a(Source source) {
        a("source", source);
        return this;
    }
}
