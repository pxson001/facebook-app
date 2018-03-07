package com.facebook.quickpromotion.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Attribute;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: reaction_dialog_scroll_perf */
public class QuickPromotionDefinition_AttributeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(Attribute.class, new QuickPromotionDefinition_AttributeDeserializer());
    }

    public Object m4624a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return Attribute.fromString(jsonParser.o());
    }
}
