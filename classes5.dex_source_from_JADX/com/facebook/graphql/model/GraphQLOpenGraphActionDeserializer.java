package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: offending_view_group_child */
public class GraphQLOpenGraphActionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLOpenGraphAction.class, new GraphQLOpenGraphActionDeserializer());
    }

    public GraphQLOpenGraphActionDeserializer() {
        a(GraphQLOpenGraphAction.class);
    }

    public Object m9393a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLOpenGraphAction__JsonHelper.m9395a(jsonParser);
    }
}
