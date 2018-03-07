package com.facebook.ipc.composer.intent;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: live_comment */
public class ComposerShareParamsSerializer extends JsonSerializer<ComposerShareParams> {
    public final void m18253a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerShareParams composerShareParams = (ComposerShareParams) obj;
        if (composerShareParams == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m18252b(composerShareParams, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerShareParams.class, new ComposerShareParamsSerializer());
    }

    private static void m18252b(ComposerShareParams composerShareParams, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "share_preview", composerShareParams.sharePreview);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "shareable", composerShareParams.shareable);
        AutoGenJsonHelper.a(jsonGenerator, "link_for_share", composerShareParams.linkForShare);
        AutoGenJsonHelper.a(jsonGenerator, "share_tracking", composerShareParams.shareTracking);
        AutoGenJsonHelper.a(jsonGenerator, "quote_text", composerShareParams.quoteText);
        AutoGenJsonHelper.a(jsonGenerator, "include_reshare_context", Boolean.valueOf(composerShareParams.includeReshareContext));
    }
}
