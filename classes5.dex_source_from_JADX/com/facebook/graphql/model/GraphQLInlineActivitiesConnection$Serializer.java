package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLInlineActivitiesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: first_question */
public final class GraphQLInlineActivitiesConnection$Serializer extends JsonSerializer<GraphQLInlineActivitiesConnection> {
    public final void m8686a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) obj;
        GraphQLInlineActivitiesConnectionDeserializer.m5246a(graphQLInlineActivitiesConnection.w_(), graphQLInlineActivitiesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLInlineActivitiesConnection.class, new GraphQLInlineActivitiesConnection$Serializer());
        FbSerializerProvider.a(GraphQLInlineActivitiesConnection.class, new GraphQLInlineActivitiesConnection$Serializer());
    }
}
