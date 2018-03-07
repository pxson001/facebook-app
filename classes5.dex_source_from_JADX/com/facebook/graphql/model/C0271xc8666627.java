package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_viewer_business_manager_admin */
public class C0271xc8666627 extends JsonSerializer<GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection> {
    public final void m6579a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        C0272xa537f5eb.m6581a(jsonGenerator, (GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.class, new C0271xc8666627());
    }
}
