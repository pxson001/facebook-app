package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: region_name */
public enum BidForInputBidFor implements JsonSerializable {
    CLICK("CLICK"),
    IMPRESSION("IMPRESSION"),
    CONVERSION("CONVERSION"),
    MOBILE_APP_INSTALL("MOBILE_APP_INSTALL"),
    LINK_CLICK("LINK_CLICK"),
    OFFSITE_CONVERSION("OFFSITE_CONVERSION"),
    VIDEO_VIEWS("VIDEO_VIEWS"),
    REACH("REACH"),
    POST_ENGAGEMENT("POST_ENGAGEMENT"),
    PAGE_LIKES("PAGE_LIKES");
    
    protected final String serverValue;

    private BidForInputBidFor(String str) {
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
