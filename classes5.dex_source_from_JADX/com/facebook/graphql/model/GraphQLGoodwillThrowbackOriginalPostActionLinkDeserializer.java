package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_context_item */
public class GraphQLGoodwillThrowbackOriginalPostActionLinkDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackOriginalPostActionLink.class, new GraphQLGoodwillThrowbackOriginalPostActionLinkDeserializer());
    }

    public GraphQLGoodwillThrowbackOriginalPostActionLinkDeserializer() {
        a(GraphQLGoodwillThrowbackOriginalPostActionLink.class);
    }

    public Object m8058a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillThrowbackOriginalPostActionLink__JsonHelper.m8060a(jsonParser);
    }
}
