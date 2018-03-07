package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLLeadGenUserStatusDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feed_chaining */
public final class GraphQLLeadGenUserStatus$Serializer extends JsonSerializer<GraphQLLeadGenUserStatus> {
    public final void m8905a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLeadGenUserStatus graphQLLeadGenUserStatus = (GraphQLLeadGenUserStatus) obj;
        GraphQLLeadGenUserStatusDeserializer.m5314a(graphQLLeadGenUserStatus.w_(), graphQLLeadGenUserStatus.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLLeadGenUserStatus.class, new GraphQLLeadGenUserStatus$Serializer());
        FbSerializerProvider.a(GraphQLLeadGenUserStatus.class, new GraphQLLeadGenUserStatus$Serializer());
    }
}
