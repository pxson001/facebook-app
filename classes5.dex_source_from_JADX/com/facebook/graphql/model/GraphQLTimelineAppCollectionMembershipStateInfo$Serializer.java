package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTimelineAppCollectionMembershipStateInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNKNOWN_ERR */
public final class GraphQLTimelineAppCollectionMembershipStateInfo$Serializer extends JsonSerializer<GraphQLTimelineAppCollectionMembershipStateInfo> {
    public final void m22154a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimelineAppCollectionMembershipStateInfo graphQLTimelineAppCollectionMembershipStateInfo = (GraphQLTimelineAppCollectionMembershipStateInfo) obj;
        GraphQLTimelineAppCollectionMembershipStateInfoDeserializer.m6076a(graphQLTimelineAppCollectionMembershipStateInfo.w_(), graphQLTimelineAppCollectionMembershipStateInfo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLTimelineAppCollectionMembershipStateInfo.class, new GraphQLTimelineAppCollectionMembershipStateInfo$Serializer());
        FbSerializerProvider.a(GraphQLTimelineAppCollectionMembershipStateInfo.class, new GraphQLTimelineAppCollectionMembershipStateInfo$Serializer());
    }
}
