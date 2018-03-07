package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: msite_page_action_menu_suggest_edits */
public class GraphQLSinglePublisherVideoChannelsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLSinglePublisherVideoChannelsEdge.class, new GraphQLSinglePublisherVideoChannelsEdgeDeserializer());
    }

    public GraphQLSinglePublisherVideoChannelsEdgeDeserializer() {
        a(GraphQLSinglePublisherVideoChannelsEdge.class);
    }

    public Object m21669a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLSinglePublisherVideoChannelsEdge__JsonHelper.m21671a(jsonParser);
    }
}
