package com.facebook.ipc.composer.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TIMELINE_FANNED_PAGES_SECTION */
public class ProductItemAttachmentSerializer extends JsonSerializer<ProductItemAttachment> {
    public final void m23402a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ProductItemAttachment productItemAttachment = (ProductItemAttachment) obj;
        if (productItemAttachment == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m23401b(productItemAttachment, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ProductItemAttachment.class, new ProductItemAttachmentSerializer());
    }

    private static void m23401b(ProductItemAttachment productItemAttachment, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "title", productItemAttachment.title);
        AutoGenJsonHelper.a(jsonGenerator, "pickup_delivery_info", productItemAttachment.pickupDeliveryInfo);
        AutoGenJsonHelper.a(jsonGenerator, "description", productItemAttachment.description);
        AutoGenJsonHelper.a(jsonGenerator, "price", productItemAttachment.price);
        AutoGenJsonHelper.a(jsonGenerator, "currency", productItemAttachment.currencyCode);
        AutoGenJsonHelper.a(jsonGenerator, "category_id", productItemAttachment.categoryID);
        AutoGenJsonHelper.a(jsonGenerator, "location_page_id", productItemAttachment.getLocationPageID());
    }
}
