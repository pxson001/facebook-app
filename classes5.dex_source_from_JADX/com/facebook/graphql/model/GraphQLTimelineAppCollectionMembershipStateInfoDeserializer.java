package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: mobile_android */
public class GraphQLTimelineAppCollectionMembershipStateInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimelineAppCollectionMembershipStateInfo.class, new GraphQLTimelineAppCollectionMembershipStateInfoDeserializer());
    }

    public GraphQLTimelineAppCollectionMembershipStateInfoDeserializer() {
        a(GraphQLTimelineAppCollectionMembershipStateInfo.class);
    }

    public Object m22155a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLTimelineAppCollectionMembershipStateInfo__JsonHelper.m22157a(jsonParser);
    }
}
