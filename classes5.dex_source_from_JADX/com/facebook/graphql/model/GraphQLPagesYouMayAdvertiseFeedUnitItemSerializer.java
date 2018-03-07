package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: element_video */
public class GraphQLPagesYouMayAdvertiseFeedUnitItemSerializer extends JsonSerializer<GraphQLPagesYouMayAdvertiseFeedUnitItem> {
    public final void m9569a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPagesYouMayAdvertiseFeedUnitItem__JsonHelper.m9571a(jsonGenerator, (GraphQLPagesYouMayAdvertiseFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPagesYouMayAdvertiseFeedUnitItem.class, new GraphQLPagesYouMayAdvertiseFeedUnitItemSerializer());
    }
}
