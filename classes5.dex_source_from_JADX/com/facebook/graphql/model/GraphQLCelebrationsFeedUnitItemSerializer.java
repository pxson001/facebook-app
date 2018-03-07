package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_dismissible */
public class GraphQLCelebrationsFeedUnitItemSerializer extends JsonSerializer<GraphQLCelebrationsFeedUnitItem> {
    public final void m6754a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCelebrationsFeedUnitItem__JsonHelper.m6756a(jsonGenerator, (GraphQLCelebrationsFeedUnitItem) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLCelebrationsFeedUnitItem.class, new GraphQLCelebrationsFeedUnitItemSerializer());
    }
}
