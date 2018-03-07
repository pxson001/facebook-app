package com.facebook.quickpromotion.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ImageParameters;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: reaction_component_id */
public class QuickPromotionDefinition_ImageParametersSerializer extends JsonSerializer<ImageParameters> {
    public final void m4642a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ImageParameters imageParameters = (ImageParameters) obj;
        if (imageParameters == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4641b(imageParameters, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ImageParameters.class, new QuickPromotionDefinition_ImageParametersSerializer());
    }

    private static void m4641b(ImageParameters imageParameters, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "uri", imageParameters.uri);
        AutoGenJsonHelper.a(jsonGenerator, "width", Integer.valueOf(imageParameters.width));
        AutoGenJsonHelper.a(jsonGenerator, "height", Integer.valueOf(imageParameters.height));
        AutoGenJsonHelper.a(jsonGenerator, "scale", Float.valueOf(imageParameters.scale));
        AutoGenJsonHelper.a(jsonGenerator, "name", imageParameters.name);
    }
}
