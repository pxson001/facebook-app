package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: historical-records */
public class GraphQLFeedbackReactionInfoSerializer extends JsonSerializer<GraphQLFeedbackReactionInfo> {
    public final void m7490a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedbackReactionInfo__JsonHelper.a(jsonGenerator, (GraphQLFeedbackReactionInfo) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFeedbackReactionInfo.class, new GraphQLFeedbackReactionInfoSerializer());
    }
}
