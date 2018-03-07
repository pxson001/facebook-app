package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pages_profile_groups_tab */
public class GraphQLExternalUrlDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLExternalUrl.class, new GraphQLExternalUrlDeserializer());
    }

    public GraphQLExternalUrlDeserializer() {
        a(GraphQLExternalUrl.class);
    }

    public Object m7427a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLExternalUrl__JsonHelper.m7429a(jsonParser);
    }
}
