package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: expected =  */
public class GraphQLNegativeFeedbackActionSerializer extends JsonSerializer<GraphQLNegativeFeedbackAction> {
    public final void m9235a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNegativeFeedbackAction__JsonHelper.m9237a(jsonGenerator, (GraphQLNegativeFeedbackAction) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLNegativeFeedbackAction.class, new GraphQLNegativeFeedbackActionSerializer());
    }
}
