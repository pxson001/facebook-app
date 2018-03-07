package com.facebook.resources.impl.loading;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: PRIMARY_ACTION_BUTTON_STYLE */
public class LanguagePackInfoSerializer extends JsonSerializer<LanguagePackInfo> {
    public final void m12930a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        LanguagePackInfo languagePackInfo = (LanguagePackInfo) obj;
        if (languagePackInfo == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m12929b(languagePackInfo, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(LanguagePackInfo.class, new LanguagePackInfoSerializer());
    }

    private static void m12929b(LanguagePackInfo languagePackInfo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "download_url", languagePackInfo.downloadUrl);
        AutoGenJsonHelper.a(jsonGenerator, "download_checksum", languagePackInfo.checksum);
        AutoGenJsonHelper.a(jsonGenerator, "version_code", Integer.valueOf(languagePackInfo.versionCode));
        AutoGenJsonHelper.a(jsonGenerator, "locale", languagePackInfo.locale);
    }
}
