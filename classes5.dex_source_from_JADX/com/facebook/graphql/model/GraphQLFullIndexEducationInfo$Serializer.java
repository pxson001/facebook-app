package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLFullIndexEducationInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: gyscItems */
public final class GraphQLFullIndexEducationInfo$Serializer extends JsonSerializer<GraphQLFullIndexEducationInfo> {
    public final void m7659a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFullIndexEducationInfo graphQLFullIndexEducationInfo = (GraphQLFullIndexEducationInfo) obj;
        GraphQLFullIndexEducationInfoDeserializer.m4971a(graphQLFullIndexEducationInfo.w_(), graphQLFullIndexEducationInfo.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLFullIndexEducationInfo.class, new GraphQLFullIndexEducationInfo$Serializer());
        FbSerializerProvider.a(GraphQLFullIndexEducationInfo.class, new GraphQLFullIndexEducationInfo$Serializer());
    }
}
