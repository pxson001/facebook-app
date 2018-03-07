package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: promotion_tag */
public final class GroupUpdateSubscriptionLevelInputData extends GraphQlMutationCallInput {

    /* compiled from: promotion_tag */
    public enum Setting implements JsonSerializable {
        ALL_POSTS("ALL_POSTS"),
        FRIEND_POSTS("FRIEND_POSTS"),
        HIGHLIGHTS("HIGHLIGHTS"),
        OFF("OFF");
        
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
