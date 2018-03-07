package com.facebook.ipc.composer.intent;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: life_event_icon_suggestions */
public class SharePreviewSerializer extends JsonSerializer<SharePreview> {
    public final void m18306a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        SharePreview sharePreview = (SharePreview) obj;
        if (sharePreview == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m18305b(sharePreview, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(SharePreview.class, new SharePreviewSerializer());
    }

    private static void m18305b(SharePreview sharePreview, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "title", sharePreview.title);
        AutoGenJsonHelper.a(jsonGenerator, "sub_title", sharePreview.subTitle);
        AutoGenJsonHelper.a(jsonGenerator, "summary", sharePreview.summary);
        AutoGenJsonHelper.a(jsonGenerator, "original_share_actor_name", sharePreview.originalShareActorName);
        AutoGenJsonHelper.a(jsonGenerator, "reshare_message", sharePreview.reshareMessage);
        AutoGenJsonHelper.a(jsonGenerator, "image_url", sharePreview.imageUrl);
        AutoGenJsonHelper.a(jsonGenerator, "image_width", Integer.valueOf(sharePreview.imageWidth));
        AutoGenJsonHelper.a(jsonGenerator, "image_height", Integer.valueOf(sharePreview.imageHeight));
        AutoGenJsonHelper.a(jsonGenerator, "is_override", Boolean.valueOf(sharePreview.isOverride));
    }
}
