package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friend_count */
public class GraphQLGroupMembersConnectionSerializer extends JsonSerializer<GraphQLGroupMembersConnection> {
    public final void m8457a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupMembersConnection__JsonHelper.m8459a(jsonGenerator, (GraphQLGroupMembersConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupMembersConnection.class, new GraphQLGroupMembersConnectionSerializer());
    }
}
