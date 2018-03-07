package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: related_groups */
public final class AymtLogEventInputData extends GraphQlMutationCallInput {

    /* compiled from: related_groups */
    public enum EventType implements JsonSerializable {
        ELIGIBILITY("ELIGIBILITY"),
        INVALIDATED("INVALIDATED"),
        IMPRESSION("IMPRESSION"),
        CLICK("CLICK"),
        XOUT("XOUT"),
        CONVERSION("CONVERSION"),
        DELIVERY("DELIVERY"),
        TOUR_COMPLETE("TOUR_COMPLETE");
        
        protected final String serverValue;

        private EventType(String str) {
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

    public final AymtLogEventInputData m4310a(String str) {
        a("channel_id", str);
        return this;
    }

    public final AymtLogEventInputData m4309a(EventType eventType) {
        a("event_type", eventType);
        return this;
    }

    public final AymtLogEventInputData m4311b(String str) {
        a("tip_id", str);
        return this;
    }
}
