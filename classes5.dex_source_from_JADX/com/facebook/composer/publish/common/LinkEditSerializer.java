package com.facebook.composer.publish.common;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ad_impression */
public class LinkEditSerializer extends JsonSerializer<LinkEdit> {
    public final void m19663a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        LinkEdit linkEdit = (LinkEdit) obj;
        if (linkEdit == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m19662b(linkEdit, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(LinkEdit.class, new LinkEditSerializer());
    }

    private static void m19662b(LinkEdit linkEdit, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "no_link", linkEdit.noLink);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "link_data", linkEdit.linkData);
    }
}
