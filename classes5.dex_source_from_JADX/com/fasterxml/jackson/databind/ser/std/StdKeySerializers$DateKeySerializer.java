package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.Date;

/* compiled from: can_viewer_message */
public class StdKeySerializers$DateKeySerializer extends StdSerializer<Date> {
    protected static final JsonSerializer<?> f6221a = new StdKeySerializers$DateKeySerializer();

    public final void m11733a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        serializerProvider.b((Date) obj, jsonGenerator);
    }

    public StdKeySerializers$DateKeySerializer() {
        super(Date.class);
    }
}
