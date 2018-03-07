package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: historical-record */
public class GraphQLFeedbackReactionSerializer extends JsonSerializer<GraphQLFeedbackReaction> {
    public final void m7491a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedbackReaction__JsonHelper.a(jsonGenerator, (GraphQLFeedbackReaction) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFeedbackReaction.class, new GraphQLFeedbackReactionSerializer());
    }
}
