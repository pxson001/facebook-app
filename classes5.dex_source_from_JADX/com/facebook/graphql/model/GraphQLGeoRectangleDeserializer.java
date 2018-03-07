package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_migration */
public class GraphQLGeoRectangleDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGeoRectangle.class, new GraphQLGeoRectangleDeserializer());
    }

    public GraphQLGeoRectangleDeserializer() {
        a(GraphQLGeoRectangle.class);
    }

    public Object m7764a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGeoRectangle__JsonHelper.m7766a(jsonParser);
    }
}
