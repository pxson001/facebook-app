package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: pending_claims_count */
public class GraphQLEntityCardContextItemLinkDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEntityCardContextItemLink.class, new GraphQLEntityCardContextItemLinkDeserializer());
    }

    public GraphQLEntityCardContextItemLinkDeserializer() {
        a(GraphQLEntityCardContextItemLink.class);
    }

    public Object m7078a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLEntityCardContextItemLink__JsonHelper.m7080a(jsonParser);
    }
}
