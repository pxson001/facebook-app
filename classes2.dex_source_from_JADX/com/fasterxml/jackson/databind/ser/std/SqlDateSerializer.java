package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.sql.Date;

@JacksonStdImpl
/* compiled from: staged_feed_num_units_to_prefetch */
public class SqlDateSerializer extends StdScalarSerializer<Date> {
    public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1123b(((Date) obj).toString());
    }

    public SqlDateSerializer() {
        super(Date.class);
    }
}
