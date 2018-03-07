package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.sql.Time;

@JacksonStdImpl
/* compiled from: stage */
public class SqlTimeSerializer extends StdScalarSerializer<Time> {
    public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1123b(((Time) obj).toString());
    }

    public SqlTimeSerializer() {
        super(Time.class);
    }
}
