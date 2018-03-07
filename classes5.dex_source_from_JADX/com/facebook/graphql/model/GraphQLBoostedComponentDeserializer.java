package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: phrases */
public class GraphQLBoostedComponentDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLBoostedComponent.class, new GraphQLBoostedComponentDeserializer());
    }

    public GraphQLBoostedComponentDeserializer() {
        a(GraphQLBoostedComponent.class);
    }

    public Object m6646a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLBoostedComponent__JsonHelper.m6663a(jsonParser);
    }
}
