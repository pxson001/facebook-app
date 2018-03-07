package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: install_messenger_jewel_promo */
public class GraphQLEventCategoryDataSerializer extends JsonSerializer<GraphQLEventCategoryData> {
    public final void m7121a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventCategoryData__JsonHelper.m7123a(jsonGenerator, (GraphQLEventCategoryData) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEventCategoryData.class, new GraphQLEventCategoryDataSerializer());
    }
}
