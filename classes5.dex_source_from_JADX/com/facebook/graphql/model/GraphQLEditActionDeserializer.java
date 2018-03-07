package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: permalink_context_row */
public class GraphQLEditActionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEditAction.class, new GraphQLEditActionDeserializer());
    }

    public GraphQLEditActionDeserializer() {
        a(GraphQLEditAction.class);
    }

    public Object m6958a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEditAction__JsonHelper.m6960a(jsonParser);
    }
}
