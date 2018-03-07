package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_finch_related_pages */
public class GraphQLGoodwillThrowbackDataPointsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackDataPointsConnection.class, new GraphQLGoodwillThrowbackDataPointsConnectionDeserializer());
    }

    public GraphQLGoodwillThrowbackDataPointsConnectionDeserializer() {
        a(GraphQLGoodwillThrowbackDataPointsConnection.class);
    }

    public Object m7938a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillThrowbackDataPointsConnection__JsonHelper.m7940a(jsonParser);
    }
}
