package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTimelineAppCollectionMembershipStateInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UNKNOWN_ERR */
public class GraphQLTimelineAppCollectionMembershipStateInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTimelineAppCollectionMembershipStateInfo.class, new GraphQLTimelineAppCollectionMembershipStateInfo$Deserializer());
    }

    public Object m22153a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTimelineAppCollectionMembershipStateInfoDeserializer.m6075a(jsonParser, (short) 161);
        Object graphQLTimelineAppCollectionMembershipStateInfo = new GraphQLTimelineAppCollectionMembershipStateInfo();
        ((BaseModel) graphQLTimelineAppCollectionMembershipStateInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTimelineAppCollectionMembershipStateInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLTimelineAppCollectionMembershipStateInfo).a();
        }
        return graphQLTimelineAppCollectionMembershipStateInfo;
    }
}
