package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: home_team_market */
public class GraphQLFeedbackContextSerializer extends JsonSerializer<GraphQLFeedbackContext> {
    public final void m7478a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedbackContext__JsonHelper.m7480a(jsonGenerator, (GraphQLFeedbackContext) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFeedbackContext.class, new GraphQLFeedbackContextSerializer());
    }
}
