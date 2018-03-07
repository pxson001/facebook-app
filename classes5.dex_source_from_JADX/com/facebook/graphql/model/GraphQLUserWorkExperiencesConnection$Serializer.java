package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLUserWorkExperiencesConnectionDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TimezoneInfo */
public final class GraphQLUserWorkExperiencesConnection$Serializer extends JsonSerializer<GraphQLUserWorkExperiencesConnection> {
    public final void m22402a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLUserWorkExperiencesConnection graphQLUserWorkExperiencesConnection = (GraphQLUserWorkExperiencesConnection) obj;
        GraphQLUserWorkExperiencesConnectionDeserializer.m6161a(graphQLUserWorkExperiencesConnection.w_(), graphQLUserWorkExperiencesConnection.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLUserWorkExperiencesConnection.class, new GraphQLUserWorkExperiencesConnection$Serializer());
        FbSerializerProvider.a(GraphQLUserWorkExperiencesConnection.class, new GraphQLUserWorkExperiencesConnection$Serializer());
    }
}
