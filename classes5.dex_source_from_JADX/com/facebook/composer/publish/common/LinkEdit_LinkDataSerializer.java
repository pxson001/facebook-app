package com.facebook.composer.publish.common;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.composer.publish.common.LinkEdit.LinkData;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ad_account_id */
public class LinkEdit_LinkDataSerializer extends JsonSerializer<LinkData> {
    public final void m19667a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        LinkData linkData = (LinkData) obj;
        if (linkData == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m19666b(linkData, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(LinkData.class, new LinkEdit_LinkDataSerializer());
    }

    private static void m19666b(LinkData linkData, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "link", linkData.link);
    }
}
