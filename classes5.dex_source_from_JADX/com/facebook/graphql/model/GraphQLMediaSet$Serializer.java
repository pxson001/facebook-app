package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLMediaSetDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: family_search */
public final class GraphQLMediaSet$Serializer extends JsonSerializer<GraphQLMediaSet> {
    public final void m9066a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMediaSet graphQLMediaSet = (GraphQLMediaSet) obj;
        GraphQLMediaSetDeserializer.m5357a(graphQLMediaSet.w_(), graphQLMediaSet.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLMediaSet.class, new GraphQLMediaSet$Serializer());
        FbSerializerProvider.a(GraphQLMediaSet.class, new GraphQLMediaSet$Serializer());
    }
}
