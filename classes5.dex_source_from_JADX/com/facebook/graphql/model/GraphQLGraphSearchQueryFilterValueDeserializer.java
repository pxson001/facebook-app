package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_admin_overview_messages_card */
public class GraphQLGraphSearchQueryFilterValueDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchQueryFilterValue.class, new GraphQLGraphSearchQueryFilterValueDeserializer());
    }

    public GraphQLGraphSearchQueryFilterValueDeserializer() {
        a(GraphQLGraphSearchQueryFilterValue.class);
    }

    public Object m8245a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGraphSearchQueryFilterValue__JsonHelper.m8247a(jsonParser);
    }
}
