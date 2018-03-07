package com.fasterxml.jackson.datatype.guava.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.google.common.base.Absent;

/* compiled from: can_upload */
public class GuavaOptionalBeanPropertyWriter extends BeanPropertyWriter {
    protected GuavaOptionalBeanPropertyWriter(BeanPropertyWriter beanPropertyWriter) {
        super(beanPropertyWriter);
    }

    public final void m12040a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if ((a(obj) != null && !Absent.INSTANCE.equals(a(obj))) || this.l != null) {
            super.a(obj, jsonGenerator, serializerProvider);
        }
    }
}
