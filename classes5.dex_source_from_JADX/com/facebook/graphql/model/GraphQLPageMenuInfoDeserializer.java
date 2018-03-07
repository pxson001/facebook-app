package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: nuxLabel */
public class GraphQLPageMenuInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageMenuInfo.class, new GraphQLPageMenuInfoDeserializer());
    }

    public GraphQLPageMenuInfoDeserializer() {
        a(GraphQLPageMenuInfo.class);
    }

    public Object m9498a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPageMenuInfo__JsonHelper.m9500a(jsonParser);
    }
}
