package com.facebook.friendsharing.souvenirs.layout;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ReactionMoreComponentsQuery */
public class SouvenirRowSerializer extends JsonSerializer<SouvenirRow> {
    public final void m26152a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        SouvenirRow souvenirRow = (SouvenirRow) obj;
        if (souvenirRow == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m26151b(souvenirRow, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(SouvenirRow.class, new SouvenirRowSerializer());
    }

    private static void m26151b(SouvenirRow souvenirRow, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "template", souvenirRow.mTemplate);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "items", souvenirRow.mItems);
    }
}
