package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: privacy_option */
public final class PageCallToActionUpdateInputData extends GraphQlMutationCallInput {

    /* compiled from: privacy_option */
    public enum CtaType implements JsonSerializable {
        NONE("NONE"),
        BOOK_NOW("BOOK_NOW"),
        MAKE_RESERVATION("MAKE_RESERVATION"),
        CALL_NOW("CALL_NOW"),
        CHARITY_DONATE("CHARITY_DONATE"),
        CONTACT_US("CONTACT_US"),
        DONATE_NOW("DONATE_NOW"),
        MESSAGE("MESSAGE"),
        OPEN_APP("OPEN_APP"),
        PLAY_NOW("PLAY_NOW"),
        SHOP_NOW("SHOP_NOW"),
        SIGN_UP("SIGN_UP"),
        WATCH_NOW("WATCH_NOW"),
        GET_OFFER("GET_OFFER"),
        GET_OFFER_VIEW("GET_OFFER_VIEW"),
        REQUEST_QUOTE("REQUEST_QUOTE"),
        BOOK_APPOINTMENT("BOOK_APPOINTMENT"),
        LISTEN("LISTEN"),
        EMAIL("EMAIL"),
        LEARN_MORE("LEARN_MORE");
        
        protected final String serverValue;

        private CtaType(String str) {
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

    /* compiled from: privacy_option */
    public final class FieldsData extends GraphQlCallInput {
    }

    /* compiled from: privacy_option */
    public enum Source implements JsonSerializable {
        NONE("NONE"),
        MOBILE_PAGE_PRESENCE_CALL_TO_ACTION("MOBILE_PAGE_PRESENCE_CALL_TO_ACTION"),
        COVER_PHOTO_SURFACE("COVER_PHOTO_SURFACE"),
        HOVER_CARD_SURFACE("HOVER_CARD_SURFACE"),
        PAGE_PLUGIN_SURFACE("PAGE_PLUGIN_SURFACE"),
        ADMIN_MENU_TEST_LINK("ADMIN_MENU_TEST_LINK"),
        PAGE_PRESENCE_LHS_CARD("PAGE_PRESENCE_LHS_CARD"),
        SEARCH_ENTITY_CARD("SEARCH_ENTITY_CARD"),
        PROSERVICES_SEARCH_ENTITY_CARD("PROSERVICES_SEARCH_ENTITY_CARD"),
        FEED_STORY("FEED_STORY"),
        FEED_STORY_SEARCH("FEED_STORY_SEARCH"),
        PAGES_ACTIONS_UNIT_SURFACE("PAGES_ACTIONS_UNIT_SURFACE"),
        PAGES_SERVICES_SURFACE("PAGES_SERVICES_SURFACE"),
        CTA_HOVER_CARD_SURFACE("CTA_HOVER_CARD_SURFACE");
        
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
