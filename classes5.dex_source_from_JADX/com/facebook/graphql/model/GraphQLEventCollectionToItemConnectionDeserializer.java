package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pb_other */
public class GraphQLEventCollectionToItemConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventCollectionToItemConnection.class, new GraphQLEventCollectionToItemConnectionDeserializer());
    }

    public GraphQLEventCollectionToItemConnectionDeserializer() {
        a(GraphQLEventCollectionToItemConnection.class);
    }

    public Object m7151a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEventCollectionToItemConnection__JsonHelper.m7153a(jsonParser);
    }
}
