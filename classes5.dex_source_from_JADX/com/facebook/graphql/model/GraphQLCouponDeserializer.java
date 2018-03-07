package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photoForLauncherShortcut */
public class GraphQLCouponDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCoupon.class, new GraphQLCouponDeserializer());
    }

    public GraphQLCouponDeserializer() {
        a(GraphQLCoupon.class);
    }

    public Object m6889a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLCoupon__JsonHelper.m6891a(jsonParser);
    }
}
