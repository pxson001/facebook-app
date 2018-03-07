package com.facebook.composer.publish.common;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: activity_log */
public class PostParamsWrapperSerializer extends JsonSerializer<PostParamsWrapper> {
    public final void m19696a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PostParamsWrapper postParamsWrapper = (PostParamsWrapper) obj;
        if (postParamsWrapper == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m19695b(postParamsWrapper, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(PostParamsWrapper.class, new PostParamsWrapperSerializer());
    }

    private static void m19695b(PostParamsWrapper postParamsWrapper, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "publish_post_params", postParamsWrapper.m19692k());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "edit_post_params", postParamsWrapper.m19691j());
    }
}
