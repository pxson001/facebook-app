package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: graph_search_chevron_incorrect_location */
public class GraphQLGoodwillHappyBirthdayStoriesConnectionSerializer extends JsonSerializer<GraphQLGoodwillHappyBirthdayStoriesConnection> {
    public final void m7897a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGoodwillHappyBirthdayStoriesConnection__JsonHelper.m7899a(jsonGenerator, (GraphQLGoodwillHappyBirthdayStoriesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGoodwillHappyBirthdayStoriesConnection.class, new GraphQLGoodwillHappyBirthdayStoriesConnectionSerializer());
    }
}
