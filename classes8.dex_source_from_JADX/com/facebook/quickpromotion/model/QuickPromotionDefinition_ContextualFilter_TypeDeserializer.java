package com.facebook.quickpromotion.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: reaction_critic_review_thumbnail_width */
public class QuickPromotionDefinition_ContextualFilter_TypeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(QuickPromotionDefinition$ContextualFilter$Type.class, new QuickPromotionDefinition_ContextualFilter_TypeDeserializer());
    }

    public Object m4629a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return QuickPromotionDefinition$ContextualFilter$Type.fromString(jsonParser.o());
    }
}
