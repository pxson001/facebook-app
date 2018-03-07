package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_invite */
public class GraphQLGoodwillHappyBirthdayCardDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillHappyBirthdayCard.class, new GraphQLGoodwillHappyBirthdayCardDeserializer());
    }

    public GraphQLGoodwillHappyBirthdayCardDeserializer() {
        a(GraphQLGoodwillHappyBirthdayCard.class);
    }

    public Object m7886a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillHappyBirthdayCard__JsonHelper.m7888a(jsonParser);
    }
}
