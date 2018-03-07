package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: profilePictureAsCover */
public final class MessengerGroupChangeThreadJoinableSettingsInputData extends GraphQlMutationCallInput {

    /* compiled from: profilePictureAsCover */
    public enum Mode implements JsonSerializable {
        PRIVATE("PRIVATE"),
        JOINABLE("JOINABLE");
        
        protected final String serverValue;

        private Mode(String str) {
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

    public final MessengerGroupChangeThreadJoinableSettingsInputData m4461a(Mode mode) {
        a("mode", mode);
        return this;
    }
}
