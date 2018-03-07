package com.facebook.nux;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: isResultFromServer */
public class NuxHistorySerializer extends JsonSerializer<NuxHistory> {
    public final void m19143a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        NuxHistory nuxHistory = (NuxHistory) obj;
        if (nuxHistory == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m19142b(nuxHistory, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(NuxHistory.class, new NuxHistorySerializer());
    }

    private static void m19142b(NuxHistory nuxHistory, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "lastAppearanceTime", Long.valueOf(nuxHistory.lastAppearanceTime));
        AutoGenJsonHelper.a(jsonGenerator, "isCompleted", Boolean.valueOf(nuxHistory.isCompleted));
        AutoGenJsonHelper.a(jsonGenerator, "numAppearances", Long.valueOf(nuxHistory.numAppearances));
    }
}
