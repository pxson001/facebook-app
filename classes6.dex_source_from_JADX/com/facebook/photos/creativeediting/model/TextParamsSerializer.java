package com.facebook.photos.creativeediting.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: superSavedState */
public class TextParamsSerializer extends JsonSerializer<TextParams> {
    public final void m4743a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        TextParams textParams = (TextParams) obj;
        if (textParams == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4742b(textParams, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(TextParams.class, new TextParamsSerializer());
    }

    private static void m4742b(TextParams textParams, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "id", textParams.mo228g());
        AutoGenJsonHelper.a(jsonGenerator, "uri", textParams.uri);
        AutoGenJsonHelper.a(jsonGenerator, "text_string", textParams.textString);
        AutoGenJsonHelper.a(jsonGenerator, "left", Float.valueOf(textParams.leftPercentage));
        AutoGenJsonHelper.a(jsonGenerator, "top", Float.valueOf(textParams.topPercentage));
        AutoGenJsonHelper.a(jsonGenerator, "width", Float.valueOf(textParams.widthPercentage));
        AutoGenJsonHelper.a(jsonGenerator, "height", Float.valueOf(textParams.heightPercentage));
        AutoGenJsonHelper.a(jsonGenerator, "rotation_degrees", Float.valueOf(textParams.rotateDegrees));
        AutoGenJsonHelper.a(jsonGenerator, "text_color", Integer.valueOf(textParams.textColor));
        AutoGenJsonHelper.a(jsonGenerator, "isSelectable", Boolean.valueOf(textParams.isSelectable));
        AutoGenJsonHelper.a(jsonGenerator, "isFrameItem", Boolean.valueOf(textParams.isFrameItem));
    }
}
