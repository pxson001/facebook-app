package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: promoted_stories */
public final class GyscSuggestionXoutInputData extends GraphQlMutationCallInput {

    /* compiled from: promoted_stories */
    public enum SuggestionType implements JsonSerializable {
        FAMILY("FAMILY"),
        LIFE_EVENT("LIFE_EVENT"),
        TOP_PAGE("TOP_PAGE"),
        WORK("WORK"),
        SCHOOL("SCHOOL"),
        MESSENGER("MESSENGER"),
        PAGE_ADMIN("PAGE_ADMIN"),
        FRIEND_LIST("FRIEND_LIST"),
        GAMES("GAMES"),
        EVENT("EVENT"),
        CLOSE_FRIENDS("CLOSE_FRIENDS");
        
        protected final String serverValue;

        private SuggestionType(String str) {
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
