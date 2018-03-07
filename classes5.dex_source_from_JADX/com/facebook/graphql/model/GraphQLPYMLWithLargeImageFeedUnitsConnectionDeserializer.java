package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: object_tool_native_language */
public class GraphQLPYMLWithLargeImageFeedUnitsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPYMLWithLargeImageFeedUnitsConnection.class, new GraphQLPYMLWithLargeImageFeedUnitsConnectionDeserializer());
    }

    public GraphQLPYMLWithLargeImageFeedUnitsConnectionDeserializer() {
        a(GraphQLPYMLWithLargeImageFeedUnitsConnection.class);
    }

    public Object m9450a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPYMLWithLargeImageFeedUnitsConnection__JsonHelper.m9452a(jsonParser);
    }
}
