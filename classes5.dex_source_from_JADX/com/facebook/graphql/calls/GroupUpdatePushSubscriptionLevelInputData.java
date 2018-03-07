package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: prompt */
public final class GroupUpdatePushSubscriptionLevelInputData extends GraphQlMutationCallInput {

    /* compiled from: prompt */
    public enum Setting implements JsonSerializable {
        OFF("OFF"),
        ON("ON"),
        DEPRECATED_ALL_POSTS("DEPRECATED_ALL_POSTS"),
        DEPRECATED_ALL_ACTIVITY("DEPRECATED_ALL_ACTIVITY"),
        HIGHLIGHTS("HIGHLIGHTS");
        
        protected final String serverValue;

        private Setting(String str) {
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
