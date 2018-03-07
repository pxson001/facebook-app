package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: object */
public class GraphQLPYMLWithLargeImageFeedUnitsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPYMLWithLargeImageFeedUnitsEdge.class, new GraphQLPYMLWithLargeImageFeedUnitsEdgeDeserializer());
    }

    public GraphQLPYMLWithLargeImageFeedUnitsEdgeDeserializer() {
        a(GraphQLPYMLWithLargeImageFeedUnitsEdge.class);
    }

    public Object m9456a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPYMLWithLargeImageFeedUnitsEdge__JsonHelper.m9458a(jsonParser);
    }
}
