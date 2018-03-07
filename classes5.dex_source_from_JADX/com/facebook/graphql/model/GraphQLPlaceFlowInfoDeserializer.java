package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: new_likers_count */
public class GraphQLPlaceFlowInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPlaceFlowInfo.class, new GraphQLPlaceFlowInfoDeserializer());
    }

    public GraphQLPlaceFlowInfoDeserializer() {
        a(GraphQLPlaceFlowInfo.class);
    }

    public Object m20845a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLPlaceFlowInfo__JsonHelper.m20847a(jsonParser);
    }
}
