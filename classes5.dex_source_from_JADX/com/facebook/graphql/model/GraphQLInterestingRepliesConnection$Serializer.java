package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLInterestingRepliesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feedback_subscribe */
public final class GraphQLInterestingRepliesConnection$Serializer extends JsonSerializer<GraphQLInterestingRepliesConnection> {
    public final void m8748a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInterestingRepliesConnection graphQLInterestingRepliesConnection = (GraphQLInterestingRepliesConnection) obj;
        GraphQLInterestingRepliesConnectionDeserializer.m5276a(graphQLInterestingRepliesConnection.w_(), graphQLInterestingRepliesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLInterestingRepliesConnection.class, new GraphQLInterestingRepliesConnection$Serializer());
        FbSerializerProvider.a(GraphQLInterestingRepliesConnection.class, new GraphQLInterestingRepliesConnection$Serializer());
    }
}
