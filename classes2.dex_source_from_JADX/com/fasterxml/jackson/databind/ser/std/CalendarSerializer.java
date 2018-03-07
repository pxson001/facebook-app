package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.text.DateFormat;
import java.util.Calendar;

@JacksonStdImpl
/* compiled from: standard_failure_pings */
public class CalendarSerializer extends DateTimeSerializerBase<Calendar> {
    public static final CalendarSerializer f4172a = new CalendarSerializer();

    protected final /* synthetic */ long mo1104b(Object obj) {
        return m7606a((Calendar) obj);
    }

    public CalendarSerializer() {
        this(false, null);
    }

    private CalendarSerializer(boolean z, DateFormat dateFormat) {
        super(Calendar.class, z, dateFormat);
    }

    public final DateTimeSerializerBase mo1103a(boolean z, DateFormat dateFormat) {
        if (z) {
            return new CalendarSerializer(true, null);
        }
        return new CalendarSerializer(false, dateFormat);
    }

    private static long m7606a(Calendar calendar) {
        return calendar == null ? 0 : calendar.getTimeInMillis();
    }

    public final void m7609a(Calendar calendar, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this.f4173b) {
            jsonGenerator.mo1111a(m7606a(calendar));
        } else if (this.f4174c != null) {
            synchronized (this.f4174c) {
                jsonGenerator.mo1123b(this.f4174c.format(calendar));
            }
        } else {
            serializerProvider.m7315a(calendar.getTime(), jsonGenerator);
        }
    }
}
