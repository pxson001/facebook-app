package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fb4a_group_profile_upsell */
public class GraphQLMediaQuestionOptionSerializer extends JsonSerializer<GraphQLMediaQuestionOption> {
    public final void m9042a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLMediaQuestionOption__JsonHelper.m9044a(jsonGenerator, (GraphQLMediaQuestionOption) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLMediaQuestionOption.class, new GraphQLMediaQuestionOptionSerializer());
    }
}
