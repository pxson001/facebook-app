package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTopLevelCommentsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNBLOCK_PROMOTION */
public final class GraphQLTopLevelCommentsConnection$Serializer extends JsonSerializer<GraphQLTopLevelCommentsConnection> {
    public final void m22245a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTopLevelCommentsConnection graphQLTopLevelCommentsConnection = (GraphQLTopLevelCommentsConnection) obj;
        GraphQLTopLevelCommentsConnectionDeserializer.m6103a(graphQLTopLevelCommentsConnection.w_(), graphQLTopLevelCommentsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTopLevelCommentsConnection.class, new GraphQLTopLevelCommentsConnection$Serializer());
        FbSerializerProvider.a(GraphQLTopLevelCommentsConnection.class, new GraphQLTopLevelCommentsConnection$Serializer());
    }
}
