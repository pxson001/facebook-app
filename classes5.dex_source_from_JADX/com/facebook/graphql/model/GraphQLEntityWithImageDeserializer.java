package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pc */
public class GraphQLEntityWithImageDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEntityWithImage.class, new GraphQLEntityWithImageDeserializer());
    }

    public GraphQLEntityWithImageDeserializer() {
        a(GraphQLEntityWithImage.class);
    }

    public Object m7098a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEntityWithImage__JsonHelper.m7100a(jsonParser);
    }
}
