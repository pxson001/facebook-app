package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: parameter_sets */
public class GraphQLEventsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventsConnection.class, new GraphQLEventsConnectionDeserializer());
    }

    public GraphQLEventsConnectionDeserializer() {
        a(GraphQLEventsConnection.class);
    }

    public Object m7349a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventsConnection__JsonHelper.m7351a(jsonParser);
    }
}
