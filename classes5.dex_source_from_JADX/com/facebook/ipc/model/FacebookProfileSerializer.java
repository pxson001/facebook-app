package com.facebook.ipc.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TEXT_LISTS */
public class FacebookProfileSerializer extends JsonSerializer<FacebookProfile> {
    public final void m23505a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        FacebookProfile facebookProfile = (FacebookProfile) obj;
        if (facebookProfile == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23504b(facebookProfile, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(FacebookProfile.class, new FacebookProfileSerializer());
    }

    private static void m23504b(FacebookProfile facebookProfile, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "id", Long.valueOf(facebookProfile.mId));
        AutoGenJsonHelper.a(jsonGenerator, "name", facebookProfile.mDisplayName);
        AutoGenJsonHelper.a(jsonGenerator, "pic_square", facebookProfile.mImageUrl);
        AutoGenJsonHelper.a(jsonGenerator, "type", facebookProfile.mTypeString);
    }
}
