package com.facebook.ipc.composer.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TODAY_GENERIC_MLE_IMAGE_BLOCKS */
public class ComposerLaunchLoggingParamsSerializer extends JsonSerializer<ComposerLaunchLoggingParams> {
    public final void m23314a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerLaunchLoggingParams composerLaunchLoggingParams = (ComposerLaunchLoggingParams) obj;
        if (composerLaunchLoggingParams == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23313b(composerLaunchLoggingParams, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerLaunchLoggingParams.class, new ComposerLaunchLoggingParamsSerializer());
    }

    private static void m23313b(ComposerLaunchLoggingParams composerLaunchLoggingParams, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "entry_picker", composerLaunchLoggingParams.getEntryPicker());
        AutoGenJsonHelper.a(jsonGenerator, "entry_point_description", composerLaunchLoggingParams.getEntryPointDescription());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "source_surface", composerLaunchLoggingParams.getSourceSurface());
    }
}
