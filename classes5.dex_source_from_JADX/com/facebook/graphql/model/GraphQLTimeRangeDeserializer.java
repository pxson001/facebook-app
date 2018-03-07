package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_android_finch_profile */
public class GraphQLTimeRangeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimeRange.class, new GraphQLTimeRangeDeserializer());
    }

    public GraphQLTimeRangeDeserializer() {
        a(GraphQLTimeRange.class);
    }

    public Object m22112a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTimeRange__JsonHelper.m22114a(jsonParser);
    }
}
