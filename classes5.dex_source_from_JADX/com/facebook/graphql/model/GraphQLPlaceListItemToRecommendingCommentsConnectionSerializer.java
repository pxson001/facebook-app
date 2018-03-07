package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WEBSITE */
public class GraphQLPlaceListItemToRecommendingCommentsConnectionSerializer extends JsonSerializer<GraphQLPlaceListItemToRecommendingCommentsConnection> {
    public final void m20869a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlaceListItemToRecommendingCommentsConnection__JsonHelper.m20871a(jsonGenerator, (GraphQLPlaceListItemToRecommendingCommentsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPlaceListItemToRecommendingCommentsConnection.class, new GraphQLPlaceListItemToRecommendingCommentsConnectionSerializer());
    }
}
