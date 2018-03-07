package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: pymk_timeline_chain */
public final class FriendRequestDeleteInputData extends GraphQlMutationCallInput {

    /* compiled from: pymk_timeline_chain */
    public enum Source implements JsonSerializable {
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
        API_ADD("api_add"),
        AUTOFRIEND_PARENT_KID("autofriend_parent_kid"),
        CONTACTS_PEOPLE("contacts_people"),
        DASH("dash"),
        EDIT_FRIENDS("edit_friends"),
        EMAIL_AC("email_ac"),
        ENTITY_CARDS("entity_cards"),
        FEED_FRIENDABLE_HEADER("feed_friendable_header"),
        FRIENDS_DASH("friends_dash"),
        JEWEL("jewel"),
        M_FRIENDS("m_friends"),
        M_FRIEND_REQUESTS("m_friend_requests"),
        M_HOME("m_home"),
        M_JEWEL("m_jewel"),
        NEARBY_FRIENDS("nearby_friends"),
        NETEGO("netego"),
        PROFILEPHP("/profile.php"),
        PROFILE_BROWSER("profile_browser"),
        PROFILE_BROWSER_EVENTS("profile_browser_events"),
        PROFILE_CONN_REMOVE("profile_conn_remove"),
        PYMK_FEED("pymk_feed"),
        QR_CODE("qr_code"),
        REJECT_ALL_SCRIPT("reject_all_script"),
        REG("reg"),
        RELATIONSHIP_CONFIRM("relationship_confirm"),
        REQSPHP("/reqs.php"),
        REQS_BULK("reqs_bulk"),
        REQUESTS_MAIN_PAGE("requests_main_page"),
        SEARCH("search"),
        SMS("sms"),
        SOCIAL_REPORT("social_report"),
        STALE_MODAL("stale_modal"),
        TEST("test"),
        T_JEWEL("t_jewel"),
        T_PROFILE("t_profile"),
        WELCOME_DASH("welcome_dash"),
        GETTINGSTARTEDPHP("/gettingstarted.php"),
        WIZARD_SEARCH("wizard_search"),
        M_FRIEND_SUGGESTIONS("m_friend_suggestions"),
        M_NORMALIZED_REQUESTS("m_normalized_requests"),
        RU_REQ_PROMO("ru_req_promo"),
        M_FIND_FRIENDS("m_find_friends"),
        M_PENDING_REQUESTS_PROMO("m_pending_requests_promo"),
        REMINDER_BOX("reminder_box"),
        FRIENDS_TAB("friends_tab"),
        FRIENDS_CENTER_FRIENDS("friends_center_friends"),
        FRIENDS_CENTER_REQUESTS("friends_center_requests"),
        FRIENDS_CENTER_SEARCH("friends_center_search"),
        FRIENDING_CARD("friending_card"),
        FRIENDING_RADAR("friending_radar"),
        QUICK_PROMOTION("quick_promotion"),
        FRIEND_LIST_PROFILE("friend_list_profile"),
        EXPIRING_REQUESTS_SCRIPT("expiring_requests_script"),
        MEMORIAL_CONTACT_TOOLS("memorial_contact_tools"),
        CONTACT_IMPORTER("contact_importer"),
        UNFRIEND_TOOL("unfriend_tool"),
        FOLLOW_MIGRATION_FLOW("follow_migration_flow"),
        NETEGO_FRIEND_REQUESTS("netego_friend_requests");
        
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
}
