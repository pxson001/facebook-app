package com.facebook.graphql.enums;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: lowerBound */
public class GraphQLPrivacyOptionTypeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPrivacyOptionType.class, new GraphQLPrivacyOptionTypeDeserializer());
    }

    public Object m6225a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPrivacyOptionType.fromIconName(jsonParser.o());
    }
}
