package com.facebook.auth.viewercontext;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.proguard.annotations.DoNotStrip;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.base.Preconditions;

@DoNotStrip
/* compiled from: suggestedEvents */
public class ViewerContextSerializer extends JsonSerializer<ViewerContext> {
    public final void m3310a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ViewerContext viewerContext = (ViewerContext) obj;
        Preconditions.checkNotNull(serializerProvider, "Must give a non null SerializerProvider");
        SerializationConfig serializationConfig = serializerProvider._config;
        Preconditions.checkNotNull(serializerProvider, "SerializerProvider must have a non-null config");
        AutoGenJsonHelper.a(serializationConfig);
        if (viewerContext == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m3309b(viewerContext, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ViewerContext.class, new ViewerContextSerializer());
    }

    private static void m3309b(ViewerContext viewerContext, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "user_id", viewerContext.mUserId);
        AutoGenJsonHelper.a(jsonGenerator, "auth_token", viewerContext.mAuthToken);
        AutoGenJsonHelper.a(jsonGenerator, "session_cookies_string", viewerContext.mSessionCookiesString);
        AutoGenJsonHelper.a(jsonGenerator, "is_page_context", Boolean.valueOf(viewerContext.mIsPageContext));
        AutoGenJsonHelper.a(jsonGenerator, "session_secret", viewerContext.mSessionSecret);
        AutoGenJsonHelper.a(jsonGenerator, "session_key", viewerContext.mSessionKey);
        AutoGenJsonHelper.a(jsonGenerator, "username", viewerContext.mUsername);
    }
}
