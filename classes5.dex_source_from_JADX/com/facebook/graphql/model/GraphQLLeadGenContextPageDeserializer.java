package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: optin_decline_title */
public class GraphQLLeadGenContextPageDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLeadGenContextPage.class, new GraphQLLeadGenContextPageDeserializer());
    }

    public GraphQLLeadGenContextPageDeserializer() {
        a(GraphQLLeadGenContextPage.class);
    }

    public Object m8812a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLLeadGenContextPage__JsonHelper.m8814a(jsonParser);
    }
}
