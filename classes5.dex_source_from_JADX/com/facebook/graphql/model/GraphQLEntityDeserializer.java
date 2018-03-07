package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pending */
public class GraphQLEntityDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEntity.class, new GraphQLEntityDeserializer());
    }

    public GraphQLEntityDeserializer() {
        a(GraphQLEntity.class);
    }

    public Object m7093a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEntity__JsonHelper.m7102a(jsonParser);
    }
}
