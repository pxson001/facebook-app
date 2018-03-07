package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pageProfilePicture */
public class GraphQLGreetingCardDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGreetingCard.class, new GraphQLGreetingCardDeserializer());
    }

    public GraphQLGreetingCardDeserializer() {
        a(GraphQLGreetingCard.class);
    }

    public Object m8324a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGreetingCard__JsonHelper.m8376a(jsonParser);
    }
}
