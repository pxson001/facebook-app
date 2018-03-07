package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFeedbackContextDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: home_team_name */
public final class GraphQLFeedbackContext$Serializer extends JsonSerializer<GraphQLFeedbackContext> {
    public final void m7476a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedbackContext graphQLFeedbackContext = (GraphQLFeedbackContext) obj;
        GraphQLFeedbackContextDeserializer.m4891a(graphQLFeedbackContext.w_(), graphQLFeedbackContext.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLFeedbackContext.class, new GraphQLFeedbackContext$Serializer());
        FbSerializerProvider.a(GraphQLFeedbackContext.class, new GraphQLFeedbackContext$Serializer());
    }
}
