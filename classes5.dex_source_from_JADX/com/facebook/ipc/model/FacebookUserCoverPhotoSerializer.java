package com.facebook.ipc.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TEXT_DIVIDER */
public class FacebookUserCoverPhotoSerializer extends JsonSerializer<FacebookUserCoverPhoto> {
    public final void m23510a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        FacebookUserCoverPhoto facebookUserCoverPhoto = (FacebookUserCoverPhoto) obj;
        if (facebookUserCoverPhoto == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23509b(facebookUserCoverPhoto, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(FacebookUserCoverPhoto.class, new FacebookUserCoverPhotoSerializer());
    }

    private static void m23509b(FacebookUserCoverPhoto facebookUserCoverPhoto, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "cover_id", Long.valueOf(facebookUserCoverPhoto.coverID));
        AutoGenJsonHelper.a(jsonGenerator, "source", facebookUserCoverPhoto.source);
        AutoGenJsonHelper.a(jsonGenerator, "offset_x", Float.valueOf(facebookUserCoverPhoto.offsetX));
        AutoGenJsonHelper.a(jsonGenerator, "offset_y", Float.valueOf(facebookUserCoverPhoto.offsetY));
    }
}
