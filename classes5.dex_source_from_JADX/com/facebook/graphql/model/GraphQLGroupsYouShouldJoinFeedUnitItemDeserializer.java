package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: original_rotation */
public class GraphQLGroupsYouShouldJoinFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupsYouShouldJoinFeedUnitItem.class, new GraphQLGroupsYouShouldJoinFeedUnitItemDeserializer());
    }

    public GraphQLGroupsYouShouldJoinFeedUnitItemDeserializer() {
        a(GraphQLGroupsYouShouldJoinFeedUnitItem.class);
    }

    public Object m8554a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGroupsYouShouldJoinFeedUnitItem__JsonHelper.m8556a(jsonParser);
    }
}
