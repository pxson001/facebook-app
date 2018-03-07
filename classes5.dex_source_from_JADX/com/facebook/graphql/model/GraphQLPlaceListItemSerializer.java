package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WEBSITE_DUPLICATE_REPORT */
public class GraphQLPlaceListItemSerializer extends JsonSerializer<GraphQLPlaceListItem> {
    public final void m20861a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPlaceListItem__JsonHelper.m20873a(jsonGenerator, (GraphQLPlaceListItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPlaceListItem.class, new GraphQLPlaceListItemSerializer());
    }
}
