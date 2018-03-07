package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: questions */
public final class EventUserBlockInputData extends GraphQlMutationCallInput {

    /* compiled from: questions */
    public enum BlockType implements JsonSerializable {
        INVITE("INVITE");
        
        protected final String serverValue;

        private BlockType(String str) {
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

    /* compiled from: questions */
    public final class Context extends GraphQlCallInput {

        /* compiled from: questions */
        public final class EventActionHistory extends GraphQlCallInput {
            public final EventActionHistory m4413a(String str) {
                a("surface", str);
                return this;
            }
        }
    }
}
