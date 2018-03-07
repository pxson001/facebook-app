package com.facebook.quickpromotion.customrender;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: region_tos_respond */
public class CustomRenderTypeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(CustomRenderType.class, new CustomRenderTypeDeserializer());
    }

    public Object m4478a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return CustomRenderType.fromString(jsonParser.o());
    }
}
