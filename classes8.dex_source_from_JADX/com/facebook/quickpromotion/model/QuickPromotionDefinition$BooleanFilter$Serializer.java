package com.facebook.quickpromotion.model;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.BooleanFilter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: reaction_forward_scroll */
public class QuickPromotionDefinition$BooleanFilter$Serializer extends JsonSerializer<BooleanFilter> {
    public final void m4616a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        BooleanFilter booleanFilter = (BooleanFilter) obj;
        if (booleanFilter == null) {
            jsonGenerator.h();
        } else {
            jsonGenerator.b(((FbObjectMapper) jsonGenerator.a()).a(booleanFilter.a));
        }
    }
}
