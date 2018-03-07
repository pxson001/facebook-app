package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: menu_item */
public class GraphQLWriteReviewActionLinkDeserializer extends FbJsonDeserializer {
    public Object m22545a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLWriteReviewActionLink graphQLWriteReviewActionLink = new GraphQLWriteReviewActionLink();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLWriteReviewActionLink = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLWriteReviewActionLink__JsonHelper.m22547a(graphQLWriteReviewActionLink, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLWriteReviewActionLink;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLWriteReviewActionLink.class, new GraphQLWriteReviewActionLinkDeserializer());
    }

    public GraphQLWriteReviewActionLinkDeserializer() {
        a(GraphQLWriteReviewActionLink.class);
    }
}
