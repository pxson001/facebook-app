package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: place_feed_thank_you_card_button */
public class GraphQLAllScheduledPostsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAllScheduledPostsConnection.class, new GraphQLAllScheduledPostsConnectionDeserializer());
    }

    public GraphQLAllScheduledPostsConnectionDeserializer() {
        a(GraphQLAllScheduledPostsConnection.class);
    }

    public Object m6526a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLAllScheduledPostsConnection__JsonHelper.m6528a(jsonParser);
    }
}
