package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLActivityTemplateTokenDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: launch_point_friend_invites */
public final class GraphQLActivityTemplateToken$Serializer extends JsonSerializer<GraphQLActivityTemplateToken> {
    public final void m6391a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLActivityTemplateToken graphQLActivityTemplateToken = (GraphQLActivityTemplateToken) obj;
        GraphQLActivityTemplateTokenDeserializer.m4516a(graphQLActivityTemplateToken.w_(), graphQLActivityTemplateToken.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLActivityTemplateToken.class, new GraphQLActivityTemplateToken$Serializer());
        FbSerializerProvider.a(GraphQLActivityTemplateToken.class, new GraphQLActivityTemplateToken$Serializer());
    }
}
