package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: num_relative_layouts_in_listview_path */
public class GraphQLPageStoriesYouMissedFeedUnitStoriesEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageStoriesYouMissedFeedUnitStoriesEdge.class, new GraphQLPageStoriesYouMissedFeedUnitStoriesEdgeDeserializer());
    }

    public GraphQLPageStoriesYouMissedFeedUnitStoriesEdgeDeserializer() {
        a(GraphQLPageStoriesYouMissedFeedUnitStoriesEdge.class);
    }

    public Object m9542a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPageStoriesYouMissedFeedUnitStoriesEdge__JsonHelper.m9544a(jsonParser);
    }
}
