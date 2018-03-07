package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: parent_page_id */
public class GraphQLEventTicketProviderDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventTicketProvider.class, new GraphQLEventTicketProviderDeserializer());
    }

    public GraphQLEventTicketProviderDeserializer() {
        a(GraphQLEventTicketProvider.class);
    }

    public Object m7295a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventTicketProvider__JsonHelper.m7297a(jsonParser);
    }
}
