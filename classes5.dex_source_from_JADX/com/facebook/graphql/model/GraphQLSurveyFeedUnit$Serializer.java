package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLSurveyFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UP */
public final class GraphQLSurveyFeedUnit$Serializer extends JsonSerializer<GraphQLSurveyFeedUnit> {
    public final void m22029a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSurveyFeedUnit graphQLSurveyFeedUnit = (GraphQLSurveyFeedUnit) obj;
        GraphQLSurveyFeedUnitDeserializer.m6025a(graphQLSurveyFeedUnit.w_(), graphQLSurveyFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLSurveyFeedUnit.class, new GraphQLSurveyFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLSurveyFeedUnit.class, new GraphQLSurveyFeedUnit$Serializer());
    }
}
