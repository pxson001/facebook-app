package com.facebook.quickpromotion.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: reaction_error */
public class QuickPromotionDefinition_Action_StyleDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(QuickPromotionDefinition$Action$Style.class, new QuickPromotionDefinition_Action_StyleDeserializer());
    }

    public Object m4623a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return QuickPromotionDefinition$Action$Style.fromString(jsonParser.o());
    }
}
