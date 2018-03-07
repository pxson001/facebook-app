package com.facebook.katana.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: upcoming_birthdays?start_date=%s */
public class FacebookSessionInfoSerializer extends JsonSerializer<FacebookSessionInfo> {
    public final void m992a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        FacebookSessionInfo facebookSessionInfo = (FacebookSessionInfo) obj;
        if (facebookSessionInfo == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m991b(facebookSessionInfo, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(FacebookSessionInfo.class, new FacebookSessionInfoSerializer());
    }

    private static void m991b(FacebookSessionInfo facebookSessionInfo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "username", facebookSessionInfo.username);
        AutoGenJsonHelper.a(jsonGenerator, "session_key", facebookSessionInfo.sessionKey);
        AutoGenJsonHelper.a(jsonGenerator, "secret", facebookSessionInfo.sessionSecret);
        AutoGenJsonHelper.a(jsonGenerator, "access_token", facebookSessionInfo.oAuthToken);
        AutoGenJsonHelper.a(jsonGenerator, "uid", Long.valueOf(facebookSessionInfo.userId));
        AutoGenJsonHelper.a(jsonGenerator, "machine_id", facebookSessionInfo.machineID);
        AutoGenJsonHelper.a(jsonGenerator, "error_data", facebookSessionInfo.errorData);
        AutoGenJsonHelper.a(jsonGenerator, "filter", facebookSessionInfo.mFilterKey);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "profile", facebookSessionInfo.mMyself);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "session_cookies", facebookSessionInfo.getSessionCookies());
    }
}
