package com.facebook.user.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: real_time_activity_info */
public class NameSerializer extends JsonSerializer<Name> {
    public final void m4178a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Name name = (Name) obj;
        if (name == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4177b(name, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.m277a(Name.class, new NameSerializer());
    }

    private static void m4177b(Name name, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.m10234a(jsonGenerator, "firstName", name.firstName);
        AutoGenJsonHelper.m10234a(jsonGenerator, "lastName", name.lastName);
        AutoGenJsonHelper.m10234a(jsonGenerator, "displayName", name.displayName);
    }
}
