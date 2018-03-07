package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VERTICAL_COMPONENT_LIST_INNER_CARD_W_AUX_ACTION */
public class GraphQLSavedCollectionFeedUnitItemSerializer extends JsonSerializer<GraphQLSavedCollectionFeedUnitItem> {
    public final void m21547a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSavedCollectionFeedUnitItem__JsonHelper.m21549a(jsonGenerator, (GraphQLSavedCollectionFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLSavedCollectionFeedUnitItem.class, new GraphQLSavedCollectionFeedUnitItemSerializer());
    }
}
