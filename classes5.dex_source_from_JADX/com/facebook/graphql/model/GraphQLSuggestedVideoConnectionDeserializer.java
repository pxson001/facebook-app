package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_in_feed */
public class GraphQLSuggestedVideoConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSuggestedVideoConnection.class, new GraphQLSuggestedVideoConnectionDeserializer());
    }

    public GraphQLSuggestedVideoConnectionDeserializer() {
        a(GraphQLSuggestedVideoConnection.class);
    }

    public Object m22024a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSuggestedVideoConnection__JsonHelper.m22026a(jsonParser);
    }
}
