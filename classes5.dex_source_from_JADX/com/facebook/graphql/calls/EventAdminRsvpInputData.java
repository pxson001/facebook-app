package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: rap_select_bug */
public final class EventAdminRsvpInputData extends GraphQlMutationCallInput {

    /* compiled from: rap_select_bug */
    public final class Context extends GraphQlCallInput {

        /* compiled from: rap_select_bug */
        public final class EventActionHistory extends GraphQlCallInput {
            public final EventActionHistory m4364a(String str) {
                a("surface", str);
                return this;
            }
        }
    }

    /* compiled from: rap_select_bug */
    public enum GuestStatus implements JsonSerializable {
        GOING("going"),
        MAYBE("maybe"),
        NOT_GOING("not_going");
        
        protected final String serverValue;

        private GuestStatus(String str) {
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
