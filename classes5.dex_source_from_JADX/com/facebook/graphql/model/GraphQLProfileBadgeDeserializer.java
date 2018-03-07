package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: neighborhood_name */
public class GraphQLProfileBadgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLProfileBadge.class, new GraphQLProfileBadgeDeserializer());
    }

    public GraphQLProfileBadgeDeserializer() {
        a(GraphQLProfileBadge.class);
    }

    public Object m21100a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLProfileBadge__JsonHelper.m21102a(jsonParser);
    }
}
