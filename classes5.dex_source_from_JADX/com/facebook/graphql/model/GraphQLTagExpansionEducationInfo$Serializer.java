package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLTagExpansionEducationInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNSUPPORTED_CATEGORY */
public final class GraphQLTagExpansionEducationInfo$Serializer extends JsonSerializer<GraphQLTagExpansionEducationInfo> {
    public final void m22033a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTagExpansionEducationInfo graphQLTagExpansionEducationInfo = (GraphQLTagExpansionEducationInfo) obj;
        GraphQLTagExpansionEducationInfoDeserializer.m6028a(graphQLTagExpansionEducationInfo.w_(), graphQLTagExpansionEducationInfo.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLTagExpansionEducationInfo.class, new GraphQLTagExpansionEducationInfo$Serializer());
        FbSerializerProvider.a(GraphQLTagExpansionEducationInfo.class, new GraphQLTagExpansionEducationInfo$Serializer());
    }
}
