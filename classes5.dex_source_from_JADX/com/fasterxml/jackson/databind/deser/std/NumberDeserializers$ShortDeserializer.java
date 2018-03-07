package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer;

@JacksonStdImpl
/* compiled from: checkin_after_party */
public final class NumberDeserializers$ShortDeserializer extends PrimitiveOrWrapperDeserializer<Short> {
    public static final NumberDeserializers$ShortDeserializer f6095a = new NumberDeserializers$ShortDeserializer(Short.class, Short.valueOf((short) 0));
    public static final NumberDeserializers$ShortDeserializer f6096b = new NumberDeserializers$ShortDeserializer(Short.TYPE, null);
    private static final long serialVersionUID = 1;

    public final /* synthetic */ Object m11249a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11250b(jsonParser, deserializationContext);
    }

    private NumberDeserializers$ShortDeserializer(Class<Short> cls, Short sh) {
        super(cls, sh);
    }

    public final Short m11250b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return n(jsonParser, deserializationContext);
    }
}
