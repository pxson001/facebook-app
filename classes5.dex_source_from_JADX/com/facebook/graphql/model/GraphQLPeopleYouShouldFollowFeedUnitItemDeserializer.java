package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: noLink */
public class GraphQLPeopleYouShouldFollowFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPeopleYouShouldFollowFeedUnitItem.class, new GraphQLPeopleYouShouldFollowFeedUnitItemDeserializer());
    }

    public GraphQLPeopleYouShouldFollowFeedUnitItemDeserializer() {
        a(GraphQLPeopleYouShouldFollowFeedUnitItem.class);
    }

    public Object m20703a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPeopleYouShouldFollowFeedUnitItem__JsonHelper.m20705a(jsonParser);
    }
}
