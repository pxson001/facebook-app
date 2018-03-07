package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TimelineStoriesConnection */
public class GraphQLUserWorkExperiencesConnectionSerializer extends JsonSerializer<GraphQLUserWorkExperiencesConnection> {
    public final void m22404a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLUserWorkExperiencesConnection__JsonHelper.m22406a(jsonGenerator, (GraphQLUserWorkExperiencesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLUserWorkExperiencesConnection.class, new GraphQLUserWorkExperiencesConnectionSerializer());
    }
}
