package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pages_liked_feed */
public class GraphQLFaceBoxDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFaceBox.class, new GraphQLFaceBoxDeserializer());
    }

    public GraphQLFaceBoxDeserializer() {
        a(GraphQLFaceBox.class);
    }

    public Object m7434a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFaceBox__JsonHelper.m7452a(jsonParser);
    }
}
