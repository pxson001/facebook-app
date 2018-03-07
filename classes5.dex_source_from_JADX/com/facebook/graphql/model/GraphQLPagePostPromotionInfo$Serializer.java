package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPagePostPromotionInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: enable_ranked_replies */
public final class GraphQLPagePostPromotionInfo$Serializer extends JsonSerializer<GraphQLPagePostPromotionInfo> {
    public final void m9510a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPagePostPromotionInfo graphQLPagePostPromotionInfo = (GraphQLPagePostPromotionInfo) obj;
        GraphQLPagePostPromotionInfoDeserializer.m5520a(graphQLPagePostPromotionInfo.w_(), graphQLPagePostPromotionInfo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPagePostPromotionInfo.class, new GraphQLPagePostPromotionInfo$Serializer());
        FbSerializerProvider.a(GraphQLPagePostPromotionInfo.class, new GraphQLPagePostPromotionInfo$Serializer());
    }
}
