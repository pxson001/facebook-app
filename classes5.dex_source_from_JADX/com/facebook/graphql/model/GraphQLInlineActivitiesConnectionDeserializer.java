package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: order_payment_method */
public class GraphQLInlineActivitiesConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInlineActivitiesConnection.class, new GraphQLInlineActivitiesConnectionDeserializer());
    }

    public GraphQLInlineActivitiesConnectionDeserializer() {
        a(GraphQLInlineActivitiesConnection.class);
    }

    public Object m8687a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLInlineActivitiesConnection__JsonHelper.m8689a(jsonParser);
    }
}
