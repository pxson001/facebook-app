package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friend_browser_wd */
public class GraphQLGroupMessageChattableMembersConnectionSerializer extends JsonSerializer<GraphQLGroupMessageChattableMembersConnection> {
    public final void m8474a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupMessageChattableMembersConnection__JsonHelper.m8476a(jsonGenerator, (GraphQLGroupMessageChattableMembersConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGroupMessageChattableMembersConnection.class, new GraphQLGroupMessageChattableMembersConnectionSerializer());
    }
}
