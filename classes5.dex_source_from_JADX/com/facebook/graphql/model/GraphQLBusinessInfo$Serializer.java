package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLBusinessInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_game */
public final class GraphQLBusinessInfo$Serializer extends JsonSerializer<GraphQLBusinessInfo> {
    public final void m6702a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLBusinessInfo graphQLBusinessInfo = (GraphQLBusinessInfo) obj;
        GraphQLBusinessInfoDeserializer.m4631b(graphQLBusinessInfo.w_(), graphQLBusinessInfo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLBusinessInfo.class, new GraphQLBusinessInfo$Serializer());
        FbSerializerProvider.a(GraphQLBusinessInfo.class, new GraphQLBusinessInfo$Serializer());
    }
}
