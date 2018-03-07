package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_browser_chaining */
public class GraphQLGoodwillThrowbackSectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackSection.class, new GraphQLGoodwillThrowbackSectionDeserializer());
    }

    public GraphQLGoodwillThrowbackSectionDeserializer() {
        a(GraphQLGoodwillThrowbackSection.class);
    }

    public Object m8114a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGoodwillThrowbackSection__JsonHelper.m8116a(jsonParser);
    }
}
