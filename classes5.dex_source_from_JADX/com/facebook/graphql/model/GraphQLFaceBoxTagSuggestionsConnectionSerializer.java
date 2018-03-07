package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hue_ */
public class GraphQLFaceBoxTagSuggestionsConnectionSerializer extends JsonSerializer<GraphQLFaceBoxTagSuggestionsConnection> {
    public final void m7439a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFaceBoxTagSuggestionsConnection__JsonHelper.m7441a(jsonGenerator, (GraphQLFaceBoxTagSuggestionsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFaceBoxTagSuggestionsConnection.class, new GraphQLFaceBoxTagSuggestionsConnectionSerializer());
    }
}
