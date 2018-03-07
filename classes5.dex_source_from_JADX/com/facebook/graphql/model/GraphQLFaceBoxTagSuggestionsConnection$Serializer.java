package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFaceBoxTagSuggestionsConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hybrid */
public final class GraphQLFaceBoxTagSuggestionsConnection$Serializer extends JsonSerializer<GraphQLFaceBoxTagSuggestionsConnection> {
    public final void m7437a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFaceBoxTagSuggestionsConnection graphQLFaceBoxTagSuggestionsConnection = (GraphQLFaceBoxTagSuggestionsConnection) obj;
        GraphQLFaceBoxTagSuggestionsConnectionDeserializer.m4875a(graphQLFaceBoxTagSuggestionsConnection.w_(), graphQLFaceBoxTagSuggestionsConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFaceBoxTagSuggestionsConnection.class, new GraphQLFaceBoxTagSuggestionsConnection$Serializer());
        FbSerializerProvider.a(GraphQLFaceBoxTagSuggestionsConnection.class, new GraphQLFaceBoxTagSuggestionsConnection$Serializer());
    }
}
