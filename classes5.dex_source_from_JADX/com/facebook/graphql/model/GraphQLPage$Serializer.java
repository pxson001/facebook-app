package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPageDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: entry no longer in map */
public final class GraphQLPage$Serializer extends JsonSerializer<GraphQLPage> {
    public final void m9462a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPage graphQLPage = (GraphQLPage) obj;
        GraphQLPageDeserializer.m5505b(graphQLPage.w_(), graphQLPage.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPage.class, new GraphQLPage$Serializer());
        FbSerializerProvider.a(GraphQLPage.class, new GraphQLPage$Serializer());
    }
}
