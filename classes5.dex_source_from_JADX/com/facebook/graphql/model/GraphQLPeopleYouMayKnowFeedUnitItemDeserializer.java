package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: no_feed_polling */
public class GraphQLPeopleYouMayKnowFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPeopleYouMayKnowFeedUnitItem.class, new GraphQLPeopleYouMayKnowFeedUnitItemDeserializer());
    }

    public GraphQLPeopleYouMayKnowFeedUnitItemDeserializer() {
        a(GraphQLPeopleYouMayKnowFeedUnitItem.class);
    }

    public Object m20684a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPeopleYouMayKnowFeedUnitItem__JsonHelper.m20686a(jsonParser);
    }
}
