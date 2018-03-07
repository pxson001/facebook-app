package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: num_non_gone_views */
public class GraphQLPageVisitsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageVisitsConnection.class, new GraphQLPageVisitsConnectionDeserializer());
    }

    public GraphQLPageVisitsConnectionDeserializer() {
        a(GraphQLPageVisitsConnection.class);
    }

    public Object m9549a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPageVisitsConnection__JsonHelper.m9551a(jsonParser);
    }
}
