package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: organic_reach */
public class GraphQLImportantReactorsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLImportantReactorsConnection.class, new GraphQLImportantReactorsConnectionDeserializer());
    }

    public GraphQLImportantReactorsConnectionDeserializer() {
        a(GraphQLImportantReactorsConnection.class);
    }

    public Object m8637a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLImportantReactorsConnection__JsonHelper.a(jsonParser);
    }
}
