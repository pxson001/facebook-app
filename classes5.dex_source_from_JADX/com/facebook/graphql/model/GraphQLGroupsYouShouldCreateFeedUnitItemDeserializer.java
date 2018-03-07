package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: otherClicks */
public class GraphQLGroupsYouShouldCreateFeedUnitItemDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGroupsYouShouldCreateFeedUnitItem.class, new GraphQLGroupsYouShouldCreateFeedUnitItemDeserializer());
    }

    public GraphQLGroupsYouShouldCreateFeedUnitItemDeserializer() {
        a(GraphQLGroupsYouShouldCreateFeedUnitItem.class);
    }

    public Object m8537a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLGroupsYouShouldCreateFeedUnitItem__JsonHelper.m8539a(jsonParser);
    }
}
