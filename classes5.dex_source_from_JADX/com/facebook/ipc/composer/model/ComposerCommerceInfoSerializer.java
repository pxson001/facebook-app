package com.facebook.ipc.composer.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TOOLS_EQUIPMENT */
public class ComposerCommerceInfoSerializer extends JsonSerializer<ComposerCommerceInfo> {
    public final void m23293a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ComposerCommerceInfo composerCommerceInfo = (ComposerCommerceInfo) obj;
        if (composerCommerceInfo == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23292b(composerCommerceInfo, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ComposerCommerceInfo.class, new ComposerCommerceInfoSerializer());
    }

    private static void m23292b(ComposerCommerceInfo composerCommerceInfo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "currency_code", composerCommerceInfo.getCurrencyCode());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "intercept_words", composerCommerceInfo.getInterceptWords());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "intercept_words_after_number", composerCommerceInfo.getInterceptWordsAfterNumber());
        AutoGenJsonHelper.a(jsonGenerator, "is_category_optional", Boolean.valueOf(composerCommerceInfo.getIsCategoryOptional()));
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "marketplace_cross_post_setting_model", composerCommerceInfo.getMarketplaceCrossPostSettingModel());
        AutoGenJsonHelper.a(jsonGenerator, "prefill_category_id", composerCommerceInfo.getPrefillCategoryId());
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "product_item_location_picker_settings", composerCommerceInfo.getProductItemLocationPickerSettings());
    }
}
