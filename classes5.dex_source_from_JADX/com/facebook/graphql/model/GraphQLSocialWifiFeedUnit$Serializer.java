package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLSocialWifiFeedUnitDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UserEducationExperiencesEdge */
public final class GraphQLSocialWifiFeedUnit$Serializer extends JsonSerializer<GraphQLSocialWifiFeedUnit> {
    public final void m21674a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSocialWifiFeedUnit graphQLSocialWifiFeedUnit = (GraphQLSocialWifiFeedUnit) obj;
        GraphQLSocialWifiFeedUnitDeserializer.m5897a(graphQLSocialWifiFeedUnit.w_(), graphQLSocialWifiFeedUnit.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLSocialWifiFeedUnit.class, new GraphQLSocialWifiFeedUnit$Serializer());
        FbSerializerProvider.a(GraphQLSocialWifiFeedUnit.class, new GraphQLSocialWifiFeedUnit$Serializer());
    }
}
