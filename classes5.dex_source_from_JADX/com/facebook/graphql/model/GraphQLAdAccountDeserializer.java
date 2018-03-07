package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_report_dialog */
public class GraphQLAdAccountDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAdAccount.class, new GraphQLAdAccountDeserializer());
    }

    public GraphQLAdAccountDeserializer() {
        a(GraphQLAdAccount.class);
    }

    public Object m6425a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAdAccount__JsonHelper.m6427a(jsonParser);
    }
}
