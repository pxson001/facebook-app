package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: open_fd_count */
public class GraphQLLocationDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLocation.class, new GraphQLLocationDeserializer());
    }

    public GraphQLLocationDeserializer() {
        a(GraphQLLocation.class);
    }

    public Object m8963a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLLocation__JsonHelper.m8965a(jsonParser);
    }
}
