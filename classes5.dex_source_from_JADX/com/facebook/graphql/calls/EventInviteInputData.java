package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: radius should be non negative */
public final class EventInviteInputData extends GraphQlMutationCallInput {

    /* compiled from: radius should be non negative */
    public final class Context extends GraphQlCallInput {

        /* compiled from: radius should be non negative */
        public final class EventActionHistory extends GraphQlCallInput {
            public final EventActionHistory m4389a(String str) {
                a("surface", str);
                return this;
            }
        }
    }

    /* compiled from: radius should be non negative */
    public enum InviteNotificationType implements JsonSerializable {
        NORMAL("NORMAL"),
        SUPPRESS_PUSH("SUPPRESS_PUSH");
        
        protected final String serverValue;

        private InviteNotificationType(String str) {
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
