package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLQuestionOptionsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEW_PROFILE */
public final class GraphQLQuestionOptionsConnection$Serializer extends JsonSerializer<GraphQLQuestionOptionsConnection> {
    public final void m21188a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLQuestionOptionsConnection graphQLQuestionOptionsConnection = (GraphQLQuestionOptionsConnection) obj;
        GraphQLQuestionOptionsConnectionDeserializer.m5742a(graphQLQuestionOptionsConnection.w_(), graphQLQuestionOptionsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLQuestionOptionsConnection.class, new GraphQLQuestionOptionsConnection$Serializer());
        FbSerializerProvider.a(GraphQLQuestionOptionsConnection.class, new GraphQLQuestionOptionsConnection$Serializer());
    }
}
