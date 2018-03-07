package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: rating_count */
public enum DeviceInputDevice implements JsonSerializable {
    IPHONE("IPHONE"),
    IPAD("IPAD"),
    ANDROID("ANDROID"),
    DESKTOP("DESKTOP"),
    IPHONE_IMMERSIVE("IPHONE_IMMERSIVE"),
    IPAD_IMMERSIVE("IPAD_IMMERSIVE"),
    TOUCH("TOUCH"),
    TIZEN("TIZEN"),
    WINDOWS("WINDOWS"),
    MAC("MAC"),
    FEATURE_PHONE("FEATURE_PHONE"),
    SNAPTU("SNAPTU"),
    FBLITE("FBLITE");
    
    protected final String serverValue;

    private DeviceInputDevice(String str) {
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
