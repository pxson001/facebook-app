package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hi_res_theme_image */
public class GraphQLFeedbackSerializer extends JsonSerializer<GraphQLFeedback> {
    public final void m7508a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedback__JsonHelper.a(jsonGenerator, (GraphQLFeedback) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFeedback.class, new GraphQLFeedbackSerializer());
    }
}
