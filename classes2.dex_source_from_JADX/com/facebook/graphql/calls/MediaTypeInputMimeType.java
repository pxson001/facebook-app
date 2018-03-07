package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: rich_presence */
public enum MediaTypeInputMimeType implements JsonSerializable {
    IMAGEGIF("image/gif"),
    IMAGEWEBP("image/webp"),
    IMAGEJPEG("image/jpeg"),
    IMAGEPNG("image/png"),
    VIDEOXAPNG("video/x-apng"),
    IMAGEXFBA("image/x-fba"),
    IMAGEXAUTO("image/x-auto"),
    IMAGEXBEST("image/x-best"),
    IMAGEXPNG2JPG("image/x-png2jpg");
    
    protected final String serverValue;

    private MediaTypeInputMimeType(String str) {
        this.serverValue = str;
    }

    public final String toString() {
        return this.serverValue;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1123b(this.serverValue);
    }

    public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
    }
}
