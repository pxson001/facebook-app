package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: packageVersionCode= */
public class GraphQLGreetingCardSlidesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGreetingCardSlidesConnection.class, new GraphQLGreetingCardSlidesConnectionDeserializer());
    }

    public GraphQLGreetingCardSlidesConnectionDeserializer() {
        a(GraphQLGreetingCardSlidesConnection.class);
    }

    public Object m8355a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGreetingCardSlidesConnection__JsonHelper.m8357a(jsonParser);
    }
}
