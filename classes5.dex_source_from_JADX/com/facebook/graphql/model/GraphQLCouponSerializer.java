package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: isAttachmentReadOnly */
public class GraphQLCouponSerializer extends JsonSerializer<GraphQLCoupon> {
    public final void m6890a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCoupon__JsonHelper.m6892a(jsonGenerator, (GraphQLCoupon) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLCoupon.class, new GraphQLCouponSerializer());
    }
}
