package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: privacy_disclaimer */
public final class PageCallToActionViewerSubmissionInputData extends GraphQlMutationCallInput {

    /* compiled from: privacy_disclaimer */
    public final class FieldsData extends GraphQlCallInput {
    }

    /* compiled from: privacy_disclaimer */
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
