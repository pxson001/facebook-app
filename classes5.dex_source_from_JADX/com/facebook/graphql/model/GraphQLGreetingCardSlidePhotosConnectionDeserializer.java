package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: padding */
public class GraphQLGreetingCardSlidePhotosConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGreetingCardSlidePhotosConnection.class, new GraphQLGreetingCardSlidePhotosConnectionDeserializer());
    }

    public GraphQLGreetingCardSlidePhotosConnectionDeserializer() {
        a(GraphQLGreetingCardSlidePhotosConnection.class);
    }

    public Object m8345a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGreetingCardSlidePhotosConnection__JsonHelper.m8347a(jsonParser);
    }
}
