package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLContactRecommendationFieldDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: isExplicitLocation */
public class GraphQLContactRecommendationField$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLContactRecommendationField.class, new GraphQLContactRecommendationField$Deserializer());
    }

    public Object m6876a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLContactRecommendationFieldDeserializer.m4684a(jsonParser, (short) 14);
        Object graphQLContactRecommendationField = new GraphQLContactRecommendationField();
        ((BaseModel) graphQLContactRecommendationField).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLContactRecommendationField instanceof Postprocessable) {
            return ((Postprocessable) graphQLContactRecommendationField).a();
        }
        return graphQLContactRecommendationField;
    }
}
