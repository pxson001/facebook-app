package com.facebook.goodwill.publish;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.goodwill.publish.PublishFriendversaryCollageMethod.ThrowbackCardPojo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: write_review_tap */
public class PublishFriendversaryCollageMethod_ThrowbackCardPojoSerializer extends JsonSerializer<ThrowbackCardPojo> {
    public final void m177a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ThrowbackCardPojo throwbackCardPojo = (ThrowbackCardPojo) obj;
        if (throwbackCardPojo == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m176b(throwbackCardPojo, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ThrowbackCardPojo.class, new PublishFriendversaryCollageMethod_ThrowbackCardPojoSerializer());
    }

    private static void m176b(ThrowbackCardPojo throwbackCardPojo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "campaign_id", Long.valueOf(throwbackCardPojo.campaign_id));
        AutoGenJsonHelper.a(jsonGenerator, "source", throwbackCardPojo.source);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "media_ids", throwbackCardPojo.media_ids);
    }
}
