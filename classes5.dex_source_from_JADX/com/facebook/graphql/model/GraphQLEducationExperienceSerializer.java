package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ios_feather_suggest_edits_upsell */
public class GraphQLEducationExperienceSerializer extends JsonSerializer<GraphQLEducationExperience> {
    public final void m6982a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEducationExperience__JsonHelper.m6984a(jsonGenerator, (GraphQLEducationExperience) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLEducationExperience.class, new GraphQLEducationExperienceSerializer());
    }
}
