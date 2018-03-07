package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: netego_permalink */
public class GraphQLPostedPhotosConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPostedPhotosConnection.class, new GraphQLPostedPhotosConnectionDeserializer());
    }

    public GraphQLPostedPhotosConnectionDeserializer() {
        a(GraphQLPostedPhotosConnection.class);
    }

    public Object m20972a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPostedPhotosConnection__JsonHelper.m20974a(jsonParser);
    }
}
