package com.facebook.ipc.composer.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TIMELINE_ACTION_MENU_REPORT_PAGE */
public class ProductItemPlaceSerializer extends JsonSerializer<ProductItemPlace> {
    public final void m23413a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ProductItemPlace productItemPlace = (ProductItemPlace) obj;
        if (productItemPlace == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23412b(productItemPlace, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ProductItemPlace.class, new ProductItemPlaceSerializer());
    }

    private static void m23412b(ProductItemPlace productItemPlace, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "name", productItemPlace.name);
        AutoGenJsonHelper.a(jsonGenerator, "location_page_id", productItemPlace.locationPageID);
        AutoGenJsonHelper.a(jsonGenerator, "latitude", Double.valueOf(productItemPlace.latitude));
        AutoGenJsonHelper.a(jsonGenerator, "longitude", Double.valueOf(productItemPlace.longitude));
    }
}
