package com.facebook.share.protocol;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: media_set_display_activity_selected_photo_uri_extra */
public class LinksPreviewParams_SizeSerializer extends JsonSerializer<Size> {
    public final void m10698a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        Size size = (Size) obj;
        if (size == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m10697b(size, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(Size.class, new LinksPreviewParams_SizeSerializer());
    }

    private static void m10697b(Size size, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "width", Integer.valueOf(size.mWidth));
        AutoGenJsonHelper.a(jsonGenerator, "height", Integer.valueOf(size.mHeight));
    }
}
