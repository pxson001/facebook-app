package com.facebook.ipc.composer.intent;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: load_draft */
public class ComposerPageDataSerializer extends JsonSerializer<ComposerPageData> {
    public final void m18237a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerPageData composerPageData = (ComposerPageData) obj;
        if (composerPageData == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m18236b(composerPageData, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerPageData.class, new ComposerPageDataSerializer());
    }

    private static void m18236b(ComposerPageData composerPageData, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "is_page_verified", Boolean.valueOf(composerPageData.getIsPageVerified()));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "post_as_page_viewer_context", composerPageData.getPostAsPageViewerContext());
    }
}
