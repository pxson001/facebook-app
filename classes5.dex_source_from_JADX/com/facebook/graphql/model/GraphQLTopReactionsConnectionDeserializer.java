package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: minutiae_suggestions */
public class GraphQLTopReactionsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTopReactionsConnection.class, new GraphQLTopReactionsConnectionDeserializer());
    }

    public GraphQLTopReactionsConnectionDeserializer() {
        a(GraphQLTopReactionsConnection.class);
    }

    public Object m22250a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTopReactionsConnection__JsonHelper.a(jsonParser);
    }
}
