package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.text.DateFormat;
import java.util.Date;

@JacksonStdImpl
/* compiled from: staging_area_hit */
public class DateSerializer extends DateTimeSerializerBase<Date> {
    public static final DateSerializer f4175a = new DateSerializer();

    public final void mo1072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Date date = (Date) obj;
        if (this.f4173b) {
            jsonGenerator.mo1111a(m7616a(date));
        } else if (this.f4174c != null) {
            synchronized (this.f4174c) {
                jsonGenerator.mo1123b(this.f4174c.format(date));
            }
        } else {
            serializerProvider.m7315a(date, jsonGenerator);
        }
    }

    protected final /* synthetic */ long mo1104b(Object obj) {
        return m7616a((Date) obj);
    }

    public DateSerializer() {
        this(false, null);
    }

    private DateSerializer(boolean z, DateFormat dateFormat) {
        super(Date.class, z, dateFormat);
    }

    public final DateTimeSerializerBase mo1103a(boolean z, DateFormat dateFormat) {
        if (z) {
            return new DateSerializer(true, null);
        }
        return new DateSerializer(false, dateFormat);
    }

    private static long m7616a(Date date) {
        return date == null ? 0 : date.getTime();
    }
}
