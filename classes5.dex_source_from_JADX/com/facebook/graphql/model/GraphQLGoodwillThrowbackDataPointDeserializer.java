package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_friends_posts_at_place_page_surface */
public class GraphQLGoodwillThrowbackDataPointDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackDataPoint.class, new GraphQLGoodwillThrowbackDataPointDeserializer());
    }

    public GraphQLGoodwillThrowbackDataPointDeserializer() {
        a(GraphQLGoodwillThrowbackDataPoint.class);
    }

    public Object m7932a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillThrowbackDataPoint__JsonHelper.m7934a(jsonParser);
    }
}
