package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.concurrent.atomic.AtomicReference;

@JacksonStdImpl
/* compiled from: can_viewer_post_photo_to_timeline */
public class SerializableSerializer extends StdSerializer<JsonSerializable> {
    public static final SerializableSerializer f6207a = new SerializableSerializer();
    private static final AtomicReference<ObjectMapper> f6208b = new AtomicReference();

    public final void m11691a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ((JsonSerializable) obj).serialize(jsonGenerator, serializerProvider);
    }

    public final void m11692a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        ((JsonSerializable) obj).serializeWithType(jsonGenerator, serializerProvider, typeSerializer);
    }

    protected SerializableSerializer() {
        super(JsonSerializable.class);
    }
}
