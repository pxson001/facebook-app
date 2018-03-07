package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pageCount */
public class GraphQLGreetingCardSlideDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGreetingCardSlide.class, new GraphQLGreetingCardSlideDeserializer());
    }

    public GraphQLGreetingCardSlideDeserializer() {
        a(GraphQLGreetingCardSlide.class);
    }

    public Object m8339a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGreetingCardSlide__JsonHelper.m8350a(jsonParser);
    }
}
