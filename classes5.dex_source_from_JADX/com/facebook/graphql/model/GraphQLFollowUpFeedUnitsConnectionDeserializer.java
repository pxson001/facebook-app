package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: page_setting_mobile */
public class GraphQLFollowUpFeedUnitsConnectionDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFollowUpFeedUnitsConnection.class, new GraphQLFollowUpFeedUnitsConnectionDeserializer());
    }

    public GraphQLFollowUpFeedUnitsConnectionDeserializer() {
        a(GraphQLFollowUpFeedUnitsConnection.class);
    }

    public Object m7530a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLFollowUpFeedUnitsConnection__JsonHelper.m7532a(jsonParser);
    }
}
