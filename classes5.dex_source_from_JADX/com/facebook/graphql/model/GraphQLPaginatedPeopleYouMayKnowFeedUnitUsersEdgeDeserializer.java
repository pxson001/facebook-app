package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: not equal */
public class GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.class, new GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdgeDeserializer());
    }

    public GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdgeDeserializer() {
        a(GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge.class);
    }

    public Object m20627a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPaginatedPeopleYouMayKnowFeedUnitUsersEdge__JsonHelper.m20629a(jsonParser);
    }
}
