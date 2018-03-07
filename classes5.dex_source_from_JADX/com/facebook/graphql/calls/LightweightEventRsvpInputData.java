package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: profilebrowser_blocked */
public final class LightweightEventRsvpInputData extends GraphQlMutationCallInput {

    /* compiled from: profilebrowser_blocked */
    public final class Context extends GraphQlCallInput {

        /* compiled from: profilebrowser_blocked */
        public final class EventActionHistory extends GraphQlCallInput {
            public final EventActionHistory m4453a(String str) {
                a("surface", str);
                return this;
            }

            public final EventActionHistory m4454b(String str) {
                a("mechanism", str);
                return this;
            }
        }
    }

    /* compiled from: profilebrowser_blocked */
    public enum GuestListState implements JsonSerializable {
        GOING("GOING"),
        INVITED("INVITED"),
        DECLINED("DECLINED");
        
        protected final String serverValue;

        private GuestListState(String str) {
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
