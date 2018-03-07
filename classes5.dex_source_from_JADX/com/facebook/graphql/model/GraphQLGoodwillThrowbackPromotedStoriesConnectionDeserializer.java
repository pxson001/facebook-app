package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_call_to_action */
public class GraphQLGoodwillThrowbackPromotedStoriesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackPromotedStoriesConnection.class, new GraphQLGoodwillThrowbackPromotedStoriesConnectionDeserializer());
    }

    public GraphQLGoodwillThrowbackPromotedStoriesConnectionDeserializer() {
        a(GraphQLGoodwillThrowbackPromotedStoriesConnection.class);
    }

    public Object m8084a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillThrowbackPromotedStoriesConnection__JsonHelper.m8086a(jsonParser);
    }
}
