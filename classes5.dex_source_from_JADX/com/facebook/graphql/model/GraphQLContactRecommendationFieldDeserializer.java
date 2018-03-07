package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photoUrl */
public class GraphQLContactRecommendationFieldDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLContactRecommendationField.class, new GraphQLContactRecommendationFieldDeserializer());
    }

    public GraphQLContactRecommendationFieldDeserializer() {
        a(GraphQLContactRecommendationField.class);
    }

    public Object m6878a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLContactRecommendationField__JsonHelper.m6880a(jsonParser);
    }
}
