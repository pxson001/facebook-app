package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: quicker */
public final class EventSuggestionTakeNegativeActionInputData extends GraphQlMutationCallInput {

    /* compiled from: quicker */
    public final class Context extends GraphQlCallInput {

        /* compiled from: quicker */
        public final class EventActionHistory extends GraphQlCallInput {
        }
    }

    /* compiled from: quicker */
    public enum NegativeActionType implements JsonSerializable {
        HIDE("HIDE"),
        REPORT("REPORT");
        
        protected final String serverValue;

        private NegativeActionType(String str) {
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
