package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: offending_view_depth */
public class GraphQLOpenGraphObjectDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLOpenGraphObject.class, new GraphQLOpenGraphObjectDeserializer());
    }

    public GraphQLOpenGraphObjectDeserializer() {
        a(GraphQLOpenGraphObject.class);
    }

    public Object m9407a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLOpenGraphObject__JsonHelper.m9409a(jsonParser);
    }
}
