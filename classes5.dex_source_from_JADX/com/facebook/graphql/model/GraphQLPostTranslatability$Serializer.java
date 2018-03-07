package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPostTranslatabilityDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Visible child  */
public final class GraphQLPostTranslatability$Serializer extends JsonSerializer<GraphQLPostTranslatability> {
    public final void m20967a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPostTranslatability graphQLPostTranslatability = (GraphQLPostTranslatability) obj;
        GraphQLPostTranslatabilityDeserializer.m5684a(graphQLPostTranslatability.w_(), graphQLPostTranslatability.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPostTranslatability.class, new GraphQLPostTranslatability$Serializer());
        FbSerializerProvider.a(GraphQLPostTranslatability.class, new GraphQLPostTranslatability$Serializer());
    }
}
