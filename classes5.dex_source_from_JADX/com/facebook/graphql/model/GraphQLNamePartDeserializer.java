package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: og_music */
public class GraphQLNamePartDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNamePart.class, new GraphQLNamePartDeserializer());
    }

    public GraphQLNamePartDeserializer() {
        a(GraphQLNamePart.class);
    }

    public Object m9153a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLNamePart__JsonHelper.a(jsonParser);
    }
}
