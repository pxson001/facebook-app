package com.facebook.quickpromotion.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.quickpromotion.model.QuickPromotionDefinition$FilterClause.BooleanType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: reaction_context_items_source */
public class QuickPromotionDefinition_FilterClause_BooleanTypeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(BooleanType.class, new QuickPromotionDefinition_FilterClause_BooleanTypeDeserializer());
    }

    public Object m4638a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return BooleanType.fromString(jsonParser.o());
    }
}
