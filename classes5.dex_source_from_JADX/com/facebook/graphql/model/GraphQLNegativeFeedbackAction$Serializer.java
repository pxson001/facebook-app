package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLNegativeFeedbackActionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: expected closing END_ARRAY after type information and deserialized value */
public final class GraphQLNegativeFeedbackAction$Serializer extends JsonSerializer<GraphQLNegativeFeedbackAction> {
    public final void m9233a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNegativeFeedbackAction graphQLNegativeFeedbackAction = (GraphQLNegativeFeedbackAction) obj;
        GraphQLNegativeFeedbackActionDeserializer.m5414a(graphQLNegativeFeedbackAction.w_(), graphQLNegativeFeedbackAction.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLNegativeFeedbackAction.class, new GraphQLNegativeFeedbackAction$Serializer());
        FbSerializerProvider.a(GraphQLNegativeFeedbackAction.class, new GraphQLNegativeFeedbackAction$Serializer());
    }
}
