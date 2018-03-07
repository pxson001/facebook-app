package com.facebook.groupcommerce.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: mPhotoTags */
public class GroupCommerceCategorySerializer extends JsonSerializer<GroupCommerceCategory> {
    public final void m17636a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GroupCommerceCategory groupCommerceCategory = (GroupCommerceCategory) obj;
        if (groupCommerceCategory == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m17635b(groupCommerceCategory, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(GroupCommerceCategory.class, new GroupCommerceCategorySerializer());
    }

    private static void m17635b(GroupCommerceCategory groupCommerceCategory, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, "name", groupCommerceCategory.name);
        AutoGenJsonHelper.a(jsonGenerator, "category_id", groupCommerceCategory.categoryID);
    }
}
