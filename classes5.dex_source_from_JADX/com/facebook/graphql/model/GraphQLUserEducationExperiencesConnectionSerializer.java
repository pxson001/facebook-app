package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TopReactionsEdge */
public class GraphQLUserEducationExperiencesConnectionSerializer extends JsonSerializer<GraphQLUserEducationExperiencesConnection> {
    public final void m22388a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLUserEducationExperiencesConnection__JsonHelper.m22390a(jsonGenerator, (GraphQLUserEducationExperiencesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLUserEducationExperiencesConnection.class, new GraphQLUserEducationExperiencesConnectionSerializer());
    }
}
