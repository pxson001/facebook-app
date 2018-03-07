package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: pm */
public final class ThrowbackSettingsEditInputData extends GraphQlMutationCallInput {

    /* compiled from: pm */
    public enum SubscriptionStatus implements JsonSerializable {
        SUBSCRIBED_ALL("SUBSCRIBED_ALL"),
        UNSUBSCRIBED("UNSUBSCRIBED"),
        SUBSCRIBED_HIGHLIGHTS("SUBSCRIBED_HIGHLIGHTS");
        
        protected final String serverValue;

        private SubscriptionStatus(String str) {
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
