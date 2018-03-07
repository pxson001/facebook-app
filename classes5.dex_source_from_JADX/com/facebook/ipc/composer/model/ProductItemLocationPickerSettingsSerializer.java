package com.facebook.ipc.composer.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TIMELINE_CONTEXT_ITEM_FRIENDS_LIST */
public class ProductItemLocationPickerSettingsSerializer extends JsonSerializer<ProductItemLocationPickerSettings> {
    public final void m23406a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ProductItemLocationPickerSettings productItemLocationPickerSettings = (ProductItemLocationPickerSettings) obj;
        if (productItemLocationPickerSettings == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23405b(productItemLocationPickerSettings, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ProductItemLocationPickerSettings.class, new ProductItemLocationPickerSettingsSerializer());
    }

    private static void m23405b(ProductItemLocationPickerSettings productItemLocationPickerSettings, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "is_compulsory", Boolean.valueOf(productItemLocationPickerSettings.getIsCompulsory()));
        AutoGenJsonHelper.a(jsonGenerator, "use_neighborhood_data_source", Boolean.valueOf(productItemLocationPickerSettings.getUseNeighborhoodDataSource()));
        AutoGenJsonHelper.a(jsonGenerator, "use_zip_code", Boolean.valueOf(productItemLocationPickerSettings.getUseZipCode()));
    }
}
