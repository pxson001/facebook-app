package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Unknown pointer size */
public class GraphQLSportsDataMatchToFactsConnectionSerializer extends JsonSerializer<GraphQLSportsDataMatchToFactsConnection> {
    public final void m21796a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSportsDataMatchToFactsConnection__JsonHelper.m21798a(jsonGenerator, (GraphQLSportsDataMatchToFactsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSportsDataMatchToFactsConnection.class, new GraphQLSportsDataMatchToFactsConnectionSerializer());
    }
}
