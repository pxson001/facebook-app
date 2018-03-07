package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIEWER_NOT_SUBSCRIBED */
public class GraphQLRatingSerializer extends JsonSerializer<GraphQLRating> {
    public final void m21309a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLRating__JsonHelper.m21311a(jsonGenerator, (GraphQLRating) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLRating.class, new GraphQLRatingSerializer());
    }
}
