package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: profile_connect */
public final class MessengerCommerceUserControlActionInputData extends GraphQlMutationCallInput {

    /* compiled from: profile_connect */
    public enum UserAction implements JsonSerializable {
        BLOCK_PROMOTION("block_promotion"),
        UNBLOCK_PROMOTION("unblock_promotion"),
        LINK("link"),
        UNLINK("unlink");
        
        protected final String serverValue;

        private UserAction(String str) {
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

    public final MessengerCommerceUserControlActionInputData m4459a(UserAction userAction) {
        a("user_action", userAction);
        return this;
    }

    public final MessengerCommerceUserControlActionInputData m4460a(String str) {
        a("page_id", str);
        return this;
    }
}
