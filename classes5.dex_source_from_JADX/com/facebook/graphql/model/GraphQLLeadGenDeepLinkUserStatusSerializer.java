package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feed_suggested_groups */
public class GraphQLLeadGenDeepLinkUserStatusSerializer extends JsonSerializer<GraphQLLeadGenDeepLinkUserStatus> {
    public final void m8826a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLeadGenDeepLinkUserStatus__JsonHelper.m8828a(jsonGenerator, (GraphQLLeadGenDeepLinkUserStatus) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLLeadGenDeepLinkUserStatus.class, new GraphQLLeadGenDeepLinkUserStatusSerializer());
    }
}
