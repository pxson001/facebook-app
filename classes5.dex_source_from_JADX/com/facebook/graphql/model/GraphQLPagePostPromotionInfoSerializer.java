package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: enable_private_reply */
public class GraphQLPagePostPromotionInfoSerializer extends JsonSerializer<GraphQLPagePostPromotionInfo> {
    public final void m9512a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPagePostPromotionInfo__JsonHelper.m9514a(jsonGenerator, (GraphQLPagePostPromotionInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPagePostPromotionInfo.class, new GraphQLPagePostPromotionInfoSerializer());
    }
}
