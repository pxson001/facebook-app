package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ogActionTypeId */
public class GraphQLNewsFeedConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNewsFeedConnection.class, new GraphQLNewsFeedConnectionDeserializer());
    }

    public GraphQLNewsFeedConnectionDeserializer() {
        a(GraphQLNewsFeedConnection.class);
    }

    public Object m9253a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLNewsFeedConnection__JsonHelper.m9255a(jsonParser);
    }
}
