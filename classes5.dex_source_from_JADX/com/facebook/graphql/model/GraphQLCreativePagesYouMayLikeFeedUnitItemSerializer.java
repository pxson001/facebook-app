package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is-autoselect */
public class GraphQLCreativePagesYouMayLikeFeedUnitItemSerializer extends JsonSerializer<GraphQLCreativePagesYouMayLikeFeedUnitItem> {
    public final void m6899a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCreativePagesYouMayLikeFeedUnitItem__JsonHelper.m6901a(jsonGenerator, (GraphQLCreativePagesYouMayLikeFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLCreativePagesYouMayLikeFeedUnitItem.class, new GraphQLCreativePagesYouMayLikeFeedUnitItemSerializer());
    }
}
