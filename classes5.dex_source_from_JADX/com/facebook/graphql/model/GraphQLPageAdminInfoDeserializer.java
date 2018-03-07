package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: obfuscatedIdentifier */
public class GraphQLPageAdminInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageAdminInfo.class, new GraphQLPageAdminInfoDeserializer());
    }

    public GraphQLPageAdminInfoDeserializer() {
        a(GraphQLPageAdminInfo.class);
    }

    public Object m9465a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPageAdminInfo__JsonHelper.m9467a(jsonParser);
    }
}
