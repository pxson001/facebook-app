package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: reject_all_script */
public final class BackstageUserUpdateAudienceModeInputData extends GraphQlMutationCallInput {

    /* compiled from: reject_all_script */
    public enum BackstageAudienceMode implements JsonSerializable {
        WHITELIST("whitelist"),
        BLACKLIST("blacklist");
        
        protected final String serverValue;

        private BackstageAudienceMode(String str) {
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
