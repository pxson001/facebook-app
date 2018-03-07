package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFeedbackReactionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hoisted_story_ids */
public final class GraphQLFeedbackReaction$Serializer extends JsonSerializer<GraphQLFeedbackReaction> {
    public final void m7484a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedbackReaction graphQLFeedbackReaction = (GraphQLFeedbackReaction) obj;
        GraphQLFeedbackReactionDeserializer.m4898a(graphQLFeedbackReaction.w_(), graphQLFeedbackReaction.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLFeedbackReaction.class, new GraphQLFeedbackReaction$Serializer());
        FbSerializerProvider.a(GraphQLFeedbackReaction.class, new GraphQLFeedbackReaction$Serializer());
    }
}
