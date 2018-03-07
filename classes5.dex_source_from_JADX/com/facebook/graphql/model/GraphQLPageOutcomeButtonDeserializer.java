package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: nux */
public class GraphQLPageOutcomeButtonDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageOutcomeButton.class, new GraphQLPageOutcomeButtonDeserializer());
    }

    public GraphQLPageOutcomeButtonDeserializer() {
        a(GraphQLPageOutcomeButton.class);
    }

    public Object m9504a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPageOutcomeButton__JsonHelper.m9506a(jsonParser);
    }
}
