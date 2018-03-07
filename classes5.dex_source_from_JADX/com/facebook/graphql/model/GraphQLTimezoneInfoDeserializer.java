package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: misc_info */
public class GraphQLTimezoneInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimezoneInfo.class, new GraphQLTimezoneInfoDeserializer());
    }

    public GraphQLTimezoneInfoDeserializer() {
        a(GraphQLTimezoneInfo.class);
    }

    public Object m22236a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTimezoneInfo__JsonHelper.m22238a(jsonParser);
    }
}
