package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_outcome_button */
public class GraphQLFundraiserPageDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFundraiserPage.class, new GraphQLFundraiserPageDeserializer());
    }

    public GraphQLFundraiserPageDeserializer() {
        a(GraphQLFundraiserPage.class);
    }

    public Object m7680a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFundraiserPage__JsonHelper.m7682a(jsonParser);
    }
}
