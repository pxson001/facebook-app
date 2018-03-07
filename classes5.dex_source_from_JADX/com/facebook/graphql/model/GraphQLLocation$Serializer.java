package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLLocationDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fb_sync */
public final class GraphQLLocation$Serializer extends JsonSerializer<GraphQLLocation> {
    public final void m8962a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLocation graphQLLocation = (GraphQLLocation) obj;
        GraphQLLocationDeserializer.m5332a(graphQLLocation.w_(), graphQLLocation.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLLocation.class, new GraphQLLocation$Serializer());
        FbSerializerProvider.a(GraphQLLocation.class, new GraphQLLocation$Serializer());
    }
}
