package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: parent_kid */
public class GraphQLEventTimeRangeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventTimeRange.class, new GraphQLEventTimeRangeDeserializer());
    }

    public GraphQLEventTimeRangeDeserializer() {
        a(GraphQLEventTimeRange.class);
    }

    public Object m7301a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventTimeRange__JsonHelper.m7303a(jsonParser);
    }
}
