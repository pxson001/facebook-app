package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNKNOWN_ADD_A_CATEGORY */
public class GraphQLTimelineAppCollectionMembershipStateInfoSerializer extends JsonSerializer<GraphQLTimelineAppCollectionMembershipStateInfo> {
    public final void m22156a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimelineAppCollectionMembershipStateInfo__JsonHelper.m22158a(jsonGenerator, (GraphQLTimelineAppCollectionMembershipStateInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTimelineAppCollectionMembershipStateInfo.class, new GraphQLTimelineAppCollectionMembershipStateInfoSerializer());
    }
}
