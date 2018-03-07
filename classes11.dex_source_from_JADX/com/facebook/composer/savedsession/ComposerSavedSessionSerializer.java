package com.facebook.composer.savedsession;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fetchTimeout */
public class ComposerSavedSessionSerializer extends JsonSerializer<ComposerSavedSession> {
    public final void m8256a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerSavedSession composerSavedSession = (ComposerSavedSession) obj;
        if (composerSavedSession == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m8255b(composerSavedSession, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerSavedSession.class, new ComposerSavedSessionSerializer());
    }

    private static void m8255b(ComposerSavedSession composerSavedSession, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "version", Integer.valueOf(composerSavedSession.version));
        AutoGenJsonHelper.a(jsonGenerator, "creation_time_ms", Long.valueOf(composerSavedSession.creationTimeMs));
        AutoGenJsonHelper.a(jsonGenerator, "load_attempts", Integer.valueOf(composerSavedSession.loadAttempts));
        AutoGenJsonHelper.a(jsonGenerator, "session_id", composerSavedSession.sessionId);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "configuration", composerSavedSession.configuration);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "composition", composerSavedSession.composition);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "viewer_coordinates", composerSavedSession.viewerCoordinates);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "target_data", composerSavedSession.targetData);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "page_data", composerSavedSession.pageData);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "privacy_override", composerSavedSession.privacyOverride);
        AutoGenJsonHelper.a(jsonGenerator, "photos_enabled", Boolean.valueOf(composerSavedSession.photosEnabled));
        AutoGenJsonHelper.a(jsonGenerator, "privacy_has_changed", Boolean.valueOf(composerSavedSession.privacyHasChanged));
        AutoGenJsonHelper.a(jsonGenerator, "plugin_state", composerSavedSession.pluginState);
    }
}
