package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: originalPostTime */
public class GraphQLIconDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLIcon.class, new GraphQLIconDeserializer());
    }

    public GraphQLIconDeserializer() {
        a(GraphQLIcon.class);
    }

    public Object m8611a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLIcon__JsonHelper.m8613a(jsonParser);
    }
}
