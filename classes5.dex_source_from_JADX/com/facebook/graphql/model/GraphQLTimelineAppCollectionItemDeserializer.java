package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_android_composer_edit */
public class GraphQLTimelineAppCollectionItemDeserializer extends FbJsonDeserializer {
    public Object m22149a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLTimelineAppCollectionItem graphQLTimelineAppCollectionItem = new GraphQLTimelineAppCollectionItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLTimelineAppCollectionItem = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                GraphQLTimelineAppCollectionItem__JsonHelper.m22151a(graphQLTimelineAppCollectionItem, i, jsonParser);
                jsonParser.f();
            }
        }
        return graphQLTimelineAppCollectionItem;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimelineAppCollectionItem.class, new GraphQLTimelineAppCollectionItemDeserializer());
    }

    public GraphQLTimelineAppCollectionItemDeserializer() {
        a(GraphQLTimelineAppCollectionItem.class);
    }
}
