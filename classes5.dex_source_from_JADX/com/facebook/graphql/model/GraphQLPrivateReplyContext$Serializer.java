package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPrivateReplyContextDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Value returned by 'any-getter' ( */
public final class GraphQLPrivateReplyContext$Serializer extends JsonSerializer<GraphQLPrivateReplyContext> {
    public final void m21036a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPrivateReplyContext graphQLPrivateReplyContext = (GraphQLPrivateReplyContext) obj;
        GraphQLPrivateReplyContextDeserializer.m5710a(graphQLPrivateReplyContext.w_(), graphQLPrivateReplyContext.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPrivateReplyContext.class, new GraphQLPrivateReplyContext$Serializer());
        FbSerializerProvider.a(GraphQLPrivateReplyContext.class, new GraphQLPrivateReplyContext$Serializer());
    }
}
