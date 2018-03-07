package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: nativeName */
public class GraphQLRelevantReactorsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLRelevantReactorsConnection.class, new GraphQLRelevantReactorsConnectionDeserializer());
    }

    public GraphQLRelevantReactorsConnectionDeserializer() {
        a(GraphQLRelevantReactorsConnection.class);
    }

    public Object m21386a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLRelevantReactorsConnection__JsonHelper.m21388a(jsonParser);
    }
}
