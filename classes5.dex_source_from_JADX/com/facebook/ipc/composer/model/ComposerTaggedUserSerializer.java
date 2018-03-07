package com.facebook.ipc.composer.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TIMEZONE */
public class ComposerTaggedUserSerializer extends JsonSerializer<ComposerTaggedUser> {
    public final void m23367a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerTaggedUser composerTaggedUser = (ComposerTaggedUser) obj;
        if (composerTaggedUser == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23366b(composerTaggedUser, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerTaggedUser.class, new ComposerTaggedUserSerializer());
    }

    private static void m23366b(ComposerTaggedUser composerTaggedUser, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "id", Long.valueOf(composerTaggedUser.mId));
        AutoGenJsonHelper.a(jsonGenerator, "name", composerTaggedUser.mName);
        AutoGenJsonHelper.a(jsonGenerator, "image_url", composerTaggedUser.mImageUrl);
    }
}
