package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers.PrimitiveOrWrapperDeserializer;

@JacksonStdImpl
/* compiled from: checkin_after_party */
public final class NumberDeserializers$ByteDeserializer extends PrimitiveOrWrapperDeserializer<Byte> {
    public static final NumberDeserializers$ByteDeserializer f6090a = new NumberDeserializers$ByteDeserializer(Byte.TYPE, Byte.valueOf((byte) 0));
    public static final NumberDeserializers$ByteDeserializer f6091b = new NumberDeserializers$ByteDeserializer(Byte.class, null);
    private static final long serialVersionUID = 1;

    public final /* synthetic */ Object m11238a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11239b(jsonParser, deserializationContext);
    }

    private NumberDeserializers$ByteDeserializer(Class<Byte> cls, Byte b) {
        super(cls, b);
    }

    public final Byte m11239b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m(jsonParser, deserializationContext);
    }
}
