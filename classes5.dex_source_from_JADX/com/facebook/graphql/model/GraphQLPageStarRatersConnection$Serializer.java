package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPageStarRatersConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: enable_feedback_for_reply_previews */
public final class GraphQLPageStarRatersConnection$Serializer extends JsonSerializer<GraphQLPageStarRatersConnection> {
    public final void m9518a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageStarRatersConnection graphQLPageStarRatersConnection = (GraphQLPageStarRatersConnection) obj;
        GraphQLPageStarRatersConnectionDeserializer.m5523a(graphQLPageStarRatersConnection.w_(), graphQLPageStarRatersConnection.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLPageStarRatersConnection.class, new GraphQLPageStarRatersConnection$Serializer());
        FbSerializerProvider.a(GraphQLPageStarRatersConnection.class, new GraphQLPageStarRatersConnection$Serializer());
    }
}
