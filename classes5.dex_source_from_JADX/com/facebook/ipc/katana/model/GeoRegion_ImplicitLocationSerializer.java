package com.facebook.ipc.katana.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.ipc.katana.model.GeoRegion.ImplicitLocation;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: THREAD_EPHEMERAL_SEND_MODE */
public class GeoRegion_ImplicitLocationSerializer extends JsonSerializer<ImplicitLocation> {
    public final void m23447a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ImplicitLocation implicitLocation = (ImplicitLocation) obj;
        if (implicitLocation == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23446b(implicitLocation, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ImplicitLocation.class, new GeoRegion_ImplicitLocationSerializer());
    }

    private static void m23446b(ImplicitLocation implicitLocation, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "label", implicitLocation.label);
        AutoGenJsonHelper.a(jsonGenerator, "page_id", Long.valueOf(implicitLocation.pageId));
    }
}
