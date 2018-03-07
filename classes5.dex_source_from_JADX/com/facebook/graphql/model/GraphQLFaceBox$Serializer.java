package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFaceBoxDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: i_am_faceweb */
public final class GraphQLFaceBox$Serializer extends JsonSerializer<GraphQLFaceBox> {
    public final void m7433a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFaceBox graphQLFaceBox = (GraphQLFaceBox) obj;
        GraphQLFaceBoxDeserializer.m4872b(graphQLFaceBox.w_(), graphQLFaceBox.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFaceBox.class, new GraphQLFaceBox$Serializer());
        FbSerializerProvider.a(GraphQLFaceBox.class, new GraphQLFaceBox$Serializer());
    }
}
