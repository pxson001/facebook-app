package com.facebook.quickpromotion.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: reaction_attachment_invalidated */
public class QuickPromotionDefinition_TemplateTypeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(TemplateType.class, new QuickPromotionDefinition_TemplateTypeDeserializer());
    }

    public Object m4647a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return TemplateType.fromString(jsonParser.o());
    }
}
