package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: TV_MOVIE_AWARD */
public class PrivacyTypeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(PrivacyType.class, new PrivacyTypeDeserializer());
    }

    public Object m22568a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return PrivacyType.getByValue(jsonParser.o());
    }
}
