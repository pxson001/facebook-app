package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLContactRecommendationFieldDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: isExplicitLocation */
public final class GraphQLContactRecommendationField$Serializer extends JsonSerializer<GraphQLContactRecommendationField> {
    public final void m6877a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLContactRecommendationField graphQLContactRecommendationField = (GraphQLContactRecommendationField) obj;
        GraphQLContactRecommendationFieldDeserializer.m4685a(graphQLContactRecommendationField.w_(), graphQLContactRecommendationField.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLContactRecommendationField.class, new GraphQLContactRecommendationField$Serializer());
        FbSerializerProvider.a(GraphQLContactRecommendationField.class, new GraphQLContactRecommendationField$Serializer());
    }
}
