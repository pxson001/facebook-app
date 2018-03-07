package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLGroupDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friends_invited */
public final class GraphQLGroup$Serializer extends JsonSerializer<GraphQLGroup> {
    public final void m8380a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroup graphQLGroup = (GraphQLGroup) obj;
        GraphQLGroupDeserializer.m5159a(graphQLGroup.w_(), graphQLGroup.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLGroup.class, new GraphQLGroup$Serializer());
        FbSerializerProvider.a(GraphQLGroup.class, new GraphQLGroup$Serializer());
    }
}
