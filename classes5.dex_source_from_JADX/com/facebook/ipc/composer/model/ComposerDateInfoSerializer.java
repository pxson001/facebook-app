package com.facebook.ipc.composer.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TOGGLE_OFF */
public class ComposerDateInfoSerializer extends JsonSerializer<ComposerDateInfo> {
    public final void m23304a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerDateInfo composerDateInfo = (ComposerDateInfo) obj;
        if (composerDateInfo == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23303b(composerDateInfo, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerDateInfo.class, new ComposerDateInfoSerializer());
    }

    private static void m23303b(ComposerDateInfo composerDateInfo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "start_date", composerDateInfo.mStartDate);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "end_date", composerDateInfo.mEndDate);
        AutoGenJsonHelper.a(jsonGenerator, "is_current", Boolean.valueOf(composerDateInfo.mIsCurrent));
    }
}
