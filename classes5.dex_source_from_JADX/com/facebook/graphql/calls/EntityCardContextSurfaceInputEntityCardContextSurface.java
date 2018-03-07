package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: raters */
public enum EntityCardContextSurfaceInputEntityCardContextSurface implements JsonSerializable {
    ENTITY_CARD("ENTITY_CARD"),
    PAGE("PAGE"),
    PAGE_HEADER("PAGE_HEADER"),
    PAGE_INFO_CARD("PAGE_INFO_CARD"),
    CONTACT_CARD("CONTACT_CARD"),
    WWW("WWW"),
    MOBILE_PAGE_ADMIN_PANEL("MOBILE_PAGE_ADMIN_PANEL"),
    PLACE_TIPS("PLACE_TIPS"),
    HIGHLIGHTS_CARD("HIGHLIGHTS_CARD"),
    STORE_LOCATOR("STORE_LOCATOR");
    
    protected final String serverValue;

    private EntityCardContextSurfaceInputEntityCardContextSurface(String str) {
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
