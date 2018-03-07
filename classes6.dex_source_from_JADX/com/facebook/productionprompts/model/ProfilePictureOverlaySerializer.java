package com.facebook.productionprompts.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: standard */
public class ProfilePictureOverlaySerializer extends JsonSerializer<ProfilePictureOverlay> {
    public final void m6338a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ProfilePictureOverlay profilePictureOverlay = (ProfilePictureOverlay) obj;
        if (profilePictureOverlay == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m6337b(profilePictureOverlay, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ProfilePictureOverlay.class, new ProfilePictureOverlaySerializer());
    }

    private static void m6337b(ProfilePictureOverlay profilePictureOverlay, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "image_overlay_id", profilePictureOverlay.mImageOverlayId);
        AutoGenJsonHelper.a(jsonGenerator, "image_overlay_url", profilePictureOverlay.mImageOverlayUrl);
    }
}
