package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLStructuredSurveyDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: USERNAME */
public final class GraphQLStructuredSurvey$Serializer extends JsonSerializer<GraphQLStructuredSurvey> {
    public final void m21939a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStructuredSurvey graphQLStructuredSurvey = (GraphQLStructuredSurvey) obj;
        GraphQLStructuredSurveyDeserializer.m6002a(graphQLStructuredSurvey.w_(), graphQLStructuredSurvey.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLStructuredSurvey.class, new GraphQLStructuredSurvey$Serializer());
        FbSerializerProvider.a(GraphQLStructuredSurvey.class, new GraphQLStructuredSurvey$Serializer());
    }
}
