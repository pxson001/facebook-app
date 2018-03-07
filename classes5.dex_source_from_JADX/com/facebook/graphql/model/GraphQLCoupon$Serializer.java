package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLCouponDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: isBackoutDraft */
public final class GraphQLCoupon$Serializer extends JsonSerializer<GraphQLCoupon> {
    public final void m6888a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCoupon graphQLCoupon = (GraphQLCoupon) obj;
        GraphQLCouponDeserializer.m4688a(graphQLCoupon.w_(), graphQLCoupon.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLCoupon.class, new GraphQLCoupon$Serializer());
        FbSerializerProvider.a(GraphQLCoupon.class, new GraphQLCoupon$Serializer());
    }
}
