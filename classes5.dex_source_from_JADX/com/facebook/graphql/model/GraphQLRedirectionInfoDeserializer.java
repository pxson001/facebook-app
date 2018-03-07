package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: native_action_name */
public class GraphQLRedirectionInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLRedirectionInfo.class, new GraphQLRedirectionInfoDeserializer());
    }

    public GraphQLRedirectionInfoDeserializer() {
        a(GraphQLRedirectionInfo.class);
    }

    public Object m21379a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLRedirectionInfo__JsonHelper.m21381a(jsonParser);
    }
}
