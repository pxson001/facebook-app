package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLNegativeFeedbackActionsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: exception occured while trying to create the socket factory */
public final class GraphQLNegativeFeedbackActionsConnection$Serializer extends JsonSerializer<GraphQLNegativeFeedbackActionsConnection> {
    public final void m9240a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNegativeFeedbackActionsConnection graphQLNegativeFeedbackActionsConnection = (GraphQLNegativeFeedbackActionsConnection) obj;
        GraphQLNegativeFeedbackActionsConnectionDeserializer.m5417a(graphQLNegativeFeedbackActionsConnection.w_(), graphQLNegativeFeedbackActionsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLNegativeFeedbackActionsConnection.class, new GraphQLNegativeFeedbackActionsConnection$Serializer());
        FbSerializerProvider.a(GraphQLNegativeFeedbackActionsConnection.class, new GraphQLNegativeFeedbackActionsConnection$Serializer());
    }
}
