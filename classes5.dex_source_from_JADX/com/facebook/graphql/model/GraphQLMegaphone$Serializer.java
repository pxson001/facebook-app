package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLMegaphoneDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: failed_status */
public final class GraphQLMegaphone$Serializer extends JsonSerializer<GraphQLMegaphone> {
    public final void m9088a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMegaphone graphQLMegaphone = (GraphQLMegaphone) obj;
        GraphQLMegaphoneDeserializer.m5366a(graphQLMegaphone.w_(), graphQLMegaphone.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLMegaphone.class, new GraphQLMegaphone$Serializer());
        FbSerializerProvider.a(GraphQLMegaphone.class, new GraphQLMegaphone$Serializer());
    }
}
