package com.facebook.ipc.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TEXT */
public class FacebookUserSerializer extends JsonSerializer<FacebookUser> {
    public final void m23514a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        FacebookUser facebookUser = (FacebookUser) obj;
        if (facebookUser == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23513b(facebookUser, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(FacebookUser.class, new FacebookUserSerializer());
    }

    private static void m23513b(FacebookUser facebookUser, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "uid", Long.valueOf(facebookUser.mUserId));
        AutoGenJsonHelper.a(jsonGenerator, "first_name", facebookUser.mFirstName);
        AutoGenJsonHelper.a(jsonGenerator, "last_name", facebookUser.mLastName);
        AutoGenJsonHelper.a(jsonGenerator, "name", facebookUser.mDisplayName);
        AutoGenJsonHelper.a(jsonGenerator, "pic_square", facebookUser.mImageUrl);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "pic_cover", facebookUser.mCoverPhoto);
    }
}
