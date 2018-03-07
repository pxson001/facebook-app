package com.facebook.quickpromotion.model;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.BooleanFilter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/* compiled from: reaction_forward_scroll */
public class QuickPromotionDefinition$BooleanFilter$Deserializer extends JsonDeserializer<BooleanFilter> {
    public Object m4615a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.g() == JsonToken.VALUE_NULL) {
            return null;
        }
        return new BooleanFilter((QuickPromotionDefinition$FilterClause) ((FbObjectMapper) jsonParser.a()).b().a(jsonParser.o()).a(QuickPromotionDefinition$FilterClause.class));
    }
}
