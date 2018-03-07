package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TYPE_MATCH_CHECK */
public class GraphQLWorkExperienceSerializer extends JsonSerializer<GraphQLWorkExperience> {
    public final void m22532a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLWorkExperience__JsonHelper.m22534a(jsonGenerator, (GraphQLWorkExperience) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLWorkExperience.class, new GraphQLWorkExperienceSerializer());
    }
}
