package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLCouponDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: isBackoutDraft */
public class GraphQLCoupon$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCoupon.class, new GraphQLCoupon$Deserializer());
    }

    public Object m6887a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLCouponDeserializer.m4687a(jsonParser, (short) 77);
        Object graphQLCoupon = new GraphQLCoupon();
        ((BaseModel) graphQLCoupon).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLCoupon instanceof Postprocessable) {
            return ((Postprocessable) graphQLCoupon).a();
        }
        return graphQLCoupon;
    }
}
