package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_approved */
public class GraphQLCommentPlaceInfoToPlaceListItemsConnectionSerializer extends JsonSerializer<GraphQLCommentPlaceInfoToPlaceListItemsConnection> {
    public final void m6809a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCommentPlaceInfoToPlaceListItemsConnection__JsonHelper.m6811a(jsonGenerator, (GraphQLCommentPlaceInfoToPlaceListItemsConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLCommentPlaceInfoToPlaceListItemsConnection.class, new GraphQLCommentPlaceInfoToPlaceListItemsConnectionSerializer());
    }
}
