package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_setting */
public class GraphQLFollowUpFeedUnitsEdgeDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFollowUpFeedUnitsEdge.class, new GraphQLFollowUpFeedUnitsEdgeDeserializer());
    }

    public GraphQLFollowUpFeedUnitsEdgeDeserializer() {
        a(GraphQLFollowUpFeedUnitsEdge.class);
    }

    public Object m7540a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFollowUpFeedUnitsEdge__JsonHelper.m7542a(jsonParser);
    }
}
