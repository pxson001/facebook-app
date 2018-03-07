package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_android_post_checkin */
public class GraphQLTemporalEventInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTemporalEventInfo.class, new GraphQLTemporalEventInfoDeserializer());
    }

    public GraphQLTemporalEventInfoDeserializer() {
        a(GraphQLTemporalEventInfo.class);
    }

    public Object m22101a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTemporalEventInfo__JsonHelper.m22103a(jsonParser);
    }
}
