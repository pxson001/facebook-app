package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feed */
public class GraphQLLikedProfilesConnectionSerializer extends JsonSerializer<GraphQLLikedProfilesConnection> {
    public final void m8913a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLikedProfilesConnection__JsonHelper.m8915a(jsonGenerator, (GraphQLLikedProfilesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLLikedProfilesConnection.class, new GraphQLLikedProfilesConnectionSerializer());
    }
}
