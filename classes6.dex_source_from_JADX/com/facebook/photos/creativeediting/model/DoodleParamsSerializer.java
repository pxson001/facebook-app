package com.facebook.photos.creativeediting.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: syncToken */
public class DoodleParamsSerializer extends JsonSerializer<DoodleParams> {
    public final void m4492a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        DoodleParams doodleParams = (DoodleParams) obj;
        if (doodleParams == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4491b(doodleParams, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(DoodleParams.class, new DoodleParamsSerializer());
    }

    private static void m4491b(DoodleParams doodleParams, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "id", doodleParams.mo228g());
        AutoGenJsonHelper.a(jsonGenerator, "uri", doodleParams.uri);
        AutoGenJsonHelper.a(jsonGenerator, "left", Float.valueOf(doodleParams.leftPercentage));
        AutoGenJsonHelper.a(jsonGenerator, "top", Float.valueOf(doodleParams.topPercentage));
        AutoGenJsonHelper.a(jsonGenerator, "width", Float.valueOf(doodleParams.widthPercentage));
        AutoGenJsonHelper.a(jsonGenerator, "height", Float.valueOf(doodleParams.heightPercentage));
        AutoGenJsonHelper.a(jsonGenerator, "rotation_degrees", Float.valueOf(doodleParams.rotateDegrees));
    }
}
