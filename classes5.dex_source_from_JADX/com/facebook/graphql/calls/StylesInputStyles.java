package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: politician_pyml */
public enum StylesInputStyles implements JsonSerializable {
    CONTEXT_LIST("CONTEXT_LIST"),
    FRIEND_GRID("FRIEND_GRID"),
    PHOTO_GRID("PHOTO_GRID"),
    PHOTO_SCROLL("PHOTO_SCROLL"),
    PYMK_SCROLL("PYMK_SCROLL"),
    QUESTION_SCROLL("QUESTION_SCROLL"),
    VIDEO_GRID("VIDEO_GRID");
    
    protected final String serverValue;

    private StylesInputStyles(String str) {
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
