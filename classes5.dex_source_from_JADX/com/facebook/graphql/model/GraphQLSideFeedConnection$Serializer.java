package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLSideFeedConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VERTEX_ADD_A_CATEGORY */
public final class GraphQLSideFeedConnection$Serializer extends JsonSerializer<GraphQLSideFeedConnection> {
    public final void m21634a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSideFeedConnection graphQLSideFeedConnection = (GraphQLSideFeedConnection) obj;
        GraphQLSideFeedConnectionDeserializer.m5882a(graphQLSideFeedConnection.w_(), graphQLSideFeedConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLSideFeedConnection.class, new GraphQLSideFeedConnection$Serializer());
        FbSerializerProvider.a(GraphQLSideFeedConnection.class, new GraphQLSideFeedConnection$Serializer());
    }
}
