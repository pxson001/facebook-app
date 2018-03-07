package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: queueCapture while  */
public final class EventUpdateNotificationSubscriptionLevelInputData extends GraphQlMutationCallInput {

    /* compiled from: queueCapture while  */
    public enum Level implements JsonSerializable {
        ALL("ALL"),
        MOST_IMPORTANT("MOST_IMPORTANT"),
        HOST_ONLY("HOST_ONLY"),
        UNSUBSCRIBED("UNSUBSCRIBED");
        
        protected final String serverValue;

        private Level(String str) {
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
