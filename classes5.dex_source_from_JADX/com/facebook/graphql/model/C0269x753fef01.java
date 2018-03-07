package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.C0239xb10bb428;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_viewer_newly_added */
public final class C0269x753fef01 extends JsonSerializer<GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection> {
    public final void m6577a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection = (GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection) obj;
        C0239xb10bb428.m4578a(graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.w_(), graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.class, new C0269x753fef01());
        FbSerializerProvider.a(GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.class, new C0269x753fef01());
    }
}
