package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.Date;

/* compiled from: firstname */
public class StdKeySerializer extends StdSerializer<Object> {
    static final StdKeySerializer f11536a = new StdKeySerializer();

    public StdKeySerializer() {
        super(Object.class);
    }

    public final void m12021a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (obj instanceof Date) {
            serializerProvider.b((Date) obj, jsonGenerator);
        } else {
            jsonGenerator.a(obj.toString());
        }
    }
}
