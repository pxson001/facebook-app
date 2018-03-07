package com.facebook.graphql.querybuilder.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: ridge_widget */
public enum ScaleInputPixelRatio implements JsonSerializable {
    NUMBER_1("1"),
    NUMBER_1_5("1.5"),
    NUMBER_2("2"),
    NUMBER_3("3"),
    NUMBER_4("4");
    
    protected final String serverValue;

    private ScaleInputPixelRatio(String str) {
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
