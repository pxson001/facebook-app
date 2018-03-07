package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: pymlPageBrowserCategory */
public final class FriendRemoveInputData extends GraphQlMutationCallInput {

    /* compiled from: pymlPageBrowserCategory */
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
        PROFILE_GEAR("profile_gear"),
        BUTTON_DROPDOWN("button_dropdown"),
        BD_ACCEPTED_REQUEST("bd_accepted_request"),
        BD_DATA_CLEANUP("bd_data_cleanup"),
        BD_FC_FRIENDS("bd_fc_friends"),
        BD_FC_REQUESTS("bd_fc_requests"),
        BD_FC_SEARCH("bd_fc_search"),
        BD_FC_SUGGESTIONS("bd_fc_suggestions"),
        BD_FRIENDS_TAB("bd_friends_tab"),
        BD_HOVERCARD("bd_hovercard"),
        BD_PROFILE_BROWSER("bd_profile_browser"),
        BD_PROFILE_BUTTON("bd_profile_button"),
        BD_SEARCH("bd_search"),
        SPRING_CLEANING_HOVERCARD("spring_cleaning_hovercard"),
        FEED_HIDE("feed_hide"),
        UNITTEST("unittest"),
        ACTIVITY_LOG("activity_log"),
        FRIENDS_TO_REMOVE("friends_to_remove"),
        PRIVACY_BLOCK("privacy_block"),
        FRIEND_TO_SUBSCRIBER("friend_to_subscriber"),
        SCRIPT_FRIEND_TO_SUBSCRIBER("script_friend_to_subscriber"),
        CHECKPOINT("checkpoint"),
        SOCIAL_REPORT("social_report"),
        TIMELINE_FRIENDS_COLLECTION("timeline_friends_collection"),
        AFRO_UNFRIEND("afro_unfriend"),
        CONTACTS_PEOPLE("contacts_people"),
        PYMK_FEED("pymk_feed"),
        GRAY_ACC("gray_acc"),
        ENTITY_CARDS("entity_cards"),
        FRIENDING_RADAR("friending_radar"),
        FRIEND_LIST_PROFILE("friend_list_profile"),
        NEARBY_FRIENDS("nearby_friends"),
        QR_CODE("qr_code"),
        SUPPORT_DASHBOARD("support_dashboard"),
        T_PROFILE("t_profile"),
        BULK_UNFRIEND_INTERN("bulk_unfriend_intern"),
        BREAKUP_SEE_LESS("breakup_see_less"),
        BREAKUP_RESTRICT("breakup_restrict"),
        M_UNFRIEND_INTERSTITIAL("m_unfriend_interstitial");
        
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
