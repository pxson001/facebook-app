package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLLeadGenDeepLinkUserStatusDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feed_topic_content */
public final class GraphQLLeadGenDeepLinkUserStatus$Serializer extends JsonSerializer<GraphQLLeadGenDeepLinkUserStatus> {
    public final void m8824a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLeadGenDeepLinkUserStatus graphQLLeadGenDeepLinkUserStatus = (GraphQLLeadGenDeepLinkUserStatus) obj;
        GraphQLLeadGenDeepLinkUserStatusDeserializer.m5288a(graphQLLeadGenDeepLinkUserStatus.w_(), graphQLLeadGenDeepLinkUserStatus.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLLeadGenDeepLinkUserStatus.class, new GraphQLLeadGenDeepLinkUserStatus$Serializer());
        FbSerializerProvider.a(GraphQLLeadGenDeepLinkUserStatus.class, new GraphQLLeadGenDeepLinkUserStatus$Serializer());
    }
}
