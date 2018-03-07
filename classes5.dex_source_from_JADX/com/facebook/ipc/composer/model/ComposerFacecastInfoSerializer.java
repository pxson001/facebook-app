package com.facebook.ipc.composer.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TODO */
public class ComposerFacecastInfoSerializer extends JsonSerializer<ComposerFacecastInfo> {
    public final void m23309a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerFacecastInfo composerFacecastInfo = (ComposerFacecastInfo) obj;
        if (composerFacecastInfo == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23308b(composerFacecastInfo, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerFacecastInfo.class, new ComposerFacecastInfoSerializer());
    }

    private static void m23308b(ComposerFacecastInfo composerFacecastInfo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "facecast_camera_index", Integer.valueOf(composerFacecastInfo.facecastCameraIndex));
        AutoGenJsonHelper.a(jsonGenerator, "facecast_camera_zoom_level", Integer.valueOf(composerFacecastInfo.facecastCameraZoomLevel));
        AutoGenJsonHelper.a(jsonGenerator, "is_facecast_ready", Boolean.valueOf(composerFacecastInfo.isFacecastReady));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "video_broadcast_response", composerFacecastInfo.videoBroadcastInitResponse);
        AutoGenJsonHelper.a(jsonGenerator, "refetch_broadcast_id", Boolean.valueOf(composerFacecastInfo.shouldRefetchBroadcastId));
    }
}
