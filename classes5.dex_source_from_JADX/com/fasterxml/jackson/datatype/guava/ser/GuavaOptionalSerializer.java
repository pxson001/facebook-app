package com.fasterxml.jackson.datatype.guava.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.common.base.Optional;

/* compiled from: can_update_currency */
public final class GuavaOptionalSerializer extends StdSerializer<Optional<?>> {
    public final void m12041a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Optional optional = (Optional) obj;
        if (optional.isPresent()) {
            serializerProvider.a(optional.get(), jsonGenerator);
        } else {
            serializerProvider.a(jsonGenerator);
        }
    }

    public GuavaOptionalSerializer(JavaType javaType) {
        super(javaType);
    }
}
