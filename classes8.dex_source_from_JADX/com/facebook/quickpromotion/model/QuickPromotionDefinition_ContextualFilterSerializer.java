package com.facebook.quickpromotion.model;

import com.facebook.common.json.AutoGenJsonHelper;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: reaction_destination_entity_id */
public class QuickPromotionDefinition_ContextualFilterSerializer extends JsonSerializer<ContextualFilter> {
    public final void m4628a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ContextualFilter contextualFilter = (ContextualFilter) obj;
        if (contextualFilter == null) {
            jsonGenerator.h();
        }
        jsonGenerator.f();
        m4627b(contextualFilter, jsonGenerator, serializerProvider);
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ContextualFilter.class, new QuickPromotionDefinition_ContextualFilterSerializer());
    }

    private static void m4627b(ContextualFilter contextualFilter, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "type", contextualFilter.a());
        AutoGenJsonHelper.a(jsonGenerator, "passes_if_not_client_supported", Boolean.valueOf(contextualFilter.passIfNotSupported));
        AutoGenJsonHelper.a(jsonGenerator, "value", contextualFilter.value);
        AutoGenJsonHelper.a(jsonGenerator, serializerProvider, "extra_data", contextualFilter.b());
    }
}
