package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: places_editor_hours_module */
public final class VideoHomeVisitInputData extends GraphQlMutationCallInput {

    /* compiled from: places_editor_hours_module */
    public enum Event implements JsonSerializable {
        START("START"),
        PAUSE("PAUSE"),
        SAW_DATA("SAW_DATA"),
        RESUME("RESUME"),
        END("END");
        
        protected final String serverValue;

        private Event(String str) {
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
