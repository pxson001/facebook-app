package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLUserEducationExperiencesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Topic */
public final class GraphQLUserEducationExperiencesConnection$Serializer extends JsonSerializer<GraphQLUserEducationExperiencesConnection> {
    public final void m22386a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLUserEducationExperiencesConnection graphQLUserEducationExperiencesConnection = (GraphQLUserEducationExperiencesConnection) obj;
        GraphQLUserEducationExperiencesConnectionDeserializer.m6155a(graphQLUserEducationExperiencesConnection.w_(), graphQLUserEducationExperiencesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLUserEducationExperiencesConnection.class, new GraphQLUserEducationExperiencesConnection$Serializer());
        FbSerializerProvider.a(GraphQLUserEducationExperiencesConnection.class, new GraphQLUserEducationExperiencesConnection$Serializer());
    }
}
