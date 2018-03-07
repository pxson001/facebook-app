package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_admin_overview_marketwatch_card */
public class GraphQLGraphSearchQueryFilterValuesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchQueryFilterValuesConnection.class, new GraphQLGraphSearchQueryFilterValuesConnectionDeserializer());
    }

    public GraphQLGraphSearchQueryFilterValuesConnectionDeserializer() {
        a(GraphQLGraphSearchQueryFilterValuesConnection.class);
    }

    public Object m8251a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGraphSearchQueryFilterValuesConnection__JsonHelper.m8253a(jsonParser);
    }
}
