package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: popular_at_remove_item */
public final class SetFriendRequestsAudienceInputData extends GraphQlMutationCallInput {

    /* compiled from: popular_at_remove_item */
    public enum Audience implements JsonSerializable {
        EVERYONE("EVERYONE"),
        FRIENDS_OF_FRIENDS("FRIENDS_OF_FRIENDS");
        
        protected final String serverValue;

        private Audience(String str) {
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
