package com.facebook.privacy.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: should_use_likers_sentence */
public class PrivacyOptionsResultSerializer extends JsonSerializer<PrivacyOptionsResult> {
    public final void m2384a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PrivacyOptionsResult privacyOptionsResult = (PrivacyOptionsResult) obj;
        if (privacyOptionsResult == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m2383b(privacyOptionsResult, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.m277a(PrivacyOptionsResult.class, new PrivacyOptionsResultSerializer());
    }

    private static void m2383b(PrivacyOptionsResult privacyOptionsResult, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.m10226a(jsonGenerator, serializerProvider, "basic_privacy_options", privacyOptionsResult.basicPrivacyOptions);
        AutoGenJsonHelper.m10226a(jsonGenerator, serializerProvider, "friend_list_privacy_options", privacyOptionsResult.friendListPrivacyOptions);
        AutoGenJsonHelper.m10225a(jsonGenerator, serializerProvider, "selected_privacy_option", privacyOptionsResult.selectedPrivacyOption);
        AutoGenJsonHelper.m10229a(jsonGenerator, "is_selected_option_external", Boolean.valueOf(privacyOptionsResult.isSelectedOptionExternal));
        AutoGenJsonHelper.m10225a(jsonGenerator, serializerProvider, "recent_privacy_option", privacyOptionsResult.recentPrivacyOption);
        AutoGenJsonHelper.m10229a(jsonGenerator, "is_result_from_server", Boolean.valueOf(privacyOptionsResult.isResultFromServer));
    }
}
