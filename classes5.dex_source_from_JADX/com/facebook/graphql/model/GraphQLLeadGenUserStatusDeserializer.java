package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: open_graph_node */
public class GraphQLLeadGenUserStatusDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLeadGenUserStatus.class, new GraphQLLeadGenUserStatusDeserializer());
    }

    public GraphQLLeadGenUserStatusDeserializer() {
        a(GraphQLLeadGenUserStatus.class);
    }

    public Object m8906a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLLeadGenUserStatus__JsonHelper.m8908a(jsonParser);
    }
}
