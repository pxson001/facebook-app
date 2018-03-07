package com.facebook.uicontrib.datepicker;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: scroll_percent */
public class DateSerializer extends JsonSerializer<Date> {
    public final void m7958a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Date date = (Date) obj;
        if (date == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m7957b(date, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(Date.class, new DateSerializer());
    }

    private static void m7957b(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "year", Integer.valueOf(date.m7933a()));
        AutoGenJsonHelper.a(jsonGenerator, "month", date.m7934b());
        AutoGenJsonHelper.a(jsonGenerator, "day", date.m7935c());
    }
}
