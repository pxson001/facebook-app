package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFeedbackReactionInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: history */
public final class GraphQLFeedbackReactionInfo$Serializer extends JsonSerializer<GraphQLFeedbackReactionInfo> {
    public final void m7488a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedbackReactionInfo graphQLFeedbackReactionInfo = (GraphQLFeedbackReactionInfo) obj;
        GraphQLFeedbackReactionInfoDeserializer.m4903a(graphQLFeedbackReactionInfo.w_(), graphQLFeedbackReactionInfo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFeedbackReactionInfo.class, new GraphQLFeedbackReactionInfo$Serializer());
        FbSerializerProvider.a(GraphQLFeedbackReactionInfo.class, new GraphQLFeedbackReactionInfo$Serializer());
    }
}
