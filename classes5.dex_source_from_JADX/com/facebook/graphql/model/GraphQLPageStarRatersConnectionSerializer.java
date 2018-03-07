package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: enable_comment_replies_most_recent */
public class GraphQLPageStarRatersConnectionSerializer extends JsonSerializer<GraphQLPageStarRatersConnection> {
    public final void m9520a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageStarRatersConnection__JsonHelper.m9522a(jsonGenerator, (GraphQLPageStarRatersConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPageStarRatersConnection.class, new GraphQLPageStarRatersConnectionSerializer());
    }
}
