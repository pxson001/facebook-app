package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: pymlWithLargeImageTitle */
public enum ForNuxInputNuxKey implements JsonSerializable {
    MESSAGE_BUTTON_NUX("MESSAGE_BUTTON_NUX"),
    SAVE_BUTTON_NUX_DEPRECATED("SAVE_BUTTON_NUX_DEPRECATED"),
    SAVE_ACTIONBAR_BUTTON_NUX("SAVE_ACTIONBAR_BUTTON_NUX"),
    SAVE_OVERLAY_BUTTON_NUX("SAVE_OVERLAY_BUTTON_NUX");
    
    protected final String serverValue;

    private ForNuxInputNuxKey(String str) {
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
