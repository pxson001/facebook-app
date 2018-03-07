package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: post_promotion_info */
public final class RegionTosRespondInputData extends GraphQlMutationCallInput {

    /* compiled from: post_promotion_info */
    public enum RegionCode implements JsonSerializable {
        GENERAL("GENERAL"),
        ALDRIN("ALDRIN"),
        MOON("MOON"),
        MARS("MARS");
        
        protected final String serverValue;

        private RegionCode(String str) {
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

    /* compiled from: post_promotion_info */
    public enum ResponseAction implements JsonSerializable {
        AGREED("AGREED"),
        AGREED_IMPLICIT("AGREED_IMPLICIT"),
        DENIED("DENIED");
        
        protected final String serverValue;

        private ResponseAction(String str) {
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

    public final RegionTosRespondInputData m4480a(ResponseAction responseAction) {
        a("response_action", responseAction);
        return this;
    }

    public final RegionTosRespondInputData m4479a(RegionCode regionCode) {
        a("region_code", regionCode);
        return this;
    }

    public final RegionTosRespondInputData m4481a(String str) {
        a("response_version", str);
        return this;
    }
}
