package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VOTING_ACTIONS */
public class GraphQLPrivateReplyContextSerializer extends JsonSerializer<GraphQLPrivateReplyContext> {
    public final void m21038a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivateReplyContext__JsonHelper.m21040a(jsonGenerator, (GraphQLPrivateReplyContext) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivateReplyContext.class, new GraphQLPrivateReplyContextSerializer());
    }
}
