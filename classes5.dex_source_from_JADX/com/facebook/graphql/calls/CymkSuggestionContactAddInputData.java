package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: reaction_attachment */
public final class CymkSuggestionContactAddInputData extends GraphQlMutationCallInput {

    /* compiled from: reaction_attachment */
    public enum SuggestionSurface implements JsonSerializable {
        ONBOARDING("ONBOARDING"),
        PEOPLE_TAB("PEOPLE_TAB");
        
        protected final String serverValue;

        private SuggestionSurface(String str) {
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
