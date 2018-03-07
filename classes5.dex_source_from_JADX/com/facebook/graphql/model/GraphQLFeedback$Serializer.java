package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFeedbackDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: home_team_object */
public final class GraphQLFeedback$Serializer extends JsonSerializer<GraphQLFeedback> {
    public final void m7474a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
        GraphQLFeedbackDeserializer.m4895b(graphQLFeedback.w_(), graphQLFeedback.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFeedback.class, new GraphQLFeedback$Serializer());
        FbSerializerProvider.a(GraphQLFeedback.class, new GraphQLFeedback$Serializer());
    }
}
