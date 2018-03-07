package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLImageAtRangeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: follow_up_action_text */
public final class GraphQLImageAtRange$Serializer extends JsonSerializer<GraphQLImageAtRange> {
    public final void m8619a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLImageAtRange graphQLImageAtRange = (GraphQLImageAtRange) obj;
        GraphQLImageAtRangeDeserializer.m5225b(graphQLImageAtRange.w_(), graphQLImageAtRange.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLImageAtRange.class, new GraphQLImageAtRange$Serializer());
        FbSerializerProvider.a(GraphQLImageAtRange.class, new GraphQLImageAtRange$Serializer());
    }
}
