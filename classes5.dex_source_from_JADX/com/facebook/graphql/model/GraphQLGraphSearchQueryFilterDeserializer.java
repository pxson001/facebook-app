package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_admin_overview_promotions_card */
public class GraphQLGraphSearchQueryFilterDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchQueryFilter.class, new GraphQLGraphSearchQueryFilterDeserializer());
    }

    public GraphQLGraphSearchQueryFilterDeserializer() {
        a(GraphQLGraphSearchQueryFilter.class);
    }

    public Object m8225a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGraphSearchQueryFilter__JsonHelper.m8255a(jsonParser);
    }
}
