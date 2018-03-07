package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: rawMessage */
public final class DeviceAutoplaySettingUpdateInputData extends GraphQlMutationCallInput {

    /* compiled from: rawMessage */
    public enum AutoplaySetting implements JsonSerializable {
        ON("ON"),
        OFF("OFF"),
        WIFI_ONLY("WIFI_ONLY"),
        DEFAULT_AUTOPLAY("DEFAULT_AUTOPLAY");
        
        protected final String serverValue;

        private AutoplaySetting(String str) {
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

    /* compiled from: rawMessage */
    public enum UpdateType implements JsonSerializable {
        MIGRATION("MIGRATION"),
        SETTING_CHANGE("SETTING_CHANGE");
        
        protected final String serverValue;

        private UpdateType(String str) {
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
