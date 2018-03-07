package com.facebook.ipc.friendsharing.listeningto;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: unknown image view attribute =  */
public class ListeningToComposerPluginConfigSerializer extends JsonSerializer<ListeningToComposerPluginConfig> {
    public final void m1382a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ListeningToComposerPluginConfig listeningToComposerPluginConfig = (ListeningToComposerPluginConfig) obj;
        if (listeningToComposerPluginConfig == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m1381b(listeningToComposerPluginConfig, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ListeningToComposerPluginConfig.class, new ListeningToComposerPluginConfigSerializer());
    }

    private static void m1381b(ListeningToComposerPluginConfig listeningToComposerPluginConfig, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "artist_name", listeningToComposerPluginConfig.mArtistName);
        AutoGenJsonHelper.a(jsonGenerator, "track_name", listeningToComposerPluginConfig.mTrackName);
        AutoGenJsonHelper.a(jsonGenerator, "composer_session_id", listeningToComposerPluginConfig.mComposerSessionId);
    }
}
