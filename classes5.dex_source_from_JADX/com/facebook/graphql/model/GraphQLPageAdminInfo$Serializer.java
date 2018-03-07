package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLPageAdminInfoDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: entity_with_image */
public final class GraphQLPageAdminInfo$Serializer extends JsonSerializer<GraphQLPageAdminInfo> {
    public final void m9464a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPageAdminInfo graphQLPageAdminInfo = (GraphQLPageAdminInfo) obj;
        GraphQLPageAdminInfoDeserializer.m5494a(graphQLPageAdminInfo.w_(), graphQLPageAdminInfo.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(GraphQLPageAdminInfo.class, new GraphQLPageAdminInfo$Serializer());
        FbSerializerProvider.a(GraphQLPageAdminInfo.class, new GraphQLPageAdminInfo$Serializer());
    }
}
